package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class OrangePortalTeleportingProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (PowerModVariables.MapVariables.get(world).blue_portal_placed) {
			{
				Entity _ent = entity;
				_ent.teleportTo(PowerModVariables.MapVariables.get(world).bpX, PowerModVariables.MapVariables.get(world).bpY, PowerModVariables.MapVariables.get(world).bpZ);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(PowerModVariables.MapVariables.get(world).bpX, PowerModVariables.MapVariables.get(world).bpY, PowerModVariables.MapVariables.get(world).bpZ, _ent.getYRot(), _ent.getXRot());
			}
		}
	}
}
