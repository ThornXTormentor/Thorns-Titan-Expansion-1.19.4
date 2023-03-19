package net.thornxtormentor.thornstitanexpansion.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thornxtormentor.thornstitanexpansion.ThornsTitanExpansionMod;

public class ModItems {
    //ORE
    public static final Item RAW_PERIDOT = registerItem("raw_peridot", new Item(new FabricItemSettings().group(ModItemGroup.TTEGROUP)));
    public static final Item RAW_AQUAMARINE = registerItem("raw_aquamarine", new Item(new FabricItemSettings().group(ModItemGroup.TTEGROUP)));
    public static final Item RAW_RED_BERYL = registerItem("raw_red_beryl", new Item(new FabricItemSettings().group(ModItemGroup.TTEGROUP)));
    public static final Item RAW_TOPAZ = registerItem("raw_topaz", new Item(new FabricItemSettings().group(ModItemGroup.TTEGROUP)));

    //GEMS
    public static final Item PERIDOT = registerItem("peridot", new Item(new FabricItemSettings().group(ModItemGroup.TTEGROUP)));
    public static final Item AQUAMARINE = registerItem("aquamarine", new Item(new FabricItemSettings().group(ModItemGroup.TTEGROUP)));
    public static final Item RED_BERYL = registerItem("red_beryl", new Item(new FabricItemSettings().group(ModItemGroup.TTEGROUP)));
    public static final Item TOPAZ = registerItem("topaz", new Item(new FabricItemSettings().group(ModItemGroup.TTEGROUP)));

    //TOOLS
    public static final Item PERIDOT_SWORD = registerItem("peridot_sword", new SwordItem(ModToolMaterials.PERIDOT, 1, 2f, new FabricItemSettings().group(ModItemGroup.TTEGROUP)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(ThornsTitanExpansionMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        ThornsTitanExpansionMod.LOGGER.info("Registering Mod Items for " + ThornsTitanExpansionMod.MOD_ID);
    }
}
