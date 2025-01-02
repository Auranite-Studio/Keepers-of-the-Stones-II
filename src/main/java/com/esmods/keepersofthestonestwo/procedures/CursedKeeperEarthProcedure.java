package com.esmods.keepersofthestonestwo.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;

public class CursedKeeperEarthProcedure {
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
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 5, false, false));
		entity.getPersistentData().putDouble("IA", (entity.getPersistentData().getDouble("IA") + 1));
		if (entity.getPersistentData().getDouble("IA") == 15) {
			if (entity instanceof CursedKeeperEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_two_anim_sync, false);
			if (entity instanceof CursedKeeperEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_attack_anim_sync, 4);
		}
		if (entity.getPersistentData().getDouble("IA") > 59 && entity.getPersistentData().getDouble("IA") < 61) {
			if (entity.getPersistentData().getDouble("IA") > 59 && entity.getPersistentData().getDouble("IA") < 61) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate_tiles.break")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate_tiles.break")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity) && entityiterator instanceof Player) {
						if (!(entityiterator instanceof ItemEntity)) {
							if ((world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()))).getBlock() == Blocks.AIR) {
								world.levelEvent(2001, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), Block.getId(Blocks.POINTED_DRIPSTONE.defaultBlockState()));
								world.setBlock(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), Blocks.POINTED_DRIPSTONE.defaultBlockState(), 3);
								if (world instanceof Level _level)
									_level.updateNeighborsAt(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
											_level.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())).getBlock());
								world.levelEvent(2001, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1, entityiterator.getZ()), Block.getId(Blocks.POINTED_DRIPSTONE.defaultBlockState()));
								world.setBlock(BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1, entityiterator.getZ()), Blocks.POINTED_DRIPSTONE.defaultBlockState(), 3);
								if (world instanceof Level _level)
									_level.updateNeighborsAt(BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1, entityiterator.getZ()),
											_level.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1, entityiterator.getZ())).getBlock());
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("power:elemental_powers")))), 24);
							}
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("IA") == 80) {
			entity.getPersistentData().putDouble("IA", 0);
			entity.getPersistentData().putString("State", "Idle");
			if (entity instanceof CursedKeeperEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_attack_anim_sync, 0);
			if (entity instanceof CursedKeeperEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_two_anim_sync, true);
		}
	}
}
