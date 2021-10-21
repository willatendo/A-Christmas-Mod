package achristmasmod.library.item;

import java.util.List;

import achristmasmod.content.client.book.StoryBooks;
import achristmasmod.content.server.ModUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class StoryBookItem extends Item
{
	private final String name;
	private final Items item;
	
	public StoryBookItem(String name, Items item) 
	{
		super(new Properties().tab(ItemGroup.TAB_MISC).stacksTo(1).rarity(Rarity.RARE));
		this.name = name;
		this.item = item;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> text, ITooltipFlag flag) 
	{
		text.add(ModUtils.gTC("story_book", this.name));
	}
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) 
	{
		ItemStack stack = entity.getItemInHand(hand);
		if(world.isClientSide)
		{
			StoryBooks.getBook(this.item).openGui(hand, stack);;
		}
		return ActionResult.success(stack);
	}
	
	public enum Items
	{
		THE_NIGHT_OF_THE_YULE_CAT;
	}
}
