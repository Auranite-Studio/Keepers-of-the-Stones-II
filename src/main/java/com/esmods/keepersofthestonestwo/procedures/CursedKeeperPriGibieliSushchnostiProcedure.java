package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import java.util.Comparator;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class CursedKeeperPriGibieliSushchnostiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.theGame().getAdvancements().get(ResourceLocation.parse("power:the_great_win"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.unlock_keepers_box = true;
					_vars.syncPlayerVariables(entityiterator);
				}
			}
		}
	}
}
