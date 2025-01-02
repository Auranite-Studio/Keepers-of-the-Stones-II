package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.network.chat.Component;

public class PoisonBatteryDescProcedure {
	public static String execute() {
		return "\u00A7a\u00A7o" + Component.translatable("battery.desc.poison").getString();
	}
}
