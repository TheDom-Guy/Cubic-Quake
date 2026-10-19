package com.github.thedomguy.cubic_quake.items;

import com.github.thedomguy.cubic_quake.CubicQuake;
import com.github.thedomguy.cubic_quake.ModSounds;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;

public enum Powerups {

    DEFAULT(StatusEffects.ABSORPTION, 20, ModSounds.QUAD_DAMAGE_START),

    QUAD_DAMAGE(CubicQuake.QUAD_DAMAGE_EFFECT, 300, ModSounds.QUAD_DAMAGE_START),
    RING_OF_SHADOWS(StatusEffects.INVISIBILITY, 400, ModSounds.RING_OF_SHADOWS_START),
    PENTAGRAM_OF_PROTECTION(CubicQuake.PENTAGRAM_PROTECTION_EFFECT, 400, ModSounds.PENTAGRAM_OF_PROTECTION_START);

    private final RegistryEntry<StatusEffect> e;
    private final int d;
    private final SoundEvent s;

    Powerups(RegistryEntry<StatusEffect> effect, int duration, SoundEvent startSound) {
        e = effect;
        d = duration;
        s = startSound;
    }

    public RegistryEntry<StatusEffect> EFFECT() {
        return e;
    }

    public int DURATION() {
        return d;
    }

    public SoundEvent STARTSOUND() {
        return s;
    }
}
