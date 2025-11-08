package com.esmods.keepersofthestonestwo;

import com.google.gson.*;
import net.minecraft.network.chat.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.neoforged.neoforgespi.language.IModInfo;

import javax.annotation.Nullable;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

@EventBusSubscriber
public class ModVersionManager {

	private static final String PROJECT_ID = "keepers-of-the-stones-2";
	private static final String MINECRAFT_VERSION = getMinecraftVersion();
	private static final String CURRENT_VERSION = getCurrentVersion();

	static class Version implements Comparable<Version> {
		private final String raw;
		private final int[] parts;

		public Version(String version) {
			this.raw = version;
			this.parts = parseVersion(version);
		}

		private static int[] parseVersion(String v) {
			String clean = v.contains("-") ? v.substring(0, v.indexOf('-')) : v;
			String[] split = clean.split("\\.");
			int[] result = new int[Math.min(split.length, 3)]; // Только major.minor.patch
			for (int i = 0; i < result.length; i++) {
				try {
					result[i] = Integer.parseInt(split[i]);
				} catch (NumberFormatException e) {
					result[i] = 0;
				}
			}
			return result;
		}

		@Override
		public int compareTo(Version o) {
			int len = Math.max(this.parts.length, o.parts.length);
			for (int i = 0; i < len; i++) {
				int a = i < this.parts.length ? this.parts[i] : 0;
				int b = i < o.parts.length ? o.parts[i] : 0;
				if (a != b) {
					return Integer.compare(a, b);
				}
			}
			return 0;
		}

		@Override
		public String toString() {
			return raw;
		}
	}

	private static VersionType getVersionType(String version) {
		if (version == null || version.isEmpty()) return VersionType.UNKNOWN;
		if (Pattern.matches("^\\d+\\.\\d+\\.\\d+$", version)) {
			return VersionType.RELEASE;
		}
		return VersionType.OTHER;
	}

	enum VersionType {
		RELEASE, OTHER, UNKNOWN
	}

	public static void checkForUpdates(ServerPlayer player) {
 		if (getVersionType(CURRENT_VERSION) != VersionType.RELEASE) {
			return;
		}

		try {
			List<VersionData> allVersions = fetchVersionsFromModrinth();
			if (allVersions.isEmpty()) {
				System.out.println("Couldn't get a list of versions.");
				return;
			}

			Version current = new Version(CURRENT_VERSION);
			Version latestRelease = null;

			for (VersionData data : allVersions) {
				if (!isMinecraftVersionSupported(data.gameVersions)) continue;

				// Рассматриваем ТОЛЬКО RELEASE-версии (x.x.x)
				if (getVersionType(data.versionNumber) != VersionType.RELEASE) {
					continue;
				}

				Version candidate = new Version(data.versionNumber);
				if (candidate.compareTo(current) > 0) {
					if (latestRelease == null || candidate.compareTo(latestRelease) > 0) {
						latestRelease = candidate;
					}
				}
			}

			if (latestRelease == null) {
				System.out.println("No newer RELEASE version found.");
				return;
			}

			String changelog = getVersionChangelog(allVersions, latestRelease.toString());
			sendUpdateMessage(player, latestRelease, changelog);
			System.out.println("Newer RELEASE version found: " + latestRelease);
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
										"https://modrinth.com/project/" + PROJECT_ID
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
				.filter(v -> isMinecraftVersionSupported(v.gameVersions))
				.map(v -> v.changelog != null ? v.changelog : "")
				.findFirst()
				.orElse("Changelog not available for your Minecraft version.");
	}

	private static List<VersionData> fetchVersionsFromModrinth() throws IOException {
		URL url = new URL("https://api.modrinth.com/v2/project/" + PROJECT_ID + "/version");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("User-Agent", "KeepersOfTheStonesII/UpdateChecker");

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

	private static String getCurrentVersion() {
		for (IModInfo mod : ModList.get().getMods()) {
			if ("power".equals(mod.getModId())) {
				return mod.getVersion().toString();
			}
		}
		return "0.0.0";
	}

	private static String getMinecraftVersion() {
		for (IModInfo mod : ModList.get().getMods()) {
			if ("minecraft".equals(mod.getModId())) {
				return mod.getVersion().toString();
			}
		}
		return "0.0.0";
	}

	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerLoggedInEvent event) {
		executeCheckForUpdates(event, event.getEntity());
		executeBetaWarning(event, event.getEntity());
	}

	private static void executeCheckForUpdates(@Nullable Event event, Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			checkForUpdates(serverPlayer);
		}
	}

	private static void executeBetaWarning(@Nullable Event event, Entity entity) {
		if (entity instanceof Player player) {
			if (getVersionType(CURRENT_VERSION) != VersionType.RELEASE) {
				player.displayClientMessage(
						Component.translatable("power.modupdater.beta_detect"),
						false
				);
			}
		}
	}
}