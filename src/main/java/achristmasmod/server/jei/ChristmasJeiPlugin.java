package achristmasmod.server.jei;

import achristmasmod.server.blocks.ChristmasBlocks;
import achristmasmod.server.jei.category.GiftCategory;
import achristmasmod.server.jei.recipe.ChristmasRecipeManager;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;

@JeiPlugin
public class ChristmasJeiPlugin implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return ChristmasJeiConstants.CHRISTMAS_PLUGIN;
	}

	@Override
	public void registerRecipes(IRecipeRegistration recipeRegistration) {
		IJeiHelpers jeiHelpers = recipeRegistration.getJeiHelpers();
		IIngredientManager ingredientManager = recipeRegistration.getIngredientManager();

		recipeRegistration.addRecipes(ChristmasJeiConstants.GIFT, ChristmasRecipeManager.getChiselableRecipes(ingredientManager, jeiHelpers));
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration recipeCategoryRegistration) {
		IGuiHelper helper = recipeCategoryRegistration.getJeiHelpers().getGuiHelper();

		recipeCategoryRegistration.addRecipeCategories(new GiftCategory(helper));
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration recipeCatalystRegistration) {
		for (DyeColor dyeColour : DyeColor.values()) {
			recipeCatalystRegistration.addRecipeCatalyst(ChristmasBlocks.PRESENT_BLOCKS.get(dyeColour).asStack(), ChristmasJeiConstants.GIFT);
		}
	}
}
