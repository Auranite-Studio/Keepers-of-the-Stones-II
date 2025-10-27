package com.esmods.keepersofthestonestwo.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.AbstractThrownPotion;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.core.registries.BuiltInRegistries;

import com.esmods.keepersofthestonestwo.procedures.*;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class CursedKeeperEntity extends Monster {
	public static final EntityDataAccessor<Integer> DATA_attack_anim_sync = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_stage_zero_anim_sync = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_stage_one_anim_sync = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_stage_two_anim_sync = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_aggro_anim_sync = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_fall_anim_sync = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_IA = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<String> DATA_State = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Boolean> DATA_Phase = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_Wave = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Patience = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_OnBattle = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_Look = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_windShield = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_BreathRange = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.INT);
	public final AnimationState animationState0 = new AnimationState();
	public final AnimationState animationState1 = new AnimationState();
	public final AnimationState animationState2 = new AnimationState();
	public final AnimationState animationState3 = new AnimationState();
	public final AnimationState animationState4 = new AnimationState();
	public final AnimationState animationState5 = new AnimationState();
	public final AnimationState animationState6 = new AnimationState();
	public final AnimationState animationState7 = new AnimationState();
	public final AnimationState animationState8 = new AnimationState();
	public final AnimationState animationState9 = new AnimationState();
	public final AnimationState animationState10 = new AnimationState();
	public final AnimationState animationState11 = new AnimationState();
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.PURPLE, ServerBossEvent.BossBarOverlay.NOTCHED_10);

	public CursedKeeperEntity(EntityType<CursedKeeperEntity> type, Level world) {
		super(type, world);
		xpReward = 1000;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_attack_anim_sync, 0);
		builder.define(DATA_stage_zero_anim_sync, true);
		builder.define(DATA_stage_one_anim_sync, false);
		builder.define(DATA_stage_two_anim_sync, false);
		builder.define(DATA_aggro_anim_sync, false);
		builder.define(DATA_fall_anim_sync, false);
		builder.define(DATA_IA, 0);
		builder.define(DATA_State, "");
		builder.define(DATA_Phase, false);
		builder.define(DATA_Wave, 0);
		builder.define(DATA_Patience, 0);
		builder.define(DATA_OnBattle, false);
		builder.define(DATA_Look, 0);
		builder.define(DATA_windShield, 0);
		builder.define(DATA_BreathRange, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, true, false));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new FloatGoal(this));
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(serverLevel, new ItemStack(PowerModItems.LUCK_COIN.get()));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.generic.death"));
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.IN_FIRE))
			return false;
		if (damagesource.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (damagesource.getDirectEntity() instanceof AbstractThrownPotion || damagesource.getDirectEntity() instanceof AreaEffectCloud || damagesource.typeHolder().is(NeoForgeMod.POISON_DAMAGE))
			return false;
		if (damagesource.is(DamageTypes.FALL))
			return false;
		if (damagesource.is(DamageTypes.CACTUS))
			return false;
		if (damagesource.is(DamageTypes.DROWN))
			return false;
		if (damagesource.is(DamageTypes.LIGHTNING_BOLT))
			return false;
		if (damagesource.is(DamageTypes.EXPLOSION) || damagesource.is(DamageTypes.PLAYER_EXPLOSION))
			return false;
		if (damagesource.is(DamageTypes.FALLING_ANVIL))
			return false;
		if (damagesource.is(DamageTypes.DRAGON_BREATH))
			return false;
		if (damagesource.is(DamageTypes.WITHER) || damagesource.is(DamageTypes.WITHER_SKULL))
			return false;
		return super.hurtServer(level, damagesource, amount);
	}

	@Override
	public boolean ignoreExplosion(Explosion explosion) {
		return true;
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		CursedKeeperPriGibieliSushchnostiProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
	}

	@Override
	public void addAdditionalSaveData(ValueOutput valueOutput) {
		super.addAdditionalSaveData(valueOutput);
		valueOutput.putInt("Dataattack_anim_sync", this.entityData.get(DATA_attack_anim_sync));
		valueOutput.putBoolean("Datastage_zero_anim_sync", this.entityData.get(DATA_stage_zero_anim_sync));
		valueOutput.putBoolean("Datastage_one_anim_sync", this.entityData.get(DATA_stage_one_anim_sync));
		valueOutput.putBoolean("Datastage_two_anim_sync", this.entityData.get(DATA_stage_two_anim_sync));
		valueOutput.putBoolean("Dataaggro_anim_sync", this.entityData.get(DATA_aggro_anim_sync));
		valueOutput.putBoolean("Datafall_anim_sync", this.entityData.get(DATA_fall_anim_sync));
		valueOutput.putInt("DataIA", this.entityData.get(DATA_IA));
		valueOutput.putString("DataState", this.entityData.get(DATA_State));
		valueOutput.putBoolean("DataPhase", this.entityData.get(DATA_Phase));
		valueOutput.putInt("DataWave", this.entityData.get(DATA_Wave));
		valueOutput.putInt("DataPatience", this.entityData.get(DATA_Patience));
		valueOutput.putBoolean("DataOnBattle", this.entityData.get(DATA_OnBattle));
		valueOutput.putInt("DataLook", this.entityData.get(DATA_Look));
		valueOutput.putInt("DatawindShield", this.entityData.get(DATA_windShield));
		valueOutput.putInt("DataBreathRange", this.entityData.get(DATA_BreathRange));
	}

	@Override
	public void readAdditionalSaveData(ValueInput valueInput) {
		super.readAdditionalSaveData(valueInput);
		this.entityData.set(DATA_attack_anim_sync, valueInput.getIntOr("Dataattack_anim_sync", 0));
		this.entityData.set(DATA_stage_zero_anim_sync, valueInput.getBooleanOr("Datastage_zero_anim_sync", false));
		this.entityData.set(DATA_stage_one_anim_sync, valueInput.getBooleanOr("Datastage_one_anim_sync", false));
		this.entityData.set(DATA_stage_two_anim_sync, valueInput.getBooleanOr("Datastage_two_anim_sync", false));
		this.entityData.set(DATA_aggro_anim_sync, valueInput.getBooleanOr("Dataaggro_anim_sync", false));
		this.entityData.set(DATA_fall_anim_sync, valueInput.getBooleanOr("Datafall_anim_sync", false));
		this.entityData.set(DATA_IA, valueInput.getIntOr("DataIA", 0));
		this.entityData.set(DATA_State, valueInput.getStringOr("DataState", ""));
		this.entityData.set(DATA_Phase, valueInput.getBooleanOr("DataPhase", false));
		this.entityData.set(DATA_Wave, valueInput.getIntOr("DataWave", 0));
		this.entityData.set(DATA_Patience, valueInput.getIntOr("DataPatience", 0));
		this.entityData.set(DATA_OnBattle, valueInput.getBooleanOr("DataOnBattle", false));
		this.entityData.set(DATA_Look, valueInput.getIntOr("DataLook", 0));
		this.entityData.set(DATA_windShield, valueInput.getIntOr("DatawindShield", 0));
		this.entityData.set(DATA_BreathRange, valueInput.getIntOr("DataBreathRange", 0));
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.animationState0.animateWhen(CursedKeeperSprintingProcedure.execute(this), this.tickCount);
			this.animationState1.animateWhen(CursedKeeperWalkProcedure.execute(this), this.tickCount);
			this.animationState2.animateWhen(CursedKeeperIdle0Procedure.execute(this), this.tickCount);
			this.animationState3.animateWhen(CursedKeeperIdle1Procedure.execute(this), this.tickCount);
			this.animationState4.animateWhen(CursedKeeperIdle2Procedure.execute(this), this.tickCount);
			this.animationState5.animateWhen(CursedKeeperAggroProcedure.execute(this), this.tickCount);
			this.animationState6.animateWhen(CursedKeeperFallProcedure.execute(this), this.tickCount);
			this.animationState7.animateWhen(CursedKeeperAttack1Procedure.execute(this), this.tickCount);
			this.animationState8.animateWhen(CursedKeeperAttack2Procedure.execute(this), this.tickCount);
			this.animationState9.animateWhen(CursedKeeperAttack3Procedure.execute(this), this.tickCount);
			this.animationState10.animateWhen(CursedKeeperAttack4Procedure.execute(this), this.tickCount);
			this.animationState11.animateWhen(CursedKeeperAttack5Procedure.execute(this), this.tickCount);
		}
	}

	@Override
	public void baseTick() {
		super.baseTick();
		CursedKeeperPriObnovlieniiTikaSushchnostiProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void customServerAiStep(ServerLevel serverLevel) {
		super.customServerAiStep(serverLevel);
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
		builder = builder.add(Attributes.MAX_HEALTH, 700);
		builder = builder.add(Attributes.ARMOR, 10);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 100);
		builder = builder.add(Attributes.FOLLOW_RANGE, 128);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.25);
		return builder;
	}
}