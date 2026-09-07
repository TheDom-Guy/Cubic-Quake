package com.github.thedomguy.cubic_quake.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.world.World;

public class WeaponProjectile extends ProjectileEntity {

    protected float dmg = 0;

    public WeaponProjectile(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public void setUp(float damage, PlayerEntity user) {
        dmg = damage;
        setVelocity(user, user.getPitch(), user.getYaw(), 0, 1, 0);
        setPosition(user.getPos().add(0, 1, 0));
    }




    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }

    @Override
    protected double getGravity() {
        return 0;
    }

    @Override
    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        double d = packet.getVelocityX();
        double e = packet.getVelocityY();
        double f = packet.getVelocityZ();

        this.setVelocity(d, e, f);
    }
}
