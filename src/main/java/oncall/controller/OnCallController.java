package oncall.controller;

import java.util.List;
import oncall.model.OnCallResponseDto;
import oncall.service.OnCallCalculateService;
import oncall.service.OnCallSaveService;

public class OnCallController {
    private final OnCallSaveService onCallSaveService;
    private final OnCallCalculateService onCallCalculateService;

    public OnCallController(OnCallSaveService onCallSaveService, OnCallCalculateService onCallCalculateService) {
        this.onCallSaveService = onCallSaveService;
        this.onCallCalculateService = onCallCalculateService;
    }

    public void saveAssignMonthAndStartDayOfTheWeek(String inputValue) {
        onCallSaveService.saveAssignMonthAndStartDayOfTheWeek(inputValue);
    }

    public void saveWeekdaysOnCallPlace(String inputValue) {
        onCallSaveService.saveWeekdaysOnCallPlace(inputValue);
    }

    public void saveWeekendsOnCallPlace(String inputValue) {
        onCallSaveService.saveWeekendsOnCallPlace(inputValue);
    }

    public List<OnCallResponseDto> getOnCallResponseDto() {
        return onCallCalculateService.calculateOnCall();
    }
}
