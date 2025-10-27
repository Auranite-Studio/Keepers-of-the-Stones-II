package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.PowerMod;

public class ElementalPowerGeneratorSaveElementalPowerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).active_battery == false) {
			if (entity.isShiftKeyDown()) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("0")) {
					PowerMod.queueServerWork(1, () -> {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putString("powerRecorded", entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					});
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.beacon.activate")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.beacon.activate")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					{
						int _value = 1;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("power:grant_your_power"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				} else {
					PowerMod.queueServerWork(1, () -> {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putString("powerRecorded", "0");
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					});
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					{
						int _value = 0;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				}
			} else {
				if (!(getBlockNBTString(world, BlockPos.containing(x, y, z), "powerRecorded")).equals("0")) {
					if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
						if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(getBlockNBTString(world, BlockPos.containing(x, y, z), "powerRecorded"))
								&& !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(getBlockNBTString(world, BlockPos.containing(x, y, z), "powerRecorded"))) {
							if (entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power == false && entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first_timer == 0) {
								{
									PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
									_vars.fake_element_name_first = getBlockNBTString(world, BlockPos.containing(x, y, z), "powerRecorded");
									_vars.markSyncDirty();
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.beacon.power_select")), SoundSource.BLOCKS, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.beacon.power_select")), SoundSource.BLOCKS, 1, 1, false);
									}
								}
								{
									PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
									_vars.fake_element_name_first_timer = (entity.getData(PowerModVariables.PLAYER_VARIABLES).master_effect_duration / 4) * 20;
									_vars.power_recorded = true;
									_vars.power = 100;
									_vars.markSyncDirty();
								}
							}
						}
					} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
						if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(getBlockNBTString(world, BlockPos.containing(x, y, z), "powerRecorded"))
								&& !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(getBlockNBTString(world, BlockPos.containing(x, y, z), "powerRecorded"))) {
							if (entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power == false && entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second_timer == 0) {
								{
									PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
									_vars.fake_element_name_second = getBlockNBTString(world, BlockPos.containing(x, y, z), "powerRecorded");
									_vars.markSyncDirty();
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.beacon.power_select")), SoundSource.BLOCKS, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.beacon.power_select")), SoundSource.BLOCKS, 1, 1, false);
									}
								}
								{
									PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
									_vars.fake_element_name_second_timer = (entity.getData(PowerModVariables.PLAYER_VARIABLES).master_effect_duration / 4) * 20;
									_vars.power_recorded = true;
									_vars.power = 100;
									_vars.markSyncDirty();
								}
							}
						}
					} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
							&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
						if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(getBlockNBTString(world, BlockPos.containing(x, y, z), "powerRecorded"))
								&& !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(getBlockNBTString(world, BlockPos.containing(x, y, z), "powerRecorded"))) {
							if (entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power == false && entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third_timer == 0) {
								{
									PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
									_vars.fake_element_name_third = getBlockNBTString(world, BlockPos.containing(x, y, z), "powerRecorded");
									_vars.markSyncDirty();
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.beacon.power_select")), SoundSource.BLOCKS, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.beacon.power_select")), SoundSource.BLOCKS, 1, 1, false);
									}
								}
								{
									PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
									_vars.fake_element_name_third_timer = (entity.getData(PowerModVariables.PLAYER_VARIABLES).master_effect_duration / 4) * 20;
									_vars.power_recorded = true;
									_vars.power = 100;
									_vars.markSyncDirty();
								}
							}
						}
					}
				}
			}
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getStringOr(tag, "");
		return "";
	}
}