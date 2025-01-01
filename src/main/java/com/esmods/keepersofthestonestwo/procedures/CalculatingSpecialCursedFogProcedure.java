package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

@EventBusSubscriber
public class CalculatingSpecialCursedFogProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("power:cursed_biomes")))) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.is_render_fog = true;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).start_fog == 100 && entity.getData(PowerModVariables.PLAYER_VARIABLES).end_fog == 150) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.is_render_fog = false;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).is_render_fog) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).start_fog > 15 && entity.getData(PowerModVariables.PLAYER_VARIABLES).end_fog > 45) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.start_fog = entity.getData(PowerModVariables.PLAYER_VARIABLES).start_fog - 1;
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.end_fog = entity.getData(PowerModVariables.PLAYER_VARIABLES).end_fog - 1;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).start_fog < 100 && entity.getData(PowerModVariables.PLAYER_VARIABLES).end_fog < 150) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.start_fog = entity.getData(PowerModVariables.PLAYER_VARIABLES).start_fog + 1;
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.end_fog = entity.getData(PowerModVariables.PLAYER_VARIABLES).end_fog + 1;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
