package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import java.util.List;
import java.util.Comparator;

public class RedMagnetPowerTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double itemPosZ = 0;
		double itemPosY = 0;
		double itemPosX = 0;
		double playerPosY = 0;
		double playerPosZ = 0;
		double playerPosX = 0;
		playerPosX = entity.getX();
		playerPosY = entity.getY();
		playerPosZ = entity.getZ();
		{
			final Vec3 _center = new Vec3(playerPosX, playerPosY, playerPosZ);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false) && (entity instanceof Mob || entity instanceof Player)) {
						itemPosX = entityiterator.getX();
						itemPosY = entityiterator.getY();
						itemPosZ = entityiterator.getZ();
						if (itemPosX > playerPosX) {
							entityiterator.setDeltaMovement(new Vec3((-0.25), (entityiterator.getDeltaMovement().y()), (entityiterator.getDeltaMovement().z())));
						} else if (itemPosX < playerPosX) {
							entityiterator.setDeltaMovement(new Vec3(0.25, (entityiterator.getDeltaMovement().y()), (entityiterator.getDeltaMovement().z())));
						}
						if (itemPosY > playerPosY) {
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (-0.25), (entityiterator.getDeltaMovement().z())));
						} else if (itemPosY < playerPosY) {
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), 0.25, (entityiterator.getDeltaMovement().z())));
						}
						if (itemPosZ > playerPosZ) {
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (entityiterator.getDeltaMovement().y()), (-0.25)));
						} else if (itemPosZ < playerPosZ) {
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (entityiterator.getDeltaMovement().y()), 0.25));
						}
					}
				}
			}
		}
	}
}
