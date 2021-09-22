package achristmasmod.library.biome;

import achristmasmod.content.ModUtils;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class BiomeKeys 
{
	public static final ResourceKey<Biome> WINTER_DESERT = register("winter_desert");
	public static final ResourceKey<Biome> WINTER_DESERT_HILLS = register("winter_desert_hills");
	public static final ResourceKey<Biome> WINTER_DESERT_LAKES = register("winter_desert_lakes");
	
	private static ResourceKey<Biome> register(String id)
	{
		return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtils.ID, id));
	}
}
