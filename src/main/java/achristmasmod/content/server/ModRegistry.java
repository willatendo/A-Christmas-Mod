package achristmasmod.content.server;

import achristmasmod.library.item.StoryBookItem;
import tyrannotitanlib.library.tyrannoregister.TyrannoRegister;

public class ModRegistry 
{
	public static void register()
	{
		for(StoryBookItem.Items items : StoryBookItem.Items.values())
		{
			TyrannoRegister.registerItem(items.toString().toLowerCase(), new StoryBookItem(items.toString().toLowerCase(), items));
		}
	}
}
