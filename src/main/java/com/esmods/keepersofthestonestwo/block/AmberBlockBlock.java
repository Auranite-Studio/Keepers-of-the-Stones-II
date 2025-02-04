
package com.esmods.keepersofthestonestwo.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class AmberBlockBlock extends Block {
	public AmberBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(6f, 5f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
