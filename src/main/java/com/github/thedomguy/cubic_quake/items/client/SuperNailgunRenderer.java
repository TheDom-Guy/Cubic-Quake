package com.github.thedomguy.cubic_quake.items.client;

import com.github.thedomguy.cubic_quake.items.weapons.SuperNailgunItem;
import com.github.thedomguy.cubic_quake.items.weapons.ThunderboltItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SuperNailgunRenderer extends GeoItemRenderer<SuperNailgunItem> {
    public SuperNailgunRenderer() {
        super(new SuperNailgunModel());
    }
}
