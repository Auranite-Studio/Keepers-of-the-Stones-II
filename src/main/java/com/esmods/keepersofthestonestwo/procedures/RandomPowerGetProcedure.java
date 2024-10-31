package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class RandomPowerGetProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double RandomPower = 0;
		String element = "";
		RandomPower = Mth.nextInt(RandomSource.create(), 1, 46);
		if (RandomPower == 1) {
			element = "fire";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 2) {
			element = "air";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 3) {
			element = "earth";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 4) {
			element = "water";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 5) {
			element = "ether";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 6) {
			element = "ice";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 7) {
			element = "lightning";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 8) {
			element = "sound";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 9) {
			element = "crystal";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 10) {
			element = "lava";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 11) {
			element = "rain";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 12) {
			element = "tornado";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 13) {
			element = "ocean";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 14) {
			element = "plants";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 15) {
			element = "animals";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 16) {
			element = "metal";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 17) {
			element = "light";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 18) {
			element = "shadow";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 19) {
			element = "vacuum";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 20) {
			element = "energy";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 21) {
			element = "sun";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 22) {
			element = "moon";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 23) {
			element = "space";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 24) {
			element = "time";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 25) {
			element = "creation";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 26) {
			element = "destruction";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 27) {
			element = "blood";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 28) {
			element = "technology";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 29) {
			element = "teleportation";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 30) {
			element = "explosion";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 31) {
			element = "amber";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 32) {
			element = "mist";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 33) {
			element = "sand";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 34) {
			element = "speed";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 35) {
			element = "poison";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 36) {
			element = "magnet";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 37) {
			element = "mushrooms";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 38) {
			element = "mercury";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 39) {
			element = "music";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 40) {
			element = "plague";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 41) {
			element = "blue_flame";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 42) {
			element = "gravity";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 43) {
			element = "smoke";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 44) {
			element = "spirit";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 45) {
			element = "form";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} else if (RandomPower == 46) {
			element = "mind";
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0") && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")
					&& (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0")) {
				if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals(element) && !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals(element)) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = element;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
	}
}
