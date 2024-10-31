package com.esmods.keepersofthestonestwo.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class PowerConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Double> MASTER_EFFECT_DURATION;
	public static final ModConfigSpec.ConfigValue<Double> RECHARGE_TIMER;
	static {
		BUILDER.push("basic_settings");
		MASTER_EFFECT_DURATION = BUILDER.comment("Sets the base duration value for the master effect").define("master_effect_duration", (double) 600);
		RECHARGE_TIMER = BUILDER.comment("Sets the recharge time of the stone").define("recharge_timer", (double) 300);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
