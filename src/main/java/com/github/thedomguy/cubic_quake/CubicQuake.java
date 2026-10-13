package com.github.thedomguy.cubic_quake;

import com.github.thedomguy.cubic_quake.blocks.ModBlocks;
import com.github.thedomguy.cubic_quake.entities.ModEntities;
import com.github.thedomguy.cubic_quake.entities.effects.PentagramProtectionEffect;
import com.github.thedomguy.cubic_quake.entities.effects.QuadDamageEffect;
import com.github.thedomguy.cubic_quake.items.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CubicQuake implements ModInitializer {
	public static final String MOD_ID = "cubic_quake";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final RegistryKey<DamageType> CUBIC_QUAKE_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(MOD_ID, "cubic_quake_damage"));

	public static final RegistryEntry<StatusEffect> QUAD_DAMAGE_EFFECT = Registry.registerReference(
			Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "quad_damage"), new QuadDamageEffect().applySound(SoundEvents.BLOCK_ANVIL_LAND));

	public static final RegistryEntry<StatusEffect> PENTAGRAM_PROTECTION_EFFECT = Registry.registerReference(
			Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "pentagram_protection"), new PentagramProtectionEffect()
					.addAttributeModifier(
							EntityAttributes.GENERIC_ARMOR, Identifier.of(MOD_ID, "pentagram_armour"), 10000F, EntityAttributeModifier.Operation.ADD_VALUE)
	);

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
