/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import com.esmods.keepersofthestonestwo.client.particle.*;

@EventBusSubscriber(Dist.CLIENT)
public class PowerModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(PowerModParticleTypes.BASS_BOOM.get(), BassBoomParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.INSECTS.get(), InsectsParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.LIGHT_SPARKLE.get(), LightSparkleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.VACUUM_PARTICLE.get(), VacuumParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.ENERGY_SPARK.get(), EnergySparkParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.SUN_PARTICLES.get(), SunParticlesParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.MOON_PARTICLE.get(), MoonParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.STAR_PARTICLE.get(), StarParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.TIME_SLOW.get(), TimeSlowParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.TIME_STOP.get(), TimeStopParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.TIME_FAST.get(), TimeFastParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.RUNES_OF_CREATION.get(), RunesOfCreationParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.RUNES_OF_DESTRUCTION.get(), RunesOfDestructionParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.TECHNOBARRIER_PARTICLE.get(), TechnobarrierParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.TELEPORTATION_PARTICLE.get(), TeleportationParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.ENERGIUM_GOLEM_CORE_ATTACK_PARTICLE.get(), EnergiumGolemCoreAttackParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.AMBER_POWER.get(), AmberPowerParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.BLOOD_SPLASH.get(), BloodSplashParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.MIST_PARTICLE.get(), MistParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.POISON_PARTICLE.get(), PoisonParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.BLUE_MAGNET_PARTICLE.get(), BlueMagnetParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.RED_MAGNET_PARTICLE.get(), RedMagnetParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.MUSHROOM_SPORES.get(), MushroomSporesParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.MERCURY_PARTICLE.get(), MercuryParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.PLAGUE_PARTICLE_ONE.get(), PlagueParticleOneParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.PLAGUE_PARTICLE_TWO.get(), PlagueParticleTwoParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.PLAGUE_PARTICLE_THREE.get(), PlagueParticleThreeParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.PLAGUE_PARTICLE_FOUR.get(), PlagueParticleFourParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.FEATHER_PARTICLE.get(), FeatherParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.MIND_REACTION_PARTICLE.get(), MindReactionParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.LIGHTNING_PARTICLE.get(), LightningParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.SHOCK_WAVES_PARTICLE.get(), ShockWavesParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.PROTECTION_PARTICLE.get(), ProtectionParticleParticle::provider);
		event.registerSpriteSet(PowerModParticleTypes.CURSED_PORTAL_PARTICLE.get(), CursedPortalParticleParticle::provider);
	}
}