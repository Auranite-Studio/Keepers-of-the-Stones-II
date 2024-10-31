
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import com.esmods.keepersofthestonestwo.entity.WaterAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.TurretProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.TurretEntity;
import com.esmods.keepersofthestonestwo.entity.StoneAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.SpiritEntity;
import com.esmods.keepersofthestonestwo.entity.SphereNothingProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.SoundBombProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.SmokeMusketProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.SmokeBombProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.ShadowSphereEntity;
import com.esmods.keepersofthestonestwo.entity.ShadowEntity;
import com.esmods.keepersofthestonestwo.entity.RainDropProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.PoisonousThornEntity;
import com.esmods.keepersofthestonestwo.entity.PoisonPitEntity;
import com.esmods.keepersofthestonestwo.entity.PoisonDropProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.PoisonBombEntity;
import com.esmods.keepersofthestonestwo.entity.PlagueBombEntity;
import com.esmods.keepersofthestonestwo.entity.NoteBombProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.MiniTornadoProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.MeteoriteProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.MercuryBallProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.MagicFireballProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.LightballProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.LavaAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.KnifeAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.IronAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.IceAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.GrenadeEntity;
import com.esmods.keepersofthestonestwo.entity.GrassBlockAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.GoldAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.EtherAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.EnergyChargeEntity;
import com.esmods.keepersofthestonestwo.entity.EnergiumGolemEntity;
import com.esmods.keepersofthestonestwo.entity.DirtBlockAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.DestructionBallProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.CursedSquireEntity;
import com.esmods.keepersofthestonestwo.entity.CursedKnightEntity;
import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;
import com.esmods.keepersofthestonestwo.entity.CopperAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.CobblestoneAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.CobbledDeepslateAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.BlueMagicFireballProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.BlackHoleEntity;
import com.esmods.keepersofthestonestwo.entity.BallLightningProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.AtomicRocketEntity;
import com.esmods.keepersofthestonestwo.entity.AmethystClusterAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.entity.AmethystAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PowerModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, PowerMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<MagicFireballProjectileEntity>> MAGIC_FIREBALL_PROJECTILE = register("magic_fireball_projectile",
			EntityType.Builder.<MagicFireballProjectileEntity>of(MagicFireballProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<StoneAttackProjectileEntity>> STONE_ATTACK_PROJECTILE = register("stone_attack_projectile",
			EntityType.Builder.<StoneAttackProjectileEntity>of(StoneAttackProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GrassBlockAttackProjectileEntity>> GRASS_BLOCK_ATTACK_PROJECTILE = register("grass_block_attack_projectile",
			EntityType.Builder.<GrassBlockAttackProjectileEntity>of(GrassBlockAttackProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<DirtBlockAttackProjectileEntity>> DIRT_BLOCK_ATTACK_PROJECTILE = register("dirt_block_attack_projectile",
			EntityType.Builder.<DirtBlockAttackProjectileEntity>of(DirtBlockAttackProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<CobblestoneAttackProjectileEntity>> COBBLESTONE_ATTACK_PROJECTILE = register("cobblestone_attack_projectile",
			EntityType.Builder.<CobblestoneAttackProjectileEntity>of(CobblestoneAttackProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<CobbledDeepslateAttackProjectileEntity>> COBBLED_DEEPSLATE_ATTACK_PROJECTILE = register("cobbled_deepslate_attack_projectile",
			EntityType.Builder.<CobbledDeepslateAttackProjectileEntity>of(CobbledDeepslateAttackProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<WaterAttackProjectileEntity>> WATER_ATTACK_PROJECTILE = register("water_attack_projectile",
			EntityType.Builder.<WaterAttackProjectileEntity>of(WaterAttackProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<EtherAttackProjectileEntity>> ETHER_ATTACK_PROJECTILE = register("ether_attack_projectile",
			EntityType.Builder.<EtherAttackProjectileEntity>of(EtherAttackProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<IceAttackProjectileEntity>> ICE_ATTACK_PROJECTILE = register("ice_attack_projectile",
			EntityType.Builder.<IceAttackProjectileEntity>of(IceAttackProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BallLightningProjectileEntity>> BALL_LIGHTNING_PROJECTILE = register("ball_lightning_projectile",
			EntityType.Builder.<BallLightningProjectileEntity>of(BallLightningProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<AmethystAttackProjectileEntity>> AMETHYST_ATTACK_PROJECTILE = register("amethyst_attack_projectile",
			EntityType.Builder.<AmethystAttackProjectileEntity>of(AmethystAttackProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<LavaAttackProjectileEntity>> LAVA_ATTACK_PROJECTILE = register("lava_attack_projectile",
			EntityType.Builder.<LavaAttackProjectileEntity>of(LavaAttackProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SoundBombProjectileEntity>> SOUND_BOMB_PROJECTILE = register("sound_bomb_projectile",
			EntityType.Builder.<SoundBombProjectileEntity>of(SoundBombProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<AmethystClusterAttackProjectileEntity>> AMETHYST_CLUSTER_ATTACK_PROJECTILE = register("amethyst_cluster_attack_projectile",
			EntityType.Builder.<AmethystClusterAttackProjectileEntity>of(AmethystClusterAttackProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<RainDropProjectileEntity>> RAIN_DROP_PROJECTILE = register("rain_drop_projectile",
			EntityType.Builder.<RainDropProjectileEntity>of(RainDropProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<MiniTornadoProjectileEntity>> MINI_TORNADO_PROJECTILE = register("mini_tornado_projectile",
			EntityType.Builder.<MiniTornadoProjectileEntity>of(MiniTornadoProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PoisonousThornEntity>> POISONOUS_THORN = register("poisonous_thorn",
			EntityType.Builder.<PoisonousThornEntity>of(PoisonousThornEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<CopperAttackProjectileEntity>> COPPER_ATTACK_PROJECTILE = register("copper_attack_projectile",
			EntityType.Builder.<CopperAttackProjectileEntity>of(CopperAttackProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GoldAttackProjectileEntity>> GOLD_ATTACK_PROJECTILE = register("gold_attack_projectile",
			EntityType.Builder.<GoldAttackProjectileEntity>of(GoldAttackProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<IronAttackProjectileEntity>> IRON_ATTACK_PROJECTILE = register("iron_attack_projectile",
			EntityType.Builder.<IronAttackProjectileEntity>of(IronAttackProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<KnifeAttackProjectileEntity>> KNIFE_ATTACK_PROJECTILE = register("knife_attack_projectile",
			EntityType.Builder.<KnifeAttackProjectileEntity>of(KnifeAttackProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<LightballProjectileEntity>> LIGHTBALL_PROJECTILE = register("lightball_projectile",
			EntityType.Builder.<LightballProjectileEntity>of(LightballProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ShadowEntity>> SHADOW = register("shadow",
			EntityType.Builder.<ShadowEntity>of(ShadowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ShadowSphereEntity>> SHADOW_SPHERE = register("shadow_sphere",
			EntityType.Builder.<ShadowSphereEntity>of(ShadowSphereEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SphereNothingProjectileEntity>> SPHERE_NOTHING_PROJECTILE = register("sphere_nothing_projectile",
			EntityType.Builder.<SphereNothingProjectileEntity>of(SphereNothingProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<EnergyChargeEntity>> ENERGY_CHARGE = register("energy_charge",
			EntityType.Builder.<EnergyChargeEntity>of(EnergyChargeEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BlackHoleEntity>> BLACK_HOLE = register("black_hole",
			EntityType.Builder.<BlackHoleEntity>of(BlackHoleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.2f, 0.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<MeteoriteProjectileEntity>> METEORITE_PROJECTILE = register("meteorite_projectile",
			EntityType.Builder.<MeteoriteProjectileEntity>of(MeteoriteProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<DestructionBallProjectileEntity>> DESTRUCTION_BALL_PROJECTILE = register("destruction_ball_projectile",
			EntityType.Builder.<DestructionBallProjectileEntity>of(DestructionBallProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<EnergiumGolemEntity>> ENERGIUM_GOLEM = register("energium_golem",
			EntityType.Builder.<EnergiumGolemEntity>of(EnergiumGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).fireImmune().sized(2.25f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<TurretEntity>> TURRET = register("turret",
			EntityType.Builder.<TurretEntity>of(TurretEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(48).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<TurretProjectileEntity>> TURRET_PROJECTILE = register("turret_projectile",
			EntityType.Builder.<TurretProjectileEntity>of(TurretProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<AtomicRocketEntity>> ATOMIC_ROCKET = register("atomic_rocket",
			EntityType.Builder.<AtomicRocketEntity>of(AtomicRocketEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GrenadeEntity>> GRENADE = register("grenade",
			EntityType.Builder.<GrenadeEntity>of(GrenadeEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PoisonDropProjectileEntity>> POISON_DROP_PROJECTILE = register("poison_drop_projectile",
			EntityType.Builder.<PoisonDropProjectileEntity>of(PoisonDropProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PoisonBombEntity>> POISON_BOMB = register("poison_bomb",
			EntityType.Builder.<PoisonBombEntity>of(PoisonBombEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PoisonPitEntity>> POISON_PIT = register("poison_pit",
			EntityType.Builder.<PoisonPitEntity>of(PoisonPitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(4f, 0.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<CursedKeeperEntity>> CURSED_KEEPER = register("cursed_keeper",
			EntityType.Builder.<CursedKeeperEntity>of(CursedKeeperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MercuryBallProjectileEntity>> MERCURY_BALL_PROJECTILE = register("mercury_ball_projectile",
			EntityType.Builder.<MercuryBallProjectileEntity>of(MercuryBallProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<NoteBombProjectileEntity>> NOTE_BOMB_PROJECTILE = register("note_bomb_projectile",
			EntityType.Builder.<NoteBombProjectileEntity>of(NoteBombProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PlagueBombEntity>> PLAGUE_BOMB = register("plague_bomb",
			EntityType.Builder.<PlagueBombEntity>of(PlagueBombEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BlueMagicFireballProjectileEntity>> BLUE_MAGIC_FIREBALL_PROJECTILE = register("blue_magic_fireball_projectile",
			EntityType.Builder.<BlueMagicFireballProjectileEntity>of(BlueMagicFireballProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<CursedKnightEntity>> CURSED_KNIGHT = register("cursed_knight",
			EntityType.Builder.<CursedKnightEntity>of(CursedKnightEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<SmokeMusketProjectileEntity>> SMOKE_MUSKET_PROJECTILE = register("smoke_musket_projectile",
			EntityType.Builder.<SmokeMusketProjectileEntity>of(SmokeMusketProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SmokeBombProjectileEntity>> SMOKE_BOMB_PROJECTILE = register("smoke_bomb_projectile",
			EntityType.Builder.<SmokeBombProjectileEntity>of(SmokeBombProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<CursedSquireEntity>> CURSED_SQUIRE = register("cursed_squire",
			EntityType.Builder.<CursedSquireEntity>of(CursedSquireEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3).fireImmune().sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<SpiritEntity>> SPIRIT = register("spirit",
			EntityType.Builder.<SpiritEntity>of(SpiritEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3)

					.sized(1f, 1f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		ShadowEntity.init(event);
		BlackHoleEntity.init(event);
		EnergiumGolemEntity.init(event);
		TurretEntity.init(event);
		PoisonPitEntity.init(event);
		CursedKeeperEntity.init(event);
		CursedKnightEntity.init(event);
		CursedSquireEntity.init(event);
		SpiritEntity.init(event);
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
