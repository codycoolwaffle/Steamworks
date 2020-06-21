package waffletopia.steamworks.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;

public class Ore
{
	public static Block ore_zinc = new Block(
			Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(1)
			                .hardnessAndResistance(3f, 50f))
			.setRegistryName("steamworks", "ore_zinc");
	public static BlockItem item_ore_zinc = new BlockItem(ore_zinc, new Item.Properties());
}
