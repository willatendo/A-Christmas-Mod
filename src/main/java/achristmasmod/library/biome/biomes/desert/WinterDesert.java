package achristmasmod.library.biome.biomes.desert;

import achristmasmod.library.biome.ModBiomeMaker;
import achristmasmod.library.biome.biomes.SimpleBiome;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;

public class WinterDesert extends SimpleBiome
{
	public static final MobSpawnSettings.Builder MOB_SPAWNS = new MobSpawnSettings.Builder();
	public static final BiomeGenerationSettings.Builder GENERATION = new BiomeGenerationSettings.Builder();
	
	private static boolean villages;
	private static boolean pyramids;
	private static boolean fossils;
	
	static
	{
		addSpawns();
		addGeneration();
	}
	
	static void addSpawns() 
	{
		BiomeDefaultFeatures.desertSpawns(MOB_SPAWNS);
	}
	
	static void addGeneration() 
	{
		GENERATION.surfaceBuilder(SurfaceBuilders.DESERT);
		if(villages) 
		{
			GENERATION.addStructureStart(StructureFeatures.VILLAGE_DESERT);
			GENERATION.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
		}
		
		if(pyramids) 
		{
			GENERATION.addStructureStart(StructureFeatures.DESERT_PYRAMID);
		}
		
		if(fossils) 
		{
			BiomeDefaultFeatures.addFossilDecoration(GENERATION);
		}
		
		BiomeDefaultFeatures.addDefaultOverworldLandStructures(GENERATION);
		GENERATION.addStructureStart(StructureFeatures.RUINED_PORTAL_DESERT);
		BiomeDefaultFeatures.addDefaultCarvers(GENERATION);
		BiomeDefaultFeatures.addDesertLakes(GENERATION);
		BiomeDefaultFeatures.addDefaultCrystalFormations(GENERATION);
		BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION);
		BiomeDefaultFeatures.addDefaultOres(GENERATION);
		BiomeDefaultFeatures.addDefaultSoftDisks(GENERATION);
		BiomeDefaultFeatures.addDefaultFlowers(GENERATION);
		BiomeDefaultFeatures.addDefaultGrass(GENERATION);
		BiomeDefaultFeatures.addDesertVegetation(GENERATION);
		BiomeDefaultFeatures.addDefaultMushrooms(GENERATION);
		BiomeDefaultFeatures.addDesertExtraVegetation(GENERATION);
		BiomeDefaultFeatures.addDefaultSprings(GENERATION);
		BiomeDefaultFeatures.addDesertExtraDecoration(GENERATION);
		BiomeDefaultFeatures.addSurfaceFreezing(GENERATION);
	}
	
	public static Biome create(float depth, float scale, boolean hasVillages, boolean hasPyramids, boolean hasFossils)
	{		
		villages = hasVillages;
		pyramids = hasPyramids;
		fossils = hasFossils;
		return ModBiomeMaker.create(Precipitation.NONE, BiomeCategory.DESERT, depth, scale, -0.5F, 0.0F, 4159204, 329011, 12638463, calculateSkyColor(2.0F), MOB_SPAWNS.build(), GENERATION.build());
	}
}
