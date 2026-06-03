package com.esmods.keepersofthestonestwo.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class DepletedEnergiumBlockBlock extends Block {
	public DepletedEnergiumBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(6.75f, 5f).requiresCorrectToolForDrops());
	}
}