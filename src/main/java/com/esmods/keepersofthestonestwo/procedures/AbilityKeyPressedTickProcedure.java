package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

@EventBusSubscriber
public class AbilityKeyPressedTickProcedure {
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
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).ability_block == false && !(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
					}
					return false;
				}
			}.checkGamemode(entity))) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("fire") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("fire")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("fire") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("fire")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("fire") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("fire")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("thirst") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("thirst")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("thirst") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("thirst")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("thirst") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("thirst")) {
					FireSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("air") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("air")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("air") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("air")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("air") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("air")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("chaos") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("chaos")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("chaos") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("chaos")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("chaos") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("chaos")) {
					AirSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("earth") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("earth")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("earth") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("earth")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("earth") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("earth")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("horror") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("horror")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("horror") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("horror")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("horror") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("horror")) {
					EarthSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("water") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("water")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("water") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("water")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("water") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("water")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("filth") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("filth")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("filth") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("filth")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("filth") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("filth")) {
					WaterSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("ether") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("ether")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("ether") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("ether")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("ether") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("ether")) {
					EtherSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("ice") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("ice")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("ice") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("ice")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("ice") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("ice")) {
					IceSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("lightning") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("lightning")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("lightning") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("lightning")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("lightning") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("lightning")) {
					LightningSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("sound") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("sound")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("sound") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("sound")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("sound") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("sound")) {
					SoundSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("crystal") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("crystal")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("crystal") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("crystal")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("crystal") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("crystal")) {
					CrystalSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("lava") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("lava")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("lava") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("lava")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("lava") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("lava")) {
					LavaSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("rain") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("rain")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("rain") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("rain")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("rain") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("rain")) {
					RainSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("tornado") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("tornado")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("tornado") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("tornado")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("tornado") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("tornado")) {
					TornadoSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("ocean") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("ocean")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("ocean") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("ocean")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("ocean") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("ocean")) {
					OceanSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("plants") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("plants")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("plants") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("plants")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("plants") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("plants")) {
					PlantsSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("animals") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("animals")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("animals") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("animals")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("animals") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("animals")) {
					AnimalsSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("metal") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("metal")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("metal") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("metal")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("metal") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("metal")) {
					MetalSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("light") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("light")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("light") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("light")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("light") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("light")) {
					LightSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("shadow") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("shadow")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("shadow") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("shadow")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("shadow") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("shadow")) {
					ShadowSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("vacuum") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("vacuum")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("vacuum") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("vacuum")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("vacuum") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("vacuum")) {
					VacuumSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("energy") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("energy")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("energy") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("energy")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("energy") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("energy")) {
					EnergySpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("sun") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("sun")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("sun") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("sun")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("sun") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("sun")) {
					SunSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("moon") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("moon")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("moon") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("moon")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("moon") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("moon")) {
					MoonSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("space") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("space")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("space") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("space")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("space") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("space")) {
					SpaceSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("time") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("time")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("time") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("time")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("time") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("time")) {
					TimeSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("creation") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("creation")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("creation") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("creation")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("creation") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("creation")) {
					CreationSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("destruction") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("destruction")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("destruction") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("destruction")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("destruction") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("destruction")) {
					DestructionSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("blood") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("blood")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("blood") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("blood")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("blood") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("blood")) {
					BloodSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("technology") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("technology")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("technology") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("technology")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("technology") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("technology")) {
					TechnologySpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("teleportation") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("teleportation")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("teleportation") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("teleportation")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("teleportation") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("teleportation")) {
					TeleportationSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("explosion") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("explosion")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("explosion") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("explosion")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("explosion") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("explosion")) {
					ExplosionSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("amber") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("amber")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("amber") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("amber")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("amber") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("amber")) {
					AmberSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("mist") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("mist")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("mist") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("mist")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("mist") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("mist")) {
					MistSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("sand") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("sand")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("sand") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("sand")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("sand") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("sand")) {
					SandSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("speed") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("speed")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("speed") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("speed")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("speed") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("speed")) {
					SpeedSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("poison") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("poison")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("poison") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("poison")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("poison") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("poison")) {
					PoisonSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("magnet") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("magnet")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("magnet") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("magnet")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("magnet") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("magnet")) {
					MagnetSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("mushrooms") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("mushrooms")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("mushrooms") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("mushrooms")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("mushrooms") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("mushrooms")) {
					MushroomsSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("mercury") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("mercury")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("mercury") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("mercury")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("mercury") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("mercury")) {
					MercurySpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("music") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("music")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("music") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("music")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("music") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("music")) {
					MusicSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("plague") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("plague")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("plague") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("plague")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("plague") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("plague")) {
					PlagueSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("blue_flame") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("blue_flame")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("blue_flame") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("blue_flame")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("blue_flame") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("blue_flame")) {
					BlueFlameSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("gravity") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("gravity")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("gravity") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("gravity")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("gravity") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("gravity")) {
					GravitySpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("smoke") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("smoke")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("smoke") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("smoke")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("smoke") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("smoke")) {
					SmokeSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("spirit") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("spirit")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("spirit") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("spirit")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("spirit") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("spirit")) {
					SpiritSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("form") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("form")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("form") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("form")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("form") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("form")) {
					FormSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("mind") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("mind")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("mind") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("mind")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("mind") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("mind")) {
					MindSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("golden_dust") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("golden_dust")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("golden_dust") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("golden_dust")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("golden_dust") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("golden_dust")) {
					GoldenDustSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("darkness") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("darkness")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("darkness") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("darkness")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("darkness") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("darkness")) {
					DarknessSpecialAttackProcedure.execute(world, x, y, z, entity);
				}
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.use_ability_key_var = false;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
