package com.esmods.keepersofthestonestwo.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

import com.esmods.keepersofthestonestwo.PowerMod;

public class QuakePowerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands()
					.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("execute align xyz run summon block_display" + " ~" + DoubleArgumentType.getDouble(arguments, "x_translate") + " ~-0.9" + " ~" + DoubleArgumentType.getDouble(arguments, "z_translate")
									+ " {shadow_radius:0f,shadow_strength:0f, width:0f,height:0f,brightness:{sky:15,block:0},block_state:{Name:\"" + ForgeRegistries.BLOCKS
											.getKey((world.getBlockState(BlockPos.containing(x + DoubleArgumentType.getDouble(arguments, "x_translate"), y - 1, z + DoubleArgumentType.getDouble(arguments, "z_translate")))).getBlock()).toString()
									+ "\"}}"));
		world.levelEvent(2001, BlockPos.containing(x + DoubleArgumentType.getDouble(arguments, "x_translate"), y - 1, z + DoubleArgumentType.getDouble(arguments, "z_translate")),
				Block.getId((world.getBlockState(BlockPos.containing(x + DoubleArgumentType.getDouble(arguments, "x_translate"), y - 1, z + DoubleArgumentType.getDouble(arguments, "z_translate"))))));
		PowerMod.queueServerWork(1, () -> {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((x + DoubleArgumentType.getDouble(arguments, "x_translate")), y, (z + DoubleArgumentType.getDouble(arguments, "z_translate"))), Vec2.ZERO, _level, 4, "",
								Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"data merge entity @e[type=block_display,sort=nearest,limit=1] {transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0.3f,0f],scale:[1f,1f,1f]}, start_interpolation:0,interpolation_duration:3}");
			PowerMod.queueServerWork(2, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + DoubleArgumentType.getDouble(arguments, "x_translate")), y, (z + DoubleArgumentType.getDouble(arguments, "z_translate"))), Vec2.ZERO, _level, 4, "",
									Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"data merge entity @e[type=block_display,sort=nearest,limit=1] {transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0f,0f],scale:[1f,1f,1f]}, start_interpolation:0,interpolation_duration:1}");
				PowerMod.queueServerWork(2, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((x + DoubleArgumentType.getDouble(arguments, "x_translate")), y, (z + DoubleArgumentType.getDouble(arguments, "z_translate"))), Vec2.ZERO,
										_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "kill @e[type=block_display,sort=nearest,limit=1]");
				});
			});
		});
	}
}
