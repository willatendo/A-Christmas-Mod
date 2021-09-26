package achristmasmod.content.server.init;

import achristmasmod.content.ModRegistry;
import achristmasmod.content.ModUtils;
import achristmasmod.library.biome.biomes.desert.WinterBadlands;
import achristmasmod.library.biome.biomes.desert.WinterDesert;
import achristmasmod.library.biome.biomes.forest.WinterBirchForest;
import achristmasmod.library.biome.biomes.forest.WinterDarkForest;
import achristmasmod.library.biome.biomes.forest.WinterForest;
import achristmasmod.library.biome.biomes.forest.WinterGiantTreeTaiga;
import achristmasmod.library.biome.biomes.forest.WinterJungle;
import achristmasmod.library.biome.biomes.forest.WinterSavanna;
import achristmasmod.library.biome.biomes.forest.WinterTaiga;
import achristmasmod.library.biome.biomes.magic.WinterMushroomFields;
import achristmasmod.library.biome.biomes.mountains.WinterMountains;
import achristmasmod.library.biome.biomes.plains.WinterPlains;
import achristmasmod.library.biome.biomes.river.WinterRiver;
import achristmasmod.library.biome.biomes.shore.WinterBeach;
import achristmasmod.library.biome.biomes.wetland.WinterSwamp;
import net.minecraft.world.level.biome.Biome;

public class BiomeInit 
{
	public static final Biome WINTER_PLAINS = ModRegistry.registry("winter_plains", WinterPlains.create(0.125F, 0.05F, false));
	public static final Biome WINTER_SUNFLOWER_PLAINS = ModRegistry.registry("winter_sunflower_plains", WinterPlains.create(0.125F, 0.05F, true));
	
	public static final Biome WINTER_DESERT = ModRegistry.registry("winter_desert", WinterDesert.create(0.125F, 0.05F, true, true, true));
	public static final Biome WINTER_DESERT_HILLS = ModRegistry.registry("winter_desert_hills", WinterDesert.create(0.45F, 0.3F, false, true, false));
	public static final Biome WINTER_DESERT_LAKES = ModRegistry.registry("winter_desert_lakes", WinterDesert.create(0.225F, 0.25F, false, false, false));

	public static final Biome WINTER_FOREST = ModRegistry.registry("winter_forest", WinterForest.create(0.1F, 0.2F, false));
	public static final Biome WINTER_FOREST_HILLS = ModRegistry.registry("winter_forest_hills", WinterForest.create(0.45F, 0.3F, false));
	public static final Biome WINTER_FLOWER_FOREST = ModRegistry.registry("winter_flower_forest", WinterForest.create(0.1F, 0.4F, true));
	
	public static final Biome WINTER_MOUNTAINS = ModRegistry.registry("winter_mountains", WinterMountains.create(1.0F, 0.5F, false, false));
	public static final Biome WINTER_MOUNTAINS_EDGE = ModRegistry.registry("winter_mountains_edge", WinterMountains.create(0.8F, 0.3F, true, false));
	public static final Biome WINTER_WOODED_MOUNTAINS = ModRegistry.registry("winter_wooded_mountains", WinterMountains.create(1.0F, 0.5F, true, false));
	public static final Biome WINTER_GRAVELLY_MOUNTAINS = ModRegistry.registry("winter_gravelly_mountains", WinterMountains.create(1.0F, 0.5F, false, true));
	public static final Biome WINTER_MODIFIED_GRAVELLY_MOUNTAINS = ModRegistry.registry("winter_modified_gravelly_mountains", WinterMountains.create(1.0F, 0.5F, false, true));

	public static final Biome WINTER_TAIGA = ModRegistry.registry("winter_taiga", WinterTaiga.create(0.2F, 0.2F, false, true, false));
	public static final Biome WINTER_TAIGA_HILLS = ModRegistry.registry("winter_taiga_hills", WinterTaiga.create(0.45F, 0.3F, false, false, false));
	public static final Biome SNOWY_WINTER_TAIGA = ModRegistry.registry("snowy_winter_taiga", WinterTaiga.create(0.2F, 0.2F, false, false, true));
	public static final Biome SNOWY_WINTER_TAIGA_HILLS = ModRegistry.registry("snowy_winter_taiga_hills", WinterTaiga.create(0.45F, 0.3F, false, false, false));
	public static final Biome WINTER_TAIGA_MOUNTAINS = ModRegistry.registry("winter_taiga_mounains", WinterTaiga.create(0.3F, 0.4F, true, false, false));
	public static final Biome SNOWY_WINTER_TAIGA_MOUNTAINS = ModRegistry.registry("snowy_winter_taiga_mounains", WinterTaiga.create(0.3F, 0.4F, true, false, false));
	
	public static final Biome WINTER_SWAMP = ModRegistry.registry("winter_swamp", WinterSwamp.create(-0.2F, 0.1F, false));
	public static final Biome WINTER_SWAMP_HILLS = ModRegistry.registry("winter_swamp_hills", WinterSwamp.create(-0.1F, 0.3F, true));
	
	public static final Biome WINTER_RIVER = ModRegistry.registry("winter_river", WinterRiver.create(-0.5F, 0.0F, false));
	public static final Biome FROZEN_WINTER_RIVER = ModRegistry.registry("frozen_winter_river", WinterRiver.create(-0.5F, 0.0F, true));
	
	//Ocean
	
	public static final Biome WINTER_MUSHROOM_FIELDS = ModRegistry.registry("winter_mushroom_feilds", WinterMushroomFields.create(0.2F, 0.3F));
	public static final Biome WINTER_MUSHROOM_FIELDS_SHORE = ModRegistry.registry("winter_mushroom_feilds_shore", WinterMushroomFields.create(0.0F, 0.025F));
	
	public static final Biome WINTER_BEACH = ModRegistry.registry("winter_beach", WinterBeach.create(0.0F, 0.025F, false, false));
	public static final Biome WINTER_STONE_SHORE = ModRegistry.registry("winter_stone_shore", WinterBeach.create(0.1F, 0.8F, true, false));
	public static final Biome SNOWY_WINTER_BEACH = ModRegistry.registry("snowy_winter_beach", WinterBeach.create(0.0F, 0.025F, false, true));
	
	public static final Biome WINTER_JUNGLE = ModRegistry.registry("winter_jungle", WinterJungle.createJungle());
	public static final Biome WINTER_JUNGLE_HILLS = ModRegistry.registry("winter_jungle_hills", WinterJungle.createJungleHills());
	public static final Biome MODIFIED_WINTER_JUNGLE = ModRegistry.registry("modified_winter_jungle", WinterJungle.createModifiedJungle());
	public static final Biome MODIFIED_WINTER_JUNGLE_EDGE = ModRegistry.registry("modified_winter_jungle_edge", WinterJungle.createModifiedJungleEdge());
	public static final Biome WINTER_BAMBOO_JUNGLE = ModRegistry.registry("winter_bamboo_jungle", WinterJungle.createBambooJungle());
	public static final Biome WINTER_BAMBOO_JUNGLE_HILLS = ModRegistry.registry("winter_bamboo_jungle_hills", WinterJungle.createBambooJungleHills());
	
	public static final Biome WINTER_BIRCH_FOREST = ModRegistry.registry("winter_birch_forest", WinterBirchForest.create(0.1F, 0.2F, false));
	public static final Biome WINTER_BIRCH_FOREST_HILLS = ModRegistry.registry("winter_birch_forest_hills", WinterBirchForest.create(0.45F, 0.3F, false));
	public static final Biome TALL_WINTER_BIRCH_FOREST = ModRegistry.registry("tall_winter_birch_forest", WinterBirchForest.create(0.2F, 0.4F, true));
	public static final Biome TALL_WINTER_BIRCH_FOREST_HILLS = ModRegistry.registry("tall_winter_birch_forest_hills", WinterBirchForest.create(0.55F, 0.5F, true));
	
	public static final Biome WINTER_DARK_FOREST = ModRegistry.registry("winter_dark_forest", WinterDarkForest.create(0.1F, 0.2F, false));
	public static final Biome WINTER_DARK_FOREST_HILLS = ModRegistry.registry("winter_dark_forest_hills", WinterDarkForest.create(0.2F, 0.4F, true));

	public static final Biome WINTER_GIANT_TREE_TAIGA = ModRegistry.registry("winter_giant_tree_taiga", WinterGiantTreeTaiga.create(0.2F, 0.2F, false));
	public static final Biome WINTER_GIANT_TREE_TAIGA_HILLS = ModRegistry.registry("winter_giant_tree_taiga_hills", WinterGiantTreeTaiga.create(0.45F, 0.3F, false));
	public static final Biome WINTER_GIANT_SPRUCE_TAIGA = ModRegistry.registry("winter_giant_spruce_taiga", WinterGiantTreeTaiga.create(0.2F, 0.2F, true));
	public static final Biome WINTER_GIANT_TREE_SPRUCE_HILLS = ModRegistry.registry("winter_giant_spruce_taiga_hills", WinterGiantTreeTaiga.create(0.2F, 0.2F, true));

	public static final Biome WINTER_SAVANNA = ModRegistry.registry("winter_savanna", WinterSavanna.savannaBiome(0.125F, 0.05F, false, false));
	public static final Biome WINTER_SAVANNA_PLATEAU = ModRegistry.registry("winter_savanna_plateau", WinterSavanna.savanaPlateauBiome());
	public static final Biome WINTER_SHATTERED_SAVANNA = ModRegistry.registry("winter_shattered_savanna", WinterSavanna.savannaBiome(0.3625F, 1.225F, true, true));
	public static final Biome WINTER_SHATTERED_SAVANNA_PLATEAU = ModRegistry.registry("winter_shattered_savanna_plateau", WinterSavanna.savannaBiome(1.05F, 1.2125001F, true, true));
	
	public static final Biome WINTER_BADLANDS = ModRegistry.registry("winter_badlands", WinterBadlands.badlandsBiome(0.1F, 0.2F, false));
	public static final Biome WOODED_WINTER_BADLANDS_PLATEAU = ModRegistry.registry("wooded_winter_badlands_plateau", WinterBadlands.woodedBadlandsPlateauBiome(1.5F, 0.025F));
	public static final Biome WINTER_BADLANDS_PLATEAU = ModRegistry.registry("winter_badlands_plateau", WinterBadlands.badlandsBiome(1.5F, 0.025F, true));
	public static final Biome ERRODED_WINTER_BADLANDS = ModRegistry.registry("erroded_winter_badlands", WinterBadlands.erodedBadlandsBiome());
	public static final Biome MODIFIED_WOODED_WINTER_BADLANDS_PLATEAU = ModRegistry.registry("winter_badlands", WinterBadlands.woodedBadlandsPlateauBiome(0.45F, 0.3F));
	public static final Biome MODIFIED_WINTER_BADLANDS_PLATEAU = ModRegistry.registry("wooded_winter_badlands_plateau", WinterBadlands.badlandsBiome(0.45F, 0.3F, true));
	
	public static void init() { ModUtils.LOGGER.debug("Registering Mod Biomes"); }
}
