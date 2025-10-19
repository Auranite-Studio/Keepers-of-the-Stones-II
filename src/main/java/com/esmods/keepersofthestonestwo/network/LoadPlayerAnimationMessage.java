package com.esmods.keepersofthestonestwo.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

import com.esmods.keepersofthestonestwo.PowerModPlayerAnimationAPI;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record LoadPlayerAnimationMessage(String animationfile) implements CustomPacketPayload {
	public static final Type<LoadPlayerAnimationMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "load_player_animation"));
	public static final StreamCodec<RegistryFriendlyByteBuf, LoadPlayerAnimationMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, LoadPlayerAnimationMessage message) -> {
		buffer.writeUtf(message.animationfile);
	}, (RegistryFriendlyByteBuf buffer) -> new LoadPlayerAnimationMessage(buffer.readUtf()));

	@Override
	public Type<LoadPlayerAnimationMessage> type() {
		return TYPE;
	}

	public static void handleData(final LoadPlayerAnimationMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.CLIENTBOUND) {
			context.enqueueWork(() -> {
				JsonObject received = null;
				try {
					received = new Gson().fromJson(message.animationfile, JsonObject.class);
				} catch (Exception e) {
					e.printStackTrace();
				}
				PowerModPlayerAnimationAPI.loadAnimationFile(received);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(LoadPlayerAnimationMessage.TYPE, LoadPlayerAnimationMessage.STREAM_CODEC, LoadPlayerAnimationMessage::handleData);
	}
}