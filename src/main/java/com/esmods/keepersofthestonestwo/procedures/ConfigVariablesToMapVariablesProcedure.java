package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ConfigVariablesToMapVariablesProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		PowerModVariables.master_effect_duration = (double) PowerConfigConfiguration.MASTER_EFFECT_DURATION.get();
		PowerModVariables.recharge_timer = (double) PowerConfigConfiguration.RECHARGE_TIMER.get();
	}
}
