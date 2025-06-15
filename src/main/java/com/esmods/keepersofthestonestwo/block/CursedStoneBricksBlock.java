package com.esmods.keepersofthestonestwo.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class CursedStoneBricksBlock extends Block {
	public CursedStoneBricksBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.TUFF).strength(2.5f, 3f).instrument(NoteBlockInstrument.BASEDRUM));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}