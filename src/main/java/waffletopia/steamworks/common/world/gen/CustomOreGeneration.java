package waffletopia.steamworks.common.world.gen;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.registries.ForgeRegistries;

import waffletopia.steamworks.common.block.SWBlocks;

public class CustomOreGeneration
{
	public static void generateOre()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
					.withConfiguration(
							new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
							                     SWBlocks.oreZinc.getDefaultState(), 10))
					.withPlacement(
							Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 123))));
			//Count:        frequency
			//bottomOffset: minY1
			//topOffset:    minY2
			//maximum:      maxY
		}
	}
}
