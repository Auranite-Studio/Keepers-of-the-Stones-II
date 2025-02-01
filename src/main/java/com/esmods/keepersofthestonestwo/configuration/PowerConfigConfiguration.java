package com.esmods.keepersofthestonestwo.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class PowerConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;

	public static final ModConfigSpec.ConfigValue<Boolean> FIRST_JOIN_STONES_DISTRIBUTION;
	public static final ModConfigSpec.ConfigValue<Boolean> ONE_PLAYER_LIMIT_STONES;
	public static final ModConfigSpec.ConfigValue<Boolean> LIMIT_NUMBER_STONES;
	public static final ModConfigSpec.ConfigValue<Boolean> ENABLE_LEVELS;
	static {
		BUILDER.push("stone_distribution_settings");
		FIRST_JOIN_STONES_DISTRIBUTION = BUILDER.comment("Allows players to select a stone when entering the world").define("first_join_stones_distribution", true);
		ONE_PLAYER_LIMIT_STONES = BUILDER.comment("Enables the One Player, one Power mode").define("one_player_limit_stones", true);
		LIMIT_NUMBER_STONES = BUILDER.comment("Limits the number of stones to receive and includes their uniqueness").define("limit_number_stones", true);
		BUILDER.pop();
		BUILDER.push("additional_features");
		ENABLE_LEVELS = BUILDER.comment("Enables and disables the level system").define("enable_levels", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
