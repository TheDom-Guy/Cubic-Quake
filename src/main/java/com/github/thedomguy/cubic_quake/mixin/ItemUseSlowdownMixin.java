package com.github.thedomguy.cubic_quake.mixin;

import com.github.thedomguy.cubic_quake.items.WeaponItem;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

//I'll be honest, Google's AI helped here
@Mixin(ClientPlayerEntity.class)
public class ItemUseSlowdownMixin {
    @Redirect(
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;isUsingItem()Z"),
            method = "tickMovement")
    private boolean init(ClientPlayerEntity player) {
        return player.isUsingItem() && !(player.getMainHandStack().getItem() instanceof WeaponItem);
    }
}
