package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.Minecraft;

public class CharacteristicsCardDopolnitielnaiaInformatsiiaProcedure {
	public static String execute(LevelAccessor world, ItemStack itemstack) {
		return "\u00A77" + Minecraft.getInstance().level.getPlayerByUUID(java.util.UUID.fromString((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("owner")))).getName().getString();
	}
}
