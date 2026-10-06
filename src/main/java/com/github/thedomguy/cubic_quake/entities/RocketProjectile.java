package com.github.thedomguy.cubic_quake.entities;

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
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.AdvancedExplosionBehavior;
import net.minecraft.world.explosion.Explosion;

import java.util.Optional;
import java.util.function.Function;

public class RocketProjectile extends WeaponProjectile{
    public RocketProjectile(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public RocketProjectile(World world, PlayerEntity user, float damage) {
        super(ModEntities.ROCKET_PROJECTILE, world, user, damage);
    }

    @Override
    protected float getSpeed() {
        return 2;
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
        if (this.getWorld().getStatesInBox(this.getBoundingBox()).noneMatch(AbstractBlock.AbstractBlockState::isAir)) {
            this.discard();
        } else {
            this.setVelocity(vec3d.multiply(0.99F));
            this.setPosition(d, e, f);
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity hit = entityHitResult.getEntity();
        if (hit instanceof LivingEntity && !(hit == getOwner())) {
            explode();


            this.discard();
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        explode();
    }

    private void explode() {
        this.getWorld().createExplosion(
                this,
                ds,
                new AdvancedExplosionBehavior(false, true, Optional.of(1.22F), Registries.BLOCK.getEntryList(BlockTags.BLOCKS_WIND_CHARGE_EXPLOSIONS).map(Function.identity())),
                this.getX(),
                this.getY(),
                this.getZ(),
                1F,
                false,
                World.ExplosionSourceType.TRIGGER,
                ParticleTypes.EXPLOSION,
                ParticleTypes.EXPLOSION_EMITTER,
                SoundEvents.ENTITY_GENERIC_EXPLODE);
    }
}
