package achristmasmod.content.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class ModUtils 
{
	public static final Logger LOGGER = LogManager.getLogger(ModUtils.ID);
	
	public static final String ID = "achristmasmod";
	
	public static ResourceLocation rL(String location)
	{
		return new ResourceLocation(ID, location);
	}
	
	public static TranslationTextComponent tTC(String type, String key)
	{
		return new TranslationTextComponent(type + "." + ID + "." + key);
	}
	
	public static TranslationTextComponent cTC(String type, String key, TextFormatting colour)
	{
		TranslationTextComponent text = tTC(type, key);
		text.withStyle(colour);
		return text;
	}
	
	public static TranslationTextComponent gTC(String type, String key)
	{
		TranslationTextComponent text = tTC(type, key);
		text.withStyle(TextFormatting.GRAY);
		return text;
	}
}