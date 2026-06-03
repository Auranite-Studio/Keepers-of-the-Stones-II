package com.esmods.keepersofthestonestwo.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class AmplifierBlockBlock extends Block {
	public AmplifierBlockBlock() {
		super(BlockBehaviour.Properties.of().strength(6.75f, 5f).lightLevel(blockstate -> 6).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}