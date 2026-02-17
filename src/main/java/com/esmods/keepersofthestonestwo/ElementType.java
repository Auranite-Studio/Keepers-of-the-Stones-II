package com.esmods.keepersofthestonestwo;

import java.util.Arrays;
import java.util.Optional;

public enum ElementType {
    FIRE("power:fire_dmg"),

    PHYSICAL("power:physical_dmg");

    private final String damageTypeId;

    ElementType(String damageTypeId) {
        this.damageTypeId = damageTypeId;
    }
    public String getDamageTypeId() {
        return damageTypeId;
    }

    public static Optional<ElementType> fromDamageTypeId(String id) {
        return Arrays.stream(values())
                .filter(type -> type.getDamageTypeId().equals(id))
                .findFirst();
    }
}