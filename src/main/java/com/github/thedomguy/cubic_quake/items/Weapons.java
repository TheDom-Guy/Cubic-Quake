package com.github.thedomguy.cubic_quake.items;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public enum Weapons {


    DEFAULT(0, Items.ARROW, 20, EntityType.ARROW, 1),
    SHOTGUN(1, ModItems.SHELL, 17, EntityType.CHICKEN, 1),
    DOUBLE_BARRElLED_SHOTGUN(1, ModItems.SHELL, 30, EntityType.HORSE, 2);





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
