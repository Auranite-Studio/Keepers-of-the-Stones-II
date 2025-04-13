
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
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

import com.esmods.keepersofthestonestwo.procedures.GetStarPointsProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetActiveProcedure;
import com.esmods.keepersofthestonestwo.procedures.BlueRune3CheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.BlueRune2CheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.BlueRune1CheckProcedure;

@EventBusSubscriber({Dist.CLIENT})
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
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (GetActiveProcedure.execute(entity)) {
			event.getGuiGraphics().blit(ResourceLocation.parse("power:textures/screens/star_points_overlay.png"), 2, 28, 0, 0, 59, 20, 59, 20);

			event.getGuiGraphics().blit(ResourceLocation.parse("power:textures/screens/runes_inventory.png"), w - 77, h - 40, 0, 0, 68, 33, 68, 33);

			if (BlueRune1CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("power:textures/screens/star_extra_booster_1.png"), w - 69, h - 32, 0, 0, 16, 16, 16, 16);
			}
			if (BlueRune2CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("power:textures/screens/star_extra_booster_2.png"), w - 69, h - 32, 0, 0, 16, 16, 16, 16);
			}
			if (BlueRune3CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("power:textures/screens/star_extra_booster_3.png"), w - 69, h - 32, 0, 0, 16, 16, 16, 16);
			}
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					GetStarPointsProcedure.execute(entity), 31, 35, -1, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
