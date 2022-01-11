package achristmasmod.content.server;

import achristmasmod.library.block.ChimneyBlock;
import achristmasmod.library.block.MiscBlocks;
import achristmasmod.library.block.PresentBlock;
import achristmasmod.library.block.StockingBlock;
import achristmasmod.library.item.FoodItems;
import achristmasmod.library.item.StoryBookItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item.Properties;
import tyrannotitanlib.library.tyrannoregister.TyrannoRegister;

public class ModRegistry 
{
	public static void register()
	{
		for(StoryBookItem.Items items : StoryBookItem.Items.values())
		{
			TyrannoRegister.registerItem(items.toString().toLowerCase(), new StoryBookItem(items.toString().toLowerCase(), items));
		}
		
		for(FoodItems items : FoodItems.values())
		{
			TyrannoRegister.registerItem(items.toString().toLowerCase(), items.getItem());
		}
		
		for(StockingBlock.StockingBlocks blocks : StockingBlock.StockingBlocks.values())
		{
			TyrannoRegister.registerBlock(blocks.toString().toLowerCase(), blocks.getBlock());
			TyrannoRegister.registerItem(blocks.toString().toLowerCase(), new BlockItem(blocks.getBlock(), new Properties().tab(ModUtils.CHRISTMAS)));
		}
		
		for(ChimneyBlock.ChimneyBlocks blocks : ChimneyBlock.ChimneyBlocks.values())
		{
			TyrannoRegister.registerBlock(blocks.toString().toLowerCase(), blocks.getBlock());
			TyrannoRegister.registerItem(blocks.toString().toLowerCase(), new BlockItem(blocks.getBlock(), new Properties().tab(ModUtils.CHRISTMAS)));
		}
		
		for(MiscBlocks blocks : MiscBlocks.values())
		{
			TyrannoRegister.registerBlock(blocks.toString().toLowerCase(), blocks.getBlock());
			ItemGroup group;
			if(blocks == MiscBlocks.KINARA)
			{
				group = ModUtils.KWANZAA;
			}
			else
			{
				group = ModUtils.CHRISTMAS;
			}
			TyrannoRegister.registerItem(blocks.toString().toLowerCase(), new BlockItem(blocks.getBlock(), new Properties().tab(group)));
		}
		
		for(DyeColor colours : DyeColor.values())
		{
			Block block = new PresentBlock(AbstractBlock.Properties.of(Material.CLOTH_DECORATION).instabreak().noOcclusion().sound(SoundType.WOOL));
			TyrannoRegister.registerBlock(colours.toString().toLowerCase() + "_present", block);
			TyrannoRegister.registerItem(colours.toString().toLowerCase() + "_present", new BlockItem(block, new Properties().tab(ModUtils.CHRISTMAS).stacksTo(1)));
		}
	}
}
