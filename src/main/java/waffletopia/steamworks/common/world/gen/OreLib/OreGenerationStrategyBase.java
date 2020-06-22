package waffletopia.steamworks.common.world.gen.OreLib;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;

import java.util.List;

public abstract class OreGenerationStrategyBase {
    public abstract int getSize();
    public abstract List<Biome.Category> getBiomeCategories();
    public abstract boolean biomesAreWhitelisted();
    public abstract OreFeatureConfig getOreConfig();
    public abstract CountRangeConfig getCountRangeConfig();
}
