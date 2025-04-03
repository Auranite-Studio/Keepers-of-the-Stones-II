package com.esmods.keepersofthestonestwo.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

import com.esmods.keepersofthestonestwo.PowerMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PowerModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		PowerMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		PowerMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
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
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					PowerMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					PowerMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					PowerMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "power_worldvars";
		public double entity_rotation = 0;

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			entity_rotation = nbt.getDouble("entity_rotation");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("entity_rotation", entity_rotation);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				PowerMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
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
		public double cpapi_ver = 21.0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
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
			cpapi_ver = nbt.getDouble("cpapi_ver");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
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
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				PowerMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("power", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
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

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PowerMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
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
			nbt.put("helmet", helmet.save(new CompoundTag()));
			nbt.put("chestplate", chestplate.save(new CompoundTag()));
			nbt.put("leggings", leggings.save(new CompoundTag()));
			nbt.put("boots", boots.save(new CompoundTag()));
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
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
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
			power = nbt.getDouble("power");
			powerTimer = nbt.getDouble("powerTimer");
			mergers = nbt.getDouble("mergers");
			power_recovery_multiplier = nbt.getDouble("power_recovery_multiplier");
			max_power = nbt.getDouble("max_power");
			recharge_timer = nbt.getDouble("recharge_timer");
			master_effect_duration = nbt.getDouble("master_effect_duration");
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
			helmet = ItemStack.of(nbt.getCompound("helmet"));
			chestplate = ItemStack.of(nbt.getCompound("chestplate"));
			leggings = ItemStack.of(nbt.getCompound("leggings"));
			boots = ItemStack.of(nbt.getCompound("boots"));
			unlock_keepers_box = nbt.getBoolean("unlock_keepers_box");
			transfered_power = nbt.getBoolean("transfered_power");
			master_effect_end = nbt.getBoolean("master_effect_end");
			master_effect_start = nbt.getBoolean("master_effect_start");
			level = nbt.getDouble("level");
			level_exp = nbt.getDouble("level_exp");
			base_damage_by_lvl = nbt.getDouble("base_damage_by_lvl");
			max_level_exp = nbt.getDouble("max_level_exp");
			resistance_char = nbt.getDouble("resistance_char");
			speed_char = nbt.getDouble("speed_char");
			haste_char = nbt.getDouble("haste_char");
			jump_char = nbt.getDouble("jump_char");
			level_up_status = nbt.getBoolean("level_up_status");
			rank = nbt.getString("rank");
			mind_player_owner = nbt.getString("mind_player_owner");
			mind_used = nbt.getBoolean("mind_used");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.ability = message.data.ability;
					variables.element_name_first = message.data.element_name_first;
					variables.element_name_second = message.data.element_name_second;
					variables.element_name_third = message.data.element_name_third;
					variables.teleporting_effect = message.data.teleporting_effect;
					variables.fake_element_name_first = message.data.fake_element_name_first;
					variables.fake_element_name_second = message.data.fake_element_name_second;
					variables.fake_element_name_third = message.data.fake_element_name_third;
					variables.abilities_timer = message.data.abilities_timer;
					variables.fake_element_name_first_timer = message.data.fake_element_name_first_timer;
					variables.fake_element_name_second_timer = message.data.fake_element_name_second_timer;
					variables.fake_element_name_third_timer = message.data.fake_element_name_third_timer;
					variables.power = message.data.power;
					variables.powerTimer = message.data.powerTimer;
					variables.mergers = message.data.mergers;
					variables.power_recovery_multiplier = message.data.power_recovery_multiplier;
					variables.max_power = message.data.max_power;
					variables.recharge_timer = message.data.recharge_timer;
					variables.master_effect_duration = message.data.master_effect_duration;
					variables.active_power = message.data.active_power;
					variables.selected = message.data.selected;
					variables.active_battery = message.data.active_battery;
					variables.ability_block = message.data.ability_block;
					variables.use_ability_key_var = message.data.use_ability_key_var;
					variables.detransf_key_var = message.data.detransf_key_var;
					variables.wheel_open_key_var = message.data.wheel_open_key_var;
					variables.second_wheel_open_var = message.data.second_wheel_open_var;
					variables.third_wheel_open_var = message.data.third_wheel_open_var;
					variables.first_fake_wheel_open_var = message.data.first_fake_wheel_open_var;
					variables.second_fake_wheel_open_var = message.data.second_fake_wheel_open_var;
					variables.third_fake_wheel_open_var = message.data.third_fake_wheel_open_var;
					variables.ability_using = message.data.ability_using;
					variables.power_recorded = message.data.power_recorded;
					variables.debug = message.data.debug;
					variables.detransform_anim_trigger = message.data.detransform_anim_trigger;
					variables.helmet = message.data.helmet;
					variables.chestplate = message.data.chestplate;
					variables.leggings = message.data.leggings;
					variables.boots = message.data.boots;
					variables.unlock_keepers_box = message.data.unlock_keepers_box;
					variables.transfered_power = message.data.transfered_power;
					variables.master_effect_end = message.data.master_effect_end;
					variables.master_effect_start = message.data.master_effect_start;
					variables.level = message.data.level;
					variables.level_exp = message.data.level_exp;
					variables.base_damage_by_lvl = message.data.base_damage_by_lvl;
					variables.max_level_exp = message.data.max_level_exp;
					variables.is_not_stone = message.data.is_not_stone;
					variables.attribute_is_ready = message.data.attribute_is_ready;
					variables.resistance_char = message.data.resistance_char;
					variables.speed_char = message.data.speed_char;
					variables.haste_char = message.data.haste_char;
					variables.jump_char = message.data.jump_char;
					variables.level_up_status = message.data.level_up_status;
					variables.rank = message.data.rank;
					variables.cursed_fog = message.data.cursed_fog;
					variables.fog_distance = message.data.fog_distance;
					variables.mind_player_owner = message.data.mind_player_owner;
					variables.mind_used = message.data.mind_used;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
