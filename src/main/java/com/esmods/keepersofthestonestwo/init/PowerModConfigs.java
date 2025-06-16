package com.esmods.keepersofthestonestwo.init;

import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;

import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber(modid = PowerMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class PowerModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModList.get().getModContainerById("power").get().registerConfig(ModConfig.Type.COMMON, PowerConfigConfiguration.SPEC, "power_config.toml");
		});
	}
}