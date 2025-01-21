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

import com.esmods.keepersofthestonestwo.world.inventory.WheelAbilitiesPoisonMenu;
import com.esmods.keepersofthestonestwo.procedures.PowerLockCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetWheelTwoProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetWheelTwoOrFirstFakeProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetWheelThreeProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetFakeWheelTwoProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetFakeWheelThirdProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetFakeWheelOneProcedure;
import com.esmods.keepersofthestonestwo.network.WheelAbilitiesPoisonButtonMessage;

public class WheelAbilitiesPoisonScreen extends AbstractContainerScreen<WheelAbilitiesPoisonMenu> {
	private final static HashMap<String, Object> guistate = WheelAbilitiesPoisonMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_wheel_button_1;
	ImageButton imagebutton_wheel_button_2;
	ImageButton imagebutton_wheel_button_3;
	ImageButton imagebutton_fake_wheel_button_1;
	ImageButton imagebutton_fake_wheel_button_2;
	ImageButton imagebutton_fake_wheel_button_3;
	ImageButton imagebutton_toxic_acid_flow;
	ImageButton imagebutton_poison_bomb;
	ImageButton imagebutton_cleaning;

	public WheelAbilitiesPoisonScreen(WheelAbilitiesPoisonMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 192;
		this.imageHeight = 192;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 82 && mouseX < leftPos + 106 && mouseY > topPos + 24 && mouseY < topPos + 48)
			guiGraphics.renderTooltip(font, Component.translatable("gui.power.wheel_abilities_poison.tooltip_toxic_acid_flow_uses_15"), mouseX, mouseY);
		if (mouseX > leftPos + 145 && mouseX < leftPos + 169 && mouseY > topPos + 85 && mouseY < topPos + 109)
			guiGraphics.renderTooltip(font, Component.translatable("gui.power.wheel_abilities_poison.tooltip_poison_bomb_uses_40"), mouseX, mouseY);
		if (mouseX > leftPos + 82 && mouseX < leftPos + 106 && mouseY > topPos + 146 && mouseY < topPos + 170)
			guiGraphics.renderTooltip(font, Component.translatable("gui.power.wheel_abilities_poison.tooltip_cleaning_uses_70"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("power:textures/screens/wheel_of_abilities.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 192, 192, 192, 192);

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
		imagebutton_wheel_button_1 = new ImageButton(this.leftPos + 140, this.topPos + 154, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/wheel_button_1.png"), ResourceLocation.parse("power:textures/screens/wheel_button_1_highlight.png")), e -> {
					if (GetWheelTwoOrFirstFakeProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesPoisonButtonMessage(0, x, y, z));
						WheelAbilitiesPoisonButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (GetWheelTwoOrFirstFakeProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_wheel_button_1", imagebutton_wheel_button_1);
		this.addRenderableWidget(imagebutton_wheel_button_1);
		imagebutton_wheel_button_2 = new ImageButton(this.leftPos + 152, this.topPos + 154, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/wheel_button_2.png"), ResourceLocation.parse("power:textures/screens/wheel_button_2_highlight.png")), e -> {
					if (GetWheelTwoProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesPoisonButtonMessage(1, x, y, z));
						WheelAbilitiesPoisonButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (GetWheelTwoProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_wheel_button_2", imagebutton_wheel_button_2);
		this.addRenderableWidget(imagebutton_wheel_button_2);
		imagebutton_wheel_button_3 = new ImageButton(this.leftPos + 164, this.topPos + 154, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/wheel_button_3.png"), ResourceLocation.parse("power:textures/screens/wheel_button_3_highlight.png")), e -> {
					if (GetWheelThreeProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesPoisonButtonMessage(2, x, y, z));
						WheelAbilitiesPoisonButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (GetWheelThreeProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_wheel_button_3", imagebutton_wheel_button_3);
		this.addRenderableWidget(imagebutton_wheel_button_3);
		imagebutton_fake_wheel_button_1 = new ImageButton(this.leftPos + 140, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_1.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_1_highlight.png")), e -> {
					if (GetFakeWheelOneProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesPoisonButtonMessage(3, x, y, z));
						WheelAbilitiesPoisonButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (GetFakeWheelOneProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_fake_wheel_button_1", imagebutton_fake_wheel_button_1);
		this.addRenderableWidget(imagebutton_fake_wheel_button_1);
		imagebutton_fake_wheel_button_2 = new ImageButton(this.leftPos + 152, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_2.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_2_highlight.png")), e -> {
					if (GetFakeWheelTwoProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesPoisonButtonMessage(4, x, y, z));
						WheelAbilitiesPoisonButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (GetFakeWheelTwoProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_fake_wheel_button_2", imagebutton_fake_wheel_button_2);
		this.addRenderableWidget(imagebutton_fake_wheel_button_2);
		imagebutton_fake_wheel_button_3 = new ImageButton(this.leftPos + 164, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_3.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_3_highlight.png")), e -> {
					if (GetFakeWheelThirdProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesPoisonButtonMessage(5, x, y, z));
						WheelAbilitiesPoisonButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (GetFakeWheelThirdProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_fake_wheel_button_3", imagebutton_fake_wheel_button_3);
		this.addRenderableWidget(imagebutton_fake_wheel_button_3);
		imagebutton_toxic_acid_flow = new ImageButton(this.leftPos + 72, this.topPos + 12, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/toxic_acid_flow.png"), ResourceLocation.parse("power:textures/screens/toxic_acid_flow_highlight.png")), e -> {
					if (PowerLockCheckProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesPoisonButtonMessage(6, x, y, z));
						WheelAbilitiesPoisonButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_toxic_acid_flow", imagebutton_toxic_acid_flow);
		this.addRenderableWidget(imagebutton_toxic_acid_flow);
		imagebutton_poison_bomb = new ImageButton(this.leftPos + 133, this.topPos + 73, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/poison_bomb.png"), ResourceLocation.parse("power:textures/screens/poison_bomb_highlight.png")), e -> {
					if (PowerLockCheckProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesPoisonButtonMessage(7, x, y, z));
						WheelAbilitiesPoisonButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_poison_bomb", imagebutton_poison_bomb);
		this.addRenderableWidget(imagebutton_poison_bomb);
		imagebutton_cleaning = new ImageButton(this.leftPos + 72, this.topPos + 134, 46, 46, new WidgetSprites(ResourceLocation.parse("power:textures/screens/cleaning.png"), ResourceLocation.parse("power:textures/screens/cleaning_highlight.png")),
				e -> {
					if (PowerLockCheckProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesPoisonButtonMessage(8, x, y, z));
						WheelAbilitiesPoisonButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_cleaning", imagebutton_cleaning);
		this.addRenderableWidget(imagebutton_cleaning);
	}
}
