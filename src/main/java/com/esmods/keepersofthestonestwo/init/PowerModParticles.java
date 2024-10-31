
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import com.esmods.keepersofthestonestwo.client.particle.VacuumParticleParticle;
import com.esmods.keepersofthestonestwo.client.particle.TimeStopParticle;
import com.esmods.keepersofthestonestwo.client.particle.TimeSlowParticle;
import com.esmods.keepersofthestonestwo.client.particle.TimeFastParticle;
import com.esmods.keepersofthestonestwo.client.particle.TeleportationParticleParticle;
import com.esmods.keepersofthestonestwo.client.particle.TechnobarrierParticleParticle;
import com.esmods.keepersofthestonestwo.client.particle.SunParticlesParticle;
import com.esmods.keepersofthestonestwo.client.particle.StarParticleParticle;
import com.esmods.keepersofthestonestwo.client.particle.RunesOfDestructionParticle;
import com.esmods.keepersofthestonestwo.client.particle.RunesOfCreationParticle;
import com.esmods.keepersofthestonestwo.client.particle.RedMagnetParticleParticle;
import com.esmods.keepersofthestonestwo.client.particle.PoisonParticleParticle;
import com.esmods.keepersofthestonestwo.client.particle.PlagueParticleTwoParticle;
import com.esmods.keepersofthestonestwo.client.particle.PlagueParticleThreeParticle;
import com.esmods.keepersofthestonestwo.client.particle.PlagueParticleOneParticle;
import com.esmods.keepersofthestonestwo.client.particle.PlagueParticleFourParticle;
import com.esmods.keepersofthestonestwo.client.particle.MushroomSporesParticle;
import com.esmods.keepersofthestonestwo.client.particle.MoonParticleParticle;
import com.esmods.keepersofthestonestwo.client.particle.MistParticleParticle;
import com.esmods.keepersofthestonestwo.client.particle.MindReactionParticleParticle;
import com.esmods.keepersofthestonestwo.client.particle.MercuryParticleParticle;
import com.esmods.keepersofthestonestwo.client.particle.LightSparkleParticle;
import com.esmods.keepersofthestonestwo.client.particle.InsectsParticle;
import com.esmods.keepersofthestonestwo.client.particle.FeatherParticleParticle;
import com.esmods.keepersofthestonestwo.client.particle.EnergySparkParticle;
import com.esmods.keepersofthestonestwo.client.particle.EnergiumGolemCoreAttackParticleParticle;
import com.esmods.keepersofthestonestwo.client.particle.BlueMagnetParticleParticle;
import com.esmods.keepersofthestonestwo.client.particle.BloodSplashParticle;
import com.esmods.keepersofthestonestwo.client.particle.BassBoomParticle;
import com.esmods.keepersofthestonestwo.client.particle.AmberPowerParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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
	}
}
