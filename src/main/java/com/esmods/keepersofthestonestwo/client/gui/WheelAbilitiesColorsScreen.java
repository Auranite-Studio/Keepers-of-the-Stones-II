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

import com.esmods.keepersofthestonestwo.world.inventory.WheelAbilitiesColorsMenu;
import com.esmods.keepersofthestonestwo.procedures.*;
import com.esmods.keepersofthestonestwo.network.WheelAbilitiesColorsButtonMessage;
import com.esmods.keepersofthestonestwo.init.PowerModScreens;

public class WheelAbilitiesColorsScreen extends AbstractContainerScreen<WheelAbilitiesColorsMenu> implements PowerModScreens.ScreenAccessor {
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
	private ImageButton imagebutton_color_ray;
	private ImageButton imagebutton_white_bomb;
	private ImageButton imagebutton_colored_aura;

	public WheelAbilitiesColorsScreen(WheelAbilitiesColorsMenu container, Inventory inventory, Component text) {
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
		if (mouseX > leftPos + 84 && mouseX < leftPos + 108 && mouseY > topPos + 23 && mouseY < topPos + 47) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.power.wheel_abilities_colors.tooltip_color_ray_uses_10"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 144 && mouseX < leftPos + 168 && mouseY > topPos + 84 && mouseY < topPos + 108) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.power.wheel_abilities_colors.tooltip_white_bomb_uses_40"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 82 && mouseX < leftPos + 106 && mouseY > topPos + 145 && mouseY < topPos + 169) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.power.wheel_abilities_colors.tooltip_colored_aura_uses_70"), mouseX, mouseY);
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
					int x = WheelAbilitiesColorsScreen.this.x;
					int y = WheelAbilitiesColorsScreen.this.y;
					if (GetWheelTwoOrFirstFakeProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesColorsButtonMessage(0, x, y, z));
						WheelAbilitiesColorsButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesColorsScreen.this.x;
				int y = WheelAbilitiesColorsScreen.this.y;
				if (GetWheelTwoOrFirstFakeProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_wheel_button_1);
		imagebutton_wheel_button_2 = new ImageButton(this.leftPos + 152, this.topPos + 154, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/wheel_button_2.png"), ResourceLocation.parse("power:textures/screens/wheel_button_2_highlight.png")), e -> {
					int x = WheelAbilitiesColorsScreen.this.x;
					int y = WheelAbilitiesColorsScreen.this.y;
					if (GetWheelTwoProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesColorsButtonMessage(1, x, y, z));
						WheelAbilitiesColorsButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesColorsScreen.this.x;
				int y = WheelAbilitiesColorsScreen.this.y;
				if (GetWheelTwoProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_wheel_button_2);
		imagebutton_wheel_button_3 = new ImageButton(this.leftPos + 164, this.topPos + 154, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/wheel_button_3.png"), ResourceLocation.parse("power:textures/screens/wheel_button_3_highlight.png")), e -> {
					int x = WheelAbilitiesColorsScreen.this.x;
					int y = WheelAbilitiesColorsScreen.this.y;
					if (GetWheelThreeProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesColorsButtonMessage(2, x, y, z));
						WheelAbilitiesColorsButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesColorsScreen.this.x;
				int y = WheelAbilitiesColorsScreen.this.y;
				if (GetWheelThreeProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_wheel_button_3);
		imagebutton_fake_wheel_button_1 = new ImageButton(this.leftPos + 140, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_1.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_1_highlight.png")), e -> {
					int x = WheelAbilitiesColorsScreen.this.x;
					int y = WheelAbilitiesColorsScreen.this.y;
					if (GetFakeWheelOneProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesColorsButtonMessage(3, x, y, z));
						WheelAbilitiesColorsButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesColorsScreen.this.x;
				int y = WheelAbilitiesColorsScreen.this.y;
				if (GetFakeWheelOneProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fake_wheel_button_1);
		imagebutton_fake_wheel_button_2 = new ImageButton(this.leftPos + 152, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_2.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_2_highlight.png")), e -> {
					int x = WheelAbilitiesColorsScreen.this.x;
					int y = WheelAbilitiesColorsScreen.this.y;
					if (GetFakeWheelTwoProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesColorsButtonMessage(4, x, y, z));
						WheelAbilitiesColorsButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesColorsScreen.this.x;
				int y = WheelAbilitiesColorsScreen.this.y;
				if (GetFakeWheelTwoProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fake_wheel_button_2);
		imagebutton_fake_wheel_button_3 = new ImageButton(this.leftPos + 164, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_3.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_3_highlight.png")), e -> {
					int x = WheelAbilitiesColorsScreen.this.x;
					int y = WheelAbilitiesColorsScreen.this.y;
					if (GetFakeWheelThirdProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesColorsButtonMessage(5, x, y, z));
						WheelAbilitiesColorsButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesColorsScreen.this.x;
				int y = WheelAbilitiesColorsScreen.this.y;
				if (GetFakeWheelThirdProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fake_wheel_button_3);
		imagebutton_power_rune_ability = new ImageButton(this.leftPos + 11, this.topPos + 73, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/power_rune_ability.png"), ResourceLocation.parse("power:textures/screens/power_rune_ability_highlight.png")), e -> {
					int x = WheelAbilitiesColorsScreen.this.x;
					int y = WheelAbilitiesColorsScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesColorsButtonMessage(6, x, y, z));
						WheelAbilitiesColorsButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesColorsScreen.this.x;
				int y = WheelAbilitiesColorsScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_power_rune_ability);
		imagebutton_color_ray = new ImageButton(this.leftPos + 72, this.topPos + 12, 46, 46, new WidgetSprites(ResourceLocation.parse("power:textures/screens/color_ray.png"), ResourceLocation.parse("power:textures/screens/color_ray_highlight.png")),
				e -> {
					int x = WheelAbilitiesColorsScreen.this.x;
					int y = WheelAbilitiesColorsScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesColorsButtonMessage(7, x, y, z));
						WheelAbilitiesColorsButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesColorsScreen.this.x;
				int y = WheelAbilitiesColorsScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_color_ray);
		imagebutton_white_bomb = new ImageButton(this.leftPos + 133, this.topPos + 73, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/white_bomb.png"), ResourceLocation.parse("power:textures/screens/white_bomb_highlight.png")), e -> {
					int x = WheelAbilitiesColorsScreen.this.x;
					int y = WheelAbilitiesColorsScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesColorsButtonMessage(8, x, y, z));
						WheelAbilitiesColorsButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesColorsScreen.this.x;
				int y = WheelAbilitiesColorsScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_white_bomb);
		imagebutton_colored_aura = new ImageButton(this.leftPos + 72, this.topPos + 134, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/colored_aura.png"), ResourceLocation.parse("power:textures/screens/colored_aura_highlight.png")), e -> {
					int x = WheelAbilitiesColorsScreen.this.x;
					int y = WheelAbilitiesColorsScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new WheelAbilitiesColorsButtonMessage(9, x, y, z));
						WheelAbilitiesColorsButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesColorsScreen.this.x;
				int y = WheelAbilitiesColorsScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_colored_aura);
	}
}