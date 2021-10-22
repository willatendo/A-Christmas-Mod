package achristmasmod.library.block.entity;

import achristmasmod.library.block.IStocking;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ForgeRegistries;

public enum BlockEntities implements IBlockEntityRegister
{
	STOCKING(new StockingBlockEntity(), collectBlocks(IStocking.class));
	
	private final TileEntity blockEntity;
	private final Block[] blocks;
	
	private BlockEntities(TileEntity blockEntity, Block... blocks) 
	{
		this.blockEntity = blockEntity;
		this.blocks = blocks;
	}

	@Override
	public TileEntityType getBlockEntity() 
	{
		return TileEntityType.Builder.of(() -> this.blockEntity, this.blocks).build(null);
	}

	public static Block[] collectBlocks(Class<?> blockClass) 
	{
		return ForgeRegistries.BLOCKS.getValues().stream().filter(blockClass::isInstance).toArray(Block[]::new);
	}
}
