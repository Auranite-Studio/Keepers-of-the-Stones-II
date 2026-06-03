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
public record KeepersBoxGUIPart4ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<KeepersBoxGUIPart4ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "keepers_box_gui_part_4_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, KeepersBoxGUIPart4ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, KeepersBoxGUIPart4ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new KeepersBoxGUIPart4ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<KeepersBoxGUIPart4ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final KeepersBoxGUIPart4ButtonMessage message, final IPayloadContext context) {
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

			KBtoPart3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			KBtoPart5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			AnimalsElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 3) {

			CrystalElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 4) {

			EtherElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 5) {

			MetalElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 6) {

			EarthElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 7) {

			PlantsElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 8) {

			AmberElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 9) {

			SandElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 10) {

			PoisonElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 11) {

			MushrooomsElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 12) {

			MercuryElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 13) {

			PlagueElementGetProcedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(KeepersBoxGUIPart4ButtonMessage.TYPE, KeepersBoxGUIPart4ButtonMessage.STREAM_CODEC, KeepersBoxGUIPart4ButtonMessage::handleData);
	}
}