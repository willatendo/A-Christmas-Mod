package achristmasmod.library.biome.biomes.forest;

import achristmasmod.library.biome.biomes.SimpleBiome;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class WinterSavanna extends SimpleBiome
{
	private static Biome baseSavannaBiome(float depth, float scale, boolean plateau, boolean shattered, MobSpawnSettings.Builder mobSpawn) 
	{
		BiomeGenerationSettings.Builder GENERATION = (new BiomeGenerationSettings.Builder()).surfaceBuilder(shattered ? SurfaceBuilders.SHATTERED_SAVANNA : SurfaceBuilders.GRASS);
		if(!plateau && !shattered) 
		{
			GENERATION.addStructureStart(StructureFeatures.VILLAGE_SAVANNA).addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
		}
		
		BiomeDefaultFeatures.addDefaultOverworldLandStructures(GENERATION);
		GENERATION.addStructureStart(plateau ? StructureFeatures.RUINED_PORTAL_MOUNTAIN : StructureFeatures.RUINED_PORTAL_STANDARD);
		BiomeDefaultFeatures.addDefaultCarvers(GENERATION);
		BiomeDefaultFeatures.addDefaultLakes(GENERATION);
		BiomeDefaultFeatures.addDefaultCrystalFormations(GENERATION);
		BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION);
		if(!shattered) 
		{
			BiomeDefaultFeatures.addSavannaGrass(GENERATION);
		}
		
		BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION);
		BiomeDefaultFeatures.addDefaultOres(GENERATION);
		BiomeDefaultFeatures.addDefaultSoftDisks(GENERATION);
		if(shattered) 
		{
			BiomeDefaultFeatures.addShatteredSavannaTrees(GENERATION);
			BiomeDefaultFeatures.addDefaultFlowers(GENERATION);
			BiomeDefaultFeatures.addShatteredSavannaGrass(GENERATION);
		} 
		else 
		{
			BiomeDefaultFeatures.addSavannaTrees(GENERATION);
			BiomeDefaultFeatures.addWarmFlowers(GENERATION);
			BiomeDefaultFeatures.addSavannaExtraGrass(GENERATION);
		}
		
		BiomeDefaultFeatures.addDefaultMushrooms(GENERATION);
		BiomeDefaultFeatures.addDefaultExtraVegetation(GENERATION);
		BiomeDefaultFeatures.addDefaultSprings(GENERATION);
		BiomeDefaultFeatures.addSurfaceFreezing(GENERATION);
		return (new Biome.BiomeBuilder()).precipitation(Precipitation.SNOW).biomeCategory(BiomeCategory.SAVANNA).depth(depth).scale(scale).temperature(-0.5F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(1.2F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobSpawn.build()).generationSettings(GENERATION.build()).build();
	}
	
	public static Biome savannaBiome(float depth, float scale, boolean plateau, boolean shattered) 
	{
		MobSpawnSettings.Builder MOB_SPAWNS = savannaMobs();
		return baseSavannaBiome(depth, scale, plateau, shattered, MOB_SPAWNS);
	}
	
	private static MobSpawnSettings.Builder savannaMobs() 
	{
		MobSpawnSettings.Builder MOB_SPAWNS = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.farmAnimals(MOB_SPAWNS);
		MOB_SPAWNS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 1, 2, 6)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 1));
		BiomeDefaultFeatures.commonSpawns(MOB_SPAWNS);
		return MOB_SPAWNS;
	}
	
	public static Biome savanaPlateauBiome() 
	{
		MobSpawnSettings.Builder MOB_SPAWNS = savannaMobs();
		MOB_SPAWNS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.LLAMA, 8, 4, 4));
		return baseSavannaBiome(1.5F, 0.025F, true, false, MOB_SPAWNS);
	}
}
