package com.esmods.keepersofthestonestwo.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class PolishedCursedStoneSlabBlock extends SlabBlock {
	public PolishedCursedStoneSlabBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.TUFF).strength(2.5f, 3f).instrument(NoteBlockInstrument.BASEDRUM));
	}
}