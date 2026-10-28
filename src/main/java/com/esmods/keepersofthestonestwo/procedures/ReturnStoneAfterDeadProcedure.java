package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber
public class ReturnStoneAfterDeadProcedure {
	/**
	 * Maps element names to their corresponding stone DeferredItem suppliers.
	 * When a new element is added, just add one line here — no need to touch the logic.
	 */
	private static final Map<String, Supplier<net.neoforged.neoforge.registries.DeferredItem<? extends net.minecraft.world.item.Item>>> ELEMENT_STONES;
	static {
		Map<String, Supplier<net.neoforged.neoforge.registries.DeferredItem<? extends net.minecraft.world.item.Item>>> m = new java.util.HashMap<>();
		m.put("fire", () -> PowerModItems.FIRE_STONE);
		ELEMENT_STONES = Map.copyOf(m);
	}

	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event.getEntity());
	}

	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.fake_element_name_first = "0";
				_vars.fake_element_name_second = "0";
				_vars.fake_element_name_third = "0";
				_vars.transfered_power = false;
				_vars.markSyncDirty();
			}
			if (!entity.getData(PowerModVariables.PLAYER_VARIABLES).active_battery) {
				if (entity instanceof Player || entity instanceof ServerPlayer) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.level_exp = entity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp - Math.round(entity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp * 0.25);
						_vars.markSyncDirty();
					}
				}
				// Return stones for all three element slots using the map
				returnStonesForSlot(entity, "element_name_first");
				returnStonesForSlot(entity, "element_name_second");
				returnStonesForSlot(entity, "element_name_third");
			} else {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.active_battery = false;
					_vars.markSyncDirty();
				}
			}
		}
	}

	/**
	 * Checks if any of the three element slots contains the given element name,
	 * resets it, and gives the corresponding stone to the player.
	 */
	private static void returnStonesForSlot(Entity entity, String slotVarName) {
		String element = getElementValue(entity, slotVarName);
		if (element == null || element.equals("0"))
			return;

		Supplier<?> stoneSupplier = ELEMENT_STONES.get(element);
		if (stoneSupplier == null) {
			PowerMod.LOGGER.warn("Unknown element '{}' in slot '{}', cannot return stone", element, slotVarName);
			return;
		}

		// Reset the slot
		setElementValue(entity, slotVarName, "0");

		// Give the stone
		if (entity instanceof Player _player) {
			Supplier<net.neoforged.neoforge.registries.DeferredItem<? extends net.minecraft.world.item.Item>> supplier = (Supplier<net.neoforged.neoforge.registries.DeferredItem<? extends net.minecraft.world.item.Item>>) (Supplier<?>) stoneSupplier;
			ItemStack _setstack = new ItemStack(supplier.get().get()).copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}

	/**
	 * Reads the value of an element slot variable by name.
	 * Supports: element_name_first, element_name_second, element_name_third
	 */
	private static String getElementValue(Entity entity, String slotVarName) {
		PowerModVariables.PlayerVariables vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
		return switch (slotVarName) {
			case "element_name_first" -> vars.element_name_first;
			case "element_name_second" -> vars.element_name_second;
			case "element_name_third" -> vars.element_name_third;
			default -> null;
		};
	}

	/**
	 * Sets the value of an element slot variable by name.
	 * Supports: element_name_first, element_name_second, element_name_third
	 */
	private static void setElementValue(Entity entity, String slotVarName, String value) {
		PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
		switch (slotVarName) {
			case "element_name_first" -> _vars.element_name_first = value;
			case "element_name_second" -> _vars.element_name_second = value;
			case "element_name_third" -> _vars.element_name_third = value;
		}
		_vars.markSyncDirty();
	}
}
