package waffletopia.steamworks.common.world.gen.OreLib;

import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.registries.ForgeRegistries;

import vazkii.arl.block.BasicBlock;
import waffletopia.steamworks.common.world.gen.OreLib.Strategies.OreGenerationStrategyBase;


public class OreRegistry
{
	public static void RegisterOre(BasicBlock block, OreGenerationStrategyBase generatorOptions)
	{
		ForgeRegistries.BIOMES.getValues()
		                      .stream()
		                      .filter(biome -> (generatorOptions.getBiomeCategories()
		                                                        .contains(biome.getCategory()))
		                                       == generatorOptions.biomesAreWhitelisted())
		                      .forEach(biome -> {
			                      biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
			                                       generatorOptions.getConfiguredFeature(block));
		                      });
	}
}