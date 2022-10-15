package achristmasmod.server.blocks;

import achristmasmod.server.util.ModCalendar;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class AdventCalendarBlock extends AbstractCalendarBlock {
	public AdventCalendarBlock(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useFunction(ModCalendar modCalendar, Level level, Player player) {
		return null;
	}
}
