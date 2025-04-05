package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class SmokeIntangibilityEndProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _entity = entity;
			if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.HEAD, entity.getData(PowerModVariables.PLAYER_VARIABLES).helmet);
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.CHEST, entity.getData(PowerModVariables.PLAYER_VARIABLES).chestplate);
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.LEGS, entity.getData(PowerModVariables.PLAYER_VARIABLES).leggings);
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.FEET, entity.getData(PowerModVariables.PLAYER_VARIABLES).boots);
			}
		}
	}
}
