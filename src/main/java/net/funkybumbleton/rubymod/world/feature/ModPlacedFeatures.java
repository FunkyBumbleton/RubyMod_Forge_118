package net.funkybumbleton.rubymod.world.feature;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class ModPlacedFeatures
{
    public static final PlacedFeature RUBY_ORE_PLACED = PlacementUtils.register("ruby_ore_placed",
            ModConfiguredFeature.RUBY_ORE.placed(ModOrePlacement.commonOrePlacement(20, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(30), VerticalAnchor.aboveBottom(100)))));
}
