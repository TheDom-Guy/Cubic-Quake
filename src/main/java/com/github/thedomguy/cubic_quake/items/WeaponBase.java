package com.github.thedomguy.cubic_quake.items;

import com.github.thedomguy.cubic_quake.CubicQuake;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WeaponBase extends Item {

    private final int damage = 0;
    private final Item ammo = Items.ARROW;
    private final int firerate = 20;
    private final EntityType projectile = EntityType.ARROW;
    private final int ammoConsuption = 1;

    private int fireDelay = 0;

    public WeaponBase(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world instanceof ServerWorld serverWorld) {

            if (fireDelay <= 0) {
                if (user.getOffHandStack().getItem() == ammo) {
                    fireDelay = firerate;
                    if (!user.isCreative()) {
                        user.getOffHandStack().decrement(ammoConsuption);
                    }
                    projectile.spawn(serverWorld, user.getBlockPos(), SpawnReason.TRIGGERED);
                }
            }
        }

        return TypedActionResult.success(this.getDefaultStack());
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (fireDelay > 0) {
            fireDelay -= 1;
        }
    }
}
