package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.network.chat.Component;

public class MindBatteryDescProcedure {
	public static String execute() {
		return "\u00A7d\u00A7o" + Component.translatable("battery.desc.mind").getString();
	}
}
