package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class RuneCutterPriObnovlieniiTikaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_1.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_1.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_2.get()).copy();
				_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1));
				_itemHandlerModifiable.setStackInSlot(2, _setstack);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("validRecipe", true);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_2.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_2.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_3.get()).copy();
				_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1));
				_itemHandlerModifiable.setStackInSlot(2, _setstack);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("validRecipe", true);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_1.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_1.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_2.get()).copy();
				_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1));
				_itemHandlerModifiable.setStackInSlot(2, _setstack);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("validRecipe", true);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_2.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_2.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_3.get()).copy();
				_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1));
				_itemHandlerModifiable.setStackInSlot(2, _setstack);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("validRecipe", true);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_1.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_1.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_2.get()).copy();
				_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1));
				_itemHandlerModifiable.setStackInSlot(2, _setstack);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("validRecipe", true);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_2.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_2.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_3.get()).copy();
				_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1));
				_itemHandlerModifiable.setStackInSlot(2, _setstack);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("validRecipe", true);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem())) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 2;
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

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}
