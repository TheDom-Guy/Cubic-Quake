package com.github.thedomguy.cubic_quake.entities.client;

import com.github.thedomguy.cubic_quake.CubicQuake;
import com.github.thedomguy.cubic_quake.CubicQuakeClient;
import com.github.thedomguy.cubic_quake.entities.NailProjectile;
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
public class NailProjectileRenderer extends EntityRenderer<NailProjectile> {
    private static final Identifier TEXTURE = Identifier.of(CubicQuake.MOD_ID, "textures/entity/nail_projectile.png");
    private final NailProjectileModel<NailProjectile> model;

    public NailProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new NailProjectileModel<>(context.getPart(CubicQuakeClient.NAIL_PROJECTILE_LAYER));
    }

    @Override
    public void render(NailProjectile nailProjectile, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.scale(1, -1, -1);
        matrixStack.translate(0, -0.275, 0);

        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-nailProjectile.getYaw()));
        matrixStack.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(nailProjectile.getPitch()));
        CubicQuake.print(nailProjectile.getYaw() + " " + nailProjectile.getPitch());

        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(TEXTURE));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV);
        matrixStack.pop();
        super.render(nailProjectile, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(NailProjectile nailProjectile) {
        return TEXTURE;
    }
}
