package oncall.service;

import static oncall.util.DayOfTheWeekConstant.FRIDAY;
import static oncall.util.DayOfTheWeekConstant.MONDAY;
import static oncall.util.DayOfTheWeekConstant.SATURDAY;
import static oncall.util.DayOfTheWeekConstant.SUNDAY;
import static oncall.util.DayOfTheWeekConstant.THURSDAY;
import static oncall.util.DayOfTheWeekConstant.TUESDAY;
import static oncall.util.DayOfTheWeekConstant.WEDNESDAY;

import oncall.exception.InputException;

public class OnCallValidator {
    private static final String MONTH_AND_DAYOFTHEWEEK_REGEX = "^([1-9]|1[012])\\,(%s|%s|%s|%s|%s|%s|%s)$";
    private static final String ON_CALL_PLACE_REGEX = "([가-힣]{1,5},)+[가-힣]{1,5}$";

    public void validateAssignMonthAndStartDayOfTheWeek(String inputValue) {
        if(!inputValue.matches(
                String.format(
                        MONTH_AND_DAYOFTHEWEEK_REGEX,
                        MONDAY.getInKorean(),
                        TUESDAY.getInKorean(),
                        WEDNESDAY.getInKorean(),
                        THURSDAY.getInKorean(),
                        FRIDAY.getInKorean(),
                        SATURDAY.getInKorean(),
                        SUNDAY.getInKorean()
                )
        )) {
            throw new InputException();
        }
    }

    public void validateOnCallPlace(String inputValue) {
        if(!inputValue.matches(ON_CALL_PLACE_REGEX)) {
            throw new InputException();
        }
    }
}
