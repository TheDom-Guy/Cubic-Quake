package com.github.thedomguy.cubic_quake.items;

import com.github.thedomguy.cubic_quake.entities.GrenadeProjectile;
import com.github.thedomguy.cubic_quake.entities.NailProjectile;
import com.github.thedomguy.cubic_quake.entities.RocketProjectile;
import com.github.thedomguy.cubic_quake.entities.WeaponProjectile;
import com.github.thedomguy.cubic_quake.items.client.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public enum Weapons {

    DEFAULT(0, Items.ARROW, 20, null, 1, new ShotgunRenderer()),
    AXE(1, null, 20, null, 0, new ShotgunRenderer()),

    SHOTGUN(1, ModItems.SHELL, 8, NailProjectile::new, 1, new ShotgunRenderer()),
    DOUBLE_BARRELLED_SHOTGUN(1, ModItems.SHELL, 15, NailProjectile::new, 2, new DoubleBarrelledShotgunRenderer()),
    NAILGUN(2, ModItems.NAIL, 2, NailProjectile::new, 1, new NailgunRenderer()),
    SUPER_NAILGUN(4, ModItems.NAIL, 2, NailProjectile::new, 2, new SuperNailgunRenderer()),
    THUNDERBOLT(4, ModItems.CELL, 3, NailProjectile::new, 1, new ThunderboltRenderer()),
    GRENADE_LAUNCHER(10, ModItems.ROCKET, 14, GrenadeProjectile::new, 1, new GrenadeLauncherRenderer()),
    ROCKET_LAUNCHER(20, ModItems.ROCKET, 17, RocketProjectile::new, 1, new RocketLauncherRenderer());

    private final float d;
    private final Item a;
    private final int f;
    private final WeaponProjectile.Factory<? extends WeaponProjectile> p;
    private final int c;
    private final GeoItemRenderer<? extends WeaponItem> r;

    Weapons(float damage, Item ammo, int firerate, @Nullable WeaponProjectile.Factory<? extends WeaponProjectile> projectile, int ammoConsumption, GeoItemRenderer<? extends WeaponItem> renderer) {
        d = damage;
        a = ammo;
        f = firerate;
        p = projectile;
        c = ammoConsumption;
        r = renderer;
    }

    public float DAMAGE() {
        return d;
    }

    public Item AMMO() {
        return a;
    }

    public int FIRERATE() {
        return f;
    }

    public WeaponProjectile.Factory<? extends WeaponProjectile> PROJECTILE() {
        return p;
    }

    public int AMMO_CONSUMPTION() {
        return c;
    }

    public GeoItemRenderer<? extends WeaponItem> RENDERER() {
        return r;
    }

}
