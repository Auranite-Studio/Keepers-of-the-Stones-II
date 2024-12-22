package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

@EventBusSubscriber
public class LevelExpGetProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
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
		if (sourceentity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("power:standart_exp")))) {
				{
					PowerModVariables.PlayerVariables _vars = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.level_exp = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp + 1;
					_vars.syncPlayerVariables(sourceentity);
				}
			} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("power:golden_rank_exp")))) {
				{
					PowerModVariables.PlayerVariables _vars = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.level_exp = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp + 3;
					_vars.syncPlayerVariables(sourceentity);
				}
			} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("power:boss_exp")))) {
				{
					PowerModVariables.PlayerVariables _vars = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.level_exp = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp + 50;
					_vars.syncPlayerVariables(sourceentity);
				}
			} else if (entity instanceof Player || entity instanceof ServerPlayer) {
				if (entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
					{
						PowerModVariables.PlayerVariables _vars = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.level_exp = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp + Math.round(sourceentity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp * 0.25);
						_vars.syncPlayerVariables(sourceentity);
					}
				}
			}
		}
	}
}
