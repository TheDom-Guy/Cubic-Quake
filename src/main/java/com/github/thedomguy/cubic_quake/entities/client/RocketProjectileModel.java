package com.github.thedomguy.cubic_quake.entities.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.Entity;

@Environment(EnvType.CLIENT)
public class RocketProjectileModel<T extends Entity> extends SinglePartEntityModel<T> {
    private final ModelPart rt;

    protected RocketProjectileModel(ModelPart root) {
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
                        .cuboid(-1.5f, 0, -6, 3, 3, 12)
                , ModelTransform.rotation(0,(float) Math.PI,0));
        modelPartData.addChild("finsv", ModelPartBuilder.create()
                        .uv(0, -4)
                        .cuboid(0, -2f, -6, 0, 7, 4)
                , ModelTransform.NONE);
        modelPartData.addChild("finsh", ModelPartBuilder.create()
                        .uv(0, -4)
                        .cuboid(1.5f, -3.5f, -6, 0, 7, 4)
                , ModelTransform.rotation(0,0,(float) (Math.PI * 0.5)));
        return TexturedModelData.of(modelData, 32, 16);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}
