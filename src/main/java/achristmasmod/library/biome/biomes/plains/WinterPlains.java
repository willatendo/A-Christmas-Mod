package achristmasmod.library.biome.biomes.plains;

import achristmasmod.library.biome.ModBiomeMaker;
import achristmasmod.library.biome.biomes.SimpleBiome;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.levelgen.GenerationStep;

public class WinterPlains extends SimpleBiome
{
	public static final MobSpawnSettings.Builder MOB_SPAWNS = new MobSpawnSettings.Builder();
	public static final BiomeGenerationSettings.Builder GENERATION = new BiomeGenerationSettings.Builder();
	
	private static boolean sunflowers;
	
	static
	{
		addSpawns();
		addGeneration();
	}
	
	static void addSpawns() 
	{
		BiomeDefaultFeatures.plainsSpawns(MOB_SPAWNS);
		if(!sunflowers)
		{
			MOB_SPAWNS.setPlayerCanSpawn();
		}
	}
	
	static void addGeneration() 
	{
		GENERATION.surfaceBuilder(SurfaceBuilders.GRASS);
		if(!sunflowers) 
		{
			GENERATION.addStructureStart(StructureFeatures.VILLAGE_PLAINS).addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
		}
		
		BiomeDefaultFeatures.addDefaultOverworldLandStructures(GENERATION);
		GENERATION.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		BiomeDefaultFeatures.addDefaultCarvers(GENERATION);
		BiomeDefaultFeatures.addDefaultLakes(GENERATION);
		BiomeDefaultFeatures.addDefaultCrystalFormations(GENERATION);
		BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION);
		BiomeDefaultFeatures.addPlainGrass(GENERATION);
		if(sunflowers) 
		{
			GENERATION.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_SUNFLOWER);
		}
		
		BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION);
		BiomeDefaultFeatures.addDefaultOres(GENERATION);
		BiomeDefaultFeatures.addDefaultSoftDisks(GENERATION);
		BiomeDefaultFeatures.addPlainVegetation(GENERATION);
		if(sunflowers) 
		{
			GENERATION.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_SUGAR_CANE);
		}
		
		BiomeDefaultFeatures.addDefaultMushrooms(GENERATION);
		if(sunflowers) 
		{
			GENERATION.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_PUMPKIN);
		}
		else 
		{
			BiomeDefaultFeatures.addDefaultExtraVegetation(GENERATION);
		}
		
		BiomeDefaultFeatures.addDefaultSprings(GENERATION);
		BiomeDefaultFeatures.addSurfaceFreezing(GENERATION);
	}
	
	public static Biome create(float depth, float scale, boolean hasSunflowers)
	{		
		sunflowers = hasSunflowers;
		return ModBiomeMaker.create(Precipitation.SNOW, BiomeCategory.PLAINS, depth, scale, -0.5F, 0.4F, 4159204, 329011, 12638463, calculateSkyColor(0.2F), MOB_SPAWNS.build(), GENERATION.build());
	}
}
