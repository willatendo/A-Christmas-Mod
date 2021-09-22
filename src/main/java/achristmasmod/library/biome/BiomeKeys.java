package achristmasmod.library.biome;

import achristmasmod.content.ModUtils;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class BiomeKeys 
{
	public static final ResourceKey<Biome> WINTER_PLAINS = register("winter_plains");
	public static final ResourceKey<Biome> WINTER_SUNFLOWER_PLAINS = register("winter_sunflower_plains");

	public static final ResourceKey<Biome> WINTER_FOREST = register("winter_forest");
	public static final ResourceKey<Biome> WINTER_FOREST_HILLS = register("winter_forest_hills");
	public static final ResourceKey<Biome> WINTER_FLOWER_FOREST = register("winter_flower_forest");

	public static final ResourceKey<Biome> WINTER_MOUNTAINS = register("winter_mountains");
	public static final ResourceKey<Biome> WINTER_MOUNTAINS_HILLS = register("winter_mountains_hills");
	public static final ResourceKey<Biome> WINTER_WOODED_MOUNTAINS = register("winter_wooded_mountains");
	public static final ResourceKey<Biome> WINTER_GRAVELLY_MOUNTAINS = register("winter_gravelly_mountains");
	public static final ResourceKey<Biome> WINTER_MODIFIED_GRAVELLY_MOUNTAINS = register("winter_modified_gravelly_mountains"); 

	public static final ResourceKey<Biome> WINTER_TAIGA = register("winter_taiga");
	public static final ResourceKey<Biome> WINTER_TAIGA_HILLS = register("winter_taiga_hills");
	public static final ResourceKey<Biome> SNOWY_WINTER_TAIGA = register("snowy_winter_taiga");
	public static final ResourceKey<Biome> SNOWY_WINTER_TAIGA_HILLS = register("snowy_winter_taiga_hills");
	public static final ResourceKey<Biome> WINTER_TAIGA_MOUNTAINS = register("winter_taiga_mountains"); 
	public static final ResourceKey<Biome> SNOWY_WINTER_TAIGA_MOUNTAINS = register("snowy_winter_taiga_mountains"); 

	public static final ResourceKey<Biome> WINTER_SWAMP = register("winter_swamp");
	public static final ResourceKey<Biome> WINTER_SWAMP_HILLS = register("winter_swamp_hills");

	public static final ResourceKey<Biome> WINTER_DESERT = register("winter_desert");
	public static final ResourceKey<Biome> WINTER_DESERT_HILLS = register("winter_desert_hills");
	public static final ResourceKey<Biome> WINTER_DESERT_LAKES = register("winter_desert_lakes");
	
	private static ResourceKey<Biome> register(String id)
	{
		return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtils.ID, id));
	}
}
