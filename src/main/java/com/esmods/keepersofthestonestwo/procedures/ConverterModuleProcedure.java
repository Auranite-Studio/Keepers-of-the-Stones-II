package com.esmods.keepersofthestonestwo.procedures;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import javax.annotation.Nullable;

import java.util.List;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

@EventBusSubscriber
public class ConverterModuleProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (PowerModVariables.MapVariables.get(world).cpapi_ver < new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(new Object() {
			String getValue(String modid) {
				String val = "";
				List<IModInfo> mods = ModList.get().getMods();
				for (IModInfo mod : mods) {
					if (mod.getModId().equals(modid.toLowerCase())) {
						val = mod.getVersion().toString();
						break;
					}
				}
				return val;
			}
		}.getValue("cpapi"))) {
			PowerModVariables.MapVariables.get(world).cpapi_ver = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(new Object() {
				String getValue(String modid) {
					String val = "";
					List<IModInfo> mods = ModList.get().getMods();
					for (IModInfo mod : mods) {
						if (mod.getModId().equals(modid.toLowerCase())) {
							val = mod.getVersion().toString();
							break;
						}
					}
					return val;
				}
			}.getValue("cpapi"));
			PowerModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
