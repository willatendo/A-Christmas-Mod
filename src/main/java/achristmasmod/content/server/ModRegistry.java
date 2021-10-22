package achristmasmod.content.server;

import achristmasmod.library.block.ChimneyBlock;
import achristmasmod.library.block.MiscBlocks;
import achristmasmod.library.block.StockingBlock;
import achristmasmod.library.block.entity.BlockEntities;
import achristmasmod.library.item.StoryBookItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import tyrannotitanlib.library.tyrannoregister.TyrannoRegister;

public class ModRegistry 
{
	public static void register()
	{
		for(StoryBookItem.Items items : StoryBookItem.Items.values())
		{
			TyrannoRegister.registerItem(items.toString().toLowerCase(), new StoryBookItem(items.toString().toLowerCase(), items));
		}
		
		for(BlockEntities blockEntities : BlockEntities.values())
		{
			TyrannoRegister.registerBlockEntity(blockEntities.toString().toLowerCase(), blockEntities.getBlockEntity());
		}
		
		for(StockingBlock.StockingBlocks blocks : StockingBlock.StockingBlocks.values())
		{
			TyrannoRegister.registerBlock(blocks.toString().toLowerCase(), blocks.getBlock());
			TyrannoRegister.registerItem(blocks.toString().toLowerCase(), new BlockItem(blocks.getBlock(), new Properties().tab(ItemGroup.TAB_MISC)));
		}
		
		for(ChimneyBlock.ChimneyBlocks blocks : ChimneyBlock.ChimneyBlocks.values())
		{
			TyrannoRegister.registerBlock(blocks.toString().toLowerCase(), blocks.getBlock());
			TyrannoRegister.registerItem(blocks.toString().toLowerCase(), new BlockItem(blocks.getBlock(), new Properties().tab(ItemGroup.TAB_MISC)));
		}
		
		for(MiscBlocks blocks : MiscBlocks.values())
		{
			TyrannoRegister.registerBlock(blocks.toString().toLowerCase(), blocks.getBlock());
			TyrannoRegister.registerItem(blocks.toString().toLowerCase(), new BlockItem(blocks.getBlock(), new Properties().tab(ItemGroup.TAB_MISC)));
		}
	}
}
