package achristmasmod.library.biome.biomes.forest;

import achristmasmod.library.biome.ModBiomeMaker;
import achristmasmod.library.biome.biomes.SimpleBiome;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class WinterBirchForest extends SimpleBiome
{
	public static final MobSpawnSettings.Builder MOB_SPAWNS = defaultOverworldSpawns();
	public static final BiomeGenerationSettings.Builder GENERATION = new BiomeGenerationSettings.Builder();
	
	private static boolean tall;
	
	static
	{
		addSpawns();
		addGeneration();
	}
	
	static void addSpawns() 
	{
		BiomeDefaultFeatures.farmAnimals(MOB_SPAWNS);
		BiomeDefaultFeatures.commonSpawns(MOB_SPAWNS);
	}
	
	static void addGeneration() 
	{
		BiomeDefaultFeatures.addDefaultOverworldLandStructures(GENERATION);
		GENERATION.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		BiomeDefaultFeatures.addDefaultCarvers(GENERATION);
		BiomeDefaultFeatures.addDefaultLakes(GENERATION);
		BiomeDefaultFeatures.addDefaultCrystalFormations(GENERATION);
		BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION);
		BiomeDefaultFeatures.addForestFlowers(GENERATION);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION);
		BiomeDefaultFeatures.addDefaultOres(GENERATION);
		BiomeDefaultFeatures.addDefaultSoftDisks(GENERATION);
		if(tall) 
		{
			BiomeDefaultFeatures.addTallBirchTrees(GENERATION);
		} 
		else 
		{
			BiomeDefaultFeatures.addBirchTrees(GENERATION);
		}
		
		BiomeDefaultFeatures.addDefaultFlowers(GENERATION);
		BiomeDefaultFeatures.addForestGrass(GENERATION);
		BiomeDefaultFeatures.addDefaultMushrooms(GENERATION);
		BiomeDefaultFeatures.addDefaultExtraVegetation(GENERATION);
		BiomeDefaultFeatures.addDefaultSprings(GENERATION);
		BiomeDefaultFeatures.addSurfaceFreezing(GENERATION);
	}
	
	public static Biome create(float depth, float scale, boolean tallForest)
	{
		tall = tallForest;
		return ModBiomeMaker.create(Precipitation.SNOW, BiomeCategory.FOREST, depth, scale, -0.5F, 0.8F, 4159204, 329011, 12638463, calculateSkyColor(0.6F), MOB_SPAWNS.build(), GENERATION.build());
	}
}
