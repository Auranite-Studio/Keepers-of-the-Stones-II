package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.modifier.AbstractFadeModifier;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.firstPerson.FirstPersonMode;
import dev.kosmx.playerAnim.api.firstPerson.FirstPersonConfiguration;

import com.esmods.keepersofthestonestwo.PowerMod;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@EventBusSubscriber(modid = "power", bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AnimationsModuleSetupProcedure {
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		PlayerAnimationAccess.REGISTER_ANIMATION_EVENT.register((player, animationStack) -> {
			ModifierLayer<IAnimation> layer = new ModifierLayer<>();
			animationStack.addAnimLayer(69, layer);
			PlayerAnimationAccess.getPlayerAssociatedData(player).set(ResourceLocation.fromNamespaceAndPath("power", "player_animation"), layer);
		});
	}

	@EventBusSubscriber(modid = "power", bus = EventBusSubscriber.Bus.MOD)
	public record PowerModAnimationMessage(String animation, int target, boolean override) implements CustomPacketPayload {

		public static final Type<PowerModAnimationMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "animations_module_setup"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PowerModAnimationMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PowerModAnimationMessage message) -> {
			buffer.writeUtf(message.animation);
			buffer.writeInt(message.target);
			buffer.writeBoolean(message.override);
		}, (RegistryFriendlyByteBuf buffer) -> new PowerModAnimationMessage(buffer.readUtf(), buffer.readInt(), buffer.readBoolean()));
		@Override
		public @NotNull Type<PowerModAnimationMessage> type() {
			return TYPE;
		}

		public static void handleData(final PowerModAnimationMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND) {
				context.enqueueWork(() -> {
					Level level = context.player().level();
					if (level.getEntity(message.target) != null) {
						Player player = (Player) level.getEntity(message.target);
						setAnimationClientside(player, message.animation, message.override);
					}
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			PowerMod.addNetworkMessage(PowerModAnimationMessage.TYPE, PowerModAnimationMessage.STREAM_CODEC, PowerModAnimationMessage::handleData);
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static void setAnimationClientside(Player player, String anim, boolean override) {
		if (player instanceof net.minecraft.client.player.AbstractClientPlayer player_) {
			var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player_).get(ResourceLocation.fromNamespaceAndPath("power", "player_animation"));
			if (animation != null && override || !Objects.requireNonNull(animation).isActive()) {
				animation.replaceAnimationWithFade(AbstractFadeModifier.functionalFadeIn(0, (modelName, type, value) -> value), PlayerAnimationRegistry.getAnimation(ResourceLocation.fromNamespaceAndPath("power", anim)).playAnimation()
						.setFirstPersonMode(FirstPersonMode.THIRD_PERSON_MODEL).setFirstPersonConfiguration(new FirstPersonConfiguration().setShowRightArm(true).setShowLeftItem(false)));
			}
		}
	}
}
