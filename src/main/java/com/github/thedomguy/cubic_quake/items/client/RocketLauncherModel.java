package com.github.thedomguy.cubic_quake.items.client;

import com.github.thedomguy.cubic_quake.CubicQuake;
import com.github.thedomguy.cubic_quake.items.weapons.GrenadeLauncherItem;
import com.github.thedomguy.cubic_quake.items.weapons.RocketLauncherItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class RocketLauncherModel extends GeoModel<RocketLauncherItem> {
    @Override
    public Identifier getModelResource(RocketLauncherItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "geo/rocket_launcher.geo.json");
    }

    @Override
    public Identifier getTextureResource(RocketLauncherItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "textures/item/geckolib/rocket_launcher.png");
    }

    @Override
    public Identifier getAnimationResource(RocketLauncherItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "animations/rocket_launcher.animation.json");
    }
}
