package achristmasmod.server.util;

import java.util.Calendar;

import net.minecraft.network.chat.Component;

public class ModCalendar {
	private final Calendar calendar;

	public ModCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public String getMonth() {
		String month = "";
		int theMonth = this.calendar.get(2);
		if (theMonth == 0) {
			month = "january";
		}
		if (theMonth == 1) {
			month = "february";
		}
		if (theMonth == 2) {
			month = "march";
		}
		if (theMonth == 3) {
			month = "april";
		}
		if (theMonth == 4) {
			month = "may";
		}
		if (theMonth == 5) {
			month = "june";
		}
		if (theMonth == 6) {
			month = "july";
		}
		if (theMonth == 7) {
			month = "august";
		}
		if (theMonth == 8) {
			month = "september";
		}
		if (theMonth == 9) {
			month = "october";
		}
		if (theMonth == 10) {
			month = "november";
		}
		if (theMonth == 11) {
			month = "december";
		}
		return Component.translatable("block.achristmasmod.calendar." + month).getString();
	}

	public String getMonth(int theMonth) {
		String month = "";
		if (theMonth == 0) {
			month = "january";
		}
		if (theMonth == 1) {
			month = "february";
		}
		if (theMonth == 2) {
			month = "march";
		}
		if (theMonth == 3) {
			month = "april";
		}
		if (theMonth == 4) {
			month = "may";
		}
		if (theMonth == 5) {
			month = "june";
		}
		if (theMonth == 6) {
			month = "july";
		}
		if (theMonth == 7) {
			month = "august";
		}
		if (theMonth == 8) {
			month = "september";
		}
		if (theMonth == 9) {
			month = "october";
		}
		if (theMonth == 10) {
			month = "november";
		}
		if (theMonth == 11) {
			month = "december";
		}
		return month;
	}

	public String getDate() {
		return Component.translatable(this.calendar.get(5) + "").getString();
	}

	public String getYear() {
		return Component.translatable(this.calendar.get(1) + "").getString();
	}
}
