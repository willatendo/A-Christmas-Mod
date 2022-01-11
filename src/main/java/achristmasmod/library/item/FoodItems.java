package achristmasmod.library.item;

import achristmasmod.content.server.ModUtils;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public enum FoodItems 
{
	CANDY_CANE(1, 0.05F, true, 16),
	CHOCOLATE_BAR(3, 0.2F, true, 64),
	;
	
	private final Item item;
	
	private FoodItems(int nutrition, float saturation, boolean sweet, int stacksize) 
	{
		this.item = sweet ? new Item(new Properties().tab(ModUtils.CHRISTMAS).stacksTo(stacksize).food(new Food.Builder().fast().nutrition(stacksize).saturationMod(stacksize).effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 100, 2), 1.0F).alwaysEat().build())) : new Item(new Properties().tab(ModUtils.CHRISTMAS).stacksTo(stacksize).food(new Food.Builder().nutrition(nutrition).saturationMod(saturation).build()));
	}
	
	public Item getItem()
	{
		return this.item;
	}
}
