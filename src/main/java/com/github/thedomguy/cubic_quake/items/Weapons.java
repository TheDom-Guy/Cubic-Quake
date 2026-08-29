package com.github.thedomguy.cubic_quake.items;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public enum Weapons {


    DEFAULT(0, Items.ARROW, 20, EntityType.ARROW, 1),
    AXE(1, null, 20, EntityType.COW, 0),
    SHOTGUN(1, ModItems.SHELL, 17, EntityType.CHICKEN, 1),
    DOUBLE_BARRElLED_SHOTGUN(1, ModItems.SHELL, 30, EntityType.HORSE, 2),
    NAILGUN(2, ModItems.NAIL, 5, EntityType.SALMON, 1),
    SUPER_NAILGUN(4, ModItems.NAIL, 5, EntityType.COD, 2),
    THUNDERBOLT(4, ModItems.CELL, 5, EntityType.SHEEP, 1),
    GRENADE_LAUNCHER(10, ModItems.ROCKET, 5, EntityType.PIG, 1),
    ROCKET_LAUNCHER(20, ModItems.ROCKET, 5, EntityType.SLIME, 1);






    private final int d;
    private final Item a;
    private final int f;
    private final EntityType p;
    private final int c;

    Weapons(int damage, Item ammo, int firerate, EntityType projectile, int ammoConsumption) {
        d = damage;
        a = ammo;
        f = firerate;
        p = projectile;
        c = ammoConsumption;
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

}
