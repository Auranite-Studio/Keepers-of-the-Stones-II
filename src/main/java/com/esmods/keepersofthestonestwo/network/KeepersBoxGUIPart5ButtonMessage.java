
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

import java.util.HashMap;

import com.esmods.keepersofthestonestwo.world.inventory.KeepersBoxGUIPart5Menu;
import com.esmods.keepersofthestonestwo.procedures.ShockwaveElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.KBtoPart4Procedure;
import com.esmods.keepersofthestonestwo.procedures.HeatElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.ColorsElementGetProcedure;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record KeepersBoxGUIPart5ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<KeepersBoxGUIPart5ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "keepers_box_gui_part_5_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, KeepersBoxGUIPart5ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, KeepersBoxGUIPart5ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new KeepersBoxGUIPart5ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<KeepersBoxGUIPart5ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final KeepersBoxGUIPart5ButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = KeepersBoxGUIPart5Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			KBtoPart4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			HeatElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 12) {

			ShockwaveElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 13) {

			ColorsElementGetProcedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(KeepersBoxGUIPart5ButtonMessage.TYPE, KeepersBoxGUIPart5ButtonMessage.STREAM_CODEC, KeepersBoxGUIPart5ButtonMessage::handleData);
	}
}
