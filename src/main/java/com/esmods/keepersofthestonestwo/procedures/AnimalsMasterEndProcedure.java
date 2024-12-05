package com.esmods.keepersofthestonestwo.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class AnimalsMasterEndProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("power:stone_deactivation")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("power:stone_deactivation")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
		DetransformationKeyUseProcedure.execute(world, entity);
		if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).element_name_first).equals("animals")) {
			{
				String _setval = "0";
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.element_name_first = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).element_name_second).equals("animals")) {
			{
				String _setval = "0";
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.element_name_second = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).element_name_third).equals("animals")) {
			{
				String _setval = "0";
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.element_name_third = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).active_battery == false) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerModItems.ANIMALS_STONE.get());
				_setstack.setCount(1);
				_setstack.getOrCreateTag().putDouble("rechargeStone", (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) ? PowerModVariables.recharge_timer * 20 : 0));
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else {
			{
				boolean _setval = false;
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.active_battery = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
