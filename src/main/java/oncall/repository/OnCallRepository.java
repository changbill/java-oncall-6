package oncall.repository;

import java.time.DayOfWeek;
import java.time.Month;
import oncall.model.StaffPlace;

public class OnCallRepository {
    private Month assignedMonth;
    private DayOfWeek startDayOfWeek;
    private StaffPlace weekdaysPlace;
    private StaffPlace weekendsPlace;

    public void saveAssignMonthAndStartDayOfTheWeek(Month month, DayOfWeek dayOfWeek) {
        assignedMonth = month;
        startDayOfWeek = dayOfWeek;
    }

    public void saveWeekdaysOnCallPlace(StaffPlace weekdaysPlace) {
        this.weekdaysPlace = weekdaysPlace;
    }

    public void saveWeekendsOnCallPlace(StaffPlace weekendsPlace) {
        this.weekendsPlace = weekendsPlace;
    }

    public Month getAssignedMonth() {
        return assignedMonth;
    }

    public DayOfWeek getStartDayOfWeek() {
        return startDayOfWeek;
    }

    public StaffPlace getWeekdaysPlace() {
        return weekdaysPlace;
    }

    public StaffPlace getWeekendsPlace() {
        return weekendsPlace;
    }
}
