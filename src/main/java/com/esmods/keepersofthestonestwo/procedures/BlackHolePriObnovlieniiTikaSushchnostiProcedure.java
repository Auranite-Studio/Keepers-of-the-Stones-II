package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import java.util.List;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class BlackHolePriObnovlieniiTikaSushchnostiProcedure {
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
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(((entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).element_name_first).equals("space")
						|| ((entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).element_name_second).equals("space")
						|| ((entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).element_name_third).equals("space")
						|| ((entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("space")
						|| ((entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("space")
						|| ((entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("space"))) {
					if (entityiterator instanceof Mob || entityiterator instanceof Player) {
						if (!(new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer _serverPlayer) {
									return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
								} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
									return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
											&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
								}
								return false;
							}
						}.checkGamemode(entityiterator)) && !(new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer _serverPlayer) {
									return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
								} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
									return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
											&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
								}
								return false;
							}
						}.checkGamemode(entityiterator))) {
							itemPosX = entityiterator.getX();
							itemPosY = entityiterator.getY();
							itemPosZ = entityiterator.getZ();
							if (itemPosX < playerPosX) {
								entityiterator.setDeltaMovement(new Vec3(0.25, (entityiterator.getDeltaMovement().y()), (entityiterator.getDeltaMovement().z())));
							} else if (itemPosX > playerPosX) {
								entityiterator.setDeltaMovement(new Vec3((-0.25), (entityiterator.getDeltaMovement().y()), (entityiterator.getDeltaMovement().z())));
							}
							if (itemPosY < playerPosY) {
								entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), 0.25, (entityiterator.getDeltaMovement().z())));
							} else if (itemPosY > playerPosY) {
								entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (-0.25), (entityiterator.getDeltaMovement().z())));
							}
							if (itemPosZ < playerPosZ) {
								entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (entityiterator.getDeltaMovement().y()), 0.25));
							} else if (itemPosZ > playerPosZ) {
								entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (entityiterator.getDeltaMovement().y()), (-0.25)));
							}
						}
					}
				}
			}
		}
	}
}
