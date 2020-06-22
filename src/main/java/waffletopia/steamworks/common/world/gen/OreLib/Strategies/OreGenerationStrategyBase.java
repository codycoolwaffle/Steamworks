package waffletopia.steamworks.common.world.gen.OreLib.Strategies;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;

import java.util.List;

import vazkii.arl.block.BasicBlock;

public abstract class OreGenerationStrategyBase
{
	public abstract int getSize();
	
	public abstract List<Biome.Category> getBiomeCategories();
	
	public abstract boolean biomesAreWhitelisted();
	
	public abstract OreFeatureConfig getOreConfig(BasicBlock block);
	
	public abstract CountRangeConfig getGeneratorConfig();
	
	public abstract ConfiguredFeature<?, ?> getConfiguredFeature(BasicBlock block);
}
