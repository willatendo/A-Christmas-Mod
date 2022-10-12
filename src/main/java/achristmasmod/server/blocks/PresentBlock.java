package achristmasmod.server.blocks;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import achristmasmod.server.ChristmasTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ForgeRegistries;

public class PresentBlock extends Block {
	public static final VoxelShape SHAPE = Block.box(3.0D, 0, 3.0D, 13.0D, 10.0D, 13.0D);

	public PresentBlock(Properties properties) {
		super(properties);
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return SHAPE;
	}

	@Override
	public void appendHoverText(ItemStack itemStack, BlockGetter blockGetter, List<Component> components, TooltipFlag tooltipFlag) {
		components.add(Component.translatable("block.achristmasmod.present.opendate").withStyle(ChatFormatting.GRAY));
		super.appendHoverText(itemStack, blockGetter, components, tooltipFlag);
	}

	@Override
	public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
		Calendar calendar = Calendar.getInstance();
		if ((calendar.get(2) + 1 == 12 && calendar.get(5) == 25) || !FMLEnvironment.production) {
			List<Item> gifts = ForgeRegistries.ITEMS.tags().getTag(ChristmasTags.Items.GIFTS).stream().toList();
			Block.popResource(level, blockPos, gifts.get(new Random().nextInt(gifts.size())).getDefaultInstance());
			level.destroyBlock(blockPos, false);
			return InteractionResult.SUCCESS;
		}
		player.sendSystemMessage(Component.translatable("block.achristmasmod.present.notopenable"));
		return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
	}
}
