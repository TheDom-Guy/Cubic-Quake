package com.github.thedomguy.cubic_quake;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent SHOTGUN_FIRE = registerSoundEvent("shotgun_fire");
    public static final SoundEvent SUPER_SHOTGUN_FIRE = registerSoundEvent("super_shotgun_fire");
    public static final SoundEvent NAILGUN_FIRE = registerSoundEvent("nailgun_fire");
    public static final SoundEvent SUPER_NAILGUN_FIRE = registerSoundEvent("super_nailgun_fire");
    public static final SoundEvent GRENADE_LAUNCHER_FIRE = registerSoundEvent("grenade_launcher_fire");
    public static final SoundEvent ROCKET_LAUNCHER_FIRE = registerSoundEvent("rocket_launcher_fire");
    public static final SoundEvent THUNDERBOLT_FIRE = registerSoundEvent("thunderbolt_fire");

    public static final SoundEvent GRENADE_BOUNCE = registerSoundEvent("grenade_bounce");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(CubicQuake.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
    }
}
