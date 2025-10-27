package com.esmods.keepersofthestonestwo.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class PolishedCursedStoneWallBlock extends WallBlock {
	public PolishedCursedStoneWallBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.TUFF).strength(2.5f, 3f).instrument(NoteBlockInstrument.BASEDRUM).forceSolidOn());
	}
}