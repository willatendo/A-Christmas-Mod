package achristmasmod.content.client.book;

import achristmasmod.content.server.ModUtils;
import achristmasmod.library.item.StoryBookItem;
import net.minecraft.util.ResourceLocation;
import tyrannotitanlib.library.tyrannobook.client.FileRepository;
import tyrannotitanlib.library.tyrannobook.client.PaddingBookTransformer;
import tyrannotitanlib.library.tyrannobook.client.TyrannobookLoader;
import tyrannotitanlib.library.tyrannobook.client.TyrannobookTransformer;
import tyrannotitanlib.library.tyrannobook.client.data.TyrannobookData;

public class StoryBooks extends TyrannobookData
{
	private static final ResourceLocation THE_NIGHT_OF_THE_YULE_CAT_ID = ModUtils.rL("the_night_of_the_yule_cat");
	public static final TyrannobookData THE_NIGHT_OF_THE_YULE_CAT = TyrannobookLoader.registerBook(THE_NIGHT_OF_THE_YULE_CAT_ID.toString(), false, false);
	
	public static void initBooks() 
	{
		addStandardData(THE_NIGHT_OF_THE_YULE_CAT, THE_NIGHT_OF_THE_YULE_CAT_ID);
	}
	
	private static void addStandardData(TyrannobookData book, ResourceLocation id) 
	{
		book.addRepository(new FileRepository(id.getNamespace() + ":tyrannobook/" + id.getPath()));
		book.addTransformer(TyrannobookTransformer.indexTranformer());
		book.addTransformer(PaddingBookTransformer.INSTANCE);
	}
	
	public static TyrannobookData getBook(StoryBookItem.Items book) 
	{
		switch(book) 
		{
			default:
			case THE_NIGHT_OF_THE_YULE_CAT:
				return THE_NIGHT_OF_THE_YULE_CAT;
		}
	}
}
