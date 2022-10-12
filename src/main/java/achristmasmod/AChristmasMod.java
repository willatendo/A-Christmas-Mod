package achristmasmod;

import achristmasmod.server.blocks.ChristmasBlocks;
import achristmasmod.server.util.ModUtils;
import net.minecraftforge.fml.common.Mod;

@Mod(ModUtils.ID)
public class AChristmasMod {
	public AChristmasMod() {
		ChristmasBlocks.init();
	}
}
