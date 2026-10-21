package com.github.thedomguy.cubic_quake.items;

import com.github.thedomguy.cubic_quake.CubicQuake;
import com.github.thedomguy.cubic_quake.blocks.ModBlocks;
import com.github.thedomguy.cubic_quake.items.weapons.*;
import com.github.thedomguy.cubic_quake.items.weapons.AxeItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.minecraft.item.Item.BASE_ATTACK_DAMAGE_MODIFIER_ID;
import static net.minecraft.item.Item.BASE_ATTACK_SPEED_MODIFIER_ID;

public class ModItems {
    //Ammo
    public static final Item SHELL = registerItem("shell", new Item(new Item.Settings()));
    public static final Item NAIL = registerItem("nail", new Item(new Item.Settings()));
    public static final Item CELL = registerItem("cell", new Item(new Item.Settings().maxCount(16)));
    public static final Item ROCKET = registerItem("rocket", new Item(new Item.Settings()));

    //Weapons
    public static final Item AXE = registerItem("axe", new AxeItem(new Item.Settings().maxCount(1).attributeModifiers(AttributeModifiersComponent.builder()
            .add(
                    EntityAttributes.GENERIC_ATTACK_DAMAGE,
                    new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 1.0, EntityAttributeModifier.Operation.ADD_VALUE),
                    AttributeModifierSlot.MAINHAND
            )
            .add(
                    EntityAttributes.GENERIC_ATTACK_SPEED,
                    new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, -1F, EntityAttributeModifier.Operation.ADD_VALUE),
                    AttributeModifierSlot.MAINHAND
            )
            .build())));
    public static final Item SHOTGUN = registerItem("shotgun", new ShotgunItem(new Item.Settings(), Weapons.SHOTGUN));
    public static final Item DOUBLE_BARRELLED_SHOTGUN = registerItem("double_barrelled_shotgun", new DoubleBarrelledShotgunItem(new Item.Settings(), Weapons.DOUBLE_BARRELLED_SHOTGUN));
    public static final Item NAILGUN = registerItem("nailgun", new NailgunItem(new Item.Settings(), Weapons.NAILGUN));
    public static final Item SUPER_NAILGUN = registerItem("super_nailgun", new SuperNailgunItem(new Item.Settings(), Weapons.SUPER_NAILGUN));
    public static final Item GRENADE_LAUNCHER = registerItem("grenade_launcher", new GrenadeLauncherItem(new Item.Settings(), Weapons.GRENADE_LAUNCHER));
    public static final Item ROCKET_LAUNCHER = registerItem("rocket_launcher", new RocketLauncherItem(new Item.Settings(), Weapons.ROCKET_LAUNCHER));
    public static final Item THUNDERBOLT = registerItem("thunderbolt", new ThunderboltItem(new Item.Settings(), Weapons.THUNDERBOLT));

    //Powerups
    public static final Item QUAD_DAMAGE = registerItem("quad_damage", new PowerupItem(new Item.Settings(), Powerups.QUAD_DAMAGE));
    public static final Item RING_OF_SHADOWS = registerItem("ring_of_shadows", new PowerupItem(new Item.Settings(), Powerups.RING_OF_SHADOWS));
    public static final Item PENTAGRAM_OF_PROTECTION = registerItem("pentagram_of_protection", new PowerupItem(new Item.Settings(), Powerups.PENTAGRAM_OF_PROTECTION));

    //Creative Tab
    public static final ItemGroup CUBIC_QUAKE_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CubicQuake.MOD_ID, "cubic_quake_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.QUAD_DAMAGE))
                    .displayName(Text.translatable("itemgroup.cubic_quake.items"))
                    .entries((displayContext, entries) -> {

                        entries.add(AXE);
                        entries.add(SHOTGUN);
                        entries.add(DOUBLE_BARRELLED_SHOTGUN);
                        entries.add(NAILGUN);
                        entries.add(SUPER_NAILGUN);
                        entries.add(GRENADE_LAUNCHER);
                        entries.add(ROCKET_LAUNCHER);
                        entries.add(THUNDERBOLT);
                        entries.add(SHELL);
                        entries.add(NAIL);
                        entries.add(ROCKET);
                        entries.add(CELL);
                        entries.add(ModBlocks.BOX_OF_SHELLS);
                        entries.add(ModBlocks.BOX_OF_NAILS);
                        entries.add(ModBlocks.BOX_OF_ROCKETS);
                        entries.add(ModBlocks.BOX_OF_CELLS);
                        entries.add(QUAD_DAMAGE);
                        entries.add(RING_OF_SHADOWS);
                        entries.add(PENTAGRAM_OF_PROTECTION);

                    })
                    .build()
    );

    //Item Registration
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CubicQuake.MOD_ID, name), item);
    }

    public static void registerModItems() {
    }
}
