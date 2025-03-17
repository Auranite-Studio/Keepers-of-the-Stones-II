package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.network.chat.Component;

public class ColorsBatteryDescProcedure {
	public static String execute() {
		return "\u00A7d\u00A7f" + Component.translatable("battery.desc.colors").getString();
	}
}
