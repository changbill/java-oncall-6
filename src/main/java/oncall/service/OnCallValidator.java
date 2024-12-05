package oncall.service;

import static oncall.model.DayOfTheWeekConstant.FRIDAY;
import static oncall.model.DayOfTheWeekConstant.MONDAY;
import static oncall.model.DayOfTheWeekConstant.SATURDAY;
import static oncall.model.DayOfTheWeekConstant.SUNDAY;
import static oncall.model.DayOfTheWeekConstant.THURSDAY;
import static oncall.model.DayOfTheWeekConstant.TUESDAY;
import static oncall.model.DayOfTheWeekConstant.WEDNESDAY;

import oncall.exception.InputException;

public class OnCallValidator {
    private static final String MONTH_AND_DAYOFTHEWEEK_REGEX = "^([1-9]|1[012])\\,(%s|%s|%s|%s|%s|%s|%s)$";

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


}
