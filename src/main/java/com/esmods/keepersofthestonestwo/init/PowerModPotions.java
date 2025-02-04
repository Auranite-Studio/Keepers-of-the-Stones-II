
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import com.esmods.keepersofthestonestwo.PowerMod;

public class PowerModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, PowerMod.MODID);
	public static final DeferredHolder<Potion, Potion> STAR_REGENERATION_POTION = REGISTRY.register("star_regeneration_potion",
			() -> new Potion("star_regeneration_potion", new MobEffectInstance(PowerModMobEffects.STAR_REGENERATION, 900, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> POWER_LOCK_POTION = REGISTRY.register("power_lock_potion", () -> new Potion("power_lock_potion", new MobEffectInstance(PowerModMobEffects.POWER_LOCK, 3600, 0, false, true)));
}
