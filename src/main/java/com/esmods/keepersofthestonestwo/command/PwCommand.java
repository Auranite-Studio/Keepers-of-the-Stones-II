
package com.esmods.keepersofthestonestwo.command;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.common.util.FakePlayerFactory;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

import com.esmods.keepersofthestonestwo.procedures.UnlockKeepersBoxProcedure;
import com.esmods.keepersofthestonestwo.procedures.QuakePowerProcedure;
import com.esmods.keepersofthestonestwo.procedures.PowerScaleSetProcedure;
import com.esmods.keepersofthestonestwo.procedures.PowerRecoveryMultiplierSetProcedure;
import com.esmods.keepersofthestonestwo.procedures.MaxPowerScaleSetProcedure;
import com.esmods.keepersofthestonestwo.procedures.FakeElementSetProcedure;
import com.esmods.keepersofthestonestwo.procedures.DebugControlProcedure;

@EventBusSubscriber
public class PwCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("pw").requires(s -> s.hasPermission(4))
				.then(Commands.literal("points").then(Commands.literal("set").then(Commands.argument("players", EntityArgument.players()).then(Commands.argument("count", DoubleArgumentType.doubleArg(0, 9999)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					PowerScaleSetProcedure.execute(arguments, entity);
					return 0;
				}))))).then(Commands.literal("max_points").then(Commands.literal("set").then(Commands.argument("players", EntityArgument.players()).then(Commands.argument("count", DoubleArgumentType.doubleArg(0, 9999)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					MaxPowerScaleSetProcedure.execute(arguments, entity);
					return 0;
				}))))).then(Commands.literal("multiplier").then(Commands.literal("set").then(Commands.argument("players", EntityArgument.players()).then(Commands.argument("count", DoubleArgumentType.doubleArg(0, 10)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					PowerRecoveryMultiplierSetProcedure.execute(arguments, entity);
					return 0;
				}))))).then(Commands.literal("fake_element").then(Commands.literal("set").then(Commands.argument("players", EntityArgument.players()).then(
						Commands.argument("element_order", DoubleArgumentType.doubleArg(1, 3)).then(Commands.argument("element_name", StringArgumentType.word()).then(Commands.argument("time", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							FakeElementSetProcedure.execute(arguments, entity);
							return 0;
						})))))))
				.then(Commands.literal("unlock_box").then(Commands.argument("players", EntityArgument.players()).then(Commands.argument("unlock_logic", BoolArgumentType.bool()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					UnlockKeepersBoxProcedure.execute(arguments, entity);
					return 0;
				})))).then(Commands.literal("debug").then(Commands.literal("set").then(Commands.argument("debug_logic", BoolArgumentType.bool()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					DebugControlProcedure.execute(arguments, entity);
					return 0;
				})))).then(Commands.literal("vfx").then(Commands.literal("quake").then(Commands.argument("x_translate", DoubleArgumentType.doubleArg()).then(Commands.argument("z_translate", DoubleArgumentType.doubleArg()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					QuakePowerProcedure.execute(world, x, y, z, arguments);
					return 0;
				}))))));
	}
}
