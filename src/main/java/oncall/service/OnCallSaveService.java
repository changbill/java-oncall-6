package oncall.service;

import java.time.DayOfWeek;
import java.time.Month;
import oncall.model.StaffPlace;
import oncall.repository.OnCallRepository;

public class OnCallSaveService {
    private final OnCallValidator onCallValidator;
    private final OnCallParser onCallParser;
    private final OnCallRepository onCallRepository;

    public OnCallSaveService(
            OnCallValidator onCallValidator,
            OnCallParser onCallParser,
            OnCallRepository onCallRepository
    ) {
        this.onCallValidator = onCallValidator;
        this.onCallParser = onCallParser;
        this.onCallRepository = onCallRepository;
    }

    public void saveAssignMonthAndStartDayOfTheWeek(String inputValue) {
        onCallValidator.validateAssignMonthAndStartDayOfTheWeek(inputValue);
        Month month = onCallParser.parseToMonth(inputValue);
        DayOfWeek dayOfWeek = onCallParser.parseToDayOfTheWeek(inputValue);

        onCallRepository.saveAssignMonthAndStartDayOfTheWeek(month, dayOfWeek);
    }

    public void saveWeekdaysOnCallPlace(String inputValue) {
        onCallValidator.validateOnCallPlace(inputValue);
        StaffPlace weekdaysPlace = onCallParser.parseToStaffPlace(inputValue);

        onCallRepository.saveWeekdaysOnCallPlace(weekdaysPlace);
    }

    public void saveWeekendsOnCallPlace(String inputValue) {
        onCallValidator.validateOnCallPlace(inputValue);
        StaffPlace weekendsPlace = onCallParser.parseToStaffPlace(inputValue);
        StaffPlace weekdaysPlace = onCallRepository.getWeekdaysPlace();
        weekendsPlace.validateWeekendsPlace(weekdaysPlace);

        onCallRepository.saveWeekendsOnCallPlace(weekendsPlace);
    }
}
