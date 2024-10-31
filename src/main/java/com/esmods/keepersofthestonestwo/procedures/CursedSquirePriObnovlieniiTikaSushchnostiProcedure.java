package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityAnchorArgument;

public class CursedSquirePriObnovlieniiTikaSushchnostiProcedure {
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
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), y, ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
				}
				CursedSquireAttackDetectionProcedure.execute(world, x, y, z, entity);
			}
			if ((entity.getPersistentData().getString("State")).equals("Bite")) {
				CursedSquireBiteProcedure.execute(world, x, y, z, entity);
			}
		}
		if (entity.getPersistentData().getDouble("Patience") == 100) {
			entity.getPersistentData().putDouble("IA", 0);
			entity.getPersistentData().putDouble("Patience", 0);
			entity.setSprinting(false);
			entity.getPersistentData().putBoolean("OnBattle", false);
		}
	}
}
