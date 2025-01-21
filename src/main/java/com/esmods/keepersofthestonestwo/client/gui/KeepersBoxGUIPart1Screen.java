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

import com.esmods.keepersofthestonestwo.world.inventory.KeepersBoxGUIPart1Menu;
import com.esmods.keepersofthestonestwo.procedures.WaterStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.RainStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.OceanStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.MagnetStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.LightningStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.LavaStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.IceStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.GravityStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.FireStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.ExplosionStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.EnergyStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.BlueFlameStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.network.KeepersBoxGUIPart1ButtonMessage;

public class KeepersBoxGUIPart1Screen extends AbstractContainerScreen<KeepersBoxGUIPart1Menu> {
	private final static HashMap<String, Object> guistate = KeepersBoxGUIPart1Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_keepers_box_button_down;
	ImageButton imagebutton_keepers_box_button_up_locked;
	ImageButton imagebutton_fire_element;
	ImageButton imagebutton_lava_element;
	ImageButton imagebutton_energy_element;
	ImageButton imagebutton_rain_element;
	ImageButton imagebutton_lightning_element;
	ImageButton imagebutton_water_element;
	ImageButton imagebutton_ocean_element;
	ImageButton imagebutton_ice_element;
	ImageButton imagebutton_explosion_element;
	ImageButton imagebutton_magnet_element;
	ImageButton imagebutton_blue_flame_element;
	ImageButton imagebutton_gravity_element;

	public KeepersBoxGUIPart1Screen(KeepersBoxGUIPart1Menu container, Inventory inventory, Component text) {
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
		if (FireStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 45 && mouseX < leftPos + 69 && mouseY > topPos + 65 && mouseY < topPos + 89)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_fire"), mouseX, mouseY);
		if (LavaStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 92 && mouseX < leftPos + 116 && mouseY > topPos + 65 && mouseY < topPos + 89)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_lava"), mouseX, mouseY);
		if (EnergyStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 158 && mouseX < leftPos + 182 && mouseY > topPos + 65 && mouseY < topPos + 89)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_energy"), mouseX, mouseY);
		if (RainStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 134 && mouseX < leftPos + 158 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_rain"), mouseX, mouseY);
		if (LightningStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 159 && mouseX < leftPos + 183 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_lightning"), mouseX, mouseY);
		if (WaterStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 101 && mouseY < topPos + 125)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_water"), mouseX, mouseY);
		if (OceanStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 68 && mouseX < leftPos + 92 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_ocean"), mouseX, mouseY);
		if (IceStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 92 && mouseX < leftPos + 116 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_ice"), mouseX, mouseY);
		if (ExplosionStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 134 && mouseX < leftPos + 158 && mouseY > topPos + 65 && mouseY < topPos + 89)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_explosion"), mouseX, mouseY);
		if (MagnetStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 183 && mouseX < leftPos + 207 && mouseY > topPos + 103 && mouseY < topPos + 127)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_magnet"), mouseX, mouseY);
		if (BlueFlameStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 68 && mouseX < leftPos + 92 && mouseY > topPos + 65 && mouseY < topPos + 89)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_blue_flame"), mouseX, mouseY);
		if (GravityStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 182 && mouseX < leftPos + 206 && mouseY > topPos + 64 && mouseY < topPos + 88)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_gravity"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("power:textures/screens/keepers_box_gui_part_1.png"), this.leftPos + 5, this.topPos + -34, 0, 0, 240, 260, 240, 260);

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
		imagebutton_keepers_box_button_down = new ImageButton(this.leftPos + 209, this.topPos + 103, 18, 18,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/keepers_box_button_down.png"), ResourceLocation.parse("power:textures/screens/keepers_box_button_down_active.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart1ButtonMessage(0, x, y, z));
						KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_keepers_box_button_down", imagebutton_keepers_box_button_down);
		this.addRenderableWidget(imagebutton_keepers_box_button_down);
		imagebutton_keepers_box_button_up_locked = new ImageButton(this.leftPos + 209, this.topPos + 70, 18, 18,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/keepers_box_button_up_locked.png"), ResourceLocation.parse("power:textures/screens/keepers_box_button_up_locked.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_keepers_box_button_up_locked", imagebutton_keepers_box_button_up_locked);
		this.addRenderableWidget(imagebutton_keepers_box_button_up_locked);
		imagebutton_fire_element = new ImageButton(this.leftPos + 49, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fire_element.png"), ResourceLocation.parse("power:textures/screens/fire_element_highlighted.png")), e -> {
					if (FireStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart1ButtonMessage(2, x, y, z));
						KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (FireStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_fire_element", imagebutton_fire_element);
		this.addRenderableWidget(imagebutton_fire_element);
		imagebutton_lava_element = new ImageButton(this.leftPos + 95, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/lava_element.png"), ResourceLocation.parse("power:textures/screens/lava_element_highlighted.png")), e -> {
					if (LavaStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart1ButtonMessage(3, x, y, z));
						KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (LavaStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_lava_element", imagebutton_lava_element);
		this.addRenderableWidget(imagebutton_lava_element);
		imagebutton_energy_element = new ImageButton(this.leftPos + 162, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/energy_element.png"), ResourceLocation.parse("power:textures/screens/energy_element_highlighted.png")), e -> {
					if (EnergyStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart1ButtonMessage(4, x, y, z));
						KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (EnergyStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_energy_element", imagebutton_energy_element);
		this.addRenderableWidget(imagebutton_energy_element);
		imagebutton_rain_element = new ImageButton(this.leftPos + 138, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/rain_element.png"), ResourceLocation.parse("power:textures/screens/rain_element_highlighted.png")), e -> {
					if (RainStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart1ButtonMessage(5, x, y, z));
						KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (RainStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_rain_element", imagebutton_rain_element);
		this.addRenderableWidget(imagebutton_rain_element);
		imagebutton_lightning_element = new ImageButton(this.leftPos + 162, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/lightning_element.png"), ResourceLocation.parse("power:textures/screens/lightning_element_highlighted.png")), e -> {
					if (LightningStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart1ButtonMessage(6, x, y, z));
						KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (LightningStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_lightning_element", imagebutton_lightning_element);
		this.addRenderableWidget(imagebutton_lightning_element);
		imagebutton_water_element = new ImageButton(this.leftPos + 49, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/water_element.png"), ResourceLocation.parse("power:textures/screens/water_element_highlighted.png")), e -> {
					if (WaterStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart1ButtonMessage(7, x, y, z));
						KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (WaterStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_water_element", imagebutton_water_element);
		this.addRenderableWidget(imagebutton_water_element);
		imagebutton_ocean_element = new ImageButton(this.leftPos + 71, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/ocean_element.png"), ResourceLocation.parse("power:textures/screens/ocean_element_highlighted.png")), e -> {
					if (OceanStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart1ButtonMessage(8, x, y, z));
						KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (OceanStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_ocean_element", imagebutton_ocean_element);
		this.addRenderableWidget(imagebutton_ocean_element);
		imagebutton_ice_element = new ImageButton(this.leftPos + 95, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/ice_element.png"), ResourceLocation.parse("power:textures/screens/ice_element_highlighted.png")), e -> {
					if (IceStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart1ButtonMessage(9, x, y, z));
						KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (IceStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_ice_element", imagebutton_ice_element);
		this.addRenderableWidget(imagebutton_ice_element);
		imagebutton_explosion_element = new ImageButton(this.leftPos + 138, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/explosion_element.png"), ResourceLocation.parse("power:textures/screens/explosion_element_highlighted.png")), e -> {
					if (ExplosionStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart1ButtonMessage(10, x, y, z));
						KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ExplosionStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_explosion_element", imagebutton_explosion_element);
		this.addRenderableWidget(imagebutton_explosion_element);
		imagebutton_magnet_element = new ImageButton(this.leftPos + 184, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/magnet_element.png"), ResourceLocation.parse("power:textures/screens/magnet_element_highlighted.png")), e -> {
					if (MagnetStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart1ButtonMessage(11, x, y, z));
						KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (MagnetStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_magnet_element", imagebutton_magnet_element);
		this.addRenderableWidget(imagebutton_magnet_element);
		imagebutton_blue_flame_element = new ImageButton(this.leftPos + 71, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/blue_flame_element.png"), ResourceLocation.parse("power:textures/screens/blue_flame_element_highlighted.png")), e -> {
					if (BlueFlameStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart1ButtonMessage(12, x, y, z));
						KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (BlueFlameStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blue_flame_element", imagebutton_blue_flame_element);
		this.addRenderableWidget(imagebutton_blue_flame_element);
		imagebutton_gravity_element = new ImageButton(this.leftPos + 184, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/gravity_element.png"), ResourceLocation.parse("power:textures/screens/gravity_element_highlighted.png")), e -> {
					if (GravityStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart1ButtonMessage(13, x, y, z));
						KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 13, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (GravityStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_gravity_element", imagebutton_gravity_element);
		this.addRenderableWidget(imagebutton_gravity_element);
	}
}
