package com.esmods.keepersofthestonestwo.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class CopyriumBlockBlock extends Block {
	public CopyriumBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(5f).requiresCorrectToolForDrops());
	}
}