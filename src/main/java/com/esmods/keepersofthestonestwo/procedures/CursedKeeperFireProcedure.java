package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;

public class CursedKeeperFireProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Grow = 0;
		double Chain = 0;
		double ChainWait = 0;
		double XPar = 0;
		double YPar = 0;
		double loop = 0;
		double Range = 0;
		double particles = 0;
		double ZPar = 0;
		Range = 1;
		particles = 3;
		entity.getPersistentData().putDouble("IA", (entity.getPersistentData().getDouble("IA") + 1));
		if (entity.getPersistentData().getDouble("IA") == 15) {
			if (entity instanceof CursedKeeperEntity) {
				((CursedKeeperEntity) entity).setAnimation("animation.cursed_keeper.firethrowing");
			}
		}
		if (entity.getPersistentData().getDouble("IA") > 19 && entity.getPersistentData().getDouble("IA") < 30) {
			entity.getPersistentData().putDouble("BreathRange", (entity.getPersistentData().getDouble("BreathRange") + 1));
		}
		if (entity.getPersistentData().getDouble("IA") > 35 && entity.getPersistentData().getDouble("IA") < 62) {
			if (entity.getPersistentData().getDouble("IA") > 35 && entity.getPersistentData().getDouble("IA") < 37) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
			}
			for (int index0 = 0; index0 < (int) entity.getPersistentData().getDouble("BreathRange"); index0++) {
				for (int index1 = 0; index1 < (int) particles; index1++) {
					XPar = x + Math.cos(((Math.PI * 0.5) / particles) * loop + Math.toRadians(entity.getYRot() + 75)) * Range;
					YPar = y + 1.5;
					ZPar = z + Math.sin(((Math.PI * 0.5) / particles) * loop + Math.toRadians(entity.getYRot() + 75)) * Range;
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FLAME, XPar, YPar, ZPar, 5, (0.075 + Range * 0.05), (0.075 + Range * 0.05), (0.075 + Range * 0.05), 0);
					{
						final Vec3 _center = new Vec3(XPar, YPar, ZPar);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((0.125 + Range * 0.05) / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
								.toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (!(entityiterator instanceof LivingEntity _livEnt18 && _livEnt18.isBlocking())) {
									if (!(entityiterator instanceof ItemEntity)) {
										entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("power:elemental_powers")))), 9);
										entityiterator.igniteForSeconds(10);
									}
								} else {
									if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHIELD) {
										if (world instanceof ServerLevel _level) {
											(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
											});
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")), SoundSource.PLAYERS, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")), SoundSource.PLAYERS, 1, 1, false);
											}
										}
									} else if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.SHIELD) {
										if (world instanceof ServerLevel _level) {
											(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
											});
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")), SoundSource.PLAYERS, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")), SoundSource.PLAYERS, 1, 1, false);
											}
										}
									}
								}
							}
						}
					}
					loop = loop + 1;
				}
				Range = Range + 1;
				particles = particles + 1;
				loop = 0;
			}
		}
		if (entity.getPersistentData().getDouble("IA") == 70) {
			entity.getPersistentData().putDouble("BreathRange", 0);
			entity.getPersistentData().putDouble("IA", 0);
			entity.getPersistentData().putString("State", "Idle");
		}
	}
}
