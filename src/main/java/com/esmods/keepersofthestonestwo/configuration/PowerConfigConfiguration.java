package com.esmods.keepersofthestonestwo.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class PowerConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Boolean> MASTER_EFFECTS_CONTROL_BY_CONFIG;
	public static final ModConfigSpec.ConfigValue<Double> MASTER_EFFECT_DURATION;
	public static final ModConfigSpec.ConfigValue<Double> RECHARGE_TIMER;
	public static final ModConfigSpec.ConfigValue<Boolean> ENABLE_LEVELS;
	static {
		MASTER_EFFECTS_CONTROL_BY_CONFIG = BUILDER.define("master_effects_control_by_config", false);
		BUILDER.push("stones_settings");
		MASTER_EFFECT_DURATION = BUILDER.comment("Sets the base duration value for the master effect").define("master_effect_duration", (double) 600);
		RECHARGE_TIMER = BUILDER.comment("Sets the recharge time of the stone").define("recharge_timer", (double) 300);
		BUILDER.pop();
		BUILDER.push("additional_features");
		ENABLE_LEVELS = BUILDER.comment("Enables and disables the level system").define("enable_levels", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
