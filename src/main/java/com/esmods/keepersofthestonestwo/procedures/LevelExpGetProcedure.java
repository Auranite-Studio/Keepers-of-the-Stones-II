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
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;

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
		if (PowerConfigConfiguration.ENABLE_LEVELS.get() == true) {
			if (sourceentity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
				if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("power:xp/1")))) {
					{
						PowerModVariables.PlayerVariables _vars = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.level_exp = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp + 1;
						_vars.syncPlayerVariables(sourceentity);
					}
				} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("power:xp/2")))) {
					{
						PowerModVariables.PlayerVariables _vars = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.level_exp = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp + 2;
						_vars.syncPlayerVariables(sourceentity);
					}
				} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("power:xp/3")))) {
					{
						PowerModVariables.PlayerVariables _vars = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.level_exp = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp + 3;
						_vars.syncPlayerVariables(sourceentity);
					}
				} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("power:xp/5")))) {
					{
						PowerModVariables.PlayerVariables _vars = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.level_exp = sourceentity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp + 5;
						_vars.syncPlayerVariables(sourceentity);
					}
				} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("power:xp/50")))) {
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
}
