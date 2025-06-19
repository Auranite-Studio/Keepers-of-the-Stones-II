package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import java.util.Random;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.entity.CursedKnightEntity;

public class CursedKnightAttackDetectionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Xpar = 0;
		double Ypar = 0;
		double Random = 0;
		double Range = 0;
		double Zpar = 0;
		Range = 0.75;
		if ((entity instanceof CursedKnightEntity _datEntI ? _datEntI.getEntityData().get(CursedKnightEntity.DATA_IA) : 0) > 11) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				for (int index0 = 0; index0 < 15; index0++) {
					Xpar = x + entity.getLookAngle().x * Range;
					Ypar = y + 1.75;
					Zpar = z + entity.getLookAngle().z * Range;
					{
						final Vec3 _center = new Vec3(Xpar, Ypar, Zpar);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.75 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
								if (Range <= 3) {
									if (entity instanceof CursedKnightEntity _datEntSetS)
										_datEntSetS.getEntityData().set(CursedKnightEntity.DATA_State, "Bite");
								}
								if (entity instanceof CursedKnightEntity _datEntSetI)
									_datEntSetI.getEntityData().set(CursedKnightEntity.DATA_IA, 0);
							}
						}
					}
					Range = Range + 0.85;
				}
			}
		} else {
			if (entity instanceof CursedKnightEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CursedKnightEntity.DATA_IA, (int) ((entity instanceof CursedKnightEntity _datEntI ? _datEntI.getEntityData().get(CursedKnightEntity.DATA_IA) : 0) + 1));
		}
	}
}