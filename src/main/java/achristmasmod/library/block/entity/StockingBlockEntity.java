package achristmasmod.library.block.entity;

import achristmasmod.content.server.ModUtils;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;

public class StockingBlockEntity extends LockableLootTileEntity
{
	private NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
	
	public StockingBlockEntity() 
	{
		super(BlockEntities.STOCKING.getBlockEntity());
	}

	@Override
	public int getContainerSize() 
	{
		return 3;
	}

	@Override
	protected ITextComponent getDefaultName() 
	{
		return ModUtils.tTC("contianer", "stocking");
	}
	
	@Override
	public void load(BlockState state, CompoundNBT nbt) 
	{
		super.load(state, nbt);
		this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		if(!this.tryLoadLootTable(nbt)) 
		{
			ItemStackHelper.loadAllItems(nbt, this.items);
		}
	}
	
	@Override
	public CompoundNBT save(CompoundNBT nbt) 
	{
		super.save(nbt);
		if(!this.trySaveLootTable(nbt)) 
		{
			ItemStackHelper.saveAllItems(nbt, this.items);
		}
		
		return nbt;
	}

	@Override
	protected NonNullList<ItemStack> getItems() 
	{
		return this.items;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> items) 
	{
		this.items = items;
	}

	@Override
	protected Container createMenu(int windowId, PlayerInventory player) 
	{
		return null;
	}
}
