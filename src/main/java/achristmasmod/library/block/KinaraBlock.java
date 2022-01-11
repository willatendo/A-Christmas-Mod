package achristmasmod.library.block;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class KinaraBlock extends Block
{
	protected static final Map<Block, Map<Direction, VoxelShape>> SHAPES = new HashMap<Block, Map<Direction, VoxelShape>>();
	private static final IntegerProperty CANDLES = IntegerProperty.create("candles", 0, 7);
	public static final DirectionProperty HORIZONTAL_FACING = HorizontalBlock.FACING;
	
	private static final VoxelShape SHAPE = Block.box(-3, 0, 6, 19, 5, 10);	
	
	public KinaraBlock(Properties properties) 
	{
		super(properties);		
		this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(CANDLES, Integer.valueOf(0)));

		runCalculation(SHAPE);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	{
		return SHAPES.get(this).get(state.getValue(HORIZONTAL_FACING));
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
	
	protected static VoxelShape calculateShapes(Direction to, VoxelShape shape) 
	{
		VoxelShape[] buffer = new VoxelShape[] { shape, VoxelShapes.empty() };

		int times = (to.get2DDataValue() - Direction.NORTH.get2DDataValue() + 4) % 4;
		for (int i = 0; i < times; i++) 
		{
			buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.or(buffer[1], VoxelShapes.box(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
			buffer[0] = buffer[1];
			buffer[1] = VoxelShapes.empty();
		}

		return buffer[0];
	}

	protected void runCalculation(VoxelShape shape) 
	{
		SHAPES.put(this, new HashMap<Direction, VoxelShape>());
		Map<Direction, VoxelShape> facingMap = SHAPES.get(this);
		for (Direction direction : Direction.values()) 
		{
			facingMap.put(direction, calculateShapes(direction, shape));
		}
	}
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) 
	{
		builder.add(HORIZONTAL_FACING, CANDLES);
	}
}
