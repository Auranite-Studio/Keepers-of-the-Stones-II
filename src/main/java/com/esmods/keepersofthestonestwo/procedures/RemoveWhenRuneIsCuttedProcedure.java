package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class RemoveWhenRuneIsCuttedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
			int _slotid = 0;
			ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
			_stk.shrink(1);
			_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
		}
		if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
			int _slotid = 1;
			ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
			_stk.shrink(1);
			_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putBoolean("validRecipe", false);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}