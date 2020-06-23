package waffletopia.steamworks;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import waffletopia.steamworks.common.LibMisc;
import waffletopia.steamworks.common.block.SWBlocks;
import waffletopia.steamworks.common.item.SWItems;

@Mod(LibMisc.MOD_ID)
public class SteamWorks
{
	private static final Logger LOGGER = LogManager.getLogger();
	
	public SteamWorks()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		MinecraftForge.EVENT_BUS.register(this);
		
		SWBlocks.blockSetup();
		SWItems.itemSetup();
	}
	
	//new preInit
	private void setup(final FMLCommonSetupEvent event)
	{
	
	}
	
	//Client side
	private void doClientStuff(final FMLClientSetupEvent event)
	{
		//LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
	}
	
	//InterMod Communication
	//Sending
	private void enqueueIMC(final InterModEnqueueEvent event)
	{
		/*InterModComms.sendTo("steamworks", "helloworld", () -> {
			LOGGER.info("Hello world from the MDK");
			return "Hello world";
		});*/
	}
	
	//Receiving
	private void processIMC(final InterModProcessEvent event)
	{
		/*LOGGER.info("Got IMC {}", event.getIMCStream().
				map(m -> m.getMessageSupplier().get()).
				                               collect(Collectors.toList()));*/
	}
	
	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event)
	{
		// do something when the server starts
		LOGGER.info("HELLO from server starting");
	}
}