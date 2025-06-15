package com.esmods.keepersofthestonestwo.item;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

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

import com.esmods.keepersofthestonestwo.procedures.RemoveForbiddenItemProcedure;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TechnoPickaxeItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 0, 12f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("power:techno_pickaxe_repair_items")));

	public TechnoPickaxeItem(Item.Properties properties) {
		super(properties.pickaxe(TOOL_MATERIAL, 8.9f, -2.56f).fireResistant());
	}

	@SubscribeEvent
	public static void handleToolDamage(ModifyDefaultComponentsEvent event) {
		event.modify(PowerModItems.TECHNO_PICKAXE.get(), builder -> builder.remove(DataComponents.MAX_DAMAGE));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, EquipmentSlot slot) {
		super.inventoryTick(itemstack, world, entity, slot);
		RemoveForbiddenItemProcedure.execute(entity, itemstack);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}