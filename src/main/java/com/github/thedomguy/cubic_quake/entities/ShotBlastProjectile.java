package com.github.thedomguy.cubic_quake.entities;

import com.github.thedomguy.cubic_quake.CubicQuake;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class ShotBlastProjectile extends WeaponProjectile{
    public ShotBlastProjectile(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public ShotBlastProjectile(World world, PlayerEntity user, float damage) {
        super(ModEntities.SHOT_BLAST_PROJECTILE, world, user, damage);
        lifespan = 20;


        EntityHitResult hitResult = ProjectileUtil.raycast(user, user.getEyePos(), user.getEyePos().add(10, 0, 0), new Box(user.getBlockPos()).stretch(2, 2, 2), entity -> entity instanceof LivingEntity, 10);
         if (hitResult != null) {
             CubicQuake.print(hitResult.getEntity().toString());
             hitResult.getEntity().damage(ds, 100);
         }


    }

    @Override
    protected float getSpeed() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        --lifespan;
        if (lifespan <= 0) {
            this.discard();
        }
    }
}
