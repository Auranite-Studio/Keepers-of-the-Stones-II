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

import com.esmods.keepersofthestonestwo.world.inventory.KeepersBoxGUIPart4Menu;
import com.esmods.keepersofthestonestwo.procedures.SandStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.PoisonStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.PlantsStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.PlagueStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.MushroomsStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.MetalStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.MercuryStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.EtherStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.EarthStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.CrystalStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.CreationStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.AnimalsStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.AmberStoneCheckProcedure;
import com.esmods.keepersofthestonestwo.network.KeepersBoxGUIPart4ButtonMessage;
import com.esmods.keepersofthestonestwo.PowerMod;

public class KeepersBoxGUIPart4Screen extends AbstractContainerScreen<KeepersBoxGUIPart4Menu> {
	private final static HashMap<String, Object> guistate = KeepersBoxGUIPart4Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_keepers_box_button_up;
	ImageButton imagebutton_keepers_box_button_down_locked;
	ImageButton imagebutton_animals_element;
	ImageButton imagebutton_crystal_element;
	ImageButton imagebutton_ether_element;
	ImageButton imagebutton_metal_element;
	ImageButton imagebutton_earth_element;
	ImageButton imagebutton_plants_element;
	ImageButton imagebutton_amber_element;
	ImageButton imagebutton_sand_element;
	ImageButton imagebutton_poison_element;
	ImageButton imagebutton_mushrooms_element;
	ImageButton imagebutton_mercury_element;
	ImageButton imagebutton_plague_element;

	public KeepersBoxGUIPart4Screen(KeepersBoxGUIPart4Menu container, Inventory inventory, Component text) {
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
		if (AnimalsStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 64 && mouseY < topPos + 88)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_animals"), mouseX, mouseY);
		if (CreationStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 91 && mouseX < leftPos + 115 && mouseY > topPos + 64 && mouseY < topPos + 88)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_crystal"), mouseX, mouseY);
		if (EtherStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 42 && mouseX < leftPos + 66 && mouseY > topPos + 103 && mouseY < topPos + 127)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_ether"), mouseX, mouseY);
		if (MetalStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 133 && mouseX < leftPos + 157 && mouseY > topPos + 64 && mouseY < topPos + 88)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_metal"), mouseX, mouseY);
		if (EarthStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 157 && mouseX < leftPos + 181 && mouseY > topPos + 65 && mouseY < topPos + 89)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_earth"), mouseX, mouseY);
		if (PlantsStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 182 && mouseX < leftPos + 206 && mouseY > topPos + 65 && mouseY < topPos + 89)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_plants"), mouseX, mouseY);
		if (AmberStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 91 && mouseX < leftPos + 115 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_amber"), mouseX, mouseY);
		if (SandStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 159 && mouseX < leftPos + 183 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_sand"), mouseX, mouseY);
		if (PoisonStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 68 && mouseX < leftPos + 92 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_poison"), mouseX, mouseY);
		if (MushroomsStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 183 && mouseX < leftPos + 207 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_mushrooms"), mouseX, mouseY);
		if (MercuryStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 134 && mouseX < leftPos + 158 && mouseY > topPos + 102 && mouseY < topPos + 126)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_mercury"), mouseX, mouseY);
		if (PlagueStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 68 && mouseX < leftPos + 92 && mouseY > topPos + 65 && mouseY < topPos + 89)
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_plague"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("power:textures/screens/keepers_box_gui_part_4.png"), this.leftPos + 5, this.topPos + -34, 0, 0, 240, 260, 240, 260);

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
		imagebutton_keepers_box_button_up = new ImageButton(this.leftPos + 209, this.topPos + 70, 18, 18, 0, 0, 18, new ResourceLocation("power:textures/screens/atlas/imagebutton_keepers_box_button_up.png"), 18, 36, e -> {
			if (true) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart4ButtonMessage(0, x, y, z));
				KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_keepers_box_button_up", imagebutton_keepers_box_button_up);
		this.addRenderableWidget(imagebutton_keepers_box_button_up);
		imagebutton_keepers_box_button_down_locked = new ImageButton(this.leftPos + 209, this.topPos + 103, 18, 18, 0, 0, 18, new ResourceLocation("power:textures/screens/atlas/imagebutton_keepers_box_button_down_locked.png"), 18, 36, e -> {
		});
		guistate.put("button:imagebutton_keepers_box_button_down_locked", imagebutton_keepers_box_button_down_locked);
		this.addRenderableWidget(imagebutton_keepers_box_button_down_locked);
		imagebutton_animals_element = new ImageButton(this.leftPos + 49, this.topPos + 69, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_animals_element.png"), 16, 32, e -> {
			if (AnimalsStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart4ButtonMessage(2, x, y, z));
				KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = AnimalsStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_animals_element", imagebutton_animals_element);
		this.addRenderableWidget(imagebutton_animals_element);
		imagebutton_crystal_element = new ImageButton(this.leftPos + 95, this.topPos + 69, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_crystal_element.png"), 16, 32, e -> {
			if (CrystalStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart4ButtonMessage(3, x, y, z));
				KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = CrystalStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_crystal_element", imagebutton_crystal_element);
		this.addRenderableWidget(imagebutton_crystal_element);
		imagebutton_ether_element = new ImageButton(this.leftPos + 49, this.topPos + 106, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_ether_element.png"), 16, 32, e -> {
			if (EtherStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart4ButtonMessage(4, x, y, z));
				KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = EtherStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_ether_element", imagebutton_ether_element);
		this.addRenderableWidget(imagebutton_ether_element);
		imagebutton_metal_element = new ImageButton(this.leftPos + 138, this.topPos + 69, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_metal_element.png"), 16, 32, e -> {
			if (MetalStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart4ButtonMessage(5, x, y, z));
				KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = MetalStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_metal_element", imagebutton_metal_element);
		this.addRenderableWidget(imagebutton_metal_element);
		imagebutton_earth_element = new ImageButton(this.leftPos + 162, this.topPos + 69, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_earth_element.png"), 16, 32, e -> {
			if (EarthStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart4ButtonMessage(6, x, y, z));
				KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = EarthStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_earth_element", imagebutton_earth_element);
		this.addRenderableWidget(imagebutton_earth_element);
		imagebutton_plants_element = new ImageButton(this.leftPos + 184, this.topPos + 69, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_plants_element.png"), 16, 32, e -> {
			if (PlantsStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart4ButtonMessage(7, x, y, z));
				KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = PlantsStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_plants_element", imagebutton_plants_element);
		this.addRenderableWidget(imagebutton_plants_element);
		imagebutton_amber_element = new ImageButton(this.leftPos + 95, this.topPos + 106, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_amber_element.png"), 16, 32, e -> {
			if (AmberStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart4ButtonMessage(8, x, y, z));
				KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = AmberStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_amber_element", imagebutton_amber_element);
		this.addRenderableWidget(imagebutton_amber_element);
		imagebutton_sand_element = new ImageButton(this.leftPos + 163, this.topPos + 106, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_sand_element.png"), 16, 32, e -> {
			if (SandStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart4ButtonMessage(9, x, y, z));
				KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = SandStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_sand_element", imagebutton_sand_element);
		this.addRenderableWidget(imagebutton_sand_element);
		imagebutton_poison_element = new ImageButton(this.leftPos + 71, this.topPos + 106, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_poison_element.png"), 16, 32, e -> {
			if (PoisonStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart4ButtonMessage(10, x, y, z));
				KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = PoisonStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_poison_element", imagebutton_poison_element);
		this.addRenderableWidget(imagebutton_poison_element);
		imagebutton_mushrooms_element = new ImageButton(this.leftPos + 184, this.topPos + 106, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_mushrooms_element.png"), 16, 32, e -> {
			if (MushroomsStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart4ButtonMessage(11, x, y, z));
				KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = MushroomsStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_mushrooms_element", imagebutton_mushrooms_element);
		this.addRenderableWidget(imagebutton_mushrooms_element);
		imagebutton_mercury_element = new ImageButton(this.leftPos + 138, this.topPos + 106, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_mercury_element.png"), 16, 32, e -> {
			if (MercuryStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart4ButtonMessage(12, x, y, z));
				KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = MercuryStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_mercury_element", imagebutton_mercury_element);
		this.addRenderableWidget(imagebutton_mercury_element);
		imagebutton_plague_element = new ImageButton(this.leftPos + 71, this.topPos + 69, 16, 16, 0, 0, 16, new ResourceLocation("power:textures/screens/atlas/imagebutton_plague_element.png"), 16, 32, e -> {
			if (PlagueStoneCheckProcedure.execute(world)) {
				PowerMod.PACKET_HANDLER.sendToServer(new KeepersBoxGUIPart4ButtonMessage(13, x, y, z));
				KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = PlagueStoneCheckProcedure.execute(world);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_plague_element", imagebutton_plague_element);
		this.addRenderableWidget(imagebutton_plague_element);
	}
}
