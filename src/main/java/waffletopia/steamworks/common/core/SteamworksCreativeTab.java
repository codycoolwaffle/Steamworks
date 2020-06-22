package waffletopia.steamworks.common.core;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import waffletopia.steamworks.common.LibMisc;
import waffletopia.steamworks.common.block.SWBlocks;

public class SteamworksCreativeTab extends ItemGroup
{
	public static final SteamworksCreativeTab INSTANCE = new SteamworksCreativeTab();
	
	public SteamworksCreativeTab()
	{
		super(LibMisc.MOD_ID);
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(SWBlocks.oreZinc);
	}
}
