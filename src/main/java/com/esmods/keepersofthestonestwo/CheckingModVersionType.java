package com.esmods.keepersofthestonestwo;

import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.IModInfo;

import java.util.List;
import java.util.regex.Pattern;

    @Deprecated(since = "release", forRemoval = true)
public class CheckingModVersionType {

	public static boolean get() {
		String version = "";
		List<IModInfo> mods = ModList.get().getMods();

		for (IModInfo mod : mods) {
			if (mod.getModId().equals("power")) {
				version = mod.getVersion().toString();
				break;
			}
		}

		if (version.isEmpty()) {
			return false;
		}

		String preReleasePattern = "^\\d+\\.\\d+\\.\\d+-pre\\d+$";
		String releaseCandidatePattern = "^\\d+\\.\\d+\\.\\d+-rc\\d+$";
		String betaPattern = "^\\d+\\.\\d+\\.\\d+\\.\\d+$";

		String[] patterns = {
				preReleasePattern,
				releaseCandidatePattern,
				betaPattern
		};
		for (String pattern : patterns) {
			if (Pattern.matches(pattern, version)) {
				return true;
			}
		}

		return false;
	}
}
