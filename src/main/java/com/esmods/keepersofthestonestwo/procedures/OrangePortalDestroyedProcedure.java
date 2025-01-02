package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class OrangePortalDestroyedProcedure {
	public static void execute(LevelAccessor world) {
		PowerModVariables.MapVariables.get(world).orange_portal_placed = false;
		PowerModVariables.MapVariables.get(world).syncData(world);
	}
}
