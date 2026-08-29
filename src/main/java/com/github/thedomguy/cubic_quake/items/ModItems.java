package com.github.thedomguy.cubic_quake.items;

import com.github.thedomguy.cubic_quake.CubicQuake;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.component.DataComponentTypes;
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
    public static final Item CELL = registerItem("cell", new Item(new Item.Settings()));
    public static final Item ROCKET = registerItem("rocket", new Item(new Item.Settings()));

    //Weapons
    public static final Item AXE = registerItem("axe", new Item(new Item.Settings().attributeModifiers(AttributeModifiersComponent.builder()
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
   // public static final Item AXE = registerItem("axe", new WeaponItem(new Item.Settings(), Weapons.AXE));
    public static final Item SHOTGUN = registerItem("shotgun", new WeaponItem(new Item.Settings(), Weapons.SHOTGUN));
    public static final Item DOUBLE_BARRElLED_SHOTGUN = registerItem("double_barrelled_shotgun", new WeaponItem(new Item.Settings(), Weapons.DOUBLE_BARRElLED_SHOTGUN));
    public static final Item NAILGUN = registerItem("nailgun", new WeaponItem(new Item.Settings(), Weapons.NAILGUN));
    public static final Item SUPER_NAILGUN = registerItem("super_nailgun", new WeaponItem(new Item.Settings(), Weapons.SUPER_NAILGUN));
    public static final Item THUNDERBOLT = registerItem("thunderbolt", new WeaponItem(new Item.Settings(), Weapons.THUNDERBOLT));
    public static final Item GRENADE_LAUNCHER = registerItem("grenade_launcher", new WeaponItem(new Item.Settings(), Weapons.GRENADE_LAUNCHER));
    public static final Item ROCKET_LAUNCHER = registerItem("rocket_launcher", new WeaponItem(new Item.Settings(), Weapons.ROCKET_LAUNCHER));

    //Powerups


    //Creative Tab
    public static final ItemGroup CUBIC_QUAKE_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CubicQuake.MOD_ID, "cubic_quake_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.SHELL))
                    .displayName(Text.translatable("itemgroup.cubic_quake.items"))
                    .entries((displayContext, entries) -> {

                        entries.add(AXE);
                        entries.add(SHOTGUN);
                        entries.add(DOUBLE_BARRElLED_SHOTGUN);
                        entries.add(NAILGUN);
                        entries.add(SUPER_NAILGUN);
                        entries.add(THUNDERBOLT);
                        entries.add(GRENADE_LAUNCHER);
                        entries.add(ROCKET_LAUNCHER);
                        entries.add(SHELL);
                        entries.add(NAIL);
                        entries.add(CELL);
                        entries.add(ROCKET);

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
