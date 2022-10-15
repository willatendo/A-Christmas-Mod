package achristmasmod.server;

import achristmasmod.server.util.ModUtils;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ChristmasTags {
	public static class Items {
		public static final TagKey<Item> GIFTS = create("gifts");

		public static final TagKey<Item> PRESENTS = create("presents");

		public static TagKey<Item> create(String id) {
			return TagKey.create(Registry.ITEM_REGISTRY, ModUtils.resource(id));
		}
	}

	public static class Blocks {
		public static final TagKey<Block> PRESENTS = create("presents");

		public static TagKey<Block> create(String id) {
			return TagKey.create(Registry.BLOCK_REGISTRY, ModUtils.resource(id));
		}
	}
}
