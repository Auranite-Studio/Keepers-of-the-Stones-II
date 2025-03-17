package com.esmods.keepersofthestonestwo.procedures;

import org.joml.Vector3f;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModEntities;
import com.esmods.keepersofthestonestwo.entity.WhiteBombEntity;

public class ColorsSpecialAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Scaling = 0;
		double particleRadius = 0;
		double particleAmount = 0;
		double color_id = 0;
		if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("colors_attack_1")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 10) {
				for (int index0 = 0; index0 < 15; index0++) {
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
						((ServerLevel) world).sendParticles((new DustParticleOptions(new Vector3f(85 / 255.0F, 85 / 255.0F, 187 / 255.0F), 1)),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								10, 1, 1, 1, 0.25);
					if (world instanceof ServerLevel)
						((ServerLevel) world).sendParticles((new DustParticleOptions(new Vector3f(62 / 255.0F, 162 / 255.0F, 95 / 255.0F), 1)),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								10, 1, 1, 1, 0.25);
					if (world instanceof ServerLevel)
						((ServerLevel) world).sendParticles((new DustParticleOptions(new Vector3f(125 / 255.0F, 12 / 255.0F, 133 / 255.0F), 1)),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								10, 1, 1, 1, 0.25);
					if (world instanceof ServerLevel)
						((ServerLevel) world).sendParticles((new DustParticleOptions(new Vector3f(255 / 255.0F, 230 / 255.0F, 63 / 255.0F), 1)),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								10, 1, 1, 1, 0.25);
					if (world instanceof ServerLevel)
						((ServerLevel) world).sendParticles((new DustParticleOptions(new Vector3f(189 / 255.0F, 32 / 255.0F, 15 / 255.0F), 1)),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								10, 1, 1, 1, 0.25);
					if (world instanceof ServerLevel)
						((ServerLevel) world).sendParticles((new DustParticleOptions(new Vector3f(255 / 255.0F, 255 / 255.0F, 255 / 255.0F), 1)),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								10, 1, 1, 1, 0.25);
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
							}
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sand.fall")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sand.fall")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = (entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 10);
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("colors_attack_2")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 40) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = initArrowProjectile(new WhiteBombEntity(PowerModEntities.WHITE_BOMB.get(), projectileLevel), entity, (float) (entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl * 1.4), true,
								false, false, AbstractArrow.Pickup.DISALLOWED);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sand.fall")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sand.fall")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = (entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 40);
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("colors_attack_3")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 70) {
				color_id = Mth.nextInt(RandomSource.create(), 1, 7);
				if (color_id == 1) {
					particleAmount = 8;
					particleRadius = 2;
					for (int index1 = 0; index1 < 60; index1++) {
						for (int index2 = 0; index2 < (int) particleAmount; index2++) {
							if (world instanceof ServerLevel)
								((ServerLevel) world).sendParticles((new DustParticleOptions(new Vector3f(255 / 255.0F, 0 / 255.0F, 0 / 255.0F), 1)), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
										(y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 1, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
										(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 1);
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1800, 3));
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power = (entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 70);
						_vars.syncPlayerVariables(entity);
					}
				}
				if (color_id == 2) {
					particleAmount = 8;
					particleRadius = 2;
					for (int index3 = 0; index3 < 60; index3++) {
						for (int index4 = 0; index4 < (int) particleAmount; index4++) {
							if (world instanceof ServerLevel)
								((ServerLevel) world).sendParticles((new DustParticleOptions(new Vector3f(255 / 255.0F, 125 / 255.0F, 0 / 255.0F), 1)), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
										(y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 1, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
										(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 1);
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1800, 0));
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power = (entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 70);
						_vars.syncPlayerVariables(entity);
					}
				}
				if (color_id == 3) {
					particleAmount = 8;
					particleRadius = 2;
					for (int index5 = 0; index5 < 60; index5++) {
						for (int index6 = 0; index6 < (int) particleAmount; index6++) {
							if (world instanceof ServerLevel)
								((ServerLevel) world).sendParticles((new DustParticleOptions(new Vector3f(255 / 255.0F, 255 / 255.0F, 0 / 255.0F), 1)), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
										(y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 1, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
										(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 1);
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 3));
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power = (entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 70);
						_vars.syncPlayerVariables(entity);
					}
				}
				if (color_id == 4) {
					particleAmount = 8;
					particleRadius = 2;
					for (int index7 = 0; index7 < 60; index7++) {
						for (int index8 = 0; index8 < (int) particleAmount; index8++) {
							if (world instanceof ServerLevel)
								((ServerLevel) world).sendParticles((new DustParticleOptions(new Vector3f(0 / 255.0F, 255 / 255.0F, 0 / 255.0F), 1)), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
										(y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 1, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
										(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 1);
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 1800, 3));
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power = (entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 70);
						_vars.syncPlayerVariables(entity);
					}
				}
				if (color_id == 5) {
					particleAmount = 8;
					particleRadius = 2;
					for (int index9 = 0; index9 < 60; index9++) {
						for (int index10 = 0; index10 < (int) particleAmount; index10++) {
							if (world instanceof ServerLevel)
								((ServerLevel) world).sendParticles((new DustParticleOptions(new Vector3f(0 / 255.0F, 255 / 255.0F, 255 / 255.0F), 1)), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
										(y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 1, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
										(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 1);
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1800, 5));
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power = (entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 70);
						_vars.syncPlayerVariables(entity);
					}
				}
				if (color_id == 6) {
					particleAmount = 8;
					particleRadius = 2;
					for (int index11 = 0; index11 < 60; index11++) {
						for (int index12 = 0; index12 < (int) particleAmount; index12++) {
							if (world instanceof ServerLevel)
								((ServerLevel) world).sendParticles((new DustParticleOptions(new Vector3f(0 / 255.0F, 0 / 255.0F, 255 / 255.0F), 1)), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
										(y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 1, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
										(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 1);
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 1800, 0));
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power = (entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 70);
						_vars.syncPlayerVariables(entity);
					}
				}
				if (color_id == 7) {
					particleAmount = 8;
					particleRadius = 2;
					for (int index13 = 0; index13 < 60; index13++) {
						for (int index14 = 0; index14 < (int) particleAmount; index14++) {
							if (world instanceof ServerLevel)
								((ServerLevel) world).sendParticles((new DustParticleOptions(new Vector3f(125 / 255.0F, 0 / 255.0F, 255 / 255.0F), 1)), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
										(y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 1, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
										(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 1);
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 1800, 3));
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power = (entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 70);
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
	}

	private static AbstractArrow initArrowProjectile(AbstractArrow entityToSpawn, Entity shooter, float damage, boolean silent, boolean fire, boolean particles, AbstractArrow.Pickup pickup) {
		entityToSpawn.setOwner(shooter);
		entityToSpawn.setBaseDamage(damage);
		if (silent)
			entityToSpawn.setSilent(true);
		if (fire)
			entityToSpawn.igniteForSeconds(100);
		if (particles)
			entityToSpawn.setCritArrow(true);
		entityToSpawn.pickup = pickup;
		return entityToSpawn;
	}
}
