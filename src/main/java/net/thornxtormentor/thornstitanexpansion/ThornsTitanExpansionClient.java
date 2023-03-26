package net.thornxtormentor.thornstitanexpansion;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.impl.client.rendering.ColorProviderRegistryImpl;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;
import net.thornxtormentor.thornstitanexpansion.block.ModBlocks;
import net.thornxtormentor.thornstitanexpansion.item.ModItems;

public class ThornsTitanExpansionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JUICY_BERRY_BUSH_BLOCK, RenderLayer.getCutout());

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return FoliageColors.getColor(0.5, 1.0);
            }
            return BiomeColors.getFoliageColor(world, pos);
        }, ModBlocks.JUICY_BERRY_BUSH_BLOCK);

        ColorProviderRegistry.ITEM.register((stack, layer) -> {
            return FoliageColors.getColor(0.5, 1.0);
        }, ModBlocks.JUICY_BERRY_BUSH_BLOCK.asItem());
    }
}
