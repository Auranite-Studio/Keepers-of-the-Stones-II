package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.util.ARGB;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

public class DarknessSpecialAttackProcedure {
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
		double itemPosZ = 0;
		double itemPosY = 0;
		double itemPosX = 0;
		double playerPosY = 0;
		double playerPosZ = 0;
		double playerPosX = 0;
		double RandomPower = 0;
		if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("darkness_ability_1")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 15) {
				for (int index0 = 0; index0 < 30; index0++) {
					if (!world.getBlockState(new BlockPos(
							entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
							entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
							entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))
							.canOcclude()) {
						Scaling = Scaling + 1.3;
					} else {
						break;
					}
					if (world instanceof ServerLevel)
						((ServerLevel) world).sendParticles((new DustParticleOptions(ARGB.color(18, 25, 45), 1)),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								35, 1, 1, 1, 0.25);
					{
						final Vec3 _center = new Vec3(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
										.getZ()));
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (!(entityiterator == entity) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("power:elemental_powers"))), entity),
										(float) entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl);
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 200, 1));
							}
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
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 15;
					_vars.markSyncDirty();
				}
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("darkness_ability_2")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 80) {
				particleAmount = 30;
				particleRadius = 5;
				for (int index1 = 0; index1 < (int) particleAmount; index1++) {
					if (world instanceof ServerLevel)
						((ServerLevel) world).sendParticles((new DustParticleOptions(ARGB.color(18, 25, 45), 1)), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
								(y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 1, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
								(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 0.25);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (!(entityiterator == entity)) {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("power:elemental_powers"))), entity),
									(float) (entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl * 1.4));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 200, 4));
						}
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 45;
					_vars.markSyncDirty();
				}
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("darkness_ability_3")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 80) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (!(entityiterator == entity) && entityiterator instanceof Player && !entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).transfered_power && entity.getData(PowerModVariables.PLAYER_VARIABLES).mergers < 3
								&& !entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
							RandomPower = Mth.nextInt(RandomSource.create(), 1, 4);
							if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
								if (RandomPower == 1) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(PowerModMobEffects.THIRST_DARK_MASTER, 12000, 1, false, false));
									{
										PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
										_vars.mergers = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).mergers + 1;
										_vars.transfered_power = true;
										_vars.markSyncDirty();
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.PLAYERS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.PLAYERS, 1, 1, false);
										}
									}
								} else if (RandomPower == 2) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(PowerModMobEffects.CHAOS_DARK_MASTER, 12000, 1, false, false));
									{
										PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
										_vars.mergers = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).mergers + 1;
										_vars.transfered_power = true;
										_vars.markSyncDirty();
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.PLAYERS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.PLAYERS, 1, 1, false);
										}
									}
								} else if (RandomPower == 3) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(PowerModMobEffects.HORROR_DARK_MASTER, 12000, 1, false, false));
									{
										PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
										_vars.mergers = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).mergers + 1;
										_vars.transfered_power = true;
										_vars.markSyncDirty();
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.PLAYERS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.PLAYERS, 1, 1, false);
										}
									}
								} else if (RandomPower == 4) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(PowerModMobEffects.FILTH_DARK_MASTER, 12000, 1, false, false));
									{
										PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
										_vars.mergers = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).mergers + 1;
										_vars.transfered_power = true;
										_vars.markSyncDirty();
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.PLAYERS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.PLAYERS, 1, 1, false);
										}
									}
								}
							}
						}
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 80;
					_vars.markSyncDirty();
				}
			}
		}
	}
}