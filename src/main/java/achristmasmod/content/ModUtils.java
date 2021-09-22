package achristmasmod.content;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.resources.ResourceLocation;

public class ModUtils 
{
	public static final Logger LOGGER = LogManager.getLogger(ModUtils.ID);
	
	public static final String ID = "achristmasmod";
	
	public static ResourceLocation rL(String path)
	{
		return new ResourceLocation(ID, path);
	}
}
