
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

import com.esmods.keepersofthestonestwo.world.inventory.KeepersBoxGUIPart3Menu;
import com.esmods.keepersofthestonestwo.procedures.KBtoPart4Procedure;
import com.esmods.keepersofthestonestwo.procedures.KBtoPart2Procedure;
import com.esmods.keepersofthestonestwo.PowerMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KeepersBoxGUIPart3ButtonMessage {
	private final int buttonID, x, y, z;

	public KeepersBoxGUIPart3ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public KeepersBoxGUIPart3ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(KeepersBoxGUIPart3ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(KeepersBoxGUIPart3ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		PowerMod.addNetworkMessage(KeepersBoxGUIPart3ButtonMessage.class, KeepersBoxGUIPart3ButtonMessage::buffer, KeepersBoxGUIPart3ButtonMessage::new, KeepersBoxGUIPart3ButtonMessage::handler);
	}
}
