package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.fml.ModList;

import java.util.List;

public class ModVersionDebugProcedure {
	public static String execute() {
		return "mod_version: " + new Object() {
			String getModInfo(String modid, int type) {
				String val = "";
				List<IModInfo> mods = ModList.get().getMods();
				for (IModInfo mod : mods) {
					if (mod.getModId().equals(modid.toLowerCase())) {
						if (type == 0) {
							val = mod.getVersion().toString();
						} else {
							val = mod.getDisplayName();
						}
						break;
					}
				}
				return val;
			}
		}.getModInfo("power", 0);
	}
}