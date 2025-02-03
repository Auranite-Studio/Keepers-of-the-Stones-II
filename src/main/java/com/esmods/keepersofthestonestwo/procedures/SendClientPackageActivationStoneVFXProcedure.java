package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class SendClientPackageActivationStoneVFXProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("power:stone_activation")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("power:stone_activation")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
		if (world.isClientSide()) {
			AnimationsModuleSetupProcedure.setAnimationClientside((Player) entity, "animation.player.transformation", false);
		}
		if (!world.isClientSide()) {
			if (entity instanceof Player)
				PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new AnimationsModuleSetupProcedure.PowerModAnimationMessage("animation.player.transformation", entity.getId(), false));
		}
	}
}
