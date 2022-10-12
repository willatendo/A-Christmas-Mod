package achristmasmod.server.blocks;

import java.util.Calendar;

import achristmasmod.server.util.ModCalendar;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class AbstractCalendarBlock extends HorizontalDirectionalBlock {
	protected int use;
	private static final VoxelShape WEST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	private static final VoxelShape EAST_SHAPE = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape NORTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	private static final VoxelShape SOUTH_SHAPE = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);

	public AbstractCalendarBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	public abstract InteractionResult useFunction(ModCalendar calendar, Level level, Player player);

	@Override
	public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
		return this.use > 0 ? super.use(blockState, level, blockPos, player, interactionHand, blockHitResult) : this.useFunction(new ModCalendar(Calendar.getInstance()), level, player);
	}

	@Override
	public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
		if (this.use > 0) {
			this.use--;
		}
		super.randomTick(blockState, serverLevel, blockPos, randomSource);
	}

	@Override
	public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
		Direction direction = blockState.getValue(FACING);
		BlockPos blockpos = blockPos.relative(direction.getOpposite());
		BlockState blockstate = levelReader.getBlockState(blockpos);
		return blockstate.isFaceSturdy(levelReader, blockpos, direction);
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		Direction facing = blockState.getValue(FACING);
		return facing == Direction.NORTH ? NORTH_SHAPE : facing == Direction.SOUTH ? SOUTH_SHAPE : facing == Direction.EAST ? EAST_SHAPE : WEST_SHAPE;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
		return true;
	}

	@Override
	public BlockState updateShape(BlockState blockState, Direction direction, BlockState newBlockState, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos newBlockPos) {
		return direction.getOpposite() == blockState.getValue(FACING) && !blockState.canSurvive(levelAccessor, blockPos) ? Blocks.AIR.defaultBlockState() : blockState;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
		if (!blockPlaceContext.replacingClickedOnBlock()) {
			BlockState blockstate = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos().relative(blockPlaceContext.getClickedFace().getOpposite()));
			if (blockstate.is(this) && blockstate.getValue(FACING) == blockPlaceContext.getClickedFace()) {
				return null;
			}
		}

		BlockState blockstate1 = this.defaultBlockState();
		LevelReader levelreader = blockPlaceContext.getLevel();
		BlockPos blockpos = blockPlaceContext.getClickedPos();

		for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
			if (direction.getAxis().isHorizontal()) {
				blockstate1 = blockstate1.setValue(FACING, direction.getOpposite());
				if (blockstate1.canSurvive(levelreader, blockpos)) {
					return blockstate1;
				}
			}
		}

		return null;
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(FACING);
		super.createBlockStateDefinition(builder);
	}
}
