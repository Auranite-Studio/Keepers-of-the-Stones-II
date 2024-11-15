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
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.Comparator;

public class EnergiumGolemPriObnovlieniiTikaSushchnostiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.getPersistentData().getBoolean("OnBattle")) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.getPersistentData().putBoolean("OnBattle", true);
				entity.getPersistentData().putString("State", "Idle");
				entity.setSprinting(true);
				entity.getPersistentData().putDouble("IA", (-25));
			}
		} else {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.getPersistentData().putDouble("Patience", 0);
			} else {
				entity.getPersistentData().putDouble("Patience", (entity.getPersistentData().getDouble("Patience") + 1));
			}
			if ((entity.getPersistentData().getString("State")).equals("Idle")) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
				}
				EnergiumGolemAttackDetectionProcedure.execute(world, x, y, z, entity);
			}
			if ((entity.getPersistentData().getString("State")).equals("Hands")) {
				EnergiumGolemHandsAttackProcedure.execute(world, x, y, z, entity);
			}
			if ((entity.getPersistentData().getString("State")).equals("Core")) {
				EnergiumGolemCoreAttackProcedure.execute(world, x, y, z, entity);
			}
		}
		if (entity.getPersistentData().getDouble("Patience") == 100) {
			entity.getPersistentData().putDouble("IA", 0);
			entity.getPersistentData().putDouble("Patience", 0);
			entity.setSprinting(false);
			entity.getPersistentData().putBoolean("OnBattle", false);
		}
		if (!world.getEntitiesOfClass(Boat.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty()) {
			((Entity) world.getEntitiesOfClass(Boat.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1000);
		} else if (!world.getEntitiesOfClass(ChestBoat.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty()) {
			((Entity) world.getEntitiesOfClass(ChestBoat.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1000);
		} else if (!world.getEntitiesOfClass(Minecart.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty()) {
			((Entity) world.getEntitiesOfClass(Minecart.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1000);
		}
	}
}
