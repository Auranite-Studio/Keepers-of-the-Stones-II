
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

import com.esmods.keepersofthestonestwo.world.inventory.WheelAbilitiesFormMenu;
import com.esmods.keepersofthestonestwo.procedures.OpenWheelTwoProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenWheelThreeProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenWheelOneProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenFakeWheelThirdProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenFakeWheelSecondProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenFakeWheelOneProcedure;
import com.esmods.keepersofthestonestwo.procedures.Attack179Procedure;
import com.esmods.keepersofthestonestwo.procedures.Attack178Procedure;
import com.esmods.keepersofthestonestwo.procedures.Attack177Procedure;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record WheelAbilitiesFormButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<WheelAbilitiesFormButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "wheel_abilities_form_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, WheelAbilitiesFormButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, WheelAbilitiesFormButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new WheelAbilitiesFormButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<WheelAbilitiesFormButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final WheelAbilitiesFormButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = WheelAbilitiesFormMenu.guistate;
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

			Attack177Procedure.execute(entity);
		}
		if (buttonID == 7) {

			Attack178Procedure.execute(entity);
		}
		if (buttonID == 8) {

			Attack179Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(WheelAbilitiesFormButtonMessage.TYPE, WheelAbilitiesFormButtonMessage.STREAM_CODEC, WheelAbilitiesFormButtonMessage::handleData);
	}
}
