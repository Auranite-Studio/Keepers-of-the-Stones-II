package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.network.chat.Component;

public class EmptyBatteryDescProcedure {
	public static String execute() {
		return "\u00A77\u00A7o" + Component.translatable("battery.desc.empty").getString();
	}
}
