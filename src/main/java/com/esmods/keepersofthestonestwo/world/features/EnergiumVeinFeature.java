package com.esmods.keepersofthestonestwo.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.DeltaFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.DeltaFeature;
import net.minecraft.world.level.WorldGenLevel;

import com.esmods.keepersofthestonestwo.procedures.EnergiumVeinDopolnitielnoieUsloviieGienieratsiiProcedure;

public class EnergiumVeinFeature extends DeltaFeature {
	public EnergiumVeinFeature() {
		super(DeltaFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<DeltaFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!EnergiumVeinDopolnitielnoieUsloviieGienieratsiiProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}