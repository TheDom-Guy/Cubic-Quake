package com.github.thedomguy.cubic_quake.items.client;

import com.github.thedomguy.cubic_quake.items.weapons.ShotgunItem;
import com.github.thedomguy.cubic_quake.items.weapons.ThunderboltItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ThunderboltRenderer extends GeoItemRenderer<ThunderboltItem> {
    public ThunderboltRenderer() {
        super(new ThunderboltModel());
    }
}
