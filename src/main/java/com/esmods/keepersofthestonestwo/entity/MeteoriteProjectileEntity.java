
package com.esmods.keepersofthestonestwo.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.procedures.MeteoriteProjectileKoghdaSnariadPopadaietVBlokProcedure;
import com.esmods.keepersofthestonestwo.procedures.MeteoriteProjectileKazhdyiTikPriPoliotieSnariadaProcedure;
import com.esmods.keepersofthestonestwo.init.PowerModEntities;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class MeteoriteProjectileEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(Blocks.REINFORCED_DEEPSLATE);

	public MeteoriteProjectileEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(PowerModEntities.METEORITE_PROJECTILE.get(), world);
	}

	public MeteoriteProjectileEntity(EntityType<? extends MeteoriteProjectileEntity> type, Level world) {
		super(type, world);
	}

	public MeteoriteProjectileEntity(EntityType<? extends MeteoriteProjectileEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public MeteoriteProjectileEntity(EntityType<? extends MeteoriteProjectileEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getPickupItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Nullable
	@Override
	protected EntityHitResult findHitEntity(Vec3 projectilePosition, Vec3 deltaPosition) {
		double d0 = Double.MAX_VALUE;
		Entity entity = null;
		AABB lookupBox = this.getBoundingBox();
		for (Entity entity1 : this.level().getEntities(this, lookupBox, this::canHitEntity)) {
			if (entity1 == this.getOwner())
				continue;
			AABB aabb = entity1.getBoundingBox();
			if (aabb.intersects(lookupBox)) {
				double d1 = projectilePosition.distanceToSqr(projectilePosition);
				if (d1 < d0) {
					entity = entity1;
					d0 = d1;
				}
			}
		}
		return entity == null ? null : new EntityHitResult(entity);
	}

	private Direction determineHitDirection(AABB entityBox, AABB blockBox) {
		double dx = entityBox.getCenter().x - blockBox.getCenter().x;
		double dy = entityBox.getCenter().y - blockBox.getCenter().y;
		double dz = entityBox.getCenter().z - blockBox.getCenter().z;
		double absDx = Math.abs(dx);
		double absDy = Math.abs(dy);
		double absDz = Math.abs(dz);
		if (absDy > absDx && absDy > absDz) {
			return dy > 0 ? Direction.DOWN : Direction.UP;
		} else if (absDx > absDz) {
			return dx > 0 ? Direction.WEST : Direction.EAST;
		} else {
			return dz > 0 ? Direction.NORTH : Direction.SOUTH;
		}
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		MeteoriteProjectileKoghdaSnariadPopadaietVBlokProcedure.execute(this.level(), blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ());
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.isNoPhysics()) {
			for (VoxelShape collision : this.level().getBlockCollisions(this, this.getBoundingBox())) {
				for (AABB blockAABB : collision.toAabbs()) {
					if (this.getBoundingBox().intersects(blockAABB)) {
						BlockPos blockPos = new BlockPos((int) blockAABB.minX, (int) blockAABB.minY, (int) blockAABB.minZ);
						Vec3 intersectionPoint = new Vec3((blockAABB.minX + blockAABB.maxX) / 2, (blockAABB.minY + blockAABB.maxY) / 2, (blockAABB.minZ + blockAABB.maxZ) / 2);
						Direction hitDirection = determineHitDirection(this.getBoundingBox(), blockAABB);
						this.onHit(new BlockHitResult(intersectionPoint, hitDirection, blockPos, false));
					}
				}
			}
		}
		MeteoriteProjectileKazhdyiTikPriPoliotieSnariadaProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
		if (this.inGround)
			this.discard();
	}

	public static MeteoriteProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 0.8f, 4.5, 4);
	}

	public static MeteoriteProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
		return shoot(world, entity, source, pullingPower * 0.8f, 4.5, 4);
	}

	public static MeteoriteProjectileEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		MeteoriteProjectileEntity entityarrow = new MeteoriteProjectileEntity(PowerModEntities.METEORITE_PROJECTILE.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		entityarrow.setSecondsOnFire(100);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.break")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static MeteoriteProjectileEntity shoot(LivingEntity entity, LivingEntity target) {
		MeteoriteProjectileEntity entityarrow = new MeteoriteProjectileEntity(PowerModEntities.METEORITE_PROJECTILE.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 0.8f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(4.5);
		entityarrow.setKnockback(4);
		entityarrow.setCritArrow(false);
		entityarrow.setSecondsOnFire(100);
		entity.level().addFreshEntity(entityarrow);
		entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.break")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
