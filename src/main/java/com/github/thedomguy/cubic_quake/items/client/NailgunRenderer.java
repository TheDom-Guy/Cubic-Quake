package com.github.thedomguy.cubic_quake.items.client;

import com.github.thedomguy.cubic_quake.items.weapons.NailgunItem;
import com.github.thedomguy.cubic_quake.items.weapons.SuperNailgunItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class NailgunRenderer extends GeoItemRenderer<NailgunItem> {
    public NailgunRenderer() {
        super(new NailgunModel());
    }
}
