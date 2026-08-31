package com.github.thedomguy.cubic_quake.items.client;

import com.github.thedomguy.cubic_quake.CubicQuake;
import com.github.thedomguy.cubic_quake.items.WeaponItem;
import com.github.thedomguy.cubic_quake.items.weapons.DoubleBarrelledShotgunItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class DoubleBarrelledShotgunModel extends GeoModel<DoubleBarrelledShotgunItem> {
    @Override
    public Identifier getModelResource(DoubleBarrelledShotgunItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "geo/double_barrelled_shotgun.geo.json");
    }

    @Override
    public Identifier getTextureResource(DoubleBarrelledShotgunItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "textures/item/geckolib/double_barrelled_shotgun.png");
    }

    @Override
    public Identifier getAnimationResource(DoubleBarrelledShotgunItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "animations/double_barrelled_shotgun.animation.json");
    }
}
