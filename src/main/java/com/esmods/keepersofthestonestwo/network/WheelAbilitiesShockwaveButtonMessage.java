
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

import com.esmods.keepersofthestonestwo.world.inventory.WheelAbilitiesShockwaveMenu;
import com.esmods.keepersofthestonestwo.procedures.ShockwaveAttack3Procedure;
import com.esmods.keepersofthestonestwo.procedures.ShockwaveAttack2Procedure;
import com.esmods.keepersofthestonestwo.procedures.ShockwaveAttack1Procedure;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record WheelAbilitiesShockwaveButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<WheelAbilitiesShockwaveButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "wheel_abilities_shockwave_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, WheelAbilitiesShockwaveButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, WheelAbilitiesShockwaveButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new WheelAbilitiesShockwaveButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<WheelAbilitiesShockwaveButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final WheelAbilitiesShockwaveButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = WheelAbilitiesShockwaveMenu.guistate;
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

			OpenFakeFirstWheelProcedure.execute();
		}
		if (buttonID == 4) {

			OpenFakeSecondWheelProcedure.execute();
		}
		if (buttonID == 5) {

			OpenFakeThirdWheelProcedure.execute();
		}
		if (buttonID == 6) {

			ShockwaveAttack1Procedure.execute(entity);
		}
		if (buttonID == 7) {

			ShockwaveAttack2Procedure.execute(entity);
		}
		if (buttonID == 8) {

			ShockwaveAttack3Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(WheelAbilitiesShockwaveButtonMessage.TYPE, WheelAbilitiesShockwaveButtonMessage.STREAM_CODEC, WheelAbilitiesShockwaveButtonMessage::handleData);
	}
}
