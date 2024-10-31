
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

import com.esmods.keepersofthestonestwo.world.inventory.KeepersBoxGUIPart3Menu;
import com.esmods.keepersofthestonestwo.procedures.VacuumElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.SunElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.SpiritElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.SpaceElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.ShadowElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.MoonElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.MindElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.LightElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.KBtoPart4Procedure;
import com.esmods.keepersofthestonestwo.procedures.KBtoPart2Procedure;
import com.esmods.keepersofthestonestwo.procedures.GoldenDustElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.FormElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.DarknessElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.BloodElementGetProcedure;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record KeepersBoxGUIPart3ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<KeepersBoxGUIPart3ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "keepers_box_gui_part_3_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, KeepersBoxGUIPart3ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, KeepersBoxGUIPart3ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new KeepersBoxGUIPart3ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<KeepersBoxGUIPart3ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final KeepersBoxGUIPart3ButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = KeepersBoxGUIPart3Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			KBtoPart2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			KBtoPart4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			LightElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 3) {

			ShadowElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 4) {

			SunElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 5) {

			SpaceElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 6) {

			MoonElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 7) {

			VacuumElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 8) {

			BloodElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 9) {

			SpiritElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 10) {

			FormElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 11) {

			MindElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 12) {

			GoldenDustElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 13) {

			DarknessElementGetProcedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(KeepersBoxGUIPart3ButtonMessage.TYPE, KeepersBoxGUIPart3ButtonMessage.STREAM_CODEC, KeepersBoxGUIPart3ButtonMessage::handleData);
	}
}
