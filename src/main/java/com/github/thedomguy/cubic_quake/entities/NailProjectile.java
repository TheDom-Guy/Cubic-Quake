package com.github.thedomguy.cubic_quake.entities;

import net.minecraft.block.AbstractBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class NailProjectile extends WeaponProjectile{
    public NailProjectile(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public NailProjectile(World world, PlayerEntity user, float damage) {
        super(ModEntities.NAIL_PROJECTILE, world, user, damage);
    }

    @Override
    protected float getSpeed() {
        return 3;
    }

    @Override
    public void tick() {
        super.tick();
        --lifespan;
        if (lifespan <= 0) {
            this.discard();
        }

        Vec3d vec3d = this.getVelocity();
        HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
        this.hitOrDeflect(hitResult);
        double d = this.getX() + vec3d.x;
        double e = this.getY() + vec3d.y;
        double f = this.getZ() + vec3d.z;
        this.updateRotation();

        this.setVelocity(vec3d.multiply(0.99F));
        this.setPosition(d, e, f);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity hit = entityHitResult.getEntity();
        if (hit instanceof LivingEntity && !(hit == getOwner())) {
            hit.damage(ds, dmg);

            this.discard();
        }
    }
}
