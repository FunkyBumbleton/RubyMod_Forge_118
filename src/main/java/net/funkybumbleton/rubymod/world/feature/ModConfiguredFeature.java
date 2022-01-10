package net.funkybumbleton.rubymod.world.feature;

import net.funkybumbleton.rubymod.block.ModBlocks;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeature
{
    public static final  List<OreConfiguration.TargetBlockState> OVERWORLD_RUBY_ORE = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.RUBY_BLOCK.get().defaultBlockState())
    );

    public static final ConfiguredFeature<?, ?> RUBY_ORE =
            FeatureUtils.register("ruby_ore",
                    Feature.ORE.configured(new OreConfiguration(OVERWORLD_RUBY_ORE, 9)));
}
