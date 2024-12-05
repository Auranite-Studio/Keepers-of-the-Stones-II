
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import com.esmods.keepersofthestonestwo.PowerMod;

public class PowerModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PowerMod.MODID);
	public static final RegistryObject<SoundEvent> STONE_ACTIVATION = REGISTRY.register("stone_activation", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "stone_activation")));
	public static final RegistryObject<SoundEvent> STONE_DEACTIVATION = REGISTRY.register("stone_deactivation", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "stone_deactivation")));
	public static final RegistryObject<SoundEvent> ELECTRIC_SPARK = REGISTRY.register("electric_spark", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "electric_spark")));
	public static final RegistryObject<SoundEvent> EAR_RINGING = REGISTRY.register("ear_ringing", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "ear_ringing")));
	public static final RegistryObject<SoundEvent> MAGNETIC_WAVES = REGISTRY.register("magnetic_waves", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "magnetic_waves")));
	public static final RegistryObject<SoundEvent> RECORD_CALL_OF_THE_PAST = REGISTRY.register("record.call_of_the_past", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "record.call_of_the_past")));
	public static final RegistryObject<SoundEvent> RECORD_ANCIENT_MOOD = REGISTRY.register("record.ancient_mood", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "record.ancient_mood")));
	public static final RegistryObject<SoundEvent> TIME_ABILITY_EFFECT = REGISTRY.register("time_ability_effect", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "time_ability_effect")));
	public static final RegistryObject<SoundEvent> MUSKET = REGISTRY.register("musket", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "musket")));
	public static final RegistryObject<SoundEvent> CURSED_KNIGHT_ATTACK = REGISTRY.register("cursed_knight.attack", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "cursed_knight.attack")));
	public static final RegistryObject<SoundEvent> CURSED_KNIGHT_DEATH = REGISTRY.register("cursed_knight.death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "cursed_knight.death")));
	public static final RegistryObject<SoundEvent> CURSED_KNIGHT_HURT = REGISTRY.register("cursed_knight.hurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "cursed_knight.hurt")));
	public static final RegistryObject<SoundEvent> CURSED_KNIGHT_WALK = REGISTRY.register("cursed_knight.walk", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "cursed_knight.walk")));
	public static final RegistryObject<SoundEvent> CURSED_SQUIRE_DEATH = REGISTRY.register("cursed_squire.death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "cursed_squire.death")));
	public static final RegistryObject<SoundEvent> CURSED_SQUIRE_HURT = REGISTRY.register("cursed_squire.hurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "cursed_squire.hurt")));
	public static final RegistryObject<SoundEvent> CURSED_SQUIRE_ATTACK = REGISTRY.register("cursed_squire.attack", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "cursed_squire.attack")));
	public static final RegistryObject<SoundEvent> CURSED_SQUIRE_WALK = REGISTRY.register("cursed_squire.walk", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "cursed_squire.walk")));
	public static final RegistryObject<SoundEvent> AMBIENT_BIOME_CURSED_FOREST = REGISTRY.register("ambient.biome.cursed_forest", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "ambient.biome.cursed_forest")));
	public static final RegistryObject<SoundEvent> MUSIC_MYSTERY_OF_THE_CURSED_FOREST = REGISTRY.register("music.mystery_of_the_cursed_forest",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "music.mystery_of_the_cursed_forest")));
	public static final RegistryObject<SoundEvent> ELECTRICITY = REGISTRY.register("electricity", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("power", "electricity")));
}
