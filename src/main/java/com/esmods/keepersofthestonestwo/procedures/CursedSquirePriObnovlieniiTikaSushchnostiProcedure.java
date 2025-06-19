package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import com.esmods.keepersofthestonestwo.entity.CursedSquireEntity;

public class CursedSquirePriObnovlieniiTikaSushchnostiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof CursedSquireEntity _datEntL0 && _datEntL0.getEntityData().get(CursedSquireEntity.DATA_OnBattle))) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity instanceof CursedSquireEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CursedSquireEntity.DATA_OnBattle, true);
				if (entity instanceof CursedSquireEntity _datEntSetS)
					_datEntSetS.getEntityData().set(CursedSquireEntity.DATA_State, "Idle");
				entity.setSprinting(true);
				if (entity instanceof CursedSquireEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CursedSquireEntity.DATA_IA, -25);
			}
		} else {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity instanceof CursedSquireEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CursedSquireEntity.DATA_Patience, 0);
			} else {
				if (entity instanceof CursedSquireEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CursedSquireEntity.DATA_Patience, (int) ((entity instanceof CursedSquireEntity _datEntI ? _datEntI.getEntityData().get(CursedSquireEntity.DATA_Patience) : 0) + 1));
			}
			if ((entity instanceof CursedSquireEntity _datEntS ? _datEntS.getEntityData().get(CursedSquireEntity.DATA_State) : "").equals("Idle")) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), y, ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
				}
				CursedSquireAttackDetectionProcedure.execute(world, x, y, z, entity);
			}
			if ((entity instanceof CursedSquireEntity _datEntS ? _datEntS.getEntityData().get(CursedSquireEntity.DATA_State) : "").equals("Bite")) {
				CursedSquireBiteProcedure.execute(world, x, y, z, entity);
			}
		}
		if ((entity instanceof CursedSquireEntity _datEntI ? _datEntI.getEntityData().get(CursedSquireEntity.DATA_Patience) : 0) == 100) {
			if (entity instanceof CursedSquireEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CursedSquireEntity.DATA_IA, 0);
			if (entity instanceof CursedSquireEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CursedSquireEntity.DATA_Patience, 0);
			entity.setSprinting(false);
			if (entity instanceof CursedSquireEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CursedSquireEntity.DATA_OnBattle, false);
		}
	}
}