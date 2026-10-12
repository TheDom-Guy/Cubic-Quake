package com.github.thedomguy.cubic_quake.items.client;

import com.github.thedomguy.cubic_quake.CubicQuake;
import com.github.thedomguy.cubic_quake.items.weapons.ShotgunItem;
import com.github.thedomguy.cubic_quake.items.weapons.ThunderboltItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ThunderboltModel extends GeoModel<ThunderboltItem> {
    @Override
    public Identifier getModelResource(ThunderboltItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "geo/thunderbolt.geo.json");
    }

    @Override
    public Identifier getTextureResource(ThunderboltItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "textures/item/geckolib/thunderbolt.png");
    }

    @Override
    public Identifier getAnimationResource(ThunderboltItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "animations/thunderbolt.animation.json");
    }
}
