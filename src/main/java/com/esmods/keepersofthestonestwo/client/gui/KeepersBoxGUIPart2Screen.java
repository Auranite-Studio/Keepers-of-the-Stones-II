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

import com.esmods.keepersofthestonestwo.world.inventory.KeepersBoxGUIPart2Menu;
import com.esmods.keepersofthestonestwo.procedures.TornadoStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.TimeStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.TeleportationStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.TechnologyStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.SpeedStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.SoundStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.SmokeStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.MusicStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.MistStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.DestructionStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.CreationStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.AirStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.network.KeepersBoxGUIPart2ButtonMessage;

public class KeepersBoxGUIPart2Screen extends AbstractContainerScreen<KeepersBoxGUIPart2Menu> {
	private final static HashMap<String, Object> guistate = KeepersBoxGUIPart2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_keepers_box_button_up;
	ImageButton imagebutton_keepers_box_button_down;
	ImageButton imagebutton_creation_element;
	ImageButton imagebutton_time_element;
	ImageButton imagebutton_sound_element;
	ImageButton imagebutton_air_element;
	ImageButton imagebutton_tornado_element;
	ImageButton imagebutton_destruction_element;
	ImageButton imagebutton_technology_element;
	ImageButton imagebutton_teleportation_element;
	ImageButton imagebutton_mist_element;
	ImageButton imagebutton_speed_element_highlighted;
	ImageButton imagebutton_music_element;
	ImageButton imagebutton_smoke_element;

	public KeepersBoxGUIPart2Screen(KeepersBoxGUIPart2Menu container, Inventory inventory, Component text) {
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
		if (CreationStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 64 && mouseY < topPos + 88)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_2.tooltip_creation"), mouseX, mouseY);
		if (TimeStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 91 && mouseX < leftPos + 115 && mouseY > topPos + 65 && mouseY < topPos + 89)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_2.tooltip_time"), mouseX, mouseY);
		if (SoundStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 134 && mouseX < leftPos + 158 && mouseY > topPos + 65 && mouseY < topPos + 89)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_2.tooltip_sound"), mouseX, mouseY);
		if (AirStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 182 && mouseX < leftPos + 206 && mouseY > topPos + 64 && mouseY < topPos + 88)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_2.tooltip_air"), mouseX, mouseY);
		if (TornadoStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 181 && mouseX < leftPos + 205 && mouseY > topPos + 101 && mouseY < topPos + 125)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_2.tooltip_tornado"), mouseX, mouseY);
		if (DestructionStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 43 && mouseX < leftPos + 67 && mouseY > topPos + 101 && mouseY < topPos + 125)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_2.tooltip_creation1"), mouseX, mouseY);
		if (TechnologyStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 68 && mouseX < leftPos + 92 && mouseY > topPos + 65 && mouseY < topPos + 89)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_2.tooltip_technology"), mouseX, mouseY);
		if (TeleportationStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 67 && mouseX < leftPos + 91 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_2.tooltip_teleportation"), mouseX, mouseY);
		if (MistStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 158 && mouseX < leftPos + 182 && mouseY > topPos + 65 && mouseY < topPos + 89)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_2.tooltip_mist"), mouseX, mouseY);
		if (SpeedStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 91 && mouseX < leftPos + 115 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_2.tooltip_speed"), mouseX, mouseY);
		if (MusicStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 134 && mouseX < leftPos + 158 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_2.tooltip_music"), mouseX, mouseY);
		if (SmokeStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 158 && mouseX < leftPos + 182 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_2.tooltip_smoke"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("power:textures/screens/keepers_box_gui_part_2.png"), this.leftPos + 5, this.topPos + -34, 0, 0, 240, 260, 240, 260);

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
						PacketDistributor.sendToServer(new KeepersBoxGUIPart2ButtonMessage(0, x, y, z));
						KeepersBoxGUIPart2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
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
						PacketDistributor.sendToServer(new KeepersBoxGUIPart2ButtonMessage(1, x, y, z));
						KeepersBoxGUIPart2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_keepers_box_button_down", imagebutton_keepers_box_button_down);
		this.addRenderableWidget(imagebutton_keepers_box_button_down);
		imagebutton_creation_element = new ImageButton(this.leftPos + 49, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/creation_element.png"), ResourceLocation.parse("power:textures/screens/creation_element_highlighted.png")), e -> {
					if (CreationStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart2ButtonMessage(2, x, y, z));
						KeepersBoxGUIPart2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (CreationStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_creation_element", imagebutton_creation_element);
		this.addRenderableWidget(imagebutton_creation_element);
		imagebutton_time_element = new ImageButton(this.leftPos + 95, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/time_element.png"), ResourceLocation.parse("power:textures/screens/time_element_highlighted.png")), e -> {
					if (TimeStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart2ButtonMessage(3, x, y, z));
						KeepersBoxGUIPart2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (TimeStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_time_element", imagebutton_time_element);
		this.addRenderableWidget(imagebutton_time_element);
		imagebutton_sound_element = new ImageButton(this.leftPos + 138, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/sound_element.png"), ResourceLocation.parse("power:textures/screens/sound_element_highlighted.png")), e -> {
					if (SoundStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart2ButtonMessage(4, x, y, z));
						KeepersBoxGUIPart2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (SoundStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_sound_element", imagebutton_sound_element);
		this.addRenderableWidget(imagebutton_sound_element);
		imagebutton_air_element = new ImageButton(this.leftPos + 184, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/air_element.png"), ResourceLocation.parse("power:textures/screens/air_element_highlighted.png")), e -> {
					if (AirStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart2ButtonMessage(5, x, y, z));
						KeepersBoxGUIPart2ButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (AirStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_air_element", imagebutton_air_element);
		this.addRenderableWidget(imagebutton_air_element);
		imagebutton_tornado_element = new ImageButton(this.leftPos + 184, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/tornado_element.png"), ResourceLocation.parse("power:textures/screens/tornado_element_highlighted.png")), e -> {
					if (TornadoStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart2ButtonMessage(6, x, y, z));
						KeepersBoxGUIPart2ButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (TornadoStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tornado_element", imagebutton_tornado_element);
		this.addRenderableWidget(imagebutton_tornado_element);
		imagebutton_destruction_element = new ImageButton(this.leftPos + 49, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/destruction_element.png"), ResourceLocation.parse("power:textures/screens/destruction_element_highlighted.png")), e -> {
					if (DestructionStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart2ButtonMessage(7, x, y, z));
						KeepersBoxGUIPart2ButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (DestructionStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_destruction_element", imagebutton_destruction_element);
		this.addRenderableWidget(imagebutton_destruction_element);
		imagebutton_technology_element = new ImageButton(this.leftPos + 71, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/technology_element.png"), ResourceLocation.parse("power:textures/screens/technology_element_highlighted.png")), e -> {
					if (TechnologyStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart2ButtonMessage(8, x, y, z));
						KeepersBoxGUIPart2ButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (TechnologyStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_technology_element", imagebutton_technology_element);
		this.addRenderableWidget(imagebutton_technology_element);
		imagebutton_teleportation_element = new ImageButton(this.leftPos + 71, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/teleportation_element.png"), ResourceLocation.parse("power:textures/screens/teleportation_element_highlighted.png")), e -> {
					if (TeleportationStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart2ButtonMessage(9, x, y, z));
						KeepersBoxGUIPart2ButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (TeleportationStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_teleportation_element", imagebutton_teleportation_element);
		this.addRenderableWidget(imagebutton_teleportation_element);
		imagebutton_mist_element = new ImageButton(this.leftPos + 162, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/mist_element.png"), ResourceLocation.parse("power:textures/screens/mist_element_highlighted.png")), e -> {
					if (MistStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart2ButtonMessage(10, x, y, z));
						KeepersBoxGUIPart2ButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (MistStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_mist_element", imagebutton_mist_element);
		this.addRenderableWidget(imagebutton_mist_element);
		imagebutton_speed_element_highlighted = new ImageButton(this.leftPos + 95, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/speed_element.png"), ResourceLocation.parse("power:textures/screens/speed_element_highlighted.png")), e -> {
					if (SpeedStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart2ButtonMessage(11, x, y, z));
						KeepersBoxGUIPart2ButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (SpeedStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_speed_element_highlighted", imagebutton_speed_element_highlighted);
		this.addRenderableWidget(imagebutton_speed_element_highlighted);
		imagebutton_music_element = new ImageButton(this.leftPos + 138, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/music_element.png"), ResourceLocation.parse("power:textures/screens/music_element_highlighted.png")), e -> {
					if (MusicStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart2ButtonMessage(12, x, y, z));
						KeepersBoxGUIPart2ButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (MusicStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_music_element", imagebutton_music_element);
		this.addRenderableWidget(imagebutton_music_element);
		imagebutton_smoke_element = new ImageButton(this.leftPos + 162, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/smoke_element.png"), ResourceLocation.parse("power:textures/screens/smoke_element_highlighted.png")), e -> {
					if (SmokeStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart2ButtonMessage(13, x, y, z));
						KeepersBoxGUIPart2ButtonMessage.handleButtonAction(entity, 13, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (SmokeStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_smoke_element", imagebutton_smoke_element);
		this.addRenderableWidget(imagebutton_smoke_element);
	}
}
