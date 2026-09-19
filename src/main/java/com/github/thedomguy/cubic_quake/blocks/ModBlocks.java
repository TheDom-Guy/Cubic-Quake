package com.github.thedomguy.cubic_quake.blocks;

import com.github.thedomguy.cubic_quake.CubicQuake;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BOX_OF_SHELLS = registerBlock("box_of_shells", new Block(AbstractBlock.Settings.create().strength(0.5F).mapColor(MapColor.STONE_GRAY)));
    public static final Block BOX_OF_NAILS = registerBlock("box_of_nails", new Block(AbstractBlock.Settings.create().strength(0.5F).mapColor(MapColor.STONE_GRAY)));
    public static final Block BOX_OF_CELLS = registerBlock("box_of_cells", new Block(AbstractBlock.Settings.create().strength(0.5F).mapColor(MapColor.STONE_GRAY)));
    public static final Block BOX_OF_ROCKETS = registerBlock("box_of_rockets", new Block(AbstractBlock.Settings.create().strength(0.5F).mapColor(MapColor.STONE_GRAY)));

    //Block Registration
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(CubicQuake.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(CubicQuake.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
    }
}
