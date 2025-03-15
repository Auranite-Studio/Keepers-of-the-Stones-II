//package com.esmods.keepersofthestonestwo;
//
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.level.Level;
//
//import java.util.UUID;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class GlowManager {
//    private static final Map<UUID, GlowSettings> SERVER_GLOW_DATA = new ConcurrentHashMap<>();
//
//    public static void setGlow(LivingEntity entity, float red, float green, float blue) {
//        UUID id = entity.getUUID();
//        SERVER_GLOW_DATA.put(id, new GlowSettings(red, green, blue));
//        sendGlowUpdatePacket(entity, true, red, green, blue);
//    }
//
//    public static void removeGlow(LivingEntity entity) {
//        UUID id = entity.getUUID();
//        SERVER_GLOW_DATA.remove(id);
//        sendGlowUpdatePacket(entity, false, 0, 0, 0);
//    }
//
//    private static void sendGlowUpdatePacket(LivingEntity entity, boolean enabled, float r, float g, float b) {
//        if (entity.level().isClientSide) return;
//
//        Level level = entity.level();
//        GlowUpdatePacket packet = new GlowUpdatePacket(entity.getUUID(), enabled, r, g, b);
//
//        for (ServerPlayer player : level.getServer().getPlayerList().getPlayers()) {
//            player.connection.send(NeoForgePayloadHandler.createPacket(GlowUpdatePacket.TYPE, packet));
//        }
//    }
//}