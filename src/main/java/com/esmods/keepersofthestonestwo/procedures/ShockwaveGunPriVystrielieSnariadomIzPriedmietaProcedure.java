package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class ShockwaveGunPriVystrielieSnariadomIzPriedmietaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(new ItemStack(PowerModItems.SHOCKWAVE_GUN.get()), 60);
	}
}
