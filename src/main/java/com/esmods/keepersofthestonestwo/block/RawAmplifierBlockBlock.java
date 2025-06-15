
package com.esmods.keepersofthestonestwo.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class RawAmplifierBlockBlock extends Block {
	public RawAmplifierBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(6.75f, 5f).lightLevel(s -> 4).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
