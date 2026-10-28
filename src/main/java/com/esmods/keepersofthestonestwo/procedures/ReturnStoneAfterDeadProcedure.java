package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

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
		m.put("fire", () -> PowerModItems.FIRE_STONE.get());
		m.put("air", () -> PowerModItems.AIR_STONE.get());
		m.put("earth", () -> PowerModItems.EARTH_STONE.get());
		m.put("water", () -> PowerModItems.WATER_STONE.get());
		m.put("ether", () -> PowerModItems.ETHER_STONE.get());
		m.put("ice", () -> PowerModItems.ICE_STONE.get());
		m.put("lightning", () -> PowerModItems.LIGHTNING_STONE.get());
		m.put("sound", () -> PowerModItems.SOUND_STONE.get());
		m.put("crystal", () -> PowerModItems.CRYSTAL_STONE.get());
		m.put("lava", () -> PowerModItems.LAVA_STONE.get());
		m.put("rain", () -> PowerModItems.RAIN_STONE.get());
		m.put("tornado", () -> PowerModItems.TORNADO_STONE.get());
		m.put("ocean", () -> PowerModItems.OCEAN_STONE.get());
		m.put("plants", () -> PowerModItems.PLANTS_STONE.get());
		m.put("animals", () -> PowerModItems.ANIMALS_STONE.get());
		m.put("metal", () -> PowerModItems.METAL_STONE.get());
		m.put("light", () -> PowerModItems.LIGHT_STONE.get());
		m.put("shadow", () -> PowerModItems.SHADOW_STONE.get());
		m.put("vacuum", () -> PowerModItems.VACUUM_STONE.get());
		m.put("energy", () -> PowerModItems.ENERGY_STONE.get());
		m.put("sun", () -> PowerModItems.SUN_STONE.get());
		m.put("moon", () -> PowerModItems.MOON_STONE.get());
		m.put("space", () -> PowerModItems.SPACE_STONE.get());
		m.put("time", () -> PowerModItems.TIME_STONE.get());
		m.put("blood", () -> PowerModItems.BLOOD_STONE.get());
		m.put("technology", () -> PowerModItems.TECHNOLOGY_STONE.get());
		m.put("teleportation", () -> PowerModItems.TELEPORTATION_STONE.get());
		m.put("explosion", () -> PowerModItems.EXPLOSION_STONE.get());
		m.put("amber", () -> PowerModItems.AMBER_STONE.get());
		m.put("creation", () -> PowerModItems.CREATION_STONE.get());
		m.put("destruction", () -> PowerModItems.DESTRUCTION_STONE.get());
		m.put("mist", () -> PowerModItems.MIST_STONE.get());
		m.put("sand", () -> PowerModItems.SAND_STONE.get());
		m.put("speed", () -> PowerModItems.SPEED_STONE.get());
		m.put("poison", () -> PowerModItems.POISON_STONE.get());
		m.put("magnet", () -> PowerModItems.MAGNET_STONE.get());
		m.put("mushrooms", () -> PowerModItems.MUSHROOMS_STONE.get());
		m.put("mercury", () -> PowerModItems.MERCURY_STONE.get());
		m.put("music", () -> PowerModItems.MUSIC_STONE.get());
		m.put("plague", () -> PowerModItems.PLAGUE_STONE.get());
		m.put("blue_flame", () -> PowerModItems.BLUE_FLAME_STONE.get());
		m.put("gravity", () -> PowerModItems.GRAVITY_STONE.get());
		m.put("smoke", () -> PowerModItems.SMOKE_STONE.get());
		m.put("spirit", () -> PowerModItems.SPIRIT_STONE.get());
		m.put("form", () -> PowerModItems.FORM_STONE.get());
		m.put("mind", () -> PowerModItems.MIND_STONE.get());
		m.put("golden_dust", () -> PowerModItems.GOLDEN_DUST_STONE.get());
		m.put("darkness", () -> PowerModItems.DARKNESS_STONE.get());
		m.put("heat", () -> PowerModItems.HEAT_STONE.get());
		m.put("shockwave", () -> PowerModItems.SHOCKWAVE_STONE.get());
		m.put("colors", () -> PowerModItems.COLORS_STONE.get());
		ELEMENT_STONES = Map.copyOf(m);
	}

	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
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
