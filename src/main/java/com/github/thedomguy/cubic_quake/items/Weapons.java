package com.github.thedomguy.cubic_quake.items;

import com.github.thedomguy.cubic_quake.ModSounds;
import com.github.thedomguy.cubic_quake.entities.*;
import com.github.thedomguy.cubic_quake.items.client.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public enum Weapons {

    DEFAULT(0, Items.ARROW, 20, null, 1, new ShotgunRenderer(), SoundEvents.ENTITY_PLAYER_HURT),
    AXE(1, null, 20, null, 0, new ShotgunRenderer(), SoundEvents.ENTITY_PLAYER_HURT),

    SHOTGUN(1, ModItems.SHELL, 8, ShotBlast::new, 1, new ShotgunRenderer(), ModSounds.SHOTGUN_FIRE),
    DOUBLE_BARRELLED_SHOTGUN(2, ModItems.SHELL, 15, SuperShotBlast::new, 2, new DoubleBarrelledShotgunRenderer(), ModSounds.SUPER_SHOTGUN_FIRE),
    NAILGUN(2, ModItems.NAIL, 2, NailProjectile::new, 1, new NailgunRenderer(), ModSounds.NAILGUN_FIRE),
    SUPER_NAILGUN(4, ModItems.NAIL, 2, NailProjectile::new, 2, new SuperNailgunRenderer(), ModSounds.SUPER_NAILGUN_FIRE),
    THUNDERBOLT(8, ModItems.CELL, 3, LightningProjectile::new, 1, new ThunderboltRenderer(), ModSounds.THUNDERBOLT_FIRE),
    GRENADE_LAUNCHER(10, ModItems.ROCKET, 14, GrenadeProjectile::new, 1, new GrenadeLauncherRenderer(), ModSounds.GRENADE_LAUNCHER_FIRE),
    ROCKET_LAUNCHER(20, ModItems.ROCKET, 17, RocketProjectile::new, 1, new RocketLauncherRenderer(), ModSounds.ROCKET_LAUNCHER_FIRE);

    private final float d;
    private final Item a;
    private final int f;
    private final WeaponProjectile.Factory<? extends WeaponProjectile> p;
    private final int c;
    private final GeoItemRenderer<? extends WeaponItem> r;
    private final SoundEvent s;

    Weapons(float damage, Item ammo, int firerate, @Nullable WeaponProjectile.Factory<? extends WeaponProjectile> projectile, int ammoConsumption, GeoItemRenderer<? extends WeaponItem> renderer, SoundEvent fireSound) {
        d = damage;
        a = ammo;
        f = firerate;
        p = projectile;
        c = ammoConsumption;
        r = renderer;
        s = fireSound;
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

    public SoundEvent FIRESOUND() {
        return s;
    }

}
