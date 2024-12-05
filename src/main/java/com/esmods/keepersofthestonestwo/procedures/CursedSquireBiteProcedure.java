package com.esmods.keepersofthestonestwo.procedures;

import net.minecraftforge.registries.ForgeRegistries;

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
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.entity.CursedSquireEntity;

public class CursedSquireBiteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double XPar = 0;
		double YPar = 0;
		double Range = 0;
		double ZPar = 0;
		Range = 0.25;
		if (entity.getPersistentData().getDouble("IA") == 0) {
			if (entity instanceof CursedSquireEntity) {
				((CursedSquireEntity) entity).setAnimation("cursed_squire.animation.attack");
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
		if (entity.getPersistentData().getDouble("IA") == 3) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("power:cursed_squire.attack")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("power:cursed_squire.attack")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("IA") > 6 && entity.getPersistentData().getDouble("IA") < 9) {
			for (int index0 = 0; index0 < 4; index0++) {
				XPar = x + entity.getLookAngle().x * Range;
				YPar = y + 1.75;
				ZPar = z + entity.getLookAngle().z * Range;
				{
					final Vec3 _center = new Vec3(XPar, YPar, ZPar);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity) && !(entityiterator instanceof ItemEntity)) {
							if (!(entityiterator instanceof LivingEntity _livEnt16 && _livEnt16.isBlocking())) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("power:cursed_squire_ds")))), 7);
								entityiterator.setDeltaMovement(new Vec3((entity.getLookAngle().x * 0.5), 0.25, (entity.getLookAngle().z * 0.5)));
							} else {
								if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHIELD) {
									{
										ItemStack _ist = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
										if (_ist.hurt(1, RandomSource.create(), null)) {
											_ist.shrink(1);
											_ist.setDamageValue(0);
										}
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.PLAYERS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.PLAYERS, 1, 1, false);
										}
									}
								} else if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.SHIELD) {
									{
										ItemStack _ist = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
										if (_ist.hurt(1, RandomSource.create(), null)) {
											_ist.shrink(1);
											_ist.setDamageValue(0);
										}
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.PLAYERS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.PLAYERS, 1, 1, false);
										}
									}
								}
							}
						}
					}
				}
				Range = Range + 0.375;
			}
		}
		if (entity.getPersistentData().getDouble("IA") == 12) {
			entity.getPersistentData().putDouble("IA", 0);
			entity.getPersistentData().putString("State", "Idle");
		}
	}
}
