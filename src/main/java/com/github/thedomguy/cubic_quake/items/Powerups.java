package com.github.thedomguy.cubic_quake.items;

import com.github.thedomguy.cubic_quake.CubicQuake;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;

public enum Powerups {

    DEFAULT(StatusEffects.ABSORPTION, 20),

    QUAD_DAMAGE(CubicQuake.QUAD_DAMAGE_EFFECT, 300),
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
