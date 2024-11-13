package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

@EventBusSubscriber
public class StoneReturnInKeeperBoxProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("power:keepers_boxes")))) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("power:elemental_stones")))) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.selected = false;
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.unlock_keepers_box = true;
					_vars.syncPlayerVariables(entity);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.FIRE_STONE.get()) {
					PowerModVariables.MapVariables.get(world).fire_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.AIR_STONE.get()) {
					PowerModVariables.MapVariables.get(world).air_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.EARTH_STONE.get()) {
					PowerModVariables.MapVariables.get(world).earth_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.WATER_STONE.get()) {
					PowerModVariables.MapVariables.get(world).water_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.ETHER_STONE.get()) {
					PowerModVariables.MapVariables.get(world).ether_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.ICE_STONE.get()) {
					PowerModVariables.MapVariables.get(world).ice_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.LIGHTNING_STONE.get()) {
					PowerModVariables.MapVariables.get(world).lightning_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.SOUND_STONE.get()) {
					PowerModVariables.MapVariables.get(world).sound_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.CRYSTAL_STONE.get()) {
					PowerModVariables.MapVariables.get(world).crystal_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.LAVA_STONE.get()) {
					PowerModVariables.MapVariables.get(world).lava_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.RAIN_STONE.get()) {
					PowerModVariables.MapVariables.get(world).rain_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.TORNADO_STONE.get()) {
					PowerModVariables.MapVariables.get(world).tornado_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.OCEAN_STONE.get()) {
					PowerModVariables.MapVariables.get(world).ocean_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.PLANTS_STONE.get()) {
					PowerModVariables.MapVariables.get(world).plants_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.ANIMALS_STONE.get()) {
					PowerModVariables.MapVariables.get(world).animals_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.METAL_STONE.get()) {
					PowerModVariables.MapVariables.get(world).metal_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.LIGHT_STONE.get()) {
					PowerModVariables.MapVariables.get(world).light_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.SHADOW_STONE.get()) {
					PowerModVariables.MapVariables.get(world).shadow_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.VACUUM_STONE.get()) {
					PowerModVariables.MapVariables.get(world).vacuum_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.SUN_STONE.get()) {
					PowerModVariables.MapVariables.get(world).sun_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.MOON_STONE.get()) {
					PowerModVariables.MapVariables.get(world).moon_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.SPACE_STONE.get()) {
					PowerModVariables.MapVariables.get(world).space_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.TIME_STONE.get()) {
					PowerModVariables.MapVariables.get(world).time_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.BLOOD_STONE.get()) {
					PowerModVariables.MapVariables.get(world).blood_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.TECHNOLOGY_STONE.get()) {
					PowerModVariables.MapVariables.get(world).technology_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.TELEPORTATION_STONE.get()) {
					PowerModVariables.MapVariables.get(world).teleportation_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.EXPLOSION_STONE.get()) {
					PowerModVariables.MapVariables.get(world).explosion_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.AMBER_STONE.get()) {
					PowerModVariables.MapVariables.get(world).amber_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.AMBER_STONE.get()) {
					PowerModVariables.MapVariables.get(world).amber_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.CREATION_STONE.get()) {
					PowerModVariables.MapVariables.get(world).creation_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.DESTRUCTION_STONE.get()) {
					PowerModVariables.MapVariables.get(world).destruction_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.MIST_STONE.get()) {
					PowerModVariables.MapVariables.get(world).mist_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.SAND_STONE.get()) {
					PowerModVariables.MapVariables.get(world).sand_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.SPEED_STONE.get()) {
					PowerModVariables.MapVariables.get(world).speed_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.POISON_STONE.get()) {
					PowerModVariables.MapVariables.get(world).poison_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.MAGNET_STONE.get()) {
					PowerModVariables.MapVariables.get(world).magnet_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.MUSHROOMS_STONE.get()) {
					PowerModVariables.MapVariables.get(world).mushrooms_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.MERCURY_STONE.get()) {
					PowerModVariables.MapVariables.get(world).mercury_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.MUSIC_STONE.get()) {
					PowerModVariables.MapVariables.get(world).music_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.PLAGUE_STONE.get()) {
					PowerModVariables.MapVariables.get(world).plague_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.BLUE_FLAME_STONE.get()) {
					PowerModVariables.MapVariables.get(world).blue_flame_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.GRAVITY_STONE.get()) {
					PowerModVariables.MapVariables.get(world).gravity_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.SMOKE_STONE.get()) {
					PowerModVariables.MapVariables.get(world).smoke_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.FORM_STONE.get()) {
					PowerModVariables.MapVariables.get(world).form_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.MIND_STONE.get()) {
					PowerModVariables.MapVariables.get(world).mind_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.GOLDEN_DUST_STONE.get()) {
					PowerModVariables.MapVariables.get(world).golden_dust_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.DARKNESS_STONE.get()) {
					PowerModVariables.MapVariables.get(world).darkness_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.ENERGY_STONE.get()) {
					PowerModVariables.MapVariables.get(world).energy_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.SPIRIT_STONE.get()) {
					PowerModVariables.MapVariables.get(world).spirit_stone = false;
					PowerModVariables.MapVariables.get(world).syncData(world);
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			}
		}
	}
}
