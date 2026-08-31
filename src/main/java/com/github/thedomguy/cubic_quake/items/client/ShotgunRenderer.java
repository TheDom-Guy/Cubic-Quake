package com.github.thedomguy.cubic_quake.items.client;

import com.github.thedomguy.cubic_quake.items.weapons.ShotgunItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ShotgunRenderer extends GeoItemRenderer<ShotgunItem> {
    public ShotgunRenderer() {
        super(new ShotgunModel());
    }
}
