package achristmasmod.content.server.init;

import achristmasmod.content.ModRegistry;
import achristmasmod.content.ModUtils;
import achristmasmod.library.biome.biomes.desert.WinterDesert;
import net.minecraft.world.level.biome.Biome;

public class BiomeInit 
{
	//public static final Biome WINTER_PLAINS
	
	public static final Biome WINTER_DESERT = ModRegistry.registry("winter_desert", WinterDesert.create(0.125F, 0.05F, true, true, true));
	public static final Biome WINTER_DESERT_HILLS = ModRegistry.registry("winter_desert_hills", WinterDesert.create(0.45F, 0.3F, false, true, false));
	public static final Biome WINTER_DESERT_LAKES = ModRegistry.registry("winter_desert_lakes", WinterDesert.create(0.225F, 0.25F, false, false, false));
	
	public static void init() { ModUtils.LOGGER.debug("Registering Mod Biomes"); }
}
