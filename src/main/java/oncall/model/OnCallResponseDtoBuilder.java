package oncall.model;

public class OnCallResponseDtoBuilder {
    private int month;
    private int date;
    private String dayOfTheWeek;
    private boolean isHolidayInWeekdays;
    private String staffName;

    public OnCallResponseDtoBuilder month(int month) {
        this.month = month;
        return this;
    }

    public OnCallResponseDtoBuilder date(int date) {
        this.date = date;
        return this;
    }

    public OnCallResponseDtoBuilder dayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
        return this;
    }

    public OnCallResponseDtoBuilder isHolidayInWeekdays(boolean isHoliday) {
        this.isHolidayInWeekdays = isHoliday;
        return this;
    }

    public OnCallResponseDtoBuilder staffName(String staffName) {
        this.staffName = staffName;
        return this;
    }

    public OnCallResponseDto build() {
        return new OnCallResponseDto(month, date, dayOfTheWeek, isHolidayInWeekdays, staffName);
    }
}
