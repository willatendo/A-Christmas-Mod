package achristmasmod.library.biome.biomes.forest;

import achristmasmod.library.biome.ModBiomeMaker;
import achristmasmod.library.biome.biomes.SimpleBiome;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.levelgen.GenerationStep;

public class WinterDarkForest extends SimpleBiome
{
	public static final MobSpawnSettings.Builder MOB_SPAWNS = defaultOverworldSpawns();
	public static final BiomeGenerationSettings.Builder GENERATION = new BiomeGenerationSettings.Builder();
	
	private static boolean mushroom;
	
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
		GENERATION.addStructureStart(StructureFeatures.WOODLAND_MANSION);
		BiomeDefaultFeatures.addDefaultOverworldLandStructures(GENERATION);
		GENERATION.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		BiomeDefaultFeatures.addDefaultCarvers(GENERATION);
		BiomeDefaultFeatures.addDefaultLakes(GENERATION);
		BiomeDefaultFeatures.addDefaultCrystalFormations(GENERATION);
		BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION);
		GENERATION.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, mushroom ? Features.DARK_FOREST_VEGETATION_RED : Features.DARK_FOREST_VEGETATION_BROWN);
		BiomeDefaultFeatures.addForestFlowers(GENERATION);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION);
		BiomeDefaultFeatures.addDefaultOres(GENERATION);
		BiomeDefaultFeatures.addDefaultSoftDisks(GENERATION);
		BiomeDefaultFeatures.addDefaultFlowers(GENERATION);
		BiomeDefaultFeatures.addForestGrass(GENERATION);
		BiomeDefaultFeatures.addDefaultMushrooms(GENERATION);
		BiomeDefaultFeatures.addDefaultExtraVegetation(GENERATION);
		BiomeDefaultFeatures.addDefaultSprings(GENERATION);
		BiomeDefaultFeatures.addSurfaceFreezing(GENERATION);
	}
	
	public static Biome create(float depth, float scale, boolean mushroomType)
	{
		mushroom = mushroomType;
		return ModBiomeMaker.create(Precipitation.SNOW, BiomeCategory.FOREST, depth, scale, -0.5F, 0.8F, 4159204, 329011, 12638463, calculateSkyColor(0.7F), MOB_SPAWNS.build(), GENERATION.build());
	}
}
