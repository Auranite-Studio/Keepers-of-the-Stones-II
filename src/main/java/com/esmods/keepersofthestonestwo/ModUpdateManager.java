package com.esmods.keepersofthestonestwo;

import com.google.gson.*;
import net.minecraft.network.chat.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;

import javax.annotation.Nullable;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;
import java.util.Map;

@EventBusSubscriber
public class ModUpdateManager {

	// === UpdateChecker Fields and Methods ===
	private static final String PROJECT_ID = "keepers-of-the-stones-2";
	private static final String MINECRAFT_VERSION = getMinecraftVersion();
	private static final String CURRENT_VERSION = getCurrentVersion();

	private static final Map<VersionType, Integer> VERSION_PRIORITY = Map.of(
			VersionType.RELEASE, 0,
			VersionType.RELEASE_CANDIDATE, 1,
			VersionType.PRE_RELEASE, 2,
			VersionType.BETA, 3,
			VersionType.CUSTOM_SUFFIX, 4,
			VersionType.UNKNOWN, 5
	);

	public static void checkForUpdates(ServerPlayer player) {
		try {
			List<VersionData> versions = fetchVersionsFromModrinth();
			if (versions.isEmpty()) {
				System.out.println("Couldn't get a list of versions.");
				return;
			}
			Version current = new Version(CURRENT_VERSION, getVersionType(CURRENT_VERSION));
			Version latest = null;
			for (VersionData data : versions) {
				if (!isMinecraftVersionSupported(data.gameVersions)) continue;
				VersionType type = getVersionType(data.versionNumber);
				Version version = new Version(data.versionNumber, type);
				if (current.type == VersionType.RELEASE && version.type != VersionType.RELEASE) {
					continue;
				}
				if (version.compareTo(current) > 0) {
					if (latest == null || version.compareTo(latest) > 0) {
						latest = version;
					}
				}
			}
			if (latest == null || latest.compareTo(current) <= 0) {
				System.out.println("There are no updates.");
				return;
			}
			String changelog = getVersionChangelog(versions, latest.toString());
			sendUpdateMessage(player, latest, changelog);
			System.out.println("A newer version has been found: " + latest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean isMinecraftVersionSupported(List<String> gameVersions) {
		return gameVersions.contains(MINECRAFT_VERSION);
	}

	private static void sendUpdateMessage(ServerPlayer player, Version latest, String changelog) {
		MutableComponent message = Component.translatable("power.modupdater.new_release")
				.withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x00FFAA)))
				.append(Component.literal(latest.toString())
						.withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xFFFF55))))
				.append(Component.translatable("power.modupdater.click_event")
						.withStyle(Style.EMPTY
								.withColor(TextColor.fromRgb(0xAAAAAA))
								.withUnderlined(true)
								.withClickEvent(new ClickEvent(
										ClickEvent.Action.OPEN_URL,
										"https://modrinth.com/project/keepers-of-the-stones-2"
								))
								.withHoverEvent(new HoverEvent(
										HoverEvent.Action.SHOW_TEXT,
										Component.literal("\nWhat's new:\n" + changelog)
								))
						)
				);
		player.sendSystemMessage(message);
	}

	private static String getVersionChangelog(List<VersionData> allVersions, String version) {
		return allVersions.stream()
				.filter(v -> v.versionNumber.equals(version))
				.map(v -> v.changelog)
				.findFirst()
				.orElse("");
	}

	private static List<VersionData> fetchVersionsFromModrinth() throws IOException {
		URL url = new URL("https://api.modrinth.com/v2/project/"  + PROJECT_ID + "/version");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		StringBuilder response = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
		}
		return parseVersionsFromJson(response.toString());
	}

	private static List<VersionData> parseVersionsFromJson(String json) {
		JsonArray array = JsonParser.parseString(json).getAsJsonArray();
		List<VersionData> result = new ArrayList<>();
		for (JsonElement element : array) {
			JsonObject obj = element.getAsJsonObject();
			String versionNumber = obj.get("version_number").getAsString();
			String changelog = obj.has("changelog") ? obj.get("changelog").getAsString() : "";
			JsonArray gameVersionsArray = obj.getAsJsonArray("game_versions");
			List<String> gameVersions = new ArrayList<>();
			for (JsonElement el : gameVersionsArray) {
				gameVersions.add(el.getAsString());
			}
			result.add(new VersionData(versionNumber, changelog, gameVersions));
		}
		return result;
	}

	record VersionData(String versionNumber, String changelog, List<String> gameVersions) {}

	static class Version implements Comparable<Version> {
		private final String raw;
		private final VersionType type;

		public Version(String version, VersionType type) {
			this.raw = version;
			this.type = type;
		}

		@Override
		public int compareTo(Version o) {
			int priorityThis = VERSION_PRIORITY.getOrDefault(this.type, 999);
			int priorityOther = VERSION_PRIORITY.getOrDefault(o.type, 999);
			if (priorityThis != priorityOther) {
				return Integer.compare(priorityThis, priorityOther);
			}
			return compareVersionStrings(this.raw, o.raw);
		}

		private int compareVersionStrings(String v1, String v2) {
			String[] parts1 = v1.split("\\.");
			String[] parts2 = v2.split("\\.");
			int length = Math.max(parts1.length, parts2.length);
			for (int i = 0; i < length; i++) {
				int num1 = i < parts1.length ? parseInt(parts1[i]) : 0;
				int num2 = i < parts2.length ? parseInt(parts2[i]) : 0;
				if (num1 != num2) {
					return Integer.compare(num1, num2);
				}
			}
			return 0;
		}

		private int parseInt(String s) {
			try {
				return Integer.parseInt(s.replaceAll("\\D+", ""));
			} catch (NumberFormatException ignored) {
				return 0;
			}
		}

		public VersionType getVersionType() {
			return type;
		}

		@Override
		public String toString() {
			return raw;
		}
	}

	enum VersionType {
		RELEASE,
		PRE_RELEASE,
		RELEASE_CANDIDATE,
		BETA,
		CUSTOM_SUFFIX,
		UNKNOWN
	}

	private static VersionType getVersionType(String version) {
		if (Pattern.matches("^\\d+\\.\\d+\\.\\d+$", version)) {
			return VersionType.RELEASE;
		} else if (Pattern.matches("^\\d+\\.\\d+\\.\\d+-pre\\d+$", version)) {
			return VersionType.PRE_RELEASE;
		} else if (Pattern.matches("^\\d+\\.\\d+\\.\\d+-rc\\d+$", version)) {
			return VersionType.RELEASE_CANDIDATE;
		} else if (Pattern.matches("^\\d+\\.\\d+\\.\\d+\\.\\d+$", version)) {
			return VersionType.BETA;
		} else if (Pattern.matches("^\\d+\\.\\d+\\.\\d+-[a-zA-Z0-9]+.*$", version)) {
			return VersionType.CUSTOM_SUFFIX;
		} else {
			return VersionType.UNKNOWN;
		}
	}

	private static String getCurrentVersion() {
		List<IModInfo> mods = ModList.get().getMods();
		for (IModInfo mod : mods) {
			if (mod.getModId().equals("power")) {
				return mod.getVersion().toString();
			}
		}
		return "0.0.0";
	}

	private static String getMinecraftVersion() {
		List<IModInfo> mods = ModList.get().getMods();
		for (IModInfo mod : mods) {
			if (mod.getModId().equals("minecraft")) {
				return mod.getVersion().toString();
			}
		}
		return "0.0.0";
	}

	// === Beta Warning Procedure ===

	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null) return;
		if (entity instanceof Player) {
			checkForUpdates((ServerPlayer) entity);
		}
	}

	// === Beta Warning Method ===
	@SubscribeEvent
	public static void onPlayerLogin_BetaWarning(PlayerLoggedInEvent event) {
		executeBetaWarning(event, event.getEntity());
	}

	public static void executeBetaWarning(Entity entity) {
		executeBetaWarning(null, entity);
	}

	private static void executeBetaWarning(@Nullable Event event, Entity entity) {
		if (entity == null) return;
		if (isInDevelopment()) {
			if (entity instanceof Player _player && !_player.level().isClientSide()) {
				_player.displayClientMessage(Component.literal(Component.translatable("chat.power.versioncheckwarn").getString()), false);
			}
		}
	}

	// === isInDevelopment logic ===
	public static boolean isInDevelopment() {
		VersionType type = getVersionType(getCurrentVersion());
		return type == VersionType.BETA ||
				type == VersionType.PRE_RELEASE ||
				type == VersionType.RELEASE_CANDIDATE;
	}
}