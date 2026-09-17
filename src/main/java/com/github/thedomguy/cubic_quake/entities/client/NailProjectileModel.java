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
        modelPartData.addChild("spikev", ModelPartBuilder.create()
                        .uv(0, 8)
                        .cuboid(0, 0, -4, 0, 4, 8)
                , ModelTransform.NONE);
        modelPartData.addChild("spikeh", ModelPartBuilder.create()
                        .uv(0, 8)
                        .cuboid(2.4f, -2, -4, 0, 4, 8)
                , ModelTransform.rotation(0,0,(float) (Math.PI * 0.5)));
        modelPartData.addChild("back", ModelPartBuilder.create()
                        .uv(0, 4)
                        .cuboid(-2, 0, -4, 4, 4, 0)
                , ModelTransform.rotation(0,(float) Math.PI,0));
        return TexturedModelData.of(modelData, 32, 16);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}
