
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

import com.esmods.keepersofthestonestwo.world.inventory.WheelAbilitiesTeleportationMenu;
import com.esmods.keepersofthestonestwo.procedures.OpenWheelTwoProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenWheelThreeProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenWheelOneProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenFakeWheelThirdProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenFakeWheelSecondProcedure;
import com.esmods.keepersofthestonestwo.procedures.OpenFakeWheelOneProcedure;
import com.esmods.keepersofthestonestwo.procedures.CreatePortalOrangeProcedure;
import com.esmods.keepersofthestonestwo.procedures.CreatePortalBlueProcedure;
import com.esmods.keepersofthestonestwo.procedures.CheckpointTPProcedure;
import com.esmods.keepersofthestonestwo.procedures.CheckpointCreateProcedure;
import com.esmods.keepersofthestonestwo.procedures.Attack113Procedure;
import com.esmods.keepersofthestonestwo.PowerMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WheelAbilitiesTeleportationButtonMessage {
	private final int buttonID, x, y, z;

	public WheelAbilitiesTeleportationButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public WheelAbilitiesTeleportationButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(WheelAbilitiesTeleportationButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(WheelAbilitiesTeleportationButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = WheelAbilitiesTeleportationMenu.guistate;
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

			CreatePortalBlueProcedure.execute(entity);
		}
		if (buttonID == 7) {

			CreatePortalOrangeProcedure.execute(entity);
		}
		if (buttonID == 8) {

			CheckpointCreateProcedure.execute(entity);
		}
		if (buttonID == 9) {

			CheckpointTPProcedure.execute(entity);
		}
		if (buttonID == 10) {

			Attack113Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(WheelAbilitiesTeleportationButtonMessage.class, WheelAbilitiesTeleportationButtonMessage::buffer, WheelAbilitiesTeleportationButtonMessage::new, WheelAbilitiesTeleportationButtonMessage::handler);
	}
}
