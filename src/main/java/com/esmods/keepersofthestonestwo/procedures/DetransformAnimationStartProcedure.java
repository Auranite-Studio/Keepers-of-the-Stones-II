package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

@EventBusSubscriber
public class DetransformAnimationStartProcedure {
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
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).detransform_anim_trigger) {
			if (world.isClientSide()) {
				AnimationsModuleSetupProcedure.setAnimationClientside((Player) entity, "animation.player.detransformation", false);
			}
			if (!world.isClientSide()) {
				if (entity instanceof Player)
					PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new AnimationsModuleSetupProcedure.PowerModAnimationMessage("animation.player.detransformation", entity.getId(), false));
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.detransform_anim_trigger = false;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
