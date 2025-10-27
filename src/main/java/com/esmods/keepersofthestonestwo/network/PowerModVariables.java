package com.esmods.keepersofthestonestwo.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.ValueIOSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.saveddata.SavedDataType;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.ProblemReporter;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import java.util.function.Supplier;

import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber
public class PowerModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, PowerMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		PowerMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@SubscribeEvent
	public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerTickUpdateSyncPlayerVariables(PlayerTickEvent.Post event) {
		if (event.getEntity() instanceof ServerPlayer player && player.getData(PLAYER_VARIABLES)._syncDirty) {
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
			player.getData(PLAYER_VARIABLES)._syncDirty = false;
		}
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

	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		if (event.getLevel() instanceof ServerLevel level) {
			WorldVariables worldVariables = WorldVariables.get(level);
			if (worldVariables._syncDirty) {
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, worldVariables));
				worldVariables._syncDirty = false;
			}
			MapVariables mapVariables = MapVariables.get(level);
			if (mapVariables._syncDirty) {
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, mapVariables));
				mapVariables._syncDirty = false;
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final SavedDataType<WorldVariables> TYPE = new SavedDataType<>("power_worldvars", ctx -> new WorldVariables(), ctx -> CompoundTag.CODEC.xmap(tag -> {
			WorldVariables instance = new WorldVariables();
			instance.read(tag, ctx.levelOrThrow().registryAccess());
			return instance;
		}, instance -> instance.save(new CompoundTag(), ctx.levelOrThrow().registryAccess())));
		boolean _syncDirty = false;
		public double entity_rotation = 0;

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			entity_rotation = nbt.getDoubleOr("entity_rotation", 0);
		}

		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("entity_rotation", entity_rotation);
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			this._syncDirty = true;
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(WorldVariables.TYPE);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final SavedDataType<MapVariables> TYPE = new SavedDataType<>("power_mapvars", ctx -> new MapVariables(), ctx -> CompoundTag.CODEC.xmap(tag -> {
			MapVariables instance = new MapVariables();
			instance.read(tag, ctx.levelOrThrow().registryAccess());
			return instance;
		}, instance -> instance.save(new CompoundTag(), ctx.levelOrThrow().registryAccess())));
		boolean _syncDirty = false;
		public double opX = 0;
		public double opY = 0;
		public double opZ = 0;
		public double bpX = 0;
		public double bpY = 0;
		public double bpZ = 0;
		public boolean fire_stone = false;
		public boolean air_stone = false;
		public boolean earth_stone = false;
		public boolean water_stone = false;
		public boolean ether_stone = false;
		public boolean ice_stone = false;
		public boolean lightning_stone = false;
		public boolean sound_stone = false;
		public boolean crystal_stone = false;
		public boolean lava_stone = false;
		public boolean rain_stone = false;
		public boolean tornado_stone = false;
		public boolean ocean_stone = false;
		public boolean plants_stone = false;
		public boolean animals_stone = false;
		public boolean metal_stone = false;
		public boolean light_stone = false;
		public boolean shadow_stone = false;
		public boolean vacuum_stone = false;
		public boolean energy_stone = false;
		public boolean sun_stone = false;
		public boolean moon_stone = false;
		public boolean space_stone = false;
		public boolean time_stone = false;
		public boolean blood_stone = false;
		public boolean technology_stone = false;
		public boolean teleportation_stone = false;
		public boolean explosion_stone = false;
		public boolean amber_stone = false;
		public boolean creation_stone = false;
		public boolean destruction_stone = false;
		public boolean mist_stone = false;
		public boolean sand_stone = false;
		public boolean speed_stone = false;
		public boolean poison_stone = false;
		public boolean magnet_stone = false;
		public boolean mushrooms_stone = false;
		public boolean mercury_stone = false;
		public boolean music_stone = false;
		public boolean plague_stone = false;
		public boolean blue_flame_stone = false;
		public boolean gravity_stone = false;
		public boolean smoke_stone = false;
		public boolean spirit_stone = false;
		public boolean form_stone = false;
		public boolean mind_stone = false;
		public boolean golden_dust_stone = false;
		public boolean darkness_stone = false;
		public boolean blue_portal_placed = false;
		public boolean orange_portal_placed = false;
		public double cpapi_ver = 21.0;
		public boolean heat_stone = false;
		public boolean shockwave_stone = false;

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			opX = nbt.getDoubleOr("opX", 0);
			opY = nbt.getDoubleOr("opY", 0);
			opZ = nbt.getDoubleOr("opZ", 0);
			bpX = nbt.getDoubleOr("bpX", 0);
			bpY = nbt.getDoubleOr("bpY", 0);
			bpZ = nbt.getDoubleOr("bpZ", 0);
			fire_stone = nbt.getBooleanOr("fire_stone", false);
			air_stone = nbt.getBooleanOr("air_stone", false);
			earth_stone = nbt.getBooleanOr("earth_stone", false);
			water_stone = nbt.getBooleanOr("water_stone", false);
			ether_stone = nbt.getBooleanOr("ether_stone", false);
			ice_stone = nbt.getBooleanOr("ice_stone", false);
			lightning_stone = nbt.getBooleanOr("lightning_stone", false);
			sound_stone = nbt.getBooleanOr("sound_stone", false);
			crystal_stone = nbt.getBooleanOr("crystal_stone", false);
			lava_stone = nbt.getBooleanOr("lava_stone", false);
			rain_stone = nbt.getBooleanOr("rain_stone", false);
			tornado_stone = nbt.getBooleanOr("tornado_stone", false);
			ocean_stone = nbt.getBooleanOr("ocean_stone", false);
			plants_stone = nbt.getBooleanOr("plants_stone", false);
			animals_stone = nbt.getBooleanOr("animals_stone", false);
			metal_stone = nbt.getBooleanOr("metal_stone", false);
			light_stone = nbt.getBooleanOr("light_stone", false);
			shadow_stone = nbt.getBooleanOr("shadow_stone", false);
			vacuum_stone = nbt.getBooleanOr("vacuum_stone", false);
			energy_stone = nbt.getBooleanOr("energy_stone", false);
			sun_stone = nbt.getBooleanOr("sun_stone", false);
			moon_stone = nbt.getBooleanOr("moon_stone", false);
			space_stone = nbt.getBooleanOr("space_stone", false);
			time_stone = nbt.getBooleanOr("time_stone", false);
			blood_stone = nbt.getBooleanOr("blood_stone", false);
			technology_stone = nbt.getBooleanOr("technology_stone", false);
			teleportation_stone = nbt.getBooleanOr("teleportation_stone", false);
			explosion_stone = nbt.getBooleanOr("explosion_stone", false);
			amber_stone = nbt.getBooleanOr("amber_stone", false);
			creation_stone = nbt.getBooleanOr("creation_stone", false);
			destruction_stone = nbt.getBooleanOr("destruction_stone", false);
			mist_stone = nbt.getBooleanOr("mist_stone", false);
			sand_stone = nbt.getBooleanOr("sand_stone", false);
			speed_stone = nbt.getBooleanOr("speed_stone", false);
			poison_stone = nbt.getBooleanOr("poison_stone", false);
			magnet_stone = nbt.getBooleanOr("magnet_stone", false);
			mushrooms_stone = nbt.getBooleanOr("mushrooms_stone", false);
			mercury_stone = nbt.getBooleanOr("mercury_stone", false);
			music_stone = nbt.getBooleanOr("music_stone", false);
			plague_stone = nbt.getBooleanOr("plague_stone", false);
			blue_flame_stone = nbt.getBooleanOr("blue_flame_stone", false);
			gravity_stone = nbt.getBooleanOr("gravity_stone", false);
			smoke_stone = nbt.getBooleanOr("smoke_stone", false);
			spirit_stone = nbt.getBooleanOr("spirit_stone", false);
			form_stone = nbt.getBooleanOr("form_stone", false);
			mind_stone = nbt.getBooleanOr("mind_stone", false);
			golden_dust_stone = nbt.getBooleanOr("golden_dust_stone", false);
			darkness_stone = nbt.getBooleanOr("darkness_stone", false);
			blue_portal_placed = nbt.getBooleanOr("blue_portal_placed", false);
			orange_portal_placed = nbt.getBooleanOr("orange_portal_placed", false);
			cpapi_ver = nbt.getDoubleOr("cpapi_ver", 0);
			heat_stone = nbt.getBooleanOr("heat_stone", false);
			shockwave_stone = nbt.getBooleanOr("shockwave_stone", false);
		}

		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("opX", opX);
			nbt.putDouble("opY", opY);
			nbt.putDouble("opZ", opZ);
			nbt.putDouble("bpX", bpX);
			nbt.putDouble("bpY", bpY);
			nbt.putDouble("bpZ", bpZ);
			nbt.putBoolean("fire_stone", fire_stone);
			nbt.putBoolean("air_stone", air_stone);
			nbt.putBoolean("earth_stone", earth_stone);
			nbt.putBoolean("water_stone", water_stone);
			nbt.putBoolean("ether_stone", ether_stone);
			nbt.putBoolean("ice_stone", ice_stone);
			nbt.putBoolean("lightning_stone", lightning_stone);
			nbt.putBoolean("sound_stone", sound_stone);
			nbt.putBoolean("crystal_stone", crystal_stone);
			nbt.putBoolean("lava_stone", lava_stone);
			nbt.putBoolean("rain_stone", rain_stone);
			nbt.putBoolean("tornado_stone", tornado_stone);
			nbt.putBoolean("ocean_stone", ocean_stone);
			nbt.putBoolean("plants_stone", plants_stone);
			nbt.putBoolean("animals_stone", animals_stone);
			nbt.putBoolean("metal_stone", metal_stone);
			nbt.putBoolean("light_stone", light_stone);
			nbt.putBoolean("shadow_stone", shadow_stone);
			nbt.putBoolean("vacuum_stone", vacuum_stone);
			nbt.putBoolean("energy_stone", energy_stone);
			nbt.putBoolean("sun_stone", sun_stone);
			nbt.putBoolean("moon_stone", moon_stone);
			nbt.putBoolean("space_stone", space_stone);
			nbt.putBoolean("time_stone", time_stone);
			nbt.putBoolean("blood_stone", blood_stone);
			nbt.putBoolean("technology_stone", technology_stone);
			nbt.putBoolean("teleportation_stone", teleportation_stone);
			nbt.putBoolean("explosion_stone", explosion_stone);
			nbt.putBoolean("amber_stone", amber_stone);
			nbt.putBoolean("creation_stone", creation_stone);
			nbt.putBoolean("destruction_stone", destruction_stone);
			nbt.putBoolean("mist_stone", mist_stone);
			nbt.putBoolean("sand_stone", sand_stone);
			nbt.putBoolean("speed_stone", speed_stone);
			nbt.putBoolean("poison_stone", poison_stone);
			nbt.putBoolean("magnet_stone", magnet_stone);
			nbt.putBoolean("mushrooms_stone", mushrooms_stone);
			nbt.putBoolean("mercury_stone", mercury_stone);
			nbt.putBoolean("music_stone", music_stone);
			nbt.putBoolean("plague_stone", plague_stone);
			nbt.putBoolean("blue_flame_stone", blue_flame_stone);
			nbt.putBoolean("gravity_stone", gravity_stone);
			nbt.putBoolean("smoke_stone", smoke_stone);
			nbt.putBoolean("spirit_stone", spirit_stone);
			nbt.putBoolean("form_stone", form_stone);
			nbt.putBoolean("mind_stone", mind_stone);
			nbt.putBoolean("golden_dust_stone", golden_dust_stone);
			nbt.putBoolean("darkness_stone", darkness_stone);
			nbt.putBoolean("blue_portal_placed", blue_portal_placed);
			nbt.putBoolean("orange_portal_placed", orange_portal_placed);
			nbt.putDouble("cpapi_ver", cpapi_ver);
			nbt.putBoolean("heat_stone", heat_stone);
			nbt.putBoolean("shockwave_stone", shockwave_stone);
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			this._syncDirty = true;
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAccessor) {
				return serverLevelAccessor.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(MapVariables.TYPE);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data instanceof MapVariables mapVariables)
				buffer.writeNbt(mapVariables.save(new CompoundTag(), buffer.registryAccess()));
			else if (message.data instanceof WorldVariables worldVariables)
				buffer.writeNbt(worldVariables.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(((MapVariables) message.data).save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(((WorldVariables) message.data).save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements ValueIOSerializable {
		boolean _syncDirty = false;
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

		@Override
		public void serialize(ValueOutput output) {
			output.putString("ability", ability);
			output.putString("element_name_first", element_name_first);
			output.putString("element_name_second", element_name_second);
			output.putString("element_name_third", element_name_third);
			output.putDouble("teleporting_effect", teleporting_effect);
			output.putString("fake_element_name_first", fake_element_name_first);
			output.putString("fake_element_name_second", fake_element_name_second);
			output.putString("fake_element_name_third", fake_element_name_third);
			output.putDouble("abilities_timer", abilities_timer);
			output.putDouble("fake_element_name_first_timer", fake_element_name_first_timer);
			output.putDouble("fake_element_name_second_timer", fake_element_name_second_timer);
			output.putDouble("fake_element_name_third_timer", fake_element_name_third_timer);
			output.putDouble("power", power);
			output.putDouble("powerTimer", powerTimer);
			output.putDouble("mergers", mergers);
			output.putDouble("power_recovery_multiplier", power_recovery_multiplier);
			output.putDouble("max_power", max_power);
			output.putDouble("recharge_timer", recharge_timer);
			output.putDouble("master_effect_duration", master_effect_duration);
			output.putBoolean("active_power", active_power);
			output.putBoolean("selected", selected);
			output.putBoolean("active_battery", active_battery);
			output.putBoolean("ability_block", ability_block);
			output.putBoolean("use_ability_key_var", use_ability_key_var);
			output.putBoolean("detransf_key_var", detransf_key_var);
			output.putBoolean("wheel_open_key_var", wheel_open_key_var);
			output.putBoolean("second_wheel_open_var", second_wheel_open_var);
			output.putBoolean("third_wheel_open_var", third_wheel_open_var);
			output.putBoolean("first_fake_wheel_open_var", first_fake_wheel_open_var);
			output.putBoolean("second_fake_wheel_open_var", second_fake_wheel_open_var);
			output.putBoolean("third_fake_wheel_open_var", third_fake_wheel_open_var);
			output.putBoolean("ability_using", ability_using);
			output.putBoolean("power_recorded", power_recorded);
			output.putBoolean("debug", debug);
			output.putBoolean("detransform_anim_trigger", detransform_anim_trigger);
			output.store("helmet", ItemStack.OPTIONAL_CODEC, helmet);
			output.store("chestplate", ItemStack.OPTIONAL_CODEC, chestplate);
			output.store("leggings", ItemStack.OPTIONAL_CODEC, leggings);
			output.store("boots", ItemStack.OPTIONAL_CODEC, boots);
			output.putBoolean("unlock_keepers_box", unlock_keepers_box);
			output.putBoolean("transfered_power", transfered_power);
			output.putBoolean("master_effect_end", master_effect_end);
			output.putBoolean("master_effect_start", master_effect_start);
			output.putDouble("level", level);
			output.putDouble("level_exp", level_exp);
			output.putDouble("base_damage_by_lvl", base_damage_by_lvl);
			output.putDouble("max_level_exp", max_level_exp);
			output.putDouble("resistance_char", resistance_char);
			output.putDouble("speed_char", speed_char);
			output.putDouble("haste_char", haste_char);
			output.putDouble("jump_char", jump_char);
			output.putBoolean("level_up_status", level_up_status);
			output.putString("rank", rank);
			output.putString("mind_player_owner", mind_player_owner);
			output.putBoolean("mind_used", mind_used);
			output.store("blue_rune_slot", ItemStack.OPTIONAL_CODEC, blue_rune_slot);
			output.store("red_rune_slot", ItemStack.OPTIONAL_CODEC, red_rune_slot);
			output.store("green_rune_slot", ItemStack.OPTIONAL_CODEC, green_rune_slot);
			output.putDouble("rune_ovelay_display", rune_ovelay_display);
		}

		@Override
		public void deserialize(ValueInput input) {
			ability = input.getStringOr("ability", "");
			element_name_first = input.getStringOr("element_name_first", "");
			element_name_second = input.getStringOr("element_name_second", "");
			element_name_third = input.getStringOr("element_name_third", "");
			teleporting_effect = input.getDoubleOr("teleporting_effect", 0);
			fake_element_name_first = input.getStringOr("fake_element_name_first", "");
			fake_element_name_second = input.getStringOr("fake_element_name_second", "");
			fake_element_name_third = input.getStringOr("fake_element_name_third", "");
			abilities_timer = input.getDoubleOr("abilities_timer", 0);
			fake_element_name_first_timer = input.getDoubleOr("fake_element_name_first_timer", 0);
			fake_element_name_second_timer = input.getDoubleOr("fake_element_name_second_timer", 0);
			fake_element_name_third_timer = input.getDoubleOr("fake_element_name_third_timer", 0);
			power = input.getDoubleOr("power", 0);
			powerTimer = input.getDoubleOr("powerTimer", 0);
			mergers = input.getDoubleOr("mergers", 0);
			power_recovery_multiplier = input.getDoubleOr("power_recovery_multiplier", 0);
			max_power = input.getDoubleOr("max_power", 0);
			recharge_timer = input.getDoubleOr("recharge_timer", 0);
			master_effect_duration = input.getDoubleOr("master_effect_duration", 0);
			active_power = input.getBooleanOr("active_power", false);
			selected = input.getBooleanOr("selected", false);
			active_battery = input.getBooleanOr("active_battery", false);
			ability_block = input.getBooleanOr("ability_block", false);
			use_ability_key_var = input.getBooleanOr("use_ability_key_var", false);
			detransf_key_var = input.getBooleanOr("detransf_key_var", false);
			wheel_open_key_var = input.getBooleanOr("wheel_open_key_var", false);
			second_wheel_open_var = input.getBooleanOr("second_wheel_open_var", false);
			third_wheel_open_var = input.getBooleanOr("third_wheel_open_var", false);
			first_fake_wheel_open_var = input.getBooleanOr("first_fake_wheel_open_var", false);
			second_fake_wheel_open_var = input.getBooleanOr("second_fake_wheel_open_var", false);
			third_fake_wheel_open_var = input.getBooleanOr("third_fake_wheel_open_var", false);
			ability_using = input.getBooleanOr("ability_using", false);
			power_recorded = input.getBooleanOr("power_recorded", false);
			debug = input.getBooleanOr("debug", false);
			detransform_anim_trigger = input.getBooleanOr("detransform_anim_trigger", false);
			helmet = input.read("helmet", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			chestplate = input.read("chestplate", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			leggings = input.read("leggings", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			boots = input.read("boots", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			unlock_keepers_box = input.getBooleanOr("unlock_keepers_box", false);
			transfered_power = input.getBooleanOr("transfered_power", false);
			master_effect_end = input.getBooleanOr("master_effect_end", false);
			master_effect_start = input.getBooleanOr("master_effect_start", false);
			level = input.getDoubleOr("level", 0);
			level_exp = input.getDoubleOr("level_exp", 0);
			base_damage_by_lvl = input.getDoubleOr("base_damage_by_lvl", 0);
			max_level_exp = input.getDoubleOr("max_level_exp", 0);
			resistance_char = input.getDoubleOr("resistance_char", 0);
			speed_char = input.getDoubleOr("speed_char", 0);
			haste_char = input.getDoubleOr("haste_char", 0);
			jump_char = input.getDoubleOr("jump_char", 0);
			level_up_status = input.getBooleanOr("level_up_status", false);
			rank = input.getStringOr("rank", "");
			mind_player_owner = input.getStringOr("mind_player_owner", "");
			mind_used = input.getBooleanOr("mind_used", false);
			blue_rune_slot = input.read("blue_rune_slot", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			red_rune_slot = input.read("red_rune_slot", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			green_rune_slot = input.read("green_rune_slot", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			rune_ovelay_display = input.getDoubleOr("rune_ovelay_display", 0);
		}

		public void markSyncDirty() {
			_syncDirty = true;
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> {
			TagValueOutput output = TagValueOutput.createWithoutContext(ProblemReporter.DISCARDING);
			message.data.serialize(output);
			buffer.writeNbt(output.buildResult());
		}, (RegistryFriendlyByteBuf buffer) -> {
			PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
			message.data.deserialize(TagValueInput.create(ProblemReporter.DISCARDING, buffer.registryAccess(), buffer.readNbt()));
			return message;
		});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					TagValueOutput output = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, context.player().registryAccess());
					message.data.serialize(output);
					context.player().getData(PLAYER_VARIABLES).deserialize(TagValueInput.create(ProblemReporter.DISCARDING, context.player().registryAccess(), output.buildResult()));
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}