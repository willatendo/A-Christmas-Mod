package achristmasmod.library.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class PresentBlock extends Block
{
	private static final VoxelShape SHAPE = Block.box(3, 0, 3, 13, 8, 13);

	public PresentBlock(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) 
	{
		return SHAPE;
	}
}
