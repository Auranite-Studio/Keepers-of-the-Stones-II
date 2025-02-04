
package com.esmods.keepersofthestonestwo.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class CopyriumBlockBlock extends Block {
	public CopyriumBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(5f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
