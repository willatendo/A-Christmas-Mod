package achristmasmod.server.jei.recipe;

import java.util.ArrayList;
import java.util.List;

import achristmasmod.server.ChristmasTags;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class ChristmasRecipeManager {
	public static ArrayList<GiftRecipe> getChiselableRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers) {
		ArrayList<GiftRecipe> recipes = new ArrayList<>();
		List<Item> gifts = ForgeRegistries.ITEMS.tags().getTag(ChristmasTags.Items.GIFTS).stream().toList();
		for (int i = 0; i < gifts.size(); i++) {
			recipes.add(new GiftRecipe(gifts.get(i)));
		}
		return recipes;
	}
}
