package achristmasmod.server.jei.category;

import achristmasmod.server.blocks.ChristmasBlocks;
import achristmasmod.server.jei.ChristmasJeiConstants;
import achristmasmod.server.jei.recipe.GiftRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.crafting.Ingredient;

public class GiftCategory implements IRecipeCategory<GiftRecipe> {
	private final IDrawable background;
	private final IDrawable icon;

	public GiftCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createBlankDrawable(80, 40);
		this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, ChristmasBlocks.PRESENT_BLOCKS.get(DyeColor.WHITE).asStack());
	}

	@Override
	public RecipeType<GiftRecipe> getRecipeType() {
		return ChristmasJeiConstants.GIFT;
	}

	@Override
	public Component getTitle() {
		return Component.translatable("jei.achristmasmod.gifts");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, GiftRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.OUTPUT, 30, 10).addIngredients(Ingredient.of(recipe.output().asItem()));
	}
}
