package com.esmods.keepersofthestonestwo.item;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.procedures.RemoveForbiddenItemProcedure;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

@EventBusSubscriber
public class LightningFalchionItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 0, 12f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("power:lightning_falchion_repair_items")));

	public LightningFalchionItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 5.3f, -1.92f).fireResistant());
	}

	@SubscribeEvent
	public static void handleToolDamage(ModifyDefaultComponentsEvent event) {
		event.modify(PowerModItems.LIGHTNING_FALCHION.get(), builder -> builder.remove(DataComponents.MAX_DAMAGE));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		RemoveForbiddenItemProcedure.execute(world, entity, itemstack);
	}

	@Override
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}