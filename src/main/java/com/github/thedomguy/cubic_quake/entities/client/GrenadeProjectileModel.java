package com.github.thedomguy.cubic_quake.entities.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.Entity;

@Environment(EnvType.CLIENT)
public class GrenadeProjectileModel<T extends Entity> extends SinglePartEntityModel<T> {
    private final ModelPart rt;

    protected GrenadeProjectileModel(ModelPart root) {
        rt = root;
    }

    @Override
    public ModelPart getPart() {
        return rt;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("body", ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(-1.5f, 0, -3.5f, 3, 3, 7)
                , ModelTransform.rotation(0,(float) Math.PI,0));
        return TexturedModelData.of(modelData, 32, 16);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}
