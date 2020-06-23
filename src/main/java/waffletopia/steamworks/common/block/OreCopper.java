package waffletopia.steamworks.common.block;

import com.arkevorkhat.orelib.OreRegistry;
import com.arkevorkhat.orelib.strategies.BiasedCountGenerationStrategy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;


public class OreCopper extends SWBlock
{
	public OreCopper()
	{
		super("ore_copper",
		      Block.Properties.create(Material.ROCK)
		                      .harvestTool(ToolType.PICKAXE)
		                      .harvestLevel(1)
		                      .hardnessAndResistance(3f, 50f));
		
		OreRegistry.RegisterOre(this, new BiasedCountGenerationStrategy());
	}
}
