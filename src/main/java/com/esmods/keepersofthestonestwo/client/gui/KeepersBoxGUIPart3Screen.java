package com.esmods.keepersofthestonestwo.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

import com.esmods.keepersofthestonestwo.world.inventory.KeepersBoxGUIPart3Menu;
import com.esmods.keepersofthestonestwo.procedures.VacuumStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.SunStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.SpiritStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.SpaceStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.ShadowStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.MoonStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.MindStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.LightStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.GoldenDustStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.FormStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.DarknessStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.BloodStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.network.KeepersBoxGUIPart3ButtonMessage;

public class KeepersBoxGUIPart3Screen extends AbstractContainerScreen<KeepersBoxGUIPart3Menu> {
	private final static HashMap<String, Object> guistate = KeepersBoxGUIPart3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_keepers_box_button_up;
	ImageButton imagebutton_keepers_box_button_down;
	ImageButton imagebutton_light_element;
	ImageButton imagebutton_shadow_element;
	ImageButton imagebutton_sun_element;
	ImageButton imagebutton_space_element;
	ImageButton imagebutton_moon_element;
	ImageButton imagebutton_vacuum_element;
	ImageButton imagebutton_blood_element;
	ImageButton imagebutton_spirit_element;
	ImageButton imagebutton_form_element;
	ImageButton imagebutton_mind_element;
	ImageButton imagebutton_golden_dust_element;
	ImageButton imagebutton_darkness_element;

	public KeepersBoxGUIPart3Screen(KeepersBoxGUIPart3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 267;
		this.imageHeight = 188;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (LightStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 91 && mouseX < leftPos + 115 && mouseY > topPos + 64 && mouseY < topPos + 88)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_3.tooltip_light"), mouseX, mouseY);
		if (ShadowStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 134 && mouseX < leftPos + 158 && mouseY > topPos + 64 && mouseY < topPos + 88)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_3.tooltip_shadow"), mouseX, mouseY);
		if (SunStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 158 && mouseX < leftPos + 182 && mouseY > topPos + 64 && mouseY < topPos + 88)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_3.tooltip_sun"), mouseX, mouseY);
		if (SpaceStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 182 && mouseX < leftPos + 206 && mouseY > topPos + 65 && mouseY < topPos + 89)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_3.tooltip_space"), mouseX, mouseY);
		if (MoonStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 158 && mouseX < leftPos + 182 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_3.tooltip_moon"), mouseX, mouseY);
		if (VacuumStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 182 && mouseX < leftPos + 206 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_3.tooltip_vacuum"), mouseX, mouseY);
		if (BloodStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 45 && mouseX < leftPos + 69 && mouseY > topPos + 65 && mouseY < topPos + 89)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_3.tooltip_blood"), mouseX, mouseY);
		if (SpiritStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 134 && mouseX < leftPos + 158 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_3.tooltip_spirit"), mouseX, mouseY);
		if (FormStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 68 && mouseX < leftPos + 92 && mouseY > topPos + 65 && mouseY < topPos + 89)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_3.tooltip_form"), mouseX, mouseY);
		if (MindStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 45 && mouseX < leftPos + 69 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_3.tooltip_mind"), mouseX, mouseY);
		if (GoldenDustStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 69 && mouseX < leftPos + 93 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_3.tooltip_golden_dust"), mouseX, mouseY);
		if (DarknessStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 92 && mouseX < leftPos + 116 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_3.tooltip_darkness"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("power:textures/screens/keepers_box_gui_part_3.png"), this.leftPos + 5, this.topPos + -34, 0, 0, 240, 260, 240, 260);

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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_keepers_box_button_up = new ImageButton(this.leftPos + 209, this.topPos + 70, 18, 18,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/keepers_box_button_up.png"), ResourceLocation.parse("power:textures/screens/keepers_box_button_up_active.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart3ButtonMessage(0, x, y, z));
						KeepersBoxGUIPart3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_keepers_box_button_up", imagebutton_keepers_box_button_up);
		this.addRenderableWidget(imagebutton_keepers_box_button_up);
		imagebutton_keepers_box_button_down = new ImageButton(this.leftPos + 209, this.topPos + 103, 18, 18,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/keepers_box_button_down.png"), ResourceLocation.parse("power:textures/screens/keepers_box_button_down_active.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart3ButtonMessage(1, x, y, z));
						KeepersBoxGUIPart3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_keepers_box_button_down", imagebutton_keepers_box_button_down);
		this.addRenderableWidget(imagebutton_keepers_box_button_down);
		imagebutton_light_element = new ImageButton(this.leftPos + 95, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/light_element.png"), ResourceLocation.parse("power:textures/screens/light_element_highlighted.png")), e -> {
					if (LightStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart3ButtonMessage(2, x, y, z));
						KeepersBoxGUIPart3ButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (LightStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_light_element", imagebutton_light_element);
		this.addRenderableWidget(imagebutton_light_element);
		imagebutton_shadow_element = new ImageButton(this.leftPos + 138, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/shadow_element.png"), ResourceLocation.parse("power:textures/screens/shadow_element_highlighted.png")), e -> {
					if (ShadowStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart3ButtonMessage(3, x, y, z));
						KeepersBoxGUIPart3ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ShadowStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_shadow_element", imagebutton_shadow_element);
		this.addRenderableWidget(imagebutton_shadow_element);
		imagebutton_sun_element = new ImageButton(this.leftPos + 162, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/sun_element.png"), ResourceLocation.parse("power:textures/screens/sun_element_highlighted.png")), e -> {
					if (SunStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart3ButtonMessage(4, x, y, z));
						KeepersBoxGUIPart3ButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (SunStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_sun_element", imagebutton_sun_element);
		this.addRenderableWidget(imagebutton_sun_element);
		imagebutton_space_element = new ImageButton(this.leftPos + 184, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/space_element.png"), ResourceLocation.parse("power:textures/screens/space_element_highlighted.png")), e -> {
					if (SpaceStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart3ButtonMessage(5, x, y, z));
						KeepersBoxGUIPart3ButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (SpaceStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_space_element", imagebutton_space_element);
		this.addRenderableWidget(imagebutton_space_element);
		imagebutton_moon_element = new ImageButton(this.leftPos + 162, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/moon_element.png"), ResourceLocation.parse("power:textures/screens/moon_element_highlighted.png")), e -> {
					if (MoonStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart3ButtonMessage(6, x, y, z));
						KeepersBoxGUIPart3ButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (MoonStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_moon_element", imagebutton_moon_element);
		this.addRenderableWidget(imagebutton_moon_element);
		imagebutton_vacuum_element = new ImageButton(this.leftPos + 184, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/vacuum_element.png"), ResourceLocation.parse("power:textures/screens/vacuum_element_highlighted.png")), e -> {
					if (VacuumStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart3ButtonMessage(7, x, y, z));
						KeepersBoxGUIPart3ButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (VacuumStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_vacuum_element", imagebutton_vacuum_element);
		this.addRenderableWidget(imagebutton_vacuum_element);
		imagebutton_blood_element = new ImageButton(this.leftPos + 49, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/blood_element.png"), ResourceLocation.parse("power:textures/screens/blood_element_highlighted.png")), e -> {
					if (BloodStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart3ButtonMessage(8, x, y, z));
						KeepersBoxGUIPart3ButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (BloodStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blood_element", imagebutton_blood_element);
		this.addRenderableWidget(imagebutton_blood_element);
		imagebutton_spirit_element = new ImageButton(this.leftPos + 138, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/spirit_element.png"), ResourceLocation.parse("power:textures/screens/spirit_element_highlighted.png")), e -> {
					if (SpiritStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart3ButtonMessage(9, x, y, z));
						KeepersBoxGUIPart3ButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (SpiritStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_spirit_element", imagebutton_spirit_element);
		this.addRenderableWidget(imagebutton_spirit_element);
		imagebutton_form_element = new ImageButton(this.leftPos + 71, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/form_element.png"), ResourceLocation.parse("power:textures/screens/form_element_highlighted.png")), e -> {
					if (FormStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart3ButtonMessage(10, x, y, z));
						KeepersBoxGUIPart3ButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (FormStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_form_element", imagebutton_form_element);
		this.addRenderableWidget(imagebutton_form_element);
		imagebutton_mind_element = new ImageButton(this.leftPos + 49, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/mind_element.png"), ResourceLocation.parse("power:textures/screens/mind_element_highlighted.png")), e -> {
					if (MindStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart3ButtonMessage(11, x, y, z));
						KeepersBoxGUIPart3ButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (MindStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_mind_element", imagebutton_mind_element);
		this.addRenderableWidget(imagebutton_mind_element);
		imagebutton_golden_dust_element = new ImageButton(this.leftPos + 71, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/golden_dust_element.png"), ResourceLocation.parse("power:textures/screens/golden_dust_element_highlighted.png")), e -> {
					if (GoldenDustStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart3ButtonMessage(12, x, y, z));
						KeepersBoxGUIPart3ButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (GoldenDustStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_golden_dust_element", imagebutton_golden_dust_element);
		this.addRenderableWidget(imagebutton_golden_dust_element);
		imagebutton_darkness_element = new ImageButton(this.leftPos + 95, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/darkness_element.png"), ResourceLocation.parse("power:textures/screens/darkness_element_highlighted.png")), e -> {
					if (DarknessStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart3ButtonMessage(13, x, y, z));
						KeepersBoxGUIPart3ButtonMessage.handleButtonAction(entity, 13, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (DarknessStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_darkness_element", imagebutton_darkness_element);
		this.addRenderableWidget(imagebutton_darkness_element);
	}
}
