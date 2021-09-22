package achristmasmod.content.server.init;

import achristmasmod.content.ModRegistry;
import achristmasmod.content.ModUtils;
import achristmasmod.library.worldtype.WinterWorldType;
import net.minecraftforge.common.world.ForgeWorldType;

public class WorldTypeInit 
{
	public static final ForgeWorldType WINTER = ModRegistry.register("winter", new WinterWorldType());
	
	public static void init() { ModUtils.LOGGER.debug("Registering Mod World Types"); }
}
