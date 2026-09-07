package com.github.thedomguy.cubic_quake.entities.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.Entity;

@Environment(EnvType.CLIENT)
public class NailProjectileModel<T extends Entity> extends SinglePartEntityModel<T> {
    private final ModelPart rt;

    protected NailProjectileModel(ModelPart root) {
        rt = root;
    }

    @Override
    public ModelPart getPart() {
        return rt;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("main", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F).cuboid(0.0F, -4.0F, 0.0F, 2.0F, 2.0F, 2.0F).cuboid(0.0F, 0.0F, -4.0F, 2.0F, 2.0F, 2.0F).cuboid(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F).cuboid(2.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F).cuboid(0.0F, 2.0F, 0.0F, 2.0F, 2.0F, 2.0F).cuboid(0.0F, 0.0F, 2.0F, 2.0F, 2.0F, 2.0F), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}
