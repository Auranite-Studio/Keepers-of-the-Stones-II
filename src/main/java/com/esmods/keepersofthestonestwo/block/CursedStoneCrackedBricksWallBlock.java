
package com.esmods.keepersofthestonestwo.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class CursedStoneCrackedBricksWallBlock extends WallBlock {
	public CursedStoneCrackedBricksWallBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.TUFF).strength(2.5f, 3f).dynamicShape().instrument(NoteBlockInstrument.BASEDRUM).forceSolidOn());
	}
}
