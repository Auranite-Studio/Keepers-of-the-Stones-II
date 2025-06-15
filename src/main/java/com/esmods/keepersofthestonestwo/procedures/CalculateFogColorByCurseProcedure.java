package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.client.event.ViewportEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

@EventBusSubscriber(value = Dist.CLIENT)
public class CalculateFogColorByCurseProcedure {
	public static ViewportEvent.ComputeFogColor provider = null;

	public static void setColor(int color) {
		provider.setRed((color >> 16 & 255) / 255.0F);
		provider.setGreen((color >> 8 & 255) / 255.0F);
		provider.setBlue((color & 255) / 255.0F);
	}

	public static void setColor(float level, int color) {
		if (level <= 0.0F)
			return;
		if (level >= 1.0F) {
			provider.setRed((color >> 16 & 255) / 255.0F);
			provider.setGreen((color >> 8 & 255) / 255.0F);
			provider.setBlue((color & 255) / 255.0F);
		} else {
			level = Mth.clamp(level, 0.0F, 1.0F);
			provider.setRed(Mth.clamp(Mth.lerp(level, Mth.clamp(provider.getRed(), 0.0F, 1.0F), (color >> 16 & 255) / 255.0F), 0.0F, 1.0F));
			provider.setGreen(Mth.clamp(Mth.lerp(level, Mth.clamp(provider.getGreen(), 0.0F, 1.0F), (color >> 8 & 255) / 255.0F), 0.0F, 1.0F));
			provider.setBlue(Mth.clamp(Mth.lerp(level, Mth.clamp(provider.getBlue(), 0.0F, 1.0F), (color & 255) / 255.0F), 0.0F, 1.0F));
		}
	}

	@SubscribeEvent
	public static void computeFogColor(ViewportEvent.ComputeFogColor event) {
		provider = event;
		ClientLevel level = Minecraft.getInstance().level;
		Entity entity = provider.getCamera().getEntity();
		if (level != null && entity != null) {
			Vec3 entPos = entity.getPosition((float) provider.getPartialTick());
			execute(provider, entity);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (!entity.isUnderWater() && !(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(PowerModMobEffects.MIST))) {
			if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(PowerModMobEffects.CURSE)) {
				setColor(255 << 24 | 153 << 16 | 141 << 8 | 163);
			}
		}
	}
}