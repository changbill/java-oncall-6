package oncall.util;

import java.util.Arrays;

public enum HolidayConstant {
    NEW_YEAR(1, 1),
    THREE_ONE_DAY(3, 1),
    CHILDREN_DAY(5, 5),
    MEMORIAL_DAY(6 ,6),
    LIBERATION_DAY(8, 15),
    NATIONAL_FOUNDATION_DAY(10, 3),
    HANGUL_DAY(10, 9),
    XMAS(12, 25),
    ;

    private final int month;
    private final int date;

    HolidayConstant(int month, int date) {
        this.month = month;
        this.date = date;
    }

    public static boolean isHoliday(int month, int date) {
        return Arrays.stream(values()).anyMatch(value ->
            value.month == month && value.date == date
        );
    }
}
