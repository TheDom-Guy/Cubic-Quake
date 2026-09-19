package com.github.thedomguy.cubic_quake;

import com.github.thedomguy.cubic_quake.blocks.ModBlocks;
import com.github.thedomguy.cubic_quake.entities.ModEntities;
import com.github.thedomguy.cubic_quake.items.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CubicQuake implements ModInitializer {
	public static final String MOD_ID = "cubic_quake";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final RegistryKey<DamageType> CUBIC_QUAKE_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(MOD_ID, "cubic_quake_damage"));

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModEntities.registerModEntities();
		ModBlocks.registerModBlocks();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	public static void print(String text) {
		LOGGER.info(text);
	}
}
