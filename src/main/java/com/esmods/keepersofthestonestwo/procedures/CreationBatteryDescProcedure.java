package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.network.chat.Component;

public class CreationBatteryDescProcedure {
	public static String execute() {
		return "\u00A7f\u00A7o" + Component.translatable("battery.desc.creation").getString();
	}
}
