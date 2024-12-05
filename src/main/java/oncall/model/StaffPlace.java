package oncall.model;

import java.util.HashSet;
import java.util.List;
import oncall.exception.InputException;

public class StaffPlace {
    private final List<Staff> staffList;

    public StaffPlace(List<Staff> staffList) {
        validateStaffPlace(staffList);
        this.staffList = staffList;
    }

    public void validateWeekendsPlace(StaffPlace weekdaysPlace) {
        validateExistsBoth(weekdaysPlace);
        validateSameCount(weekdaysPlace);
    }

    public Staff getStaffByIndex(int index) {
        return staffList.get(index);
    }

    public void changePlaceByFormerIndex(int formerIndex) {
        Staff formerStaff = staffList.get(formerIndex);

        // 마지막 index라면
        if(formerIndex == staffList.size() - 1) {
            Staff targetStaff = staffList.get(0);
            staffList.set(formerIndex, targetStaff);
            staffList.set(0, formerStaff);
            return;
        }

        Staff targetStaff = staffList.get(formerIndex + 1);
        staffList.set(formerIndex, targetStaff);
        staffList.set(formerIndex + 1, formerStaff);
    }

    public boolean containsStaff(Staff staff) {
        return staffList.contains(staff);
    }

    public int getStaffCount() {
        return staffList.size();
    }

    private void validateExistsBoth(StaffPlace weekdaysPlace) {
        if(!staffList.stream().allMatch(weekdaysPlace::containsStaff)) {
            throw new InputException();
        }
    }

    private void validateSameCount(StaffPlace weekdaysPlace) {
        if(staffList.size() != weekdaysPlace.getStaffCount()) {
            throw new InputException();
        }
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
