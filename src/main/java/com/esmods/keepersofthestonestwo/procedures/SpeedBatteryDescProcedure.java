package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.network.chat.Component;

public class SpeedBatteryDescProcedure {
	public static String execute() {
		return "\u00A7b\u00A7o" + Component.translatable("battery.desc.speed").getString();
	}
}
