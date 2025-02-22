package com.esmods.keepersofthestonestwo.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import com.mojang.blaze3d.shaders.FogShape;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class RenderFogByCurseProcedure {
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
				execute(provider, entity, provider.getFarPlaneDistance());
			}
		}
	}

	public static void execute(Entity entity, double end) {
		execute(null, entity, end);
	}

	private static void execute(@Nullable Event event, Entity entity, double end) {
		if (entity == null)
			return;
		if (!entity.isUnderWater() && !(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(PowerModMobEffects.MIST.get()))) {
			if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(PowerModMobEffects.CURSE.get())) {
				setDistance((float) (0.4 * Math.sqrt(3)), (float) (Math.sqrt(end) * 2 + 3));
			}
		}
	}
}
