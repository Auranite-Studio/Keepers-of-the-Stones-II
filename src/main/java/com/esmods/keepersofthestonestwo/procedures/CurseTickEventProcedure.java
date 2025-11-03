package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

public class CurseTickEventProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("power:cursed_world"))) {
			if (entity.getPersistentData().getDouble("curseTickDamage") == 180) {
				entity.getPersistentData().putDouble("curseTickDamage", 0);
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 3);
			} else if (entity.getPersistentData().getDouble("curseTickDamage") < 180) {
				entity.getPersistentData().putDouble("curseTickDamage", (entity.getPersistentData().getDouble("curseTickDamage") + 1));
			}
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(PowerModMobEffects.CURSE);
		}
	}
}