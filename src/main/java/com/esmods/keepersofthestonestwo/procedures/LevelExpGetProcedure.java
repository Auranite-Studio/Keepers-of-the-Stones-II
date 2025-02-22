package com.esmods.keepersofthestonestwo.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

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

import java.util.List;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;

@Mod.EventBusSubscriber
public class LevelExpGetProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
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
			if ((sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).active_power) {
				if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).level < 20) {
					if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("power:xp/1")))) {
						{
							double _setval = (sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).level_exp + 1;
							sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.level_exp = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("power:xp/2")))) {
						{
							double _setval = (sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).level_exp + 2;
							sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.level_exp = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("power:xp/3")))) {
						{
							double _setval = (sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).level_exp + 3;
							sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.level_exp = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("power:xp/5")))) {
						{
							double _setval = (sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).level_exp + 5;
							sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.level_exp = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("power:xp/50")))) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
									{
										double _setval = (entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).level_exp + 50;
										entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.level_exp = _setval;
											capability.syncPlayerVariables(entityiterator);
										});
									}
								}
							}
						}
					} else if (entity instanceof Player || entity instanceof ServerPlayer) {
						if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).active_power) {
							{
								double _setval = (sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).level_exp
										+ Math.round((sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).level_exp * 0.25);
								sourceentity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.level_exp = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					}
				}
			}
		}
	}
}
