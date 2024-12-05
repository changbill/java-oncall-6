package oncall;

import oncall.controller.OnCallController;
import oncall.controller.OnCallControllerFactory;
import oncall.view.InputView;

public class OnCallSystem {
    private final InputView inputView;
    private final OnCallController controller;

    public OnCallSystem() {
        inputView = new InputView();
        controller = OnCallControllerFactory.getController();
    }
    public void run() {
        saveAssignMonthAndStartDayOfTheWeek();
        saveWeekdaysOnCallPlace();
        saveWeekendsOnCallPlace();
    }

    private void saveAssignMonthAndStartDayOfTheWeek() {
        while(true) {
            try {
                String inputValue = inputView.inputAssignMonthAndStartDayOfTheWeek();
                controller.saveAssignMonthAndStartDayOfTheWeek(inputValue);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void saveWeekdaysOnCallPlace() {
        while(true) {
            try {
                String inputValue = inputView.inputWeekdaysOnCallPlace();
                controller.saveWeekdaysOnCallPlace(inputValue);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void saveWeekendsOnCallPlace() {
        while(true) {
            try {
                String inputValue = inputView.inputWeekendsOnCallPlace();
                controller.saveWeekendsOnCallPlace(inputValue);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
