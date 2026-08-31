package com.github.thedomguy.cubic_quake.items.client;

import com.github.thedomguy.cubic_quake.items.weapons.RocketLauncherItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class RocketLauncherRenderer extends GeoItemRenderer<RocketLauncherItem> {
    public RocketLauncherRenderer() {
        super(new RocketLauncherModel());
    }
}
