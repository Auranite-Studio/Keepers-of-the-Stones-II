package com.esmods.keepersofthestonestwo.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
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

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PowerModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, PowerMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());
	public static double recharge_timer = 300.0;
	public static double master_effect_duration = 600.0;

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
			clone.first_booster_slot = original.first_booster_slot;
			clone.second_booster_slot = original.second_booster_slot;
			clone.third_booster_slot = original.third_booster_slot;
			clone.max_power = original.max_power;
			clone.selected = original.selected;
			clone.active_battery = original.active_battery;
			clone.debug = original.debug;
			clone.helmet = original.helmet;
			clone.chestplate = original.chestplate;
			clone.leggings = original.leggings;
			clone.boots = original.boots;
			clone.unlock_keepers_box = original.unlock_keepers_box;
			clone.level = original.level;
			clone.level_xp = original.level_xp;
			clone.base_damage_by_lvl = original.base_damage_by_lvl;
			clone.hypnotized = original.hypnotized;
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

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "power_worldvars";
		public double entity_rotation = 0;

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			entity_rotation = nbt.getDouble("entity_rotation");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("entity_rotation", entity_rotation);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof ServerLevel level)
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "power_mapvars";
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
		public boolean get_limit_of_stones = true;

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			opX = nbt.getDouble("opX");
			opY = nbt.getDouble("opY");
			opZ = nbt.getDouble("opZ");
			bpX = nbt.getDouble("bpX");
			bpY = nbt.getDouble("bpY");
			bpZ = nbt.getDouble("bpZ");
			fire_stone = nbt.getBoolean("fire_stone");
			air_stone = nbt.getBoolean("air_stone");
			earth_stone = nbt.getBoolean("earth_stone");
			water_stone = nbt.getBoolean("water_stone");
			ether_stone = nbt.getBoolean("ether_stone");
			ice_stone = nbt.getBoolean("ice_stone");
			lightning_stone = nbt.getBoolean("lightning_stone");
			sound_stone = nbt.getBoolean("sound_stone");
			crystal_stone = nbt.getBoolean("crystal_stone");
			lava_stone = nbt.getBoolean("lava_stone");
			rain_stone = nbt.getBoolean("rain_stone");
			tornado_stone = nbt.getBoolean("tornado_stone");
			ocean_stone = nbt.getBoolean("ocean_stone");
			plants_stone = nbt.getBoolean("plants_stone");
			animals_stone = nbt.getBoolean("animals_stone");
			metal_stone = nbt.getBoolean("metal_stone");
			light_stone = nbt.getBoolean("light_stone");
			shadow_stone = nbt.getBoolean("shadow_stone");
			vacuum_stone = nbt.getBoolean("vacuum_stone");
			energy_stone = nbt.getBoolean("energy_stone");
			sun_stone = nbt.getBoolean("sun_stone");
			moon_stone = nbt.getBoolean("moon_stone");
			space_stone = nbt.getBoolean("space_stone");
			time_stone = nbt.getBoolean("time_stone");
			blood_stone = nbt.getBoolean("blood_stone");
			technology_stone = nbt.getBoolean("technology_stone");
			teleportation_stone = nbt.getBoolean("teleportation_stone");
			explosion_stone = nbt.getBoolean("explosion_stone");
			amber_stone = nbt.getBoolean("amber_stone");
			creation_stone = nbt.getBoolean("creation_stone");
			destruction_stone = nbt.getBoolean("destruction_stone");
			mist_stone = nbt.getBoolean("mist_stone");
			sand_stone = nbt.getBoolean("sand_stone");
			speed_stone = nbt.getBoolean("speed_stone");
			poison_stone = nbt.getBoolean("poison_stone");
			magnet_stone = nbt.getBoolean("magnet_stone");
			mushrooms_stone = nbt.getBoolean("mushrooms_stone");
			mercury_stone = nbt.getBoolean("mercury_stone");
			music_stone = nbt.getBoolean("music_stone");
			plague_stone = nbt.getBoolean("plague_stone");
			blue_flame_stone = nbt.getBoolean("blue_flame_stone");
			gravity_stone = nbt.getBoolean("gravity_stone");
			smoke_stone = nbt.getBoolean("smoke_stone");
			spirit_stone = nbt.getBoolean("spirit_stone");
			form_stone = nbt.getBoolean("form_stone");
			mind_stone = nbt.getBoolean("mind_stone");
			golden_dust_stone = nbt.getBoolean("golden_dust_stone");
			darkness_stone = nbt.getBoolean("darkness_stone");
			blue_portal_placed = nbt.getBoolean("blue_portal_placed");
			orange_portal_placed = nbt.getBoolean("orange_portal_placed");
			get_limit_of_stones = nbt.getBoolean("get_limit_of_stones");
		}

		@Override
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
			nbt.putBoolean("get_limit_of_stones", get_limit_of_stones);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
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
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
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
		public String first_booster_slot = "0";
		public String second_booster_slot = "0";
		public String third_booster_slot = "0";
		public double power = 0.0;
		public double powerTimer = 0.0;
		public double mergers = 0.0;
		public double power_recovery_multiplier = 1.0;
		public double max_power = 100.0;
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
		public double level = 1.0;
		public double level_xp = 0;
		public double base_damage_by_lvl = 0;
		public boolean hypnotized = false;

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
			nbt.putString("first_booster_slot", first_booster_slot);
			nbt.putString("second_booster_slot", second_booster_slot);
			nbt.putString("third_booster_slot", third_booster_slot);
			nbt.putDouble("power", power);
			nbt.putDouble("powerTimer", powerTimer);
			nbt.putDouble("mergers", mergers);
			nbt.putDouble("power_recovery_multiplier", power_recovery_multiplier);
			nbt.putDouble("max_power", max_power);
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
			nbt.put("helmet", helmet.saveOptional(lookupProvider));
			nbt.put("chestplate", chestplate.saveOptional(lookupProvider));
			nbt.put("leggings", leggings.saveOptional(lookupProvider));
			nbt.put("boots", boots.saveOptional(lookupProvider));
			nbt.putBoolean("unlock_keepers_box", unlock_keepers_box);
			nbt.putBoolean("transfered_power", transfered_power);
			nbt.putDouble("level", level);
			nbt.putDouble("level_xp", level_xp);
			nbt.putDouble("base_damage_by_lvl", base_damage_by_lvl);
			nbt.putBoolean("hypnotized", hypnotized);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			ability = nbt.getString("ability");
			element_name_first = nbt.getString("element_name_first");
			element_name_second = nbt.getString("element_name_second");
			element_name_third = nbt.getString("element_name_third");
			teleporting_effect = nbt.getDouble("teleporting_effect");
			fake_element_name_first = nbt.getString("fake_element_name_first");
			fake_element_name_second = nbt.getString("fake_element_name_second");
			fake_element_name_third = nbt.getString("fake_element_name_third");
			abilities_timer = nbt.getDouble("abilities_timer");
			fake_element_name_first_timer = nbt.getDouble("fake_element_name_first_timer");
			fake_element_name_second_timer = nbt.getDouble("fake_element_name_second_timer");
			fake_element_name_third_timer = nbt.getDouble("fake_element_name_third_timer");
			first_booster_slot = nbt.getString("first_booster_slot");
			second_booster_slot = nbt.getString("second_booster_slot");
			third_booster_slot = nbt.getString("third_booster_slot");
			power = nbt.getDouble("power");
			powerTimer = nbt.getDouble("powerTimer");
			mergers = nbt.getDouble("mergers");
			power_recovery_multiplier = nbt.getDouble("power_recovery_multiplier");
			max_power = nbt.getDouble("max_power");
			active_power = nbt.getBoolean("active_power");
			selected = nbt.getBoolean("selected");
			active_battery = nbt.getBoolean("active_battery");
			ability_block = nbt.getBoolean("ability_block");
			use_ability_key_var = nbt.getBoolean("use_ability_key_var");
			detransf_key_var = nbt.getBoolean("detransf_key_var");
			wheel_open_key_var = nbt.getBoolean("wheel_open_key_var");
			second_wheel_open_var = nbt.getBoolean("second_wheel_open_var");
			third_wheel_open_var = nbt.getBoolean("third_wheel_open_var");
			first_fake_wheel_open_var = nbt.getBoolean("first_fake_wheel_open_var");
			second_fake_wheel_open_var = nbt.getBoolean("second_fake_wheel_open_var");
			third_fake_wheel_open_var = nbt.getBoolean("third_fake_wheel_open_var");
			ability_using = nbt.getBoolean("ability_using");
			power_recorded = nbt.getBoolean("power_recorded");
			debug = nbt.getBoolean("debug");
			detransform_anim_trigger = nbt.getBoolean("detransform_anim_trigger");
			helmet = ItemStack.parseOptional(lookupProvider, nbt.getCompound("helmet"));
			chestplate = ItemStack.parseOptional(lookupProvider, nbt.getCompound("chestplate"));
			leggings = ItemStack.parseOptional(lookupProvider, nbt.getCompound("leggings"));
			boots = ItemStack.parseOptional(lookupProvider, nbt.getCompound("boots"));
			unlock_keepers_box = nbt.getBoolean("unlock_keepers_box");
			transfered_power = nbt.getBoolean("transfered_power");
			level = nbt.getDouble("level");
			level_xp = nbt.getDouble("level_xp");
			base_damage_by_lvl = nbt.getDouble("base_damage_by_lvl");
			hypnotized = nbt.getBoolean("hypnotized");
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
