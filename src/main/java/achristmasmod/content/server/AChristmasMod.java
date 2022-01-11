package achristmasmod.content.server;

import achristmasmod.content.client.book.StoryBooks;
import achristmasmod.library.block.StockingBlock.StockingBlocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tyrannotitanlib.library.TyrannotitanMod;

@Mod(ModUtils.ID)
public class AChristmasMod 
{
	public AChristmasMod() 
	{
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		TyrannotitanMod.init(ModUtils.ID);
		ModRegistry.register();
		
		bus.addListener(this::commonSetup);
		bus.addListener(this::clientSetup);
	}
	
	private void commonSetup(FMLCommonSetupEvent event) 
	{
		ModUtils.CHRISTMAS.setIcon(StockingBlocks.GREEN_STOCKING.getBlock().asItem().getDefaultInstance());
		ModUtils.HANUKKAH.setIcon(StockingBlocks.GREEN_STOCKING.getBlock().asItem().getDefaultInstance());
		ModUtils.KWANZAA.setIcon(StockingBlocks.GREEN_STOCKING.getBlock().asItem().getDefaultInstance());
	}
	
	private void clientSetup(FMLClientSetupEvent event) 
	{		
		StoryBooks.initBooks();
	}
}
