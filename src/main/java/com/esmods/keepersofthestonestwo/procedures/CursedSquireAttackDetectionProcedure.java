package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import java.util.Random;
import java.util.Comparator;

public class CursedSquireAttackDetectionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Xpar = 0;
		double Ypar = 0;
		double Random = 0;
		double Range = 0;
		double Zpar = 0;
		Range = 0.75;
		if (entity.getPersistentData().getDouble("IA") > 4) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				for (int index0 = 0; index0 < 15; index0++) {
					Xpar = x + entity.getLookAngle().x * Range;
					Ypar = y + 1.75;
					Zpar = z + entity.getLookAngle().z * Range;
					{
						final Vec3 _center = new Vec3(Xpar, Ypar, Zpar);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.75 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
								if (Range <= 1.5) {
									entity.getPersistentData().putString("State", "Bite");
								}
								entity.getPersistentData().putDouble("IA", 0);
							}
						}
					}
					Range = Range + 0.85;
				}
			}
		} else {
			entity.getPersistentData().putDouble("IA", (entity.getPersistentData().getDouble("IA") + 1));
		}
		if (!world.getEntitiesOfClass(Boat.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(1 / 2d), e -> true).isEmpty()) {
			(findEntityInWorldRange(world, Boat.class, x, y, z, 1)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1000);
		} else if (!world.getEntitiesOfClass(ChestBoat.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(1 / 2d), e -> true).isEmpty()) {
			(findEntityInWorldRange(world, ChestBoat.class, x, y, z, 1)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1000);
		} else if (!world.getEntitiesOfClass(Minecart.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(1 / 2d), e -> true).isEmpty()) {
			(findEntityInWorldRange(world, Minecart.class, x, y, z, 1)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1000);
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}
