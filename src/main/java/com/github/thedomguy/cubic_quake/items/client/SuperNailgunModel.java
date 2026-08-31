package com.github.thedomguy.cubic_quake.items.client;

import com.github.thedomguy.cubic_quake.CubicQuake;
import com.github.thedomguy.cubic_quake.items.weapons.SuperNailgunItem;
import com.github.thedomguy.cubic_quake.items.weapons.ThunderboltItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class SuperNailgunModel extends GeoModel<SuperNailgunItem> {
    @Override
    public Identifier getModelResource(SuperNailgunItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "geo/super_nailgun.geo.json");
    }

    @Override
    public Identifier getTextureResource(SuperNailgunItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "textures/item/geckolib/super_nailgun.png");
    }

    @Override
    public Identifier getAnimationResource(SuperNailgunItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "animations/super_nailgun.animation.json");
    }
}
