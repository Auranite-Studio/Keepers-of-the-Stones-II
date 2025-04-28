package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.client.Minecraft;

public class BetaVersionOverlayIsGUINotHiddingProcedure {
	public static boolean execute() {
		return !Minecraft.getInstance().options.hideGui;
	}
}
