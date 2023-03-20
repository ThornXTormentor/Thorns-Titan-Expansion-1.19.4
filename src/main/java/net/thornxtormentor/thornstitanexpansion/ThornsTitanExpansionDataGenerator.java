package net.thornxtormentor.thornstitanexpansion;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.thornxtormentor.thornstitanexpansion.data.ModLootTableGenerator;
import net.thornxtormentor.thornstitanexpansion.data.ModModelProvider;
import net.thornxtormentor.thornstitanexpansion.data.ModRecipieGenerator;
import net.thornxtormentor.thornstitanexpansion.data.ModWorldGenerator;
import net.thornxtormentor.thornstitanexpansion.world.ModConfiguredFeatures;
import net.thornxtormentor.thornstitanexpansion.world.ModPlacedFeatures;

public class ThornsTitanExpansionDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModLootTableGenerator::new);
        pack.addProvider(ModRecipieGenerator::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModWorldGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}
