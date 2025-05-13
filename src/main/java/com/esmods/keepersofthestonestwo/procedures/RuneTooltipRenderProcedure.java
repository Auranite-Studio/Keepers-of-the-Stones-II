package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.network.chat.Component;

public class RuneTooltipRenderProcedure {
	public static String execute() {
		return Component.translatable("gui.power.wheel_abilities.tooltip.rune_not_install").getString();
	}
}
