package net.thornxtormentor.thornstitanexpansion.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thornxtormentor.thornstitanexpansion.ThornsTitanExpansionMod;

public class ModItems {
    //ORE
    public static final Item RAW_PERIDOT = registerItem("raw_peridot", new Item(new FabricItemSettings()));
    public static final Item RAW_AQUAMARINE = registerItem("raw_aquamarine", new Item(new FabricItemSettings()));
    public static final Item RAW_RED_BERYL = registerItem("raw_red_beryl", new Item(new FabricItemSettings()));
    public static final Item RAW_TOPAZ = registerItem("raw_topaz", new Item(new FabricItemSettings()));
    public static final Item RAW_AMETHYST = registerItem("raw_amethyst", new Item(new FabricItemSettings()));

    //GEMS
    public static final Item PERIDOT = registerItem("peridot", new Item(new FabricItemSettings()));
    public static final Item AQUAMARINE = registerItem("aquamarine", new Item(new FabricItemSettings()));
    public static final Item RED_BERYL = registerItem("red_beryl", new Item(new FabricItemSettings()));
    public static final Item TOPAZ = registerItem("topaz", new Item(new FabricItemSettings()));
    public static final Item AMETHYST = registerItem("amethyst", new Item(new FabricItemSettings()));

    //TOOLS
    //public static final Item PERIDOT_SWORD = registerItem("peridot_sword", new SwordItem(ModToolMaterials.PERIDOT, 1, 2f, new FabricItemSettings().group(ModItemGroup.TTEGroup)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(ThornsTitanExpansionMod.MOD_ID, name), item);
    }

    //Add each item to the mod item group
    public static void addItemsToItemGroup(){
        addToItemGroup(ModItemGroup.TTEGroup, RAW_PERIDOT);
        addToItemGroup(ModItemGroup.TTEGroup, RAW_AQUAMARINE);
        addToItemGroup(ModItemGroup.TTEGroup, RAW_RED_BERYL);
        addToItemGroup(ModItemGroup.TTEGroup, RAW_TOPAZ);
        addToItemGroup(ModItemGroup.TTEGroup, RAW_AMETHYST);
        addToItemGroup(ModItemGroup.TTEGroup, PERIDOT);
        addToItemGroup(ModItemGroup.TTEGroup, AQUAMARINE);
        addToItemGroup(ModItemGroup.TTEGroup, RED_BERYL);
        addToItemGroup(ModItemGroup.TTEGroup, TOPAZ);
        addToItemGroup(ModItemGroup.TTEGroup, AMETHYST);
    }

    public static void addToItemGroup(ItemGroup itemGroup, Item item){
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(item));
    }

    public static void registerModItems(){
        ThornsTitanExpansionMod.LOGGER.info("Registering Mod Items for " + ThornsTitanExpansionMod.MOD_ID);
        addItemsToItemGroup();
    }
}
