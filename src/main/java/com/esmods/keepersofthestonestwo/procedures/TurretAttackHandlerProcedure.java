package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.entity.TurretEntity;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber
public class TurretAttackHandlerProcedure {
	@SubscribeEvent
	public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity sourceentity) {
		execute(null, world, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof TurretEntity) {
			if (sourceentity instanceof TurretEntity _datEntSetL)
				_datEntSetL.getEntityData().set(TurretEntity.DATA_is_attack, true);
			PowerMod.queueServerWork(23, () -> {
				if (sourceentity instanceof TurretEntity _datEntSetL)
					_datEntSetL.getEntityData().set(TurretEntity.DATA_is_attack, false);
			});
		}
	}
}
