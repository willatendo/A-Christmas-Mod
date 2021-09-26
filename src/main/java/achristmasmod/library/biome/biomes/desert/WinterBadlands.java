package achristmasmod.library.biome.biomes.desert;

import achristmasmod.library.biome.biomes.SimpleBiome;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class WinterBadlands extends SimpleBiome
{
	private static Biome baseBadlandsBiome(ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> surfacebuilder, float depth, float scale, boolean plateau, boolean forested) 
	{
		MobSpawnSettings.Builder mob_spawns = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mob_spawns);
		BiomeGenerationSettings.Builder generation = (new BiomeGenerationSettings.Builder()).surfaceBuilder(surfacebuilder);
		BiomeDefaultFeatures.addDefaultOverworldLandMesaStructures(generation);
		generation.addStructureStart(plateau ? StructureFeatures.RUINED_PORTAL_MOUNTAIN : StructureFeatures.RUINED_PORTAL_STANDARD);
		BiomeDefaultFeatures.addDefaultCarvers(generation);
		BiomeDefaultFeatures.addDefaultLakes(generation);
		BiomeDefaultFeatures.addDefaultCrystalFormations(generation);
		BiomeDefaultFeatures.addDefaultMonsterRoom(generation);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(generation);
		BiomeDefaultFeatures.addDefaultOres(generation);
		BiomeDefaultFeatures.addExtraGold(generation);
		BiomeDefaultFeatures.addDefaultSoftDisks(generation);
		if(forested) 
		{
			BiomeDefaultFeatures.addBadlandsTrees(generation);
		}
		
		BiomeDefaultFeatures.addBadlandGrass(generation);
		BiomeDefaultFeatures.addDefaultMushrooms(generation);
		BiomeDefaultFeatures.addBadlandExtraVegetation(generation);
		BiomeDefaultFeatures.addDefaultSprings(generation);
		BiomeDefaultFeatures.addSurfaceFreezing(generation);
		return (new Biome.BiomeBuilder()).precipitation(Precipitation.SNOW).biomeCategory(BiomeCategory.MESA).depth(depth).scale(scale).temperature(-0.5F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(2.0F)).foliageColorOverride(10387789).grassColorOverride(9470285).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mob_spawns.build()).generationSettings(generation.build()).build();
	}
	
	public static Biome badlandsBiome(float depth, float scale, boolean plateau) 
	{
		return baseBadlandsBiome(SurfaceBuilders.BADLANDS, depth, scale, plateau, false);
	}
	
	public static Biome woodedBadlandsPlateauBiome(float depth, float scale) 
	{
		return baseBadlandsBiome(SurfaceBuilders.WOODED_BADLANDS, depth, scale, true, true);
	}
	
	public static Biome erodedBadlandsBiome() 
	{
		return baseBadlandsBiome(SurfaceBuilders.ERODED_BADLANDS, 0.1F, 0.2F, true, false);
	}
}
