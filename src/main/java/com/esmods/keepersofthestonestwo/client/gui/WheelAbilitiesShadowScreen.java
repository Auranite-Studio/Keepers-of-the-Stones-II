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

import com.esmods.keepersofthestonestwo.world.inventory.WheelAbilitiesShadowMenu;
import com.esmods.keepersofthestonestwo.procedures.RuneTooltipRenderProcedure;
import com.esmods.keepersofthestonestwo.procedures.PowerLockCheckProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetWheelTwoProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetWheelTwoOrFirstFakeProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetWheelThreeProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetFakeWheelTwoProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetFakeWheelThirdProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetFakeWheelOneProcedure;
import com.esmods.keepersofthestonestwo.network.WheelAbilitiesShadowButtonMessage;
import com.esmods.keepersofthestonestwo.init.PowerModScreens;

public class WheelAbilitiesShadowScreen extends AbstractContainerScreen<WheelAbilitiesShadowMenu> implements PowerModScreens.ScreenAccessor {
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
	ImageButton imagebutton_shadow_ray;
	ImageButton imagebutton_shadow_sphere;
	ImageButton imagebutton_rising_shadow;

	public WheelAbilitiesShadowScreen(WheelAbilitiesShadowMenu container, Inventory inventory, Component text) {
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
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.power.wheel_abilities_shadow.tooltip_shadow_ray_uses_10"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 144 && mouseX < leftPos + 168 && mouseY > topPos + 84 && mouseY < topPos + 108) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.power.wheel_abilities_shadow.tooltip_shadow_sphere_uses_35"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 82 && mouseX < leftPos + 106 && mouseY > topPos + 146 && mouseY < topPos + 170) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.power.wheel_abilities_shadow.tooltip_rising_shadow_uses_75"), mouseX, mouseY);
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
					int x = WheelAbilitiesShadowScreen.this.x;
					int y = WheelAbilitiesShadowScreen.this.y;
					if (GetWheelTwoOrFirstFakeProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesShadowButtonMessage(0, x, y, z));
						WheelAbilitiesShadowButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesShadowScreen.this.x;
				int y = WheelAbilitiesShadowScreen.this.y;
				if (GetWheelTwoOrFirstFakeProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_wheel_button_1);
		imagebutton_wheel_button_2 = new ImageButton(this.leftPos + 152, this.topPos + 154, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/wheel_button_2.png"), ResourceLocation.parse("power:textures/screens/wheel_button_2_highlight.png")), e -> {
					int x = WheelAbilitiesShadowScreen.this.x;
					int y = WheelAbilitiesShadowScreen.this.y;
					if (GetWheelTwoProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesShadowButtonMessage(1, x, y, z));
						WheelAbilitiesShadowButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesShadowScreen.this.x;
				int y = WheelAbilitiesShadowScreen.this.y;
				if (GetWheelTwoProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_wheel_button_2);
		imagebutton_wheel_button_3 = new ImageButton(this.leftPos + 164, this.topPos + 154, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/wheel_button_3.png"), ResourceLocation.parse("power:textures/screens/wheel_button_3_highlight.png")), e -> {
					int x = WheelAbilitiesShadowScreen.this.x;
					int y = WheelAbilitiesShadowScreen.this.y;
					if (GetWheelThreeProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesShadowButtonMessage(2, x, y, z));
						WheelAbilitiesShadowButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesShadowScreen.this.x;
				int y = WheelAbilitiesShadowScreen.this.y;
				if (GetWheelThreeProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_wheel_button_3);
		imagebutton_fake_wheel_button_1 = new ImageButton(this.leftPos + 140, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_1.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_1_highlight.png")), e -> {
					int x = WheelAbilitiesShadowScreen.this.x;
					int y = WheelAbilitiesShadowScreen.this.y;
					if (GetFakeWheelOneProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesShadowButtonMessage(3, x, y, z));
						WheelAbilitiesShadowButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesShadowScreen.this.x;
				int y = WheelAbilitiesShadowScreen.this.y;
				if (GetFakeWheelOneProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fake_wheel_button_1);
		imagebutton_fake_wheel_button_2 = new ImageButton(this.leftPos + 152, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_2.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_2_highlight.png")), e -> {
					int x = WheelAbilitiesShadowScreen.this.x;
					int y = WheelAbilitiesShadowScreen.this.y;
					if (GetFakeWheelTwoProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesShadowButtonMessage(4, x, y, z));
						WheelAbilitiesShadowButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesShadowScreen.this.x;
				int y = WheelAbilitiesShadowScreen.this.y;
				if (GetFakeWheelTwoProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fake_wheel_button_2);
		imagebutton_fake_wheel_button_3 = new ImageButton(this.leftPos + 164, this.topPos + 164, 10, 7,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/fake_wheel_button_3.png"), ResourceLocation.parse("power:textures/screens/fake_wheel_button_3_highlight.png")), e -> {
					int x = WheelAbilitiesShadowScreen.this.x;
					int y = WheelAbilitiesShadowScreen.this.y;
					if (GetFakeWheelThirdProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesShadowButtonMessage(5, x, y, z));
						WheelAbilitiesShadowButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesShadowScreen.this.x;
				int y = WheelAbilitiesShadowScreen.this.y;
				if (GetFakeWheelThirdProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fake_wheel_button_3);
		imagebutton_power_rune_ability = new ImageButton(this.leftPos + 11, this.topPos + 73, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/power_rune_ability.png"), ResourceLocation.parse("power:textures/screens/power_rune_ability_highlight.png")), e -> {
					int x = WheelAbilitiesShadowScreen.this.x;
					int y = WheelAbilitiesShadowScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesShadowButtonMessage(6, x, y, z));
						WheelAbilitiesShadowButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesShadowScreen.this.x;
				int y = WheelAbilitiesShadowScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_power_rune_ability);
		imagebutton_shadow_ray = new ImageButton(this.leftPos + 72, this.topPos + 12, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/shadow_ray.png"), ResourceLocation.parse("power:textures/screens/shadow_ray_highlight.png")), e -> {
					int x = WheelAbilitiesShadowScreen.this.x;
					int y = WheelAbilitiesShadowScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesShadowButtonMessage(7, x, y, z));
						WheelAbilitiesShadowButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesShadowScreen.this.x;
				int y = WheelAbilitiesShadowScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_shadow_ray);
		imagebutton_shadow_sphere = new ImageButton(this.leftPos + 133, this.topPos + 73, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/shadow_sphere.png"), ResourceLocation.parse("power:textures/screens/shadow_sphere_highlight.png")), e -> {
					int x = WheelAbilitiesShadowScreen.this.x;
					int y = WheelAbilitiesShadowScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesShadowButtonMessage(8, x, y, z));
						WheelAbilitiesShadowButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesShadowScreen.this.x;
				int y = WheelAbilitiesShadowScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_shadow_sphere);
		imagebutton_rising_shadow = new ImageButton(this.leftPos + 72, this.topPos + 134, 46, 46,
				new WidgetSprites(ResourceLocation.parse("power:textures/screens/rising_shadow.png"), ResourceLocation.parse("power:textures/screens/rising_shadow_highlight.png")), e -> {
					int x = WheelAbilitiesShadowScreen.this.x;
					int y = WheelAbilitiesShadowScreen.this.y;
					if (PowerLockCheckProcedure.execute(entity)) {
						ClientPacketDistributor.sendToServer(new WheelAbilitiesShadowButtonMessage(9, x, y, z));
						WheelAbilitiesShadowButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = WheelAbilitiesShadowScreen.this.x;
				int y = WheelAbilitiesShadowScreen.this.y;
				if (PowerLockCheckProcedure.execute(entity))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_rising_shadow);
	}
}