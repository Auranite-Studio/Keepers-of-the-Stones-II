
package com.esmods.keepersofthestonestwo.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownPotion;
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
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import com.esmods.keepersofthestonestwo.procedures.CursedKeeperWalkProcedure;
import com.esmods.keepersofthestonestwo.procedures.CursedKeeperSprintingProcedure;
import com.esmods.keepersofthestonestwo.procedures.CursedKeeperPriObnovlieniiTikaSushchnostiProcedure;
import com.esmods.keepersofthestonestwo.procedures.CursedKeeperPriGibieliSushchnostiProcedure;
import com.esmods.keepersofthestonestwo.procedures.CursedKeeperIdle2Procedure;
import com.esmods.keepersofthestonestwo.procedures.CursedKeeperIdle1Procedure;
import com.esmods.keepersofthestonestwo.procedures.CursedKeeperIdle0Procedure;
import com.esmods.keepersofthestonestwo.procedures.CursedKeeperFallProcedure;
import com.esmods.keepersofthestonestwo.procedures.CursedKeeperAttack5Procedure;
import com.esmods.keepersofthestonestwo.procedures.CursedKeeperAttack4Procedure;
import com.esmods.keepersofthestonestwo.procedures.CursedKeeperAttack3Procedure;
import com.esmods.keepersofthestonestwo.procedures.CursedKeeperAttack2Procedure;
import com.esmods.keepersofthestonestwo.procedures.CursedKeeperAttack1Procedure;
import com.esmods.keepersofthestonestwo.procedures.CursedKeeperAggroProcedure;
import com.esmods.keepersofthestonestwo.init.PowerModItems;
import com.esmods.keepersofthestonestwo.init.PowerModEntities;

public class CursedKeeperEntity extends Monster {
	public static final EntityDataAccessor<Integer> DATA_attack_anim_sync = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_stage_zero_anim_sync = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_stage_one_anim_sync = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_stage_two_anim_sync = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_aggro_anim_sync = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_fall_anim_sync = SynchedEntityData.defineId(CursedKeeperEntity.class, EntityDataSerializers.BOOLEAN);
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

	public CursedKeeperEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(PowerModEntities.CURSED_KEEPER.get(), world);
	}

	public CursedKeeperEntity(EntityType<CursedKeeperEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 1000;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_attack_anim_sync, 0);
		this.entityData.define(DATA_stage_zero_anim_sync, true);
		this.entityData.define(DATA_stage_one_anim_sync, false);
		this.entityData.define(DATA_stage_two_anim_sync, false);
		this.entityData.define(DATA_aggro_anim_sync, false);
		this.entityData.define(DATA_fall_anim_sync, false);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, true, false));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(PowerModItems.LUCK_COIN.get()));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.IN_FIRE))
			return false;
		if (damagesource.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (damagesource.getDirectEntity() instanceof ThrownPotion || damagesource.getDirectEntity() instanceof AreaEffectCloud)
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
		return super.hurt(damagesource, amount);
	}

	@Override
	public boolean ignoreExplosion() {
		return true;
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		CursedKeeperPriGibieliSushchnostiProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Dataattack_anim_sync", this.entityData.get(DATA_attack_anim_sync));
		compound.putBoolean("Datastage_zero_anim_sync", this.entityData.get(DATA_stage_zero_anim_sync));
		compound.putBoolean("Datastage_one_anim_sync", this.entityData.get(DATA_stage_one_anim_sync));
		compound.putBoolean("Datastage_two_anim_sync", this.entityData.get(DATA_stage_two_anim_sync));
		compound.putBoolean("Dataaggro_anim_sync", this.entityData.get(DATA_aggro_anim_sync));
		compound.putBoolean("Datafall_anim_sync", this.entityData.get(DATA_fall_anim_sync));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Dataattack_anim_sync"))
			this.entityData.set(DATA_attack_anim_sync, compound.getInt("Dataattack_anim_sync"));
		if (compound.contains("Datastage_zero_anim_sync"))
			this.entityData.set(DATA_stage_zero_anim_sync, compound.getBoolean("Datastage_zero_anim_sync"));
		if (compound.contains("Datastage_one_anim_sync"))
			this.entityData.set(DATA_stage_one_anim_sync, compound.getBoolean("Datastage_one_anim_sync"));
		if (compound.contains("Datastage_two_anim_sync"))
			this.entityData.set(DATA_stage_two_anim_sync, compound.getBoolean("Datastage_two_anim_sync"));
		if (compound.contains("Dataaggro_anim_sync"))
			this.entityData.set(DATA_aggro_anim_sync, compound.getBoolean("Dataaggro_anim_sync"));
		if (compound.contains("Datafall_anim_sync"))
			this.entityData.set(DATA_fall_anim_sync, compound.getBoolean("Datafall_anim_sync"));
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
	public boolean canChangeDimensions() {
		return false;
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
	public void customServerAiStep() {
		super.customServerAiStep();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
		builder = builder.add(Attributes.MAX_HEALTH, 700);
		builder = builder.add(Attributes.ARMOR, 10);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 100);
		builder = builder.add(Attributes.FOLLOW_RANGE, 128);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.25);
		return builder;
	}
}
