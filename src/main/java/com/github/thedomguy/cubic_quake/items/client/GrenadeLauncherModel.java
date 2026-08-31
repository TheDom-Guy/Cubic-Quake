package com.github.thedomguy.cubic_quake.items.client;

import com.github.thedomguy.cubic_quake.CubicQuake;
import com.github.thedomguy.cubic_quake.items.weapons.GrenadeLauncherItem;
import com.github.thedomguy.cubic_quake.items.weapons.ShotgunItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class GrenadeLauncherModel extends GeoModel<GrenadeLauncherItem> {
    @Override
    public Identifier getModelResource(GrenadeLauncherItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "geo/grenade_launcher.geo.json");
    }

    @Override
    public Identifier getTextureResource(GrenadeLauncherItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "textures/item/geckolib/grenade_launcher.png");
    }

    @Override
    public Identifier getAnimationResource(GrenadeLauncherItem animatable) {
        return Identifier.of(CubicQuake.MOD_ID, "animations/grenade_launcher.animation.json");
    }
}
