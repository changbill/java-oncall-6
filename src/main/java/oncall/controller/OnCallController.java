package oncall.controller;

import oncall.service.OnCallSaveService;

public class OnCallController {
    private final OnCallSaveService onCallSaveService;

    public OnCallController(OnCallSaveService onCallSaveService) {
        this.onCallSaveService = onCallSaveService;
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
}
