package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class RandomPowerGetProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double RandomPower = 0;
		String element = "";
		RandomPower = Mth.nextInt(RandomSource.create(), 1, (int) (PowerModVariables.MapVariables.get(world).allow_custom_element_powers_for_stones ? 47 : 46));
		if (RandomPower == 1) {
			element = "fire";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 2) {
			element = "air";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 3) {
			element = "earth";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 4) {
			element = "water";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 5) {
			element = "ether";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 6) {
			element = "ice";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 7) {
			element = "lightning";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 8) {
			element = "sound";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 9) {
			element = "crystal";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 10) {
			element = "lava";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 11) {
			element = "rain";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 12) {
			element = "tornado";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 13) {
			element = "ocean";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 14) {
			element = "plants";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 15) {
			element = "animals";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 16) {
			element = "metal";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 17) {
			element = "light";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 18) {
			element = "shadow";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 19) {
			element = "vacuum";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 20) {
			element = "energy";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 21) {
			element = "sun";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 22) {
			element = "moon";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 23) {
			element = "space";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 24) {
			element = "time";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 25) {
			element = "creation";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 26) {
			element = "destruction";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 27) {
			element = "blood";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 28) {
			element = "technology";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 29) {
			element = "teleportation";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 30) {
			element = "explosion";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 31) {
			element = "amber";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 32) {
			element = "mist";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 33) {
			element = "sand";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 34) {
			element = "speed";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 35) {
			element = "poison";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 36) {
			element = "magnet";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 37) {
			element = "mushrooms";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 38) {
			element = "mercury";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 39) {
			element = "music";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 40) {
			element = "plague";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 41) {
			element = "blue_flame";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 42) {
			element = "gravity";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 43) {
			element = "smoke";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 44) {
			element = "spirit";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 45) {
			element = "form";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 46) {
			element = "mind";
			if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals("0")
					&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals("0")
					&& ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_third).equals("0")) {
				if (!((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_first).equals(element)
						&& !((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).fake_element_name_second).equals(element)) {
					{
						String _setval = element;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (RandomPower == 47) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.golden_dust_extended_powers = true;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
