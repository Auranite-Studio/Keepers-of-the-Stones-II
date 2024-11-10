
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

import com.esmods.keepersofthestonestwo.procedures.StarPointsRegTimerDebugProcedure;
import com.esmods.keepersofthestonestwo.procedures.StarPointsRecoveryMultiplierDebugProcedure;
import com.esmods.keepersofthestonestwo.procedures.StarPointsDebugProcedure;
import com.esmods.keepersofthestonestwo.procedures.SelectedAttackDebugProcedure;
import com.esmods.keepersofthestonestwo.procedures.PowerRecordedDubugProcedure;
import com.esmods.keepersofthestonestwo.procedures.ModVersionDebugProcedure;
import com.esmods.keepersofthestonestwo.procedures.MergersNumberDebugProcedure;
import com.esmods.keepersofthestonestwo.procedures.MaxStarPointsDebugProcedure;
import com.esmods.keepersofthestonestwo.procedures.LevelXPDebugProcedure;
import com.esmods.keepersofthestonestwo.procedures.LevelDebugProcedure;
import com.esmods.keepersofthestonestwo.procedures.FakeElementsTimerDebugProcedure;
import com.esmods.keepersofthestonestwo.procedures.FakeElementsActiveDebugProcedure;
import com.esmods.keepersofthestonestwo.procedures.ElementsActiveDebugProcedure;
import com.esmods.keepersofthestonestwo.procedures.DebugCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.CPAPIVersionDebugProcedure;
import com.esmods.keepersofthestonestwo.procedures.ActivePowerDebugProcedure;
import com.esmods.keepersofthestonestwo.procedures.ActiveBatteryDebugProcedure;
import com.esmods.keepersofthestonestwo.procedures.AbilityBlockedDebugProcedure;

@EventBusSubscriber({Dist.CLIENT})
public class DebugInfoOverlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
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
		if (DebugCheckProcedure.execute(entity)) {
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					StarPointsRecoveryMultiplierDebugProcedure.execute(entity), 6, 98, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					MaxStarPointsDebugProcedure.execute(entity), 6, 107, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					FakeElementsTimerDebugProcedure.execute(entity), 6, 170, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					PowerRecordedDubugProcedure.execute(entity), 6, 179, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					FakeElementsActiveDebugProcedure.execute(entity), 6, 161, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ElementsActiveDebugProcedure.execute(entity), 6, 152, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ActivePowerDebugProcedure.execute(entity), 6, 116, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ActiveBatteryDebugProcedure.execute(entity), 6, 125, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					MergersNumberDebugProcedure.execute(entity), 6, 143, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ModVersionDebugProcedure.execute(), 6, 62, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.power.debug_info.label_debug_mode"), 6, 53, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					StarPointsDebugProcedure.execute(entity), 6, 80, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					SelectedAttackDebugProcedure.execute(entity), 6, 134, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					CPAPIVersionDebugProcedure.execute(), 6, 71, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					StarPointsRegTimerDebugProcedure.execute(entity), 6, 89, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					AbilityBlockedDebugProcedure.execute(entity), 6, 188, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					LevelDebugProcedure.execute(entity), 6, 197, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					LevelXPDebugProcedure.execute(entity), 6, 206, -1, false);
		}
	}
}
