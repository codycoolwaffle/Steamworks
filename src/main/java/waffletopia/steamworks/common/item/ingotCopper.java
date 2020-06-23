package waffletopia.steamworks.common.item;

import net.minecraft.item.Item;
import waffletopia.steamworks.common.core.SteamworksCreativeTab;

public class ingotCopper extends SWItem {
	public ingotCopper() {
		super("ingot_copper", new Item.Properties().maxStackSize(64).setNoRepair().group(SteamworksCreativeTab.INSTANCE));
	}
}
