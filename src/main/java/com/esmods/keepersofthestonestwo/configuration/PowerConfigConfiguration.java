package com.esmods.keepersofthestonestwo.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class PowerConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> MASTER_EFFECT_DURATION;
	public static final ForgeConfigSpec.ConfigValue<Double> RECHARGE_TIMER;
	static {
		BUILDER.push("basic_settings");
		MASTER_EFFECT_DURATION = BUILDER.comment("Sets the base duration value for the master effect").define("master_effect_duration", (double) 600);
		RECHARGE_TIMER = BUILDER.comment("Sets the recharge time of the stone").define("recharge_timer", (double) 300);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
