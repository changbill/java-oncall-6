package oncall.model;

import java.util.HashSet;
import java.util.List;
import oncall.exception.InputException;

public class WeekdaysPlace {
    private final List<Staff> staffPlace;

    public WeekdaysPlace(List<Staff> staffPlace) {
        validateStaffPlace(staffPlace);
        this.staffPlace = staffPlace;
    }

    private void validateStaffPlace(List<Staff> target) {
        validateDuplication(target);
        validateMinimumCount(target);
        validateMaximumCount(target);
    }

    private void validateDuplication(List<Staff> target) {
        if(target.size() != new HashSet<>(target).size()) {
            throw new InputException();
        }
    }

    private void validateMinimumCount(List<Staff> target) {
        if(target.size() < 5) {
            throw new InputException();
        }
    }

    private void validateMaximumCount(List<Staff> target) {
        if(target.size() > 35) {
            throw new InputException();
        }
    }
}
