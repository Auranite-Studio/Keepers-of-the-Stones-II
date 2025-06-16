package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import java.util.UUID;
import java.util.Comparator;
import java.util.ArrayList;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModParticleTypes;

public class MindSpecialAttackProcedure {
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
		if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("mind_ability_1")) {
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
						((ServerLevel) world).sendParticles(((SimpleParticleType) (PowerModParticleTypes.MIND_REACTION_PARTICLE.get())),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								2, 1, 1, 1, 0.25);
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
									_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 4));
							}
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.trial_spawner.ambient")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.trial_spawner.ambient")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 15;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("mind_ability_2")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 80) {
				if (!entity.getData(PowerModVariables.PLAYER_VARIABLES).mind_used) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (!(entityiterator == entity) && entityiterator instanceof Player) {
								{
									PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
									_vars.mind_player_owner = entity.getStringUUID();
									_vars.syncPlayerVariables(entityiterator);
								}
							}
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.trial_spawner.ambient")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.trial_spawner.ambient")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.mind_used = true;
						_vars.syncPlayerVariables(entity);
					}
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 80;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("remote_control_1")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 25) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if (!(entity == entityiterator) && new Object() {
						Entity getEntity(String uuid) {
							Entity _uuidentity = null;
							if (world instanceof ServerLevel _server) {
								try {
									_uuidentity = _server.getEntity(UUID.fromString(uuid));
								} catch (IllegalArgumentException e) {
								}
							}
							return _uuidentity;
						}
					}.getEntity(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).mind_player_owner) == entity) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("X: " + entityiterator.getX() + "Y: " + entityiterator.getY() + "Z: " + entityiterator.getZ())), false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.trial_spawner.ambient")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.trial_spawner.ambient")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 25;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("remote_control_2")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 25) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if (!(entity == entityiterator) && new Object() {
						Entity getEntity(String uuid) {
							Entity _uuidentity = null;
							if (world instanceof ServerLevel _server) {
								try {
									_uuidentity = _server.getEntity(UUID.fromString(uuid));
								} catch (IllegalArgumentException e) {
								}
							}
							return _uuidentity;
						}
					}.getEntity(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).mind_player_owner) == entity) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("power:elemental_powers")))), 500);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.trial_spawner.ambient")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.trial_spawner.ambient")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 25;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("remote_control_3")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 25) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if (!(entity == entityiterator) && new Object() {
						Entity getEntity(String uuid) {
							Entity _uuidentity = null;
							if (world instanceof ServerLevel _server) {
								try {
									_uuidentity = _server.getEntity(UUID.fromString(uuid));
								} catch (IllegalArgumentException e) {
								}
							}
							return _uuidentity;
						}
					}.getEntity(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).mind_player_owner) == entity) {
						{
							PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
							_vars.mind_player_owner = "";
							_vars.syncPlayerVariables(entityiterator);
						}
						{
							PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
							_vars.mind_used = false;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.trial_spawner.ambient")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.trial_spawner.ambient")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 25;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}