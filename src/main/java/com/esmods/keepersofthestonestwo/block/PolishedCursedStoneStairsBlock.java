
package com.esmods.keepersofthestonestwo.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class PolishedCursedStoneStairsBlock extends StairBlock {
	public PolishedCursedStoneStairsBlock(BlockBehaviour.Properties properties) {
		super(Blocks.AIR.defaultBlockState(), properties.instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(2.5f, 3f).dynamicShape());
	}

	@Override
	public float getExplosionResistance() {
		return 3f;
	}
}
