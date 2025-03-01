
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

import com.esmods.keepersofthestonestwo.world.inventory.KeepersBoxGUIPart1Menu;
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

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KeepersBoxGUIPart1ButtonMessage {
	private final int buttonID, x, y, z;

	public KeepersBoxGUIPart1ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public KeepersBoxGUIPart1ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(KeepersBoxGUIPart1ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(KeepersBoxGUIPart1ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = KeepersBoxGUIPart1Menu.guistate;
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
		PowerMod.addNetworkMessage(KeepersBoxGUIPart1ButtonMessage.class, KeepersBoxGUIPart1ButtonMessage::buffer, KeepersBoxGUIPart1ButtonMessage::new, KeepersBoxGUIPart1ButtonMessage::handler);
	}
}
