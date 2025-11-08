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

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

import com.esmods.keepersofthestonestwo.world.inventory.WheelAbilitiesSmokeMenu;
import com.esmods.keepersofthestonestwo.procedures.*;
import com.esmods.keepersofthestonestwo.network.WheelAbilitiesSmokeButtonMessage;
import com.esmods.keepersofthestonestwo.init.PowerModScreens;

public class WheelAbilitiesSmokeScreen extends AbstractContainerScreen<WheelAbilitiesSmokeMenu> implements PowerModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_wheel_button_1;
	private ImageButton imagebutton_wheel_button_2;
	private ImageButton imagebutton_wheel_button_3;
	private ImageButton imagebutton_fake_wheel_button_1;
	private ImageButton imagebutton_fake_wheel_button_2;
	private ImageButton imagebutton_fake_wheel_button_3;
	private ImageButton imagebutton_power_rune_ability;
	private ImageButton imagebutton_smoke_attack;
	private ImageButton imagebutton_smoke_bomb;
	private ImageButton imagebutton_smoke_intangibility;

	public WheelAbilitiesSmokeScreen(WheelAbilitiesSmokeMenu container, Inventory inventory, Component text) {
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
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 22 && mouseX < leftPos + 46 && mouseY > topPos + 82 && mouseY < topPos + 106) {
			String hoverText = RuneTooltipRenderProcedure.execute(entity);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 83 && mouseX < leftPos + 107 && mouseY > topPos + 22 && mouseY < topPos + 46) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.power.wheel_abilities_smoke.tooltip_smoke_attack_uses_10"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 146 && mouseX < leftPos + 170 && mouseY > topPos + 85 && mouseY < topPos + 109) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.power.wheel_abilities_smoke.tooltip_smoke_bomb_uses_35"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 82 && mouseX < leftPos + 106 && mouseY > topPos + 145 && mouseY < topPos + 169) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.power.wheel_abilities_smoke.tooltip_smoke_intangibility_uses_80"), mouseX, mouseY);
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
					int x = WheelAbilitiesSmokeScreen.this.x;
					int y = WheelAbilitiesSmokeScreen.this.y;
					if (GetWheelTwoOrFirstFakeProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesSmokeButtonMessage(0, x, y, z));
						WheelAbilitiesSmokeButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesSmokeScreen.this.x;
				int y = WheelAbilitiesSmokeScreen.this.y;
				if (GetWheelTwoOrFirstFakeProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_wheel_button_1);
		imagebutton_wheel_button_2 = new ImageButton(this.leftPos + 152, this.topPos + 154, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/wheel_button_2.png"), ResourceLocation.parse("power:textures/screens/wheel_button_2_highlight.png")), e -> {
					int x = WheelAbilitiesSmokeScreen.this.x;
					int y = WheelAbilitiesSmokeScreen.this.y;
					if (GetWheelTwoProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesSmokeButtonMessage(1, x, y, z));
						WheelAbilitiesSmokeButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesSmokeScreen.this.x;
				int y = WheelAbilitiesSmokeScreen.this.y;
				if (GetWheelTwoProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_wheel_button_2);
		imagebutton_wheel_button_3 = new ImageButton(this.leftPos + 164, this.topPos + 154, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/wheel_button_3.png"), ResourceLocation.parse("power:textures/screens/wheel_button_3_highlight.png")), e -> {
					int x = WheelAbilitiesSmokeScreen.this.x;
					int y = WheelAbilitiesSmokeScreen.this.y;
					if (GetWheelThreeProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesSmokeButtonMessage(2, x, y, z));
						WheelAbilitiesSmokeButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesSmokeScreen.this.x;
				int y = WheelAbilitiesSmokeScreen.this.y;
				if (GetWheelThreeProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_wheel_button_3);
		imagebutton_fake_wheel_button_1 = new ImageButton(this.leftPos + 140, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_1.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_1_highlight.png")), e -> {
					int x = WheelAbilitiesSmokeScreen.this.x;
					int y = WheelAbilitiesSmokeScreen.this.y;
					if (GetFakeWheelOneProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesSmokeButtonMessage(3, x, y, z));
						WheelAbilitiesSmokeButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesSmokeScreen.this.x;
				int y = WheelAbilitiesSmokeScreen.this.y;
				if (GetFakeWheelOneProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fake_wheel_button_1);
		imagebutton_fake_wheel_button_2 = new ImageButton(this.leftPos + 152, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_2.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_2_highlight.png")), e -> {
					int x = WheelAbilitiesSmokeScreen.this.x;
					int y = WheelAbilitiesSmokeScreen.this.y;
					if (GetFakeWheelTwoProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesSmokeButtonMessage(4, x, y, z));
						WheelAbilitiesSmokeButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesSmokeScreen.this.x;
				int y = WheelAbilitiesSmokeScreen.this.y;
				if (GetFakeWheelTwoProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fake_wheel_button_2);
		imagebutton_fake_wheel_button_3 = new ImageButton(this.leftPos + 164, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_3.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_3_highlight.png")), e -> {
					int x = WheelAbilitiesSmokeScreen.this.x;
					int y = WheelAbilitiesSmokeScreen.this.y;
					if (GetFakeWheelThirdProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesSmokeButtonMessage(5, x, y, z));
						WheelAbilitiesSmokeButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesSmokeScreen.this.x;
				int y = WheelAbilitiesSmokeScreen.this.y;
				if (GetFakeWheelThirdProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fake_wheel_button_3);
		imagebutton_power_rune_ability = new ImageButton(this.leftPos + 11, this.topPos + 73, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/power_rune_ability.png"), ResourceLocation.parse("power:textures/screens/power_rune_ability_highlight.png")), e -> {
					int x = WheelAbilitiesSmokeScreen.this.x;
					int y = WheelAbilitiesSmokeScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesSmokeButtonMessage(6, x, y, z));
						WheelAbilitiesSmokeButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesSmokeScreen.this.x;
				int y = WheelAbilitiesSmokeScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_power_rune_ability);
		imagebutton_smoke_attack = new ImageButton(this.leftPos + 72, this.topPos + 12, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/smoke_attack.png"), ResourceLocation.parse("power:textures/screens/smoke_attack_highlight.png")), e -> {
					int x = WheelAbilitiesSmokeScreen.this.x;
					int y = WheelAbilitiesSmokeScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesSmokeButtonMessage(7, x, y, z));
						WheelAbilitiesSmokeButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesSmokeScreen.this.x;
				int y = WheelAbilitiesSmokeScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_smoke_attack);
		imagebutton_smoke_bomb = new ImageButton(this.leftPos + 133, this.topPos + 73, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/smoke_bomb.png"), ResourceLocation.parse("power:textures/screens/smoke_bomb_highlight.png")), e -> {
					int x = WheelAbilitiesSmokeScreen.this.x;
					int y = WheelAbilitiesSmokeScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesSmokeButtonMessage(8, x, y, z));
						WheelAbilitiesSmokeButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesSmokeScreen.this.x;
				int y = WheelAbilitiesSmokeScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_smoke_bomb);
		imagebutton_smoke_intangibility = new ImageButton(this.leftPos + 72, this.topPos + 134, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/smoke_intangibility.png"), ResourceLocation.parse("power:textures/screens/smoke_intangibility_highlight.png")), e -> {
					int x = WheelAbilitiesSmokeScreen.this.x;
					int y = WheelAbilitiesSmokeScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesSmokeButtonMessage(9, x, y, z));
						WheelAbilitiesSmokeButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesSmokeScreen.this.x;
				int y = WheelAbilitiesSmokeScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_smoke_intangibility);
	}
}