package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.damagesource.DamageSource;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

import javax.annotation.Nullable;
import java.util.stream.IntStream;

@EventBusSubscriber
public class FirePassiveSkills {

    private static boolean hasFireMasterCondition(ServerPlayer player) {
        if (!player.hasEffect(PowerModMobEffects.FIRE_MASTER)) {
            return false;
        }

        Level level = player.level();

        if (level.dimension() == Level.NETHER) {
            return true;
        }

        BlockPos center = player.blockPosition();
        int range = 5;

        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                for (int z = -range; z <= range; z++) {
                    BlockPos pos = center.offset(x, y, z);
                    BlockState state = level.getBlockState(pos);
                    if (state.getFluidState().is(FluidTags.LAVA) || state.is(BlockTags.FIRE)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        DamageSource source = event.getSource();

        if (source.getEntity() instanceof ServerPlayer attacker) {
            if (hasFireMasterCondition(attacker)) {
                float original = event.getOriginalDamage();
                event.setNewDamage(original * 1.2f);
            }
        }
    }

    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        if (event.getEntity() != null) {
            execute(event, event.getSource(), event.getEntity());
        }
    }

    public static void execute(DamageSource damagesource, Entity entity) {
        execute(null, damagesource, entity);
    }

    private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity) {
        if (damagesource == null || entity == null)
            return;
        if (entity instanceof Player && damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("minecraft:is_fire")))) {
            if (event instanceof ICancellableEvent _cancellable) {
                if (hasFireMasterCondition((ServerPlayer) entity)) {
                    _cancellable.setCanceled(true);
                }
            }
        }
    }
}
