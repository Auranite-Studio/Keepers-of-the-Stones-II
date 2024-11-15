package com.esmods.keepersofthestonestwo.procedures;

import net.minecraftforge.forgespi.language.IModInfo;
import net.minecraftforge.fml.ModList;

import java.util.List;

public class CPAPIVersionDebugProcedure {
	public static String execute() {
		return "cpapi_version: v" + new Object() {
			String getValue(String modid) {
				String val = "";
				List<IModInfo> mods = ModList.get().getMods();
				for (IModInfo mod : mods) {
					if (mod.getModId().equals(modid.toLowerCase())) {
						val = mod.getVersion().toString();
						break;
					}
				}
				return val;
			}
		}.getValue("cpapi");
	}
}
