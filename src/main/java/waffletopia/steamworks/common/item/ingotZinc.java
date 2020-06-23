package waffletopia.steamworks.common.item;

import net.minecraft.item.Item;

import waffletopia.steamworks.common.core.SteamworksCreativeTab;

public class ingotZinc extends SWItem
{
	public ingotZinc()
	{
		super("ingot_zinc",
		      new Item.Properties().maxStackSize(64)
		                           .setNoRepair()
		                           .group(SteamworksCreativeTab.INSTANCE));
	}
}

