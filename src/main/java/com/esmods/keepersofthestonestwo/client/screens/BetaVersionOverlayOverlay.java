
package com.esmods.keepersofthestonestwo.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import com.esmods.keepersofthestonestwo.procedures.BetaVersionOverlayUsloviiePokazaNalozhieniiaProcedure;
import com.esmods.keepersofthestonestwo.procedures.BetaVersionOverlayIsGUINotHiddingProcedure;

@EventBusSubscriber({Dist.CLIENT})
public class BetaVersionOverlayOverlay {
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
		if (BetaVersionOverlayIsGUINotHiddingProcedure.execute()) {
			if (BetaVersionOverlayUsloviiePokazaNalozhieniiaProcedure.execute())
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.power.beta_version_overlay.label_warning_this_version_is_not_fin"), w / 2 + -81, 3, -65536, false);
		}
	}
}
