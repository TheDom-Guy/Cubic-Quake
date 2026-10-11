package com.github.thedomguy.cubic_quake.entities;

import com.github.thedomguy.cubic_quake.CubicQuake;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

public class ShotBlast extends WeaponProjectile{
    public ShotBlast(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public ShotBlast(World world, PlayerEntity user, float damage) {
        super(ModEntities.SHOT_BLAST, world, user, damage);
        lifespan = 20;


      /*  EntityHitResult hitResult = ProjectileUtil.raycast(user, user.getEyePos(), user.getEyePos().add(10, 0, 0), new Box(user.getBlockPos()).stretch(2, 2, 2), entity -> entity instanceof LivingEntity, 10);
         if (hitResult != null) {
             CubicQuake.print(hitResult.getEntity().toString());
             hitResult.getEntity().damage(ds, 100);
         }*/

        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            world.spawnEntity(new ShotPelletProjectile(serverWorld, user, damage));
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
