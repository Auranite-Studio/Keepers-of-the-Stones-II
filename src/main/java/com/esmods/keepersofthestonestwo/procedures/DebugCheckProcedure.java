package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class DebugCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(PowerModVariables.PLAYER_VARIABLES).debug && !Minecraft.getInstance().options.hideGui;
	}
}