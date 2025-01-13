package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.client.event.ViewportEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import com.mojang.blaze3d.shaders.FogShape;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

@EventBusSubscriber(value = Dist.CLIENT)
public class RenderSpecialFogInCursedBiomesProcedure {
	public static ViewportEvent.RenderFog provider = null;

	public static void setDistance(float start, float end) {
		provider.setNearPlaneDistance(start);
		provider.setFarPlaneDistance(end);
		if (!provider.isCanceled()) {
			provider.setCanceled(true);
		}
	}

	public static void setShape(FogShape shape) {
		provider.setFogShape(shape);
		if (!provider.isCanceled()) {
			provider.setCanceled(true);
		}
	}

	@SubscribeEvent
	public static void renderFog(ViewportEvent.RenderFog event) {
		provider = event;
		if (provider.getMode() == FogRenderer.FogMode.FOG_TERRAIN) {
			ClientLevel level = Minecraft.getInstance().level;
			Entity entity = provider.getCamera().getEntity();
			if (level != null && entity != null) {
				Vec3 pos = entity.getPosition((float) provider.getPartialTick());
				execute(provider, level, pos.x(), pos.y(), pos.z(), entity, provider.getFarPlaneDistance());
			}
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double end) {
		execute(null, world, x, y, z, entity, end);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double end) {
		if (entity == null)
			return;
		if (!entity.isUnderWater() && !(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(PowerModMobEffects.MIST))) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("power:cursed_biomes")))) {
				setDistance((float) (0.4 * Math.sqrt(entity.getData(PowerModVariables.PLAYER_VARIABLES).fog_distance)), (float) (Math.sqrt(end) * 2 + entity.getData(PowerModVariables.PLAYER_VARIABLES).fog_distance));
			} else {
				setDistance((float) (0.4 * Math.sqrt(entity.getData(PowerModVariables.PLAYER_VARIABLES).fog_distance)), (float) (Math.sqrt(end) * 2 + entity.getData(PowerModVariables.PLAYER_VARIABLES).fog_distance));
			}
		}
	}
}
