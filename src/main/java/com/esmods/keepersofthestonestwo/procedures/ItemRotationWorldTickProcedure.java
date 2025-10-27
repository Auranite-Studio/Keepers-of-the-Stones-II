package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

@EventBusSubscriber
public class ItemRotationWorldTickProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		PowerModVariables.WorldVariables.get(world).entity_rotation = PowerModVariables.WorldVariables.get(world).entity_rotation < 360 ? PowerModVariables.WorldVariables.get(world).entity_rotation + 8 : 0;
		PowerModVariables.WorldVariables.get(world).markSyncDirty();
	}
}