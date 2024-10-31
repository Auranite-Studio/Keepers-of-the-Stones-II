
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import com.esmods.keepersofthestonestwo.client.renderer.WaterAttackProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.TurretRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.TurretProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.StoneAttackProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.SpiritRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.SphereNothingProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.SoundBombProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.SmokeMusketProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.SmokeBombProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.ShadowSphereRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.ShadowRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.RainDropProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.PoisonousThornRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.PoisonPitRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.PoisonDropProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.PoisonBombRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.PlagueBombRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.NoteBombProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.MiniTornadoProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.MeteoriteProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.LightballProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.LavaAttackProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.KnifeAttackProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.IronAttackProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.IceAttackProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.GrenadeRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.GrassBlockAttackProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.GoldAttackProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.EtherAttackProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.EnergyChargeRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.EnergiumGolemRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.DirtBlockAttackProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.DestructionBallProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.CursedSquireRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.CursedKnightRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.CursedKeeperRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.CopperAttackProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.CobblestoneAttackProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.CobbledDeepslateAttackProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.BlackHoleRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.BallLightningProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.AtomicRocketRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.AmethystClusterAttackProjectileRenderer;
import com.esmods.keepersofthestonestwo.client.renderer.AmethystAttackProjectileRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PowerModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(PowerModEntities.MAGIC_FIREBALL_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(PowerModEntities.STONE_ATTACK_PROJECTILE.get(), StoneAttackProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.GRASS_BLOCK_ATTACK_PROJECTILE.get(), GrassBlockAttackProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.DIRT_BLOCK_ATTACK_PROJECTILE.get(), DirtBlockAttackProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.COBBLESTONE_ATTACK_PROJECTILE.get(), CobblestoneAttackProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.COBBLED_DEEPSLATE_ATTACK_PROJECTILE.get(), CobbledDeepslateAttackProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.WATER_ATTACK_PROJECTILE.get(), WaterAttackProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.ETHER_ATTACK_PROJECTILE.get(), EtherAttackProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.ICE_ATTACK_PROJECTILE.get(), IceAttackProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.BALL_LIGHTNING_PROJECTILE.get(), BallLightningProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.AMETHYST_ATTACK_PROJECTILE.get(), AmethystAttackProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.LAVA_ATTACK_PROJECTILE.get(), LavaAttackProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.SOUND_BOMB_PROJECTILE.get(), SoundBombProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.AMETHYST_CLUSTER_ATTACK_PROJECTILE.get(), AmethystClusterAttackProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.RAIN_DROP_PROJECTILE.get(), RainDropProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.MINI_TORNADO_PROJECTILE.get(), MiniTornadoProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.POISONOUS_THORN.get(), PoisonousThornRenderer::new);
		event.registerEntityRenderer(PowerModEntities.COPPER_ATTACK_PROJECTILE.get(), CopperAttackProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.GOLD_ATTACK_PROJECTILE.get(), GoldAttackProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.IRON_ATTACK_PROJECTILE.get(), IronAttackProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.KNIFE_ATTACK_PROJECTILE.get(), KnifeAttackProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.LIGHTBALL_PROJECTILE.get(), LightballProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.SHADOW.get(), ShadowRenderer::new);
		event.registerEntityRenderer(PowerModEntities.SHADOW_SPHERE.get(), ShadowSphereRenderer::new);
		event.registerEntityRenderer(PowerModEntities.SPHERE_NOTHING_PROJECTILE.get(), SphereNothingProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.ENERGY_CHARGE.get(), EnergyChargeRenderer::new);
		event.registerEntityRenderer(PowerModEntities.BLACK_HOLE.get(), BlackHoleRenderer::new);
		event.registerEntityRenderer(PowerModEntities.METEORITE_PROJECTILE.get(), MeteoriteProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.DESTRUCTION_BALL_PROJECTILE.get(), DestructionBallProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.ENERGIUM_GOLEM.get(), EnergiumGolemRenderer::new);
		event.registerEntityRenderer(PowerModEntities.TURRET.get(), TurretRenderer::new);
		event.registerEntityRenderer(PowerModEntities.TURRET_PROJECTILE.get(), TurretProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.ATOMIC_ROCKET.get(), AtomicRocketRenderer::new);
		event.registerEntityRenderer(PowerModEntities.GRENADE.get(), GrenadeRenderer::new);
		event.registerEntityRenderer(PowerModEntities.POISON_DROP_PROJECTILE.get(), PoisonDropProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.POISON_BOMB.get(), PoisonBombRenderer::new);
		event.registerEntityRenderer(PowerModEntities.POISON_PIT.get(), PoisonPitRenderer::new);
		event.registerEntityRenderer(PowerModEntities.CURSED_KEEPER.get(), CursedKeeperRenderer::new);
		event.registerEntityRenderer(PowerModEntities.MERCURY_BALL_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(PowerModEntities.NOTE_BOMB_PROJECTILE.get(), NoteBombProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.PLAGUE_BOMB.get(), PlagueBombRenderer::new);
		event.registerEntityRenderer(PowerModEntities.BLUE_MAGIC_FIREBALL_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(PowerModEntities.CURSED_KNIGHT.get(), CursedKnightRenderer::new);
		event.registerEntityRenderer(PowerModEntities.SMOKE_MUSKET_PROJECTILE.get(), SmokeMusketProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.SMOKE_BOMB_PROJECTILE.get(), SmokeBombProjectileRenderer::new);
		event.registerEntityRenderer(PowerModEntities.CURSED_SQUIRE.get(), CursedSquireRenderer::new);
		event.registerEntityRenderer(PowerModEntities.SPIRIT.get(), SpiritRenderer::new);
	}
}
