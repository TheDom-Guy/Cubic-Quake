package com.github.thedomguy.cubic_quake.items.client;

import com.github.thedomguy.cubic_quake.items.WeaponItem;
import com.github.thedomguy.cubic_quake.items.weapons.DoubleBarrelledShotgunItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class DoubleBarrelledShotgunRenderer extends GeoItemRenderer<DoubleBarrelledShotgunItem> {
    public DoubleBarrelledShotgunRenderer() {
        super(new DoubleBarrelledShotgunModel());
    }
}
