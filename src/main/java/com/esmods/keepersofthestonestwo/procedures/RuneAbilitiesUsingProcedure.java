package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.util.ARGB;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.DustParticleOptions;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class RuneAbilitiesUsingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == PowerModItems.PROTECTION_RUNE.get()) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 90) {
				if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(PowerModMobEffects.TECHNOBARRIER))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PowerModMobEffects.PROTECTION, 600, 0, false, false));
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 90;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == PowerModItems.SPIN_RUNE.get()) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 90) {
				if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(PowerModMobEffects.SPIN))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PowerModMobEffects.SPIN, 600, 0, false, false));
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 90;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == PowerModItems.DODGING_RUNE.get()) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 90) {
				if (!(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(PowerModMobEffects.DODGING))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PowerModMobEffects.DODGING, 200, 0, false, false));
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 90;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == PowerModItems.INVISIBILITY_RUNE.get()) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 90) {
				if (entity instanceof Player && entity.getData(PowerModVariables.PLAYER_VARIABLES).ability_using == false) {
					particleAmount = 8;
					particleRadius = 2;
					for (int index0 = 0; index0 < 60; index0++) {
						for (int index1 = 0; index1 < (int) particleAmount; index1++) {
							if (world instanceof ServerLevel)
								((ServerLevel) world).sendParticles((new DustParticleOptions(ARGB.color(0, 255, 0), 1)), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
										(y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 1, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
										(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 1);
						}
					}
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.helmet = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy();
						_vars.syncPlayerVariables(entity);
					}
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.chestplate = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy();
						_vars.syncPlayerVariables(entity);
					}
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.leggings = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy();
						_vars.syncPlayerVariables(entity);
					}
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.boots = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy();
						_vars.syncPlayerVariables(entity);
					}
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(3, ItemStack.EMPTY);
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
						}
					}
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(2, ItemStack.EMPTY);
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
						}
					}
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(1, ItemStack.EMPTY);
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.LEGS, ItemStack.EMPTY);
						}
					}
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(0, ItemStack.EMPTY);
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.FEET, ItemStack.EMPTY);
						}
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 600, 3, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.abilities_timer = 600;
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.ability_using = true;
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 90;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == PowerModItems.HEALING_RUNE.get()) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 90) {
				particleAmount = 8;
				particleRadius = 2;
				for (int index2 = 0; index2 < 60; index2++) {
					for (int index3 = 0; index3 < (int) particleAmount; index3++) {
						if (world instanceof ServerLevel)
							((ServerLevel) world).sendParticles((new DustParticleOptions(ARGB.color(0, 255, 0), 1)), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
									(y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 1, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
									(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 1);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 4, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 90;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}