package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.network.PlayPlayerAnimationMessage;

@EventBusSubscriber
public class DetransformAnimationStartProcedure {
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
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).detransform_anim_trigger) {
			if (entity instanceof Player) {
				if (entity.level().isClientSide()) {
					CompoundTag data = entity.getPersistentData();
					data.putString("PlayerCurrentAnimation", "power:animation.player.detransformation");
					data.putBoolean("OverrideCurrentAnimation", false);
					data.putBoolean("FirstPersonAnimation", false);
				} else {
					PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new PlayPlayerAnimationMessage(entity.getId(), "power:animation.player.detransformation", false, false));
				}
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.detransform_anim_trigger = false;
				_vars.markSyncDirty();
			}
		}
	}
}