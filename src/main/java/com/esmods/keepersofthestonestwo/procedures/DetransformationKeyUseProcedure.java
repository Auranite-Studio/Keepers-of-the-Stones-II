package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import com.esmods.keepersofthestonestwo.PowerMod;

public class DetransformationKeyUseProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		PowerMod.queueServerWork(1, () -> {
			if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).active_power == true) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.FIRE_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.AIR_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.EARTH_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.WATER_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.ETHER_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.ICE_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.LIGHTNING_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SOUND_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.CRYSTAL_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.LAVA_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.RAIN_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.TORNADO_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.OCEAN_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.PLANTS_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.ANIMALS_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.METAL_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.LIGHT_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SHADOW_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.VACUUM_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.ENERGY_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SUN_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.MOON_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SPACE_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.TIME_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.CREATION_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.DESTRUCTION_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.BLOOD_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.TECHNOLOGY_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.TELEPORTATION_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.EXPLOSION_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.AMBER_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.MIST_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SAND_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SPEED_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.POISON_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.MAGNET_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.MUSHROOMS_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.MERCURY_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.MUSIC_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.PLAGUE_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.BLUE_FLAME_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.GRAVITY_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SMOKE_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SPIRIT_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.FORM_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.MIND_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.GOLDEN_DUST_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.DARKNESS_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.THIRST_DARK_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.CHAOS_DARK_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.HORROR_DARK_MASTER.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.FILTH_DARK_MASTER.get());
				{
					boolean _setval = false;
					entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.active_power = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.mergers = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = true;
					entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.detransform_anim_trigger = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = false;
					entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.transfered_power = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			{
				double _setval = 0;
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.power = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.fake_element_name_first_timer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.fake_element_name_second_timer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.fake_element_name_third_timer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "0";
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.fake_element_name_first = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "0";
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.fake_element_name_second = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "0";
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.fake_element_name_third = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "0";
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof Level _level) {
				PlayerTeam _pt = _level.getScoreboard().getPlayerTeam(("HypnotizedBy" + entity.getDisplayName().getString()));
				if (_pt != null)
					_level.getScoreboard().removePlayerTeam(_pt);
			}
		});
	}
}
