package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

import java.util.Comparator;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;

@EventBusSubscriber
public class LevelExpGetProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (PowerConfigConfiguration.ENABLE_LEVELS.get() == true) {
			if (sourceentity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
				if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level < 20) {
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
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
									{
										PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
										_vars.level_exp = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).level_exp + 50;
										_vars.syncPlayerVariables(entityiterator);
									}
								}
							}
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
}