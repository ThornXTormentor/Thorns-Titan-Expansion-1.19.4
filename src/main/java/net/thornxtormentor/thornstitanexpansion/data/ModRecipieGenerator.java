package net.thornxtormentor.thornstitanexpansion.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.book.RecipeCategory;
import net.thornxtormentor.thornstitanexpansion.block.ModBlocks;
import net.thornxtormentor.thornstitanexpansion.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipieGenerator extends FabricRecipeProvider {
    public ModRecipieGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        //offerSmelting(exporter, List.of(ModItems.RAW_PERIDOT),RecipeCategory.MISC, ModItems.PERIDOT, 0.7f, 200, "ttegroup");
        //offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,ModItems.PERIDOT, RecipeCategory.DECORATIONS, ModBlocks.PERIDOT_BLOCK);
    }
}
