package com.github.thedomguy.cubic_quake.items.client;

import com.github.thedomguy.cubic_quake.items.weapons.GrenadeLauncherItem;
import com.github.thedomguy.cubic_quake.items.weapons.ShotgunItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GrenadeLauncherRenderer extends GeoItemRenderer<GrenadeLauncherItem> {
    public GrenadeLauncherRenderer() {
        super(new GrenadeLauncherModel());
    }
}
