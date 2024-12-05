package oncall.view;

import java.util.List;
import oncall.model.OnCallResponseDto;

public class OutputView {

    public void printOnCallResponse(List<OnCallResponseDto> onCallResponseDtos) {
        for(OnCallResponseDto response : onCallResponseDtos) {
            int month = response.month();
            int date = response.date();
            String dayOfTheWeek = response.dayOfTheWeek();
            String name = response.staffName();

            if(response.isHolidayInWeekdays()) {
                System.out.printf("%d월 %d일 %s(휴일) %s" + System.lineSeparator(), month, date, dayOfTheWeek, name);
                return;
            }

            System.out.printf("%d월 %d일 %s %s" + System.lineSeparator(), month, date, dayOfTheWeek, name);
        }
    }
}
