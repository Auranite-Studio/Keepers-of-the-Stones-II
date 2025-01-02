
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import com.esmods.keepersofthestonestwo.network.DetransformationKeyMessage;
import com.esmods.keepersofthestonestwo.network.AbilityWheelOpeningkeyMessage;
import com.esmods.keepersofthestonestwo.network.AbilityUsingKeyMessage;
import com.esmods.keepersofthestonestwo.PowerMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PowerModKeyMappings {
	public static final KeyMapping DETRANSFORMATION_KEY = new KeyMapping("key.power.detransformation_key", GLFW.GLFW_KEY_U, "key.categories.power2") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PowerMod.PACKET_HANDLER.sendToServer(new DetransformationKeyMessage(0, 0));
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
				PowerMod.PACKET_HANDLER.sendToServer(new AbilityWheelOpeningkeyMessage(0, 0));
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
				PowerMod.PACKET_HANDLER.sendToServer(new AbilityUsingKeyMessage(0, 0));
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

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				DETRANSFORMATION_KEY.consumeClick();
				ABILITY_WHEEL_OPENINGKEY.consumeClick();
				ABILITY_USING_KEY.consumeClick();
			}
		}
	}
}
