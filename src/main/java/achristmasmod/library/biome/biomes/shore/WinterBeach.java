package achristmasmod.library.biome.biomes.shore;

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

public class WinterBeach extends SimpleBiome
{
	public static final MobSpawnSettings.Builder MOB_SPAWNS = new MobSpawnSettings.Builder();
	public static final BiomeGenerationSettings.Builder GENERATION = new BiomeGenerationSettings.Builder();
	
	private static boolean stone;
	private static boolean snowy;
	
	static
	{
		addSpawns();
		addGeneration();
	}
	
	static void addSpawns() 
	{
		if(!stone && !snowy)
		{
			MOB_SPAWNS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.TURTLE, 5, 2, 5));
		}
		BiomeDefaultFeatures.commonSpawns(MOB_SPAWNS);
	}
	
	static void addGeneration() 
	{
		GENERATION.surfaceBuilder(stone ? SurfaceBuilders.STONE : SurfaceBuilders.DESERT);
		
		if(stone) 
		{
			BiomeDefaultFeatures.addDefaultOverworldLandStructures(GENERATION);
		} 
		else 
		{
			GENERATION.addStructureStart(StructureFeatures.MINESHAFT);
			GENERATION.addStructureStart(StructureFeatures.BURIED_TREASURE);
			GENERATION.addStructureStart(StructureFeatures.SHIPWRECH_BEACHED);
		}
		
		GENERATION.addStructureStart(stone ? StructureFeatures.RUINED_PORTAL_MOUNTAIN : StructureFeatures.RUINED_PORTAL_STANDARD);
		BiomeDefaultFeatures.addDefaultCarvers(GENERATION);
		BiomeDefaultFeatures.addDefaultLakes(GENERATION);
		BiomeDefaultFeatures.addDefaultCrystalFormations(GENERATION);
		BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION);
		BiomeDefaultFeatures.addDefaultOres(GENERATION);
		BiomeDefaultFeatures.addDefaultSoftDisks(GENERATION);
		BiomeDefaultFeatures.addDefaultFlowers(GENERATION);
		BiomeDefaultFeatures.addDefaultGrass(GENERATION);
		BiomeDefaultFeatures.addDefaultMushrooms(GENERATION);
		BiomeDefaultFeatures.addDefaultExtraVegetation(GENERATION);
		BiomeDefaultFeatures.addDefaultSprings(GENERATION);
		BiomeDefaultFeatures.addSurfaceFreezing(GENERATION);
	}
	
	public static Biome create(float depth, float scale, boolean isStone, boolean isSnowy)
	{		
		stone = isStone;
		snowy = isSnowy;
		return ModBiomeMaker.create(Precipitation.SNOW, isStone ? BiomeCategory.NONE : BiomeCategory.BEACH, depth, scale, -0.5F, 0.4F, 4159204, 329011, 12638463, calculateSkyColor(0.4F), MOB_SPAWNS.build(), GENERATION.build());
	}
}
