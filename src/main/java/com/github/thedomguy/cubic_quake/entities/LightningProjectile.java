package com.github.thedomguy.cubic_quake.entities;

import com.github.thedomguy.cubic_quake.CubicQuake;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LightningProjectile extends WeaponProjectile{
    public LightningProjectile(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public LightningProjectile(World world, PlayerEntity user, float damage) {
        super(ModEntities.LIGHTNING_PROJECTILE, world, user, damage);
    }

    @Override
    protected float getSpeed() {
        return 7;
    }

    @Override
    public void tick() {
        super.tick();
        --lifespan;
        if (lifespan <= 0) {
            this.discard();
        }

        if (!getWorld().isClient) {
            ((ServerWorld)getWorld()).spawnParticles(ParticleTypes.CRIT, this.getX(), this.getY(), this.getZ(), 3, 0,0,0,0);
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
    protected void onBlockHit(BlockHitResult blockHitResult) {
        discard();

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
