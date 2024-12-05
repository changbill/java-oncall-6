package oncall.model;

public record OnCallResponseDto(int month, int date, String dayOfTheWeek, boolean isHolidayInWeekdays, String staffName) {
}
