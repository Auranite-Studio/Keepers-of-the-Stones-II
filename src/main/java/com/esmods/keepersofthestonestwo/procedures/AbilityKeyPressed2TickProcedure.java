package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

@EventBusSubscriber
public class AbilityKeyPressed2TickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).use_ability_key_var) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).ability_block == false && !(getEntityGameType(entity) == GameType.SPECTATOR)) {
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("rune_ability")) {
					RuneAbilitiesUsingProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("heat") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("heat")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("heat") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("heat")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("heat") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("heat")) {
					HeatSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("shockwave") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("shockwave")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("shockwave") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("shockwave")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("shockwave") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("shockwave")) {
					ShockwaveSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}
