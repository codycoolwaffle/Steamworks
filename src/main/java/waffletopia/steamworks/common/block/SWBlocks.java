package waffletopia.steamworks.common.block;

import com.arkevorkhat.orelib.OreRegistry;
import com.arkevorkhat.orelib.strategies.BiasedCountGenerationStrategy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SWBlocks
{
	public static SWBlock oreZinc;
	public static SWBlock oreCopper;
	
	public static SWBlock blockCopper;
	public static SWBlock blockZinc;
	
	
	public static void blockSetup()
	{
		oreZinc = new SWBlock("ore_zinc",
		                      Block.Properties.create(Material.ROCK)
		                                      .harvestTool(ToolType.PICKAXE)
		                                      .harvestLevel(1)
		                                      .hardnessAndResistance(3f, 50f));
		oreCopper = new SWBlock("ore_copper", Block.Properties.from(oreZinc));
		blockCopper = new SWBlock("block_copper", Block.Properties.create(Material.IRON)
		                                              .hardnessAndResistance(5f, 75f)
		                                              .harvestLevel(1)
		                                              .harvestTool(ToolType.PICKAXE));
		blockZinc = new SWBlock("block_zinc", Block.Properties.from(blockCopper));
		
		
		OreRegistry.RegisterOre(oreCopper, new BiasedCountGenerationStrategy());
		OreRegistry.RegisterOre(oreZinc, new BiasedCountGenerationStrategy());
	}
}
