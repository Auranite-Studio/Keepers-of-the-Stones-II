**New features**
- Added level system
- Added characteristic card
- Added new achievement - Become like an adventurer
- Added a new effect - Curse
- The curse effect reduces some of the player's stats, as well as dealing 6 damage and impairing visibility by creating a cursed fog
- Cursed forest will now give curse effect instead of wither effect
- Curse does not affect players with activated stones or batteries
- The curse effect is given regardless of difficulty

**Improvemnts:**
- Increased the Cursed Keeper's health to 700
- Cursed mobs are now invulnerable to the wither
- Reworked the warp effect, it now makes the player twice as low
- The abilities of the master of earth and metal no longer consume resources
- Shooting blocks of earth and metal now also determines the block in the second hand
- Star points will now not be restored when the power lock effect is active
- All mobs now have the format of vanilla java models
- The GeckoLib and pehkui mods is no longer needed


**API changes**
- Colorful Powers API has been updated to version 23
- Added variables level, level_exp and max_level_exp for control levels
- Added variable base_damage_by_lvl for dynamic change magical abilities damage
- Added a new field to the config file - enable_levels
- Removed the lines in the config that control the duration of the stones and their recharge
- The mod's game rules have been removed, with all their functionality moved to the config
- Removed variable ``golden_dust_extended_powers``
- Removed variable ``allow_custom_element_powers_for_stones``

**Bugfixes**
- [Bugfix] Fixed a bug that caused star regeneration potion to not speed up the recovery of star points
- [Bugfix] Fixed a bug that made the cursed keeper vulnerable to potion effects

**Known issues**
- *N/A*