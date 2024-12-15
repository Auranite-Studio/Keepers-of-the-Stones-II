
package com.esmods.keepersofthestonestwo.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

import com.esmods.keepersofthestonestwo.world.inventory.KeepersBoxGUIPart2Menu;
import com.esmods.keepersofthestonestwo.procedures.TornadoElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.TimeElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.TeleportationElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.TechnologyElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.SpeedElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.SoundElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.SmokeElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.MusicElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.MistElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.KBtoPart3Procedure;
import com.esmods.keepersofthestonestwo.procedures.KBtoPart1Procedure;
import com.esmods.keepersofthestonestwo.procedures.DestructionElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.CreationElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.AirElementGetProcedure;
import com.esmods.keepersofthestonestwo.PowerMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KeepersBoxGUIPart2ButtonMessage {
	private final int buttonID, x, y, z;

	public KeepersBoxGUIPart2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public KeepersBoxGUIPart2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(KeepersBoxGUIPart2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(KeepersBoxGUIPart2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = KeepersBoxGUIPart2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
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
		PowerMod.addNetworkMessage(KeepersBoxGUIPart2ButtonMessage.class, KeepersBoxGUIPart2ButtonMessage::buffer, KeepersBoxGUIPart2ButtonMessage::new, KeepersBoxGUIPart2ButtonMessage::handler);
	}
}
