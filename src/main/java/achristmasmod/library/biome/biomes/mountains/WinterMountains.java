package achristmasmod.library.biome.biomes.mountains;

import achristmasmod.library.biome.ModBiomeMaker;
import achristmasmod.library.biome.biomes.SimpleBiome;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class WinterMountains extends SimpleBiome
{
	public static final MobSpawnSettings.Builder MOB_SPAWNS = new MobSpawnSettings.Builder();
	public static final BiomeGenerationSettings.Builder GENERATION = new BiomeGenerationSettings.Builder();
	
	private static boolean edge;
	private static boolean gravel;
	
	static
	{
		addSpawns();
		addGeneration();
	}
	
	static void addSpawns() 
	{
		BiomeDefaultFeatures.farmAnimals(MOB_SPAWNS);
		MOB_SPAWNS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.LLAMA, 5, 4, 6));
		MOB_SPAWNS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 10, 4, 6));
		BiomeDefaultFeatures.commonSpawns(MOB_SPAWNS);
		
	}
	
	static void addGeneration() 
	{
		if(gravel)
		{
			GENERATION.surfaceBuilder(SurfaceBuilders.GRAVELLY_MOUNTAIN);
		}
		else if(edge)
		{
			GENERATION.surfaceBuilder(SurfaceBuilders.GRASS);
		}
		else
		{
			GENERATION.surfaceBuilder(SurfaceBuilders.MOUNTAIN);
		}
		BiomeDefaultFeatures.addDefaultOverworldLandStructures(GENERATION);
		GENERATION.addStructureStart(StructureFeatures.RUINED_PORTAL_MOUNTAIN);
		BiomeDefaultFeatures.addDefaultCarvers(GENERATION);
		BiomeDefaultFeatures.addDefaultLakes(GENERATION);
		BiomeDefaultFeatures.addDefaultCrystalFormations(GENERATION);
		BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION);
		BiomeDefaultFeatures.addDefaultOres(GENERATION);
		BiomeDefaultFeatures.addDefaultSoftDisks(GENERATION);
		if(edge) 
		{
			BiomeDefaultFeatures.addMountainEdgeTrees(GENERATION);
		} 
		else 
		{
			BiomeDefaultFeatures.addMountainTrees(GENERATION);
		}
		
		BiomeDefaultFeatures.addDefaultFlowers(GENERATION);
		BiomeDefaultFeatures.addDefaultGrass(GENERATION);
		BiomeDefaultFeatures.addDefaultMushrooms(GENERATION);
		BiomeDefaultFeatures.addDefaultExtraVegetation(GENERATION);
		BiomeDefaultFeatures.addDefaultSprings(GENERATION);
		BiomeDefaultFeatures.addExtraEmeralds(GENERATION);
		BiomeDefaultFeatures.addInfestedStone(GENERATION);
		BiomeDefaultFeatures.addSurfaceFreezing(GENERATION);
	}
	
	public static Biome create(float depth, float scale, boolean isEdge, boolean isGravel)
	{		
		edge = isEdge;
		gravel = isGravel;
		return ModBiomeMaker.create(Precipitation.SNOW, BiomeCategory.EXTREME_HILLS, depth, scale, -0.5F, 0.3F, 4159204, 329011, 12638463, calculateSkyColor(0.2F), MOB_SPAWNS.build(), GENERATION.build());
	}
}
