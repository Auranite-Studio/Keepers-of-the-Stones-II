package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

public class ElementalPowerGeneratorRegenerationStarsTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip1) : -1) == 1) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).active_battery == false && entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).active_power == false
								&& !(entityiterator instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(PowerModMobEffects.STAR_REGENERATION))) {
							if (entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).powerTimer > 0) {
								{
									PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
									_vars.powerTimer = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).powerTimer - 0.5;
									_vars.syncPlayerVariables(entityiterator);
								}
							} else {
								{
									PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
									_vars.powerTimer = 50;
									_vars.syncPlayerVariables(entityiterator);
								}
								if (entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).power < entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).max_power) {
									{
										PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
										_vars.power = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).power + 5;
										_vars.syncPlayerVariables(entityiterator);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
