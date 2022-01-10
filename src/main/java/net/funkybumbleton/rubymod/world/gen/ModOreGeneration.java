package net.funkybumbleton.rubymod.world.gen;

import net.funkybumbleton.rubymod.world.feature.ModPlacedFeatures;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Set;
import java.util.List;
import java.util.function.Supplier;

public class ModOreGeneration
{
    public static void generateOres(final BiomeLoadingEvent event)
    {
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if(types.contains(BiomeDictionary.Type.MUSHROOM))
        {
            List<Supplier<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

            base.add(() -> ModPlacedFeatures.RUBY_ORE_PLACED);
        }
    }
}
