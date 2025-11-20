package com.esmods.keepersofthestonestwo.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import org.joml.Matrix4f;

import net.minecraft.world.entity.player.Player;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Camera;

import com.esmods.keepersofthestonestwo.PowerModPlayerAnimationAPI;

@Mixin(LevelRenderer.class)
public abstract class LevelRendererMixin {
	private String master = null;

	@Inject(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;isDetached()Z"))
	private void fakeThirdPersonMode(DeltaTracker deltaTracker, boolean bl, Camera camera, GameRenderer gameRenderer, LightTexture lightTexture, Matrix4f matrix4f, Matrix4f matrix4f2, CallbackInfo ci) {
		if (master == null) {
			if (!PowerModPlayerAnimationAPI.animations.isEmpty())
				master = "power";
			else
				return;
		}
		if (!master.equals("power")) {
			return;
		}
		if (camera.getEntity() instanceof Player player && player.getPersistentData().getBoolean("FirstPersonAnimation") && Minecraft.getInstance().player == player) {
			((CameraAccessor) camera).setDetached(true);
		}
	}

	@Inject(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;isDetached()Z", shift = At.Shift.AFTER))
	private void resetThirdPerson(DeltaTracker deltaTracker, boolean bl, Camera camera, GameRenderer gameRenderer, LightTexture lightTexture, Matrix4f matrix4f, Matrix4f matrix4f2, CallbackInfo ci) {
		if (master == null) {
			if (!PowerModPlayerAnimationAPI.animations.isEmpty())
				master = "power";
			else
				return;
		}
		if (!master.equals("power")) {
			return;
		}
		((CameraAccessor) camera).setDetached(false);
	}
}