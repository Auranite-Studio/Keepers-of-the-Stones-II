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
		entity.getPersistentData().putDouble("IA", (entity.getPersistentData().getDouble("IA") + 1));
		if (entity.getPersistentData().getDouble("IA") == 15) {
			if (entity instanceof CursedKeeperEntity) {
				((CursedKeeperEntity) entity).setAnimation("animation.cursed_keeper.agro");
			}
		}
		if (entity.getPersistentData().getDouble("IA") == 82) {
			if (entity instanceof CursedKeeperEntity) {
				((CursedKeeperEntity) entity).setAnimation("animation.cursed_keeper.idle");
			}
		}
		if (entity.getPersistentData().getDouble("Wave") == 0) {
			if (entity.getPersistentData().getDouble("IA") == 139) {
				if (entity instanceof CursedKeeperEntity) {
					((CursedKeeperEntity) entity).setAnimation("animation.cursed_keeper.summon_wave");
				}
				PowerMod.queueServerWork(38, () -> {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PowerModEntities.CURSED_KNIGHT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				});
			}
			if (entity.getPersistentData().getDouble("IA") == 206) {
				if (entity instanceof CursedKeeperEntity) {
					((CursedKeeperEntity) entity).setAnimation("animation.cursed_keeper.idle");
				}
				entity.getPersistentData().putDouble("Wave", 1);
			}
		}
		if (entity.getPersistentData().getDouble("Wave") == 1) {
			if (entity.getPersistentData().getDouble("IA") == 806) {
				if (entity instanceof CursedKeeperEntity) {
					((CursedKeeperEntity) entity).setAnimation("animation.cursed_keeper.summon_wave");
				}
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
			if (entity.getPersistentData().getDouble("IA") == 873) {
				if (entity instanceof CursedKeeperEntity) {
					((CursedKeeperEntity) entity).setAnimation("animation.cursed_keeper.idle");
				}
				entity.getPersistentData().putDouble("Wave", 2);
			}
		}
		if (entity.getPersistentData().getDouble("Wave") == 2) {
			if (entity.getPersistentData().getDouble("IA") == 1473) {
				if (entity instanceof CursedKeeperEntity) {
					((CursedKeeperEntity) entity).setAnimation("animation.cursed_keeper.summon_wave");
				}
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
			if (entity.getPersistentData().getDouble("IA") == 1540) {
				if (entity instanceof CursedKeeperEntity) {
					((CursedKeeperEntity) entity).setAnimation("animation.cursed_keeper.idle");
				}
				entity.getPersistentData().putDouble("Wave", 3);
			}
		}
		if (entity.getPersistentData().getDouble("Wave") == 3) {
			if (entity.getPersistentData().getDouble("IA") == 2140) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 255, false, false));
				if (entity instanceof CursedKeeperEntity) {
					((CursedKeeperEntity) entity).setAnimation("animation.cursed_keeper.fall");
				}
			}
			if (entity.getPersistentData().getDouble("IA") == 2196) {
				entity.getPersistentData().putBoolean("Phase", true);
				entity.getPersistentData().putDouble("IA", 0);
				PowerMod.queueServerWork(1, () -> {
					entity.getPersistentData().putString("State", "Idle");
				});
			}
		}
	}
}
