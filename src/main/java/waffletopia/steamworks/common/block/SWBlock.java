package waffletopia.steamworks.common.block;

import net.minecraft.item.ItemGroup;

import vazkii.arl.block.BasicBlock;
import vazkii.arl.util.RegistryHelper;
import waffletopia.steamworks.common.core.SteamworksCreativeTab;

public class SWBlock extends BasicBlock
{
	
	//default constructor
	public SWBlock(String regname, Properties properties)
	{
		super(regname, properties);
		RegistryHelper.setCreativeTab(this, SteamworksCreativeTab.INSTANCE);
	}
	
	//constructor with custom creative tab
	public SWBlock(String regname, Properties properties, ItemGroup group)
	{
		super(regname, properties);
		RegistryHelper.setCreativeTab(this, group);
	}
}
