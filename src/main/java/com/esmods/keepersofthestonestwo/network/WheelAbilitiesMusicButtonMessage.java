package com.esmods.keepersofthestonestwo.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import com.esmods.keepersofthestonestwo.procedures.*;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber
public record WheelAbilitiesMusicButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<WheelAbilitiesMusicButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "wheel_abilities_music_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, WheelAbilitiesMusicButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, WheelAbilitiesMusicButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new WheelAbilitiesMusicButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<WheelAbilitiesMusicButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final WheelAbilitiesMusicButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenWheelOneProcedure.execute(entity);
		}
		if (buttonID == 1) {

			OpenWheelTwoProcedure.execute(entity);
		}
		if (buttonID == 2) {

			OpenWheelThreeProcedure.execute(entity);
		}
		if (buttonID == 3) {

			OpenFakeWheelOneProcedure.execute(entity);
		}
		if (buttonID == 4) {

			OpenFakeWheelSecondProcedure.execute(entity);
		}
		if (buttonID == 5) {

			OpenFakeWheelThirdProcedure.execute(entity);
		}
		if (buttonID == 6) {

			PowerRuneAbilityProcedure.execute(entity);
		}
		if (buttonID == 7) {

			Attack153Procedure.execute(entity);
		}
		if (buttonID == 8) {

			Attack154Procedure.execute(entity);
		}
		if (buttonID == 9) {

			Attack155Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(WheelAbilitiesMusicButtonMessage.TYPE, WheelAbilitiesMusicButtonMessage.STREAM_CODEC, WheelAbilitiesMusicButtonMessage::handleData);
	}
}