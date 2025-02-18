package com.esmods.keepersofthestonestwo.client.model.animations;

import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.AnimationChannel;

// Save this class in your mod and generate all required imports
/**
 * Made with Blockbench 4.11.2 Exported for Minecraft version 1.19 or later with
 * Mojang mappings
 * 
 * @author Author
 */
public class cursed_knightAnimation {
	public static final AnimationDefinition idle = AnimationDefinition.Builder.withLength(2.6667F).looping()
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4583F, KeyframeAnimations.degreeVec(1.38F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.5F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.375F, KeyframeAnimations.degreeVec(-0.5621F, 0.0F, 0.0528F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.11F, -7.4976F, -2.512F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.125F, KeyframeAnimations.degreeVec(2.2822F, -9.4905F, -3.0067F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-2.434F, -7.4991F, -1.5072F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.11F, -7.4976F, -2.512F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, -0.4F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.11F, 7.4976F, 2.512F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.125F, KeyframeAnimations.degreeVec(4.7822F, 9.4905F, 3.0067F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-2.434F, 7.4991F, 1.5072F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.11F, 7.4976F, 2.512F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, -0.4F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.4407F, -9.9904F, -2.5385F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.329F, 7.4928F, 2.5215F), AnimationChannel.Interpolations.CATMULLROM))).build();
	public static final AnimationDefinition attack = AnimationDefinition.Builder.withLength(1.8125F)
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.1875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6042F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5625F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.9792F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.6042F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2708F, KeyframeAnimations.degreeVec(-65.8513F, 20.7048F, 9.0072F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5625F, KeyframeAnimations.degreeVec(-112.6101F, 29.9985F, 4.9145F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-40.0116F, 27.3669F, 17.1813F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-40.0116F, 27.3669F, 17.1813F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.4792F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.25F, KeyframeAnimations.degreeVec(-65.8513F, -20.7048F, -9.0072F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-112.6101F, -29.9985F, -4.9145F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.6875F, KeyframeAnimations.degreeVec(-40.0116F, -27.3669F, -17.1813F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.0208F, KeyframeAnimations.degreeVec(-40.0116F, -27.3669F, -17.1813F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.4792F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("bone2", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.0427F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(-4.1556F, 10.2003F, 21.9762F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6042F, KeyframeAnimations.degreeVec(-15.7321F, 15.4336F, 17.0926F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(7.3256F, -0.023F, 26.3389F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("bone2", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.posVec(1.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8333F, KeyframeAnimations.posVec(1.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_leg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.4407F, -9.9904F, -2.5385F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.625F, KeyframeAnimations.degreeVec(-22.0593F, -9.9904F, -2.5385F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.7292F, KeyframeAnimations.degreeVec(-22.0593F, -9.9904F, -2.5385F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-22.0593F, -9.9904F, -2.5385F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.4407F, -9.9904F, -2.5385F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.6875F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.329F, 7.4928F, 2.5215F), AnimationChannel.Interpolations.CATMULLROM))).build();
	public static final AnimationDefinition rofl = AnimationDefinition.Builder.withLength(5.625F)
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.751F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.0833F, KeyframeAnimations.degreeVec(44.514F, -13.0368F, -123.2583F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.4583F, KeyframeAnimations.degreeVec(44.514F, -13.0368F, -123.2583F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.75F, KeyframeAnimations.degreeVec(35.3562F, -10.1723F, -127.4425F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.9583F, KeyframeAnimations.degreeVec(35.3562F, -10.1723F, -127.4425F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.2083F, KeyframeAnimations.degreeVec(35.3562F, 10.1723F, 127.4425F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.3333F, KeyframeAnimations.degreeVec(35.3562F, 10.1723F, 127.4425F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.4583F, KeyframeAnimations.degreeVec(35.3562F, 10.1723F, 127.4425F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.625F, KeyframeAnimations.degreeVec(35.3562F, 10.1723F, 127.4425F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-3.15F, 6.8346F, 181.0275F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.2083F, KeyframeAnimations.degreeVec(6.8449F, 3.1276F, 271.4027F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.5417F, KeyframeAnimations.degreeVec(7.0569F, -2.6118F, 316.0546F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.8333F, KeyframeAnimations.degreeVec(6.3289F, -4.0744F, 328.4903F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(5.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 360.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6677F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.9167F, KeyframeAnimations.posVec(-4.62F, 6.37F, -8.87F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0833F, KeyframeAnimations.posVec(-9.0F, 5.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.4167F, KeyframeAnimations.posVec(-9.0F, 5.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.7083F, KeyframeAnimations.posVec(-9.0F, 3.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.9167F, KeyframeAnimations.posVec(-9.0F, 3.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.1667F, KeyframeAnimations.posVec(6.0F, 10.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(3.2917F, KeyframeAnimations.posVec(9.0F, 2.5F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.4167F, KeyframeAnimations.posVec(9.0F, 3.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(3.5833F, KeyframeAnimations.posVec(9.0F, 3.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.7083F, KeyframeAnimations.posVec(12.59F, 3.5F, -9.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(3.7917F, KeyframeAnimations.posVec(14.75F, 3.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.0833F, KeyframeAnimations.posVec(14.75F, -22.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.2917F, KeyframeAnimations.posVec(14.75F, -21.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.4583F, KeyframeAnimations.posVec(17.75F, -28.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.75F, KeyframeAnimations.posVec(20.75F, -29.25F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.875F, KeyframeAnimations.posVec(22.14F, -28.18F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.9583F, KeyframeAnimations.posVec(22.75F, -32.25F, -9.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.001F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-117.1209F, 4.4113F, 57.0619F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.25F, KeyframeAnimations.degreeVec(-117.1209F, 4.4113F, 57.0619F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.375F, KeyframeAnimations.degreeVec(-117.0569F, -2.2679F, 60.4759F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9593F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.2917F, KeyframeAnimations.posVec(0.5F, -5.0F, 0.75F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.2083F, KeyframeAnimations.posVec(0.5F, -5.0F, 0.75F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(3.3333F, KeyframeAnimations.posVec(0.5F, -5.75F, 0.75F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2083F, KeyframeAnimations.degreeVec(12.9264F, -14.6364F, -3.3191F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.3333F, KeyframeAnimations.degreeVec(13.0467F, -39.1359F, -8.9779F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.6667F, KeyframeAnimations.degreeVec(13.0467F, -39.1359F, -8.9779F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.125F, KeyframeAnimations.degreeVec(-132.7342F, -15.6999F, -16.325F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-143.0781F, -55.3518F, -11.7267F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.75F, KeyframeAnimations.degreeVec(-143.0781F, -55.3518F, -11.7267F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-117.1209F, -4.4113F, -57.0619F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-117.1209F, -4.4113F, -57.0619F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.75F, KeyframeAnimations.degreeVec(-117.1242F, 4.4937F, -61.6163F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-117.1242F, 4.4937F, -61.6163F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-119.5458F, -11.0003F, -44.9215F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.2917F, KeyframeAnimations.degreeVec(-117.1209F, -4.4113F, -57.0619F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 2.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 2.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.posVec(-0.5F, -5.0F, 0.75F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.6667F, KeyframeAnimations.posVec(-0.5F, -5.0F, 0.75F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.4167F, KeyframeAnimations.posVec(-0.5F, -5.0F, 0.75F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.7083F, KeyframeAnimations.posVec(-0.5F, -6.0F, 0.75F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.9167F, KeyframeAnimations.posVec(-0.5F, -6.0F, 0.75F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(3.0417F, KeyframeAnimations.posVec(-0.5F, -5.0F, 0.75F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.25F, KeyframeAnimations.posVec(-0.5F, -5.0F, 0.75F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("bone2", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0.375F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.376F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4167F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
	public static final AnimationDefinition walk = AnimationDefinition.Builder.withLength(1.4583F).looping().addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.63F), AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.27F), AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.218F, -2.4905F, 4.9953F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.329F, -7.5212F, -2.5501F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.218F, 2.4905F, -4.9953F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.329F, 7.5212F, 2.5501F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.218F, -2.4905F, 4.9953F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(13.9042F, -5.6842F, -3.1937F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-4.6211F, 1.9113F, -2.5771F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.75F, KeyframeAnimations.degreeVec(-18.586F, 7.5208F, -3.7323F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-4.6211F, 1.9113F, -2.5771F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.4583F, KeyframeAnimations.degreeVec(13.9042F, -5.6842F, -3.1937F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, -0.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(-18.586F, -7.5208F, 3.7323F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-4.6211F, -1.9113F, 2.5771F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.75F, KeyframeAnimations.degreeVec(13.9042F, 5.6842F, 3.1937F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-4.6211F, -1.9113F, 2.5771F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-18.586F, -7.5208F, 3.7323F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, -0.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.0833F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.25F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 1.25F, 0.25F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.25F, -1.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4167F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4583F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.22F, 0.2F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 1.25F, 1.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.25F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.22F, 0.2F), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
	public static final AnimationDefinition sprint = AnimationDefinition.Builder.withLength(0.9722F).looping()
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2778F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.63F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5278F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.27F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9722F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2222F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4722F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6944F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.9722F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.218F, -2.4905F, 4.9953F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2778F, KeyframeAnimations.degreeVec(0.329F, -7.5212F, -2.5501F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5278F, KeyframeAnimations.degreeVec(0.218F, 2.4905F, -4.9953F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.7778F, KeyframeAnimations.degreeVec(0.329F, 7.5212F, 2.5501F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.9722F, KeyframeAnimations.degreeVec(0.218F, -2.4905F, 4.9953F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(13.9042F, -5.6842F, -3.1937F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2222F, KeyframeAnimations.degreeVec(-4.6211F, 1.9113F, -2.5771F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5F, KeyframeAnimations.degreeVec(-18.586F, 7.5208F, -3.7323F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.7222F, KeyframeAnimations.degreeVec(-4.6211F, 1.9113F, -2.5771F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.9722F, KeyframeAnimations.degreeVec(13.9042F, -5.6842F, -3.1937F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1944F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4722F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6944F, KeyframeAnimations.posVec(0.0F, -0.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.9722F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(-18.586F, -7.5208F, 3.7323F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2222F, KeyframeAnimations.degreeVec(-4.6211F, -1.9113F, 2.5771F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5F, KeyframeAnimations.degreeVec(13.9042F, 5.6842F, 3.1937F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.7222F, KeyframeAnimations.degreeVec(-4.6211F, -1.9113F, 2.5771F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.9722F, KeyframeAnimations.degreeVec(-18.586F, -7.5208F, 3.7323F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1944F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4722F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6944F, KeyframeAnimations.posVec(0.0F, -0.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.9722F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2778F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.7222F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8056F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9722F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.25F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2778F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7222F, KeyframeAnimations.posVec(0.0F, 1.25F, 0.25F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.9722F, KeyframeAnimations.posVec(0.0F, 0.25F, -1.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.2778F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3611F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7222F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9722F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.22F, 0.2F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2778F, KeyframeAnimations.posVec(0.0F, 1.25F, 1.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.25F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7222F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.9722F, KeyframeAnimations.posVec(0.0F, 0.22F, 0.2F), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
}
