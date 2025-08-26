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

import com.esmods.keepersofthestonestwo.world.inventory.WheelAbilitiesTechnologyMenu;
import com.esmods.keepersofthestonestwo.procedures.RuneTooltipRenderProcedure;
import com.esmods.keepersofthestonestwo.procedures.PowerLockCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetWheelTwoProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetWheelTwoOrFirstFakeProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetWheelThreeProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetFakeWheelTwoProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetFakeWheelThirdProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetFakeWheelOneProcedure;
import com.esmods.keepersofthestonestwo.network.WheelAbilitiesTechnologyButtonMessage;
import com.esmods.keepersofthestonestwo.init.PowerModScreens;

public class WheelAbilitiesTechnologyScreen extends AbstractContainerScreen<WheelAbilitiesTechnologyMenu> implements PowerModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	ImageButton imagebutton_wheel_button_1;
	ImageButton imagebutton_wheel_button_2;
	ImageButton imagebutton_wheel_button_3;
	ImageButton imagebutton_fake_wheel_button_1;
	ImageButton imagebutton_fake_wheel_button_2;
	ImageButton imagebutton_fake_wheel_button_3;
	ImageButton imagebutton_power_rune_ability;
	ImageButton imagebutton_red_plasma_ball;
	ImageButton imagebutton_technobarrier;
	ImageButton imagebutton_turret;

	public WheelAbilitiesTechnologyScreen(WheelAbilitiesTechnologyMenu container, Inventory inventory, Component text) {
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
		if (mouseX > leftPos + 82 && mouseX < leftPos + 106 && mouseY > topPos + 24 && mouseY < topPos + 48) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.power.wheel_abilities_technology.tooltip_red_plasma_ball_uses_15"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 143 && mouseX < leftPos + 167 && mouseY > topPos + 84 && mouseY < topPos + 108) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.power.wheel_abilities_technology.tooltip_technobarrier_uses_60"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 83 && mouseX < leftPos + 107 && mouseY > topPos + 144 && mouseY < topPos + 168) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.power.wheel_abilities_technology.tooltip_turret_uses_80"), mouseX, mouseY);
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
					int x = WheelAbilitiesTechnologyScreen.this.x;
					int y = WheelAbilitiesTechnologyScreen.this.y;
					if (GetWheelTwoOrFirstFakeProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTechnologyButtonMessage(0, x, y, z));
						WheelAbilitiesTechnologyButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTechnologyScreen.this.x;
				int y = WheelAbilitiesTechnologyScreen.this.y;
				if (GetWheelTwoOrFirstFakeProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_wheel_button_1);
		imagebutton_wheel_button_2 = new ImageButton(this.leftPos + 152, this.topPos + 154, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/wheel_button_2.png"), ResourceLocation.parse("power:textures/screens/wheel_button_2_highlight.png")), e -> {
					int x = WheelAbilitiesTechnologyScreen.this.x;
					int y = WheelAbilitiesTechnologyScreen.this.y;
					if (GetWheelTwoProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTechnologyButtonMessage(1, x, y, z));
						WheelAbilitiesTechnologyButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTechnologyScreen.this.x;
				int y = WheelAbilitiesTechnologyScreen.this.y;
				if (GetWheelTwoProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_wheel_button_2);
		imagebutton_wheel_button_3 = new ImageButton(this.leftPos + 164, this.topPos + 154, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/wheel_button_3.png"), ResourceLocation.parse("power:textures/screens/wheel_button_3_highlight.png")), e -> {
					int x = WheelAbilitiesTechnologyScreen.this.x;
					int y = WheelAbilitiesTechnologyScreen.this.y;
					if (GetWheelThreeProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTechnologyButtonMessage(2, x, y, z));
						WheelAbilitiesTechnologyButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTechnologyScreen.this.x;
				int y = WheelAbilitiesTechnologyScreen.this.y;
				if (GetWheelThreeProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_wheel_button_3);
		imagebutton_fake_wheel_button_1 = new ImageButton(this.leftPos + 140, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_1.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_1_highlight.png")), e -> {
					int x = WheelAbilitiesTechnologyScreen.this.x;
					int y = WheelAbilitiesTechnologyScreen.this.y;
					if (GetFakeWheelOneProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTechnologyButtonMessage(3, x, y, z));
						WheelAbilitiesTechnologyButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTechnologyScreen.this.x;
				int y = WheelAbilitiesTechnologyScreen.this.y;
				if (GetFakeWheelOneProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fake_wheel_button_1);
		imagebutton_fake_wheel_button_2 = new ImageButton(this.leftPos + 152, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_2.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_2_highlight.png")), e -> {
					int x = WheelAbilitiesTechnologyScreen.this.x;
					int y = WheelAbilitiesTechnologyScreen.this.y;
					if (GetFakeWheelTwoProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTechnologyButtonMessage(4, x, y, z));
						WheelAbilitiesTechnologyButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTechnologyScreen.this.x;
				int y = WheelAbilitiesTechnologyScreen.this.y;
				if (GetFakeWheelTwoProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fake_wheel_button_2);
		imagebutton_fake_wheel_button_3 = new ImageButton(this.leftPos + 164, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_3.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_3_highlight.png")), e -> {
					int x = WheelAbilitiesTechnologyScreen.this.x;
					int y = WheelAbilitiesTechnologyScreen.this.y;
					if (GetFakeWheelThirdProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTechnologyButtonMessage(5, x, y, z));
						WheelAbilitiesTechnologyButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTechnologyScreen.this.x;
				int y = WheelAbilitiesTechnologyScreen.this.y;
				if (GetFakeWheelThirdProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fake_wheel_button_3);
		imagebutton_power_rune_ability = new ImageButton(this.leftPos + 11, this.topPos + 73, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/power_rune_ability.png"), ResourceLocation.parse("power:textures/screens/power_rune_ability_highlight.png")), e -> {
					int x = WheelAbilitiesTechnologyScreen.this.x;
					int y = WheelAbilitiesTechnologyScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTechnologyButtonMessage(6, x, y, z));
						WheelAbilitiesTechnologyButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTechnologyScreen.this.x;
				int y = WheelAbilitiesTechnologyScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_power_rune_ability);
		imagebutton_red_plasma_ball = new ImageButton(this.leftPos + 72, this.topPos + 12, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/red_plasma_ball.png"), ResourceLocation.parse("power:textures/screens/red_plasma_ball_highlight.png")), e -> {
					int x = WheelAbilitiesTechnologyScreen.this.x;
					int y = WheelAbilitiesTechnologyScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTechnologyButtonMessage(7, x, y, z));
						WheelAbilitiesTechnologyButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTechnologyScreen.this.x;
				int y = WheelAbilitiesTechnologyScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_red_plasma_ball);
		imagebutton_technobarrier = new ImageButton(this.leftPos + 133, this.topPos + 73, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/technobarrier.png"), ResourceLocation.parse("power:textures/screens/technobarrier_highlight.png")), e -> {
					int x = WheelAbilitiesTechnologyScreen.this.x;
					int y = WheelAbilitiesTechnologyScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesTechnologyButtonMessage(8, x, y, z));
						WheelAbilitiesTechnologyButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTechnologyScreen.this.x;
				int y = WheelAbilitiesTechnologyScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_technobarrier);
		imagebutton_turret = new ImageButton(this.leftPos + 72, this.topPos + 134, 46, 46, new WidgetSprites(ResourceLocation.parse("power:textures/screens/turret.png"), ResourceLocation.parse("power:textures/screens/turret_highlight.png")), e -> {
			int x = WheelAbilitiesTechnologyScreen.this.x;
			int y = WheelAbilitiesTechnologyScreen.this.y;
			if (PowerLockCheckProcedure.execute(entity)) {
				ClientPacketDistributor.sendToServer(new WheelAbilitiesTechnologyButtonMessage(9, x, y, z));
				WheelAbilitiesTechnologyButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesTechnologyScreen.this.x;
				int y = WheelAbilitiesTechnologyScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_turret);
	}
}