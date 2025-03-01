package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;
import com.esmods.keepersofthestonestwo.init.PowerModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber (modid = PowerMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ExperimentalTabHandler {
	@SubscribeEvent
	public static void onTabBuild(BuildCreativeModeTabContentsEvent event) {
		ResourceKey<CreativeModeTab> targetTab = ResourceKey.create(
				Registries.CREATIVE_MODE_TAB,
				ResourceLocation.fromNamespaceAndPath("power", "items")
		);
		if (event.getTabKey() == targetTab) {
			runesExpirementsRegistry(event);
		}
	}

	@Deprecated(forRemoval = true, since = "1.2")
	public static void runesExpirementsRegistry(BuildCreativeModeTabContentsEvent event) {
		if (PowerConfigConfiguration.ENABLE_RUNES.get()) {
			event.accept(PowerModItems.RUNE_CUTTER.get());
			event.accept(PowerModItems.EXTRA_STAR_POINTS_RUNE_1.get());
			event.accept(PowerModItems.EXTRA_STAR_POINTS_RUNE_2.get());
			event.accept(PowerModItems.EXTRA_STAR_POINTS_RUNE_3.get());
		}
	}
}