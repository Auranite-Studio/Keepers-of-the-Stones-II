package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import com.esmods.keepersofthestonestwo.network.PlayPlayerAnimationMessage;

public class ActivationStoneTriggerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("power:stone_activation")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("power:stone_activation")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
		if (entity instanceof Player) {
			if (entity.level().isClientSide()) {
				CompoundTag data = entity.getPersistentData();
				data.putString("PlayerCurrentAnimation", "power:animation.player.transformation");
				data.putBoolean("OverrideCurrentAnimation", false);
				data.putBoolean("FirstPersonAnimation", false);
			} else {
				PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new PlayPlayerAnimationMessage(entity.getId(), "power:animation.player.transformation", false, false));
			}
		}
	}
}