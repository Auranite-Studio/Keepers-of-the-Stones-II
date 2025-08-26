package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

@EventBusSubscriber
public class MistInvisibleTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).abilities_timer > 0) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.abilities_timer = entity.getData(PowerModVariables.PLAYER_VARIABLES).abilities_timer - 1;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).ability_using) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, entity.getData(PowerModVariables.PLAYER_VARIABLES).helmet);
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, entity.getData(PowerModVariables.PLAYER_VARIABLES).chestplate);
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, entity.getData(PowerModVariables.PLAYER_VARIABLES).leggings);
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, entity.getData(PowerModVariables.PLAYER_VARIABLES).boots);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.ability_using = false;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}