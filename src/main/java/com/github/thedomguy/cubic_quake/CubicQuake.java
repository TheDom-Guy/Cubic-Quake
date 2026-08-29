package com.github.thedomguy.cubic_quake;

import com.github.thedomguy.cubic_quake.items.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CubicQuake implements ModInitializer {
	public static final String MOD_ID = "cubic_quake";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
