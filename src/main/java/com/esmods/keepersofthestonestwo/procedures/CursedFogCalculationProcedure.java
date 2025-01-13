package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

@EventBusSubscriber
public class CursedFogCalculationProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.isUnderWater() && !(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(PowerModMobEffects.MIST))) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("power:cursed_biomes")))) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.cursed_fog = true;
					_vars.syncPlayerVariables(entity);
				}
				if (entity.getData(PowerModVariables.PLAYER_VARIABLES).fog_distance > 10) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fog_distance = entity.getData(PowerModVariables.PLAYER_VARIABLES).fog_distance - 10;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else {
				if (entity.getData(PowerModVariables.PLAYER_VARIABLES).fog_distance < 1000) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fog_distance = entity.getData(PowerModVariables.PLAYER_VARIABLES).fog_distance + 10;
						_vars.syncPlayerVariables(entity);
					}
				}
				if (entity.getData(PowerModVariables.PLAYER_VARIABLES).fog_distance >= 999) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.cursed_fog = true;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
	}
}
