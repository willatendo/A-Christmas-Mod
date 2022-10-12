package achristmasmod.server.blocks;

import achristmasmod.server.util.ModCalendar;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CalendarBlock extends AbstractCalendarBlock {
	public CalendarBlock(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useFunction(ModCalendar modCalendar, Level level, Player player) {
		this.use = 1;
		player.sendSystemMessage(Component.translatable("block.achristmasmod.calendar.date", modCalendar.getMonth(), modCalendar.getDate() + (modCalendar.getDate().endsWith("1") ? "st," : modCalendar.getDate().endsWith("2") ? "nd," : modCalendar.getDate().endsWith("3") ? "rd," : "th,"), modCalendar.getYear()));
		return InteractionResult.SUCCESS;
	}
}
