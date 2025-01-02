package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.network.chat.Component;

public class AirBatteryDescProcedure {
	public static String execute() {
		return "\u00A7b\u00A7o" + Component.translatable("battery.desc.air").getString();
	}
}
