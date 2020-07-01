package waffletopia.steamworks.common.block;

import io.netty.util.internal.SuppressJava6Requirement;
import jdk.nashorn.internal.ir.annotations.Ignore;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.ToolType;
import waffletopia.steamworks.common.HarvestLevel;

import javax.annotation.ParametersAreNonnullByDefault;

public class BlockCharcoalLayer extends SWBlock {
	public static final IntegerProperty LAYER_COUNT = BlockStateProperties.LAYERS_1_8;
	protected static final VoxelShape[] SHAPES = new VoxelShape[]{
		  VoxelShapes.empty(),
		  Block.makeCuboidShape(0d, 0d, 0d, 16d, 2d, 16d),
		  Block.makeCuboidShape(0d, 0d, 0d, 16d, 4d, 16d),
		  Block.makeCuboidShape(0d, 0d, 0d, 16d, 6d, 16d),
		  Block.makeCuboidShape(0d, 0d, 0d, 16d, 8d, 16d),
		  Block.makeCuboidShape(0d, 0d, 0d, 16d, 10d, 16d),
		  Block.makeCuboidShape(0d, 0d, 0d, 16d, 12d, 16d),
		  Block.makeCuboidShape(0d, 0d, 0d, 16d, 14d, 16d),
		  Block.makeCuboidShape(0d, 0d, 0d, 16d, 16d, 16d)
		  
	};
	public BlockCharcoalLayer() {
		super("charcoal_layer",
			  Block.Properties.create(Material.ORGANIC)
					.harvestTool(ToolType.SHOVEL)
					.harvestLevel(HarvestLevel.WOOD)
					.hardnessAndResistance(1f, 1f));
	}
	@Override
	@SuppressWarnings("deprecation")
	@ParametersAreNonnullByDefault
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context){
		return SHAPES[state.get(LAYER_COUNT)];
	}
	@Override
	@SuppressWarnings("deprecation")
	@ParametersAreNonnullByDefault
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES[state.get(LAYER_COUNT) - 1];
	}
	@Override
	@ParametersAreNonnullByDefault
	public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state){
		if(worldIn.isRemote()) return;
		if(state.get(LAYER_COUNT) > 1 ){
			worldIn.setBlockState(pos, state.with(LAYER_COUNT, state.get(LAYER_COUNT) - 1), 3);
		}
		InventoryHelper.spawnItemStack(worldIn.getWorld(),
			  pos.getX(),
			  pos.getY(),
			  pos.getZ(),
			  Items.CHARCOAL.getDefaultInstance());
	}
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(LAYER_COUNT);
	}
}
