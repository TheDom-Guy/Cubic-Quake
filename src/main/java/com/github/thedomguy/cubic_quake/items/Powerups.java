package com.github.thedomguy.cubic_quake.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.registry.entry.RegistryEntry;

public enum Powerups {

    DEFAULT(StatusEffects.ABSORPTION, 20),

    QUAD_DAMAGE(StatusEffects.STRENGTH, 200),
    RING_OF_SHADOWS(StatusEffects.INVISIBILITY, 400),
    PENTAGRAM_OF_PROTECTION(StatusEffects.ABSORPTION, 400);

    private final RegistryEntry<StatusEffect> e;
    private final int d;

    Powerups(RegistryEntry<StatusEffect> effect,int duration) {
        e = effect;
        d = duration;
    }

    public RegistryEntry<StatusEffect> EFFECT() {
        return e;
    }

    public int DURATION() {
        return d;
    }
}
