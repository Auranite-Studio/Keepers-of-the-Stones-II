package com.esmods.keepersofthestonestwo.init;

import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.bus.api.IEventBus;

import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;

public class PowerModConfigs {
	public static void register(IEventBus bus, ModContainer modContainer) {
		modContainer.registerConfig(ModConfig.Type.COMMON, PowerConfigConfiguration.SPEC, "power_config.toml");
	}
}
