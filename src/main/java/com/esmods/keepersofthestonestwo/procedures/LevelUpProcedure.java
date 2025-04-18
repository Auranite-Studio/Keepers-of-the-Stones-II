package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModParticleTypes;

@EventBusSubscriber
public class LevelUpProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level_up_status) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level <= 14 || entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 20) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.base_damage_by_lvl = entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl + 1;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level >= 15 && entity.getData(PowerModVariables.PLAYER_VARIABLES).level <= 19) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.base_damage_by_lvl = entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl + 2;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 5) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.jump_char = 2;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 5) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.resistance_char = 1;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 10) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.resistance_char = 2;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 20) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.resistance_char = 3;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 5) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.speed_char = 2;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 10) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.speed_char = 3;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 10) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.haste_char = 0;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 15) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.haste_char = 1;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 20) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.haste_char = 2;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level > 20) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.max_level_exp = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.level_exp = 0;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 5) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.rank = "C";
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 10) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.rank = "B";
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 15) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.rank = "A";
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 20) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.rank = "S";
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.theGame().getAdvancements().get(ResourceLocation.parse("power:unbreakable_diamond"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.max_level_exp = 100 * entity.getData(PowerModVariables.PLAYER_VARIABLES).level;
				_vars.syncPlayerVariables(entity);
			}
			particleAmount = 150;
			particleRadius = 2.25;
			for (int index0 = 0; index0 < (int) particleAmount; index0++) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (PowerModParticleTypes.ENERGIUM_GOLEM_CORE_ATTACK_PARTICLE.get()), (x + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * particleRadius),
							(y + 0 + Mth.nextDouble(RandomSource.create(), 0, 5) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * particleRadius), 1, 0, 0, 0, 0.25);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("power:power.level_up")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("power:power.level_up")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 1800, 1, false, false));
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.level_up_status = false;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
