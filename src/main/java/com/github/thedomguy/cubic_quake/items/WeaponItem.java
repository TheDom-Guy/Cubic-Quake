package com.github.thedomguy.cubic_quake.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WeaponItem extends Item {

    private final int damage;
    private final Item ammo;
    private final int firerate;
    private final EntityType projectile;
    private final int ammoConsumption;

    private int fireDelay = 0;

    public WeaponItem(Settings settings, Weapons weapon) {
        super(settings);
        damage = weapon.DAMAGE();
        ammo = weapon.AMMO();
        firerate = weapon.FIRERATE();
        projectile = weapon.PROJECTILE();
        ammoConsumption = weapon.AMMO_CONSUMPTION();
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world instanceof ServerWorld serverWorld) {

            if (fireDelay <= 0) {
                if (user.getOffHandStack().getItem() == ammo) {
                    fireDelay = firerate;
                    if (!user.isCreative()) {
                        user.getOffHandStack().decrement(ammoConsumption);
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
