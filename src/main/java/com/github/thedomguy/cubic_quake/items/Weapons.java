package com.github.thedomguy.cubic_quake.items;

import com.github.thedomguy.cubic_quake.items.client.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public enum Weapons {

    DEFAULT(0, Items.ARROW, 20, EntityType.ARROW, 1, new ShotgunRenderer()),
    AXE(1, null, 20, EntityType.COW, 0, new ShotgunRenderer()),

    SHOTGUN(1, ModItems.SHELL, 11, EntityType.CHICKEN, 1, new ShotgunRenderer()),
    DOUBLE_BARRElLED_SHOTGUN(1, ModItems.SHELL, 15, EntityType.HORSE, 2, new DoubleBarrelledShotgunRenderer()),
    NAILGUN(2, ModItems.NAIL, 2, EntityType.SALMON, 1, new NailgunRenderer()),
    SUPER_NAILGUN(4, ModItems.NAIL, 2, EntityType.COD, 2, new SuperNailgunRenderer()),
    THUNDERBOLT(4, ModItems.CELL, 3, EntityType.SHEEP, 1, new ThunderboltRenderer()),
    GRENADE_LAUNCHER(10, ModItems.ROCKET, 14, EntityType.PIG, 1, new GrenadeLauncherRenderer()),
    ROCKET_LAUNCHER(20, ModItems.ROCKET, 17, EntityType.SLIME, 1, new RocketLauncherRenderer());

    private final int d;
    private final Item a;
    private final int f;
    private final EntityType p;
    private final int c;
    private final GeoItemRenderer<WeaponItem> r;

    Weapons(int damage, Item ammo, int firerate, EntityType projectile, int ammoConsumption, GeoItemRenderer renderer) {
        d = damage;
        a = ammo;
        f = firerate;
        p = projectile;
        c = ammoConsumption;
        r = renderer;
    }

    public int DAMAGE() {
        return d;
    }

    public Item AMMO() {
        return a;
    }

    public int FIRERATE() {
        return f;
    }

    public EntityType PROJECTILE() {
        return p;
    }

    public int AMMO_CONSUMPTION() {
        return c;
    }

    public GeoItemRenderer<WeaponItem> RENDERER() {
        return r;
    }

}
