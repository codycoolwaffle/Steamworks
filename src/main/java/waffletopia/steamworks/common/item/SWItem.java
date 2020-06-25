package waffletopia.steamworks.common.item;

import net.minecraft.item.Item;

import vazkii.arl.item.BasicItem;
import waffletopia.steamworks.common.core.SteamworksCreativeTab;

public class SWItem extends BasicItem
{
	public SWItem(String regname)
	{
		super(regname,
		      new Item.Properties().maxStackSize(64)
		                           .setNoRepair()
		                           .group(SteamworksCreativeTab.INSTANCE));
	}
	
	public SWItem(String regname, Properties properties)
	{
		super(regname, properties);
	}
}