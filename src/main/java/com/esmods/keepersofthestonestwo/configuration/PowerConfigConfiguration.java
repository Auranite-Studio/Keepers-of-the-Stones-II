package com.esmods.keepersofthestonestwo.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class PowerConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Boolean> FIRST_JOIN_STONES_DISTRIBUTION;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ONE_PLAYER_LIMIT_STONES;
	public static final ForgeConfigSpec.ConfigValue<Boolean> LIMIT_NUMBER_STONES;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_LEVELS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_RUNES;
	static {
		BUILDER.push("stone_distribution_settings");
		FIRST_JOIN_STONES_DISTRIBUTION = BUILDER.comment("Allows players to select a stone when entering the world").define("first_join_stones_distribution", false);
		ONE_PLAYER_LIMIT_STONES = BUILDER.comment("Enables the One Player, one Power mode").define("one_player_limit_stones", true);
		LIMIT_NUMBER_STONES = BUILDER.comment("Limits the number of stones to receive and includes their uniqueness").define("limit_number_stones", true);
		BUILDER.pop();
		BUILDER.push("additional_features");
		ENABLE_LEVELS = BUILDER.comment("Enables and disables the level system").define("enable_levels", true);
		BUILDER.pop();
		BUILDER.push("experimental_features");
		ENABLE_RUNES = BUILDER.comment("Enables and disables the runes (1.2)").define("enable_runes", false);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
