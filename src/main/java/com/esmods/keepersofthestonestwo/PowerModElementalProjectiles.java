package com.esmods.keepersofthestonestwo;

import com.auranite.abloom.AbloomMod;
import com.auranite.abloom.ElementType;
import com.esmods.keepersofthestonestwo.init.PowerModEntities;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import com.auranite.abloom.ElementalProjectileRegistry;


public class PowerModElementalProjectiles {

    public static void onCommonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(PowerModElementalProjectiles::registerAll);
    }

    public static void registerAll() {

        ElementalProjectileRegistry.registerProjectile(PowerModEntities.MAGIC_FIREBALL_PROJECTILE.get(), ElementType.FIRE, 15f);

        ElementalProjectileRegistry.registerProjectile(PowerModEntities.DIRT_BLOCK_ATTACK_PROJECTILE.get(), ElementType.EARTH, 20f);
        ElementalProjectileRegistry.registerProjectile(PowerModEntities.GRASS_BLOCK_ATTACK_PROJECTILE.get(), ElementType.EARTH, 20f);
        ElementalProjectileRegistry.registerProjectile(PowerModEntities.STONE_ATTACK_PROJECTILE.get(), ElementType.EARTH, 25f);
        ElementalProjectileRegistry.registerProjectile(PowerModEntities.COBBLESTONE_ATTACK_PROJECTILE.get(), ElementType.EARTH, 25f);
        ElementalProjectileRegistry.registerProjectile(PowerModEntities.COBBLED_DEEPSLATE_ATTACK_PROJECTILE.get(), ElementType.EARTH, 30f);

        ElementalProjectileRegistry.registerProjectile(PowerModEntities.WATER_ATTACK_PROJECTILE.get(), ElementType.WATER, 30f);

        ElementalProjectileRegistry.registerProjectile(PowerModEntities.ETHER_ATTACK_PROJECTILE.get(), ElementType.ETHER, 25f);

        ElementalProjectileRegistry.registerProjectile(PowerModEntities.ICE_ATTACK_PROJECTILE.get(), ElementType.ICE, 25f);




        registerCustomProjectiles();

        AbloomMod.LOGGER.info("Registered {} elemental projectile types",
                ElementalProjectileRegistry.getRegisteredCount());
    }

    private static void registerCustomProjectiles() {

    }
}
