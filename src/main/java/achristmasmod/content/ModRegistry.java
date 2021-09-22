package achristmasmod.content;

import achristmasmod.content.server.init.BiomeInit;
import achristmasmod.content.server.init.WorldTypeInit;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.world.ForgeWorldType;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRegistry 
{
	public static Biome registry(String id, Biome biome)
	{
		biome.setRegistryName(ModUtils.rL(id));
		ForgeRegistries.BIOMES.register(biome);
		return biome;
	}
	
	public static ForgeWorldType register(String id, ForgeWorldType worldType)
	{
		worldType.setRegistryName(ModUtils.rL(id));
		ForgeRegistries.WORLD_TYPES.register(worldType);
		return worldType;
	}
	
	public static void register()
	{
		BiomeInit.init();
		WorldTypeInit.init();
	}
}
