package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class ExtraStarPointsRune3UseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
			particleAmount = 150;
			particleRadius = 2.25;
			for (int index0 = 0; index0 < (int) particleAmount; index0++) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ENCHANT, (x + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * particleRadius), (y + 0 + Mth.nextDouble(RandomSource.create(), 0, 5) * particleRadius),
							(z + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * particleRadius), 1, 0, 0, 0, 0.25);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("power:power.level_up")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("power:power.level_up")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.max_power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power + 20;
				_vars.syncPlayerVariables(entity);
			}
			if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				itemstack.shrink(1);
			}
		}
	}
}
