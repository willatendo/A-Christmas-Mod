package achristmasmod.server.jei;

import achristmasmod.server.jei.recipe.GiftRecipe;
import achristmasmod.server.util.ModUtils;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.resources.ResourceLocation;

public class ChristmasJeiConstants {
	public static final ResourceLocation CHRISTMAS_PLUGIN = ModUtils.resource("christmas_plugin");

	public static final RecipeType GIFT = RecipeType.create(ModUtils.ID, "gift", GiftRecipe.class);
}
