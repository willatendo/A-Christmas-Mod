package achristmasmod.library.biome.biomes.forest;

import achristmasmod.library.biome.biomes.SimpleBiome;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class WinterJungle extends SimpleBiome 
{
	private static Biome baseJungleBiome(float depth, float scale, float downfall, boolean edge, boolean bamboo, boolean bambooForest, MobSpawnSettings.Builder spawnSettings) 
	{
		BiomeGenerationSettings.Builder GENERATION = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilders.GRASS);
		if(!edge && !bambooForest) 
		{
			GENERATION.addStructureStart(StructureFeatures.JUNGLE_TEMPLE);
		}

		BiomeDefaultFeatures.addDefaultOverworldLandStructures(GENERATION);
		GENERATION.addStructureStart(StructureFeatures.RUINED_PORTAL_JUNGLE);
		BiomeDefaultFeatures.addDefaultCarvers(GENERATION);
		BiomeDefaultFeatures.addDefaultLakes(GENERATION);
		BiomeDefaultFeatures.addDefaultCrystalFormations(GENERATION);
		BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION);
		BiomeDefaultFeatures.addDefaultOres(GENERATION);
		BiomeDefaultFeatures.addDefaultSoftDisks(GENERATION);
		if(bamboo) 
		{
			BiomeDefaultFeatures.addBambooVegetation(GENERATION);
		} 
		else 
		{
			if(!edge && !bambooForest) 
			{
				BiomeDefaultFeatures.addLightBambooVegetation(GENERATION);
			}

			if(edge) 
			{
				BiomeDefaultFeatures.addJungleEdgeTrees(GENERATION);
			} 
			else 
			{
				BiomeDefaultFeatures.addJungleTrees(GENERATION);
			}
		}

		BiomeDefaultFeatures.addWarmFlowers(GENERATION);
		BiomeDefaultFeatures.addJungleGrass(GENERATION);
		BiomeDefaultFeatures.addDefaultMushrooms(GENERATION);
		BiomeDefaultFeatures.addDefaultExtraVegetation(GENERATION);
		BiomeDefaultFeatures.addDefaultSprings(GENERATION);
		BiomeDefaultFeatures.addJungleExtraVegetation(GENERATION);
		BiomeDefaultFeatures.addSurfaceFreezing(GENERATION);
		return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.JUNGLE).depth(depth).scale(scale).temperature(-0.5F).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.95F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(GENERATION.build()).build();
	}

	private static Biome jungleBiome(float depth, float scale, int parrotWeight, int parrotMaxGroup, int ocelotMaxGroup) 
	{
		MobSpawnSettings.Builder MOB_SPAWNS = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.baseJungleSpawns(MOB_SPAWNS);
		MOB_SPAWNS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, parrotWeight, 1, parrotMaxGroup)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, ocelotMaxGroup)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PANDA, 1, 1, 2));
		MOB_SPAWNS.setPlayerCanSpawn();
		return baseJungleBiome(depth, scale, 0.9F, false, false, false, MOB_SPAWNS);
	}
	
	private static Biome bambooJungleBiome(float depth, float scale, int parrotWeight, int parrotMaxGroup) 
	{
		MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.baseJungleSpawns(mobspawnsettings$builder);
		mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, parrotWeight, 1, parrotMaxGroup)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PANDA, 80, 1, 2)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 1));
		return baseJungleBiome(depth, scale, 0.9F, true, false, false, mobspawnsettings$builder);
	}
	
	public static Biome createJungle() 
	{
		return jungleBiome(0.1F, 0.2F, 40, 2, 3);
	}
	
	public static Biome createJungleHills() 
	{
		return jungleBiome(0.45F, 0.3F, 10, 1, 1);
	}
	
	public static Biome createJungleEdge() 
	{
		MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.baseJungleSpawns(mobspawnsettings$builder);
		return baseJungleBiome(0.1F, 0.2F, 0.8F, false, true, false, mobspawnsettings$builder);
	}
	
	public static Biome createModifiedJungle() 
	{
		MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.baseJungleSpawns(mobspawnsettings$builder);
		mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 10, 1, 1)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 1));
		return baseJungleBiome(0.2F, 0.4F, 0.9F, false, false, true, mobspawnsettings$builder);
	}
	
	public static Biome createModifiedJungleEdge() 
	{
		MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.baseJungleSpawns(mobspawnsettings$builder);
		return baseJungleBiome(0.2F, 0.4F, 0.8F, false, true, true, mobspawnsettings$builder);
	}
	
	public static Biome createBambooJungle() 
	{
		return bambooJungleBiome(0.1F, 0.2F, 40, 2);
	}
	
	public static Biome createBambooJungleHills() 
	{
		return bambooJungleBiome(0.45F, 0.3F, 10, 1);
	}
}
