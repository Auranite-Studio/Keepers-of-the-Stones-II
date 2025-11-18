package com.esmods.keepersofthestonestwo.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

public class TearsFlowerBlock extends FlowerBlock {
	public TearsFlowerBlock() {
		super(PowerModMobEffects.WARP, 100, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.GRASS).instabreak().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).noCollission()
				.offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}
}