package com.esmods.keepersofthestonestwo.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

import com.esmods.keepersofthestonestwo.procedures.EthernalProgressBarIntProcedure;
import com.esmods.keepersofthestonestwo.procedures.EthernalCurseProgressGUCheckEffectProcedure;

@EventBusSubscriber(Dist.CLIENT)
public class EthernalCurseProgressGUIOverlay {
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("power:textures/screens/ethernal_curse_progress_line.png");
	private static final ResourceLocation SPRITE_0 = ResourceLocation.parse("power:textures/screens/ethernal_curse_progress_bar.png");

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
		if (EthernalCurseProgressGUCheckEffectProcedure.execute(entity)) {
			event.getGuiGraphics().blit(IMAGE_0, w / 2 + -55, h - 72, 0, 0, 102, 10, 102, 10);

			event.getGuiGraphics().blit(SPRITE_0, w / 2 + -54, h - 71, 0, Mth.clamp((int) EthernalProgressBarIntProcedure.execute(entity) * 8, 0, 800), 100, 8, 100, 808);

		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}