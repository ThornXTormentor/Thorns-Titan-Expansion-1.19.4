package net.thornxtormentor.thornstitanexpansion.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.thornxtormentor.thornstitanexpansion.block.ModBlocks;
import net.thornxtormentor.thornstitanexpansion.item.ModItems;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {

    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.PERIDOT_BLOCK);

        oreDrops(ModBlocks.PERIDOT_ORE, ModItems.RAW_PERIDOT);
        oreDrops(ModBlocks.DEEPSLATE_PERIDOT_ORE, ModItems.RAW_PERIDOT);
    }
}
