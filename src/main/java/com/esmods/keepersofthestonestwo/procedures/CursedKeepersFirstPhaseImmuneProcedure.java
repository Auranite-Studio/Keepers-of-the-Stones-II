package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;

@EventBusSubscriber
public class CursedKeepersFirstPhaseImmuneProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof CursedKeeperEntity && (!entity.getPersistentData().getBoolean("Phase") || entity.getPersistentData().getDouble("windShield") > 0) && (sourceentity instanceof ServerPlayer || sourceentity instanceof Player)) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
		}
	}
}
