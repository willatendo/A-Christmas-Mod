package achristmasmod.library.biome.biomes.forest;

import achristmasmod.library.biome.ModBiomeMaker;
import achristmasmod.library.biome.biomes.SimpleBiome;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.levelgen.GenerationStep;

public class WinterGiantTreeTaiga extends SimpleBiome
{
	public static final MobSpawnSettings.Builder MOB_SPAWNS = defaultOverworldSpawns();
	public static final BiomeGenerationSettings.Builder GENERATION = new BiomeGenerationSettings.Builder();
	
	private static boolean spruce;
	
	static
	{
		addSpawns();
		addGeneration();
	}
	
	static void addSpawns() 
	{
		BiomeDefaultFeatures.farmAnimals(MOB_SPAWNS);
		MOB_SPAWNS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
		MOB_SPAWNS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
		MOB_SPAWNS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
		if(spruce) 
		{
			BiomeDefaultFeatures.commonSpawns(MOB_SPAWNS);
		} 
		else 
		{
			BiomeDefaultFeatures.caveSpawns(MOB_SPAWNS);
			BiomeDefaultFeatures.monsters(MOB_SPAWNS, 100, 25, 100);
		}
	}
	
	static void addGeneration() 
	{
		BiomeDefaultFeatures.addDefaultOverworldLandStructures(GENERATION);
		GENERATION.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		BiomeDefaultFeatures.addDefaultCarvers(GENERATION);
		BiomeDefaultFeatures.addDefaultLakes(GENERATION);
		BiomeDefaultFeatures.addDefaultCrystalFormations(GENERATION);
		BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION);
		BiomeDefaultFeatures.addMossyStoneBlock(GENERATION);
		BiomeDefaultFeatures.addFerns(GENERATION);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION);
		BiomeDefaultFeatures.addDefaultOres(GENERATION);
		BiomeDefaultFeatures.addDefaultSoftDisks(GENERATION);
		GENERATION.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, spruce ? Features.TREES_GIANT_SPRUCE : Features.TREES_GIANT);
		BiomeDefaultFeatures.addDefaultFlowers(GENERATION);
		BiomeDefaultFeatures.addGiantTaigaVegetation(GENERATION);
		BiomeDefaultFeatures.addDefaultMushrooms(GENERATION);
		BiomeDefaultFeatures.addDefaultExtraVegetation(GENERATION);
		BiomeDefaultFeatures.addDefaultSprings(GENERATION);
		BiomeDefaultFeatures.addSparseBerryBushes(GENERATION);
		BiomeDefaultFeatures.addSurfaceFreezing(GENERATION);
	}
	
	public static Biome create(float depth, float scale, boolean spruceTrees)
	{
		spruce = spruceTrees;
		return ModBiomeMaker.create(Precipitation.SNOW, BiomeCategory.FOREST, depth, scale, -0.5F, 0.8F, 4159204, 329011, 12638463, spruceTrees ? calculateSkyColor(0.25F) : calculateSkyColor(0.3F), MOB_SPAWNS.build(), GENERATION.build());
	}
}
