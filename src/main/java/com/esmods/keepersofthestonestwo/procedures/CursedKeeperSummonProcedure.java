package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import com.esmods.keepersofthestonestwo.init.PowerModEntities;
import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;
import com.esmods.keepersofthestonestwo.PowerMod;

public class CursedKeeperSummonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 5, false, false));
		if (entity instanceof CursedKeeperEntity _datEntSetI)
			_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_IA, (int) ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_IA) : 0) + 1));
		if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_IA) : 0) == 15) {
			if (entity instanceof CursedKeeperEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_zero_anim_sync, false);
			if (entity instanceof CursedKeeperEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_aggro_anim_sync, true);
		}
		if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_IA) : 0) == 82) {
			if (entity instanceof CursedKeeperEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_aggro_anim_sync, false);
			if (entity instanceof CursedKeeperEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_one_anim_sync, true);
		}
		if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_Wave) : 0) == 0) {
			if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_IA) : 0) == 139) {
				if (entity instanceof CursedKeeperEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_one_anim_sync, false);
				if (entity instanceof CursedKeeperEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_attack_anim_sync, 1);
				PowerMod.queueServerWork(38, () -> {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PowerModEntities.CURSED_KNIGHT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				});
			}
			if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_IA) : 0) == 206) {
				if (entity instanceof CursedKeeperEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_Wave, 1);
				if (entity instanceof CursedKeeperEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_attack_anim_sync, 0);
				if (entity instanceof CursedKeeperEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_one_anim_sync, true);
			}
		}
		if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_Wave) : 0) == 1) {
			if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_IA) : 0) == 806) {
				if (entity instanceof CursedKeeperEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_one_anim_sync, false);
				if (entity instanceof CursedKeeperEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_attack_anim_sync, 1);
				PowerMod.queueServerWork(28, () -> {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PowerModEntities.CURSED_KNIGHT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					PowerMod.queueServerWork(48, () -> {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = PowerModEntities.CURSED_SQUIRE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					});
				});
			}
			if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_IA) : 0) == 873) {
				if (entity instanceof CursedKeeperEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_Wave, 2);
				if (entity instanceof CursedKeeperEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_attack_anim_sync, 0);
				if (entity instanceof CursedKeeperEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_one_anim_sync, true);
			}
		}
		if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_Wave) : 0) == 2) {
			if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_IA) : 0) == 1473) {
				if (entity instanceof CursedKeeperEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_one_anim_sync, false);
				if (entity instanceof CursedKeeperEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_attack_anim_sync, 1);
				PowerMod.queueServerWork(18, () -> {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PowerModEntities.CURSED_KNIGHT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					PowerMod.queueServerWork(28, () -> {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = PowerModEntities.CURSED_SQUIRE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						PowerMod.queueServerWork(38, () -> {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = PowerModEntities.CURSED_KNIGHT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
							PowerMod.queueServerWork(48, () -> {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = PowerModEntities.CURSED_SQUIRE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							});
						});
					});
				});
			}
			if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_IA) : 0) == 1540) {
				if (entity instanceof CursedKeeperEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_Wave, 3);
				if (entity instanceof CursedKeeperEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_attack_anim_sync, 0);
				if (entity instanceof CursedKeeperEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_one_anim_sync, true);
			}
		}
		if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_Wave) : 0) == 3) {
			if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_IA) : 0) == 2140) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 255, false, false));
				if (entity instanceof CursedKeeperEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_one_anim_sync, false);
				if (entity instanceof CursedKeeperEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_fall_anim_sync, true);
			}
			if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_IA) : 0) == 2196) {
				if (entity instanceof CursedKeeperEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_Phase, true);
				if (entity instanceof CursedKeeperEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_IA, 0);
				if (entity instanceof CursedKeeperEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_Wave, 3);
				if (entity instanceof CursedKeeperEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_fall_anim_sync, false);
				if (entity instanceof CursedKeeperEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_two_anim_sync, true);
				if (entity instanceof CursedKeeperEntity _datEntSetS)
					_datEntSetS.getEntityData().set(CursedKeeperEntity.DATA_State, "Idle");
			}
		}
	}
}