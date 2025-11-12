/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.registries.Registries;

import com.esmods.keepersofthestonestwo.world.features.EnergiumVeinFeature;
import com.esmods.keepersofthestonestwo.PowerMod;

public class PowerModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, PowerMod.MODID);
	public static final DeferredHolder<Feature<?>, Feature<?>> ENERGIUM_VEIN = REGISTRY.register("energium_vein", EnergiumVeinFeature::new);
}