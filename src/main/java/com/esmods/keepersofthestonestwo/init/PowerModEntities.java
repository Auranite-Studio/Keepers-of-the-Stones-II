
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.entity.TurretEntity;
import com.esmods.keepersofthestonestwo.entity.PoisonPitEntity;
import com.esmods.keepersofthestonestwo.entity.CursedSquireEntity;
import com.esmods.keepersofthestonestwo.entity.CursedKnightEntity;
import com.esmods.keepersofthestonestwo.entity.BlackHoleEntity;
import com.esmods.keepersofthestonestwo.PowerMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PowerModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PowerMod.MODID);
	public static final RegistryObject<EntityType<MagicFireballProjectileEntity>> MAGIC_FIREBALL_PROJECTILE = register("magic_fireball_projectile",
			EntityType.Builder.<MagicFireballProjectileEntity>of(MagicFireballProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(MagicFireballProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<StoneAttackProjectileEntity>> STONE_ATTACK_PROJECTILE = register("stone_attack_projectile", EntityType.Builder.<StoneAttackProjectileEntity>of(StoneAttackProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(StoneAttackProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GrassBlockAttackProjectileEntity>> GRASS_BLOCK_ATTACK_PROJECTILE = register("grass_block_attack_projectile",
			EntityType.Builder.<GrassBlockAttackProjectileEntity>of(GrassBlockAttackProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(GrassBlockAttackProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<DirtBlockAttackProjectileEntity>> DIRT_BLOCK_ATTACK_PROJECTILE = register("dirt_block_attack_projectile",
			EntityType.Builder.<DirtBlockAttackProjectileEntity>of(DirtBlockAttackProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(DirtBlockAttackProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CobblestoneAttackProjectileEntity>> COBBLESTONE_ATTACK_PROJECTILE = register("cobblestone_attack_projectile",
			EntityType.Builder.<CobblestoneAttackProjectileEntity>of(CobblestoneAttackProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(CobblestoneAttackProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CobbledDeepslateAttackProjectileEntity>> COBBLED_DEEPSLATE_ATTACK_PROJECTILE = register("cobbled_deepslate_attack_projectile",
			EntityType.Builder.<CobbledDeepslateAttackProjectileEntity>of(CobbledDeepslateAttackProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(CobbledDeepslateAttackProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WaterAttackProjectileEntity>> WATER_ATTACK_PROJECTILE = register("water_attack_projectile", EntityType.Builder.<WaterAttackProjectileEntity>of(WaterAttackProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(WaterAttackProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<EtherAttackProjectileEntity>> ETHER_ATTACK_PROJECTILE = register("ether_attack_projectile", EntityType.Builder.<EtherAttackProjectileEntity>of(EtherAttackProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(EtherAttackProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IceAttackProjectileEntity>> ICE_ATTACK_PROJECTILE = register("ice_attack_projectile", EntityType.Builder.<IceAttackProjectileEntity>of(IceAttackProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(IceAttackProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BallLightningProjectileEntity>> BALL_LIGHTNING_PROJECTILE = register("ball_lightning_projectile",
			EntityType.Builder.<BallLightningProjectileEntity>of(BallLightningProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(BallLightningProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AmethystAttackProjectileEntity>> AMETHYST_ATTACK_PROJECTILE = register("amethyst_attack_projectile",
			EntityType.Builder.<AmethystAttackProjectileEntity>of(AmethystAttackProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(AmethystAttackProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<LavaAttackProjectileEntity>> LAVA_ATTACK_PROJECTILE = register("lava_attack_projectile", EntityType.Builder.<LavaAttackProjectileEntity>of(LavaAttackProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(LavaAttackProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SoundBombProjectileEntity>> SOUND_BOMB_PROJECTILE = register("sound_bomb_projectile", EntityType.Builder.<SoundBombProjectileEntity>of(SoundBombProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(SoundBombProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AmethystClusterAttackProjectileEntity>> AMETHYST_CLUSTER_ATTACK_PROJECTILE = register("amethyst_cluster_attack_projectile",
			EntityType.Builder.<AmethystClusterAttackProjectileEntity>of(AmethystClusterAttackProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(AmethystClusterAttackProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RainDropProjectileEntity>> RAIN_DROP_PROJECTILE = register("rain_drop_projectile", EntityType.Builder.<RainDropProjectileEntity>of(RainDropProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(RainDropProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MiniTornadoProjectileEntity>> MINI_TORNADO_PROJECTILE = register("mini_tornado_projectile", EntityType.Builder.<MiniTornadoProjectileEntity>of(MiniTornadoProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MiniTornadoProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PoisonousThornEntity>> POISONOUS_THORN = register("poisonous_thorn",
			EntityType.Builder.<PoisonousThornEntity>of(PoisonousThornEntity::new, MobCategory.MISC).setCustomClientFactory(PoisonousThornEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CopperAttackProjectileEntity>> COPPER_ATTACK_PROJECTILE = register("copper_attack_projectile", EntityType.Builder.<CopperAttackProjectileEntity>of(CopperAttackProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(CopperAttackProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GoldAttackProjectileEntity>> GOLD_ATTACK_PROJECTILE = register("gold_attack_projectile", EntityType.Builder.<GoldAttackProjectileEntity>of(GoldAttackProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(GoldAttackProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IronAttackProjectileEntity>> IRON_ATTACK_PROJECTILE = register("iron_attack_projectile", EntityType.Builder.<IronAttackProjectileEntity>of(IronAttackProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(IronAttackProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<KnifeAttackProjectileEntity>> KNIFE_ATTACK_PROJECTILE = register("knife_attack_projectile", EntityType.Builder.<KnifeAttackProjectileEntity>of(KnifeAttackProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(KnifeAttackProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<LightballProjectileEntity>> LIGHTBALL_PROJECTILE = register("lightball_projectile", EntityType.Builder.<LightballProjectileEntity>of(LightballProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(LightballProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ShadowEntity>> SHADOW = register("shadow",
			EntityType.Builder.<ShadowEntity>of(ShadowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShadowEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ShadowSphereEntity>> SHADOW_SPHERE = register("shadow_sphere",
			EntityType.Builder.<ShadowSphereEntity>of(ShadowSphereEntity::new, MobCategory.MISC).setCustomClientFactory(ShadowSphereEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SphereNothingProjectileEntity>> SPHERE_NOTHING_PROJECTILE = register("sphere_nothing_projectile",
			EntityType.Builder.<SphereNothingProjectileEntity>of(SphereNothingProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(SphereNothingProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<EnergyChargeEntity>> ENERGY_CHARGE = register("energy_charge",
			EntityType.Builder.<EnergyChargeEntity>of(EnergyChargeEntity::new, MobCategory.MISC).setCustomClientFactory(EnergyChargeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BlackHoleEntity>> BLACK_HOLE = register("black_hole", EntityType.Builder.<BlackHoleEntity>of(BlackHoleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(BlackHoleEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<MeteoriteProjectileEntity>> METEORITE_PROJECTILE = register("meteorite_projectile", EntityType.Builder.<MeteoriteProjectileEntity>of(MeteoriteProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MeteoriteProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<DestructionBallProjectileEntity>> DESTRUCTION_BALL_PROJECTILE = register("destruction_ball_projectile",
			EntityType.Builder.<DestructionBallProjectileEntity>of(DestructionBallProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(DestructionBallProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<EnergiumGolemEntity>> ENERGIUM_GOLEM = register("energium_golem", EntityType.Builder.<EnergiumGolemEntity>of(EnergiumGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(EnergiumGolemEntity::new).fireImmune().sized(2.25f, 2f));
	public static final RegistryObject<EntityType<TurretEntity>> TURRET = register("turret",
			EntityType.Builder.<TurretEntity>of(TurretEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(48).setUpdateInterval(3).setCustomClientFactory(TurretEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TurretProjectileEntity>> TURRET_PROJECTILE = register("turret_projectile", EntityType.Builder.<TurretProjectileEntity>of(TurretProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(TurretProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AtomicRocketEntity>> ATOMIC_ROCKET = register("atomic_rocket",
			EntityType.Builder.<AtomicRocketEntity>of(AtomicRocketEntity::new, MobCategory.MISC).setCustomClientFactory(AtomicRocketEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GrenadeEntity>> GRENADE = register("grenade",
			EntityType.Builder.<GrenadeEntity>of(GrenadeEntity::new, MobCategory.MISC).setCustomClientFactory(GrenadeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PoisonDropProjectileEntity>> POISON_DROP_PROJECTILE = register("poison_drop_projectile", EntityType.Builder.<PoisonDropProjectileEntity>of(PoisonDropProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(PoisonDropProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PoisonBombEntity>> POISON_BOMB = register("poison_bomb",
			EntityType.Builder.<PoisonBombEntity>of(PoisonBombEntity::new, MobCategory.MISC).setCustomClientFactory(PoisonBombEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PoisonPitEntity>> POISON_PIT = register("poison_pit",
			EntityType.Builder.<PoisonPitEntity>of(PoisonPitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PoisonPitEntity::new).fireImmune().sized(4f, 0.2f));
	public static final RegistryObject<EntityType<CursedKeeperEntity>> CURSED_KEEPER = register("cursed_keeper", EntityType.Builder.<CursedKeeperEntity>of(CursedKeeperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(CursedKeeperEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MercuryBallProjectileEntity>> MERCURY_BALL_PROJECTILE = register("mercury_ball_projectile", EntityType.Builder.<MercuryBallProjectileEntity>of(MercuryBallProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MercuryBallProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<NoteBombProjectileEntity>> NOTE_BOMB_PROJECTILE = register("note_bomb_projectile", EntityType.Builder.<NoteBombProjectileEntity>of(NoteBombProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(NoteBombProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PlagueBombEntity>> PLAGUE_BOMB = register("plague_bomb",
			EntityType.Builder.<PlagueBombEntity>of(PlagueBombEntity::new, MobCategory.MISC).setCustomClientFactory(PlagueBombEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BlueMagicFireballProjectileEntity>> BLUE_MAGIC_FIREBALL_PROJECTILE = register("blue_magic_fireball_projectile",
			EntityType.Builder.<BlueMagicFireballProjectileEntity>of(BlueMagicFireballProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(BlueMagicFireballProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CursedKnightEntity>> CURSED_KNIGHT = register("cursed_knight", EntityType.Builder.<CursedKnightEntity>of(CursedKnightEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CursedKnightEntity::new).fireImmune().sized(1f, 2f));
	public static final RegistryObject<EntityType<SmokeMusketProjectileEntity>> SMOKE_MUSKET_PROJECTILE = register("smoke_musket_projectile", EntityType.Builder.<SmokeMusketProjectileEntity>of(SmokeMusketProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(SmokeMusketProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SmokeBombProjectileEntity>> SMOKE_BOMB_PROJECTILE = register("smoke_bomb_projectile", EntityType.Builder.<SmokeBombProjectileEntity>of(SmokeBombProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(SmokeBombProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CursedSquireEntity>> CURSED_SQUIRE = register("cursed_squire", EntityType.Builder.<CursedSquireEntity>of(CursedSquireEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(32).setUpdateInterval(3).setCustomClientFactory(CursedSquireEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<SpiritEntity>> SPIRIT = register("spirit",
			EntityType.Builder.<SpiritEntity>of(SpiritEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3).setCustomClientFactory(SpiritEntity::new)

					.sized(1f, 1f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ShadowEntity.init();
			BlackHoleEntity.init();
			EnergiumGolemEntity.init();
			TurretEntity.init();
			PoisonPitEntity.init();
			CursedKeeperEntity.init();
			CursedKnightEntity.init();
			CursedSquireEntity.init();
			SpiritEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SHADOW.get(), ShadowEntity.createAttributes().build());
		event.put(BLACK_HOLE.get(), BlackHoleEntity.createAttributes().build());
		event.put(ENERGIUM_GOLEM.get(), EnergiumGolemEntity.createAttributes().build());
		event.put(TURRET.get(), TurretEntity.createAttributes().build());
		event.put(POISON_PIT.get(), PoisonPitEntity.createAttributes().build());
		event.put(CURSED_KEEPER.get(), CursedKeeperEntity.createAttributes().build());
		event.put(CURSED_KNIGHT.get(), CursedKnightEntity.createAttributes().build());
		event.put(CURSED_SQUIRE.get(), CursedSquireEntity.createAttributes().build());
		event.put(SPIRIT.get(), SpiritEntity.createAttributes().build());
	}
}
