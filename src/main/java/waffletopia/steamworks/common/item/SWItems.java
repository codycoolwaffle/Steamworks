package waffletopia.steamworks.common.item;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import vazkii.arl.util.RegistryHelper;

public class SWItems
{
	public static SWItem ingotZinc;
	public static SWItem ingotCopper;
	public static SWItem ingotBrass;
	
	public static DapperHat dapperHat;
	
	
	public static void itemSetup()
	{
		ingotZinc = new SWItem("ingot_zinc");
		ingotCopper = new SWItem("ingot_copper");
		ingotBrass = new SWItem("ingot_brass");
		
		dapperHat = new DapperHat();
	}
	
	public static void registerItems(RegistryEvent.Register<Item> evt)
	{
		IForgeRegistry<Item> r = evt.getRegistry();
		r.register(dapperHat.setRegistryName("steamworks", "dapper_helmet"));
	}
}
