package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import com.esmods.keepersofthestonestwo.init.PowerModBlocks;

public class PurpleMushroomUsloviieRazmieshchieniiaBlokaProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == PowerModBlocks.PURPLE_MUSHROOM.get()) && world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude();
	}
}
