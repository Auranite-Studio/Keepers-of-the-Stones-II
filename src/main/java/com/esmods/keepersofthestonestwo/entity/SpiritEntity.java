
package com.esmods.keepersofthestonestwo.entity;

import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoEntity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.EventHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.List;
import java.util.EnumSet;

import com.esmods.keepersofthestonestwo.procedures.SpiritPriObnovlieniiTikaSushchnostiProcedure;
import com.esmods.keepersofthestonestwo.procedures.SpiritPriNachalnomPrizyvieSushchnostiProcedure;
import com.esmods.keepersofthestonestwo.init.PowerModEntities;

public class SpiritEntity extends TamableAnimal implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SpiritEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SpiritEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SpiritEntity.class, EntityDataSerializers.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public SpiritEntity(EntityType<SpiritEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(SHOOT, false);
		builder.define(ANIMATION, "undefined");
		builder.define(TEXTURE, "spirit");
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.goalSelector.addGoal(3, new Goal() {
			{
				this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			}

			public boolean canUse() {
				if (SpiritEntity.this.getTarget() != null && !SpiritEntity.this.getMoveControl().hasWanted()) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public boolean canContinueToUse() {
				return SpiritEntity.this.getMoveControl().hasWanted() && SpiritEntity.this.getTarget() != null && SpiritEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = SpiritEntity.this.getTarget();
				Vec3 vec3d = livingentity.getEyePosition(1);
				SpiritEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.2);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = SpiritEntity.this.getTarget();
				if (SpiritEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					SpiritEntity.this.doHurtTarget(livingentity);
				} else {
					double d0 = SpiritEntity.this.distanceToSqr(livingentity);
					if (d0 < 4) {
						Vec3 vec3d = livingentity.getEyePosition(1);
						SpiritEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.2);
					}
				}
			}
		});
		this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1, (float) 4, (float) 10));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = SpiritEntity.this.getRandom();
				double dir_x = SpiritEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = SpiritEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = SpiritEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}
		});
		this.goalSelector.addGoal(6, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.targetSelector.addGoal(9, new HurtByTargetGoal(this));
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
		SpiritPriNachalnomPrizyvieSushchnostiProcedure.execute(this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			retval = super.mobInteract(sourceentity, hand);
		} else if (this.level().isClientSide()) {
			retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack)) ? InteractionResult.sidedSuccess(this.level().isClientSide()) : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isOwnedBy(sourceentity)) {
					if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						FoodProperties foodproperties = itemstack.getFoodProperties(this);
						float nutrition = foodproperties != null ? (float) foodproperties.nutrition() : 1;
						this.heal(nutrition);
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal(4);
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else {
						retval = super.mobInteract(sourceentity, hand);
					}
				}
			} else if (this.isFood(itemstack)) {
				this.usePlayerItem(sourceentity, hand, itemstack);
				if (this.random.nextInt(3) == 0 && !EventHooks.onAnimalTame(this, sourceentity)) {
					this.tame(sourceentity);
					this.level().broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level().broadcastEntityEvent(this, (byte) 6);
				}
				this.setPersistenceRequired();
				retval = InteractionResult.sidedSuccess(this.level().isClientSide());
			} else {
				retval = super.mobInteract(sourceentity, hand);
				if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
					this.setPersistenceRequired();
			}
		}
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		SpiritPriObnovlieniiTikaSushchnostiProcedure.execute(this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose pose) {
		return super.getDefaultDimensions(pose).scale(1f);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		SpiritEntity retval = PowerModEntities.SPIRIT.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(Blocks.VOID_AIR.asItem()).contains(stack.getItem());
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void doPush(Entity entityIn) {
	}

	@Override
	protected void pushEntities() {
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
		this.setNoGravity(true);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 1);
		builder = builder.add(Attributes.MAX_HEALTH, 1000);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 14);
		builder = builder.add(Attributes.FOLLOW_RANGE, 8);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 10);
		builder = builder.add(Attributes.FLYING_SPEED, 1);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			return event.setAndContinue(RawAnimation.begin().thenLoop("animation.spirit.idle"));
		}
		return PlayState.STOP;
	}

	String prevAnim = "empty";

	private PlayState procedurePredicate(AnimationState event) {
		if (!animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED || (!this.animationprocedure.equals(prevAnim) && !this.animationprocedure.equals("empty"))) {
			if (!this.animationprocedure.equals(prevAnim))
				event.getController().forceAnimationReset();
			event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				this.animationprocedure = "empty";
				event.getController().forceAnimationReset();
			}
		} else if (animationprocedure.equals("empty")) {
			prevAnim = "empty";
			return PlayState.STOP;
		}
		prevAnim = this.animationprocedure;
		return PlayState.CONTINUE;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(SpiritEntity.RemovalReason.KILLED);
			this.dropExperience(this);
		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
