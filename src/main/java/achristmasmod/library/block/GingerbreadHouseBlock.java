package achristmasmod.library.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;

public class GingerbreadHouseBlock extends Block
{
	public static final DirectionProperty HORIZONTAL_FACING = HorizontalBlock.FACING;

	public GingerbreadHouseBlock(Properties properties) 
	{
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH));
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) 
	{
		return this.defaultBlockState().setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	@Nullable
	public BlockState rotate(BlockState state, Rotation rotation) 
	{
		return state.setValue(HORIZONTAL_FACING, rotation.rotate(state.getValue(HORIZONTAL_FACING)));
	}

	@Override
	@Nullable
	public BlockState mirror(BlockState state, Mirror mirror) 
	{
		return state.rotate(mirror.getRotation(state.getValue(HORIZONTAL_FACING)));
	}
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) 
	{
		builder.add(HORIZONTAL_FACING);
	}
}
