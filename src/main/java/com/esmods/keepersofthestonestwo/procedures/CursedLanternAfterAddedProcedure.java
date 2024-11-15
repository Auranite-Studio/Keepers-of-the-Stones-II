package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class CursedLanternAfterAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).isFaceSturdy(world, BlockPos.containing(x, y + 1, z), Direction.DOWN)
				^ (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:fences")))) {
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if (world.getBlockState(BlockPos.containing(x, y - 1, z)).isFaceSturdy(world, BlockPos.containing(x, y - 1, z), Direction.UP)
				^ (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:fences")))) {
			{
				int _value = 1;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
	}
}
