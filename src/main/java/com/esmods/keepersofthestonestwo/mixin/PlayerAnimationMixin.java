package com.esmods.keepersofthestonestwo.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.Minecraft;

import java.util.Map;

import com.esmods.keepersofthestonestwo.PowerModPlayerAnimationAPI;

@Mixin(PlayerModel.class)
public abstract class PlayerAnimationMixin {
	private String master = null;

	@Inject(method = "Lnet/minecraft/client/model/PlayerModel;setupAnim(Lnet/minecraft/client/renderer/entity/state/PlayerRenderState;)V", at = @At(value = "HEAD"))
	public void setupPivot(PlayerRenderState renderState, CallbackInfo ci) {
		if (master == null)
			master = "power";
		Player player = (Player) renderState.getRenderData(PowerModPlayerAnimationAPI.ClientAttachments.PLAYER);
		if (player == null)
			return;
		PlayerModel model = (PlayerModel) (Object) this;
		PowerModPlayerAnimationAPI.PlayerAnimation animation = PowerModPlayerAnimationAPI.active_animations.get(player);
		if (animation == null)
			return;
		if (animation.bones.get("left_arm") != null || animation.bones.get("torso") != null || animation.bones.get("right_arm") != null)
			renderState.attackTime = 0;
		renderState.isCrouching = false;
	}

	@Inject(method = "Lnet/minecraft/client/model/PlayerModel;setupAnim(Lnet/minecraft/client/renderer/entity/state/PlayerRenderState;)V", at = @At(value = "TAIL"))
	public void setupAnim(PlayerRenderState renderState, CallbackInfo ci) {
		Player player = (Player) renderState.getRenderData(PowerModPlayerAnimationAPI.ClientAttachments.PLAYER);
		if (player == null)
			return;
		if (!master.equals("power")) {
			if (!PowerModPlayerAnimationAPI.animations.isEmpty())
				PowerModPlayerAnimationAPI.animations.clear();
			return;
		}
		PlayerModel model = (PlayerModel) (Object) this;
		CompoundTag data = player.getPersistentData();
		String playingAnimation = data.getStringOr("PlayerCurrentAnimation", "");
		boolean overrideAnimation = data.getBooleanOr("OverrideCurrentAnimation", false);
		Minecraft mc = Minecraft.getInstance();
		boolean firstPerson = data.getBooleanOr("FirstPersonAnimation", false) && mc.player == player;
		if (data.getBooleanOr("ResetPlayerAnimation", false)) {
			data.remove("ResetPlayerAnimation");
			data.remove("LastTickTime");
			PowerModPlayerAnimationAPI.active_animations.put(player, null);
			hideModelParts(model, false);
		}
		if (playingAnimation.isEmpty()) {
			return;
		}
		if (firstPerson) {
			hideModelParts(model, mc.options.getCameraType().isFirstPerson());
		}
		float animationProgress;
		if (overrideAnimation) {
			firstPerson = data.getBooleanOr("FirstPersonAnimation", false);
			PowerModPlayerAnimationAPI.active_animations.put(player, null);
			data.remove("PlayerAnimationProgress");
			data.putBoolean("OverrideCurrentAnimation", false);
		}
		PowerModPlayerAnimationAPI.PlayerAnimation animation = PowerModPlayerAnimationAPI.active_animations.get(player);
		if (animation == null) {
			animation = PowerModPlayerAnimationAPI.animations.get(playingAnimation);
			PowerModPlayerAnimationAPI.active_animations.put(player, animation);
		}
		if (!data.contains("PlayerAnimationProgress")) {
			animationProgress = 0f;
			data.putFloat("PlayerAnimationProgress", animationProgress);
			data.putFloat("LastTickTime", renderState.ageInTicks);
		} else {
			animationProgress = data.getFloatOr("PlayerAnimationProgress", 0);
			float lastTickTime = data.getFloatOr("LastTickTime", renderState.ageInTicks);
			float deltaTime = (renderState.ageInTicks - lastTickTime) / 20f; // Convert ticks to seconds
			animationProgress += deltaTime;
			data.putFloat("PlayerAnimationProgress", animationProgress);
			data.putFloat("LastTickTime", renderState.ageInTicks);
			if (animationProgress >= animation.length) {
				if (!animation.hold_on_last_frame && !animation.loop) {
					data.putBoolean("FirstPersonAnimation", false);
					data.putBoolean("ResetPlayerAnimation", true);
					data.remove("PlayerCurrentAnimation");
					data.remove("PlayerAnimationProgress");
					PowerModPlayerAnimationAPI.active_animations.put(player, null);
					animationProgress = animation.length;
				} else if (animation.hold_on_last_frame) {
					data.putFloat("PlayerAnimationProgress", animation.length);
				} else if (animation.loop) {
					data.remove("PlayerAnimationProgress");
				}
			}
		}
		// Apply each bone's transformations
		for (Map.Entry<String, PowerModPlayerAnimationAPI.PlayerBone> entry : animation.bones.entrySet()) {
			String boneName = entry.getKey();
			PowerModPlayerAnimationAPI.PlayerBone bone = entry.getValue();
			ModelPart modelPart = getModelPart(model, boneName);
			if (modelPart == null)
				continue;
			// Apply rotation
			Vec3 rotation = PowerModPlayerAnimationAPI.PlayerBone.interpolate(bone.rotations, animationProgress);
			if (rotation != null) {
				modelPart.xRot = (float) Math.toRadians(rotation.x);
				modelPart.yRot = (float) Math.toRadians(rotation.y);
				modelPart.zRot = (float) Math.toRadians(rotation.z);
			}
			// Apply position (don't apply if null - keep default position)
			Vec3 position = PowerModPlayerAnimationAPI.PlayerBone.interpolate(bone.positions, animationProgress);
			if (position != null) {
				// Position offsets are relative, not absolute
				modelPart.x += (float) position.x;
				modelPart.y -= (float) position.y;
				modelPart.z += (float) position.z;
			}
			// Apply scale
			Vec3 scale = PowerModPlayerAnimationAPI.PlayerBone.interpolate(bone.scales, animationProgress);
			if (scale != null) {
				modelPart.xScale = (float) scale.x;
				modelPart.yScale = (float) scale.y;
				modelPart.zScale = (float) scale.z;
			}
		}
	}

	private ModelPart getModelPart(PlayerModel model, String boneName) {
		switch (boneName) {
			case "torso" :
				return model.body;
			case "head" :
				return model.head;
			case "right_arm" :
				return model.rightArm;
			case "left_arm" :
				return model.leftArm;
			case "right_leg" :
				return model.rightLeg;
			case "left_leg" :
				return model.leftLeg;
			default :
				return null;
		}
	}

	private void hideModelParts(PlayerModel model, boolean hide) {
		model.head.skipDraw = hide;
		model.hat.skipDraw = hide;
		model.body.skipDraw = hide;
		model.jacket.skipDraw = hide;
		model.leftLeg.skipDraw = hide;
		model.leftPants.skipDraw = hide;
		model.rightLeg.skipDraw = hide;
		model.rightPants.skipDraw = hide;
	}
}