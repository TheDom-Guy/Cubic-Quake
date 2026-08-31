package com.github.thedomguy.cubic_quake.items.client;

import com.github.thedomguy.cubic_quake.CubicQuake;
import com.github.thedomguy.cubic_quake.items.weapons.NailgunItem;
import com.github.thedomguy.cubic_quake.items.weapons.SuperNailgunItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class NailgunModel extends GeoModel<NailgunItem> {
    @Override
    public Identifier getModelResource(NailgunItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "geo/nailgun.geo.json");
    }

    @Override
    public Identifier getTextureResource(NailgunItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "textures/item/geckolib/nailgun.png");
    }

    @Override
    public Identifier getAnimationResource(NailgunItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "animations/nailgun.animation.json");
    }
}
