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

import com.esmods.keepersofthestonestwo.procedures.PowerRuneAbilityProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenWheelTwoProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenWheelThreeProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenWheelOneProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenFakeWheelThirdProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenFakeWheelSecondProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenFakeWheelOneProcedure;
import com.esmods.keepersofthestonestwo.procedures.Attack87Procedure;
import com.esmods.keepersofthestonestwo.procedures.Attack86Procedure;
import com.esmods.keepersofthestonestwo.procedures.Attack85Procedure;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber
public record WheelAbilitiesMoonButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<WheelAbilitiesMoonButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "wheel_abilities_moon_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, WheelAbilitiesMoonButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, WheelAbilitiesMoonButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new WheelAbilitiesMoonButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<WheelAbilitiesMoonButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final WheelAbilitiesMoonButtonMessage message, final IPayloadContext context) {
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

			Attack85Procedure.execute(entity);
		}
		if (buttonID == 8) {

			Attack86Procedure.execute(entity);
		}
		if (buttonID == 9) {

			Attack87Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(WheelAbilitiesMoonButtonMessage.TYPE, WheelAbilitiesMoonButtonMessage.STREAM_CODEC, WheelAbilitiesMoonButtonMessage::handleData);
	}
}