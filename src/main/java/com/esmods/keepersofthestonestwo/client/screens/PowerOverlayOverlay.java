package com.esmods.keepersofthestonestwo.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.Minecraft;

import com.esmods.keepersofthestonestwo.procedures.GetStarPointsProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetActiveProcedure;

@EventBusSubscriber(Dist.CLIENT)
public class PowerOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (GetActiveProcedure.execute(entity)) {
			event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("power:textures/screens/star_points_overlay.png"), 2, 28, 0, 0, 59, 20, 59, 20);

			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					GetStarPointsProcedure.execute(entity), 31, 35, -1, false);
		}
	}
}