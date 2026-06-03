package com.esmods.keepersofthestonestwo.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class AmplifierOreBlock extends Block {
	public AmplifierOreBlock() {
		super(BlockBehaviour.Properties.of().strength(6.75f, 5f).lightLevel(blockstate -> 2).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}