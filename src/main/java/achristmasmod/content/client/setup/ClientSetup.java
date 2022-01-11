package achristmasmod.content.client.setup;

import achristmasmod.content.server.ModUtils;
import achristmasmod.library.block.MiscBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = ModUtils.ID, bus = Bus.MOD)
public class ClientSetup 
{
	@SubscribeEvent
	public static void setupClient(FMLClientSetupEvent event)
	{
		RenderTypeLookup.setRenderLayer(MiscBlocks.SPIKE_BARS.getBlock(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(MiscBlocks.GINGERBREAD_HOUSE.getBlock(), RenderType.translucent());
	}
}
