package waffletopia.steamworks.common.block;

import com.arkevorkhat.orelib.OreRegistry;
import com.arkevorkhat.orelib.strategies.BiasedCountGenerationStrategy;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.ToolType;
import waffletopia.steamworks.common.HarvestLevel;
import waffletopia.steamworks.common.core.SteamworksCreativeTab;
import waffletopia.steamworks.common.item.SWItems;

import javax.annotation.ParametersAreNonnullByDefault;

public class SWBlocks {
	public static SWBlock oreZinc;
	public static SWBlock oreCopper;
	
	public static SWBlock blockCopper;
	public static SWBlock blockZinc;
	
	public static BlockFerrousCharcoal blockFerrousCharcoal;
	public static SWBlock blockIronBloom;
	public static SWBlock blockHammeredIronBloom;
	public static SWBlock blockOxidizedIronBloom;
	public static SWBlock blockCharcoal;
	
	
	public static void blockSetup() {
		blockCharcoal = new SWBlock("charcoal",
			  Block.Properties.create(Material.ROCK)
					.harvestTool(ToolType.PICKAXE)
					.harvestLevel(HarvestLevel.WOOD)
					.hardnessAndResistance(5f, 75f));
		oreZinc = new SWBlock("ore_zinc",
			  Block.Properties.create(Material.ROCK)
					.harvestTool(ToolType.PICKAXE)
					.harvestLevel(1)
					.hardnessAndResistance(3f, 50f));
		oreCopper = new SWBlock("ore_copper", Block.Properties.from(oreZinc));
		blockCopper = new SWBlock("block_copper",
			  Block.Properties.create(Material.IRON)
					.hardnessAndResistance(5f, 75f)
					.harvestLevel(1)
					.harvestTool(ToolType.PICKAXE));
		blockZinc = new SWBlock("block_zinc", Block.Properties.from(blockCopper));
		blockFerrousCharcoal = new BlockFerrousCharcoal();
		blockHammeredIronBloom = new SWBlock("block_hammered_iron_bloom",
			  Block.Properties.create(Material.IRON)
					.harvestLevel(HarvestLevel.IRON)
					.hardnessAndResistance(3f, 50f)
					.harvestTool(ToolType.PICKAXE));
		blockIronBloom = new SWBlock("block_iron_bloom", Block.Properties.create(Material.IRON)) {
			@Override
			@SuppressWarnings("deprecation")
			@ParametersAreNonnullByDefault
			public ActionResultType onBlockActivated(BlockState state,
			                                         World worldIn,
			                                         BlockPos pos,
			                                         PlayerEntity player,
			                                         Hand handIn,
			                                         BlockRayTraceResult hit) {
				if (worldIn.isRemote) return ActionResultType.PASS;
				else {
					ItemStack tool = player.getHeldItem(handIn);
					if (tool.getToolTypes().contains(ToolType.PICKAXE)) {
						tool.damageItem(2, player, (t) -> worldIn.playSound(t,
							  pos,
							  SoundEvents.ENTITY_ITEM_BREAK,
							  SoundCategory.AMBIENT,
							  1f,
							  0.9f));
						worldIn.setBlockState(pos, blockHammeredIronBloom.getDefaultState());
						worldIn.playSound(pos.getX(),
							  pos.getY(),
							  pos.getZ(),
							  SoundEvents.BLOCK_ANVIL_USE,
							  SoundCategory.BLOCKS,
							  1f,
							  1f,
							  false);
						InventoryHelper.spawnItemStack(worldIn,
							  pos.getX() + 0.5,
							  pos.getY() + 0.5,
							  pos.getZ() + 0.5,
							  new ItemStack(SWItems.nuggetSteel,
									worldIn.rand.nextInt(2) + worldIn.rand.nextInt(2)));
						InventoryHelper.spawnItemStack(worldIn,
							  pos.getX() + 0.51,
							  pos.getY() + 0.5,
							  pos.getZ() + 0.5,
							  new ItemStack(Items.IRON_NUGGET,
									worldIn.rand.nextInt(4) + worldIn.rand.nextInt(4)));
					}
				}
				return ActionResultType.PASS;
			}
		};
		
		OreRegistry.RegisterOre(oreCopper, new BiasedCountGenerationStrategy());
		OreRegistry.RegisterOre(oreZinc, new BiasedCountGenerationStrategy());
	}
}
