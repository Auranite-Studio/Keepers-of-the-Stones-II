package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.functions.CommandFunction;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Optional;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class SpinTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("spinTickDamage") == 5) {
			entity.getPersistentData().putDouble("spinTickDamage", 0);
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (!(entity == entityiterator)) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("power:elemental_powers")))),
								(float) (entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl * 0.25));
					}
				}
			}
		} else if (entity.getPersistentData().getDouble("spinTickDamage") < 5) {
			entity.getPersistentData().putDouble("spinTickDamage", (entity.getPersistentData().getDouble("spinTickDamage") + 1));
		}
		if (entity.getPersistentData().getDouble("spinEffectTickDamage") == 3) {
			if (world instanceof ServerLevel _level && _level.getServer() != null) {
				Optional<CommandFunction<CommandSourceStack>> _fopt = _level.getServer().getFunctions().get(ResourceLocation.parse("power:tornado"));
				if (_fopt.isPresent())
					_level.getServer().getFunctions().execute(_fopt.get(), new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null));
			}
			entity.getPersistentData().putDouble("spinEffectTickDamage", 0);
		} else if (entity.getPersistentData().getDouble("spinEffectTickDamage") < 3) {
			entity.getPersistentData().putDouble("spinEffectTickDamage", (entity.getPersistentData().getDouble("spinEffectTickDamage") + 1));
		}
	}
}
