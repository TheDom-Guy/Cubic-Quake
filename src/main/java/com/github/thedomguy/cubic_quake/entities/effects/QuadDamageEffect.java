package com.github.thedomguy.cubic_quake.entities.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class QuadDamageEffect extends StatusEffect {
    public QuadDamageEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x272733);
    }
}
