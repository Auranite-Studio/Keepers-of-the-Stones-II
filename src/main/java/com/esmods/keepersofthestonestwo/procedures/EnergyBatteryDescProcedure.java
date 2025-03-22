package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.network.chat.Component;

public class EnergyBatteryDescProcedure {
	public static String execute() {
		return "\u00A7e\u00A7o" + Component.translatable("battery.desc.energy").getString();
	}
}
