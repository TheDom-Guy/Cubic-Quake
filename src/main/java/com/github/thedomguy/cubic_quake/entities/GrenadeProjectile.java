package com.github.thedomguy.cubic_quake.entities;

import com.github.thedomguy.cubic_quake.CubicQuake;
import com.github.thedomguy.cubic_quake.ModSounds;
import net.minecraft.block.AbstractBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.AdvancedExplosionBehavior;

import java.util.Optional;
import java.util.function.Function;

public class GrenadeProjectile extends WeaponProjectile{
    private boolean canExplodeOnEntity = true;
    private boolean bounce = false;
    private double gravForce = 0.02;
    private double startGrav = 0.02;
    private boolean applyPhysics = true;


    public GrenadeProjectile(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public GrenadeProjectile(World world, PlayerEntity user, float damage) {
        super(ModEntities.GRENADE_PROJECTILE, world, user, damage);
        lifespan = 500;
    }

    @Override
    public void tick() {
        super.tick();
        --lifespan;
        if (lifespan <= 0) {
            explode();
        }

        if (applyPhysics) {
            Vec3d vec3d = this.getVelocity();
            HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
            this.hitOrDeflect(hitResult);
            double d = this.getX() + vec3d.x;
            double e = this.getY() + vec3d.y - gravForce;
            double f = this.getZ() + vec3d.z;
            this.updateRotation();

            if (bounce) {
                bounce = false;
                gravForce = startGrav;
                this.setPosition(getX(), getY() + 0.1, getZ());
            } else {
                gravForce = Math.clamp(gravForce * 1.2, startGrav, 1);

                this.setVelocity(vec3d.multiply(0.99F));
                this.setPosition(d, e, f);
            }
        }

    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity hit = entityHitResult.getEntity();
        if (hit instanceof LivingEntity && !(hit == getOwner()) && canExplodeOnEntity) {
            explode();
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        canExplodeOnEntity = false;
        bounce = true;
        lifespan = Math.clamp(lifespan, 0 ,80) - 5;
        Direction side = blockHitResult.getSide();

        getWorld().playSound(null, getBlockPos(), ModSounds.GRENADE_BOUNCE, SoundCategory.PLAYERS);

        setVelocity(getVelocity().multiply(0.70f));
        if ((getVelocity().x < 0.1 && getVelocity().x > -0.1)
                && (getVelocity().y < 0.1 && getVelocity().y > -0.1)
                && (getVelocity().z < 0.1 && getVelocity().z > -0.1)) {
            applyPhysics = false;
            setVelocity(0, 0, 0);
        }

        switch (side) {
            case UP, DOWN -> setVelocity(getVelocity().multiply(1, -1, 1));
            case EAST, WEST -> setVelocity(getVelocity().multiply(-1, 1, 1));
            case NORTH, SOUTH -> setVelocity(getVelocity().multiply(1, 1, -1));
        }
    }

    private void explode() {
        this.getWorld().createExplosion(
                this,
                ds,
                new AdvancedExplosionBehavior(false, true, Optional.of(1.22F), Registries.BLOCK.getEntryList(BlockTags.BLOCKS_WIND_CHARGE_EXPLOSIONS).map(Function.identity())),
                this.getX(),
                this.getY(),
                this.getZ(),
                2F,
                false,
                World.ExplosionSourceType.TRIGGER,
                ParticleTypes.EXPLOSION,
                ParticleTypes.EXPLOSION_EMITTER,
                SoundEvents.ENTITY_GENERIC_EXPLODE);
        this.discard();
    }
}
