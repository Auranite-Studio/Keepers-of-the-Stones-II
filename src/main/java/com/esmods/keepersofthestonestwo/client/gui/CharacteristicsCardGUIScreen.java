package com.esmods.keepersofthestonestwo.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

import com.esmods.keepersofthestonestwo.world.inventory.CharacteristicsCardGUIMenu;
import com.esmods.keepersofthestonestwo.procedures.SpeedInfoProcedure;
import com.esmods.keepersofthestonestwo.procedures.ResistanceInfoProcedure;
import com.esmods.keepersofthestonestwo.procedures.RankSCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.RankDCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.RankCCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.RankBCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.RankACheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.NameInfoProcedure;
import com.esmods.keepersofthestonestwo.procedures.LevelInfoProcedure;
import com.esmods.keepersofthestonestwo.procedures.HasteInfoProcedure;
import com.esmods.keepersofthestonestwo.procedures.ExpBar4Procedure;
import com.esmods.keepersofthestonestwo.procedures.ExpBar3Procedure;
import com.esmods.keepersofthestonestwo.procedures.ExpBar2Procedure;
import com.esmods.keepersofthestonestwo.procedures.ExpBar1Procedure;
import com.esmods.keepersofthestonestwo.procedures.DamageInfoProcedure;
import com.esmods.keepersofthestonestwo.procedures.BarExp7Procedure;
import com.esmods.keepersofthestonestwo.procedures.BarExp6Procedure;
import com.esmods.keepersofthestonestwo.procedures.BarExp5Procedure;
import com.esmods.keepersofthestonestwo.procedures.Bar9Procedure;
import com.esmods.keepersofthestonestwo.procedures.Bar8Procedure;
import com.esmods.keepersofthestonestwo.procedures.Bar12Procedure;
import com.esmods.keepersofthestonestwo.procedures.Bar11Procedure;
import com.esmods.keepersofthestonestwo.procedures.Bar10Procedure;

public class CharacteristicsCardGUIScreen extends AbstractContainerScreen<CharacteristicsCardGUIMenu> {
	private final static HashMap<String, Object> guistate = CharacteristicsCardGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CharacteristicsCardGUIScreen(CharacteristicsCardGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 320;
		this.imageHeight = 176;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("power:textures/screens/characteristics_card_gui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 320, 176, 320, 176);

		if (ExpBar1Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/experience_bar_progress_1.png"), this.leftPos + 29, this.topPos + 56, 0, 0, 9, 5, 9, 5);
		}
		if (ExpBar2Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/experience_bar_progress_mid.png"), this.leftPos + 38, this.topPos + 56, 0, 0, 11, 5, 11, 5);
		}
		if (ExpBar3Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/experience_bar_progress_mid.png"), this.leftPos + 48, this.topPos + 56, 0, 0, 11, 5, 11, 5);
		}
		if (ExpBar4Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/experience_bar_progress_mid.png"), this.leftPos + 58, this.topPos + 56, 0, 0, 11, 5, 11, 5);
		}
		if (BarExp5Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/experience_bar_progress_mid.png"), this.leftPos + 68, this.topPos + 56, 0, 0, 11, 5, 11, 5);
		}
		if (BarExp6Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/experience_bar_progress_mid.png"), this.leftPos + 78, this.topPos + 56, 0, 0, 11, 5, 11, 5);
		}
		if (BarExp7Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/experience_bar_progress_mid.png"), this.leftPos + 88, this.topPos + 56, 0, 0, 11, 5, 11, 5);
		}
		if (Bar8Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/experience_bar_progress_mid.png"), this.leftPos + 98, this.topPos + 56, 0, 0, 11, 5, 11, 5);
		}
		if (Bar9Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/experience_bar_progress_mid.png"), this.leftPos + 108, this.topPos + 56, 0, 0, 11, 5, 11, 5);
		}
		if (Bar10Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/experience_bar_progress_mid.png"), this.leftPos + 118, this.topPos + 56, 0, 0, 11, 5, 11, 5);
		}
		if (Bar11Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/experience_bar_progress_mid.png"), this.leftPos + 128, this.topPos + 56, 0, 0, 11, 5, 11, 5);
		}
		if (Bar12Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/experience_bar_progress_end.png"), this.leftPos + 139, this.topPos + 56, 0, 0, 10, 5, 10, 5);
		}
		if (RankDCheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/rank_d_print.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 320, 176, 320, 176);
		}
		if (RankCCheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/rank_c_print.png"), this.leftPos + 0, this.topPos + 1, 0, 0, 320, 176, 320, 176);
		}
		if (RankBCheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/rank_b_print.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 320, 176, 320, 176);
		}
		if (RankACheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/rank_a_print.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 320, 176, 320, 176);
		}
		if (RankSCheckProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("power:textures/screens/rank_s_print.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 320, 176, 320, 176);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				NameInfoProcedure.execute(entity), 35, 36, -5927048, false);
		guiGraphics.drawString(this.font,

				LevelInfoProcedure.execute(entity), 82, 62, -10713797, false);
		guiGraphics.drawString(this.font,

				DamageInfoProcedure.execute(entity), 66, 77, -5927048, false);
		guiGraphics.drawString(this.font,

				SpeedInfoProcedure.execute(entity), 66, 99, -5927048, false);
		guiGraphics.drawString(this.font,

				ResistanceInfoProcedure.execute(entity), 66, 121, -5927048, false);
		guiGraphics.drawString(this.font,

				HasteInfoProcedure.execute(entity), 66, 143, -5927048, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
