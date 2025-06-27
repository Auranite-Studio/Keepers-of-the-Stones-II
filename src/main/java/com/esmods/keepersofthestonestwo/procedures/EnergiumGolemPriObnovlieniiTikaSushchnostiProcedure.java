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

import com.esmods.keepersofthestonestwo.entity.EnergiumGolemEntity;

public class EnergiumGolemPriObnovlieniiTikaSushchnostiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof EnergiumGolemEntity _datEntL0 && _datEntL0.getEntityData().get(EnergiumGolemEntity.DATA_OnBattle))) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity instanceof EnergiumGolemEntity _datEntSetL)
					_datEntSetL.getEntityData().set(EnergiumGolemEntity.DATA_OnBattle, true);
				if (entity instanceof EnergiumGolemEntity _datEntSetS)
					_datEntSetS.getEntityData().set(EnergiumGolemEntity.DATA_State, "Idle");
				entity.setSprinting(true);
				if (entity instanceof EnergiumGolemEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EnergiumGolemEntity.DATA_IA, -25);
			}
		} else {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity instanceof EnergiumGolemEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EnergiumGolemEntity.DATA_Patience, 0);
			} else {
				if (entity instanceof EnergiumGolemEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EnergiumGolemEntity.DATA_Patience, (int) ((entity instanceof EnergiumGolemEntity _datEntI ? _datEntI.getEntityData().get(EnergiumGolemEntity.DATA_Patience) : 0) + 1));
			}
			if ((entity instanceof EnergiumGolemEntity _datEntS ? _datEntS.getEntityData().get(EnergiumGolemEntity.DATA_State) : "").equals("Idle")) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
				}
				EnergiumGolemAttackDetectionProcedure.execute(world, x, y, z, entity);
			}
			if ((entity instanceof EnergiumGolemEntity _datEntS ? _datEntS.getEntityData().get(EnergiumGolemEntity.DATA_State) : "").equals("Hands")) {
				EnergiumGolemHandsAttackProcedure.execute(world, x, y, z, entity);
			}
			if ((entity instanceof EnergiumGolemEntity _datEntS ? _datEntS.getEntityData().get(EnergiumGolemEntity.DATA_State) : "").equals("Core")) {
				EnergiumGolemCoreAttackProcedure.execute(world, x, y, z, entity);
			}
		}
		if ((entity instanceof EnergiumGolemEntity _datEntI ? _datEntI.getEntityData().get(EnergiumGolemEntity.DATA_Patience) : 0) == 100) {
			if (entity instanceof EnergiumGolemEntity _datEntSetI)
				_datEntSetI.getEntityData().set(EnergiumGolemEntity.DATA_IA, 0);
			if (entity instanceof EnergiumGolemEntity _datEntSetI)
				_datEntSetI.getEntityData().set(EnergiumGolemEntity.DATA_Patience, 0);
			entity.setSprinting(false);
			if (entity instanceof EnergiumGolemEntity _datEntSetL)
				_datEntSetL.getEntityData().set(EnergiumGolemEntity.DATA_OnBattle, false);
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