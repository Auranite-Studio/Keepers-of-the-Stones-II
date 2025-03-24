package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.BufferBuilder;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class ShapeRepulsorBarProcedure {
	private static BufferBuilder bufferBuilder = null;
	private static VertexBuffer vertexBuffer = null;
	private static VertexFormat.Mode mode = null;
	private static VertexFormat format = null;

	private static void add(float x, float y, float z, int color) {
		add(x, y, z, 0.0F, 0.0F, color);
	}

	private static void add(float x, float y, float z, float u, float v, int color) {
		if (bufferBuilder == null)
			return;
		if (format == DefaultVertexFormat.POSITION_COLOR) {
			bufferBuilder.addVertex(x, y, z).setColor(color);
		} else if (format == DefaultVertexFormat.POSITION_TEX_COLOR) {
			bufferBuilder.addVertex(x, y, z).setUv(u, v).setColor(color);
		}
	}

	private static boolean begin(VertexFormat.Mode mode, VertexFormat format, boolean update) {
		if (ShapeRepulsorBarProcedure.bufferBuilder == null) {
			if (update)
				clear();
			if (ShapeRepulsorBarProcedure.vertexBuffer == null) {
				if (format == DefaultVertexFormat.POSITION_COLOR) {
					ShapeRepulsorBarProcedure.mode = mode;
					ShapeRepulsorBarProcedure.format = format;
					ShapeRepulsorBarProcedure.bufferBuilder = Tesselator.getInstance().begin(mode, DefaultVertexFormat.POSITION_COLOR);
					return true;
				} else if (format == DefaultVertexFormat.POSITION_TEX_COLOR) {
					ShapeRepulsorBarProcedure.mode = mode;
					ShapeRepulsorBarProcedure.format = format;
					ShapeRepulsorBarProcedure.bufferBuilder = Tesselator.getInstance().begin(mode, DefaultVertexFormat.POSITION_TEX_COLOR);
					return true;
				}
			}
		}
		return false;
	}

	private static void clear() {
		if (vertexBuffer != null) {
			vertexBuffer.close();
			vertexBuffer = null;
		}
	}

	private static void end() {
		if (bufferBuilder == null)
			return;
		if (vertexBuffer != null)
			vertexBuffer.close();
		MeshData meshData = bufferBuilder.build();
		if (meshData == null) {
			vertexBuffer = null;
			bufferBuilder = null;
		} else {
			vertexBuffer = new VertexBuffer(VertexBuffer.Usage.STATIC);
			vertexBuffer.bind();
			vertexBuffer.upload(meshData);
			VertexBuffer.unbind();
			bufferBuilder = null;
		}
	}

	private static VertexBuffer shape() {
		return vertexBuffer;
	}

	public static VertexBuffer execute(Entity entity) {
		return execute(null, entity);
	}

	private static VertexBuffer execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return null;
		double width = 0;
		double progress = 0;
		progress = Mth.clamp((entity.getData(PowerModVariables.PLAYER_VARIABLES).power / 100), 0, 1);
		width = 102 * progress;
		if (begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR, true)) {
			add(0, 0, 0, 0, 0, 255 << 24 | 255 << 16 | 255 << 8 | 255);
			add(0, 5, 0, 0, 1, 255 << 24 | 255 << 16 | 255 << 8 | 255);
			add((float) width, 5, 0, (float) progress, 1, 255 << 24 | 255 << 16 | 255 << 8 | 255);
			add((float) width, 0, 0, (float) progress, 0, 255 << 24 | 255 << 16 | 255 << 8 | 255);
			end();
		}
		return shape();
	}
}
