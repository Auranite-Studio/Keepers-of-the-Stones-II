package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class OceanSpecialAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double Scaling = 0;
		double particleAmount = 0;
		if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("ocean_ability_1")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 10) {
				for (int index0 = 0; index0 < 15; index0++) {
					if (!world.getBlockState(new BlockPos(
							entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
							entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
							entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))
							.canOcclude()) {
						Scaling = Scaling + 0.5;
					} else {
						break;
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.BUBBLE_POP,
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								25, 1, 1, 1, 0.25);
					{
						final Vec3 _center = new Vec3(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
										.getZ()));
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (!(entityiterator == entity)) {
								entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("power:elemental_powers"))), entity),
										(float) entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl);
							}
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.bubble_column.whirlpool_inside")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.bubble_column.whirlpool_inside")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 10;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("ocean_ability_2")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 35) {
				particleAmount = 25;
				particleRadius = 2;
				for (int index1 = 0; index1 < (int) particleAmount; index1++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.BUBBLE_POP, (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
								(z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 25, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
								(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 0.25);
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (!(entityiterator == entity)) {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("power:elemental_powers"))), entity),
									(float) (entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl * 1.7));
						}
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 35;
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.bubble_column.whirlpool_inside")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.bubble_column.whirlpool_inside")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("ocean_ability_3")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 5) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.dolphin.splash")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.dolphin.splash")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 30, 0, (-1), 0, 1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 30, 0, 1, 0, 1);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100, 18, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 5;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}