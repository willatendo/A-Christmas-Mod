package achristmasmod.library.biome;

import achristmasmod.library.biome.biomes.SimpleBiome;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class ModBiomeMaker 
{
	public static Biome create(Precipitation rainType, BiomeCategory category, float depth, float scale, float temperature, float downfall, int waterColour, int waterFogColour, int fogColour, int skyColour, int grassColour, int foliageColour, MobSpawnSettings mobSpawns, BiomeGenerationSettings generation)
	{
		return (new Biome.BiomeBuilder()).precipitation(rainType).biomeCategory(category).depth(depth).scale(scale).temperature(temperature).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder().waterColor(waterColour).waterFogColor(waterFogColour).fogColor(fogColour).skyColor(skyColour).grassColorOverride(grassColour).foliageColorOverride(foliageColour).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)).build()).mobSpawnSettings(mobSpawns).generationSettings(generation).build();
	}
	
	public static Biome create(Precipitation rainType, BiomeCategory category, float depth, float scale, float temperature, float downfall, int waterColour, int waterFogColour, int fogColour, int skyColour, MobSpawnSettings mobSpawns, BiomeGenerationSettings generation)
	{
		return (new Biome.BiomeBuilder()).precipitation(rainType).biomeCategory(category).depth(depth).scale(scale).temperature(temperature).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder().waterColor(waterColour).waterFogColor(waterFogColour).fogColor(fogColour).skyColor(skyColour).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)).build()).mobSpawnSettings(mobSpawns).generationSettings(generation).build();
	}
	
	public static Biome create(Precipitation rainType, BiomeCategory category, float depth, float scale, float temperature, float downfall, int waterColour, int waterFogColour, int fogColour, MobSpawnSettings mobSpawns, BiomeGenerationSettings generation)
	{
		return (new Biome.BiomeBuilder()).precipitation(rainType).biomeCategory(category).depth(depth).scale(scale).temperature(temperature).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder().waterColor(waterColour).waterFogColor(waterFogColour).fogColor(fogColour).skyColor(SimpleBiome.calculateSkyColor(temperature)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)).build()).mobSpawnSettings(mobSpawns).generationSettings(generation).build();
	}
	
	public static Biome create(Precipitation rainType, BiomeCategory category, float depth, float scale, float temperature, float downfall, int waterColour, int waterFogColour, int fogColour, int skyColour, int grassColour, int foliageColour, float particleAmount, SimpleParticleType particle, MobSpawnSettings mobSpawns, BiomeGenerationSettings generation)
	{
		return (new Biome.BiomeBuilder()).precipitation(rainType).biomeCategory(category).depth(depth).scale(scale).temperature(temperature).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder().waterColor(waterColour).waterFogColor(waterFogColour).fogColor(fogColour).skyColor(skyColour).grassColorOverride(grassColour).foliageColorOverride(foliageColour).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)).ambientParticle(new AmbientParticleSettings(particle, particleAmount)).build()).mobSpawnSettings(mobSpawns).generationSettings(generation).build();
	}
}
