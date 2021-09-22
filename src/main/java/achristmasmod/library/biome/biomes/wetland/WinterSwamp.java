package achristmasmod.library.biome.biomes.wetland;

import achristmasmod.library.biome.ModBiomeMaker;
import achristmasmod.library.biome.biomes.SimpleBiome;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.levelgen.GenerationStep;

public class WinterSwamp extends SimpleBiome
{
	public static final MobSpawnSettings.Builder MOB_SPAWNS = new MobSpawnSettings.Builder();
	public static final BiomeGenerationSettings.Builder GENERATION = new BiomeGenerationSettings.Builder();
	
	private static boolean hills;
	
	static
	{
		addSpawns();
		addGeneration();
	}
	
	static void addSpawns() 
	{
		BiomeDefaultFeatures.farmAnimals(MOB_SPAWNS);
		BiomeDefaultFeatures.commonSpawns(MOB_SPAWNS);
		MOB_SPAWNS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));
	}
	
	static void addGeneration() 
	{
		GENERATION.surfaceBuilder(SurfaceBuilders.SWAMP);
		if(!hills) 
		{
			GENERATION.addStructureStart(StructureFeatures.SWAMP_HUT);
		}
		
		GENERATION.addStructureStart(StructureFeatures.MINESHAFT);
		GENERATION.addStructureStart(StructureFeatures.RUINED_PORTAL_SWAMP);
		BiomeDefaultFeatures.addDefaultCarvers(GENERATION);
		if(!hills) 
		{
			BiomeDefaultFeatures.addFossilDecoration(GENERATION);
		}
		
		BiomeDefaultFeatures.addDefaultLakes(GENERATION);
		BiomeDefaultFeatures.addDefaultCrystalFormations(GENERATION);
		BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION);
		BiomeDefaultFeatures.addDefaultOres(GENERATION);
		BiomeDefaultFeatures.addSwampClayDisk(GENERATION);
		BiomeDefaultFeatures.addSwampVegetation(GENERATION);
		BiomeDefaultFeatures.addDefaultMushrooms(GENERATION);
		BiomeDefaultFeatures.addSwampExtraVegetation(GENERATION);
		BiomeDefaultFeatures.addDefaultSprings(GENERATION);
		if(hills) 
		{
			BiomeDefaultFeatures.addFossilDecoration(GENERATION);
		} 
		else 
		{
			GENERATION.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_SWAMP);
		}
		
		BiomeDefaultFeatures.addSurfaceFreezing(GENERATION);
	}
	
	public static Biome create(float depth, float scale, boolean isHills)
	{		
		hills = isHills;
		return ModBiomeMaker.create(Precipitation.SNOW, BiomeCategory.SWAMP, depth, scale, -0.5F, 0.9F, 4159204, 329011, 12638463, calculateSkyColor(0.2F), MOB_SPAWNS.build(), GENERATION.build());
	}
}
