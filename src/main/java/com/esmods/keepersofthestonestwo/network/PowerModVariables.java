
package com.esmods.keepersofthestonestwo.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.level.LevelEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedDataType;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import java.util.function.Supplier;

import com.mojang.serialization.RecordBuilder;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Codec;
import com.mojang.datafixers.util.Pair;

import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PowerModVariables {
	public static void registerEventHandlers() {
		NeoForge.EVENT_BUS.addListener(GameEventHandler::onWorldCreate);
		NeoForge.EVENT_BUS.addListener(GameEventHandler::onWorldLoad);
	}

	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, PowerMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		PowerMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.ability = original.ability;
			clone.element_name_first = original.element_name_first;
			clone.element_name_second = original.element_name_second;
			clone.element_name_third = original.element_name_third;
			clone.fake_element_name_first = original.fake_element_name_first;
			clone.fake_element_name_second = original.fake_element_name_second;
			clone.fake_element_name_third = original.fake_element_name_third;
			clone.max_power = original.max_power;
			clone.recharge_timer = original.recharge_timer;
			clone.master_effect_duration = original.master_effect_duration;
			clone.selected = original.selected;
			clone.active_battery = original.active_battery;
			clone.debug = original.debug;
			clone.helmet = original.helmet;
			clone.chestplate = original.chestplate;
			clone.leggings = original.leggings;
			clone.boots = original.boots;
			clone.unlock_keepers_box = original.unlock_keepers_box;
			clone.level = original.level;
			clone.level_exp = original.level_exp;
			clone.base_damage_by_lvl = original.base_damage_by_lvl;
			clone.max_level_exp = original.max_level_exp;
			clone.resistance_char = original.resistance_char;
			clone.speed_char = original.speed_char;
			clone.haste_char = original.haste_char;
			clone.jump_char = original.jump_char;
			clone.rank = original.rank;
			clone.mind_used = original.mind_used;
			clone.blue_rune_slot = original.blue_rune_slot;
			clone.red_rune_slot = original.red_rune_slot;
			clone.green_rune_slot = original.green_rune_slot;
			if (!event.isWasDeath()) {
				clone.teleporting_effect = original.teleporting_effect;
				clone.abilities_timer = original.abilities_timer;
				clone.fake_element_name_first_timer = original.fake_element_name_first_timer;
				clone.fake_element_name_second_timer = original.fake_element_name_second_timer;
				clone.fake_element_name_third_timer = original.fake_element_name_third_timer;
				clone.power = original.power;
				clone.powerTimer = original.powerTimer;
				clone.mergers = original.mergers;
				clone.power_recovery_multiplier = original.power_recovery_multiplier;
				clone.active_power = original.active_power;
				clone.ability_block = original.ability_block;
				clone.use_ability_key_var = original.use_ability_key_var;
				clone.detransf_key_var = original.detransf_key_var;
				clone.wheel_open_key_var = original.wheel_open_key_var;
				clone.second_wheel_open_var = original.second_wheel_open_var;
				clone.third_wheel_open_var = original.third_wheel_open_var;
				clone.first_fake_wheel_open_var = original.first_fake_wheel_open_var;
				clone.second_fake_wheel_open_var = original.second_fake_wheel_open_var;
				clone.third_fake_wheel_open_var = original.third_fake_wheel_open_var;
				clone.ability_using = original.ability_using;
				clone.power_recorded = original.power_recorded;
				clone.detransform_anim_trigger = original.detransform_anim_trigger;
				clone.transfered_power = original.transfered_power;
				clone.master_effect_end = original.master_effect_end;
				clone.master_effect_start = original.master_effect_start;
				clone.level_up_status = original.level_up_status;
				clone.mind_player_owner = original.mind_player_owner;
				clone.rune_ovelay_display = original.rune_ovelay_display;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class GameEventHandler {
		@SubscribeEvent
		public static void onWorldCreate(LevelEvent.CreateSpawnPosition event) {
			if (!event.getLevel().isClientSide() && event.getLevel() instanceof ServerLevel level) {
				// Инициализация WorldVariables только при создании мира
				WorldVariables worldVariables = WorldVariables.get(level);
				worldVariables.entity_rotation = 0;
				worldVariables.setDirty();
				// Инициализация MapVariables только при создании мира
				MapVariables mapVariables = MapVariables.get(level);
				mapVariables.opX = 0;
				mapVariables.opY = 0;
				mapVariables.opZ = 0;
				mapVariables.bpX = 0;
				mapVariables.bpY = 0;
				mapVariables.bpZ = 0;
				mapVariables.fire_stone = false;
				mapVariables.air_stone = false;
				mapVariables.earth_stone = false;
				mapVariables.water_stone = false;
				mapVariables.ether_stone = false;
				mapVariables.ice_stone = false;
				mapVariables.lightning_stone = false;
				mapVariables.sound_stone = false;
				mapVariables.crystal_stone = false;
				mapVariables.lava_stone = false;
				mapVariables.rain_stone = false;
				mapVariables.tornado_stone = false;
				mapVariables.ocean_stone = false;
				mapVariables.plants_stone = false;
				mapVariables.animals_stone = false;
				mapVariables.metal_stone = false;
				mapVariables.light_stone = false;
				mapVariables.shadow_stone = false;
				mapVariables.vacuum_stone = false;
				mapVariables.energy_stone = false;
				mapVariables.sun_stone = false;
				mapVariables.moon_stone = false;
				mapVariables.space_stone = false;
				mapVariables.time_stone = false;
				mapVariables.blood_stone = false;
				mapVariables.technology_stone = false;
				mapVariables.teleportation_stone = false;
				mapVariables.explosion_stone = false;
				mapVariables.amber_stone = false;
				mapVariables.creation_stone = false;
				mapVariables.destruction_stone = false;
				mapVariables.mist_stone = false;
				mapVariables.sand_stone = false;
				mapVariables.speed_stone = false;
				mapVariables.poison_stone = false;
				mapVariables.magnet_stone = false;
				mapVariables.mushrooms_stone = false;
				mapVariables.mercury_stone = false;
				mapVariables.music_stone = false;
				mapVariables.plague_stone = false;
				mapVariables.blue_flame_stone = false;
				mapVariables.gravity_stone = false;
				mapVariables.smoke_stone = false;
				mapVariables.spirit_stone = false;
				mapVariables.form_stone = false;
				mapVariables.mind_stone = false;
				mapVariables.golden_dust_stone = false;
				mapVariables.darkness_stone = false;
				mapVariables.blue_portal_placed = false;
				mapVariables.orange_portal_placed = false;
				mapVariables.cpapi_ver = 21.0;
				mapVariables.heat_stone = false;
				mapVariables.shockwave_stone = false;
				mapVariables.setDirty();
			}
		}

		@SubscribeEvent
		public static void onWorldLoad(LevelEvent.Load event) {
			// Только синхронизация при загрузке существующего мира
			if (!event.getLevel().isClientSide() && event.getLevel() instanceof ServerLevel level) {
				WorldVariables.get(level).setDirty();
				MapVariables.get(level).setDirty();
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "power_worldvars";
		public double entity_rotation;
		public static final Codec<WorldVariables> CODEC = new Codec<WorldVariables>() {
			@Override
			public <T> DataResult<Pair<WorldVariables, T>> decode(DynamicOps<T> ops, T input) {
				return ops.getMap(input).flatMap(map -> {
					Builder builder = new Builder();
					Codec.DOUBLE.decode(ops, map.get("entity_rotation")).result().ifPresent(v -> builder.entity_rotation = v.getFirst());
					return DataResult.success(Pair.of(builder.build(), ops.empty()));
				});
			}

			@Override
			public <T> DataResult<T> encode(WorldVariables input, DynamicOps<T> ops, T prefix) {
				RecordBuilder<T> recordBuilder = ops.mapBuilder();
				recordBuilder.add("entity_rotation", Codec.DOUBLE.encode(input.entity_rotation, ops, ops.empty()));
				return recordBuilder.build(prefix);
			}
		};

		private static class Builder {
			double entity_rotation = 0;

			WorldVariables build() {
				return new WorldVariables(entity_rotation);
			}
		}

		public static final SavedDataType<WorldVariables> TYPE = new SavedDataType<>(DATA_NAME, ctx -> new WorldVariables(0), ctx -> CODEC, DataFixTypes.LEVEL);

		public WorldVariables(double entity_rotation) {
			this.entity_rotation = entity_rotation;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof ServerLevel level) {
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, this));
			}
		}

		static WorldVariables clientSide = new WorldVariables(0);

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(TYPE);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "power_mapvars";
		public double opX;
		public double opY;
		public double opZ;
		public double bpX;
		public double bpY;
		public double bpZ;
		public boolean fire_stone;
		public boolean air_stone;
		public boolean earth_stone;
		public boolean water_stone;
		public boolean ether_stone;
		public boolean ice_stone;
		public boolean lightning_stone;
		public boolean sound_stone;
		public boolean crystal_stone;
		public boolean lava_stone;
		public boolean rain_stone;
		public boolean tornado_stone;
		public boolean ocean_stone;
		public boolean plants_stone;
		public boolean animals_stone;
		public boolean metal_stone;
		public boolean light_stone;
		public boolean shadow_stone;
		public boolean vacuum_stone;
		public boolean energy_stone;
		public boolean sun_stone;
		public boolean moon_stone;
		public boolean space_stone;
		public boolean time_stone;
		public boolean blood_stone;
		public boolean technology_stone;
		public boolean teleportation_stone;
		public boolean explosion_stone;
		public boolean amber_stone;
		public boolean creation_stone;
		public boolean destruction_stone;
		public boolean mist_stone;
		public boolean sand_stone;
		public boolean speed_stone;
		public boolean poison_stone;
		public boolean magnet_stone;
		public boolean mushrooms_stone;
		public boolean mercury_stone;
		public boolean music_stone;
		public boolean plague_stone;
		public boolean blue_flame_stone;
		public boolean gravity_stone;
		public boolean smoke_stone;
		public boolean spirit_stone;
		public boolean form_stone;
		public boolean mind_stone;
		public boolean golden_dust_stone;
		public boolean darkness_stone;
		public boolean blue_portal_placed;
		public boolean orange_portal_placed;
		public double cpapi_ver;
		public boolean heat_stone;
		public boolean shockwave_stone;
		public static final Codec<MapVariables> CODEC = new Codec<MapVariables>() {
			@Override
			public <T> DataResult<Pair<MapVariables, T>> decode(DynamicOps<T> ops, T input) {
				return ops.getMap(input).flatMap(map -> {
					Builder builder = new Builder();
					Codec.DOUBLE.decode(ops, map.get("opX")).result().ifPresent(v -> builder.opX = v.getFirst());
					Codec.DOUBLE.decode(ops, map.get("opY")).result().ifPresent(v -> builder.opY = v.getFirst());
					Codec.DOUBLE.decode(ops, map.get("opZ")).result().ifPresent(v -> builder.opZ = v.getFirst());
					Codec.DOUBLE.decode(ops, map.get("bpX")).result().ifPresent(v -> builder.bpX = v.getFirst());
					Codec.DOUBLE.decode(ops, map.get("bpY")).result().ifPresent(v -> builder.bpY = v.getFirst());
					Codec.DOUBLE.decode(ops, map.get("bpZ")).result().ifPresent(v -> builder.bpZ = v.getFirst());
					Codec.BOOL.decode(ops, map.get("fire_stone")).result().ifPresent(v -> builder.fire_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("air_stone")).result().ifPresent(v -> builder.air_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("earth_stone")).result().ifPresent(v -> builder.earth_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("water_stone")).result().ifPresent(v -> builder.water_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("ether_stone")).result().ifPresent(v -> builder.ether_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("ice_stone")).result().ifPresent(v -> builder.ice_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("lightning_stone")).result().ifPresent(v -> builder.lightning_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("sound_stone")).result().ifPresent(v -> builder.sound_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("crystal_stone")).result().ifPresent(v -> builder.crystal_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("lava_stone")).result().ifPresent(v -> builder.lava_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("rain_stone")).result().ifPresent(v -> builder.rain_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("tornado_stone")).result().ifPresent(v -> builder.tornado_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("ocean_stone")).result().ifPresent(v -> builder.ocean_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("plants_stone")).result().ifPresent(v -> builder.plants_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("animals_stone")).result().ifPresent(v -> builder.animals_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("metal_stone")).result().ifPresent(v -> builder.metal_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("light_stone")).result().ifPresent(v -> builder.light_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("shadow_stone")).result().ifPresent(v -> builder.shadow_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("vacuum_stone")).result().ifPresent(v -> builder.vacuum_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("energy_stone")).result().ifPresent(v -> builder.energy_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("sun_stone")).result().ifPresent(v -> builder.sun_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("moon_stone")).result().ifPresent(v -> builder.moon_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("space_stone")).result().ifPresent(v -> builder.space_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("time_stone")).result().ifPresent(v -> builder.time_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("blood_stone")).result().ifPresent(v -> builder.blood_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("technology_stone")).result().ifPresent(v -> builder.technology_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("teleportation_stone")).result().ifPresent(v -> builder.teleportation_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("explosion_stone")).result().ifPresent(v -> builder.explosion_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("amber_stone")).result().ifPresent(v -> builder.amber_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("creation_stone")).result().ifPresent(v -> builder.creation_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("destruction_stone")).result().ifPresent(v -> builder.destruction_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("mist_stone")).result().ifPresent(v -> builder.mist_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("sand_stone")).result().ifPresent(v -> builder.sand_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("speed_stone")).result().ifPresent(v -> builder.speed_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("poison_stone")).result().ifPresent(v -> builder.poison_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("magnet_stone")).result().ifPresent(v -> builder.magnet_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("mushrooms_stone")).result().ifPresent(v -> builder.mushrooms_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("mercury_stone")).result().ifPresent(v -> builder.mercury_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("music_stone")).result().ifPresent(v -> builder.music_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("plague_stone")).result().ifPresent(v -> builder.plague_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("blue_flame_stone")).result().ifPresent(v -> builder.blue_flame_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("gravity_stone")).result().ifPresent(v -> builder.gravity_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("smoke_stone")).result().ifPresent(v -> builder.smoke_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("spirit_stone")).result().ifPresent(v -> builder.spirit_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("form_stone")).result().ifPresent(v -> builder.form_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("mind_stone")).result().ifPresent(v -> builder.mind_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("golden_dust_stone")).result().ifPresent(v -> builder.golden_dust_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("darkness_stone")).result().ifPresent(v -> builder.darkness_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("blue_portal_placed")).result().ifPresent(v -> builder.blue_portal_placed = v.getFirst());
					Codec.BOOL.decode(ops, map.get("orange_portal_placed")).result().ifPresent(v -> builder.orange_portal_placed = v.getFirst());
					Codec.DOUBLE.decode(ops, map.get("cpapi_ver")).result().ifPresent(v -> builder.cpapi_ver = v.getFirst());
					Codec.BOOL.decode(ops, map.get("heat_stone")).result().ifPresent(v -> builder.heat_stone = v.getFirst());
					Codec.BOOL.decode(ops, map.get("shockwave_stone")).result().ifPresent(v -> builder.shockwave_stone = v.getFirst());
					return DataResult.success(Pair.of(builder.build(), ops.empty()));
				});
			}

			@Override
			public <T> DataResult<T> encode(MapVariables input, DynamicOps<T> ops, T prefix) {
				RecordBuilder<T> recordBuilder = ops.mapBuilder();
				recordBuilder.add("opX", Codec.DOUBLE.encode(input.opX, ops, ops.empty()));
				recordBuilder.add("opY", Codec.DOUBLE.encode(input.opY, ops, ops.empty()));
				recordBuilder.add("opZ", Codec.DOUBLE.encode(input.opZ, ops, ops.empty()));
				recordBuilder.add("bpX", Codec.DOUBLE.encode(input.bpX, ops, ops.empty()));
				recordBuilder.add("bpY", Codec.DOUBLE.encode(input.bpY, ops, ops.empty()));
				recordBuilder.add("bpZ", Codec.DOUBLE.encode(input.bpZ, ops, ops.empty()));
				recordBuilder.add("fire_stone", Codec.BOOL.encode(input.fire_stone, ops, ops.empty()));
				recordBuilder.add("air_stone", Codec.BOOL.encode(input.air_stone, ops, ops.empty()));
				recordBuilder.add("earth_stone", Codec.BOOL.encode(input.earth_stone, ops, ops.empty()));
				recordBuilder.add("water_stone", Codec.BOOL.encode(input.water_stone, ops, ops.empty()));
				recordBuilder.add("ether_stone", Codec.BOOL.encode(input.ether_stone, ops, ops.empty()));
				recordBuilder.add("ice_stone", Codec.BOOL.encode(input.ice_stone, ops, ops.empty()));
				recordBuilder.add("lightning_stone", Codec.BOOL.encode(input.lightning_stone, ops, ops.empty()));
				recordBuilder.add("sound_stone", Codec.BOOL.encode(input.sound_stone, ops, ops.empty()));
				recordBuilder.add("crystal_stone", Codec.BOOL.encode(input.crystal_stone, ops, ops.empty()));
				recordBuilder.add("lava_stone", Codec.BOOL.encode(input.lava_stone, ops, ops.empty()));
				recordBuilder.add("rain_stone", Codec.BOOL.encode(input.rain_stone, ops, ops.empty()));
				recordBuilder.add("tornado_stone", Codec.BOOL.encode(input.tornado_stone, ops, ops.empty()));
				recordBuilder.add("ocean_stone", Codec.BOOL.encode(input.ocean_stone, ops, ops.empty()));
				recordBuilder.add("plants_stone", Codec.BOOL.encode(input.plants_stone, ops, ops.empty()));
				recordBuilder.add("animals_stone", Codec.BOOL.encode(input.animals_stone, ops, ops.empty()));
				recordBuilder.add("metal_stone", Codec.BOOL.encode(input.metal_stone, ops, ops.empty()));
				recordBuilder.add("light_stone", Codec.BOOL.encode(input.light_stone, ops, ops.empty()));
				recordBuilder.add("shadow_stone", Codec.BOOL.encode(input.shadow_stone, ops, ops.empty()));
				recordBuilder.add("vacuum_stone", Codec.BOOL.encode(input.vacuum_stone, ops, ops.empty()));
				recordBuilder.add("energy_stone", Codec.BOOL.encode(input.energy_stone, ops, ops.empty()));
				recordBuilder.add("sun_stone", Codec.BOOL.encode(input.sun_stone, ops, ops.empty()));
				recordBuilder.add("moon_stone", Codec.BOOL.encode(input.moon_stone, ops, ops.empty()));
				recordBuilder.add("space_stone", Codec.BOOL.encode(input.space_stone, ops, ops.empty()));
				recordBuilder.add("time_stone", Codec.BOOL.encode(input.time_stone, ops, ops.empty()));
				recordBuilder.add("blood_stone", Codec.BOOL.encode(input.blood_stone, ops, ops.empty()));
				recordBuilder.add("technology_stone", Codec.BOOL.encode(input.technology_stone, ops, ops.empty()));
				recordBuilder.add("teleportation_stone", Codec.BOOL.encode(input.teleportation_stone, ops, ops.empty()));
				recordBuilder.add("explosion_stone", Codec.BOOL.encode(input.explosion_stone, ops, ops.empty()));
				recordBuilder.add("amber_stone", Codec.BOOL.encode(input.amber_stone, ops, ops.empty()));
				recordBuilder.add("creation_stone", Codec.BOOL.encode(input.creation_stone, ops, ops.empty()));
				recordBuilder.add("destruction_stone", Codec.BOOL.encode(input.destruction_stone, ops, ops.empty()));
				recordBuilder.add("mist_stone", Codec.BOOL.encode(input.mist_stone, ops, ops.empty()));
				recordBuilder.add("sand_stone", Codec.BOOL.encode(input.sand_stone, ops, ops.empty()));
				recordBuilder.add("speed_stone", Codec.BOOL.encode(input.speed_stone, ops, ops.empty()));
				recordBuilder.add("poison_stone", Codec.BOOL.encode(input.poison_stone, ops, ops.empty()));
				recordBuilder.add("magnet_stone", Codec.BOOL.encode(input.magnet_stone, ops, ops.empty()));
				recordBuilder.add("mushrooms_stone", Codec.BOOL.encode(input.mushrooms_stone, ops, ops.empty()));
				recordBuilder.add("mercury_stone", Codec.BOOL.encode(input.mercury_stone, ops, ops.empty()));
				recordBuilder.add("music_stone", Codec.BOOL.encode(input.music_stone, ops, ops.empty()));
				recordBuilder.add("plague_stone", Codec.BOOL.encode(input.plague_stone, ops, ops.empty()));
				recordBuilder.add("blue_flame_stone", Codec.BOOL.encode(input.blue_flame_stone, ops, ops.empty()));
				recordBuilder.add("gravity_stone", Codec.BOOL.encode(input.gravity_stone, ops, ops.empty()));
				recordBuilder.add("smoke_stone", Codec.BOOL.encode(input.smoke_stone, ops, ops.empty()));
				recordBuilder.add("spirit_stone", Codec.BOOL.encode(input.spirit_stone, ops, ops.empty()));
				recordBuilder.add("form_stone", Codec.BOOL.encode(input.form_stone, ops, ops.empty()));
				recordBuilder.add("mind_stone", Codec.BOOL.encode(input.mind_stone, ops, ops.empty()));
				recordBuilder.add("golden_dust_stone", Codec.BOOL.encode(input.golden_dust_stone, ops, ops.empty()));
				recordBuilder.add("darkness_stone", Codec.BOOL.encode(input.darkness_stone, ops, ops.empty()));
				recordBuilder.add("blue_portal_placed", Codec.BOOL.encode(input.blue_portal_placed, ops, ops.empty()));
				recordBuilder.add("orange_portal_placed", Codec.BOOL.encode(input.orange_portal_placed, ops, ops.empty()));
				recordBuilder.add("cpapi_ver", Codec.DOUBLE.encode(input.cpapi_ver, ops, ops.empty()));
				recordBuilder.add("heat_stone", Codec.BOOL.encode(input.heat_stone, ops, ops.empty()));
				recordBuilder.add("shockwave_stone", Codec.BOOL.encode(input.shockwave_stone, ops, ops.empty()));
				return recordBuilder.build(prefix);
			}
		};

		private static class Builder {
			double opX = 0;
			double opY = 0;
			double opZ = 0;
			double bpX = 0;
			double bpY = 0;
			double bpZ = 0;
			boolean fire_stone = false;
			boolean air_stone = false;
			boolean earth_stone = false;
			boolean water_stone = false;
			boolean ether_stone = false;
			boolean ice_stone = false;
			boolean lightning_stone = false;
			boolean sound_stone = false;
			boolean crystal_stone = false;
			boolean lava_stone = false;
			boolean rain_stone = false;
			boolean tornado_stone = false;
			boolean ocean_stone = false;
			boolean plants_stone = false;
			boolean animals_stone = false;
			boolean metal_stone = false;
			boolean light_stone = false;
			boolean shadow_stone = false;
			boolean vacuum_stone = false;
			boolean energy_stone = false;
			boolean sun_stone = false;
			boolean moon_stone = false;
			boolean space_stone = false;
			boolean time_stone = false;
			boolean blood_stone = false;
			boolean technology_stone = false;
			boolean teleportation_stone = false;
			boolean explosion_stone = false;
			boolean amber_stone = false;
			boolean creation_stone = false;
			boolean destruction_stone = false;
			boolean mist_stone = false;
			boolean sand_stone = false;
			boolean speed_stone = false;
			boolean poison_stone = false;
			boolean magnet_stone = false;
			boolean mushrooms_stone = false;
			boolean mercury_stone = false;
			boolean music_stone = false;
			boolean plague_stone = false;
			boolean blue_flame_stone = false;
			boolean gravity_stone = false;
			boolean smoke_stone = false;
			boolean spirit_stone = false;
			boolean form_stone = false;
			boolean mind_stone = false;
			boolean golden_dust_stone = false;
			boolean darkness_stone = false;
			boolean blue_portal_placed = false;
			boolean orange_portal_placed = false;
			double cpapi_ver = 21.0;
			boolean heat_stone = false;
			boolean shockwave_stone = false;

			MapVariables build() {
				return new MapVariables(opX, opY, opZ, bpX, bpY, bpZ, fire_stone, air_stone, earth_stone, water_stone, ether_stone, ice_stone, lightning_stone, sound_stone, crystal_stone, lava_stone, rain_stone, tornado_stone, ocean_stone,
						plants_stone, animals_stone, metal_stone, light_stone, shadow_stone, vacuum_stone, energy_stone, sun_stone, moon_stone, space_stone, time_stone, blood_stone, technology_stone, teleportation_stone, explosion_stone, amber_stone,
						creation_stone, destruction_stone, mist_stone, sand_stone, speed_stone, poison_stone, magnet_stone, mushrooms_stone, mercury_stone, music_stone, plague_stone, blue_flame_stone, gravity_stone, smoke_stone, spirit_stone,
						form_stone, mind_stone, golden_dust_stone, darkness_stone, blue_portal_placed, orange_portal_placed, cpapi_ver, heat_stone, shockwave_stone);
			}
		}

		public static final SavedDataType<MapVariables> TYPE = new SavedDataType<>(DATA_NAME,
				ctx -> new MapVariables(0, 0, 0, 0, 0, 0, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 0, false, false),
				ctx -> CODEC, DataFixTypes.LEVEL);

		public MapVariables(double opX, double opY, double opZ, double bpX, double bpY, double bpZ, boolean fire_stone, boolean air_stone, boolean earth_stone, boolean water_stone, boolean ether_stone, boolean ice_stone, boolean lightning_stone,
				boolean sound_stone, boolean crystal_stone, boolean lava_stone, boolean rain_stone, boolean tornado_stone, boolean ocean_stone, boolean plants_stone, boolean animals_stone, boolean metal_stone, boolean light_stone,
				boolean shadow_stone, boolean vacuum_stone, boolean energy_stone, boolean sun_stone, boolean moon_stone, boolean space_stone, boolean time_stone, boolean blood_stone, boolean technology_stone, boolean teleportation_stone,
				boolean explosion_stone, boolean amber_stone, boolean creation_stone, boolean destruction_stone, boolean mist_stone, boolean sand_stone, boolean speed_stone, boolean poison_stone, boolean magnet_stone, boolean mushrooms_stone,
				boolean mercury_stone, boolean music_stone, boolean plague_stone, boolean blue_flame_stone, boolean gravity_stone, boolean smoke_stone, boolean spirit_stone, boolean form_stone, boolean mind_stone, boolean golden_dust_stone,
				boolean darkness_stone, boolean blue_portal_placed, boolean orange_portal_placed, double cpapi_ver, boolean heat_stone, boolean shockwave_stone) {
			this.opX = opX;
			this.opY = opY;
			this.opZ = opZ;
			this.bpX = bpX;
			this.bpY = bpY;
			this.bpZ = bpZ;
			this.fire_stone = fire_stone;
			this.air_stone = air_stone;
			this.earth_stone = earth_stone;
			this.water_stone = water_stone;
			this.ether_stone = ether_stone;
			this.ice_stone = ice_stone;
			this.lightning_stone = lightning_stone;
			this.sound_stone = sound_stone;
			this.crystal_stone = crystal_stone;
			this.lava_stone = lava_stone;
			this.rain_stone = rain_stone;
			this.tornado_stone = tornado_stone;
			this.ocean_stone = ocean_stone;
			this.plants_stone = plants_stone;
			this.animals_stone = animals_stone;
			this.metal_stone = metal_stone;
			this.light_stone = light_stone;
			this.shadow_stone = shadow_stone;
			this.vacuum_stone = vacuum_stone;
			this.energy_stone = energy_stone;
			this.sun_stone = sun_stone;
			this.moon_stone = moon_stone;
			this.space_stone = space_stone;
			this.time_stone = time_stone;
			this.blood_stone = blood_stone;
			this.technology_stone = technology_stone;
			this.teleportation_stone = teleportation_stone;
			this.explosion_stone = explosion_stone;
			this.amber_stone = amber_stone;
			this.creation_stone = creation_stone;
			this.destruction_stone = destruction_stone;
			this.mist_stone = mist_stone;
			this.sand_stone = sand_stone;
			this.speed_stone = speed_stone;
			this.poison_stone = poison_stone;
			this.magnet_stone = magnet_stone;
			this.mushrooms_stone = mushrooms_stone;
			this.mercury_stone = mercury_stone;
			this.music_stone = music_stone;
			this.plague_stone = plague_stone;
			this.blue_flame_stone = blue_flame_stone;
			this.gravity_stone = gravity_stone;
			this.smoke_stone = smoke_stone;
			this.spirit_stone = spirit_stone;
			this.form_stone = form_stone;
			this.mind_stone = mind_stone;
			this.golden_dust_stone = golden_dust_stone;
			this.darkness_stone = darkness_stone;
			this.blue_portal_placed = blue_portal_placed;
			this.orange_portal_placed = orange_portal_placed;
			this.cpapi_ver = cpapi_ver;
			this.heat_stone = heat_stone;
			this.shockwave_stone = shockwave_stone;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide()) {
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, this));
			}
		}

		static MapVariables clientSide = new MapVariables(0, 0, 0, 0, 0, 0, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
				false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 21.0, false, false);

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(TYPE);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((buffer, message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null) {
				CompoundTag tag = switch (message.dataType) {
					case 0 -> (CompoundTag) MapVariables.CODEC.encodeStart(NbtOps.INSTANCE, (MapVariables) message.data).getOrThrow();
					case 1 -> (CompoundTag) WorldVariables.CODEC.encodeStart(NbtOps.INSTANCE, (WorldVariables) message.data).getOrThrow();
					default -> throw new IllegalArgumentException("Unknown data type");
				};
				buffer.writeNbt(tag);
			}
		}, buffer -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = switch (dataType) {
				case 0 -> MapVariables.CODEC.parse(NbtOps.INSTANCE, nbt).getOrThrow();
				case 1 -> WorldVariables.CODEC.parse(NbtOps.INSTANCE, nbt).getOrThrow();
				default -> null;
			};
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0) {
						MapVariables.clientSide = (MapVariables) message.data;
					} else {
						WorldVariables.clientSide = (WorldVariables) message.data;
					}
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public String ability = "0";
		public String element_name_first = "0";
		public String element_name_second = "0";
		public String element_name_third = "0";
		public double teleporting_effect = 0;
		public String fake_element_name_first = "0";
		public String fake_element_name_second = "0";
		public String fake_element_name_third = "0";
		public double abilities_timer = 0;
		public double fake_element_name_first_timer = 0;
		public double fake_element_name_second_timer = 0;
		public double fake_element_name_third_timer = 0;
		public double power = 0.0;
		public double powerTimer = 0.0;
		public double mergers = 0.0;
		public double power_recovery_multiplier = 1.0;
		public double max_power = 100.0;
		public double recharge_timer = 300.0;
		public double master_effect_duration = 600.0;
		public boolean active_power = false;
		public boolean selected = false;
		public boolean active_battery = false;
		public boolean ability_block = false;
		public boolean use_ability_key_var = false;
		public boolean detransf_key_var = false;
		public boolean wheel_open_key_var = false;
		public boolean second_wheel_open_var = false;
		public boolean third_wheel_open_var = false;
		public boolean first_fake_wheel_open_var = false;
		public boolean second_fake_wheel_open_var = false;
		public boolean third_fake_wheel_open_var = false;
		public boolean ability_using = false;
		public boolean power_recorded = false;
		public boolean debug = false;
		public boolean detransform_anim_trigger = false;
		public ItemStack helmet = ItemStack.EMPTY;
		public ItemStack chestplate = ItemStack.EMPTY;
		public ItemStack leggings = ItemStack.EMPTY;
		public ItemStack boots = ItemStack.EMPTY;
		public boolean unlock_keepers_box = false;
		public boolean transfered_power = false;
		public boolean master_effect_end = false;
		public boolean master_effect_start = false;
		public double level = 1.0;
		public double level_exp = 0.0;
		public double base_damage_by_lvl = 6.0;
		public double max_level_exp = 100.0;
		public double resistance_char = 0.0;
		public double speed_char = 1.0;
		public double haste_char = -1.0;
		public double jump_char = 1.0;
		public boolean level_up_status = false;
		public String rank = "D";
		public String mind_player_owner = "\"\"";
		public boolean mind_used = false;
		public ItemStack blue_rune_slot = ItemStack.EMPTY;
		public ItemStack red_rune_slot = ItemStack.EMPTY;
		public ItemStack green_rune_slot = ItemStack.EMPTY;
		public double rune_ovelay_display = 0;

		private void putItemStack(CompoundTag nbt, String key, ItemStack stack, HolderLookup.Provider lookupProvider) {
			if (!stack.isEmpty()) {
				nbt.put(key, stack.save(lookupProvider));
			} else {
				nbt.putBoolean(key + "_empty", true);
			}
		}

		private ItemStack getItemStack(CompoundTag nbt, String key, HolderLookup.Provider lookupProvider) {
			if (nbt.contains(key + "_empty")) {
				return ItemStack.EMPTY;
			}
			return nbt.contains(key) ? ItemStack.parse(lookupProvider, nbt.getCompoundOrEmpty(key)).orElse(ItemStack.EMPTY) : ItemStack.EMPTY;
		}

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("ability", ability);
			nbt.putString("element_name_first", element_name_first);
			nbt.putString("element_name_second", element_name_second);
			nbt.putString("element_name_third", element_name_third);
			nbt.putDouble("teleporting_effect", teleporting_effect);
			nbt.putString("fake_element_name_first", fake_element_name_first);
			nbt.putString("fake_element_name_second", fake_element_name_second);
			nbt.putString("fake_element_name_third", fake_element_name_third);
			nbt.putDouble("abilities_timer", abilities_timer);
			nbt.putDouble("fake_element_name_first_timer", fake_element_name_first_timer);
			nbt.putDouble("fake_element_name_second_timer", fake_element_name_second_timer);
			nbt.putDouble("fake_element_name_third_timer", fake_element_name_third_timer);
			nbt.putDouble("power", power);
			nbt.putDouble("powerTimer", powerTimer);
			nbt.putDouble("mergers", mergers);
			nbt.putDouble("power_recovery_multiplier", power_recovery_multiplier);
			nbt.putDouble("max_power", max_power);
			nbt.putDouble("recharge_timer", recharge_timer);
			nbt.putDouble("master_effect_duration", master_effect_duration);
			nbt.putBoolean("active_power", active_power);
			nbt.putBoolean("selected", selected);
			nbt.putBoolean("active_battery", active_battery);
			nbt.putBoolean("ability_block", ability_block);
			nbt.putBoolean("use_ability_key_var", use_ability_key_var);
			nbt.putBoolean("detransf_key_var", detransf_key_var);
			nbt.putBoolean("wheel_open_key_var", wheel_open_key_var);
			nbt.putBoolean("second_wheel_open_var", second_wheel_open_var);
			nbt.putBoolean("third_wheel_open_var", third_wheel_open_var);
			nbt.putBoolean("first_fake_wheel_open_var", first_fake_wheel_open_var);
			nbt.putBoolean("second_fake_wheel_open_var", second_fake_wheel_open_var);
			nbt.putBoolean("third_fake_wheel_open_var", third_fake_wheel_open_var);
			nbt.putBoolean("ability_using", ability_using);
			nbt.putBoolean("power_recorded", power_recorded);
			nbt.putBoolean("debug", debug);
			nbt.putBoolean("detransform_anim_trigger", detransform_anim_trigger);
			putItemStack(nbt, "helmet", helmet, lookupProvider);
			putItemStack(nbt, "chestplate", chestplate, lookupProvider);
			putItemStack(nbt, "leggings", leggings, lookupProvider);
			putItemStack(nbt, "boots", boots, lookupProvider);
			nbt.putBoolean("unlock_keepers_box", unlock_keepers_box);
			nbt.putBoolean("transfered_power", transfered_power);
			nbt.putBoolean("master_effect_end", master_effect_end);
			nbt.putBoolean("master_effect_start", master_effect_start);
			nbt.putDouble("level", level);
			nbt.putDouble("level_exp", level_exp);
			nbt.putDouble("base_damage_by_lvl", base_damage_by_lvl);
			nbt.putDouble("max_level_exp", max_level_exp);
			nbt.putDouble("resistance_char", resistance_char);
			nbt.putDouble("speed_char", speed_char);
			nbt.putDouble("haste_char", haste_char);
			nbt.putDouble("jump_char", jump_char);
			nbt.putBoolean("level_up_status", level_up_status);
			nbt.putString("rank", rank);
			nbt.putString("mind_player_owner", mind_player_owner);
			nbt.putBoolean("mind_used", mind_used);
			putItemStack(nbt, "blue_rune_slot", blue_rune_slot, lookupProvider);
			putItemStack(nbt, "red_rune_slot", red_rune_slot, lookupProvider);
			putItemStack(nbt, "green_rune_slot", green_rune_slot, lookupProvider);
			nbt.putDouble("rune_ovelay_display", rune_ovelay_display);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			ability = nbt.getStringOr("ability", "0");
			element_name_first = nbt.getStringOr("element_name_first", "0");
			element_name_second = nbt.getStringOr("element_name_second", "0");
			element_name_third = nbt.getStringOr("element_name_third", "0");
			teleporting_effect = nbt.getDoubleOr("teleporting_effect", 0);
			fake_element_name_first = nbt.getStringOr("fake_element_name_first", "0");
			fake_element_name_second = nbt.getStringOr("fake_element_name_second", "0");
			fake_element_name_third = nbt.getStringOr("fake_element_name_third", "0");
			abilities_timer = nbt.getDoubleOr("abilities_timer", 0);
			fake_element_name_first_timer = nbt.getDoubleOr("fake_element_name_first_timer", 0);
			fake_element_name_second_timer = nbt.getDoubleOr("fake_element_name_second_timer", 0);
			fake_element_name_third_timer = nbt.getDoubleOr("fake_element_name_third_timer", 0);
			power = nbt.getDoubleOr("power", 0.0);
			powerTimer = nbt.getDoubleOr("powerTimer", 0.0);
			mergers = nbt.getDoubleOr("mergers", 0.0);
			power_recovery_multiplier = nbt.getDoubleOr("power_recovery_multiplier", 1.0);
			max_power = nbt.getDoubleOr("max_power", 100.0);
			recharge_timer = nbt.getDoubleOr("recharge_timer", 300.0);
			master_effect_duration = nbt.getDoubleOr("master_effect_duration", 600.0);
			active_power = nbt.getBooleanOr("active_power", false);
			selected = nbt.getBooleanOr("selected", false);
			active_battery = nbt.getBooleanOr("active_battery", false);
			ability_block = nbt.getBooleanOr("ability_block", false);
			use_ability_key_var = nbt.getBooleanOr("use_ability_key_var", false);
			detransf_key_var = nbt.getBooleanOr("detransf_key_var", false);
			wheel_open_key_var = nbt.getBooleanOr("wheel_open_key_var", false);
			second_wheel_open_var = nbt.getBooleanOr("second_wheel_open_var", false);
			third_wheel_open_var = nbt.getBooleanOr("third_wheel_open_var", false);
			first_fake_wheel_open_var = nbt.getBooleanOr("first_fake_wheel_open_var", false);
			second_fake_wheel_open_var = nbt.getBooleanOr("second_fake_wheel_open_var", false);
			third_fake_wheel_open_var = nbt.getBooleanOr("third_fake_wheel_open_var", false);
			ability_using = nbt.getBooleanOr("ability_using", false);
			power_recorded = nbt.getBooleanOr("power_recorded", false);
			debug = nbt.getBooleanOr("debug", false);
			detransform_anim_trigger = nbt.getBooleanOr("detransform_anim_trigger", false);
			helmet = getItemStack(nbt, "helmet", lookupProvider);
			chestplate = getItemStack(nbt, "chestplate", lookupProvider);
			leggings = getItemStack(nbt, "leggings", lookupProvider);
			boots = getItemStack(nbt, "boots", lookupProvider);
			unlock_keepers_box = nbt.getBooleanOr("unlock_keepers_box", false);
			transfered_power = nbt.getBooleanOr("transfered_power", false);
			master_effect_end = nbt.getBooleanOr("master_effect_end", false);
			master_effect_start = nbt.getBooleanOr("master_effect_start", false);
			level = nbt.getDoubleOr("level", 1.0);
			level_exp = nbt.getDoubleOr("level_exp", 0.0);
			base_damage_by_lvl = nbt.getDoubleOr("base_damage_by_lvl", 6.0);
			max_level_exp = nbt.getDoubleOr("max_level_exp", 100.0);
			resistance_char = nbt.getDoubleOr("resistance_char", 0.0);
			speed_char = nbt.getDoubleOr("speed_char", 1.0);
			haste_char = nbt.getDoubleOr("haste_char", -1.0);
			jump_char = nbt.getDoubleOr("jump_char", 1.0);
			level_up_status = nbt.getBooleanOr("level_up_status", false);
			rank = nbt.getStringOr("rank", "D");
			mind_player_owner = nbt.getStringOr("mind_player_owner", "\"\"");
			mind_used = nbt.getBooleanOr("mind_used", false);
			blue_rune_slot = getItemStack(nbt, "blue_rune_slot", lookupProvider);
			red_rune_slot = getItemStack(nbt, "red_rune_slot", lookupProvider);
			green_rune_slot = getItemStack(nbt, "green_rune_slot", lookupProvider);
			rune_ovelay_display = nbt.getDoubleOr("rune_ovelay_display", 0);
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
