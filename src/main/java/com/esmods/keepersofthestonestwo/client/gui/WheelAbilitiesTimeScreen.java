package com.esmods.keepersofthestonestwo.client.gui;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.esmods.keepersofthestonestwo.world.inventory.WheelAbilitiesTimeMenu;
import com.esmods.keepersofthestonestwo.procedures.*;
import com.esmods.keepersofthestonestwo.network.WheelAbilitiesTimeButtonMessage;
import com.esmods.keepersofthestonestwo.init.PowerModScreens;

public class WheelAbilitiesTimeScreen extends AbstractContainerScreen<WheelAbilitiesTimeMenu> implements PowerModScreens.ScreenAccessor {
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
	private ImageButton imagebutton_time_stopping;
	private ImageButton imagebutton_time_dilation;
	private ImageButton imagebutton_acceleration_time;

	public WheelAbilitiesTimeScreen(WheelAbilitiesTimeMenu container, Inventory inventory, Component text) {
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
				guiGraphics.setComponentTooltipForNextFrame(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 81 && mouseX < leftPos + 105 && mouseY > topPos + 143 && mouseY < topPos + 167) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.power.wheel_abilities_time.tooltip_stopping_time_uses_30"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 82 && mouseX < leftPos + 106 && mouseY > topPos + 23 && mouseY < topPos + 47) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.power.wheel_abilities_time.tooltip_time_dilation_uses_30"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 142 && mouseX < leftPos + 166 && mouseY > topPos + 84 && mouseY < topPos + 108) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.power.wheel_abilities_time.tooltip_acceleration_of_time_uses_30"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("power:textures/screens/wheel_of_abilities.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 192, 192, 192, 192);
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
					int x = WheelAbilitiesTimeScreen.this.x;
					int y = WheelAbilitiesTimeScreen.this.y;
					if (GetWheelTwoOrFirstFakeProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTimeButtonMessage(0, x, y, z));
						WheelAbilitiesTimeButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTimeScreen.this.x;
				int y = WheelAbilitiesTimeScreen.this.y;
				if (GetWheelTwoOrFirstFakeProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_wheel_button_1);
		imagebutton_wheel_button_2 = new ImageButton(this.leftPos + 152, this.topPos + 154, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/wheel_button_2.png"), ResourceLocation.parse("power:textures/screens/wheel_button_2_highlight.png")), e -> {
					int x = WheelAbilitiesTimeScreen.this.x;
					int y = WheelAbilitiesTimeScreen.this.y;
					if (GetWheelTwoProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTimeButtonMessage(1, x, y, z));
						WheelAbilitiesTimeButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTimeScreen.this.x;
				int y = WheelAbilitiesTimeScreen.this.y;
				if (GetWheelTwoProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_wheel_button_2);
		imagebutton_wheel_button_3 = new ImageButton(this.leftPos + 164, this.topPos + 154, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/wheel_button_3.png"), ResourceLocation.parse("power:textures/screens/wheel_button_3_highlight.png")), e -> {
					int x = WheelAbilitiesTimeScreen.this.x;
					int y = WheelAbilitiesTimeScreen.this.y;
					if (GetWheelThreeProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTimeButtonMessage(2, x, y, z));
						WheelAbilitiesTimeButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTimeScreen.this.x;
				int y = WheelAbilitiesTimeScreen.this.y;
				if (GetWheelThreeProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_wheel_button_3);
		imagebutton_fake_wheel_button_1 = new ImageButton(this.leftPos + 140, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_1.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_1_highlight.png")), e -> {
					int x = WheelAbilitiesTimeScreen.this.x;
					int y = WheelAbilitiesTimeScreen.this.y;
					if (GetFakeWheelOneProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTimeButtonMessage(3, x, y, z));
						WheelAbilitiesTimeButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTimeScreen.this.x;
				int y = WheelAbilitiesTimeScreen.this.y;
				if (GetFakeWheelOneProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fake_wheel_button_1);
		imagebutton_fake_wheel_button_2 = new ImageButton(this.leftPos + 152, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_2.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_2_highlight.png")), e -> {
					int x = WheelAbilitiesTimeScreen.this.x;
					int y = WheelAbilitiesTimeScreen.this.y;
					if (GetFakeWheelTwoProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTimeButtonMessage(4, x, y, z));
						WheelAbilitiesTimeButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTimeScreen.this.x;
				int y = WheelAbilitiesTimeScreen.this.y;
				if (GetFakeWheelTwoProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fake_wheel_button_2);
		imagebutton_fake_wheel_button_3 = new ImageButton(this.leftPos + 164, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_3.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_3_highlight.png")), e -> {
					int x = WheelAbilitiesTimeScreen.this.x;
					int y = WheelAbilitiesTimeScreen.this.y;
					if (GetFakeWheelThirdProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTimeButtonMessage(5, x, y, z));
						WheelAbilitiesTimeButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTimeScreen.this.x;
				int y = WheelAbilitiesTimeScreen.this.y;
				if (GetFakeWheelThirdProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fake_wheel_button_3);
		imagebutton_power_rune_ability = new ImageButton(this.leftPos + 11, this.topPos + 73, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/power_rune_ability.png"), ResourceLocation.parse("power:textures/screens/power_rune_ability_highlight.png")), e -> {
					int x = WheelAbilitiesTimeScreen.this.x;
					int y = WheelAbilitiesTimeScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTimeButtonMessage(6, x, y, z));
						WheelAbilitiesTimeButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTimeScreen.this.x;
				int y = WheelAbilitiesTimeScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_power_rune_ability);
		imagebutton_time_stopping = new ImageButton(this.leftPos + 72, this.topPos + 134, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/time_stopping.png"), ResourceLocation.parse("power:textures/screens/time_stopping_highlight.png")), e -> {
					int x = WheelAbilitiesTimeScreen.this.x;
					int y = WheelAbilitiesTimeScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTimeButtonMessage(7, x, y, z));
						WheelAbilitiesTimeButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTimeScreen.this.x;
				int y = WheelAbilitiesTimeScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_time_stopping);
		imagebutton_time_dilation = new ImageButton(this.leftPos + 72, this.topPos + 12, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/time_dilation.png"), ResourceLocation.parse("power:textures/screens/time_dilation_highlight.png")), e -> {
					int x = WheelAbilitiesTimeScreen.this.x;
					int y = WheelAbilitiesTimeScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTimeButtonMessage(8, x, y, z));
						WheelAbilitiesTimeButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTimeScreen.this.x;
				int y = WheelAbilitiesTimeScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_time_dilation);
		imagebutton_acceleration_time = new ImageButton(this.leftPos + 133, this.topPos + 73, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/acceleration_time.png"), ResourceLocation.parse("power:textures/screens/acceleration_time_highlight.png")), e -> {
					int x = WheelAbilitiesTimeScreen.this.x;
					int y = WheelAbilitiesTimeScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTimeButtonMessage(9, x, y, z));
						WheelAbilitiesTimeButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTimeScreen.this.x;
				int y = WheelAbilitiesTimeScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_acceleration_time);
	}
}