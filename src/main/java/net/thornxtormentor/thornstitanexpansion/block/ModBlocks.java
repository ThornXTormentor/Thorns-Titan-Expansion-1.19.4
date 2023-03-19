package net.thornxtormentor.thornstitanexpansion.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thornxtormentor.thornstitanexpansion.ThornsTitanExpansionMod;
import net.thornxtormentor.thornstitanexpansion.item.ModItemGroup;

public class ModBlocks {

    //ORE BLOCKS
    public static final Block PERIDOT_ORE = registerBlock("peridot_ore", new Block(FabricBlockSettings.of(Material.STONE).luminance(1).requiresTool().strength(5f)), ModItemGroup.TTEGroup);
    public static final Block AQUAMARINE_ORE = registerBlock("aquamarine_ore", new Block(FabricBlockSettings.of(Material.STONE).luminance(1).requiresTool().strength(5f)), ModItemGroup.TTEGroup);
    public static final Block RED_BERYL_ORE = registerBlock("red_beryl_ore", new Block(FabricBlockSettings.of(Material.STONE).luminance(1).requiresTool().strength(5f)), ModItemGroup.TTEGroup);
    public static final Block TOPAZ_ORE = registerBlock("topaz_ore", new Block(FabricBlockSettings.of(Material.STONE).luminance(1).requiresTool().strength(5f)), ModItemGroup.TTEGroup);
    public static final Block DEEPSLATE_PERIDOT_ORE = registerBlock("deepslate_peridot_ore", new Block(FabricBlockSettings.of(Material.STONE).luminance(1).requiresTool().strength(5f)), ModItemGroup.TTEGroup);
    public static final Block DEEPSLATE_AQUAMARINE_ORE = registerBlock("deepslate_aquamarine_ore", new Block(FabricBlockSettings.of(Material.STONE).luminance(1).requiresTool().strength(5f)), ModItemGroup.TTEGroup);
    public static final Block DEEPSLATE_RED_BERYL_ORE = registerBlock("deepslate_red_beryl_ore", new Block(FabricBlockSettings.of(Material.STONE).luminance(1).requiresTool().strength(5f)), ModItemGroup.TTEGroup);
    public static final Block DEEPSLATE_TOPAZ_ORE = registerBlock("deepslate_topaz_ore", new Block(FabricBlockSettings.of(Material.STONE).luminance(1).requiresTool().strength(5f)), ModItemGroup.TTEGroup);

    //GEM BLOCKS
    public static final Block PERIDOT_BLOCK = registerBlock("peridot_block", new Block(FabricBlockSettings.of(Material.METAL).luminance(1).requiresTool().strength(5f)), ModItemGroup.TTEGroup);
    public static final Block TOPAZ_BLOCK = registerBlock("topaz_block", new Block(FabricBlockSettings.of(Material.METAL).luminance(1).requiresTool().strength(5f)), ModItemGroup.TTEGroup);
    public static final Block AQUAMARINE_BLOCK = registerBlock("aquamarine_block", new Block(FabricBlockSettings.of(Material.METAL).luminance(1).requiresTool().strength(5f)), ModItemGroup.TTEGroup);
    public static final Block RED_BERYL_BLOCK = registerBlock("red_beryl_block", new Block(FabricBlockSettings.of(Material.METAL).luminance(1).requiresTool().strength(5f)), ModItemGroup.TTEGroup);

    private static Block registerBlock(String name, Block block, ItemGroup itemGroup){
        registerBlockItem(name, block, itemGroup);
        return Registry.register(Registries.BLOCK, new Identifier(ThornsTitanExpansionMod.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup itemGroup){
        Item item = Registry.register(Registries.ITEM, new Identifier(ThornsTitanExpansionMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(item));
        return item;
    }
    public static void registerModBlocks(){
        ThornsTitanExpansionMod.LOGGER.debug("Registering Mod Blocks");
    }
}
