package waffletopia.steamworks.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraftforge.common.ToolType;
import waffletopia.steamworks.common.HarvestLevel;

public class SteamPipe extends SWBlock {
	
	public final BooleanProperty north = BooleanProperty.create("north");
	
	public SteamPipe(){
		super("pipe", Block.Properties.create(Material.IRON)
			  .harvestTool(ToolType.PICKAXE)
			  .harvestLevel(HarvestLevel.STONE));
	}
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder){
		builder.add(north);
	}
}
