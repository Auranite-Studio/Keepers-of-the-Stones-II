
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

import com.esmods.keepersofthestonestwo.world.inventory.WheelAbilitiesHeatMenu;
import com.esmods.keepersofthestonestwo.procedures.HeatAttack3Procedure;
import com.esmods.keepersofthestonestwo.procedures.HeatAttack2Procedure;
import com.esmods.keepersofthestonestwo.procedures.HeatAttack1Procedure;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record WheelAbilitiesHeatButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<WheelAbilitiesHeatButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "wheel_abilities_heat_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, WheelAbilitiesHeatButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, WheelAbilitiesHeatButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new WheelAbilitiesHeatButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<WheelAbilitiesHeatButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final WheelAbilitiesHeatButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = WheelAbilitiesHeatMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenFirstWheelProcedure.execute();
		}
		if (buttonID == 1) {

			OpenSecondWheelProcedure.execute();
		}
		if (buttonID == 2) {

			OpenThirdWheelProcedure.execute();
		}
		if (buttonID == 3) {

			HeatAttack1Procedure.execute(entity);
		}
		if (buttonID == 4) {

			HeatAttack2Procedure.execute(entity);
		}
		if (buttonID == 5) {

			HeatAttack3Procedure.execute(entity);
		}
		if (buttonID == 6) {

			OpenFakeFirstWheelProcedure.execute();
		}
		if (buttonID == 7) {

			OpenFakeSecondWheelProcedure.execute();
		}
		if (buttonID == 8) {

			OpenFakeThirdWheelProcedure.execute();
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(WheelAbilitiesHeatButtonMessage.TYPE, WheelAbilitiesHeatButtonMessage.STREAM_CODEC, WheelAbilitiesHeatButtonMessage::handleData);
	}
}
