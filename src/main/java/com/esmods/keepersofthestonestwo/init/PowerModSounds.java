
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import com.esmods.keepersofthestonestwo.PowerMod;

public class PowerModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, PowerMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> STONE_ACTIVATION = REGISTRY.register("stone_activation", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "stone_activation")));
	public static final DeferredHolder<SoundEvent, SoundEvent> STONE_DEACTIVATION = REGISTRY.register("stone_deactivation", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "stone_deactivation")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ELECTRIC_SPARK = REGISTRY.register("electric_spark", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "electric_spark")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EAR_RINGING = REGISTRY.register("ear_ringing", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "ear_ringing")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MAGNETIC_WAVES = REGISTRY.register("magnetic_waves", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "magnetic_waves")));
	public static final DeferredHolder<SoundEvent, SoundEvent> RECORD_CALL_OF_THE_PAST = REGISTRY.register("record.call_of_the_past",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "record.call_of_the_past")));
	public static final DeferredHolder<SoundEvent, SoundEvent> RECORD_ANCIENT_MOOD = REGISTRY.register("record.ancient_mood", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "record.ancient_mood")));
	public static final DeferredHolder<SoundEvent, SoundEvent> TIME_ABILITY_EFFECT = REGISTRY.register("time_ability_effect", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "time_ability_effect")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSKET = REGISTRY.register("musket", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "musket")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CURSED_KNIGHT_ATTACK = REGISTRY.register("cursed_knight.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "cursed_knight.attack")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CURSED_KNIGHT_DEATH = REGISTRY.register("cursed_knight.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "cursed_knight.death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CURSED_KNIGHT_HURT = REGISTRY.register("cursed_knight.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "cursed_knight.hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CURSED_KNIGHT_WALK = REGISTRY.register("cursed_knight.walk", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "cursed_knight.walk")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CURSED_SQUIRE_DEATH = REGISTRY.register("cursed_squire.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "cursed_squire.death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CURSED_SQUIRE_HURT = REGISTRY.register("cursed_squire.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "cursed_squire.hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CURSED_SQUIRE_ATTACK = REGISTRY.register("cursed_squire.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "cursed_squire.attack")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CURSED_SQUIRE_WALK = REGISTRY.register("cursed_squire.walk", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "cursed_squire.walk")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_BIOME_CURSED_FOREST = REGISTRY.register("ambient.biome.cursed_forest",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "ambient.biome.cursed_forest")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_MYSTERY_OF_THE_CURSED_FOREST = REGISTRY.register("music.mystery_of_the_cursed_forest",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("power", "music.mystery_of_the_cursed_forest")));
}
