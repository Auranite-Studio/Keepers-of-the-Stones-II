package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
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
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModParticleTypes;

public class AmberSpecialAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean success = false;
		double Scaling = 0;
		double XPar = 0;
		double YPar = 0;
		double Range = 0;
		double ZPar = 0;
		double particleRadius = 0;
		double particleAmount = 0;
		if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("amber_ability_1")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 15) {
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
						_level.sendParticles((SimpleParticleType) (PowerModParticleTypes.AMBER_POWER.get()),
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
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 2));
							}
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 15;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("amber_ability_2")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 50) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (!(entityiterator == entity)) {
							if (!(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("amber")) {
								if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
									{
										PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
										_vars.fake_element_name_first = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first;
										_vars.syncPlayerVariables(entity);
									}
								} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
									if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first)) {
										{
											PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
											_vars.fake_element_name_second = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first;
											_vars.syncPlayerVariables(entity);
										}
									}
								} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
										&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
									if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first)
											&& !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first)) {
										{
											PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
											_vars.fake_element_name_third = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first;
											_vars.syncPlayerVariables(entity);
										}
									}
								}
							}
							if (!(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("amber")) {
								if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
									{
										PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
										_vars.fake_element_name_first = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second;
										_vars.syncPlayerVariables(entity);
									}
								} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
									if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second)) {
										{
											PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
											_vars.fake_element_name_second = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second;
											_vars.syncPlayerVariables(entity);
										}
									}
								} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
										&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
									if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second)
											&& !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second)) {
										{
											PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
											_vars.fake_element_name_third = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second;
											_vars.syncPlayerVariables(entity);
										}
									}
								}
							}
							if (!(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("amber")) {
								if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
									{
										PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
										_vars.fake_element_name_first = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third;
										_vars.syncPlayerVariables(entity);
									}
								} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
									if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third)) {
										{
											PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
											_vars.fake_element_name_second = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third;
											_vars.syncPlayerVariables(entity);
										}
									}
								} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
										&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
									if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third)
											&& !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third)) {
										{
											PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
											_vars.fake_element_name_third = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third;
											_vars.syncPlayerVariables(entity);
										}
									}
								}
							}
						}
					}
				}
				particleAmount = 8;
				particleRadius = 1.5;
				for (int index1 = 0; index1 < 60; index1++) {
					for (int index2 = 0; index2 < (int) particleAmount; index2++) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (PowerModParticleTypes.AMBER_POWER.get()), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
									(y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 1, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
									(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 1);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("intentionally_empty")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("intentionally_empty")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 50;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("amber_ability_3")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 80) {
				if (!world
						.getBlockState(new BlockPos(
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))
						.canOcclude()) {
					Scaling = Scaling + 1.3;
				}
				{
					final Vec3 _center = new Vec3(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (!(entityiterator == entity) && !(entity instanceof ThrowableProjectile)) {
							{
								PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
								_vars.ability_block = true;
								_vars.syncPlayerVariables(entityiterator);
							}
							entityiterator.getPersistentData().putBoolean("amberLayer", true);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.stone.place")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.stone.place")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (PowerModParticleTypes.AMBER_POWER.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 35, 1, 2, 1, 0);
						}
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 80;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}