package achristmasmod.server.blocks;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FairyLightsBlock extends Block {
	private static final VoxelShape WEST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	private static final VoxelShape EAST_SHAPE = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape NORTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	private static final VoxelShape SOUTH_SHAPE = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = ImmutableMap.copyOf(Util.make(Maps.newEnumMap(Direction.class), (map) -> {
		map.put(Direction.NORTH, PipeBlock.NORTH);
		map.put(Direction.EAST, PipeBlock.EAST);
		map.put(Direction.SOUTH, PipeBlock.SOUTH);
		map.put(Direction.WEST, PipeBlock.WEST);
	}));
	private static final Map<Direction, VoxelShape> SHAPE_BY_DIRECTION = Util.make(Maps.newEnumMap(Direction.class), (map) -> {
		map.put(Direction.NORTH, NORTH_SHAPE);
		map.put(Direction.EAST, EAST_SHAPE);
		map.put(Direction.SOUTH, SOUTH_SHAPE);
		map.put(Direction.WEST, WEST_SHAPE);
	});
	protected static final Direction[] DIRECTIONS = Direction.Plane.HORIZONTAL.stream().toArray(Direction[]::new);
	private final ImmutableMap<BlockState, VoxelShape> shapesCache;
	private final boolean canRotate;
	private final boolean canMirrorX;
	private final boolean canMirrorZ;

	public FairyLightsBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(getDefaultMultifaceState(this.stateDefinition));
		this.shapesCache = this.getShapeForEachState(FairyLightsBlock::calculateMultifaceShape);
		this.canRotate = Direction.Plane.HORIZONTAL.stream().allMatch(this::isFaceSupported);
		this.canMirrorX = Direction.Plane.HORIZONTAL.stream().filter(Direction.Axis.X).filter(this::isFaceSupported).count() % 2L == 0L;
		this.canMirrorZ = Direction.Plane.HORIZONTAL.stream().filter(Direction.Axis.Z).filter(this::isFaceSupported).count() % 2L == 0L;
	}

	public static Set<Direction> availableFaces(BlockState blockState) {
		if (!(blockState.getBlock() instanceof FairyLightsBlock)) {
			return Set.of();
		} else {
			Set<Direction> set = EnumSet.noneOf(Direction.class);

			for (Direction direction : Direction.values()) {
				if (hasFace(blockState, direction)) {
					set.add(direction);
				}
			}

			return set;
		}
	}

	public static Set<Direction> unpack(byte pack) {
		Set<Direction> set = EnumSet.noneOf(Direction.class);

		for (Direction direction : Direction.values()) {
			if ((pack & (byte) (1 << direction.ordinal())) > 0) {
				set.add(direction);
			}
		}

		return set;
	}

	public static byte pack(Collection<Direction> collection) {
		byte b0 = 0;

		for (Direction direction : collection) {
			b0 = (byte) (b0 | 1 << direction.ordinal());
		}

		return b0;
	}

	protected boolean isFaceSupported(Direction direction) {
		return direction != Direction.UP && direction != Direction.DOWN;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		for (Direction direction : DIRECTIONS) {
			if (this.isFaceSupported(direction)) {
				builder.add(getFaceProperty(direction));
			}
		}
	}

	@Override
	public BlockState updateShape(BlockState blockState, Direction direction, BlockState newBlockState, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos newBlockPos) {
		if (!hasAnyFace(blockState)) {
			return Blocks.AIR.defaultBlockState();
		} else {
			return hasFace(blockState, direction) && !canAttachTo(levelAccessor, direction, newBlockPos, newBlockState) ? removeFace(blockState, getFaceProperty(direction)) : blockState;
		}
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return this.shapesCache.get(blockState);
	}

	@Override
	public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
		boolean flag = false;

		for (Direction direction : DIRECTIONS) {
			if (hasFace(blockState, direction)) {
				BlockPos blockpos = blockPos.relative(direction);
				if (!canAttachTo(levelReader, direction, blockpos, levelReader.getBlockState(blockpos))) {
					return false;
				}

				flag = true;
			}
		}

		return flag;
	}

	public boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
		return hasAnyVacantFace(blockState);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
		Level level = blockPlaceContext.getLevel();
		BlockPos blockpos = blockPlaceContext.getClickedPos();
		BlockState blockstate = level.getBlockState(blockpos);
		return Arrays.stream(blockPlaceContext.getNearestLookingDirections()).map((direction) -> {
			return this.getStateForPlacement(blockstate, level, blockpos, direction);
		}).filter(Objects::nonNull).findFirst().orElse((BlockState) null);
	}

	public boolean isValidStateForPlacement(BlockGetter blockGetter, BlockState blockState, BlockPos blockPos, Direction direction) {
		if (this.isFaceSupported(direction) && (!blockState.is(this) || !hasFace(blockState, direction))) {
			BlockPos blockpos = blockPos.relative(direction);
			return canAttachTo(blockGetter, direction, blockpos, blockGetter.getBlockState(blockpos));
		} else {
			return false;
		}
	}

	public BlockState getStateForPlacement(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
		if (!this.isValidStateForPlacement(blockGetter, blockState, blockPos, direction)) {
			return null;
		} else {
			BlockState blockstate;
			if (blockState.is(this)) {
				blockstate = blockState;
			} else {
				blockstate = this.defaultBlockState();
			}

			return blockstate.setValue(getFaceProperty(direction), Boolean.valueOf(true));
		}
	}

	@Override
	public BlockState rotate(BlockState blockState, Rotation rotation) {
		return !this.canRotate ? blockState : this.mapDirections(blockState, rotation::rotate);
	}

	@Override
	public BlockState mirror(BlockState blockState, Mirror mirror) {
		if (mirror == Mirror.FRONT_BACK && !this.canMirrorX) {
			return blockState;
		} else {
			return mirror == Mirror.LEFT_RIGHT && !this.canMirrorZ ? blockState : this.mapDirections(blockState, mirror::mirror);
		}
	}

	private BlockState mapDirections(BlockState blockState, Function<Direction, Direction> function) {
		BlockState blockstate = blockState;

		for (Direction direction : DIRECTIONS) {
			if (this.isFaceSupported(direction)) {
				blockstate = blockstate.setValue(getFaceProperty(function.apply(direction)), blockState.getValue(getFaceProperty(direction)));
			}
		}

		return blockstate;
	}

	public static boolean hasFace(BlockState blockState, Direction direction) {
		BooleanProperty booleanproperty = getFaceProperty(direction);
		return blockState.hasProperty(booleanproperty) && blockState.getValue(booleanproperty);
	}

	public static boolean canAttachTo(BlockGetter blockGetter, Direction direction, BlockPos blockPos, BlockState blockState) {
		return Block.isFaceFull(blockState.getBlockSupportShape(blockGetter, blockPos), direction.getOpposite()) || Block.isFaceFull(blockState.getCollisionShape(blockGetter, blockPos), direction.getOpposite());
	}

	private static BlockState removeFace(BlockState blockState, BooleanProperty booleanProperty) {
		BlockState blockstate = blockState.setValue(booleanProperty, Boolean.valueOf(false));
		return hasAnyFace(blockstate) ? blockstate : Blocks.AIR.defaultBlockState();
	}

	public static BooleanProperty getFaceProperty(Direction direction) {
		if (direction == Direction.UP) {
			return PROPERTY_BY_DIRECTION.get(Direction.NORTH);
		}
		if (direction == Direction.DOWN) {
			return PROPERTY_BY_DIRECTION.get(Direction.NORTH);
		}
		return PROPERTY_BY_DIRECTION.get(direction);
	}

	private static BlockState getDefaultMultifaceState(StateDefinition<Block, BlockState> stateDefinition) {
		BlockState blockstate = stateDefinition.any();

		for (BooleanProperty booleanproperty : PROPERTY_BY_DIRECTION.values()) {
			if (blockstate.hasProperty(booleanproperty)) {
				blockstate = blockstate.setValue(booleanproperty, Boolean.valueOf(false));
			}
		}

		return blockstate;
	}

	private static VoxelShape calculateMultifaceShape(BlockState blockState) {
		VoxelShape voxelshape = Shapes.empty();

		for (Direction direction : DIRECTIONS) {
			if (hasFace(blockState, direction)) {
				voxelshape = Shapes.or(voxelshape, SHAPE_BY_DIRECTION.get(direction));
			}
		}

		return voxelshape.isEmpty() ? Shapes.block() : voxelshape;
	}

	protected static boolean hasAnyFace(BlockState blockState) {
		return Arrays.stream(DIRECTIONS).anyMatch((direction) -> {
			return hasFace(blockState, direction);
		});
	}

	private static boolean hasAnyVacantFace(BlockState blockState) {
		return Arrays.stream(DIRECTIONS).anyMatch((direction) -> {
			return !hasFace(blockState, direction);
		});
	}
}
