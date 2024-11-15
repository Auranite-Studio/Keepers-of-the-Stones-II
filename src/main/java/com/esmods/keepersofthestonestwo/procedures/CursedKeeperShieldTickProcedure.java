package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;

@EventBusSubscriber
public class CursedKeeperShieldTickProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		double r = 0;
		double b = 0;
		double timer = 0;
		if (entity instanceof CursedKeeperEntity) {
			if (entity.getPersistentData().getDouble("windShield") > 0) {
				if (timer > 40) {
					timer = timer - 1;
				} else if (timer == 0) {
					{
						final Vec3 _center = new Vec3(x, (y + 1), z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Arrow) {
								entity.getPersistentData().putBoolean("barrier", true);
							}
						}
					}
					r = 1.5;
					a = 0;
					b = 90;
					for (int index0 = 0; index0 < 30; index0++) {
						for (int index1 = 0; index1 < 16; index1++) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.CLOUD, (x - r * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a))), ((y + 1) - r * Math.sin(Math.toRadians(b))),
										(z + r * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a))), 1, 0, 0, 0, 0);
							b = b + 12;
						}
						b = 90;
						a = a + 12;
						{
							final Vec3 _center = new Vec3(x, (y + 1), z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entity.getPersistentData().getBoolean("barrier") != true) {
									if (!(entityiterator == entity)) {
										entityiterator.setDeltaMovement(new Vec3((1.5 * entity.getDeltaMovement().x()), (1.5 * entity.getDeltaMovement().y()), (1.5 * entity.getLookAngle().z)));
									}
								}
							}
						}
					}
					timer = 40;
					entity.getPersistentData().putDouble("windShield", (entity.getPersistentData().getDouble("windShield") - 1));
				}
			}
		}
	}
}
