package net.thornxtormentor.thornstitanexpansion.world;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.thornxtormentor.thornstitanexpansion.ThornsTitanExpansionMod;
import net.thornxtormentor.thornstitanexpansion.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PERIDOT_ORE_KEY = registerKey("peridot_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AQUAMARINE_ORE_KEY = registerKey("aquamarine_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_BERYL_ORE_KEY = registerKey("red_beryl_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOPAZ_ORE_KEY = registerKey("topaz_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AMETHYST_ORE_KEY = registerKey("amethyst_ore");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        //Checks if stone/deepslate can be replaced
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        //List of Ores to replace, needed for each Ore
        List<OreFeatureConfig.Target> overworldPeridotOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.PERIDOT_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_PERIDOT_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldAquamarineOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.AQUAMARINE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_AQUAMARINE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldRedBerylOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.RED_BERYL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_RED_BERYL_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldTopazOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.TOPAZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_TOPAZ_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldAmethystOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.AMETHYST_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_AMETHYST_ORE.getDefaultState()));

        register(context, PERIDOT_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPeridotOres, 6));
        register(context, AQUAMARINE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldAquamarineOres, 6));
        register(context, RED_BERYL_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldRedBerylOres, 6));
        register(context, TOPAZ_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTopazOres, 6));
        register(context, AMETHYST_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldAmethystOres, 6));

        //GEODEs for future use

        //Amethyst Geode already implemented
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(ThornsTitanExpansionMod.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
