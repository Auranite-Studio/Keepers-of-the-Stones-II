package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModAttributes;
import com.esmods.keepersofthestonestwo.client.model.Modelplayer_layer;
import com.esmods.keepersofthestonestwo.client.model.Modeliceberg;

@EventBusSubscriber(value = {Dist.CLIENT})
public class IceLayerRenderProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onEventTriggered(RenderLivingEvent.Pre event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		RenderLivingEvent _evt = (RenderLivingEvent) event;
		Minecraft mc = Minecraft.getInstance();
		EntityRenderDispatcher dis = Minecraft.getInstance().getEntityRenderDispatcher();
		EntityRendererProvider.Context context = new EntityRendererProvider.Context(dis, mc.getItemRenderer(), mc.getBlockRenderer(), dis.getItemInHandRenderer(), mc.getResourceManager(), mc.getEntityModels(), mc.font);
		Entity _evtEntity = _evt.getEntity();
		PlayerRenderer _pr = null;
		PoseStack poseStack = _evt.getPoseStack();
		if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
			ResourceLocation _texture = ResourceLocation.parse("kleiders_custom_renderer:textures/entities/empty.png");
			com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer emptyRenderer = new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context,
					(_evtEntity instanceof AbstractClientPlayer ? ((AbstractClientPlayer) _evtEntity).getSkin().model() == PlayerSkin.Model.SLIM : false), _texture);
			_pr = emptyRenderer;
			emptyRenderer.clearLayers();
			emptyRenderer.render((AbstractClientPlayer) _evtEntity, _evtEntity.getYRot(), _evt.getPartialTick(), poseStack, _evt.getMultiBufferSource(), _evt.getPackedLight());
		}
		if (entity instanceof Player || entity instanceof ServerPlayer) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).ice_layer == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
					ResourceLocation _texture = ResourceLocation.parse("kleiders_custom_renderer:textures/entities/default.png");
					if (ResourceLocation.tryParse("power:textures/entities/iceberg_player.png") != null) {
						_texture = ResourceLocation.parse("power:textures/entities/iceberg_player.png");
					}
					Modelplayer_layer newModel = new Modelplayer_layer(context.bakeLayer(Modelplayer_layer.LAYER_LOCATION));
					newModel.LeftLeg.copyFrom(_pr.getModel().leftLeg);
					newModel.RightLeg.copyFrom(_pr.getModel().rightLeg);
					newModel.LeftArm.copyFrom(_pr.getModel().leftArm);
					newModel.RightArm.copyFrom(_pr.getModel().rightArm);
					newModel.Body.copyFrom(_pr.getModel().body);
					newModel.Head.copyFrom(_pr.getModel().head);
					poseStack.pushPose();
					poseStack.scale(0.9375F, 0.9375F, 0.9375F);
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerAnimatedRenderer(context, _texture, newModel).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
							_evt.getMultiBufferSource(), _evt.getPackedLight());
					poseStack.popPose();
				}
			}
		} else {
			if ((entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(PowerModAttributes.ICE_LAYER) ? _livingEntity4.getAttribute(PowerModAttributes.ICE_LAYER).getBaseValue() : 0) == 1) {
				if (!(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersEntityRenderer) && _evt.getEntity() instanceof Mob) {
					if (_evt instanceof RenderLivingEvent.Pre _pre) {
						// _pre.setCanceled(true);
					}
					new com.kleiders.kleidersplayerrenderer.KleidersEntityRenderer(context, ResourceLocation.parse("power:textures/entities/iceberg.png"), new Modeliceberg(context.bakeLayer(Modeliceberg.LAYER_LOCATION)))
							.render((Mob) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(), _evt.getMultiBufferSource(), _evt.getPackedLight());
				}
			}
		}
	}
}
