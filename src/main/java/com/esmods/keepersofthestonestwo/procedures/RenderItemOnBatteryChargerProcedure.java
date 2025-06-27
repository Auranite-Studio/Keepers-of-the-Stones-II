package com.esmods.keepersofthestonestwo.procedures;

import org.joml.Vector3f;
import org.joml.Matrix4f;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.SectionPos;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.block.model.BlockStateModel;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.gui.Font;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

import com.esmods.keepersofthestonestwo.init.PowerModBlocks;

@EventBusSubscriber(value = Dist.CLIENT)
public class RenderItemOnBatteryChargerProcedure {
	private static RenderLevelStageEvent provider = null;
	private static Map<EntityType, Entity> data = new HashMap<>();

	public static void renderBackground(String texts, double x, double y, double z, float yaw, float pitch, float roll, float scale, int color) {
		Minecraft minecraft = Minecraft.getInstance();
		Font font = minecraft.font;
		MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
		Vec3 pos = provider.getCamera().getPosition();
		PoseStack poseStack = provider.getPoseStack();
		poseStack.pushPose();
		poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
		poseStack.mulPose(com.mojang.math.Axis.YN.rotationDegrees(yaw));
		poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(pitch));
		poseStack.mulPose(com.mojang.math.Axis.ZN.rotationDegrees(roll));
		poseStack.scale(scale, -scale, 1.0F);
		poseStack.translate((font.width(texts) - 1) * -0.5F, (font.lineHeight - 1) * -0.5F, 0.0F);
		Matrix4f matrix4f = poseStack.last().pose();
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		font.drawInBatch(texts, 0.0F, 0.0F, 0, false, matrix4f, bufferSource, Font.DisplayMode.SEE_THROUGH, color, LightTexture.FULL_BRIGHT);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
	}

	public static void renderBlock(BlockState blockState, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing) {
		BlockPos blockPos = BlockPos.containing(x, y, z);
		Vec3 pos = provider.getCamera().getPosition();
		int packedLight = glowing ? LightTexture.FULL_BRIGHT : LevelRenderer.getLightColor(Minecraft.getInstance().level, blockPos);
		PoseStack poseStack = provider.getPoseStack();
		poseStack.pushPose();
		poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
		poseStack.mulPose(com.mojang.math.Axis.YN.rotationDegrees(yaw));
		poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(pitch));
		poseStack.mulPose(com.mojang.math.Axis.ZN.rotationDegrees(roll));
		poseStack.scale(scale, scale, scale);
		poseStack.translate(-0.5F, -0.5F, -0.5F);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		renderBlockModel(blockState, blockPos, poseStack, packedLight);
		renderBlockEntity(blockState, blockPos, poseStack, packedLight);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
	}

	private static void renderBlockEntity(BlockState blockState, BlockPos blockPos, PoseStack poseStack, int packedLight) {
		if (blockState.getBlock() instanceof EntityBlock entityBlock) {
			Minecraft minecraft = Minecraft.getInstance();
			ClientLevel level = minecraft.level;
			BlockEntity blockEntity = entityBlock.newBlockEntity(blockPos, blockState);
			if (blockEntity != null) {
				BlockEntityRenderer blockEntityRenderer = minecraft.getBlockEntityRenderDispatcher().getRenderer(blockEntity);
				if (blockEntityRenderer != null) {
					MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
					blockEntity.setLevel(level);
					blockEntityRenderer.render(blockEntity, 0.0F, poseStack, bufferSource, packedLight, OverlayTexture.NO_OVERLAY, new Vec3(blockPos));
				}
			}
		}
	}

	private static void renderBlockModel(BlockState blockState, BlockPos blockPos, PoseStack poseStack, int packedLight) {
		if (blockState.getRenderShape() == RenderShape.MODEL) {
			Minecraft minecraft = Minecraft.getInstance();
			ClientLevel level = minecraft.level;
			MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
			BlockRenderDispatcher dispatcher = minecraft.getBlockRenderer();
			ModelBlockRenderer renderer = dispatcher.getModelRenderer();
			List<BakedQuad> bakedModel = (List<BakedQuad>) dispatcher.getBlockModel(blockState);
			PoseStack.Pose pose = poseStack.last();
			int color = minecraft.getBlockColors().getColor(blockState, level, blockPos);
			float red = (color >> 16 & 255) / 255.0F;
			float green = (color >> 8 & 255) / 255.0F;
			float blue = (color & 255) / 255.0F;
			{
				renderer.renderModel(pose, bufferSource.getBuffer(Sheets.translucentItemSheet()), (BlockStateModel) blockState, red, green, blue, packedLight, OverlayTexture.NO_OVERLAY);
			}
		}
	}

	public static void renderEntity(EntityType type, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing) {
		if (type == null)
			return;
		Entity entity = null;
		ClientLevel level = Minecraft.getInstance().level;
		renderEntity(entity, 0.0F, x, y, z, yaw, pitch, roll, scale, glowing ? LightTexture.FULL_BRIGHT : LevelRenderer.getLightColor(level, BlockPos.containing(x, y, z)));
	}

	public static void renderEntity(Entity entity, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing) {
		float partialTick = provider.getPartialTick().getGameTimeDeltaPartialTick(false);
		int packedLight = glowing ? LightTexture.FULL_BRIGHT : Minecraft.getInstance().getEntityRenderDispatcher().getPackedLightCoords(entity, partialTick);
		renderEntity(entity, partialTick, x, y, z, yaw, pitch, roll, scale, packedLight);
	}

	private static void renderEntity(Entity entity, float partialTick, double x, double y, double z, float yaw, float pitch, float roll, float scale, int packedLight) {
		if (entity == null)
			return;
		Minecraft minecraft = Minecraft.getInstance();
		MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
		EntityRenderer renderer = minecraft.getEntityRenderDispatcher().getRenderer(entity);
		Vec3 pos = provider.getCamera().getPosition();
		float offset = (entity.getBbHeight() / 2.0F) * scale;
		PoseStack poseStack = provider.getPoseStack();
		poseStack.pushPose();
		poseStack.translate(x - pos.x(), y + offset - pos.y(), z - pos.z());
		poseStack.mulPose(com.mojang.math.Axis.YN.rotationDegrees(yaw));
		poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(pitch));
		poseStack.mulPose(com.mojang.math.Axis.ZN.rotationDegrees(roll));
		poseStack.translate(0.0F, -offset, 0.0F);
		poseStack.scale(scale, scale, scale);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		renderer.render(new EntityRenderState(), poseStack, bufferSource, packedLight);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
	}

	public static void renderItem(ItemStack itemStack, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing, boolean b) {
		Minecraft minecraft = Minecraft.getInstance();
		MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
		ItemRenderer renderer = minecraft.getItemRenderer();
		Vec3 pos = provider.getCamera().getPosition();
		int packedLight = glowing ? LightTexture.FULL_BRIGHT : LevelRenderer.getLightColor(minecraft.level, BlockPos.containing(x, y, z));
		PoseStack poseStack = provider.getPoseStack();
		poseStack.pushPose();
		poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
		poseStack.mulPose(com.mojang.math.Axis.YN.rotationDegrees(yaw));
		poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(pitch));
		poseStack.mulPose(com.mojang.math.Axis.ZN.rotationDegrees(roll));
		poseStack.scale(scale, scale, scale);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		renderer.renderStatic(null, itemStack, ItemDisplayContext.FIXED, poseStack, bufferSource, minecraft.level, packedLight, OverlayTexture.NO_OVERLAY, 0);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
	}

	public static void renderLine(double x1, double y1, double z1, double x2, double y2, double z2, int color) {
		MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
		Vec3 pos = provider.getCamera().getPosition();
		Vector3f normal = new Vec3(x2 - x1, y2 - y1, z2 - z1).normalize().toVector3f();
		Matrix4f matrix4f = provider.getPoseStack().last().pose();
		VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.lines());
		vertexConsumer.addVertex(matrix4f, (float) (x1 - pos.x()), (float) (y1 - pos.y()), (float) (z1 - pos.z())).setColor(color).setNormal(normal.x(), normal.y(), normal.z());
		vertexConsumer.addVertex(matrix4f, (float) (x2 - pos.x()), (float) (y2 - pos.y()), (float) (z2 - pos.z())).setColor(color).setNormal(normal.x(), normal.y(), normal.z());
	}

	public static void renderTexts(String texts, double x, double y, double z, float yaw, float pitch, float roll, float scale, int color, boolean glowing) {
		Minecraft minecraft = Minecraft.getInstance();
		Font font = minecraft.font;
		MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
		Vec3 pos = provider.getCamera().getPosition();
		int packedLight = glowing ? LightTexture.FULL_BRIGHT : LevelRenderer.getLightColor(minecraft.level, BlockPos.containing(x, y, z));
		PoseStack poseStack = provider.getPoseStack();
		poseStack.pushPose();
		poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
		poseStack.mulPose(com.mojang.math.Axis.YN.rotationDegrees(yaw));
		poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(pitch));
		poseStack.mulPose(com.mojang.math.Axis.ZN.rotationDegrees(roll));
		poseStack.scale(scale, -scale, 1.0F);
		poseStack.translate((font.width(texts) - 1) * -0.5F, (font.lineHeight - 1) * -0.5F, 0.0F);
		Matrix4f matrix4f = poseStack.last().pose();
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		font.drawInBatch(texts, 0.0F, 0.0F, color, false, matrix4f, bufferSource, Font.DisplayMode.NORMAL, 0, packedLight);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
	}

	@SubscribeEvent
	public static void renderModels(RenderLevelStageEvent event) {
		provider = event;
		if (provider.getStage() == RenderLevelStageEvent.Stage.AFTER_ENTITIES) {
			ClientLevel level = Minecraft.getInstance().level;
			Entity entity = provider.getCamera().getEntity();
			Vec3 pos = entity.getPosition(provider.getPartialTick().getGameTimeDeltaPartialTick(false));
			execute(provider, level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		if (world instanceof ClientLevel _blockEntityContext) {
			int _scanRange = Minecraft.getInstance().options.getEffectiveRenderDistance();
			BlockPos _scanCenter = Minecraft.getInstance().player.blockPosition();
			LevelChunk _levelChunk;
			BlockState blockstateiterator;
			int positionx, positiony, positionz;
			for (int _chunkZ = -_scanRange; _chunkZ <= _scanRange; ++_chunkZ) {
				for (int _chunkX = -_scanRange; _chunkX <= _scanRange; ++_chunkX) {
					_levelChunk = _blockEntityContext.getChunk(SectionPos.blockToSectionCoord(_scanCenter.getX() + (_chunkX << 4)), SectionPos.blockToSectionCoord(_scanCenter.getZ() + (_chunkZ << 4)));
					if (_levelChunk != null) {
						for (Map.Entry<BlockPos, BlockEntity> _blockEntityEntry : _levelChunk.getBlockEntities().entrySet()) {
							blockstateiterator = _blockEntityEntry.getValue().getBlockState();
							positionx = _blockEntityEntry.getKey().getX();
							positiony = _blockEntityEntry.getKey().getY();
							positionz = _blockEntityEntry.getKey().getZ();
							if ((world.getBlockState(new BlockPos(positionx, positiony, positionz))).getBlock() == PowerModBlocks.BATTERY_CHARGER.get()) {
								if ((getBlockDirection(world, new BlockPos(positionx, positiony, positionz))) == Direction.NORTH) {
									if (!((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 2).copy()).getItem() == ItemStack.EMPTY.getItem())) {
										renderItem((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 2).copy()), (positionx + 0.5), (positiony + 1), (positionz + 0.5), 0, 90, 0, (float) 0.5, true, false);
									} else if (!((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 0).copy()).getItem() == ItemStack.EMPTY.getItem())) {
										renderItem((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 0).copy()), (positionx + 0.5), (positiony + 1), (positionz + 0.5), 0, 90, 0, (float) 0.5, true, false);
									}
								} else if ((getBlockDirection(world, new BlockPos(positionx, positiony, positionz))) == Direction.SOUTH) {
									if (!((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 2).copy()).getItem() == ItemStack.EMPTY.getItem())) {
										renderItem((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 2).copy()), (positionx + 0.5), (positiony + 1), (positionz + 0.5), 180, 90, 0, (float) 0.5, true, false);
									} else if (!((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 0).copy()).getItem() == ItemStack.EMPTY.getItem())) {
										renderItem((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 0).copy()), (positionx + 0.5), (positiony + 1), (positionz + 0.5), 180, 90, 0, (float) 0.5, true, false);
									}
								} else if ((getBlockDirection(world, new BlockPos(positionx, positiony, positionz))) == Direction.WEST) {
									if (!((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 2).copy()).getItem() == ItemStack.EMPTY.getItem())) {
										renderItem((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 2).copy()), (positionx + 0.5), (positiony + 1), (positionz + 0.5), -90, 90, 0, (float) 0.5, true, false);
									} else if (!((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 0).copy()).getItem() == ItemStack.EMPTY.getItem())) {
										renderItem((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 0).copy()), (positionx + 0.5), (positiony + 1), (positionz + 0.5), -90, 90, 0, (float) 0.5, true, false);
									}
								} else if ((getBlockDirection(world, new BlockPos(positionx, positiony, positionz))) == Direction.EAST) {
									if (!((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 2).copy()).getItem() == ItemStack.EMPTY.getItem())) {
										renderItem((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 2).copy()), (positionx + 0.5), (positiony + 1), (positionz + 0.5), 90, 90, 0, (float) 0.5, true, false);
									} else if (!((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 0).copy()).getItem() == ItemStack.EMPTY.getItem())) {
										renderItem((itemFromBlockInventory(world, new BlockPos(positionx, positiony, positionz), 0).copy()), (positionx + 0.5), (positiony + 1), (positionz + 0.5), 90, 90, 0, (float) 0.5, true, false);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private static Direction getBlockDirection(LevelAccessor world, BlockPos pos) {
		BlockState blockState = world.getBlockState(pos);
		Property<?> property = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (property != null && blockState.getValue(property) instanceof Direction direction)
			return direction;
		else if (blockState.hasProperty(BlockStateProperties.AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
		else if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
		return Direction.NORTH;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}