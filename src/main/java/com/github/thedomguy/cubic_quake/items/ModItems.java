package com.github.thedomguy.cubic_quake.items;

import com.github.thedomguy.cubic_quake.CubicQuake;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    //Ammo
    public static final Item SHELL = registerItem("shell", new Item(new Item.Settings()));
    public static final Item NAIL = registerItem("nail", new Item(new Item.Settings()));
    public static final Item CELL = registerItem("cell", new Item(new Item.Settings()));
    public static final Item ROCKET = registerItem("rocket", new Item(new Item.Settings()));

    //Weapons


    //Powerups


    //Creative Tab
    public static final ItemGroup CUBIC_QUAKE_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CubicQuake.MOD_ID, "cubic_quake_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.SHELL))
                    .displayName(Text.translatable("itemgroup.cubic_quake.items"))
                    .entries((displayContext, entries) -> {

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
