package achristmasmod.content.server;

import achristmasmod.content.client.book.StoryBooks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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
		
		bus.addListener(this::clientSetup);
	}
	
	private void clientSetup(FMLClientSetupEvent event) 
	{		
		StoryBooks.initBooks();
	}
}
