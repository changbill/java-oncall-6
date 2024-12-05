package oncall.util;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Optional;

public enum DayOfTheWeekConstant {
    MONDAY("월", DayOfWeek.MONDAY),
    TUESDAY("화", DayOfWeek.TUESDAY),
    WEDNESDAY("수", DayOfWeek.WEDNESDAY),
    THURSDAY("목", DayOfWeek.THURSDAY),
    FRIDAY("금", DayOfWeek.FRIDAY),
    SATURDAY("토", DayOfWeek.SATURDAY),
    SUNDAY("일", DayOfWeek.SUNDAY),
    ;

    private final String inKorean;
    private final DayOfWeek dayOfWeek;

    DayOfTheWeekConstant(String inKorean, DayOfWeek dayOfWeek) {
        this.inKorean = inKorean;
        this.dayOfWeek = dayOfWeek;
    }

    public static Optional<DayOfWeek> getDayOfWeekByKorean(String korean) {
        return Arrays.stream(values())
                .filter(v -> v.inKorean.equals(korean))
                .map(DayOfTheWeekConstant::getDayOfWeek)
                .findFirst();
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public String getInKorean() {
        return inKorean;
    }
}
