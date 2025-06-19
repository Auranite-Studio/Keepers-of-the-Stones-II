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
import net.minecraft.core.BlockPos;

import java.util.Comparator;

import com.esmods.keepersofthestonestwo.entity.CursedKnightEntity;

public class CursedKnightBiteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double XPar = 0;
		double YPar = 0;
		double Range = 0;
		double ZPar = 0;
		Range = 0.25;
		if ((entity instanceof CursedKnightEntity _datEntI ? _datEntI.getEntityData().get(CursedKnightEntity.DATA_IA) : 0) == 0) {
			if (entity instanceof CursedKnightEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CursedKnightEntity.DATA_attack_anim_sync, 1);
			if (entity instanceof CursedKnightEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CursedKnightEntity.DATA_Look, (int) entity.getYRot());
		}
		if (entity instanceof CursedKnightEntity _datEntSetI)
			_datEntSetI.getEntityData().set(CursedKnightEntity.DATA_IA, (int) ((entity instanceof CursedKnightEntity _datEntI ? _datEntI.getEntityData().get(CursedKnightEntity.DATA_IA) : 0) + 1));
		{
			Entity _ent = entity;
			_ent.setYRot((float) (entity instanceof CursedKnightEntity _datEntI ? _datEntI.getEntityData().get(CursedKnightEntity.DATA_Look) : 0));
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
		if ((entity instanceof CursedKnightEntity _datEntI ? _datEntI.getEntityData().get(CursedKnightEntity.DATA_IA) : 0) == 9) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("power:cursed_knight.attack")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("power:cursed_knight.attack")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
		if ((entity instanceof CursedKnightEntity _datEntI ? _datEntI.getEntityData().get(CursedKnightEntity.DATA_IA) : 0) > 13 && (entity instanceof CursedKnightEntity _datEntI ? _datEntI.getEntityData().get(CursedKnightEntity.DATA_IA) : 0) < 23) {
			for (int index0 = 0; index0 < 4; index0++) {
				XPar = x + entity.getLookAngle().x * Range;
				YPar = y + 1.75;
				ZPar = z + entity.getLookAngle().z * Range;
				{
					final Vec3 _center = new Vec3(XPar, YPar, ZPar);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (!(entityiterator == entity) && !(entityiterator instanceof ItemEntity)) {
							if (!(entityiterator instanceof LivingEntity _livEnt16 && _livEnt16.isBlocking())) {
								entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("power:cursed_knight_ds")))), 14);
								entityiterator.setDeltaMovement(new Vec3((entity.getLookAngle().x * 0.5), 0.25, (entity.getLookAngle().z * 0.5)));
							} else {
								if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHIELD) {
									if (world instanceof ServerLevel _level) {
										(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
										});
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.shield.block")), SoundSource.PLAYERS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.shield.block")), SoundSource.PLAYERS, 1, 1, false);
										}
									}
								} else if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.SHIELD) {
									if (world instanceof ServerLevel _level) {
										(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
										});
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.shield.block")), SoundSource.PLAYERS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.shield.block")), SoundSource.PLAYERS, 1, 1, false);
										}
									}
								}
							}
						}
					}
				}
				Range = Range + 0.75;
			}
		}
		if ((entity instanceof CursedKnightEntity _datEntI ? _datEntI.getEntityData().get(CursedKnightEntity.DATA_IA) : 0) == 31) {
			if (entity instanceof CursedKnightEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CursedKnightEntity.DATA_IA, 0);
			if (entity instanceof CursedKnightEntity _datEntSetS)
				_datEntSetS.getEntityData().set(CursedKnightEntity.DATA_State, "Idle");
			if (entity instanceof CursedKnightEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CursedKnightEntity.DATA_attack_anim_sync, 0);
		}
	}
}