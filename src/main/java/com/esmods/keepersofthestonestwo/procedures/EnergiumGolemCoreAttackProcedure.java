package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.init.PowerModParticleTypes;
import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import com.esmods.keepersofthestonestwo.entity.EnergiumGolemEntity;

public class EnergiumGolemCoreAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double XPar = 0;
		double YPar = 0;
		double loop = 0;
		double Range = 0;
		double particles = 0;
		double ZPar = 0;
		Range = 3;
		particles = 5;
		if (entity.getPersistentData().getDouble("IA") == 0) {
			if (entity instanceof EnergiumGolemEntity) {
				((EnergiumGolemEntity) entity).setAnimation("energium_golem.animation.shoot");
			}
			entity.getPersistentData().putDouble("Look", (entity.getYRot()));
		}
		entity.getPersistentData().putDouble("IA", (entity.getPersistentData().getDouble("IA") + 1));
		{
			Entity _ent = entity;
			_ent.setYRot((float) entity.getPersistentData().getDouble("Look"));
			_ent.setXRot(0);
			_ent.setYBodyRot(_ent.getYRot());
			_ent.setYHeadRot(_ent.getYRot());
			_ent.yRotO = _ent.getYRot();
			_ent.xRotO = _ent.getXRot();
			if (_ent instanceof LivingEntity _entity) {
				_entity.yBodyRotO = _entity.getYRot();
				_entity.yHeadRotO = _entity.getYRot();
			}
		}
		if (entity.getPersistentData().getDouble("IA") > 5 && entity.getPersistentData().getDouble("IA") < 20) {
			entity.getPersistentData().putDouble("BreathRange", (entity.getPersistentData().getDouble("BreathRange") + 1));
		}
		if (entity.getPersistentData().getDouble("IA") > 24 && entity.getPersistentData().getDouble("IA") < 37) {
			if (entity.getPersistentData().getDouble("IA") > 24 && entity.getPersistentData().getDouble("IA") < 26) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
			}
			for (int index0 = 0; index0 < (int) entity.getPersistentData().getDouble("BreathRange"); index0++) {
				for (int index1 = 0; index1 < (int) particles; index1++) {
					XPar = x + Math.cos(((Math.PI * 0.5) / particles) * loop + Math.toRadians(entity.getYRot() + 75)) * Range;
					YPar = y + 1.5;
					ZPar = z + Math.sin(((Math.PI * 0.5) / particles) * loop + Math.toRadians(entity.getYRot() + 75)) * Range;
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (PowerModParticleTypes.ENERGIUM_GOLEM_CORE_ATTACK_PARTICLE.get()), XPar, YPar, ZPar, 5, (0.075 + Range * 0.05), (0.075 + Range * 0.05), (0.075 + Range * 0.05), 0);
					{
						final Vec3 _center = new Vec3(XPar, YPar, ZPar);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((0.125 + Range * 0.05) / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
								.toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (!(entityiterator instanceof ItemEntity)) {
									entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("power:energium_golem_ds")))), 24);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(PowerModMobEffects.POWER_LOCK, 200, 0));
								}
							}
						}
					}
					if (!(world.getBlockState(BlockPos.containing(XPar, YPar, ZPar))).is(BlockTags.create(ResourceLocation.parse("c:unbreakable"))) && world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) == true) {
						world.destroyBlock(BlockPos.containing(XPar, YPar, ZPar), false);
					}
					loop = loop + 1;
				}
				Range = Range + 1;
				particles = particles + 1;
				loop = 0;
			}
		}
		if (entity.getPersistentData().getDouble("IA") == 42) {
			entity.getPersistentData().putDouble("IA", 0);
			entity.getPersistentData().putDouble("BreathRange", 0);
			entity.getPersistentData().putString("State", "Idle");
		}
	}
}
