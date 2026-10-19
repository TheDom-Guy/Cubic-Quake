package com.github.thedomguy.cubic_quake.items;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PowerupItem extends Item {

    private final RegistryEntry<StatusEffect> effect;
    private final int duration;
    private final SoundEvent startSound;

    public PowerupItem(Settings settings, Powerups powerup) {
        super(settings.maxCount(1));

        effect = powerup.EFFECT();
        duration = powerup.DURATION();
        startSound = powerup.STARTSOUND();
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        StatusEffectInstance instance = new StatusEffectInstance(effect, duration, 0, false, true, true);
        user.addStatusEffect(instance);

        if (world instanceof ServerWorld serverWorld) {
            serverWorld.playSoundFromEntity(null, user, startSound, SoundCategory.PLAYERS, 0.6f, 1);
        }

        if (!user.isCreative()) {
            itemStack.decrement(1);
        }

        return TypedActionResult.pass(itemStack);
    }
}
