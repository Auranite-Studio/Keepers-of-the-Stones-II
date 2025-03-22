package com.esmods.keepersofthestonestwo.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;

@Mod.EventBusSubscriber
public class CursedKeepersFirstPhaseImmuneProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
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
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
