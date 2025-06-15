
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
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.CoreShaders;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

import com.esmods.keepersofthestonestwo.procedures.RedRune6CheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.RedRune5CheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.RedRune4CheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.RedRune3CheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.RedRune2CheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.RedRune1CheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.GreenRune5CheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.GreenRune4CheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.GreenRune3CheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.GreenRune2CheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.GreenRune1CheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetRunesProcedure;
import com.esmods.keepersofthestonestwo.procedures.BlueRune3CheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.BlueRune2CheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.BlueRune1CheckProcedure;

@EventBusSubscriber({Dist.CLIENT})
public class RunesOverlayOverlay {
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
		RenderSystem.setShader(CoreShaders.POSITION_TEX);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (GetRunesProcedure.execute(entity)) {
			event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("power:textures/screens/runes_inventory.png"), 2, 50, 0, 0, 59, 26, 59, 26);

			if (BlueRune1CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("power:textures/screens/star_extra_rune_1.png"), 7, 56, 0, 0, 16, 16, 16, 16);
			}
			if (BlueRune2CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("power:textures/screens/star_extra_rune_2.png"), 7, 56, 0, 0, 16, 16, 16, 16);
			}
			if (BlueRune3CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("power:textures/screens/star_extra_rune_3.png"), 7, 56, 0, 0, 16, 16, 16, 16);
			}
			if (RedRune1CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("power:textures/screens/reduced_stone_recharge_time_rune_1.png"), 23, 56, 0, 0, 16, 16, 16, 16);
			}
			if (RedRune2CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("power:textures/screens/reduced_stone_recharge_time_rune_2.png"), 23, 56, 0, 0, 16, 16, 16, 16);
			}
			if (RedRune3CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("power:textures/screens/reduced_stone_recharge_time_rune_3.png"), 23, 56, 0, 0, 16, 16, 16, 16);
			}
			if (RedRune4CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("power:textures/screens/addition_time_master_effect_rune_1.png"), 23, 56, 0, 0, 16, 16, 16, 16);
			}
			if (RedRune5CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("power:textures/screens/addition_time_master_effect_rune_2.png"), 23, 56, 0, 0, 16, 16, 16, 16);
			}
			if (RedRune6CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("power:textures/screens/addition_time_master_effect_rune_3.png"), 23, 56, 0, 0, 16, 16, 16, 16);
			}
			if (GreenRune1CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("power:textures/screens/protection_rune.png"), 39, 56, 0, 0, 16, 16, 16, 16);
			}
			if (GreenRune2CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("power:textures/screens/spin_rune.png"), 39, 56, 0, 0, 16, 16, 16, 16);
			}
			if (GreenRune3CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("power:textures/screens/dodging_rune.png"), 39, 56, 0, 0, 16, 16, 16, 16);
			}
			if (GreenRune4CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("power:textures/screens/invisibility_rune.png"), 39, 56, 0, 0, 16, 16, 16, 16);
			}
			if (GreenRune5CheckProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("power:textures/screens/healing_rune.png"), 39, 56, 0, 0, 16, 16, 16, 16);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
