package com.github.thedomguy.cubic_quake;

import com.github.thedomguy.cubic_quake.entities.ModEntities;
import com.github.thedomguy.cubic_quake.entities.client.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class CubicQuakeClient implements ClientModInitializer {
    public static final EntityModelLayer NAIL_PROJECTILE_LAYER = new EntityModelLayer(Identifier.of(CubicQuake.MOD_ID, "nail_projectile"), "main");
    public static final EntityModelLayer ROCKET_PROJECTILE_LAYER = new EntityModelLayer(Identifier.of(CubicQuake.MOD_ID, "rocket_projectile"), "main");
    public static final EntityModelLayer GRENADE_PROJECTILE_LAYER = new EntityModelLayer(Identifier.of(CubicQuake.MOD_ID, "grenade_projectile"), "main");
    public static final EntityModelLayer SHOT_BLAST_PROJECTILE_LAYER = new EntityModelLayer(Identifier.of(CubicQuake.MOD_ID, "shot_blast_projectile"), "main");


    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.NAIL_PROJECTILE, NailProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(NAIL_PROJECTILE_LAYER, NailProjectileModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.ROCKET_PROJECTILE, RocketProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ROCKET_PROJECTILE_LAYER, RocketProjectileModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.GRENADE_PROJECTILE, GrenadeProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(GRENADE_PROJECTILE_LAYER, GrenadeProjectileModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.SHOT_BLAST_PROJECTILE, ShotBlastProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(SHOT_BLAST_PROJECTILE_LAYER, ShotBlastProjectileModel::getTexturedModelData);

    }
}
