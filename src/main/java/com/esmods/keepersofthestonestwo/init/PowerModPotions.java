
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import com.esmods.keepersofthestonestwo.PowerMod;

public class PowerModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, PowerMod.MODID);
	public static final RegistryObject<Potion> STAR_REGENERATION_POTION = REGISTRY.register("star_regeneration_potion", () -> new Potion(new MobEffectInstance(PowerModMobEffects.STAR_REGENERATION.get(), 900, 0, false, true)));
	public static final RegistryObject<Potion> POWER_LOCK_POTION = REGISTRY.register("power_lock_potion", () -> new Potion(new MobEffectInstance(PowerModMobEffects.POWER_LOCK.get(), 3600, 0, false, true)));
}
