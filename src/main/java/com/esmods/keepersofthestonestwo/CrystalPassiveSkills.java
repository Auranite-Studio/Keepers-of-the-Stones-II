package your.modid.common.event;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

import java.util.Set;

@EventBusSubscriber
public class CrystalPassiveSkills {

	private static final Set<BlockState> AMETHYST_BLOCKS = Set.of(
			Blocks.AMETHYST_BLOCK.defaultBlockState(),
			Blocks.BUDDING_AMETHYST.defaultBlockState(),
			Blocks.AMETHYST_CLUSTER.defaultBlockState(),
			Blocks.LARGE_AMETHYST_BUD.defaultBlockState(),
			Blocks.MEDIUM_AMETHYST_BUD.defaultBlockState(),
			Blocks.SMALL_AMETHYST_BUD.defaultBlockState()
	);

	/**
	 * Проверяет, есть ли в радиусе 10 блоков от игрока хотя бы один аметистовый блок.
	 */
	private static boolean hasAmethystNearby(ServerLevel level, BlockPos center) {
		int radius = 16;
		for (int x = -radius; x <= radius; x++) {
			for (int y = -radius; y <= radius; y++) {
				for (int z = -radius; z <= radius; z++) {
					BlockPos pos = center.offset(x, y, z);
					BlockState state = level.getBlockState(pos);
					if (AMETHYST_BLOCKS.contains(state)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@SubscribeEvent
	public static void onPlayerAttacked(LivingDamageEvent.Pre event) {
		LivingEntity target = event.getEntity();
		if (!(target instanceof ServerPlayer player)) return;
		if (!player.hasEffect(PowerModMobEffects.CRYSTAL_MASTER)) return;

		ServerLevel level = (ServerLevel) player.level();
		if (!hasAmethystNearby(level, player.blockPosition())) return;

		LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
		if (attacker instanceof LivingEntity livingAttacker && level.random.nextFloat() < 0.125f) {
			livingAttacker.addEffect(new MobEffectInstance(PowerModMobEffects.STUN, 100));
		}
	}

	@SubscribeEvent
	public static void onPlayerHurt(LivingIncomingDamageEvent event) {
		LivingEntity target = event.getEntity();
		if (!(target instanceof ServerPlayer player)) return;
		if (!player.hasEffect(PowerModMobEffects.CRYSTAL_MASTER)) return;

		ServerLevel level = (ServerLevel) player.level();
		if (!hasAmethystNearby(level, player.blockPosition())) return;

		if (level.random.nextFloat() < 0.10f) {
			event.setCanceled(true);
		}
	}
}