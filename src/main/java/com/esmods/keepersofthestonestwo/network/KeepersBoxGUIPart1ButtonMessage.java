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

import com.esmods.keepersofthestonestwo.procedures.WaterElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.RainElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.OceanElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.MagnetElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.LightningElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.LavaElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.KBtoPart2Procedure;
import com.esmods.keepersofthestonestwo.procedures.IceElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.GravityElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.FireElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.ExplosionElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.EnergyElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.BlueFlameElementGetProcedure;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber
public record KeepersBoxGUIPart1ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<KeepersBoxGUIPart1ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "keepers_box_gui_part_1_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, KeepersBoxGUIPart1ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, KeepersBoxGUIPart1ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new KeepersBoxGUIPart1ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<KeepersBoxGUIPart1ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final KeepersBoxGUIPart1ButtonMessage message, final IPayloadContext context) {
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

			KBtoPart2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			FireElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 3) {

			LavaElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 4) {

			EnergyElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 5) {

			RainElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 6) {

			LightningElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 7) {

			WaterElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 8) {

			OceanElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 9) {

			IceElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 10) {

			ExplosionElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 11) {

			MagnetElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 12) {

			BlueFlameElementGetProcedure.execute(world, entity);
		}
		if (buttonID == 13) {

			GravityElementGetProcedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(KeepersBoxGUIPart1ButtonMessage.TYPE, KeepersBoxGUIPart1ButtonMessage.STREAM_CODEC, KeepersBoxGUIPart1ButtonMessage::handleData);
	}
}