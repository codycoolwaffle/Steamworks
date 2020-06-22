package waffletopia.steamworks.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.common.ToolType;
import waffletopia.steamworks.common.world.gen.OreLib.Strategies.OreGenerationStrategyFactory;
import waffletopia.steamworks.common.world.gen.OreLib.OreRegistry;


public class OreZinc extends SWBlock
{
	public OreZinc()
	{
		super("ore_zinc",
		      Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(1)
		                      .hardnessAndResistance(3f, 50f));
		OreRegistry.RegisterOre(this, new OreGenerationStrategyFactory()
				.withBiomeBlacklist(Biome.Category.NETHER, Biome.Category.THEEND)
				.withCountRangeConfig(new CountRangeConfig(20,1,1,123))
				.withOreFeatureConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
						this.getDefaultState(), 10))
				.getStrategy()
		);
	}
}
