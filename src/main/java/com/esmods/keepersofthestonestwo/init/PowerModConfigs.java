package com.esmods.keepersofthestonestwo.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;
import com.esmods.keepersofthestonestwo.PowerMod;

@Mod.EventBusSubscriber(modid = PowerMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PowerModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PowerConfigConfiguration.SPEC, "power_config.toml");
		});
	}
}
