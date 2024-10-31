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
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power == true) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.FIRE_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.AIR_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.EARTH_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.WATER_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.ETHER_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.ICE_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.LIGHTNING_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SOUND_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.CRYSTAL_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.LAVA_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.RAIN_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.TORNADO_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.OCEAN_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.PLANTS_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.ANIMALS_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.METAL_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.LIGHT_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SHADOW_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.VACUUM_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.ENERGY_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SUN_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.MOON_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SPACE_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.TIME_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.CREATION_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.DESTRUCTION_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.BLOOD_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.TECHNOLOGY_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.TELEPORTATION_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.EXPLOSION_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.AMBER_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.MIST_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SAND_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SPEED_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.POISON_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.MAGNET_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.MUSHROOMS_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.MERCURY_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.MUSIC_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.PLAGUE_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.BLUE_FLAME_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.GRAVITY_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SMOKE_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.SPIRIT_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.FORM_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.MIND_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.GOLDEN_DUST_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.DARKNESS_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.THIRST_DARK_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.CHAOS_DARK_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.HORROR_DARK_MASTER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.FILTH_DARK_MASTER);
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.active_power = false;
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.mergers = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.detransform_anim_trigger = true;
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.transfered_power = false;
					_vars.syncPlayerVariables(entity);
				}
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.power = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.fake_element_name_first_timer = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.fake_element_name_second_timer = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.fake_element_name_third_timer = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.fake_element_name_first = "0";
				_vars.syncPlayerVariables(entity);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.fake_element_name_second = "0";
				_vars.syncPlayerVariables(entity);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.fake_element_name_third = "0";
				_vars.syncPlayerVariables(entity);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.ability = "0";
				_vars.syncPlayerVariables(entity);
			}
			if (world instanceof Level _level) {
				PlayerTeam _pt = _level.getScoreboard().getPlayerTeam(("HypnotizedBy" + entity.getDisplayName().getString()));
				if (_pt != null)
					_level.getScoreboard().removePlayerTeam(_pt);
			}
		});
	}
}
