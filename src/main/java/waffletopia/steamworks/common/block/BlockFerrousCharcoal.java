package waffletopia.steamworks.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

import javax.annotation.ParametersAreNonnullByDefault;

public class BlockFerrousCharcoal extends SWBlock
{
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_15;
	public static final IntegerProperty DAMAGE = IntegerProperty.create("damage", 0, 3);
	public static final BooleanProperty IS_BURNING = BooleanProperty.create("is_burning");
	public static final BooleanProperty IS_MULTIBLOCK_VALID = BooleanProperty.create(
			"multiblock_valid");
	
	public BlockFerrousCharcoal()
	{
		super("ferrous_charcoal", Block.Properties.create(Material.ROCK, DyeColor.BROWN));
	}
	
	@ParametersAreNonnullByDefault
	public boolean ticksRandomly(BlockState state)
	{
		return isMaxAge(state);
	}
	
	public boolean isMaxAge(BlockState state)
	{
		return state.get(AGE) >= 15;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	@ParametersAreNonnullByDefault
	public ActionResultType onBlockActivated(BlockState state,
	                                         World worldIn,
	                                         BlockPos pos,
	                                         PlayerEntity player,
	                                         Hand handIn,
	                                         BlockRayTraceResult hit)
	{
		if(worldIn.isRemote())
			return ActionResultType.PASS;
		else
		{
			if(player.getHeldItem(handIn)
			         .isItemEqualIgnoreDurability(Items.FLINT_AND_STEEL.getDefaultInstance()))
			{
				worldIn.setBlockState(pos, state.with(IS_BURNING, true));
				return ActionResultType.SUCCESS;
			}
			else
			{
				return ActionResultType.PASS;
			}
		}
	}
	
	public void validateMultiBlock(BlockState state, ServerWorld worldIn, BlockPos pos)
	{
		worldIn.setBlockState(pos,
		                      state.with(IS_MULTIBLOCK_VALID,
		                                 worldIn.getBlockState(pos.add(0, -2, 0)).isSolid()
		                                 && worldIn.getBlockState(pos.add(0, -1, 0))
		                                    == SWBlocks.blockCharcoal.getDefaultState()
		                                 && worldIn.getBlockState(pos.add(-1, -1, -1)).isSolid()
		                                 && worldIn.getBlockState(pos.add(1, -1, -1)).isSolid()
		                                 && worldIn.getBlockState(pos.add(-1, -1, 1)).isSolid()
		                                 && worldIn.getBlockState(pos.add(1, -1, 1)).isSolid()
		                                 && worldIn.getBlockState(pos.add(-1, 0, -1)).isSolid()
		                                 && worldIn.getBlockState(pos.add(1, 0, -1)).isSolid()
		                                 && worldIn.getBlockState(pos.add(-1, 0, 1)).isSolid()
		                                 && worldIn.getBlockState(pos.add(1, 0, 1)).isSolid()
		                                 && worldIn.getBlockState(pos.add(0, 1, 0)).isSolid()
		                                 && worldIn.getBlockState(pos) == this.getDefaultState()));
	}
	
	@Override
	@SuppressWarnings("deprecation")
	@ParametersAreNonnullByDefault
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random)
	{
		super.tick(state, worldIn, pos, random);
		if(!worldIn.isAreaLoaded(pos, 1))
			return;
		if(random.nextInt(8) == 0)
		{
			this.validateMultiBlock(state, worldIn, pos);
			if(state.get(IS_BURNING))
			{
				if(!state.get(IS_MULTIBLOCK_VALID))
				{
					if(state.get(DAMAGE) >= 3)
					{
						worldIn.setBlockState(pos,
						                      SWBlocks.blockOxidizedIronBloom.getDefaultState());
					}
				}
				else
				{
					if(!isMaxAge(state))
					{
						worldIn.setBlockState(pos, state.with(AGE, state.get(AGE) + 1));
					}
					else
					{
						
						worldIn.setBlockState(pos, SWBlocks.blockIronBloom.getDefaultState());
					}
				}
			}
			else
				if(state.get(IS_MULTIBLOCK_VALID))
				{
					for(BlockState b : new BlockState[]{worldIn.getBlockState(pos.add(-1, 0, 0)),
					                                    worldIn.getBlockState(pos.add(1, 0, 0)),
					                                    worldIn.getBlockState(pos.add(0, 0, -1)),
					                                    worldIn.getBlockState(pos.add(0, 0, 1))})
					{
						if(random.nextInt(2) == 0
						   && b.get(IS_BURNING)
						   && b.get(IS_MULTIBLOCK_VALID))
						{
							worldIn.setBlockState(pos, state.with(IS_BURNING, true));
						}
					}
				}
		}
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
	{
		builder.add(AGE);
		builder.add(DAMAGE);
		builder.add(IS_MULTIBLOCK_VALID);
		builder.add(IS_BURNING);
	}
}

