package com.esmods.keepersofthestonestwo.mixin;

import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.core.Holder;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;

import com.esmods.keepersofthestonestwo.init.PowerModBiomes;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin implements PowerModBiomes.PowerModNoiseGeneratorSettings {
	@Unique
	private Holder<DimensionType> power_dimensionTypeReference;

	@WrapMethod(method = "surfaceRule")
	public SurfaceRules.RuleSource surfaceRule(Operation<SurfaceRules.RuleSource> original) {
		SurfaceRules.RuleSource retval = original.call();
		if (this.power_dimensionTypeReference != null) {
			retval = PowerModBiomes.adaptSurfaceRule(retval, this.power_dimensionTypeReference);
		}
		return retval;
	}

	@Override
	public void setpowerDimensionTypeReference(Holder<DimensionType> dimensionType) {
		this.power_dimensionTypeReference = dimensionType;
	}
}