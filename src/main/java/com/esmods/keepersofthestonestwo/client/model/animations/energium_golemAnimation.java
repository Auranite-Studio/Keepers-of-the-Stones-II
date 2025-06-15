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
public class energium_golemAnimation {
	public static final AnimationDefinition idle = AnimationDefinition.Builder.withLength(2.0F).looping()
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("hand1", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("hand1", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("hand2", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("hand2", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
	public static final AnimationDefinition walk = AnimationDefinition.Builder.withLength(1.5417F).looping()
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.9119F, 14.7017F, 5.834F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.4167F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.7083F, KeyframeAnimations.degreeVec(3.9119F, -14.7017F, -5.834F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.0833F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5417F, KeyframeAnimations.degreeVec(3.9119F, 14.7017F, 5.834F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 1.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -1.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 1.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, -1.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("hand1",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.9901F, 11.5349F, -4.8493F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.125F, KeyframeAnimations.degreeVec(15.1746F, -6.9262F, -2.8842F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-12.9901F, 11.5349F, -4.8493F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("hand2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(22.6746F, 6.9262F, 2.8842F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-22.6746F, -6.9262F, 2.8842F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5417F, KeyframeAnimations.degreeVec(22.6746F, 6.9262F, 2.8842F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.8377F, -14.2498F, -8.3098F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.7083F, KeyframeAnimations.degreeVec(4.8377F, 14.2498F, 8.3098F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5417F, KeyframeAnimations.degreeVec(4.8377F, -14.2498F, -8.3098F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4583F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5417F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.22F, 0.2F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 2.25F, 1.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, -0.75F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.22F, 0.2F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8333F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.125F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.75F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 3.25F, 0.25F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, -0.75F, -1.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
	public static final AnimationDefinition shoot = AnimationDefinition.Builder.withLength(2.0833F).addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.2083F, KeyframeAnimations.degreeVec(12.4539F, -1.0809F, 4.8821F), AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(22.4807F, 0.9565F, -2.3099F), AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(22.4807F, -0.9565F, 2.3099F), AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-29.7873F, -3.742F, -6.5045F), AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-37.2625F, 4.5575F, 5.9627F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("hand1",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.0427F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.25F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, -27.5F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-51.8292F, 22.4162F, 10.2474F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-52.9666F, 18.4537F, 6.9922F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-70.3043F, -43.6908F, -48.1211F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-94.3724F, -28.7432F, -49.6849F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("hand2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.0843F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 27.5F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-51.8292F, -22.4162F, -10.2474F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-52.0847F, -22.8028F, -10.556F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.25F, KeyframeAnimations.degreeVec(-70.3043F, 43.6908F, 48.1211F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-94.3724F, 28.7432F, 49.6849F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.875F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.875F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
	public static final AnimationDefinition death = AnimationDefinition.Builder.withLength(1.25F).addAnimation("boss", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-92.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("boss", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, 4.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 3.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("hand1",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.6667F, KeyframeAnimations.degreeVec(10.625F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("hand1", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5833F, KeyframeAnimations.posVec(6.0F, -7.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(6.0F, -7.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.875F, KeyframeAnimations.posVec(6.0F, -8.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("hand2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 135.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.75F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 135.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 135.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 135.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("hand2", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.501F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.6667F, KeyframeAnimations.posVec(-3.0F, -3.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.posVec(-3.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.9583F, KeyframeAnimations.posVec(-4.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.6667F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 27.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 36.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 7.8F, -8.8F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 13.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 14.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leg1",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.376F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.625F, KeyframeAnimations.degreeVec(17.5F, -10.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.376F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5417F, KeyframeAnimations.posVec(8.0F, -9.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.625F, KeyframeAnimations.posVec(7.0F, -12.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.7083F, KeyframeAnimations.posVec(6.0F, -12.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.posVec(5.0F, -16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leg2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.376F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-26.2407F, 6.608F, -23.4439F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.625F, KeyframeAnimations.degreeVec(8.7363F, -6.0707F, -10.4642F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.376F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5417F, KeyframeAnimations.posVec(-4.0F, -7.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.posVec(-10.0F, -7.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.8333F, KeyframeAnimations.posVec(-12.0F, -8.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
	public static final AnimationDefinition attack = AnimationDefinition.Builder.withLength(1.3333F)
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(12.4539F, -1.0809F, 4.8821F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-19.9299F, -1.7082F, -4.6999F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(-27.2989F, 3.4553F, 6.6607F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("hand1", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.0427F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.2083F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(-127.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-142.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("hand2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.1667F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-127.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-142.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.25F, KeyframeAnimations.degreeVec(14.5108F, 3.841F, -14.5108F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5F, KeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-50.0803F, 6.732F, 15.3535F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
}