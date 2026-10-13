package com.github.thedomguy.cubic_quake.entities.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class PentagramProtectionEffect extends StatusEffect {
    private LivingEntity holder;

    public PentagramProtectionEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x770000);
    }

  /*  @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        entity.setInvulnerable(true);
        holder = entity;
    }

    @Override
    public void onRemoved(AttributeContainer attributeContainer) {
        if (holder != null) {
            holder.setInvulnerable(false);
        }
    }*/
}
