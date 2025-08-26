/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import com.esmods.keepersofthestonestwo.network.DetransformationKeyMessage;
import com.esmods.keepersofthestonestwo.network.AbilityWheelOpeningkeyMessage;
import com.esmods.keepersofthestonestwo.network.AbilityUsingKeyMessage;

@EventBusSubscriber(Dist.CLIENT)
public class PowerModKeyMappings {
	public static final KeyMapping DETRANSFORMATION_KEY = new KeyMapping("key.power.detransformation_key", GLFW.GLFW_KEY_U, "key.categories.power2") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new DetransformationKeyMessage(0, 0));
				DetransformationKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_WHEEL_OPENINGKEY = new KeyMapping("key.power.ability_wheel_openingkey", GLFW.GLFW_KEY_Y, "key.categories.power2") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new AbilityWheelOpeningkeyMessage(0, 0));
				AbilityWheelOpeningkeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_USING_KEY = new KeyMapping("key.power.ability_using_key", GLFW.GLFW_KEY_R, "key.categories.power2") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new AbilityUsingKeyMessage(0, 0));
				AbilityUsingKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(DETRANSFORMATION_KEY);
		event.register(ABILITY_WHEEL_OPENINGKEY);
		event.register(ABILITY_USING_KEY);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				DETRANSFORMATION_KEY.consumeClick();
				ABILITY_WHEEL_OPENINGKEY.consumeClick();
				ABILITY_USING_KEY.consumeClick();
			}
		}
	}
}