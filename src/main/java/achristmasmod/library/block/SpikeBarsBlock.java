package achristmasmod.library.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FourWayBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SpikeBarsBlock extends FourWayBlock 
{
	public static final BooleanProperty FULL_HEIGHT = BooleanProperty.create("full_height");
	public SpikeBarsBlock(Properties properties) 
	{
		super(1.0F, 1.0F, 16.0F, 16.0F, 16.0F, properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, Boolean.valueOf(false)).setValue(EAST, Boolean.valueOf(false)).setValue(SOUTH, Boolean.valueOf(false)).setValue(WEST, Boolean.valueOf(false)).setValue(FULL_HEIGHT, false).setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	public static boolean canConnect(BlockState state, BlockPos pos, IWorld world, Direction dir) 
	{
		if(state.getBlock() instanceof SpikeBarsBlock) 
		{
			return true;
		}
		return false;
	}

	public final boolean attachsTo(BlockState state, boolean sturdy) 
	{
		Block block = state.getBlock();
		return !isExceptionForConnection(block) && sturdy || block instanceof SpikeBarsBlock || block.is(BlockTags.WALLS);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) 
	{
		IBlockReader iblockreader = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
		BlockPos blockpos1 = blockpos.north();
		BlockPos blockpos2 = blockpos.south();
		BlockPos blockpos3 = blockpos.west();
		BlockPos blockpos4 = blockpos.east();
		BlockState blockstate = iblockreader.getBlockState(blockpos1);
		BlockState blockstate1 = iblockreader.getBlockState(blockpos2);
		BlockState blockstate2 = iblockreader.getBlockState(blockpos3);
		BlockState blockstate3 = iblockreader.getBlockState(blockpos4);
		World world = context.getLevel();
		BlockPos pos = context.getClickedPos();
		return this.defaultBlockState().setValue(NORTH, Boolean.valueOf(this.attachsTo(blockstate, blockstate.isFaceSturdy(iblockreader, blockpos1, Direction.SOUTH)))).setValue(SOUTH, Boolean.valueOf(this.attachsTo(blockstate1, blockstate1.isFaceSturdy(iblockreader, blockpos2, Direction.NORTH)))).setValue(WEST, Boolean.valueOf(this.attachsTo(blockstate2, blockstate2.isFaceSturdy(iblockreader, blockpos3, Direction.EAST)))).setValue(EAST, Boolean.valueOf(this.attachsTo(blockstate3, blockstate3.isFaceSturdy(iblockreader, blockpos4, Direction.WEST)))).setValue(FULL_HEIGHT, canConnect(world.getBlockState(pos.above()), pos, world, Direction.UP)).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
	}

	@Override
	public BlockState updateShape(BlockState state, Direction direction, BlockState newstate, IWorld world, BlockPos pos, BlockPos newpos) 
	{
		if(state.getValue(WATERLOGGED)) 
		{
			world.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		
		if(direction == Direction.UP) 
		{
			return state.setValue(FULL_HEIGHT, canConnect(newstate, pos, world, direction));
		}

		return direction.getAxis().isHorizontal() ? state.setValue(PROPERTY_BY_DIRECTION.get(direction), Boolean.valueOf(this.attachsTo(newstate, newstate.isFaceSturdy(world, newpos, direction.getOpposite())))) : super.updateShape(state, direction, newstate, world, pos, newpos);
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) 
	{
		return VoxelShapes.empty();
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean skipRendering(BlockState state, BlockState newstate, Direction direction) 
	{
		if(newstate.is(this)) 
		{
			if(!direction.getAxis().isHorizontal()) 
			{
				return true;
			}

			if(state.getValue(PROPERTY_BY_DIRECTION.get(direction)) && newstate.getValue(PROPERTY_BY_DIRECTION.get(direction.getOpposite()))) 
			{
				return true;
			}
		}

		return super.skipRendering(state, newstate, direction);
	}

	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) 
	{
		builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED, FULL_HEIGHT);
	}
}
