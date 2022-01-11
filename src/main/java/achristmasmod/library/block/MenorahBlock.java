package achristmasmod.library.block;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class MenorahBlock 
{
	public static final VoxelShape SHAPE = Stream.of(Block.box(-5, 4, 6.5, 21, 6, 9.5), Block.box(6.5, 6, 6.5, 9.5, 8, 9.5), Block.box(6, 0, 6, 10, 1, 10), Block.box(7, 1, 7, 9, 4, 9)).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
}
