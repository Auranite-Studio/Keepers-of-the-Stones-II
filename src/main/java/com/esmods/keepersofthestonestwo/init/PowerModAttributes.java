
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.core.registries.BuiltInRegistries;

import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PowerModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, PowerMod.MODID);
	public static final DeferredHolder<Attribute, Attribute> ICE_LAYER = REGISTRY.register("ice_layer", () -> new RangedAttribute("attribute.power.ice_layer", 0, 0, 1).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> AMBER_LAYER = REGISTRY.register("amber_layer", () -> new RangedAttribute("attribute.power.amber_layer", 0, 0, 1).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.getTypes().forEach(entity -> event.add(entity, ICE_LAYER));
		event.getTypes().forEach(entity -> event.add(entity, AMBER_LAYER));
	}
}
