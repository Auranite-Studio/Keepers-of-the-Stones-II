package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.network.chat.Component;

public class HeatBatteryDescProcedure {
	public static String execute() {
		return "\u00A7c\u00A7o" + Component.translatable("battery.desc.heat").getString();
	}
}
