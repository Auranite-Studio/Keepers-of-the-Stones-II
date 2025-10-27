package com.esmods.keepersofthestonestwo.entity;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.projectile.AbstractThrownPotion;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.*;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import com.esmods.keepersofthestonestwo.procedures.PoisonPitTickProcedure;
import com.esmods.keepersofthestonestwo.procedures.HitboxScaleProcedure;

public class PoisonPitEntity extends PathfinderMob {
	public PoisonPitEntity(EntityType<PoisonPitEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(true);
		setPersistenceRequired();
		this.setPathfindingMalus(PathType.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (PoisonPitEntity.this.isInWater())
					PoisonPitEntity.this.setDeltaMovement(PoisonPitEntity.this.getDeltaMovement().add(0, 0.005, 0));
				if (this.operation == MoveControl.Operation.MOVE_TO && !PoisonPitEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - PoisonPitEntity.this.getX();
					double dy = this.wantedY - PoisonPitEntity.this.getY();
					double dz = this.wantedZ - PoisonPitEntity.this.getZ();
					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * PoisonPitEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
					PoisonPitEntity.this.setYRot(this.rotlerp(PoisonPitEntity.this.getYRot(), f, 10));
					PoisonPitEntity.this.yBodyRot = PoisonPitEntity.this.getYRot();
					PoisonPitEntity.this.yHeadRot = PoisonPitEntity.this.getYRot();
					if (PoisonPitEntity.this.isInWater()) {
						PoisonPitEntity.this.setSpeed((float) PoisonPitEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						PoisonPitEntity.this.setXRot(this.rotlerp(PoisonPitEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(PoisonPitEntity.this.getXRot() * (float) (Math.PI / 180.0));
						PoisonPitEntity.this.setZza(f3 * f1);
						PoisonPitEntity.this.setYya((float) (f1 * dy));
					} else {
						PoisonPitEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					PoisonPitEntity.this.setSpeed(0);
					PoisonPitEntity.this.setYya(0);
					PoisonPitEntity.this.setZza(0);
				}
			}
		};
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new WaterBoundPathNavigation(this, world);
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public Vec3 getPassengerRidingPosition(Entity entity) {
		return super.getPassengerRidingPosition(entity).add(0, -0.35F, 0);
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.IN_FIRE))
			return false;
		if (damagesource.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (damagesource.getDirectEntity() instanceof Player)
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
		if (damagesource.is(DamageTypes.TRIDENT))
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
	public void baseTick() {
		super.baseTick();
		PoisonPitTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean canDrownInFluidType(FluidType type) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	@Override
	public boolean isPushedByFluid() {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
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
	public EntityDimensions getDefaultDimensions(Pose pose) {
		Entity entity = this;
		Level world = this.level();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		return super.getDefaultDimensions(pose).scale((float) HitboxScaleProcedure.execute(entity));
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 2);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(NeoForgeMod.SWIM_SPEED, 0.3);
		return builder;
	}
}