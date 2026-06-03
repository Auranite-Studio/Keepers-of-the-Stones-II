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
import net.minecraft.core.SectionPos;

import com.esmods.keepersofthestonestwo.procedures.*;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber
public record KeepersBoxGUIPart2ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<KeepersBoxGUIPart2ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "keepers_box_gui_part_2_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, KeepersBoxGUIPart2ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, KeepersBoxGUIPart2ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new KeepersBoxGUIPart2ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<KeepersBoxGUIPart2ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final KeepersBoxGUIPart2ButtonMessage message, final IPayloadContext context) {
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
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			KBtoPart1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			KBtoPart3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			CreationElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 3) {

			TimeElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 4) {

			SoundElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 5) {

			AirElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 6) {

			TornadoElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 7) {

			DestructionElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 8) {

			TechnologyElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 9) {

			TeleportationElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 10) {

			MistElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 11) {

			SpeedElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 12) {

			MusicElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 13) {

			SmokeElementGetProcedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(KeepersBoxGUIPart2ButtonMessage.TYPE, KeepersBoxGUIPart2ButtonMessage.STREAM_CODEC, KeepersBoxGUIPart2ButtonMessage::handleData);
	}
}