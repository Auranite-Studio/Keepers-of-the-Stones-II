package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.functions.CommandFunction;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Optional;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class GravityMasterStartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
			_vars.active_power = true;
			_vars.markSyncDirty();
		}
		for (int index0 = 0; index0 < 40; index0++) {
			if (world instanceof ServerLevel _level && _level.getServer() != null) {
				Optional<CommandFunction<CommandSourceStack>> _fopt = _level.getServer().getFunctions().get(ResourceLocation.parse("power:gravity_master"));
				if (_fopt.isPresent())
					_level.getServer().getFunctions().execute(_fopt.get(), new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null));
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).mergers == 0) {
			if (entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PowerModItems.GRAVITY_ARMOR_HELMET.get()));
			}
			if (entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PowerModItems.GRAVITY_ARMOR_CHESTPLATE.get()));
			}
			if (entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PowerModItems.GRAVITY_ARMOR_LEGGINGS.get()));
			}
			if (entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PowerModItems.GRAVITY_ARMOR_BOOTS.get()));
			}
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.element_name_first = "gravity";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).mergers == 1) {
			if (entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PowerModItems.GRAVITY_ARMOR_LEGGINGS.get()));
			}
			if (entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PowerModItems.GRAVITY_ARMOR_BOOTS.get()));
			}
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.element_name_second = "gravity";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).mergers == 2) {
			if (entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PowerModItems.GRAVITY_ARMOR_LEGGINGS.get()));
			}
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.element_name_third = "gravity";
				_vars.markSyncDirty();
			}
		}
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack36 = new ItemStack(PowerModItems.GRAVITY_MACE.get()).copy();
			_setstack36.setCount(1);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack36);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
		(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
		MasterEffectStartControlProcedure.execute(world, entity);
	}
}