package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import java.util.Comparator;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class BlueMagnetPriObnovlieniiTikaSushchnostiProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double itemPosZ = 0;
		double itemPosY = 0;
		double itemPosX = 0;
		double playerPosY = 0;
		double playerPosZ = 0;
		double playerPosX = 0;
		playerPosX = entity.getX();
		playerPosY = entity.getY();
		playerPosZ = entity.getZ();
		if (entity.getPersistentData().getDouble("time") > 0) {
			entity.getPersistentData().putDouble("time", (entity.getPersistentData().getDouble("time") - 1));
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		{
			final Vec3 _center = new Vec3(playerPosX, playerPosY, playerPosZ);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (!((entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("magnet") || (entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("magnet")
						|| (entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("magnet") || (entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("magnet")
						|| (entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("magnet") || (entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("magnet"))) {
					if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("power:magnetic_entity")))) {
						if (entityiterator instanceof Mob || entityiterator instanceof Player) {
							if (!(getEntityGameType(entityiterator) == GameType.CREATIVE) && !(getEntityGameType(entityiterator) == GameType.SPECTATOR)) {
								itemPosX = entityiterator.getX();
								itemPosY = entityiterator.getY();
								itemPosZ = entityiterator.getZ();
								if (itemPosX < playerPosX) {
									entityiterator.setDeltaMovement(new Vec3((-0.05), (entityiterator.getDeltaMovement().y()), (entityiterator.getDeltaMovement().z())));
								} else if (itemPosX > playerPosX) {
									entityiterator.setDeltaMovement(new Vec3(0.05, (entityiterator.getDeltaMovement().y()), (entityiterator.getDeltaMovement().z())));
								}
								if (itemPosY < playerPosY) {
									entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (-0.05), (entityiterator.getDeltaMovement().z())));
								} else if (itemPosY > playerPosY) {
									entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), 0.05, (entityiterator.getDeltaMovement().z())));
								}
								if (itemPosZ < playerPosZ) {
									entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (entityiterator.getDeltaMovement().y()), (-0.05)));
								} else if (itemPosZ > playerPosZ) {
									entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (entityiterator.getDeltaMovement().y()), 0.05));
								}
							}
						}
					}
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
