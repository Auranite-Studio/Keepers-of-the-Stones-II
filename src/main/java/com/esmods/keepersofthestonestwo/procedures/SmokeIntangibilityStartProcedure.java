package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class SmokeIntangibilityStartProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
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
		if (entity instanceof LivingEntity _living) {
			_living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
		}
		if (entity instanceof LivingEntity _living) {
			_living.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
		}
		if (entity instanceof LivingEntity _living) {
			_living.setItemSlot(EquipmentSlot.LEGS, ItemStack.EMPTY);
		}
		if (entity instanceof LivingEntity _living) {
			_living.setItemSlot(EquipmentSlot.FEET, ItemStack.EMPTY);
		}
	}
}