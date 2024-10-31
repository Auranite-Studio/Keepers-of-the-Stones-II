
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

import com.esmods.keepersofthestonestwo.world.inventory.WheelAbilitiesMindMenu;
import com.esmods.keepersofthestonestwo.procedures.RemoteControl3Procedure;
import com.esmods.keepersofthestonestwo.procedures.RemoteControl2Procedure;
import com.esmods.keepersofthestonestwo.procedures.RemoteControl1Procedure;
import com.esmods.keepersofthestonestwo.procedures.OpenWheelTwoProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenWheelThreeProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenWheelOneProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenFakeWheelThirdProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenFakeWheelSecondProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenFakeWheelOneProcedure;
import com.esmods.keepersofthestonestwo.procedures.Attack182Procedure;
import com.esmods.keepersofthestonestwo.procedures.Attack181Procedure;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record WheelAbilitiesMindButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<WheelAbilitiesMindButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "wheel_abilities_mind_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, WheelAbilitiesMindButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, WheelAbilitiesMindButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new WheelAbilitiesMindButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<WheelAbilitiesMindButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final WheelAbilitiesMindButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = WheelAbilitiesMindMenu.guistate;
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

			Attack181Procedure.execute(entity);
		}
		if (buttonID == 7) {

			Attack182Procedure.execute(entity);
		}
		if (buttonID == 8) {

			RemoteControl1Procedure.execute(entity);
		}
		if (buttonID == 9) {

			RemoteControl2Procedure.execute(entity);
		}
		if (buttonID == 10) {

			RemoteControl3Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(WheelAbilitiesMindButtonMessage.TYPE, WheelAbilitiesMindButtonMessage.STREAM_CODEC, WheelAbilitiesMindButtonMessage::handleData);
	}
}
