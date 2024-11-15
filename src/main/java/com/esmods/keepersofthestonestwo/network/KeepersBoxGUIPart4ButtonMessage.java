
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

import com.esmods.keepersofthestonestwo.world.inventory.KeepersBoxGUIPart4Menu;
import com.esmods.keepersofthestonestwo.procedures.SandElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.PoisonElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.PlantsElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.PlagueElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.MushrooomsElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.MetalElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.MercuryElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.KBtoPart3Procedure;
import com.esmods.keepersofthestonestwo.procedures.EtherElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.EarthElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.CrystalElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.AnimalsElementGetProcedure;
import com.esmods.keepersofthestonestwo.procedures.AmberElementGetProcedure;
import com.esmods.keepersofthestonestwo.PowerMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KeepersBoxGUIPart4ButtonMessage {
	private final int buttonID, x, y, z;

	public KeepersBoxGUIPart4ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public KeepersBoxGUIPart4ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(KeepersBoxGUIPart4ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(KeepersBoxGUIPart4ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = KeepersBoxGUIPart4Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			KBtoPart3Procedure.execute(world, x, y, z, entity);
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
		PowerMod.addNetworkMessage(KeepersBoxGUIPart4ButtonMessage.class, KeepersBoxGUIPart4ButtonMessage::buffer, KeepersBoxGUIPart4ButtonMessage::new, KeepersBoxGUIPart4ButtonMessage::handler);
	}
}
