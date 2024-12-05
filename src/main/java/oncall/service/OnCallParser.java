package oncall.service;

import static oncall.util.Delimiter.COMMA;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Arrays;
import java.util.stream.Collectors;
import oncall.model.Staff;
import oncall.model.StaffPlace;
import oncall.util.DayOfTheWeekConstant;

public class OnCallParser {
    private static final int MONTH_INDEX = 0;
    private static final int DAYOFTHEWEEK_INDEX = 1;

    public Month parseToMonth(String inputValue) {
        String[] splitValue = inputValue.split(COMMA.getDelimiter());
        return Month.of(getParsedInt(splitValue[MONTH_INDEX]));
    }

    public DayOfWeek parseToDayOfTheWeek(String inputValue) {
        String[] splitValue = inputValue.split(COMMA.getDelimiter());
        return DayOfTheWeekConstant.getDayOfWeekByKorean(splitValue[DAYOFTHEWEEK_INDEX])
                .orElseThrow(() -> new IllegalArgumentException("요일을 변환하는 중 알 수 없는 오류가 발생했습니다."));
    }

    public StaffPlace parseToStaffPlace(String inputValue) {
        return new StaffPlace(
                Arrays.stream(inputValue.split(COMMA.getDelimiter()))
                        .map(Staff::of)
                        .collect(Collectors.toList())
        );
    }

    private int getParsedInt(String value) {
        return Integer.parseInt(value);
    }
}
