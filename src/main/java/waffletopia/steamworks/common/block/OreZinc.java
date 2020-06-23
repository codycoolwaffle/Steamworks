package waffletopia.steamworks.common.block;

import com.arkevorkhat.orelib.OreRegistry;
import com.arkevorkhat.orelib.strategies.BiasedCountGenerationStrategy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class OreZinc extends SWBlock {
	public OreZinc() {
		super("ore_zinc",
			  Block.Properties.create(Material.ROCK)
					.harvestTool(ToolType.PICKAXE)
					.harvestLevel(1)
					.hardnessAndResistance(3f, 50f));
		OreRegistry.RegisterOre(this, new BiasedCountGenerationStrategy());
	}
}