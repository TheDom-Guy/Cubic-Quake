package com.github.thedomguy.cubic_quake.entities;

import com.github.thedomguy.cubic_quake.CubicQuake;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
   public static final EntityType<NailProjectile> NAIL_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(CubicQuake.MOD_ID, "nail_projectile"),
            EntityType.Builder.create(
                            (EntityType.EntityFactory<NailProjectile>) NailProjectile::new,
                            SpawnGroup.MISC)
                    .dimensions(0.3f, 0.3f)
                    .build()
   );

   public static final EntityType<RocketProjectile> ROCKET_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(CubicQuake.MOD_ID, "rocket_projectile"),
            EntityType.Builder.create(
                            (EntityType.EntityFactory<RocketProjectile>) RocketProjectile::new,
                            SpawnGroup.MISC)
                    .dimensions(0.3f, 0.3f)
                    .build()
   );

   public static final EntityType<GrenadeProjectile> GRENADE_PROJECTILE = Registry.register(
           Registries.ENTITY_TYPE,
           Identifier.of(CubicQuake.MOD_ID, "grenade_projectile"),
           EntityType.Builder.create(
                            (EntityType.EntityFactory<GrenadeProjectile>) GrenadeProjectile::new,
                            SpawnGroup.MISC)
                    .dimensions(0.3f, 0.3f)
                    .build()
   );

   public static final EntityType<ShotBlast> SHOT_BLAST = Registry.register(
           Registries.ENTITY_TYPE,
           Identifier.of(CubicQuake.MOD_ID, "shot_blast"),
           EntityType.Builder.create(
                           (EntityType.EntityFactory<ShotBlast>) ShotBlast::new,
                           SpawnGroup.MISC)
                   .dimensions(0.3f, 0.3f)
                   .build()
   );

   public static final EntityType<ShotPelletProjectile> SHOT_PELLET_PROJECTILE = Registry.register(
           Registries.ENTITY_TYPE,
           Identifier.of(CubicQuake.MOD_ID, "shot_blast_projectile"),
           EntityType.Builder.create(
                           (EntityType.EntityFactory<ShotPelletProjectile>) ShotPelletProjectile::new,
                           SpawnGroup.MISC)
                   .dimensions(0.3f, 0.3f)
                   .build()
   );


   public static void registerModEntities() {
   }
}
