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
                controller.saveAssignMonthAndStartDayOfTheWeek(inputView.inputAssignMonthAndStartDayOfTheWeek());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void saveWeekdaysOnCallPlace() {
        while(true) {
            try {
                inputView.inputWeekdaysOnCallPlace();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void saveWeekendsOnCallPlace() {
        while(true) {
            try {
                inputView.inputWeekendsOnCallPlace();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
