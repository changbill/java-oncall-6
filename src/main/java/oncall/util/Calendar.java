package oncall.util;

import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public enum Calendar {
    JANUARY(IntStream.range(1, 32).boxed().toList()),
    FEBRUARY(IntStream.range(1, 29).boxed().toList()),
    MARCH(IntStream.range(1, 32).boxed().toList()),
    APRIL(IntStream.range(1, 31).boxed().toList()),
    MAY(IntStream.range(1, 32).boxed().toList()),
    JUNE(IntStream.range(1, 31).boxed().toList()),
    JULY(IntStream.range(1, 32).boxed().toList()),
    AUGUST(IntStream.range(1, 32).boxed().toList()),
    SEPTEMBER(IntStream.range(1, 31).boxed().toList()),
    OCTOBER(IntStream.range(1, 32).boxed().toList()),
    NOVEMBER(IntStream.range(1, 31).boxed().toList()),
    DECEMBER(IntStream.range(1, 32).boxed().toList()),
    ;

    private final List<Integer> dates;

    Calendar(List<Integer> dates) {
        this.dates = dates;
    }

    public static Calendar getMonth(Month month) {
        return Arrays.stream(values())
                .filter(value -> month.name().equals(value.name()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid month: " + month));
    }

    public List<Integer> getDates() {
        return dates;
    }
}
