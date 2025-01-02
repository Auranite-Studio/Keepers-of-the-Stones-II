
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PowerModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> LIMITED_NUMBER_OF_STONES = GameRules.register("limitedNumberOfStones", GameRules.Category.DROPS, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> LIMIT_OF_STONES_FOR_ONE_PLAYER = GameRules.register("limitOfStonesForOnePlayer", GameRules.Category.DROPS, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> CHOICE_STONE_WHEN_ENTER_THE_WORLD = GameRules.register("choiceStoneWhenEnterTheWorld", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
}
