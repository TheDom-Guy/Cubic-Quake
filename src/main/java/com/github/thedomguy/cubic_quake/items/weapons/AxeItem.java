package com.github.thedomguy.cubic_quake.items.weapons;

import com.github.thedomguy.cubic_quake.CubicQuake;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;

public class AxeItem extends Item {
    public AxeItem(Settings settings) {
        super(settings);
    }

    @Override
    public float getBonusAttackDamage(Entity target, float baseAttackDamage, DamageSource damageSource) {

        PlayerEntity attacker = (PlayerEntity) damageSource.getAttacker();
        if (attacker != null && attacker.hasStatusEffect(CubicQuake.QUAD_DAMAGE_EFFECT)) {
            return baseAttackDamage * 3;
        } else {
            return 0;
        }

    }
}
