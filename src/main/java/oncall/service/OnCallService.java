package oncall.service;

import java.time.DayOfWeek;
import oncall.repository.OnCallRepository;

public class OnCallService {
    private final OnCallValidator onCallValidator;
    private final OnCallParser onCallParser;
    private final OnCallRepository onCallRepository;

    public OnCallService(
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
        int month = onCallParser.parseToMonth(inputValue);
        DayOfWeek dayOfWeek = onCallParser.parseToDayOfTheWeek(inputValue);

        onCallRepository.saveAssignMonthAndStartDayOfTheWeek(month, dayOfWeek);
    }
}
