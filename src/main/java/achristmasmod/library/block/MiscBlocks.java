package achristmasmod.library.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public enum MiscBlocks implements IBlockRegister
{
	SPIKE_BARS(new SpikeBarsBlock(AbstractBlock.Properties.of(Material.METAL, MaterialColor.NONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion())),
	GINGERBREAD_HOUSE(new GingerbreadHouseBlock(AbstractBlock.Properties.of(Material.CAKE).strength(3.0F, 0.0F).sound(SoundType.WOOL).noOcclusion())),
	KINARA(new KinaraBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD).noOcclusion())),
	;
	
	private final Block block;
	
	private MiscBlocks(Block block) 
	{
		this.block = block;
	}
	
	@Override
	public Block getBlock()
	{
		return this.block;
	}
}
