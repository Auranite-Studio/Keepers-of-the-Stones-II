package com.esmods.keepersofthestonestwo.init;

import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.CuriosCapability;

import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

import net.minecraft.world.item.ItemStack;

import com.esmods.keepersofthestonestwo.procedures.*;

public class PowerModCuriosCompat {
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				BlueRune1BaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				BlueRune1BaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, PowerModItems.EXTRA_STAR_POINTS_RUNE_1.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				BlueRune2BaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				BlueRune2BaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, PowerModItems.EXTRA_STAR_POINTS_RUNE_2.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				BlueRune3BaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				BlueRune3BaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, PowerModItems.EXTRA_STAR_POINTS_RUNE_3.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				RedRune1BaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				RedRune1BaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_1.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				RedRune2BaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				RedRune2BaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_2.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				RedRune3BaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				RedRune3BaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_3.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				RedRune4BaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				RedRune4BaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_1.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				RedRune5BaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				RedRune5BaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_2.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				RedRune6BaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				RedRune6BaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_3.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				GreenRune1BaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				GreenRune1BaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, PowerModItems.PROTECTION_RUNE.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				GreenRune2BaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				GreenRune2BaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, PowerModItems.SPIN_RUNE.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				GreenRune3BaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				GreenRune3BaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, PowerModItems.DODGING_RUNE.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				GreenRune4BaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				GreenRune4BaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, PowerModItems.INVISIBILITY_RUNE.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				GreenRune5BaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				GreenRune5BaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, PowerModItems.HEALING_RUNE.get());
	}
}