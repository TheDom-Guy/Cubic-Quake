package com.github.thedomguy.cubic_quake.entities.client;

import com.github.thedomguy.cubic_quake.CubicQuake;
import com.github.thedomguy.cubic_quake.CubicQuakeClient;
import com.github.thedomguy.cubic_quake.entities.ShotBlast;
import com.github.thedomguy.cubic_quake.entities.ShotPelletProjectile;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ShotPelletProjectileRenderer extends EntityRenderer<ShotPelletProjectile> {
    private static final Identifier TEXTURE = Identifier.of(CubicQuake.MOD_ID, "textures/entity/grenade_projectile.png");
    private final ShotPelletProjectileModel<ShotPelletProjectile> model;

    public ShotPelletProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new ShotPelletProjectileModel<>(context.getPart(CubicQuakeClient.SHOT_BLAST_LAYER));
    }

    @Override
    public void render(ShotPelletProjectile shotPelletProjectile, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(shotPelletProjectile, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(ShotPelletProjectile shotPelletProjectile) {
        return null;
    }
}
