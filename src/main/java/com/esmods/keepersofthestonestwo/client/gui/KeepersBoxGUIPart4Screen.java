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

import com.mojang.blaze3d.systems.RenderSystem;

import com.esmods.keepersofthestonestwo.world.inventory.KeepersBoxGUIPart4Menu;
import com.esmods.keepersofthestonestwo.procedures.*;
import com.esmods.keepersofthestonestwo.network.KeepersBoxGUIPart4ButtonMessage;
import com.esmods.keepersofthestonestwo.init.PowerModScreens;

public class KeepersBoxGUIPart4Screen extends AbstractContainerScreen<KeepersBoxGUIPart4Menu> implements PowerModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_keepers_box_button_up;
	private ImageButton imagebutton_keepers_box_button_down_locked;
	private ImageButton imagebutton_animals_element;
	private ImageButton imagebutton_crystal_element;
	private ImageButton imagebutton_ether_element;
	private ImageButton imagebutton_metal_element;
	private ImageButton imagebutton_earth_element;
	private ImageButton imagebutton_plants_element;
	private ImageButton imagebutton_amber_element;
	private ImageButton imagebutton_sand_element;
	private ImageButton imagebutton_poison_element;
	private ImageButton imagebutton_mushrooms_element;
	private ImageButton imagebutton_mercury_element;
	private ImageButton imagebutton_plague_element;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("power:textures/screens/keepers_box_gui_part_4.png");

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
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (AnimalsStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 64 && mouseY < topPos + 88) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_animals"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (CreationStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 91 && mouseX < leftPos + 115 && mouseY > topPos + 64 && mouseY < topPos + 88) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_crystal"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (EtherStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 42 && mouseX < leftPos + 66 && mouseY > topPos + 103 && mouseY < topPos + 127) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_ether"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (MetalStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 133 && mouseX < leftPos + 157 && mouseY > topPos + 64 && mouseY < topPos + 88) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_metal"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (EarthStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 157 && mouseX < leftPos + 181 && mouseY > topPos + 65 && mouseY < topPos + 89) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_earth"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (PlantsStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 182 && mouseX < leftPos + 206 && mouseY > topPos + 65 && mouseY < topPos + 89) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_plants"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (AmberStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 91 && mouseX < leftPos + 115 && mouseY > topPos + 102 && mouseY < topPos + 126) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_amber"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SandStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 159 && mouseX < leftPos + 183 && mouseY > topPos + 102 && mouseY < topPos + 126) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_sand"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (PoisonStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 68 && mouseX < leftPos + 92 && mouseY > topPos + 102 && mouseY < topPos + 126) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_poison"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (MushroomsStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 183 && mouseX < leftPos + 207 && mouseY > topPos + 102 && mouseY < topPos + 126) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_mushrooms"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (MercuryStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 134 && mouseX < leftPos + 158 && mouseY > topPos + 102 && mouseY < topPos + 126) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_mercury"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (PlagueStoneCheckProcedure.execute(world))
			if (mouseX > leftPos + 68 && mouseX < leftPos + 92 && mouseY > topPos + 65 && mouseY < topPos + 89) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.power.keepers_box_gui_part_4.tooltip_plague"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(IMAGE_0, this.leftPos + 5, this.topPos + -34, 0, 0, 240, 260, 240, 260);
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
					int x = KeepersBoxGUIPart4Screen.this.x;
					int y = KeepersBoxGUIPart4Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart4ButtonMessage(0, x, y, z));
						KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_keepers_box_button_up);
		imagebutton_keepers_box_button_down_locked = new ImageButton(this.leftPos + 209, this.topPos + 103, 18, 18,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/keepers_box_button_down.png"), ResourceLocation.parse("power:textures/screens/keepers_box_button_down_active.png")), e -> {
					int x = KeepersBoxGUIPart4Screen.this.x;
					int y = KeepersBoxGUIPart4Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart4ButtonMessage(1, x, y, z));
						KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_keepers_box_button_down_locked);
		imagebutton_animals_element = new ImageButton(this.leftPos + 49, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/animals_element.png"), ResourceLocation.parse("power:textures/screens/animals_element_highlighted.png")), e -> {
					int x = KeepersBoxGUIPart4Screen.this.x;
					int y = KeepersBoxGUIPart4Screen.this.y;
					if (AnimalsStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart4ButtonMessage(2, x, y, z));
						KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = KeepersBoxGUIPart4Screen.this.x;
				int y = KeepersBoxGUIPart4Screen.this.y;
				if (AnimalsStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_animals_element);
		imagebutton_crystal_element = new ImageButton(this.leftPos + 95, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/crystal_element.png"), ResourceLocation.parse("power:textures/screens/crystal_element_highlighted.png")), e -> {
					int x = KeepersBoxGUIPart4Screen.this.x;
					int y = KeepersBoxGUIPart4Screen.this.y;
					if (CrystalStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart4ButtonMessage(3, x, y, z));
						KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = KeepersBoxGUIPart4Screen.this.x;
				int y = KeepersBoxGUIPart4Screen.this.y;
				if (CrystalStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_crystal_element);
		imagebutton_ether_element = new ImageButton(this.leftPos + 49, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/ether_element.png"), ResourceLocation.parse("power:textures/screens/ether_element_highlighted.png")), e -> {
					int x = KeepersBoxGUIPart4Screen.this.x;
					int y = KeepersBoxGUIPart4Screen.this.y;
					if (EtherStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart4ButtonMessage(4, x, y, z));
						KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = KeepersBoxGUIPart4Screen.this.x;
				int y = KeepersBoxGUIPart4Screen.this.y;
				if (EtherStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_ether_element);
		imagebutton_metal_element = new ImageButton(this.leftPos + 138, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/metal_element.png"), ResourceLocation.parse("power:textures/screens/metal_element_highlighted.png")), e -> {
					int x = KeepersBoxGUIPart4Screen.this.x;
					int y = KeepersBoxGUIPart4Screen.this.y;
					if (MetalStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart4ButtonMessage(5, x, y, z));
						KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = KeepersBoxGUIPart4Screen.this.x;
				int y = KeepersBoxGUIPart4Screen.this.y;
				if (MetalStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_metal_element);
		imagebutton_earth_element = new ImageButton(this.leftPos + 162, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/earth_element.png"), ResourceLocation.parse("power:textures/screens/earth_element_highlighted.png")), e -> {
					int x = KeepersBoxGUIPart4Screen.this.x;
					int y = KeepersBoxGUIPart4Screen.this.y;
					if (EarthStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart4ButtonMessage(6, x, y, z));
						KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = KeepersBoxGUIPart4Screen.this.x;
				int y = KeepersBoxGUIPart4Screen.this.y;
				if (EarthStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_earth_element);
		imagebutton_plants_element = new ImageButton(this.leftPos + 184, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/plants_element.png"), ResourceLocation.parse("power:textures/screens/plants_element_highlighted.png")), e -> {
					int x = KeepersBoxGUIPart4Screen.this.x;
					int y = KeepersBoxGUIPart4Screen.this.y;
					if (PlantsStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart4ButtonMessage(7, x, y, z));
						KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = KeepersBoxGUIPart4Screen.this.x;
				int y = KeepersBoxGUIPart4Screen.this.y;
				if (PlantsStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_plants_element);
		imagebutton_amber_element = new ImageButton(this.leftPos + 95, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/amber_element.png"), ResourceLocation.parse("power:textures/screens/amber_element_highlighted.png")), e -> {
					int x = KeepersBoxGUIPart4Screen.this.x;
					int y = KeepersBoxGUIPart4Screen.this.y;
					if (AmberStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart4ButtonMessage(8, x, y, z));
						KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = KeepersBoxGUIPart4Screen.this.x;
				int y = KeepersBoxGUIPart4Screen.this.y;
				if (AmberStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_amber_element);
		imagebutton_sand_element = new ImageButton(this.leftPos + 162, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/sand_element.png"), ResourceLocation.parse("power:textures/screens/sand_element_highlighted.png")), e -> {
					int x = KeepersBoxGUIPart4Screen.this.x;
					int y = KeepersBoxGUIPart4Screen.this.y;
					if (SandStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart4ButtonMessage(9, x, y, z));
						KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = KeepersBoxGUIPart4Screen.this.x;
				int y = KeepersBoxGUIPart4Screen.this.y;
				if (SandStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_sand_element);
		imagebutton_poison_element = new ImageButton(this.leftPos + 71, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/poison_element.png"), ResourceLocation.parse("power:textures/screens/poison_element_highlighted.png")), e -> {
					int x = KeepersBoxGUIPart4Screen.this.x;
					int y = KeepersBoxGUIPart4Screen.this.y;
					if (PoisonStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart4ButtonMessage(10, x, y, z));
						KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = KeepersBoxGUIPart4Screen.this.x;
				int y = KeepersBoxGUIPart4Screen.this.y;
				if (PoisonStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_poison_element);
		imagebutton_mushrooms_element = new ImageButton(this.leftPos + 184, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/mushrooms_element.png"), ResourceLocation.parse("power:textures/screens/mushrooms_element_highlighted.png")), e -> {
					int x = KeepersBoxGUIPart4Screen.this.x;
					int y = KeepersBoxGUIPart4Screen.this.y;
					if (MushroomsStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart4ButtonMessage(11, x, y, z));
						KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = KeepersBoxGUIPart4Screen.this.x;
				int y = KeepersBoxGUIPart4Screen.this.y;
				if (MushroomsStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_mushrooms_element);
		imagebutton_mercury_element = new ImageButton(this.leftPos + 138, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/mercury_element.png"), ResourceLocation.parse("power:textures/screens/mercury_element_highlighted.png")), e -> {
					int x = KeepersBoxGUIPart4Screen.this.x;
					int y = KeepersBoxGUIPart4Screen.this.y;
					if (MercuryStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart4ButtonMessage(12, x, y, z));
						KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = KeepersBoxGUIPart4Screen.this.x;
				int y = KeepersBoxGUIPart4Screen.this.y;
				if (MercuryStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_mercury_element);
		imagebutton_plague_element = new ImageButton(this.leftPos + 71, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/plague_element.png"), ResourceLocation.parse("power:textures/screens/plague_element_highlighted.png")), e -> {
					int x = KeepersBoxGUIPart4Screen.this.x;
					int y = KeepersBoxGUIPart4Screen.this.y;
					if (PlagueStoneCheckProcedure.execute(world)) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart4ButtonMessage(13, x, y, z));
						KeepersBoxGUIPart4ButtonMessage.handleButtonAction(entity, 13, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = KeepersBoxGUIPart4Screen.this.x;
				int y = KeepersBoxGUIPart4Screen.this.y;
				if (PlagueStoneCheckProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_plague_element);
	}
}