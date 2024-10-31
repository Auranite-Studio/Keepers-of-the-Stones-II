
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import com.esmods.keepersofthestonestwo.procedures.WaterMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.WarpPriIstiechieniiEffiektaProcedure;
import com.esmods.keepersofthestonestwo.procedures.VacuumMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.TornadoMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.TimeStoppedPriIstiechieniiEffiektaProcedure;
import com.esmods.keepersofthestonestwo.procedures.TimeMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.ThirstDarkMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.TeleportationMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.TechnologyMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.SunMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.StunStopSoundProcedure;
import com.esmods.keepersofthestonestwo.procedures.StarRegenerationEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.SpiritMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.SpeedMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.SpaceMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.SoundMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.SmokeMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.SmokeIntangibilityEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.ShadowMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.SandMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.RainMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.PowerLockEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.PoisonMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.PlantsMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.PlagueMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.OceanMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.MusicMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.MushroomsMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.MoonMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.MistMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.MiniaturizationPriIstiechieniiEffiektaProcedure;
import com.esmods.keepersofthestonestwo.procedures.MindMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.MetalMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.MercuryMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.MagnetMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.LightningMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.LightMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.LethalityPriIstiechieniiEffiektaProcedure;
import com.esmods.keepersofthestonestwo.procedures.LavaMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.IronSkinEffectEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.IceMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.HorrorDarkMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.GravityMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.GoldenDustMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.GigantizationPriIstiechieniiEffiektaProcedure;
import com.esmods.keepersofthestonestwo.procedures.FormMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.FireMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.FilthDarkMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.ExplosionMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.EtherMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.EnergyMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.EarthMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.DestructionMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.DarknessMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.CrystalMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.CreationMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.ChaosDarkMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.BlueFlameMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.BloodMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.AnimalsMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.AmberMasterEndProcedure;
import com.esmods.keepersofthestonestwo.procedures.AirMasterEndProcedure;
import com.esmods.keepersofthestonestwo.potion.WhirlwindMobEffect;
import com.esmods.keepersofthestonestwo.potion.WaterMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.WarpMobEffect;
import com.esmods.keepersofthestonestwo.potion.VacuumMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.TornadoMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.TimeStoppedMobEffect;
import com.esmods.keepersofthestonestwo.potion.TimeSlowingMobEffect;
import com.esmods.keepersofthestonestwo.potion.TimeMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.ThirstDarkMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.TeleportationMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.TechnologyMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.TechnobarrierMobEffect;
import com.esmods.keepersofthestonestwo.potion.SunMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.StunMobEffect;
import com.esmods.keepersofthestonestwo.potion.StarRegenerationMobEffect;
import com.esmods.keepersofthestonestwo.potion.SpiritMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.SpeedMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.SpaceMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.SoundMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.SmokeMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.SmokeIntangibilityMobEffect;
import com.esmods.keepersofthestonestwo.potion.ShadowMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.SandMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.RedMagnetPowerMobEffect;
import com.esmods.keepersofthestonestwo.potion.RainMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.PowerLockMobEffect;
import com.esmods.keepersofthestonestwo.potion.PoisonMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.PlantsMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.PlagueMobEffect;
import com.esmods.keepersofthestonestwo.potion.PlagueMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.OceanMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.MusicMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.MushroomsMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.MoonMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.MistMobEffect;
import com.esmods.keepersofthestonestwo.potion.MistMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.MiniaturizationMobEffect;
import com.esmods.keepersofthestonestwo.potion.MindMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.MetalMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.MercuryMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.MagnetMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.LightningMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.LightMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.LethalityMobEffect;
import com.esmods.keepersofthestonestwo.potion.LavaMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.IronSkinMobEffect;
import com.esmods.keepersofthestonestwo.potion.ImmortalityMobEffect;
import com.esmods.keepersofthestonestwo.potion.IceMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.HorrorDarkMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.GravityMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.GoldenDustMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.GigantizationMobEffect;
import com.esmods.keepersofthestonestwo.potion.FormMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.FireMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.FilthDarkMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.ExplosionMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.EtherMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.EnergyMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.EarthMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.DestructionMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.DarknessMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.CrystalMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.CreationMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.ChaosDarkMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.BlueMagnetPowerMobEffect;
import com.esmods.keepersofthestonestwo.potion.BlueFlameMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.BloodMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.AnimalsMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.AmberMasterMobEffect;
import com.esmods.keepersofthestonestwo.potion.AirMasterMobEffect;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber
public class PowerModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, PowerMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> FIRE_MASTER = REGISTRY.register("fire_master", () -> new FireMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> AIR_MASTER = REGISTRY.register("air_master", () -> new AirMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> EARTH_MASTER = REGISTRY.register("earth_master", () -> new EarthMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> WATER_MASTER = REGISTRY.register("water_master", () -> new WaterMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ETHER_MASTER = REGISTRY.register("ether_master", () -> new EtherMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ICE_MASTER = REGISTRY.register("ice_master", () -> new IceMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LIGHTNING_MASTER = REGISTRY.register("lightning_master", () -> new LightningMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SOUND_MASTER = REGISTRY.register("sound_master", () -> new SoundMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LAVA_MASTER = REGISTRY.register("lava_master", () -> new LavaMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CRYSTAL_MASTER = REGISTRY.register("crystal_master", () -> new CrystalMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> RAIN_MASTER = REGISTRY.register("rain_master", () -> new RainMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TORNADO_MASTER = REGISTRY.register("tornado_master", () -> new TornadoMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> OCEAN_MASTER = REGISTRY.register("ocean_master", () -> new OceanMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> PLANTS_MASTER = REGISTRY.register("plants_master", () -> new PlantsMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ANIMALS_MASTER = REGISTRY.register("animals_master", () -> new AnimalsMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> METAL_MASTER = REGISTRY.register("metal_master", () -> new MetalMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> STUN = REGISTRY.register("stun", () -> new StunMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> WHIRLWIND = REGISTRY.register("whirlwind", () -> new WhirlwindMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> IRON_SKIN = REGISTRY.register("iron_skin", () -> new IronSkinMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LIGHT_MASTER = REGISTRY.register("light_master", () -> new LightMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SHADOW_MASTER = REGISTRY.register("shadow_master", () -> new ShadowMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> VACUUM_MASTER = REGISTRY.register("vacuum_master", () -> new VacuumMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> POWER_LOCK = REGISTRY.register("power_lock", () -> new PowerLockMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ENERGY_MASTER = REGISTRY.register("energy_master", () -> new EnergyMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SUN_MASTER = REGISTRY.register("sun_master", () -> new SunMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MOON_MASTER = REGISTRY.register("moon_master", () -> new MoonMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SPACE_MASTER = REGISTRY.register("space_master", () -> new SpaceMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TIME_MASTER = REGISTRY.register("time_master", () -> new TimeMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TIME_SLOWING = REGISTRY.register("time_slowing", () -> new TimeSlowingMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TIME_STOPPED = REGISTRY.register("time_stopped", () -> new TimeStoppedMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CREATION_MASTER = REGISTRY.register("creation_master", () -> new CreationMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> IMMORTALITY = REGISTRY.register("immortality", () -> new ImmortalityMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DESTRUCTION_MASTER = REGISTRY.register("destruction_master", () -> new DestructionMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LETHALITY = REGISTRY.register("lethality", () -> new LethalityMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLOOD_MASTER = REGISTRY.register("blood_master", () -> new BloodMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TECHNOLOGY_MASTER = REGISTRY.register("technology_master", () -> new TechnologyMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TECHNOBARRIER = REGISTRY.register("technobarrier", () -> new TechnobarrierMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TELEPORTATION_MASTER = REGISTRY.register("teleportation_master", () -> new TeleportationMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> EXPLOSION_MASTER = REGISTRY.register("explosion_master", () -> new ExplosionMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> AMBER_MASTER = REGISTRY.register("amber_master", () -> new AmberMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> STAR_REGENERATION = REGISTRY.register("star_regeneration", () -> new StarRegenerationMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MIST_MASTER = REGISTRY.register("mist_master", () -> new MistMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MIST = REGISTRY.register("mist", () -> new MistMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SAND_MASTER = REGISTRY.register("sand_master", () -> new SandMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SPEED_MASTER = REGISTRY.register("speed_master", () -> new SpeedMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> POISON_MASTER = REGISTRY.register("poison_master", () -> new PoisonMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MAGNET_MASTER = REGISTRY.register("magnet_master", () -> new MagnetMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> RED_MAGNET_POWER = REGISTRY.register("red_magnet_power", () -> new RedMagnetPowerMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLUE_MAGNET_POWER = REGISTRY.register("blue_magnet_power", () -> new BlueMagnetPowerMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MUSHROOMS_MASTER = REGISTRY.register("mushrooms_master", () -> new MushroomsMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MERCURY_MASTER = REGISTRY.register("mercury_master", () -> new MercuryMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MUSIC_MASTER = REGISTRY.register("music_master", () -> new MusicMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> PLAGUE_MASTER = REGISTRY.register("plague_master", () -> new PlagueMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> PLAGUE = REGISTRY.register("plague", () -> new PlagueMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLUE_FLAME_MASTER = REGISTRY.register("blue_flame_master", () -> new BlueFlameMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> GRAVITY_MASTER = REGISTRY.register("gravity_master", () -> new GravityMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SMOKE_MASTER = REGISTRY.register("smoke_master", () -> new SmokeMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SMOKE_INTANGIBILITY = REGISTRY.register("smoke_intangibility", () -> new SmokeIntangibilityMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SPIRIT_MASTER = REGISTRY.register("spirit_master", () -> new SpiritMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FORM_MASTER = REGISTRY.register("form_master", () -> new FormMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> WARP = REGISTRY.register("warp", () -> new WarpMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MINIATURIZATION = REGISTRY.register("miniaturization", () -> new MiniaturizationMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> GIGANTIZATION = REGISTRY.register("gigantization", () -> new GigantizationMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MIND_MASTER = REGISTRY.register("mind_master", () -> new MindMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> GOLDEN_DUST_MASTER = REGISTRY.register("golden_dust_master", () -> new GoldenDustMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DARKNESS_MASTER = REGISTRY.register("darkness_master", () -> new DarknessMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> THIRST_DARK_MASTER = REGISTRY.register("thirst_dark_master", () -> new ThirstDarkMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CHAOS_DARK_MASTER = REGISTRY.register("chaos_dark_master", () -> new ChaosDarkMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> HORROR_DARK_MASTER = REGISTRY.register("horror_dark_master", () -> new HorrorDarkMasterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FILTH_DARK_MASTER = REGISTRY.register("filth_dark_master", () -> new FilthDarkMasterMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(FIRE_MASTER)) {
			FireMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(AIR_MASTER)) {
			AirMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(EARTH_MASTER)) {
			EarthMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(WATER_MASTER)) {
			WaterMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(ETHER_MASTER)) {
			EtherMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(ICE_MASTER)) {
			IceMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(LIGHTNING_MASTER)) {
			LightningMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(SOUND_MASTER)) {
			SoundMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(LAVA_MASTER)) {
			LavaMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(CRYSTAL_MASTER)) {
			CrystalMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(RAIN_MASTER)) {
			RainMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(TORNADO_MASTER)) {
			TornadoMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(OCEAN_MASTER)) {
			OceanMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(PLANTS_MASTER)) {
			PlantsMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(ANIMALS_MASTER)) {
			AnimalsMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(METAL_MASTER)) {
			MetalMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(STUN)) {
			StunStopSoundProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(IRON_SKIN)) {
			IronSkinEffectEndProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(LIGHT_MASTER)) {
			LightMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(SHADOW_MASTER)) {
			ShadowMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(VACUUM_MASTER)) {
			VacuumMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(POWER_LOCK)) {
			PowerLockEndProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(ENERGY_MASTER)) {
			EnergyMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(SUN_MASTER)) {
			SunMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(MOON_MASTER)) {
			MoonMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(SPACE_MASTER)) {
			SpaceMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(TIME_MASTER)) {
			TimeMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(TIME_STOPPED)) {
			TimeStoppedPriIstiechieniiEffiektaProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(CREATION_MASTER)) {
			CreationMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(DESTRUCTION_MASTER)) {
			DestructionMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(LETHALITY)) {
			LethalityPriIstiechieniiEffiektaProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(BLOOD_MASTER)) {
			BloodMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(TECHNOLOGY_MASTER)) {
			TechnologyMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(TELEPORTATION_MASTER)) {
			TeleportationMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(EXPLOSION_MASTER)) {
			ExplosionMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(AMBER_MASTER)) {
			AmberMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(STAR_REGENERATION)) {
			StarRegenerationEndProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(MIST_MASTER)) {
			MistMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(SAND_MASTER)) {
			SandMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(SPEED_MASTER)) {
			SpeedMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(POISON_MASTER)) {
			PoisonMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(MAGNET_MASTER)) {
			MagnetMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(MUSHROOMS_MASTER)) {
			MushroomsMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(MERCURY_MASTER)) {
			MercuryMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(MUSIC_MASTER)) {
			MusicMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(PLAGUE_MASTER)) {
			PlagueMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(BLUE_FLAME_MASTER)) {
			BlueFlameMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(GRAVITY_MASTER)) {
			GravityMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(SMOKE_MASTER)) {
			SmokeMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(SMOKE_INTANGIBILITY)) {
			SmokeIntangibilityEndProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(SPIRIT_MASTER)) {
			SpiritMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(FORM_MASTER)) {
			FormMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(WARP)) {
			WarpPriIstiechieniiEffiektaProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(MINIATURIZATION)) {
			MiniaturizationPriIstiechieniiEffiektaProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(GIGANTIZATION)) {
			GigantizationPriIstiechieniiEffiektaProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(MIND_MASTER)) {
			MindMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(GOLDEN_DUST_MASTER)) {
			GoldenDustMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(DARKNESS_MASTER)) {
			DarknessMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(THIRST_DARK_MASTER)) {
			ThirstDarkMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(CHAOS_DARK_MASTER)) {
			ChaosDarkMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(HORROR_DARK_MASTER)) {
			HorrorDarkMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(FILTH_DARK_MASTER)) {
			FilthDarkMasterEndProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		}
	}
}
