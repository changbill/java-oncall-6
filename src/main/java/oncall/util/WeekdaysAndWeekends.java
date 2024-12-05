package oncall.util;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

import java.time.DayOfWeek;
import java.util.List;

public enum WeekdaysAndWeekends {
    WEEKDAYS(List.of(MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY)),
    WEEKENDS(List.of(SATURDAY,SUNDAY)),
    ;

    private final List<DayOfWeek> dayOfTheWeekList;

    WeekdaysAndWeekends(List<DayOfWeek> dayOfTheWeekList) {
        this.dayOfTheWeekList = dayOfTheWeekList;
    }

    public static boolean isWeekday(DayOfWeek dayOfTheWeek) {
        return WEEKDAYS.dayOfTheWeekList.contains(dayOfTheWeek);
    }

    public static boolean isWeekend(DayOfWeek dayOfTheWeek) {
        return WEEKENDS.dayOfTheWeekList.contains(dayOfTheWeek);
    }
}
