/*
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside com.esmods.keepersofthestonestwo as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber
public class Autododging {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {

			if (!(event.getEntity() instanceof Player player)) return;

			// Проверяем, есть ли у игрока наш эффект
			if (player.hasEffect(PowerModMobEffects.DODGING)) {
				DamageSource source = event.getSource();

				// Можно добавить проверку от какого источника урон (по желанию)
				if (source != null) {
					AutoDodgeEffect.performDodge(player);
					event.setCanceled(true); // Отменяем урон
				}
		}
	}
}
