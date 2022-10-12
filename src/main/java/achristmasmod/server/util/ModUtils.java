package achristmasmod.server.util;

import net.minecraft.resources.ResourceLocation;

public class ModUtils {
	public static final String ID = "achristmasmod";

	public static ResourceLocation resource(String path) {
		return new ResourceLocation(ID, path);
	}
}
