package com.esmods.keepersofthestonestwo.procedures;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import java.util.List;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;

@EventBusSubscriber
public class ConverterModuleProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (PowerModVariables.MapVariables.get(world).cpapi_ver < new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(getModInfo("cpapi", 0))) {
			PowerModVariables.MapVariables.get(world).cpapi_ver = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(getModInfo("cpapi", 0));
			PowerModVariables.MapVariables.get(world).markSyncDirty();
		}
		if (PowerConfigConfiguration.ENABLE_LEVELS.get() == true) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 0) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.level = 1;
					_vars.resistance_char = 0;
					_vars.jump_char = 1;
					_vars.speed_char = 1;
					_vars.haste_char = -1;
					_vars.markSyncDirty();
				}
				if (entity.getData(PowerModVariables.PLAYER_VARIABLES).max_level_exp == 0) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.max_level_exp = 100;
						_vars.markSyncDirty();
					}
				}
				if (entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl == 0 || entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl == 13.5) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.base_damage_by_lvl = 6;
						_vars.markSyncDirty();
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.rank = "D";
					_vars.markSyncDirty();
				}
			}
		} else {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl != 13.5) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.base_damage_by_lvl = 13.5;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level != 0) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.level = 0;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp != 0) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.level_exp = 0;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).max_level_exp != 0) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.max_level_exp = 0;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).resistance_char != 2) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.resistance_char = 2;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).speed_char != 2) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.speed_char = 2;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).jump_char != 2) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.jump_char = 2;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).haste_char != -1) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.haste_char = -1;
					_vars.markSyncDirty();
				}
			}
			if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).rank).equals("0")) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.rank = "0";
					_vars.markSyncDirty();
				}
			}
		}
	}

	public static String getModInfo(String modid, int type) {
		String val = "";
		List<IModInfo> mods = ModList.get().getMods();
		for (IModInfo mod : mods) {
			if (mod.getModId().equals(modid.toLowerCase())) {
				if (type == 0) {
					val = mod.getVersion().toString();
				} else {
					val = mod.getDisplayName();
				}
				break;
			}
		}
		return val;
	}
}