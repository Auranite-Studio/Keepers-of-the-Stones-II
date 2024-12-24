package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import java.util.ArrayList;

import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class EntityReturnByCardIDProcedure {
	public static Entity execute(LevelAccessor world) {
		ItemStack save = ItemStack.EMPTY;
		Entity playerGet = null;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
					if (itemstackiterator.getItem() == PowerModItems.CHARACTERISTICS_CARD.get()) {
						save = new ItemStack(PowerModItems.CHARACTERISTICS_CARD.get()).copy();
						if ((entityiterator.getPersistentData().getString("ownerCard")).equals(save.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("owner"))) {
							playerGet = entityiterator;
						}
					}
				}
			}
		}
		return playerGet;
	}
}
