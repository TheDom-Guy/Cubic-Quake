package com.github.thedomguy.cubic_quake.entities;

import com.github.thedomguy.cubic_quake.CubicQuake;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class WeaponProjectile extends ProjectileEntity {

    public float dmg = 0;
    protected int lifespan = 100;
    public DamageSource ds = new DamageSource(this.getDamageSources().registry.entryOf(CubicQuake.CUBIC_QUAKE_DAMAGE));

    public WeaponProjectile(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public WeaponProjectile(EntityType<? extends ProjectileEntity> entityType, World world, PlayerEntity user, float damage) {
        super(entityType, world);

        dmg = damage;
        setOwner(user);

        ds = new DamageSource(this.getDamageSources().registry.entryOf(CubicQuake.CUBIC_QUAKE_DAMAGE), getOwner());

        float f = -MathHelper.sin(user.getYaw() * ((float)Math.PI / 180F)) * MathHelper.cos(user.getPitch() * ((float)Math.PI / 180F));
        float g = -MathHelper.sin(user.getPitch() * ((float)Math.PI / 180F));
        float h = MathHelper.cos(user.getYaw() * ((float)Math.PI / 180F)) * MathHelper.cos(user.getPitch() * ((float)Math.PI / 180F));
        this.setVelocity(f, g, h, getSpeed(), 0);

        setPosition(user.getPos().add(0, 1.4, 0));
    }

    protected float getSpeed() {
        return 1;
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


    public interface Factory<T extends WeaponProjectile> {
        T create(World world, PlayerEntity user, float damage);
    }
}
