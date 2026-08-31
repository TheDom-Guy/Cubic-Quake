package com.github.thedomguy.cubic_quake.items.client;

import com.github.thedomguy.cubic_quake.CubicQuake;
import com.github.thedomguy.cubic_quake.items.weapons.ShotgunItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ShotgunModel extends GeoModel<ShotgunItem> {
    @Override
    public Identifier getModelResource(ShotgunItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "geo/shotgun.geo.json");
    }

    @Override
    public Identifier getTextureResource(ShotgunItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "textures/item/geckolib/shotgun.png");
    }

    @Override
    public Identifier getAnimationResource(ShotgunItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "animations/shotgun.animation.json");
    }
}
