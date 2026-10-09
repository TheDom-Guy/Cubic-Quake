package com.github.thedomguy.cubic_quake.entities.client;

import com.github.thedomguy.cubic_quake.CubicQuake;
import com.github.thedomguy.cubic_quake.CubicQuakeClient;
import com.github.thedomguy.cubic_quake.entities.GrenadeProjectile;
import com.github.thedomguy.cubic_quake.entities.RocketProjectile;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class GrenadeProjectileRenderer extends EntityRenderer<GrenadeProjectile> {
    private static final Identifier TEXTURE = Identifier.of(CubicQuake.MOD_ID, "textures/entity/rocket_projectile.png");
    private final GrenadeProjectileModel<GrenadeProjectile> model;

    public GrenadeProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new GrenadeProjectileModel<>(context.getPart(CubicQuakeClient.GRENADE_PROJECTILE_LAYER));
    }

    @Override
    public void render(GrenadeProjectile grenadeProjectile, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.scale(-1, -1, 1);
        matrixStack.translate(0, -0.24375, 0);

        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-grenadeProjectile.getYaw()));
        matrixStack.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(-grenadeProjectile.getPitch()));

        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(TEXTURE));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV);
        matrixStack.pop();
        super.render(grenadeProjectile, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(GrenadeProjectile grenadeProjectile) {
        return TEXTURE;
    }
}
