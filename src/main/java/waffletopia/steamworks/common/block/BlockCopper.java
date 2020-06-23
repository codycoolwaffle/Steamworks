package waffletopia.steamworks.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import waffletopia.steamworks.common.core.SteamworksCreativeTab;

public class BlockCopper extends SWBlock
{
	public BlockCopper()
	{
		super("block_copper",
		      Block.Properties.create(Material.IRON)
		                      .hardnessAndResistance(5f, 75f)
		                      .harvestLevel(1)
		                      .harvestTool(ToolType.PICKAXE),
		      SteamworksCreativeTab.INSTANCE);
	}
}
