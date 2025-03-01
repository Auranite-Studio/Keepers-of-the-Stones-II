package com.esmods.keepersofthestonestwo.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
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
import com.esmods.keepersofthestonestwo.PowerMod;

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
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (FireStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 45 && mouseX < leftPos + 69 && mouseY > topPos + 65 && mouseY < topPos + 89) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_fire"), mouseX, mouseY);
			}
		if (LavaStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 92 && mouseX < leftPos + 116 && mouseY > topPos + 65 && mouseY < topPos + 89) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_lava"), mouseX, mouseY);
			}
		if (EnergyStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 158 && mouseX < leftPos + 182 && mouseY > topPos + 65 && mouseY < topPos + 89) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_energy"), mouseX, mouseY);
			}
		if (RainStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 134 && mouseX < leftPos + 158 && mouseY > topPos + 102 && mouseY < topPos + 126) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_rain"), mouseX, mouseY);
			}
		if (LightningStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 159 && mouseX < leftPos + 183 && mouseY > topPos + 102 && mouseY < topPos + 126) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_lightning"), mouseX, mouseY);
			}
		if (WaterStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 101 && mouseY < topPos + 125) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_water"), mouseX, mouseY);
			}
		if (OceanStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 68 && mouseX < leftPos + 92 && mouseY > topPos + 102 && mouseY < topPos + 126) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_ocean"), mouseX, mouseY);
			}
		if (IceStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 92 && mouseX < leftPos + 116 && mouseY > topPos + 102 && mouseY < topPos + 126) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_ice"), mouseX, mouseY);
			}
		if (ExplosionStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 134 && mouseX < leftPos + 158 && mouseY > topPos + 65 && mouseY < topPos + 89) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_explosion"), mouseX, mouseY);
			}
		if (MagnetStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 183 && mouseX < leftPos + 207 && mouseY > topPos + 103 && mouseY < topPos + 127) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_magnet"), mouseX, mouseY);
			}
		if (BlueFlameStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 68 && mouseX < leftPos + 92 && mouseY > topPos + 65 && mouseY < topPos + 89) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_blue_flame"), mouseX, mouseY);
			}
		if (GravityStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 182 && mouseX < leftPos + 206 && mouseY > topPos + 64 && mouseY < topPos + 88) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_1.tooltip_gravity"), mouseX, mouseY);
			}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("power:textures/screens/keepers_box_gui_part_1.png"), this.leftPos + 5, this.topPos + -34, 0, 0, 240, 260, 240, 260);

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
		imagebutton_keepers_box_button_down = new ImageButton(this.leftPos + 209, this.topPos + 103, 18, 18, 0, 0, 18, new ResourceLocation("power:textures/screens/atlas/imagebutton_keepers_box_button_down.png"), 18, 36, e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart1ButtonMessage(0, x, y, z));
				KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_keepers_box_button_down", imagebutton_keepers_box_button_down);
		this.addRenderableWidget(imagebutton_keepers_box_button_down);
		imagebutton_keepers_box_button_up_locked = new ImageButton(this.leftPos + 209, this.topPos + 70, 18, 18, 0, 0, 18, new ResourceLocation("power:textures/screens/atlas/imagebutton_keepers_box_button_up_locked.png"), 18, 36, e -> {
		});
		guistate.put("button:imagebutton_keepers_box_button_up_locked", imagebutton_keepers_box_button_up_locked);
		this.addRenderableWidget(imagebutton_keepers_box_button_up_locked);
		imagebutton_fire_element = new ImageButton(this.leftPos + 49, this.topPos + 69, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_fire_element.png"), 16, 32, e -> {
			if (FireStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart1ButtonMessage(2, x, y, z));
				KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = FireStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_fire_element", imagebutton_fire_element);
		this.addRenderableWidget(imagebutton_fire_element);
		imagebutton_lava_element = new ImageButton(this.leftPos + 95, this.topPos + 69, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_lava_element.png"), 16, 32, e -> {
			if (LavaStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart1ButtonMessage(3, x, y, z));
				KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = LavaStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_lava_element", imagebutton_lava_element);
		this.addRenderableWidget(imagebutton_lava_element);
		imagebutton_energy_element = new ImageButton(this.leftPos + 162, this.topPos + 69, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_energy_element.png"), 16, 32, e -> {
			if (EnergyStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart1ButtonMessage(4, x, y, z));
				KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = EnergyStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_energy_element", imagebutton_energy_element);
		this.addRenderableWidget(imagebutton_energy_element);
		imagebutton_rain_element = new ImageButton(this.leftPos + 138, this.topPos + 106, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_rain_element.png"), 16, 32, e -> {
			if (RainStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart1ButtonMessage(5, x, y, z));
				KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = RainStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_rain_element", imagebutton_rain_element);
		this.addRenderableWidget(imagebutton_rain_element);
		imagebutton_lightning_element = new ImageButton(this.leftPos + 162, this.topPos + 106, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_lightning_element.png"), 16, 32, e -> {
			if (LightningStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart1ButtonMessage(6, x, y, z));
				KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = LightningStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_lightning_element", imagebutton_lightning_element);
		this.addRenderableWidget(imagebutton_lightning_element);
		imagebutton_water_element = new ImageButton(this.leftPos + 49, this.topPos + 106, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_water_element.png"), 16, 32, e -> {
			if (WaterStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart1ButtonMessage(7, x, y, z));
				KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = WaterStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_water_element", imagebutton_water_element);
		this.addRenderableWidget(imagebutton_water_element);
		imagebutton_ocean_element = new ImageButton(this.leftPos + 71, this.topPos + 106, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_ocean_element.png"), 16, 32, e -> {
			if (OceanStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart1ButtonMessage(8, x, y, z));
				KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = OceanStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_ocean_element", imagebutton_ocean_element);
		this.addRenderableWidget(imagebutton_ocean_element);
		imagebutton_ice_element = new ImageButton(this.leftPos + 95, this.topPos + 106, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_ice_element.png"), 16, 32, e -> {
			if (IceStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart1ButtonMessage(9, x, y, z));
				KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = IceStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_ice_element", imagebutton_ice_element);
		this.addRenderableWidget(imagebutton_ice_element);
		imagebutton_explosion_element = new ImageButton(this.leftPos + 138, this.topPos + 69, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_explosion_element.png"), 16, 32, e -> {
			if (ExplosionStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart1ButtonMessage(10, x, y, z));
				KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = ExplosionStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_explosion_element", imagebutton_explosion_element);
		this.addRenderableWidget(imagebutton_explosion_element);
		imagebutton_magnet_element = new ImageButton(this.leftPos + 184, this.topPos + 106, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_magnet_element.png"), 16, 32, e -> {
			if (MagnetStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart1ButtonMessage(11, x, y, z));
				KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = MagnetStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_magnet_element", imagebutton_magnet_element);
		this.addRenderableWidget(imagebutton_magnet_element);
		imagebutton_blue_flame_element = new ImageButton(this.leftPos + 71, this.topPos + 69, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_blue_flame_element.png"), 16, 32, e -> {
			if (BlueFlameStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart1ButtonMessage(12, x, y, z));
				KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = BlueFlameStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_blue_flame_element", imagebutton_blue_flame_element);
		this.addRenderableWidget(imagebutton_blue_flame_element);
		imagebutton_gravity_element = new ImageButton(this.leftPos + 184, this.topPos + 69, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_gravity_element.png"), 16, 32, e -> {
			if (GravityStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart1ButtonMessage(13, x, y, z));
				KeepersBoxGUIPart1ButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = GravityStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_gravity_element", imagebutton_gravity_element);
		this.addRenderableWidget(imagebutton_gravity_element);
	}
}
