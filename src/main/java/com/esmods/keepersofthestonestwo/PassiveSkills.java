package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.*;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.living.*;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.IntStream;

@EventBusSubscriber
public class PassiveSkills {
    private static final Random RANDOM = new Random();
    
    // === AIR ===
    @SubscribeEvent
    public static void air_onLivingIncomingDamage(LivingIncomingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;
        if (!event.getSource().is(DamageTypes.FALL)) return;
        boolean hasAirMaster = player.hasEffect(PowerModMobEffects.AIR_MASTER);
        boolean isHighEnough = player.getBlockY() >= 96;
        if (hasAirMaster && isHighEnough) {
            float originalDamage = event.getAmount();
            float reducedDamage = originalDamage * 0.25f;
            event.setAmount(reducedDamage);
        }
    }

    @SubscribeEvent
    public static void air_onPlayerAttack(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        Entity attacker = event.getSource().getEntity();
        if (!(attacker instanceof Player player)) return;
        if (player.level().isClientSide()) return;
        if (!player.hasEffect(PowerModMobEffects.AIR_MASTER) || player.getBlockY() < 96) {
            return;
        }
        if (target instanceof Player) {
            return;
        }
        if (RANDOM.nextFloat() < 0.15f) {
            double dx = target.getX() - player.getX();
            double dz = target.getZ() - player.getZ();
            double horizontalDist = Math.sqrt(dx * dx + dz * dz);
            if (horizontalDist > 0.01) {
                dx /= horizontalDist;
                dz /= horizontalDist;
            } else {
                dx = RANDOM.nextGaussian();
                dz = RANDOM.nextGaussian();
                double len = Math.sqrt(dx * dx + dz * dz);
                if (len > 0) {
                    dx /= len;
                    dz /= len;
                }
            }
            target.push(dx * 1.5, 0.35, dz * 1.5);
            target.hurtMarked = true;
        }
    }

    // === AMBER ===
    private static final int AMBER_ACCUMULATION_INTERVAL = 30 * 20;
    private static final int AMBER_STAR_POINTS_AMOUNT = 20;

    private static boolean amber_isActive(Player player) {
        var playerVars = player.getData(PowerModVariables.PLAYER_VARIABLES);
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.AMBER_MASTER)) return false;
        return playerVars.fake_element_name_first != null && !playerVars.fake_element_name_first.equals("0");
    }

    @SubscribeEvent
    public static void amber_onPlayerTakeDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!amber_isActive(player)) return;
        event.setNewDamage(event.getOriginalDamage() * 0.8f);
    }

    @SubscribeEvent
    public static void amber_onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (!(player instanceof ServerPlayer)) return;
        if (!amber_isActive(player)) return;
        long gameTime = player.level().getGameTime();
        if (gameTime % AMBER_ACCUMULATION_INTERVAL == 0) {
            var playerVars = player.getData(PowerModVariables.PLAYER_VARIABLES);
            playerVars.power += AMBER_STAR_POINTS_AMOUNT;
        }
    }

    // === ANIMALS ===
    private static boolean animals_hasTamedMobNearby(Player player) {
        return !player.level().getEntitiesOfClass(
                TamableAnimal.class,
                player.getBoundingBox().inflate(16.0, 16.0, 16.0),
                entity -> entity.isTame() && entity.getOwner() == player
        ).isEmpty();
    }

    @SubscribeEvent
    public static void animals_onLivingHurt(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        DamageSource source = event.getSource();
        Entity attacker = source.getDirectEntity();
        if (attacker instanceof Player player) {
            if (animals_hasTamedMobNearby(player)) {
                event.setNewDamage(event.getOriginalDamage() * 1.2f);
            }
        } else if (attacker instanceof TamableAnimal tameable) {
            if (tameable.isTame() && tameable.getOwner() instanceof Player owner) {
                if (animals_hasTamedMobNearby(owner)) {
                    event.setNewDamage(event.getOriginalDamage() * 1.9f);
                }
            }
        }
    }

    @SubscribeEvent
    public static void animals_onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Player player) {
            if (animals_hasTamedMobNearby(player)) {
                event.setNewDamage(event.getNewDamage() * 0.75f);
            }
        }
    }

    // === BLOOD ===
    private static final int BLOOD_WITHER_DURATION = 5 * 20;

    private static boolean blood_isBloodMasterActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.BLOOD_MASTER)) return false;
        float health = player.getHealth();
        float maxHealth = player.getMaxHealth();
        return health < maxHealth * 0.5f;
    }

    @SubscribeEvent
    public static void blood_onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (target.level().isClientSide()) return;
        if (!blood_isBloodMasterActive(attacker)) return;
        event.setNewDamage(event.getOriginalDamage() * 1.2f);
        if (attacker.getRandom().nextFloat() < 0.1f) {
            target.addEffect(new MobEffectInstance(MobEffects.WITHER, BLOOD_WITHER_DURATION, 1, false, true));
        }
    }

    @SubscribeEvent
    public static void blood_onLivingDeath(LivingDeathEvent event) {
        LivingEntity killed = event.getEntity();
        if (killed.level().isClientSide()) return;
        var source = event.getSource().getEntity();
        if (!(source instanceof Player killer)) return;
        if (!blood_isBloodMasterActive(killer)) return;
        if (killer.getRandom().nextFloat() < 0.5f) {
            float maxHealth = killer.getMaxHealth();
            float healAmount = maxHealth * 0.1f;
            if (healAmount > 0) {
                killer.heal(healAmount);
            }
        }
    }

    // === BLUE_FLAME ===
    private static final int BLUE_FLAME_FIRE_DURATION = 5 * 20;
    private static final long BLUE_FLAME_COMBO_RESET_TIME = 3 * 20;
    private static final int BLUE_FLAME_SEARCH_RADIUS = 16;
    private static final int BLUE_FLAME_MIN_FIRE_SOURCES = 3;
    private static final Map<UUID, Integer> blueFlame_attackStreak = new HashMap<>();
    private static final Map<UUID, Long> blueFlame_lastAttackTime = new HashMap<>();

    private static boolean blueFlame_isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.BLUE_FLAME_MASTER)) return false;
        Level level = player.level();
        if (level.dimension() == Level.NETHER) {
            return true;
        }
        BlockPos center = player.blockPosition();
        int fireCount = 0;
        for (int x = -BLUE_FLAME_SEARCH_RADIUS; x <= BLUE_FLAME_SEARCH_RADIUS; x++) {
            for (int y = -BLUE_FLAME_SEARCH_RADIUS; y <= BLUE_FLAME_SEARCH_RADIUS; y++) {
                for (int z = -BLUE_FLAME_SEARCH_RADIUS; z <= BLUE_FLAME_SEARCH_RADIUS; z++) {
                    BlockPos pos = center.offset(x, y, z);
                    if (level.getBlockState(pos).is(Blocks.FIRE)) {
                        fireCount++;
                        if (fireCount >= BLUE_FLAME_MIN_FIRE_SOURCES) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void blueFlame_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity target)) return;
        if (!blueFlame_isActive(attacker)) return;
        UUID playerId = attacker.getUUID();
        long currentTime = attacker.level().getGameTime();
        long lastTime = blueFlame_lastAttackTime.getOrDefault(playerId, -100L);
        int streak = blueFlame_attackStreak.getOrDefault(playerId, 0);
        if (currentTime - lastTime <= BLUE_FLAME_COMBO_RESET_TIME) {
            streak++;
        } else {
            streak = 1;
        }
        blueFlame_lastAttackTime.put(playerId, currentTime);
        blueFlame_attackStreak.put(playerId, streak);
        if (streak % 3 == 0) {
            target.igniteForSeconds(BLUE_FLAME_FIRE_DURATION / 20);
        }
    }

    @SubscribeEvent
    public static void blueFlame_onPlayerTakeFireDamage(LivingIncomingDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!blueFlame_isActive(player)) return;
        var source = event.getSource();
        if (source.is(DamageTypes.IN_FIRE) || source.is(DamageTypes.ON_FIRE) ||
            source.is(DamageTypes.LAVA) || source.is(DamageTypes.HOT_FLOOR)) {
            event.setCanceled(true);
        }
    }

    // === COLORS ===
    private static final int COLORS_BLINDNESS_DURATION = 7 * 20;

    private static boolean colors_hasDye(Player player) {
        for (var stack : player.getInventory().items) {
            if (!stack.isEmpty() && stack.getItem() instanceof DyeItem) {
                return true;
            }
        }
        var offhand = player.getOffhandItem();
        return !offhand.isEmpty() && offhand.getItem() instanceof DyeItem;
    }

    private static boolean colors_isActive(Player player) {
        return !player.level().isClientSide() &&
               player.hasEffect(PowerModMobEffects.COLORS_MASTER) &&
               colors_hasDye(player);
    }

    @SubscribeEvent
    public static void colors_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity target)) return;
        if (!colors_isActive(attacker)) return;
        if (attacker.getRandom().nextFloat() < 0.1f) {
            target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, COLORS_BLINDNESS_DURATION, 0, false, true));
        }
    }

    @SubscribeEvent
    public static void colors_onPlayerTakeDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!colors_isActive(player)) return;
        event.setNewDamage(event.getOriginalDamage() * 0.75f);
    }

    // === CREATION ===
    private static final int CREATION_HASTE_DURATION = 30;
    private static final int CREATION_SEARCH_RADIUS = 16;

    private static boolean creation_hasCreationMaster(Player player) {
        return !player.level().isClientSide() && player.hasEffect(PowerModMobEffects.CREATION_MASTER);
    }

    private static boolean creation_isNearElementalBlock(Player player) {
        BlockPos center = player.blockPosition();
        int radius = CREATION_SEARCH_RADIUS;
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos pos = center.offset(x, y, z);
                    BlockState state = player.level().getBlockState(pos);
                    if (state.is(Blocks.LAVA) || state.is(Blocks.WATER) || state.is(Blocks.FIRE)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean creation_isInMountains(Player player) {
        return player.level().getBiome(player.blockPosition()).is(BiomeTags.IS_MOUNTAIN);
    }

    private static boolean creation_isInCave(Player player) {
        BlockPos pos = player.blockPosition();
        return !player.level().canSeeSky(pos.above()) && pos.getY() < 64;
    }

    private static boolean creation_areConditionsMet(Player player) {
        return creation_isNearElementalBlock(player) || creation_isInMountains(player) || creation_isInCave(player);
    }

    @SubscribeEvent
    public static void creation_onLivingDamage(LivingDamageEvent.Pre event) {
        if (!event.getEntity().level().isClientSide()) {
            if (event.getEntity() instanceof Player player) {
                if (creation_hasCreationMaster(player) && creation_areConditionsMet(player)) {
                    event.setNewDamage(event.getOriginalDamage() * 0.8f);
                }
            } else if (event.getSource().getEntity() instanceof Player attacker) {
                if (creation_hasCreationMaster(attacker) && creation_areConditionsMet(attacker)) {
                    event.setNewDamage(event.getOriginalDamage() * 1.2f);
                }
            }
        }
    }

    @SubscribeEvent
    public static void creation_onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) return;
        if (creation_hasCreationMaster(player) && creation_areConditionsMet(player)) {
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, CREATION_HASTE_DURATION, 2, false, false));
        }
    }

    // === CRYSTAL ===
    private static final Set<BlockState> AMETHYST_BLOCKS = Set.of(
        Blocks.AMETHYST_BLOCK.defaultBlockState(),
        Blocks.BUDDING_AMETHYST.defaultBlockState(),
        Blocks.AMETHYST_CLUSTER.defaultBlockState(),
        Blocks.LARGE_AMETHYST_BUD.defaultBlockState(),
        Blocks.MEDIUM_AMETHYST_BUD.defaultBlockState(),
        Blocks.SMALL_AMETHYST_BUD.defaultBlockState()
    );

    private static boolean crystal_hasAmethystNearby(ServerLevel level, BlockPos center) {
        int radius = 16;
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos pos = center.offset(x, y, z);
                    BlockState state = level.getBlockState(pos);
                    if (AMETHYST_BLOCKS.contains(state)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void crystal_onPlayerAttacked(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        if (!(target instanceof ServerPlayer player)) return;
        if (!player.hasEffect(PowerModMobEffects.CRYSTAL_MASTER)) return;
        ServerLevel level = (ServerLevel) player.level();
        if (!crystal_hasAmethystNearby(level, player.blockPosition())) return;
        LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
        if (attacker instanceof LivingEntity livingAttacker && level.random.nextFloat() < 0.125f) {
            livingAttacker.addEffect(new MobEffectInstance(PowerModMobEffects.STUN, 100));
        }
    }

    @SubscribeEvent
    public static void crystal_onPlayerHurt(LivingIncomingDamageEvent event) {
        LivingEntity target = event.getEntity();
        if (!(target instanceof ServerPlayer player)) return;
        if (!player.hasEffect(PowerModMobEffects.CRYSTAL_MASTER)) return;
        ServerLevel level = (ServerLevel) player.level();
        if (!crystal_hasAmethystNearby(level, player.blockPosition())) return;
        if (level.random.nextFloat() < 0.10f) {
            event.setCanceled(true);
        }
    }

    // === DARKNESS ===
    private static final int DARKNESS_EFFECT_DURATION = 10 * 20;

    private static boolean darkness_isInDarkness(Player player) {
        Level level = player.level();
        if (level.getMaxLocalRawBrightness(player.blockPosition()) <= 7) {
            return true;
        }
        if (level.dimension() == Level.OVERWORLD) {
            long time = level.getDayTime() % 24000;
            return time >= 13000 && time < 23000;
        }
        return false;
    }

    private static boolean darkness_isActive(Player player) {
        return !player.level().isClientSide() &&
               player.hasEffect(PowerModMobEffects.DARKNESS_MASTER) &&
               darkness_isInDarkness(player);
    }

    @SubscribeEvent
    public static void darkness_onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        if (target.level().isClientSide()) return;
        if (target instanceof Player player) {
            if (darkness_isActive(player)) {
                event.setNewDamage(event.getOriginalDamage() * 0.55f);
            }
        }
        if (event.getSource().getEntity() instanceof Player attacker) {
            if (darkness_isActive(attacker)) {
                event.setNewDamage(event.getOriginalDamage() * 1.35f);
                if (attacker.getRandom().nextFloat() < 0.3f) {
                    Holder<MobEffect>[] effects = (Holder<MobEffect>[]) new Holder<?>[]{
                        MobEffects.WEAKNESS,
                        MobEffects.MOVEMENT_SLOWDOWN,
                        PowerModMobEffects.STUN,
                        MobEffects.BLINDNESS
                    };
                    Holder<MobEffect> chosen = effects[attacker.getRandom().nextInt(effects.length)];
                    int amplifier = 1;
                    if (chosen == MobEffects.BLINDNESS || chosen.value() == PowerModMobEffects.STUN.value()) {
                        amplifier = 0;
                    }
                    if (target instanceof LivingEntity livingTarget) {
                        livingTarget.addEffect(new MobEffectInstance(chosen, DARKNESS_EFFECT_DURATION, amplifier, false, true));
                    }
                }
            }
        }
    }

    // === DESTRUCTION ===
    private static final int DESTRUCTION_SEARCH_RADIUS = 16;

    private static boolean destruction_hasDestructionMaster(Player player) {
        return !player.level().isClientSide() && player.hasEffect(PowerModMobEffects.DESTRUCTION_MASTER);
    }

    private static boolean destruction_isNearElementalBlock(Player player) {
        BlockPos center = player.blockPosition();
        int r = DESTRUCTION_SEARCH_RADIUS;
        for (int x = -r; x <= r; x++) {
            for (int y = -r; y <= r; y++) {
                for (int z = -r; z <= r; z++) {
                    BlockPos pos = center.offset(x, y, z);
                    var state = player.level().getBlockState(pos);
                    if (state.is(Blocks.LAVA) || state.is(Blocks.WATER) || state.is(Blocks.FIRE)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean destruction_isInMountains(Player player) {
        return player.level().getBiome(player.blockPosition()).is(BiomeTags.IS_MOUNTAIN);
    }

    private static boolean destruction_isInCave(Player player) {
        BlockPos pos = player.blockPosition();
        return !player.level().canSeeSky(pos.above()) && pos.getY() < 64;
    }

    private static boolean destruction_areConditionsMet(Player player) {
        return destruction_isNearElementalBlock(player) || destruction_isInMountains(player) || destruction_isInCave(player);
    }

    @SubscribeEvent
    public static void destruction_onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (target.level().isClientSide()) return;
        if (!destruction_hasDestructionMaster(attacker) || !destruction_areConditionsMet(attacker)) return;
        float originalDamage = event.getOriginalDamage();
        event.setNewDamage(originalDamage * 1.4f);
        if (attacker.getRandom().nextFloat() < 0.1f) {
            float maxHealth = target.getMaxHealth();
            float currentHealth = target.getHealth();
            if (maxHealth > 0 && currentHealth <= maxHealth * 0.25f) {
                event.setNewDamage(currentHealth + 1.0f);
            }
        }
    }

    // === EARTH ===
    @SubscribeEvent
    public static void earth_onIncomingDamage(LivingIncomingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;
        if (player.level().isClientSide()) return;
        if (!player.hasEffect(PowerModMobEffects.EARTH_MASTER)) return;
        if (player.getBlockY() >= 64) return;
        DamageSource source = event.getSource();
        if (source.getEntity() instanceof LivingEntity) {
            float originalDamage = event.getOriginalAmount();
            float reducedDamage = originalDamage * 0.8f;
            event.setAmount(reducedDamage);
        }
    }

    @SubscribeEvent
    public static void earth_onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        DamageSource source = target.getLastDamageSource();
        if (source == null) return;
        if (!(source.getEntity() instanceof Player player)) return;
        if (player.level().isClientSide()) return;
        if (!player.hasEffect(PowerModMobEffects.EARTH_MASTER)) return;
        if (player.getBlockY() >= 64) return;
        if (RANDOM.nextFloat() < 0.125f) {
            float originalDamage = event.getOriginalDamage();
            float critDamage = originalDamage * 2.0f;
            event.setNewDamage(critDamage);
        }
    }

    // === ENERGY ===
    private static final Map<UUID, Long> energy_lastAttackTime = new HashMap<>();
    private static final Map<UUID, Integer> energy_attackStreak = new HashMap<>();
    private static final Map<UUID, Integer> energy_hungerBeforeSprint = new HashMap<>();

    @SubscribeEvent
    public static void energy_onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        DamageSource source = event.getSource();
        if (!(source.getEntity() instanceof ServerPlayer attacker)) return;
        if (target.level().isClientSide()) return;
        if (!attacker.hasEffect(PowerModMobEffects.ENERGY_MASTER) || attacker.getFoodData().getFoodLevel() < 16) {
            return;
        }
        UUID uuid = attacker.getUUID();
        long currentTime = attacker.level().getGameTime();
        long lastTime = energy_lastAttackTime.getOrDefault(uuid, -100L);
        int streak = energy_attackStreak.getOrDefault(uuid, 0);
        if (currentTime - lastTime <= 60) {
            streak++;
        } else {
            streak = 1;
        }
        energy_lastAttackTime.put(uuid, currentTime);
        energy_attackStreak.put(uuid, streak);
        if (streak % 3 == 0) {
            event.setNewDamage(event.getOriginalDamage() * 1.5f);
        }
    }

    @SubscribeEvent
    public static void energy_onPlayerTickPre(PlayerTickEvent.Pre event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) return;
        if (player.isSprinting() &&
            player.hasEffect(PowerModMobEffects.ENERGY_MASTER) &&
            player.getFoodData().getFoodLevel() >= 16) {
            energy_hungerBeforeSprint.put(player.getUUID(), player.getFoodData().getFoodLevel());
        } else {
            energy_hungerBeforeSprint.remove(player.getUUID());
        }
    }

    @SubscribeEvent
    public static void energy_onPlayerTickPost(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) return;
        UUID uuid = player.getUUID();
        if (energy_hungerBeforeSprint.containsKey(uuid)) {
            int prevHunger = energy_hungerBeforeSprint.get(uuid);
            FoodData food = player.getFoodData();
            if (food.getFoodLevel() < prevHunger) {
                food.setFoodLevel(prevHunger);
            }
            energy_hungerBeforeSprint.remove(uuid);
        }
    }

    // === ETHER ===
    private static final String ETHER_LAST_STAR_REGEN_KEY = "ethermaster_last_star_regen";
    private static final String ETHER_DAMAGE_BOOST_EXPIRE_TICK = "ethermaster_damage_boost_expire";

    @SubscribeEvent
    public static void ether_onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (!player.hasEffect(PowerModMobEffects.ETHER_MASTER)) {
            return;
        }
        var playerVars = player.getData(PowerModVariables.PLAYER_VARIABLES);
        if (playerVars == null) return;
        int prevPower = player.getPersistentData().getInt("prev_power");
        int currentPower = (int) playerVars.power;
        player.getPersistentData().putInt("prev_power", currentPower);
        if (currentPower < prevPower) {
            long currentTime = player.level().getGameTime();
            player.getPersistentData().putLong(ETHER_DAMAGE_BOOST_EXPIRE_TICK, currentTime + 100);
            long lastStarRegen = player.getPersistentData().getLong(ETHER_LAST_STAR_REGEN_KEY);
            if (currentTime - lastStarRegen >= 600) {
                if (player.getRandom().nextFloat() < 0.5f) {
                    player.addEffect(new MobEffectInstance(PowerModMobEffects.STAR_REGENERATION, 200, 1, false, false));
                    player.getPersistentData().putLong(ETHER_LAST_STAR_REGEN_KEY, currentTime);
                }
            }
        }
    }

    @SubscribeEvent
    public static void ether_onLivingHurt(LivingDamageEvent.Pre event) {
        LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
        if (!(attacker instanceof Player player)) {
            return;
        }
        if (!player.hasEffect(PowerModMobEffects.ETHER_MASTER)) {
            return;
        }
        long currentTime = player.level().getGameTime();
        long expireTick = player.getPersistentData().getLong(ETHER_DAMAGE_BOOST_EXPIRE_TICK);
        if (currentTime < expireTick) {
            event.setNewDamage(event.getOriginalDamage() * 1.1f);
        }
    }

    // === EXPLOSION ===
    private static boolean explosion_isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.EXPLOSION_MASTER)) return false;
        return player.getInventory().contains(new ItemStack(Items.TNT)) || 
               player.getInventory().contains(new ItemStack(Items.GUNPOWDER));
    }

    @SubscribeEvent
    public static void explosion_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!explosion_isActive(attacker)) return;
        event.setNewDamage(event.getOriginalDamage() * 1.2f);
    }

    @SubscribeEvent
    public static void explosion_onPlayerKilledByEntity(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!explosion_isActive(player)) return;
        var source = event.getSource();
        var attacker = source.getEntity();
        if (attacker instanceof LivingEntity && attacker != player) {
            explodePlayer(player);
        }
    }

    @SubscribeEvent
    public static void explosion_onExplosionDamage(LivingIncomingDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!explosion_isActive(player)) return;
        if (event.getSource().is(DamageTypes.EXPLOSION)) {
            event.setCanceled(true);
        }
    }

    private static void explodePlayer(Player player) {
        if (player.level() instanceof ServerLevel serverLevel) {
            serverLevel.explode(player, player.getX(), player.getY(), player.getZ(), 3.0f, Level.ExplosionInteraction.MOB);
        }
    }

    // === FIRE ===
    private static boolean fire_hasFireMasterCondition(ServerPlayer player) {
        if (!player.hasEffect(PowerModMobEffects.FIRE_MASTER)) {
            return false;
        }
        Level level = player.level();
        if (level.dimension() == Level.NETHER) {
            return true;
        }
        BlockPos center = player.blockPosition();
        int range = 16;
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
    public static void fire_onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        DamageSource source = event.getSource();
        if (source.getEntity() instanceof ServerPlayer attacker) {
            if (fire_hasFireMasterCondition(attacker)) {
                float original = event.getOriginalDamage();
                event.setNewDamage(original * 1.2f);
            }
        }
    }

    @SubscribeEvent
    public static void fire_onEntityAttacked(LivingIncomingDamageEvent event) {
        if (event.getEntity() != null) {
            fire_execute(event, event.getSource(), event.getEntity());
        }
    }

    private static void fire_execute(@Nullable Event event, DamageSource damagesource, Entity entity) {
        if (damagesource == null || entity == null) return;
        if (entity instanceof Player && damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("minecraft:is_fire")))) {
            if (event instanceof ICancellableEvent _cancellable) {
                if (fire_hasFireMasterCondition((ServerPlayer) entity)) {
                    _cancellable.setCanceled(true);
                }
            }
        }
    }

    // === FORM ===
    private static boolean form_hasFormMaster(Player player) {
        return !player.level().isClientSide() && player.hasEffect(PowerModMobEffects.FORM_MASTER);
    }

    @SubscribeEvent
    public static void form_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!form_hasFormMaster(attacker)) return;
        if (attacker.hasEffect(PowerModMobEffects.GIGANTIZATION)) {
            event.setNewDamage(event.getOriginalDamage() * 1.5f);
        }
    }

    @SubscribeEvent
    public static void form_onPlayerTakeDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!form_hasFormMaster(player)) return;
        if (player.hasEffect(PowerModMobEffects.MINIATURIZATION)) {
            event.setNewDamage(event.getOriginalDamage() * 0.25f);
        }
    }

    // === GOLDEN_DUST ===
    private static final int GOLDEN_DUST_EFFECT_DURATION = 10 * 20;
    private static final int GOLDEN_DUST_SEARCH_RADIUS = 16;

    private static boolean goldenDust_isElementalMasterNearby(Player player) {
        var players = player.level().getEntitiesOfClass(
            Player.class,
            player.getBoundingBox().inflate(GOLDEN_DUST_SEARCH_RADIUS)
        );
        for (Player other : players) {
            if (other == player) continue;
            String element = other.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first;
            if (!element.equals("0")) {
                return true;
            }
        }
        return false;
    }

    private static boolean goldenDust_isActive(Player player) {
        return !player.level().isClientSide() &&
               player.hasEffect(PowerModMobEffects.GOLDEN_DUST_MASTER) &&
               goldenDust_isElementalMasterNearby(player);
    }

    @SubscribeEvent
    public static void goldenDust_onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        if (target.level().isClientSide()) return;
        if (target instanceof Player player) {
            if (goldenDust_isActive(player)) {
                event.setNewDamage(event.getOriginalDamage() * 0.55f);
                if (player.getRandom().nextFloat() < 0.3f) {
                    Holder<MobEffect>[] effects = (Holder<MobEffect>[]) new Holder<?>[]{
                        MobEffects.REGENERATION,
                        PowerModMobEffects.STAR_REGENERATION,
                        MobEffects.DAMAGE_BOOST,
                        PowerModMobEffects.DASH
                    };
                    Holder<MobEffect> chosen = effects[player.getRandom().nextInt(effects.length)];
                    int amplifier = 1;
                    player.addEffect(new MobEffectInstance(chosen, GOLDEN_DUST_EFFECT_DURATION, amplifier, false, true));
                }
            }
        }
        if (event.getSource().getEntity() instanceof Player attacker) {
            if (goldenDust_isActive(attacker)) {
                event.setNewDamage(event.getOriginalDamage() * 1.35f);
            }
        }
    }

    // === GRAVITY ===
    private static final int GRAVITY_LEVITATION_DURATION = 25 * 20;
    private static final int GRAVITY_SLOW_FALLING_DURATION = 30;

    private static boolean gravity_isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.GRAVITY_MASTER)) return false;
        return player.level().canSeeSky(player.blockPosition().above());
    }

    @SubscribeEvent
    public static void gravity_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity target)) return;
        if (!gravity_isActive(attacker)) return;
        if (attacker.getRandom().nextFloat() < 0.1f) {
            target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, GRAVITY_LEVITATION_DURATION, 0, false, true));
        }
    }

    @SubscribeEvent
    public static void gravity_onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) return;
        if (!gravity_isActive(player)) return;
        if (!player.hasEffect(MobEffects.SLOW_FALLING)) {
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, GRAVITY_SLOW_FALLING_DURATION, 0, false, false));
        }
    }

    // === HEAT ===
    private static final int HEAT_FIRE_DURATION = 3;
    private static final int HEAT_FIRE_RESIST_DURATION = 60 * 20;
    private static final int HEAT_REGEN_DURATION = 5 * 20;
    private static final int HEAT_COOLDOWN = 90 * 20;
    private static final Map<UUID, Long> heat_lastActivationTime = new HashMap<>();
    private static final Map<UUID, Boolean> heat_wasBurning = new HashMap<>();

    private static boolean heat_isInWarmOrTemperateBiome(Player player) {
        Biome biome = player.level().getBiome(player.blockPosition()).value();
        return biome.getModifiedClimateSettings().temperature() >= 0.2f;
    }

    private static boolean heat_isActive(Player player) {
        return !player.level().isClientSide() &&
               player.hasEffect(PowerModMobEffects.HEAT_MASTER) &&
               heat_isInWarmOrTemperateBiome(player);
    }

    @SubscribeEvent
    public static void heat_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity target)) return;
        if (!heat_isActive(attacker)) return;
        event.setNewDamage(event.getOriginalDamage() * 1.2f);
        if (attacker.getRandom().nextFloat() < 0.1f) {
            target.igniteForSeconds(HEAT_FIRE_DURATION);
        }
    }

    @SubscribeEvent
    public static void heat_onPlayerTick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof Player player)) return;
        UUID id = player.getUUID();
        if (!heat_isActive(player)) {
            heat_wasBurning.remove(id);
            heat_lastActivationTime.remove(id);
            return;
        }
        boolean isBurning = player.isOnFire();
        Boolean wasBurningBefore = heat_wasBurning.get(id);
        if (isBurning && (wasBurningBefore == null || !wasBurningBefore)) {
            long now = player.level().getGameTime();
            Long last = heat_lastActivationTime.get(id);
            if (last == null || now - last >= HEAT_COOLDOWN) {
                if (player.getRandom().nextFloat() < 0.75f) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, HEAT_FIRE_RESIST_DURATION, 0, false, true));
                    player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, HEAT_REGEN_DURATION, 1, false, true));
                    heat_lastActivationTime.put(id, now);
                }
            }
        }
        heat_wasBurning.put(id, isBurning);
    }

    // === ICE ===
    private static final float ICE_COLD_BIOME_THRESHOLD = 0.25f;

    private static boolean ice_isInColdBiome(Player player) {
        Level level = player.level();
        if (level.isClientSide()) return false;
        Biome biome = level.getBiome(player.blockPosition()).value();
        return biome.getBaseTemperature() <= ICE_COLD_BIOME_THRESHOLD;
    }

    private static boolean ice_hasIceMasterEffect(Player player) {
        return player.hasEffect(PowerModMobEffects.ICE_MASTER);
    }

    @SubscribeEvent
    public static void ice_onLivingAttack(LivingDamageEvent.Pre event) {
        if (event.getSource().getEntity() instanceof Player attacker) {
            if (!attacker.level().isClientSide() && ice_hasIceMasterEffect(attacker) && ice_isInColdBiome(attacker)) {
                LivingEntity target = event.getEntity();
                if (RANDOM.nextFloat() < 0.20f) {
                    target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 2));
                    event.setNewDamage(event.getOriginalDamage() * 1.5f);
                }
            }
        }
    }

    @SubscribeEvent
    public static void ice_onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (player.level().isClientSide() || !ice_hasIceMasterEffect(player) || !ice_isInColdBiome(player)) {
            return;
        }
        Level level = player.level();
        BlockPos feetPos = player.blockPosition().below();
        BlockState state = level.getBlockState(feetPos);
        if (state.is(Blocks.WATER)) {
            int waterLevel = state.getValue(BlockStateProperties.LEVEL);
            if (waterLevel == 0 && level instanceof ServerLevel serverLevel) {
                serverLevel.setBlock(feetPos, Blocks.FROSTED_ICE.defaultBlockState(), 3);
            }
        }
    }

    // === LAVA ===
    private static final int LAVA_CHECK_RADIUS = 16;

    private static boolean lava_isLavaMasterConditionMet(Player player) {
        if (player.level().dimension().location().getPath().equals("the_nether")) {
            return true;
        }
        BlockPos playerPos = player.blockPosition();
        for (int x = -LAVA_CHECK_RADIUS; x <= LAVA_CHECK_RADIUS; x++) {
            for (int y = -LAVA_CHECK_RADIUS; y <= LAVA_CHECK_RADIUS; y++) {
                for (int z = -LAVA_CHECK_RADIUS; z <= LAVA_CHECK_RADIUS; z++) {
                    BlockPos checkPos = playerPos.offset(x, y, z);
                    BlockState state = player.level().getBlockState(checkPos);
                    if (state.is(Blocks.LAVA) || state.is(Blocks.MAGMA_BLOCK)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void lava_onIncomingDamage(LivingIncomingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;
        if (player.level().isClientSide()) return;
        if (!player.hasEffect(PowerModMobEffects.LAVA_MASTER)) return;
        if (!lava_isLavaMasterConditionMet(player)) return;
        DamageSource source = event.getSource();
        if (source.is(DamageTypes.LAVA) || source.is(DamageTypes.IN_FIRE) || source.is(DamageTypes.ON_FIRE)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void lava_onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
        if (!(attacker instanceof Player player)) return;
        if (player.level().isClientSide()) return;
        if (!player.hasEffect(PowerModMobEffects.LAVA_MASTER)) return;
        if (!lava_isLavaMasterConditionMet(player)) return;
        if (RANDOM.nextFloat() < 0.125f) {
            float originalDamage = event.getOriginalDamage();
            float critDamage = originalDamage * 1.5f;
            event.setNewDamage(critDamage);
        }
    }

    // === LIGHTNING ===
    @SubscribeEvent
    public static void lightning_onLivingHurt(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        Entity attacker = event.getSource().getEntity();
        if (attacker instanceof Player sourcePlayer
            && sourcePlayer.hasEffect(PowerModMobEffects.LIGHTNING_MASTER)
            && target.level() instanceof ServerLevel serverLevel) {
            if (RANDOM.nextFloat() < 0.1f) {
                LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(serverLevel);
                if (lightning != null) {
                    lightning.moveTo(target.getX(), target.getY(), target.getZ());
                    lightning.setCause((ServerPlayer) sourcePlayer);
                    serverLevel.addFreshEntity(lightning);
                }
            }
        }
        if (target instanceof ServerPlayer player
            && player.hasEffect(PowerModMobEffects.LIGHTNING_MASTER)
            && event.getSource().is(DamageTypes.LIGHTNING_BOLT)) {
            if (player.level().isThundering() && player.level().canSeeSky(player.blockPosition().above())) {
                int duration = 200;
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, duration, 1, false, false, true));
                player.addEffect(new MobEffectInstance(PowerModMobEffects.STAR_REGENERATION, duration, 1, false, false, true));
            }
        }
    }

    // === LIGHT ===
    private static final Map<UUID, Long> light_dashCooldowns = new HashMap<>();

    @SubscribeEvent
    public static void light_onLivingDamaged(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        var source = event.getSource();
        if (source.getEntity() instanceof Player attacker) {
            if (!light_hasLightMasterAndEnoughLight(attacker)) {
                return;
            }
            float originalDamage = event.getOriginalDamage();
            event.setNewDamage(originalDamage * 1.2f);
            UUID playerId = attacker.getUUID();
            long currentTime = attacker.level().getGameTime();
            if (light_dashCooldowns.containsKey(playerId)) {
                long lastUsed = light_dashCooldowns.get(playerId);
                if (currentTime - lastUsed < 25 * 20) {
                    return;
                }
            }
            if (attacker.getRandom().nextFloat() < 0.1f) {
                attacker.addEffect(new MobEffectInstance(PowerModMobEffects.DASH, 7 * 20, 1, false, false));
                light_dashCooldowns.put(playerId, currentTime);
            }
        }
    }

    private static boolean light_hasLightMasterAndEnoughLight(Player player) {
        if (!player.hasEffect(PowerModMobEffects.LIGHT_MASTER)) {
            return false;
        }
        int lightLevel = player.level().getMaxLocalRawBrightness(player.blockPosition());
        return lightLevel >= 12;
    }

    // === MAGNET ===
    private static final int MAGNET_SEARCH_RADIUS = 16;
    private static final int MAGNET_ITEM_ATTRACT_RADIUS = 16;
    private static final double MAGNET_ATTRACT_SPEED = 0.2;

    private static boolean magnet_isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.MAGNET_MASTER)) return false;
        BlockPos center = player.blockPosition();
        for (int x = -MAGNET_SEARCH_RADIUS; x <= MAGNET_SEARCH_RADIUS; x++) {
            for (int y = -MAGNET_SEARCH_RADIUS; y <= MAGNET_SEARCH_RADIUS; y++) {
                for (int z = -MAGNET_SEARCH_RADIUS; z <= MAGNET_SEARCH_RADIUS; z++) {
                    BlockPos pos = center.offset(x, y, z);
                    var block = player.level().getBlockState(pos).getBlock();
                    if (block == Blocks.COPPER_BLOCK || block == Blocks.IRON_BLOCK) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void magnet_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!magnet_isActive(attacker)) return;
        event.setNewDamage(event.getOriginalDamage() * 1.2f);
        if (attacker.getRandom().nextFloat() < 0.2f) {
            Entity target = event.getEntity();
            Vec3 direction = target.position().subtract(attacker.position()).normalize();
            if (direction.lengthSqr() < 1e-6) {
                direction = new Vec3(0, 0, 1);
            }
            if (!target.level().isClientSide() && target instanceof LivingEntity living) {
                living.push(direction.x * 1.0, 0.4, direction.z * 1.0);
                living.hurtMarked = true;
            }
        }
    }

    @SubscribeEvent
    public static void magnet_onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (!(player instanceof ServerPlayer)) return;
        if (!magnet_isActive(player)) return;
        var entities = player.level().getEntitiesOfClass(
            ItemEntity.class,
            player.getBoundingBox().inflate(MAGNET_ITEM_ATTRACT_RADIUS)
        );
        Vec3 playerPos = player.position();
        for (ItemEntity item : entities) {
            if (item.isRemoved() || item.isNoGravity()) continue;
            Vec3 itemPos = item.position();
            Vec3 direction = playerPos.subtract(itemPos);
            double distance = direction.length();
            if (distance > 0.5) {
                direction = direction.normalize();
                item.setDeltaMovement(
                    item.getDeltaMovement().add(
                        direction.x * MAGNET_ATTRACT_SPEED,
                        direction.y * MAGNET_ATTRACT_SPEED * 0.5,
                        direction.z * MAGNET_ATTRACT_SPEED
                    )
                );
                item.hurtMarked = true;
            }
        }
    }

    // === MERCURY ===
    private static boolean mercury_isActive(Player player) {
        return !player.level().isClientSide() && player.hasEffect(PowerModMobEffects.MERCURY_MASTER);
    }

    private static float mercury_getBiomeTemperature(Player player) {
        Biome biome = player.level().getBiome(player.blockPosition()).value();
        return biome.getModifiedClimateSettings().temperature();
    }

    private static boolean mercury_isInColdBiome(Player player) {
        return mercury_getBiomeTemperature(player) < 0.2f;
    }

    private static boolean mercury_isInWarmBiome(Player player) {
        return mercury_getBiomeTemperature(player) > 1.0f;
    }

    @SubscribeEvent
    public static void mercury_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!mercury_isActive(attacker)) return;
        if (!mercury_isInColdBiome(attacker)) return;
        event.setNewDamage(event.getOriginalDamage() * 1.25f);
    }

    @SubscribeEvent
    public static void mercury_onPlayerTakeDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!mercury_isActive(player)) return;
        if (!mercury_isInWarmBiome(player)) return;
        event.setNewDamage(event.getOriginalDamage() * 0.5f);
    }

    // === METAL ===
    private static final Set<Block> METAL_BLOCKS = Set.of(
        Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE, Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE,
        Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE, Blocks.ANCIENT_DEBRIS, Blocks.NETHER_GOLD_ORE,
        Blocks.RAW_IRON_BLOCK, Blocks.RAW_COPPER_BLOCK, Blocks.RAW_GOLD_BLOCK,
        Blocks.IRON_BLOCK, Blocks.COPPER_BLOCK, Blocks.GOLD_BLOCK, Blocks.NETHERITE_BLOCK
    );
    private static final Map<UUID, Boolean> metal_nearMetalCache = new HashMap<>();
    private static final Map<UUID, Long> metal_lastCheckTick = new HashMap<>();
    private static final int METAL_CHECK_INTERVAL_TICKS = 20;
    private static final Map<UUID, Long> metal_lastCounterAttack = new HashMap<>();

    private static boolean metal_isNearMetalBlocks(Player player) {
        UUID uuid = player.getUUID();
        Level level = player.level();
        if (level.isClientSide()) return false;
        long currentTick = level.getGameTime();
        if (metal_lastCheckTick.getOrDefault(uuid, 0L) + METAL_CHECK_INTERVAL_TICKS <= currentTick) {
            boolean result = metal_checkForMetalBlocks(player);
            metal_nearMetalCache.put(uuid, result);
            metal_lastCheckTick.put(uuid, currentTick);
            return result;
        }
        return metal_nearMetalCache.getOrDefault(uuid, false);
    }

    private static boolean metal_checkForMetalBlocks(Player player) {
        var center = player.blockPosition();
        var level = player.level();
        for (int dx = -16; dx <= 16; dx++) {
            for (int dy = -16; dy <= 16; dy++) {
                for (int dz = -16; dz <= 16; dz++) {
                    var block = level.getBlockState(center.offset(dx, dy, dz)).getBlock();
                    if (METAL_BLOCKS.contains(block)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void metal_onIncomingDamage(LivingIncomingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Player player && !player.level().isClientSide()) {
            if (player.hasEffect(PowerModMobEffects.METAL_MASTER) && metal_isNearMetalBlocks(player)) {
                event.setAmount(event.getAmount() * 0.8f);
            }
        }
    }

    @SubscribeEvent
    public static void metal_onLivingHurt(LivingDamageEvent.Pre event) {
        var source = event.getSource();
        if (source.getEntity() instanceof Player player && !player.level().isClientSide()) {
            if (player.hasEffect(PowerModMobEffects.METAL_MASTER) && metal_isNearMetalBlocks(player)) {
                event.setNewDamage(event.getOriginalDamage() * 1.1f);
            }
        }
    }

    @SubscribeEvent
    public static void metal_onPlayerAttack(AttackEntityEvent event) {
        Player player = event.getEntity();
        if (player.level().isClientSide() || !(player instanceof ServerPlayer serverPlayer)) {
            return;
        }
        if (player.hasEffect(PowerModMobEffects.METAL_MASTER) && metal_isNearMetalBlocks(player)) {
            long now = System.currentTimeMillis();
            long last = metal_lastCounterAttack.getOrDefault(player.getUUID(), 0L);
            if (now - last >= 60_000) {
                if (player.getRandom().nextFloat() < 0.15f) {
                    serverPlayer.addEffect(new MobEffectInstance(PowerModMobEffects.DASH, 300, 3, false, false));
                    metal_lastCounterAttack.put(player.getUUID(), now);
                }
            }
        }
    }

    // === MIND ===
    private static final int MIND_DASH_DURATION = 15 * 20;
    private static final int MIND_SEARCH_RADIUS = 16;

    private static boolean mind_hasMindMaster(Player player) {
        return !player.level().isClientSide() && player.hasEffect(PowerModMobEffects.MIND_MASTER);
    }

    private static Player mind_getHypnotizer(Player hypnotized) {
        String ownerIdStr = hypnotized.getData(PowerModVariables.PLAYER_VARIABLES).mind_player_owner;
        if (ownerIdStr == null || ownerIdStr.isEmpty()) {
            return null;
        }
        try {
            UUID ownerId = UUID.fromString(ownerIdStr);
            Player owner = hypnotized.level().getPlayerByUUID(ownerId);
            return owner;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static boolean mind_isHypnotizedAndControlled(Player player) {
        return mind_getHypnotizer(player) != null;
    }

    private static boolean mind_isControlledHypnotizedPlayerNearby(Player mindMaster) {
        return mindMaster.level()
            .getEntitiesOfClass(Player.class, mindMaster.getBoundingBox().inflate(MIND_SEARCH_RADIUS))
            .stream()
            .anyMatch(p -> !p.getUUID().equals(mindMaster.getUUID()) && mind_isHypnotizedAndControlled(p));
    }

    @SubscribeEvent
    public static void mind_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity)) return;
        if (attacker.level().isClientSide()) return;
        boolean applyDash = false;
        if (mind_hasMindMaster(attacker) && mind_isControlledHypnotizedPlayerNearby(attacker)) {
            event.setNewDamage(event.getOriginalDamage() * 1.2f);
            if (attacker.getRandom().nextFloat() < 0.15f) {
                applyDash = true;
            }
        } else {
            Player hypnotizer = mind_getHypnotizer(attacker);
            if (hypnotizer != null) {
                if (mind_hasMindMaster(hypnotizer) && hypnotizer.distanceToSqr(attacker) <= MIND_SEARCH_RADIUS * MIND_SEARCH_RADIUS) {
                    event.setNewDamage(event.getOriginalDamage() * 1.1f);
                    if (attacker.getRandom().nextFloat() < 0.15f) {
                        applyDash = true;
                    }
                }
            }
        }
        if (applyDash) {
            attacker.addEffect(new MobEffectInstance(PowerModMobEffects.DASH, MIND_DASH_DURATION, 0, false, false));
        }
    }

    // === MIST ===
    private static final int MIST_REGEN_DURATION = 15 * 20;
    private static final int MIST_REGEN_COOLDOWN = 45 * 20;
    private static final int MIST_WATER_RADIUS = 8;
    private static final Map<UUID, Long> mist_lastRegenTime = new HashMap<>();

    private static boolean mist_isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.MIST_MASTER)) return false;
        Level level = player.level();
        BlockPos pos = player.blockPosition();
        Biome biome = level.getBiome(pos).value();
        if (biome.getModifiedClimateSettings().downfall() >= 0.6f) {
            return true;
        }
        for (int x = -MIST_WATER_RADIUS; x <= MIST_WATER_RADIUS; x++) {
            for (int y = -MIST_WATER_RADIUS; y <= MIST_WATER_RADIUS; y++) {
                for (int z = -MIST_WATER_RADIUS; z <= MIST_WATER_RADIUS; z++) {
                    if (level.getBlockState(pos.offset(x, y, z)).is(Blocks.WATER)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean mist_isMorning(Player player) {
        long dayTime = player.level().getDayTime() % 24000;
        return dayTime >= 1000 && dayTime <= 12000;
    }

    @SubscribeEvent
    public static void mist_onPlayerTakeDamage(LivingIncomingDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!mist_isActive(player)) return;
        if (player.getRandom().nextFloat() < 0.1f) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void mist_onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) return;
        if (!mist_isActive(player)) return;
        if (!mist_isMorning(player)) return;
        UUID playerId = player.getUUID();
        long currentTime = player.level().getGameTime();
        Long lastTime = mist_lastRegenTime.get(playerId);
        if (lastTime == null || (currentTime - lastTime) >= MIST_REGEN_COOLDOWN) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, MIST_REGEN_DURATION, 1, false, true));
            mist_lastRegenTime.put(playerId, currentTime);
        }
    }

    // === MOON ===
    @SubscribeEvent
    public static void moon_onLivingHurt(LivingDamageEvent.Pre event) {
        LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
        if (!(attacker instanceof Player player)) return;
        if (!player.hasEffect(PowerModMobEffects.MOON_MASTER)) return;
        if (!player.level().isNight()) return;
        if (!player.level().canSeeSky(player.blockPosition())) return;
        int moonPhase = player.level().getMoonPhase();
        if (moonPhase == 0) {
            event.setNewDamage(event.getOriginalDamage() * 1.5f);
            if (player.getRandom().nextFloat() < 0.3f) {
                LivingEntity target = event.getEntity();
                if (target instanceof LivingEntity livingTarget) {
                    livingTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 2, false, true));
                }
            }
        } else {
            event.setNewDamage(event.getOriginalDamage() * 1.1f);
            if (player.getRandom().nextFloat() < 0.10f) {
                var playerVars = player.getData(PowerModVariables.PLAYER_VARIABLES);
                if (playerVars != null) {
                    playerVars.power += 10;
                }
            }
        }
    }

    // === MUSHROOMS ===
    private static final int MUSHROOMS_NAUSEA_DURATION = 20 * 20;
    private static final int MUSHROOMS_SEARCH_RADIUS = 16;

    private static boolean mushrooms_isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.MUSHROOMS_MASTER)) return false;
        BlockPos center = player.blockPosition();
        for (int x = -MUSHROOMS_SEARCH_RADIUS; x <= MUSHROOMS_SEARCH_RADIUS; x++) {
            for (int y = -MUSHROOMS_SEARCH_RADIUS; y <= MUSHROOMS_SEARCH_RADIUS; y++) {
                for (int z = -MUSHROOMS_SEARCH_RADIUS; z <= MUSHROOMS_SEARCH_RADIUS; z++) {
                    BlockPos pos = center.offset(x, y, z);
                    var state = player.level().getBlockState(pos);
                    if (state.is(Blocks.RED_MUSHROOM) || state.is(Blocks.BROWN_MUSHROOM) ||
                        state.is(Blocks.CRIMSON_FUNGUS) || state.is(Blocks.WARPED_FUNGUS) ||
                        state.is(Blocks.MUSHROOM_STEM) || state.is(Blocks.BROWN_MUSHROOM_BLOCK) ||
                        state.is(Blocks.RED_MUSHROOM_BLOCK) || state.is(Blocks.MYCELIUM) ||
                        state.is(Blocks.CRIMSON_NYLIUM) || state.is(Blocks.WARPED_NYLIUM) ||
                        state.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void mushrooms_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity target)) return;
        if (!mushrooms_isActive(attacker)) return;
        event.setNewDamage(event.getOriginalDamage() * 1.1f);
        if (attacker.getRandom().nextFloat() < 0.15f) {
            target.addEffect(new MobEffectInstance(MobEffects.CONFUSION, MUSHROOMS_NAUSEA_DURATION, 3, false, true));
        }
    }

    @SubscribeEvent
    public static void mushrooms_onPlayerTakeDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!mushrooms_isActive(player)) return;
        if (player.getRandom().nextFloat() < 0.15f) {
            int current = player.getFoodData().getFoodLevel();
            player.getFoodData().setFoodLevel(Math.min(20, current + 4));
        }
    }

    // === MUSIC ===
    private static final int MUSIC_WEAKNESS_DURATION = 10 * 20;
    private static final int MUSIC_REGEN_DURATION = 15 * 20;
    private static final int MUSIC_REGEN_COOLDOWN = 90 * 20;
    private static final int MUSIC_SEARCH_RADIUS = 16;
    private static final Map<UUID, Long> music_lastRegenTime = new HashMap<>();

    private static boolean music_isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.MUSIC_MASTER)) return false;
        BlockPos center = player.blockPosition();
        for (int x = -MUSIC_SEARCH_RADIUS; x <= MUSIC_SEARCH_RADIUS; x++) {
            for (int y = -MUSIC_SEARCH_RADIUS; y <= MUSIC_SEARCH_RADIUS; y++) {
                for (int z = -MUSIC_SEARCH_RADIUS; z <= MUSIC_SEARCH_RADIUS; z++) {
                    BlockPos pos = center.offset(x, y, z);
                    var block = player.level().getBlockState(pos).getBlock();
                    if (block == Blocks.NOTE_BLOCK || block == Blocks.JUKEBOX) {
                        return true;
                    }
                }
            }
        }
        for (ItemStack stack : player.getInventory().items) {
            if (!stack.isEmpty() && stack.is(Tags.Items.MUSIC_DISCS)) {
                return true;
            }
        }
        ItemStack offhand = player.getOffhandItem();
        return !offhand.isEmpty() && offhand.is(Tags.Items.MUSIC_DISCS);
    }

    @SubscribeEvent
    public static void music_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity target)) return;
        if (!music_isActive(attacker)) return;
        event.setNewDamage(event.getOriginalDamage() * 1.2f);
        if (attacker.getRandom().nextFloat() < 0.1f) {
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, MUSIC_WEAKNESS_DURATION, 2, false, true));
        }
    }

    @SubscribeEvent
    public static void music_onPlayerTakeDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!music_isActive(player)) return;
        UUID id = player.getUUID();
        long now = player.level().getGameTime();
        Long last = music_lastRegenTime.get(id);
        if ((last == null || now - last >= MUSIC_REGEN_COOLDOWN) && player.getRandom().nextFloat() < 0.1f) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, MUSIC_REGEN_DURATION, 1, false, true));
            music_lastRegenTime.put(id, now);
        }
    }

    // === OCEAN ===
    private static boolean ocean_isInOceanOrBeachBiome(LivingEntity entity) {
        if (entity.level().isClientSide()) return false;
        BlockPos pos = entity.blockPosition();
        var biome = entity.level().getBiome(pos);
        return biome.is(BiomeTags.IS_OCEAN) || biome.is(BiomeTags.IS_BEACH);
    }

    @SubscribeEvent
    public static void ocean_onLivingHurt(LivingIncomingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;
        if (player.level().isClientSide()) return;
        if (!player.hasEffect(PowerModMobEffects.OCEAN_MASTER)) return;
        if (!ocean_isInOceanOrBeachBiome(player)) return;
        if (RANDOM.nextFloat() < 0.15f) {
            float healAmount = player.getMaxHealth() * 0.75f;
            player.heal(healAmount);
        }
    }

    @SubscribeEvent
    public static void ocean_onLivingTick(PlayerTickEvent.Post event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;
        if (player.level().isClientSide()) return;
        boolean hasOceanMaster = player.hasEffect(PowerModMobEffects.OCEAN_MASTER);
        boolean inValidBiome = ocean_isInOceanOrBeachBiome(player);
        if (hasOceanMaster && inValidBiome) {
            if (!player.hasEffect(MobEffects.CONDUIT_POWER)) {
                player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 30, 0, false, false));
            }
        } else {
            if (player.hasEffect(MobEffects.CONDUIT_POWER)) {
                player.removeEffect(MobEffects.CONDUIT_POWER);
            }
        }
    }

    // === PLAGUE ===
    private static final int PLAGUE_REGEN_DURATION = 5 * 20;
    private static final int PLAGUE_SEARCH_RADIUS = 16;

    private static boolean plague_isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.PLAGUE_MASTER)) return false;
        var entities = player.level().getEntitiesOfClass(
            LivingEntity.class,
            player.getBoundingBox().inflate(PLAGUE_SEARCH_RADIUS)
        );
        for (LivingEntity entity : entities) {
            if (entity.hasEffect(PowerModMobEffects.PLAGUE)) {
                return true;
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void plague_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!plague_isActive(attacker)) return;
        event.setNewDamage(event.getOriginalDamage() * 1.2f);
        if (attacker.getRandom().nextFloat() < 0.1f) {
            attacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, PLAGUE_REGEN_DURATION, 0, false, false));
        }
    }

    @SubscribeEvent
    public static void plague_onPlagueApplicable(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!player.hasEffect(PowerModMobEffects.PLAGUE_MASTER)) return;
        player.removeEffect(MobEffects.POISON);
    }

    // === PLANTS ===
    private static boolean plants_isInValidBiome(Player player) {
        var biome = player.level().getBiome(player.blockPosition());
        return biome.is(Tags.Biomes.IS_FOREST) || biome.is(Tags.Biomes.IS_PLAINS) ||
               biome.is(Tags.Biomes.IS_TAIGA) || biome.is(Tags.Biomes.IS_SWAMP) ||
               biome.is(Tags.Biomes.IS_JUNGLE) || biome.is(Tags.Biomes.IS_SAVANNA);
    }

    private static boolean plants_isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.PLANTS_MASTER)) return false;
        return plants_isInValidBiome(player);
    }

    @SubscribeEvent
    public static void plants_onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity victim = event.getEntity();
        DamageSource source = event.getSource();
        if (source.getEntity() instanceof Player attacker) {
            if (plants_isActive(attacker)) {
                event.setNewDamage(event.getOriginalDamage() * 1.05f);
            }
        }
        if (victim instanceof Player player && plants_isActive(player)) {
            LivingEntity attacker = source.getDirectEntity() instanceof LivingEntity
                ? (LivingEntity) source.getDirectEntity()
                : null;
            if (attacker != null && attacker != player) {
                if (player.getRandom().nextFloat() < 0.25f) {
                    float reflected = event.getOriginalDamage() * 0.5f;
                    attacker.hurt(player.damageSources().thorns(player), reflected);
                }
            }
        }
    }

    @SubscribeEvent
    public static void plants_onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (!plants_isActive(player)) return;
        if (player.getFoodData().getSaturationLevel() > 0.0F || player.getFoodData().getFoodLevel() >= 9) {
            if (player.level().getGameTime() % 20 == 0) {
                if (player.getRandom().nextFloat() < 0.1f) {
                    player.heal(1.0f);
                }
            }
        }
    }

    // === POISON ===
    private static final int POISON_POISON_DURATION = 5 * 20;
    private static final int POISON_IMMUNITY_COOLDOWN = 30 * 20;
    private static final Map<UUID, Long> poison_lastImmunityTime = new HashMap<>();

    private static boolean poison_isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.POISON_MASTER)) return false;
        return poison_hasPoisonPotion(player);
    }

    private static boolean poison_hasPoisonPotion(Player player) {
        for (var stack : player.getInventory().items) {
            if (!stack.isEmpty() && stack.is(Items.POTION)) {
                PotionContents contents = stack.get(DataComponents.POTION_CONTENTS);
                if (contents != null) {
                    Optional<Holder<Potion>> potionOpt = contents.potion();
                    if (potionOpt.isPresent() && potionOpt.get() == Potions.POISON) {
                        return true;
                    }
                }
            }
        }
        var offhand = player.getOffhandItem();
        if (!offhand.isEmpty() && offhand.is(Items.POTION)) {
            PotionContents contents = offhand.get(DataComponents.POTION_CONTENTS);
            if (contents != null) {
                Optional<Holder<Potion>> potionOpt = contents.potion();
                return potionOpt.isPresent() && potionOpt.get() == Potions.POISON;
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void poison_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity target)) return;
        if (!poison_isActive(attacker)) return;
        event.setNewDamage(event.getOriginalDamage() * 1.25f);
        if (attacker.getRandom().nextFloat() < 0.25f) {
            target.addEffect(new MobEffectInstance(MobEffects.POISON, POISON_POISON_DURATION, 1, false, true));
        }
    }

    @SubscribeEvent
    public static void poison_onPoisonApplicable(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!poison_isActive(player)) return;
        player.removeEffect(MobEffects.POISON);
    }

    @SubscribeEvent
    public static void poison_onDebuffAdded(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!poison_isActive(player)) return;
        UUID playerId = player.getUUID();
        long currentTime = player.level().getGameTime();
        Long lastTime = poison_lastImmunityTime.get(playerId);
        if (lastTime == null || (currentTime - lastTime) >= POISON_IMMUNITY_COOLDOWN) {
            if (player.getRandom().nextFloat() < 0.25f) {
                for (int index0 = 0; index0 < 20; index0++) {
                    for (MobEffectInstance effectInstance : player.getActiveEffects()) {
                        if (effectInstance.getEffect().value().getCategory() == MobEffectCategory.HARMFUL) {
                            player.removeEffect(effectInstance.getEffect());
                            break;
                        }
                    }
                }
                poison_lastImmunityTime.put(playerId, currentTime);
            }
        }
    }

    // === RAIN ===
    @SubscribeEvent
    public static void rain_onLivingHurt(LivingDamageEvent.Pre event) {
        LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
        if (!(attacker instanceof ServerPlayer player)) return;
        if (!player.hasEffect(PowerModMobEffects.RAIN_MASTER)) return;
        if (!rain_isPlayerOutsideDuringRain(player)) return;
        float original = event.getOriginalDamage();
        event.setNewDamage(original * 1.15f);
    }

    @SubscribeEvent
    public static void rain_onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (!(player instanceof ServerPlayer serverPlayer)) return;
        if (!serverPlayer.hasEffect(PowerModMobEffects.RAIN_MASTER)) return;
        if (!rain_isPlayerOutsideDuringRain(serverPlayer)) return;
        if (serverPlayer.level().isClientSide()) return;
        if (serverPlayer.getFoodData().getFoodLevel() >= 18 && serverPlayer.getHealth() < serverPlayer.getMaxHealth()) {
            if (serverPlayer.tickCount % 64 == 0) {
                serverPlayer.heal(1.0f);
            }
        }
    }

    private static boolean rain_isPlayerOutsideDuringRain(ServerPlayer player) {
        var level = player.level();
        return level.isRaining() && level.canSeeSky(player.blockPosition().above());
    }

    // === SAND ===
    private static final int SAND_EFFECT_DURATION = 10 * 20;

    private static boolean sand_isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.SAND_MASTER)) return false;
        var biome = player.level().getBiome(player.blockPosition());
        return biome.is(BiomeTags.HAS_VILLAGE_DESERT) || biome.is(BiomeTags.IS_BADLANDS);
    }

    @SubscribeEvent
    public static void sand_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity target)) return;
        if (!sand_isActive(attacker)) return;
        if (attacker.getRandom().nextFloat() < 0.1f) {
            Holder<MobEffect>[] effects = (Holder<MobEffect>[]) new Holder<?>[]{
                MobEffects.BLINDNESS,
                MobEffects.MOVEMENT_SLOWDOWN,
                PowerModMobEffects.STUN
            };
            Holder<MobEffect> chosen = effects[attacker.getRandom().nextInt(effects.length)];
            target.addEffect(new MobEffectInstance(chosen, SAND_EFFECT_DURATION, 0, false, true));
        }
    }

    @SubscribeEvent
    public static void sand_onPlayerTakeDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!sand_isActive(player)) return;
        var source = event.getSource();
        float original = event.getOriginalDamage();
        if (source.is(DamageTypes.FALL)) {
            event.setNewDamage(original * 0.25f);
        } else if (source.getEntity() instanceof LivingEntity || source.getDirectEntity() instanceof LivingEntity) {
            event.setNewDamage(original * 0.75f);
        }
    }

    // === SHADOW ===
    private static final Map<UUID, Long> shadow_weaknessCooldowns = new HashMap<>();

    @SubscribeEvent
    public static void shadow_onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        MobEffectInstance existing = player.getEffect(MobEffects.NIGHT_VISION);
        if (!shadow_hasShadowMasterAndLowLight(player)) return;
        if (!player.hasEffect(MobEffects.NIGHT_VISION)) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0, false, false));
        } else if (existing.getDuration() < 240) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0, false, false));
        }
    }

    @SubscribeEvent
    public static void shadow_onLivingDamaged(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        var source = event.getSource();
        if (source.getEntity() instanceof Player attacker) {
            if (!shadow_hasShadowMasterAndLowLight(attacker)) return;
            float originalDamage = event.getOriginalDamage();
            event.setNewDamage(originalDamage * 1.2f);
            UUID playerId = attacker.getUUID();
            long currentTime = attacker.level().getGameTime();
            if (shadow_weaknessCooldowns.containsKey(playerId)) {
                long lastUsed = shadow_weaknessCooldowns.get(playerId);
                if (currentTime - lastUsed < 25 * 20) {
                    return;
                }
            }
            if (attacker.getRandom().nextFloat() < 0.1f) {
                target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 7 * 20, 1, false, true));
                shadow_weaknessCooldowns.put(playerId, currentTime);
            }
        }
    }

    private static boolean shadow_hasShadowMasterAndLowLight(Player player) {
        if (!player.hasEffect(PowerModMobEffects.SHADOW_MASTER)) {
            return false;
        }
        int lightLevel = player.level().getMaxLocalRawBrightness(player.blockPosition());
        return lightLevel <= 5;
    }

    // === SHOCKWAVE ===
    private static final long SHOCKWAVE_COMBO_RESET_TIME = 9 * 20;
    private static final Map<UUID, Integer> shockwave_attackStreak = new HashMap<>();
    private static final Map<UUID, Long> shockwave_lastAttackTime = new HashMap<>();

    private static boolean shockwave_isStandingOnSolidBlock(Player player) {
        BlockPos pos = player.blockPosition().below();
        BlockState state = player.level().getBlockState(pos);
        return !state.isAir() && state.blocksMotion();
    }

    private static boolean shockwave_isActive(Player player) {
        return !player.level().isClientSide() &&
               player.hasEffect(PowerModMobEffects.SHOCKWAVE_MASTER) &&
               shockwave_isStandingOnSolidBlock(player);
    }

    @SubscribeEvent
    public static void shockwave_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity target)) return;
        if (!shockwave_isActive(attacker)) return;
        UUID id = attacker.getUUID();
        long now = attacker.level().getGameTime();
        long last = shockwave_lastAttackTime.getOrDefault(id, -100L);
        int streak = shockwave_attackStreak.getOrDefault(id, 0);
        if (now - last <= SHOCKWAVE_COMBO_RESET_TIME) {
            streak++;
        } else {
            streak = 1;
        }
        shockwave_lastAttackTime.put(id, now);
        shockwave_attackStreak.put(id, streak);
        if (streak % 3 == 0) {
            event.setNewDamage(event.getOriginalDamage() * 1.5f);
            Vec3 dir = target.position().subtract(attacker.position()).normalize();
            if (dir.lengthSqr() < 1e-6) dir = new Vec3(0, 0, 1);
            target.push(dir.x * 1.2, 0.4, dir.z * 1.2);
            target.hurtMarked = true;
        }
    }

    @SubscribeEvent
    public static void shockwave_onPlayerTick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!player.hasEffect(PowerModMobEffects.SHOCKWAVE_MASTER)) return;
        if (!shockwave_isStandingOnSolidBlock(player)) return;
        Vec3 motion = player.getDeltaMovement();
        player.setDeltaMovement(motion.x * 0.6, motion.y, motion.z * 0.6);
    }

    // === SMOKE ===
    private static final int SMOKE_EFFECT_DURATION = 10 * 20;
    private static final int SMOKE_SEARCH_RADIUS = 16;

    private static boolean smoke_isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.SMOKE_MASTER)) return false;
        var level = player.level();
        var center = player.blockPosition();
        for (int x = -SMOKE_SEARCH_RADIUS; x <= SMOKE_SEARCH_RADIUS; x++) {
            for (int y = -SMOKE_SEARCH_RADIUS; y <= SMOKE_SEARCH_RADIUS; y++) {
                for (int z = -SMOKE_SEARCH_RADIUS; z <= SMOKE_SEARCH_RADIUS; z++) {
                    var pos = center.offset(x, y, z);
                    var block = level.getBlockState(pos).getBlock();
                    if (block == Blocks.FIRE || block == Blocks.CAMPFIRE || block == Blocks.SOUL_CAMPFIRE) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void smoke_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity target)) return;
        if (!smoke_isActive(attacker)) return;
        event.setNewDamage(event.getOriginalDamage() * 1.1f);
        if (attacker.getRandom().nextFloat() < 0.15f) {
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, SMOKE_EFFECT_DURATION, 1, false, true));
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, SMOKE_EFFECT_DURATION, 0, false, true));
        }
    }

    @SubscribeEvent
    public static void smoke_onPlayerTakeDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!smoke_isActive(player)) return;
        if (player.getRandom().nextFloat() < 0.15f) {
            event.setNewDamage(event.getOriginalDamage() * 0.25f);
        }
    }

    // === SOUND ===
    private static final Map<Player, Long> sound_lastStunTime = new HashMap<>();

    private static boolean sound_hasSoundMaster(Player player) {
        return player.hasEffect(PowerModMobEffects.SOUND_MASTER);
    }

    private static boolean sound_isInEnclosedSpace(Player player) {
        if (!(player.level() instanceof ServerLevel)) return false;
        BlockPos center = player.blockPosition();
        int radius = 4;
        int totalBlocks = 0;
        int airBlocks = 0;
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos pos = center.offset(x, y, z);
                    BlockState state = player.level().getBlockState(pos);
                    totalBlocks++;
                    if (state.isAir() || state.getBlock() == Blocks.CAVE_AIR || state.getBlock() == Blocks.VOID_AIR) {
                        airBlocks++;
                    }
                }
            }
        }
        return totalBlocks > 0 && (double) airBlocks / totalBlocks <= 0.5;
    }

    private static boolean sound_isAttackingFromBehind(LivingEntity attacker, LivingEntity target) {
        if (!(attacker instanceof Player) || !(target instanceof Player)) return false;
        double dx = target.getX() - attacker.getX();
        double dz = target.getZ() - attacker.getZ();
        double angleToTarget = Math.toDegrees(Math.atan2(dz, dx)) - 90;
        double attackerYaw = attacker.getYRot();
        double diff = Math.abs((attackerYaw - angleToTarget + 180) % 360 - 180);
        return diff > 90;
    }

    @SubscribeEvent
    public static void sound_onLivingAttack(LivingDamageEvent.Pre event) {
        LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
        LivingEntity target = event.getEntity();
        if (!(attacker instanceof Player player) || !sound_hasSoundMaster(player)) return;
        if (!sound_isInEnclosedSpace(player)) return;
        long currentTime = System.currentTimeMillis();
        Long lastTime = sound_lastStunTime.getOrDefault(player, 0L);
        if (currentTime - lastTime >= 20_000 && RANDOM.nextFloat() < 0.15f) {
            target.addEffect(new MobEffectInstance(PowerModMobEffects.STUN, 100));
            sound_lastStunTime.put(player, currentTime);
        }
    }

    @SubscribeEvent
    public static void sound_onLivingHurt(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
        if (!(target instanceof ServerPlayer player) || !(attacker instanceof LivingEntity)) return;
        if (!sound_hasSoundMaster(player)) return;
        if (!sound_isInEnclosedSpace(player)) return;
        if (sound_isAttackingFromBehind(attacker, player) && RANDOM.nextFloat() < 0.f) {
            if (event instanceof ICancellableEvent _cancellable) {
                _cancellable.setCanceled(true);
            }
        }
    }

    // === SPACE ===
    private static final Map<UUID, Long> space_lastAttackTime = new HashMap<>();
    private static final Map<UUID, Integer> space_attackStreak = new HashMap<>();
    private static final int SPACE_BLINDNESS_DURATION = 5 * 20;
    private static final int SPACE_WEAKNESS_DURATION = 15 * 20;

    private static boolean space_isActiveSpaceMaster(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.SPACE_MASTER)) return false;
        Level level = player.level();
        BlockPos pos = player.blockPosition();
        if (level.dimension() == Level.END) {
            return true;
        }
        return level.canSeeSky(pos.above());
    }

    private static boolean space_isDay(Level level) {
        if (level.dimension() != Level.OVERWORLD) return false;
        long dayTime = level.getDayTime() % 24000;
        return dayTime >= 0 && dayTime < 13000;
    }

    private static boolean space_isNight(Level level) {
        if (level.dimension() != Level.OVERWORLD) return false;
        long dayTime = level.getDayTime() % 24000;
        return dayTime >= 13000;
    }

    @SubscribeEvent
    public static void space_onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (target.level().isClientSide()) return;
        if (!space_isActiveSpaceMaster(attacker)) return;
        Level level = attacker.level();
        boolean inEnd = level.dimension() == Level.END;
        boolean outdoors = inEnd || level.canSeeSky(attacker.blockPosition().above());
        if (!outdoors) return;
        UUID uuid = attacker.getUUID();
        long currentTime = level.getGameTime();
        long lastTime = space_lastAttackTime.getOrDefault(uuid, -100L);
        int streak = space_attackStreak.getOrDefault(uuid, 0);
        if (currentTime - lastTime <= 60) {
            streak++;
        } else {
            streak = 1;
        }
        space_lastAttackTime.put(uuid, currentTime);
        space_attackStreak.put(uuid, streak);
        float originalDamage = event.getOriginalDamage();
        if (inEnd || (level.dimension() == Level.OVERWORLD && space_isDay(level))) {
            if (attacker.getRandom().nextFloat() < 0.1f) {
                event.setNewDamage(originalDamage * 2.0f);
                target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, SPACE_BLINDNESS_DURATION, 0, false, true));
                return;
            }
        }
        if (inEnd || (level.dimension() == Level.OVERWORLD && space_isNight(level))) {
            if (streak % 3 == 0) {
                event.setNewDamage(originalDamage * 1.25f);
                target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, SPACE_WEAKNESS_DURATION, 2, false, true));
            }
        }
    }

    // === SPEED ===
    private static final int SPEED_DASH_DURATION = 3 * 20;

    private static boolean speed_isActive(Player player) {
        return !player.level().isClientSide() &&
               player.hasEffect(PowerModMobEffects.SPEED_MASTER) &&
               player.isSprinting();
    }

    @SubscribeEvent
    public static void speed_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity)) return;
        if (!speed_isActive(attacker)) return;
        event.setNewDamage(event.getOriginalDamage() * 1.25f);
        if (attacker.getRandom().nextFloat() < 0.15f) {
            attacker.addEffect(new MobEffectInstance(PowerModMobEffects.DASH, SPEED_DASH_DURATION, 0, false, false));
        }
    }

    // === SPIRIT ===
    private static final int SPIRIT_BONUS_DURATION = 8 * 20;
    private static final int SPIRIT_CLEARING_DURATION = 60 * 20;

    private static boolean spirit_isActive(Player player) {
        return !player.level().isClientSide() &&
               player.hasEffect(PowerModMobEffects.SPIRIT_MASTER) &&
               player.hasEffect(PowerModMobEffects.PURIFICATION);
    }

    @SubscribeEvent
    public static void spirit_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!spirit_isActive(attacker)) return;
        event.setNewDamage(event.getOriginalDamage() * 1.2f);
    }

    @SubscribeEvent
    public static void spirit_onPlayerTakeDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!spirit_isActive(player)) return;
        if (player.getRandom().nextFloat() < 0.25f) {
            Holder<MobEffect>[] effects = (Holder<MobEffect>[]) new Holder<?>[]{
                MobEffects.REGENERATION,
                PowerModMobEffects.STAR_REGENERATION,
                MobEffects.DAMAGE_BOOST
            };
            Holder<MobEffect> chosen = effects[player.getRandom().nextInt(effects.length)];
            player.addEffect(new MobEffectInstance(chosen, SPIRIT_BONUS_DURATION, 0, false, true));
        }
    }

    @SubscribeEvent
    public static void spirit_onUndeadKill(LivingDeathEvent event) {
        LivingEntity killed = event.getEntity();
        if (killed.level().isClientSide()) return;
        if (!killed.getType().is(EntityTypeTags.UNDEAD)) return;
        var source = event.getSource().getEntity();
        if (!(source instanceof Player player)) return;
        if (player.hasEffect(PowerModMobEffects.SPIRIT_MASTER)) {
            player.addEffect(new MobEffectInstance(PowerModMobEffects.PURIFICATION, SPIRIT_CLEARING_DURATION, 0, false, true));
        }
    }

    // === SUN ===
    private static final Map<UUID, Long> sun_lastHealTime = new HashMap<>();

    private static boolean sun_canSunMasterApply(ServerPlayer player) {
        if (!player.hasEffect(PowerModMobEffects.SUN_MASTER)) return false;
        if (!player.level().canSeeSky(player.blockPosition())) return false;
        long time = player.level().getDayTime() % 24000;
        return time >= 0 && time < 13000;
    }

    @SubscribeEvent
    public static void sun_onLivingDamage(LivingDamageEvent.Pre event) {
        if (event.getEntity().level().isClientSide()) return;
        var source = event.getSource().getEntity();
        var target = event.getEntity();
        if (!(source instanceof ServerPlayer attacker)) return;
        if (!(target instanceof LivingEntity)) return;
        if (!sun_canSunMasterApply(attacker)) return;
        if (attacker.level().random.nextFloat() < 0.10f) {
            target.igniteForSeconds(3);
        }
        float health = attacker.getHealth();
        float maxHealth = attacker.getMaxHealth();
        if (health < maxHealth * 0.75f) {
            float original = event.getOriginalDamage();
            event.setNewDamage(original * 1.2f);
        }
    }

    @SubscribeEvent
    public static void sun_onPlayerTick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (!sun_canSunMasterApply(player)) return;
        float health = player.getHealth();
        float maxHealth = player.getMaxHealth();
        if (health >= maxHealth * 0.75f) return;
        var foodData = player.getFoodData();
        if (foodData.getFoodLevel() < 18 || foodData.getSaturationLevel() <= 0) {
            return;
        }
        long currentTime = player.level().getGameTime();
        UUID uuid = player.getUUID();
        long lastTime = sun_lastHealTime.getOrDefault(uuid, -100L);
        if (currentTime - lastTime >= 8) {
            player.heal(1.0f);
            sun_lastHealTime.put(uuid, currentTime);
            foodData.setSaturation(Math.max(0.0f, foodData.getSaturationLevel() - 6.0f));
        }
    }

    // === TECHNOLOGY ===
    private static final int TECHNOLOGY_SEARCH_RADIUS = 16;
    private static final int TECHNOLOGY_STUN_DURATION = 5 * 20;

    private static boolean technology_hasTechnologyMaster(Player player) {
        return !player.level().isClientSide() && player.hasEffect(PowerModMobEffects.TECHNOLOGY_MASTER);
    }

    private static boolean technology_isNearRedstoneOrMechanism(Player player) {
        BlockPos center = player.blockPosition();
        int r = TECHNOLOGY_SEARCH_RADIUS;
        for (int x = -r; x <= r; x++) {
            for (int y = -r; y <= r; y++) {
                for (int z = -r; z <= r; z++) {
                    BlockPos pos = center.offset(x, y, z);
                    BlockState state = player.level().getBlockState(pos);
                    var block = state.getBlock();
                    if (state.is(BlockTags.REDSTONE_ORES) ||
                        block == Blocks.REDSTONE_WIRE ||
                        block == Blocks.REDSTONE_TORCH ||
                        block == Blocks.REDSTONE_WALL_TORCH ||
                        block == Blocks.REPEATER ||
                        block == Blocks.COMPARATOR ||
                        block == Blocks.LEVER ||
                        block == Blocks.NOTE_BLOCK ||
                        block == Blocks.DISPENSER ||
                        block == Blocks.DROPPER ||
                        block == Blocks.PISTON ||
                        block == Blocks.STICKY_PISTON ||
                        block == Blocks.OBSERVER ||
                        block == Blocks.DAYLIGHT_DETECTOR ||
                        block == Blocks.TARGET ||
                        block == Blocks.SCULK_SENSOR ||
                        block == Blocks.CALIBRATED_SCULK_SENSOR) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void technology_onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        if (target.level().isClientSide()) return;
        if (target instanceof Player player) {
            if (technology_hasTechnologyMaster(player) && technology_isNearRedstoneOrMechanism(player)) {
                event.setNewDamage(event.getOriginalDamage() * 0.8f);
            }
        } else if (event.getSource().getEntity() instanceof Player attacker) {
            if (technology_hasTechnologyMaster(attacker) && technology_isNearRedstoneOrMechanism(attacker)) {
                if (attacker.getRandom().nextFloat() < 0.1f) {
                    target.addEffect(new MobEffectInstance(PowerModMobEffects.STUN, TECHNOLOGY_STUN_DURATION, 0, false, true));
                }
            }
        }
    }

    // === TELEPORTATION ===
    private static final int TELEPORTATION_DASH_DURATION = 3 * 20;
    private static final int TELEPORTATION_TELEPORT_RADIUS = 4;
    private static final int TELEPORTATION_CONDITION_RADIUS = 4;

    @SubscribeEvent
    public static void teleportation_onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (attacker.level().isClientSide()) return;
        if (!teleportation_isActive(attacker) || !teleportation_hasFreeSpace(attacker)) return;
        event.setNewDamage(event.getOriginalDamage() * 1.1f);
        if (attacker.getRandom().nextFloat() < 0.15f) {
            attacker.addEffect(new MobEffectInstance(PowerModMobEffects.DASH, TELEPORTATION_DASH_DURATION, 1, false, false));
        }
    }

    @SubscribeEvent
    public static void teleportation_onPlayerTakeDamage(LivingIncomingDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (player.level().isClientSide()) return;
        if (!teleportation_isActive(player) || !teleportation_hasFreeSpace(player)) return;
        if (player.getRandom().nextFloat() < 0.1f) {
            BlockPos safePos = teleportation_findSafeTeleportPosition(player);
            if (safePos != null && player.level() instanceof ServerLevel) {
                event.setCanceled(true);
                player.teleportTo(safePos.getX() + 0.5, safePos.getY(), safePos.getZ() + 0.5);
            }
        }
    }

    private static boolean teleportation_isActive(Player player) {
        return player.hasEffect(PowerModMobEffects.TELEPORTATION_MASTER);
    }

    private static boolean teleportation_hasFreeSpace(Player player) {
        Level level = player.level();
        BlockPos origin = player.blockPosition();
        RandomSource rand = player.getRandom();
        for (int i = 0; i < 30; i++) {
            int x = origin.getX() + rand.nextInt(TELEPORTATION_CONDITION_RADIUS * 2 + 1) - TELEPORTATION_CONDITION_RADIUS;
            int y = origin.getY() + rand.nextInt(7) - 3;
            int z = origin.getZ() + rand.nextInt(TELEPORTATION_CONDITION_RADIUS * 2 + 1) - TELEPORTATION_CONDITION_RADIUS;
            if (teleportation_isSafePosition(level, new BlockPos(x, y, z))) {
                return true;
            }
        }
        return false;
    }

    private static boolean teleportation_isSafePosition(Level level, BlockPos pos) {
        if (!level.isInWorldBounds(pos)) return false;
        BlockState feet = level.getBlockState(pos);
        BlockState head = level.getBlockState(pos.above());
        BlockState below = level.getBlockState(pos.below());
        if (!feet.isAir() && !feet.canBeReplaced()) return false;
        if (!head.isAir() && !head.canBeReplaced()) return false;
        if (below.isAir() || !below.blocksMotion()) return false;
        if (feet.is(Blocks.LAVA) || head.is(Blocks.LAVA) ||
            feet.is(Blocks.FIRE) || head.is(Blocks.FIRE)) {
            return false;
        }
        return true;
    }

    private static BlockPos teleportation_findSafeTeleportPosition(Player player) {
        Level level = player.level();
        BlockPos origin = player.blockPosition();
        RandomSource rand = player.getRandom();
        for (int i = 0; i < 60; i++) {
            double angle = rand.nextDouble() * Math.PI * 2;
            double dist = rand.nextDouble() * TELEPORTATION_TELEPORT_RADIUS;
            int x = origin.getX() + (int) (Mth.cos((float) angle) * dist);
            int z = origin.getZ() + (int) (Mth.sin((float) angle) * dist);
            int y = origin.getY();
            for (int dy = -4; dy <= 4; dy++) {
                BlockPos candidate = new BlockPos(x, y + dy, z);
                if (teleportation_isSafePosition(level, candidate)) {
                    return candidate;
                }
            }
        }
        return null;
    }

    // === TIME ===
    private static final Map<UUID, UUID> time_countdownOwner = new HashMap<>();
    private static final int TIME_COUNTDOWN_DURATION = 3 * 20;
    private static final int TIME_DASH_DURATION = 5 * 20;

    private static boolean time_isTimeMasterActive(Player player) {
        if (player.level().isClientSide()) return false;
        var effect = player.getEffect(PowerModMobEffects.TIME_MASTER);
        if (effect == null) return false;
        int duration = effect.getDuration();
        int amplifier = effect.getAmplifier();
        var playerVars = player.getData(PowerModVariables.PLAYER_VARIABLES);
        final double TIME_MASTER_MAX_DURATION = playerVars.master_effect_duration * 20;
        return duration <= TIME_MASTER_MAX_DURATION / 2;
    }

    @SubscribeEvent
    public static void time_onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (target.level().isClientSide()) return;
        if (!time_isTimeMasterActive(attacker)) return;
        float originalDamage = event.getOriginalDamage();
        event.setNewDamage(originalDamage * 1.5f);
        if (attacker.getRandom().nextFloat() < 0.2f) {
            attacker.addEffect(new MobEffectInstance(PowerModMobEffects.DASH, TIME_DASH_DURATION, 2, false, false));
        }
        if (attacker.getRandom().nextFloat() < 0.25f) {
            target.addEffect(new MobEffectInstance(PowerModMobEffects.COUNTDOWN, TIME_COUNTDOWN_DURATION, 0, false, true));
            time_countdownOwner.put(target.getUUID(), attacker.getUUID());
        }
    }

    @SubscribeEvent
    public static void time_onLivingDeath(LivingDeathEvent event) {
        LivingEntity target = event.getEntity();
        if (target.level().isClientSide()) return;
        if (!target.hasEffect(PowerModMobEffects.COUNTDOWN)) return;
        UUID attackerId = time_countdownOwner.remove(target.getUUID());
        if (attackerId == null) return;
        if (target.level() instanceof ServerLevel serverLevel) {
            var attacker = serverLevel.getPlayerByUUID(attackerId);
            if (attacker instanceof ServerPlayer serverPlayer && !serverPlayer.isDeadOrDying()) {
                float maxHealth = target.getMaxHealth();
                if (maxHealth > 0) {
                    serverPlayer.heal(maxHealth);
                }
            }
        }
    }

    // === TORNADO ===
    private static final float TORNADO_DASH_ACTIVATION_CHANCE = 0.3f;
    private static final int TORNADO_DASH_DURATION_TICKS = 10 * 20;
    private static final int TORNADO_DASH_COOLDOWN_TICKS = 40 * 20;
    private static final String TORNADO_PERSISTENT_DATA_KEY = "power";
    private static final String TORNADO_LAST_ACTIVATION_TICK_KEY = "tornado_last_activation";

    @SubscribeEvent
    public static void tornado_onLivingDamage(LivingDamageEvent.Pre event) {
        Level level = event.getEntity().level();
        if (!(level instanceof ServerLevel serverLevel)) return;
        LivingEntity target = event.getEntity();
        ServerPlayer attacker = null;
        if (event.getSource().getEntity() instanceof ServerPlayer sp) {
            attacker = sp;
        } else if (event.getSource().getDirectEntity() instanceof ServerPlayer sp) {
            attacker = sp;
        }
        if (attacker == null) return;
        if (!attacker.hasEffect(PowerModMobEffects.TORNADO_MASTER)) return;
        if (!tornado_isPlayerInOpenArea(attacker)) return;
        if (RANDOM.nextFloat() < 0.15f) {
            target.setDeltaMovement(target.getDeltaMovement().x(), 0.8, target.getDeltaMovement().z());
            target.hurtMarked = true;
        }
        if (RANDOM.nextFloat() < TORNADO_DASH_ACTIVATION_CHANCE) {
            CompoundTag persistentData = attacker.getPersistentData();
            CompoundTag modData = persistentData.getCompound(TORNADO_PERSISTENT_DATA_KEY);
            int currentTick = (int) attacker.level().getGameTime();
            int lastActivationTick = modData.getInt(TORNADO_LAST_ACTIVATION_TICK_KEY);
            if (lastActivationTick + TORNADO_DASH_COOLDOWN_TICKS <= currentTick) {
                attacker.addEffect(new MobEffectInstance(PowerModMobEffects.DASH, TORNADO_DASH_DURATION_TICKS, 1, false, true, true));
                modData.putInt(TORNADO_LAST_ACTIVATION_TICK_KEY, currentTick);
                persistentData.put(TORNADO_PERSISTENT_DATA_KEY, modData);
            }
        }
    }

    private static boolean tornado_isPlayerInOpenArea(ServerPlayer player) {
        return player.level().canSeeSky(player.blockPosition().above());
    }

    // === VACUUM ===
    private static final Map<UUID, Long> vacuum_lastImmortalityTrigger = new HashMap<>();

    @SubscribeEvent
    public static void vacuum_onLivingHurt(LivingDamageEvent.Pre event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.level();
        DamageSource source = event.getSource();
        if (!(entity instanceof Player player) || level.isClientSide()) {
            return;
        }
        if (!player.hasEffect(PowerModMobEffects.VACUUM_MASTER)) {
            return;
        }
        if (source.getEntity() == null || !(source.getEntity() instanceof LivingEntity)) {
            return;
        }
        float originalDamage = event.getOriginalDamage();
        float reducedDamage = originalDamage * 0.5f;
        event.setNewDamage(reducedDamage);
        if (player instanceof ServerPlayer serverPlayer) {
            long currentTime = level.getGameTime();
            if (vacuum_lastImmortalityTrigger.containsKey(serverPlayer.getUUID())) {
                long lastTime = vacuum_lastImmortalityTrigger.get(serverPlayer.getUUID());
                if (currentTime - lastTime < 3600) {
                    return;
                }
            }
            if (level.random.nextFloat() < 0.15f) {
                serverPlayer.addEffect(new MobEffectInstance(PowerModMobEffects.IMMORTALITY, 400, 0, false, true, true));
                vacuum_lastImmortalityTrigger.put(serverPlayer.getUUID(), currentTime);
            }
        }
    }

    // === WATER ===
    @SubscribeEvent
    public static void water_onLivingAttack(LivingDamageEvent.Pre event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof ServerPlayer player)) return;
        if (!player.hasEffect(PowerModMobEffects.WATER_MASTER)) return;
        DamageSource source = event.getSource();
        if (!(source.getEntity() instanceof LivingEntity)) return;
        if (RANDOM.nextFloat() < 0.15f) {
            if (RANDOM.nextBoolean()) {
                float reducedDamage = event.getOriginalDamage() * 0.25f;
                event.setNewDamage(reducedDamage);
            } else {
                float maxHealth = player.getMaxHealth();
                float healAmount = maxHealth * 0.4f;
                player.heal(healAmount);
            }
        }
    }

    @SubscribeEvent
    public static void water_onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (!(player instanceof ServerPlayer)) return;
        if (!player.hasEffect(PowerModMobEffects.WATER_MASTER)) return;
        if (water_isWaterNearby(player, 16)) {
            if (!player.hasEffect(MobEffects.WATER_BREATHING)) {
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 30, 0, true, false, false));
            }
        }
    }

    private static boolean water_isWaterNearby(Player player, int radius) {
        BlockPos playerPos = player.blockPosition();
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos pos = playerPos.offset(x, y, z);
                    if (player.level().getFluidState(pos).is(FluidTags.WATER)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}