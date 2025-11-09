package com.esmods.keepersofthestonestwo.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import com.esmods.keepersofthestonestwo.procedures.WalkingAnimationSyncProcedure;
import com.esmods.keepersofthestonestwo.procedures.SpintingAnimationSyncProcedure;
import com.esmods.keepersofthestonestwo.procedures.IdleAnimationSyncProcedure;
import com.esmods.keepersofthestonestwo.procedures.CursedSquirePriObnovlieniiTikaSushchnostiProcedure;
import com.esmods.keepersofthestonestwo.procedures.CursedSquireAttackSyncProcedure;
import com.esmods.keepersofthestonestwo.init.PowerModEntities;

public class CursedSquireEntity extends Monster {
	public static final EntityDataAccessor<Integer> DATA_attack_anim_sync = SynchedEntityData.defineId(CursedSquireEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_OnBattle = SynchedEntityData.defineId(CursedSquireEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> DATA_State = SynchedEntityData.defineId(CursedSquireEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_IA = SynchedEntityData.defineId(CursedSquireEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Patience = SynchedEntityData.defineId(CursedSquireEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Look = SynchedEntityData.defineId(CursedSquireEntity.class, EntityDataSerializers.INT);
	public final AnimationState animationState0 = new AnimationState();
	public final AnimationState animationState1 = new AnimationState();
	public final AnimationState animationState2 = new AnimationState();
	public final AnimationState animationState3 = new AnimationState();

	public CursedSquireEntity(EntityType<CursedSquireEntity> type, Level world) {
		super(type, world);
		xpReward = 25;
		setNoAi(false);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_attack_anim_sync, 0);
		builder.define(DATA_OnBattle, false);
		builder.define(DATA_State, "");
		builder.define(DATA_IA, 0);
		builder.define(DATA_Patience, 0);
		builder.define(DATA_Look, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, false, true));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
		this.goalSelector.addGoal(5, new LeapAtTargetGoal(this, (float) 1));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("power:cursed_squire.walk")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("power:cursed_squire.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("power:cursed_squire.death"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.IN_FIRE))
			return false;
		if (damagesource.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (damagesource.is(DamageTypes.FALL))
			return false;
		if (damagesource.is(DamageTypes.DRAGON_BREATH))
			return false;
		if (damagesource.is(DamageTypes.WITHER) || damagesource.is(DamageTypes.WITHER_SKULL))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Dataattack_anim_sync", this.entityData.get(DATA_attack_anim_sync));
		compound.putBoolean("DataOnBattle", this.entityData.get(DATA_OnBattle));
		compound.putString("DataState", this.entityData.get(DATA_State));
		compound.putInt("DataIA", this.entityData.get(DATA_IA));
		compound.putInt("DataPatience", this.entityData.get(DATA_Patience));
		compound.putInt("DataLook", this.entityData.get(DATA_Look));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Dataattack_anim_sync"))
			this.entityData.set(DATA_attack_anim_sync, compound.getInt("Dataattack_anim_sync"));
		if (compound.contains("DataOnBattle"))
			this.entityData.set(DATA_OnBattle, compound.getBoolean("DataOnBattle"));
		if (compound.contains("DataState"))
			this.entityData.set(DATA_State, compound.getString("DataState"));
		if (compound.contains("DataIA"))
			this.entityData.set(DATA_IA, compound.getInt("DataIA"));
		if (compound.contains("DataPatience"))
			this.entityData.set(DATA_Patience, compound.getInt("DataPatience"));
		if (compound.contains("DataLook"))
			this.entityData.set(DATA_Look, compound.getInt("DataLook"));
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.animationState0.animateWhen(WalkingAnimationSyncProcedure.execute(this), this.tickCount);
			this.animationState1.animateWhen(SpintingAnimationSyncProcedure.execute(this), this.tickCount);
			this.animationState2.animateWhen(IdleAnimationSyncProcedure.execute(this), this.tickCount);
			this.animationState3.animateWhen(CursedSquireAttackSyncProcedure.execute(this), this.tickCount);
		}
	}

	@Override
	public void baseTick() {
		super.baseTick();
		CursedSquirePriObnovlieniiTikaSushchnostiProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(PowerModEntities.CURSED_SQUIRE.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 50);
		builder = builder.add(Attributes.ARMOR, 12.5);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 6);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.5);
		return builder;
	}
}