package com.esmods.keepersofthestonestwo.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class AmberBlockBlock extends Block {
	public AmberBlockBlock() {
		super(BlockBehaviour.Properties.of().strength(6f, 5f).instrument(NoteBlockInstrument.BASEDRUM));
	}
}