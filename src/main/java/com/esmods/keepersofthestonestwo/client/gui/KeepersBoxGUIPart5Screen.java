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

import com.esmods.keepersofthestonestwo.world.inventory.KeepersBoxGUIPart5Menu;
import com.esmods.keepersofthestonestwo.network.KeepersBoxGUIPart5ButtonMessage;

public class KeepersBoxGUIPart5Screen extends AbstractContainerScreen<KeepersBoxGUIPart5Menu> {
	private final static HashMap<String, Object> guistate = KeepersBoxGUIPart5Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_keepers_box_button_up;
	ImageButton imagebutton_keepers_box_button_down_locked;
	ImageButton imagebutton_coming_element;
	ImageButton imagebutton_coming_element1;
	ImageButton imagebutton_coming_element2;
	ImageButton imagebutton_coming_element3;
	ImageButton imagebutton_coming_element4;
	ImageButton imagebutton_coming_element5;
	ImageButton imagebutton_coming_element6;
	ImageButton imagebutton_coming_element7;
	ImageButton imagebutton_coming_element8;
	ImageButton imagebutton_coming_element9;
	ImageButton imagebutton_coming_element10;
	ImageButton imagebutton_coming_element11;

	public KeepersBoxGUIPart5Screen(KeepersBoxGUIPart5Menu container, Inventory inventory, Component text) {
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
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("power:textures/screens/keepers_box_gui_part_5.png"), this.leftPos + 5, this.topPos + -34, 0, 0, 240, 260, 240, 260);

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
						PacketDistributor.sendToServer(new KeepersBoxGUIPart5ButtonMessage(0, x, y, z));
						KeepersBoxGUIPart5ButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_keepers_box_button_up", imagebutton_keepers_box_button_up);
		this.addRenderableWidget(imagebutton_keepers_box_button_up);
		imagebutton_keepers_box_button_down_locked = new ImageButton(this.leftPos + 209, this.topPos + 103, 18, 18,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/keepers_box_button_down_locked.png"), ResourceLocation.parse("power:textures/screens/keepers_box_button_down_locked.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_keepers_box_button_down_locked", imagebutton_keepers_box_button_down_locked);
		this.addRenderableWidget(imagebutton_keepers_box_button_down_locked);
		imagebutton_coming_element = new ImageButton(this.leftPos + 49, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/coming_element.png"), ResourceLocation.parse("power:textures/screens/coming_element_highlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new KeepersBoxGUIPart5ButtonMessage(2, x, y, z));
						KeepersBoxGUIPart5ButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_coming_element", imagebutton_coming_element);
		this.addRenderableWidget(imagebutton_coming_element);
		imagebutton_coming_element1 = new ImageButton(this.leftPos + 71, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/coming_element.png"), ResourceLocation.parse("power:textures/screens/coming_element_highlight.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_coming_element1", imagebutton_coming_element1);
		this.addRenderableWidget(imagebutton_coming_element1);
		imagebutton_coming_element2 = new ImageButton(this.leftPos + 95, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/coming_element.png"), ResourceLocation.parse("power:textures/screens/coming_element_highlight.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_coming_element2", imagebutton_coming_element2);
		this.addRenderableWidget(imagebutton_coming_element2);
		imagebutton_coming_element3 = new ImageButton(this.leftPos + 138, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/coming_element.png"), ResourceLocation.parse("power:textures/screens/coming_element_highlight.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_coming_element3", imagebutton_coming_element3);
		this.addRenderableWidget(imagebutton_coming_element3);
		imagebutton_coming_element4 = new ImageButton(this.leftPos + 162, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/coming_element.png"), ResourceLocation.parse("power:textures/screens/coming_element_highlight.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_coming_element4", imagebutton_coming_element4);
		this.addRenderableWidget(imagebutton_coming_element4);
		imagebutton_coming_element5 = new ImageButton(this.leftPos + 184, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/coming_element.png"), ResourceLocation.parse("power:textures/screens/coming_element_highlight.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_coming_element5", imagebutton_coming_element5);
		this.addRenderableWidget(imagebutton_coming_element5);
		imagebutton_coming_element6 = new ImageButton(this.leftPos + 184, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/coming_element.png"), ResourceLocation.parse("power:textures/screens/coming_element_highlight.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_coming_element6", imagebutton_coming_element6);
		this.addRenderableWidget(imagebutton_coming_element6);
		imagebutton_coming_element7 = new ImageButton(this.leftPos + 162, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/coming_element.png"), ResourceLocation.parse("power:textures/screens/coming_element_highlight.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_coming_element7", imagebutton_coming_element7);
		this.addRenderableWidget(imagebutton_coming_element7);
		imagebutton_coming_element8 = new ImageButton(this.leftPos + 138, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/coming_element.png"), ResourceLocation.parse("power:textures/screens/coming_element_highlight.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_coming_element8", imagebutton_coming_element8);
		this.addRenderableWidget(imagebutton_coming_element8);
		imagebutton_coming_element9 = new ImageButton(this.leftPos + 95, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/coming_element.png"), ResourceLocation.parse("power:textures/screens/coming_element_highlight.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_coming_element9", imagebutton_coming_element9);
		this.addRenderableWidget(imagebutton_coming_element9);
		imagebutton_coming_element10 = new ImageButton(this.leftPos + 71, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/coming_element.png"), ResourceLocation.parse("power:textures/screens/coming_element_highlight.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_coming_element10", imagebutton_coming_element10);
		this.addRenderableWidget(imagebutton_coming_element10);
		imagebutton_coming_element11 = new ImageButton(this.leftPos + 49, this.topPos + 106, 16, 16,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/coming_element.png"), ResourceLocation.parse("power:textures/screens/coming_element_highlight.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_coming_element11", imagebutton_coming_element11);
		this.addRenderableWidget(imagebutton_coming_element11);
	}
}
