package achristmasmod.server;

import achristmasmod.server.util.ModUtils;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ChristmasTags {
	public static class Items {
		public static final TagKey<Item> GIFTS = create("gifts");

		public static TagKey<Item> create(String id) {
			return TagKey.create(Registry.ITEM_REGISTRY, ModUtils.resource(id));
		}
	}
}
