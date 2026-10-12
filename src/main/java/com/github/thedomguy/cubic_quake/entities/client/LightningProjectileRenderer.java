package com.github.thedomguy.cubic_quake.entities.client;

import com.github.thedomguy.cubic_quake.CubicQuake;
import com.github.thedomguy.cubic_quake.CubicQuakeClient;
import com.github.thedomguy.cubic_quake.entities.LightningProjectile;
import com.github.thedomguy.cubic_quake.entities.ShotPelletProjectile;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class LightningProjectileRenderer extends EntityRenderer<LightningProjectile> {
    private static final Identifier TEXTURE = Identifier.of(CubicQuake.MOD_ID, "textures/entity/grenade_projectile.png");
    private final LightningProjectileModel<LightningProjectile> model;

    public LightningProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new LightningProjectileModel<>(context.getPart(CubicQuakeClient.LIGHTNING_PROJECTILE_LAYER));
    }

    @Override
    public void render(LightningProjectile lightningProjectile, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(lightningProjectile, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(LightningProjectile lightningProjectile) {
        return null;
    }
}
