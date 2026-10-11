package com.github.thedomguy.cubic_quake.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.world.World;

public class SuperShotBlast extends ShotBlast{
    public SuperShotBlast(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public SuperShotBlast(World world, PlayerEntity user, float damage) {
        super(world, user, damage);
    }

    @Override
    protected int getPelletsAmount() {
        return 8;
    }
}
