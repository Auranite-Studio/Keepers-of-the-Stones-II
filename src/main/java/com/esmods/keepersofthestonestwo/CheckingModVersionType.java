package com.esmods.keepersofthestonestwo;

import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.IModInfo;

import java.util.List;
import java.util.regex.Pattern;

public class CheckingModVersionType {

	public enum VersionType {
		RELEASE,
		PRE_RELEASE,
		RELEASE_CANDIDATE,
		BETA,
		CUSTOM_SUFFIX,
		UNKNOWN
	}

	public static VersionType get() {
		String version = "";
		List<IModInfo> mods = ModList.get().getMods();

		for (IModInfo mod : mods) {
			if (mod.getModId().equals("power")) {
				version = mod.getVersion().toString();
				break;
			}
		}

		if (version.isEmpty()) {
			return VersionType.UNKNOWN;
		}

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
		}

		return VersionType.UNKNOWN;
	}

	public record VersionChannel() {

		public static boolean isInDevelopment() {
			VersionType type = get();
			return type == VersionType.BETA
					|| type == VersionType.PRE_RELEASE
					|| type == VersionType.RELEASE_CANDIDATE;
		}
	}
}