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
       /* modelPartData.addChild("main", ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(-2, -4.4f, -4, 4, 4, 8)
                , ModelTransform.rotation((float) (Math.PI * 0.5),0,0));*/
        modelPartData.addChild("spikev", ModelPartBuilder.create()
                        .uv(0, 8)
                        .cuboid(0, 0, -4, 0, 4, 8)          //-4.4f
                , ModelTransform.NONE);
        modelPartData.addChild("spikeh", ModelPartBuilder.create()
                        .uv(0, 8)
                        .cuboid(2.4f, -2, -4, 0, 4, 8)      //-2.4f
                , ModelTransform.rotation(0,0,(float) (Math.PI * 0.5)));
        modelPartData.addChild("back", ModelPartBuilder.create()
                        .uv(0, 4)
                        .cuboid(-2, 0, -4, 4, 4, 0)         //-4.4f
                , ModelTransform.rotation(0,(float) Math.PI,0));
       /* modelPartData.addChild("back", ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(0, 0, 0, 16, 16, 16)
                , ModelTransform.NONE);*/
        return TexturedModelData.of(modelData, 32, 16);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}
