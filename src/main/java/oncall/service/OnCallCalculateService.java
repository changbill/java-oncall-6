package oncall.service;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import oncall.model.OnCallResponseDto;
import oncall.model.OnCallResponseDtoBuilder;
import oncall.model.Staff;
import oncall.model.StaffPlace;
import oncall.repository.OnCallRepository;
import oncall.util.Calendar;
import oncall.util.DayOfTheWeekConstant;
import oncall.util.HolidayConstant;
import oncall.util.WeekdaysAndWeekends;

public class OnCallCalculateService {
    private final OnCallRepository onCallRepository;
    private int weekdaysCount = 0;
    private int holidayCount = 0;

    public OnCallCalculateService(OnCallRepository onCallRepository) {
        this.onCallRepository = onCallRepository;
    }

    public List<OnCallResponseDto> calculateOnCall() {
        Month month = onCallRepository.getAssignedMonth();
        DayOfWeek startDayOfWeek = onCallRepository.getStartDayOfWeek();
        StaffPlace weekdaysPlace = onCallRepository.getWeekdaysPlace();
        StaffPlace weekendsPlace = onCallRepository.getWeekendsPlace();
        Staff beforeStaff = null;

        Calendar calendar = Calendar.getMonth(month);

        List<OnCallResponseDto> onCallResponseDtos = new ArrayList<>();

        for (Integer date : calendar.getDates()) {
            int monthInNumber = month.getValue();
            DayOfWeek dayOfWeek = startDayOfWeek.plus(date - 1);
            boolean isHoliday = HolidayConstant.isHoliday(month.getValue(), date);
            boolean isWeekend = WeekdaysAndWeekends.isWeekend(dayOfWeek);
            Staff targetStaff = null;

            if (isHoliday || isWeekend) {
                targetStaff = weekendsPlace.getStaffByIndex(holidayCount);

                // 이전 날짜 근무자와 일치하는 경우
                if(beforeStaff != null && beforeStaff == targetStaff) {
                    weekendsPlace.changePlaceByFormerIndex(holidayCount);
                    targetStaff = weekendsPlace.getStaffByIndex(holidayCount);
                }

                holidayCount++;
                if(holidayCount == weekendsPlace.getStaffCount()) {
                    holidayCount = 0;
                }
            }

            if(!isHoliday && !isWeekend) {
                targetStaff = weekdaysPlace.getStaffByIndex(weekdaysCount);

                // 이전 날짜 근무자와 일치하는 경우
                if(beforeStaff != null && beforeStaff == targetStaff) {
                    weekdaysPlace.changePlaceByFormerIndex(weekdaysCount);
                    targetStaff = weekdaysPlace.getStaffByIndex(weekdaysCount);
                }

                weekdaysCount++;
                if(weekdaysCount == weekdaysPlace.getStaffCount()) {
                    weekdaysCount = 0;
                }
            }

            onCallResponseDtos.add(
                    new OnCallResponseDtoBuilder()
                            .month(monthInNumber)
                            .date(date)
                            .dayOfTheWeek(DayOfTheWeekConstant.getKoreanByDayOfWeek(dayOfWeek))
                            .isHolidayInWeekdays(isHoliday && isWeekend)
                            .staffName(targetStaff.getName())
                            .build()
            );

            beforeStaff = targetStaff;
        }

        return onCallResponseDtos;
    }
}
