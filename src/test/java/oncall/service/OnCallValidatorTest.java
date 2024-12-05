package oncall.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OnCallValidatorTest {
    private OnCallValidator onCallValidator;

    @BeforeEach
    void setUp() {
        onCallValidator = new OnCallValidator();
    }

    @ParameterizedTest
    @DisplayName("비상 근무를 배정할 월과 시작 요일의 입력 값이 올바르지 않은 경우")
    @ValueSource(strings = {"asb", "123", "!?", "13,월", "0,월", "1,워", "2,뫀"})
    void validateAssignMonthAndStartDayOfTheWeekExceptionTest(String value) {
        assertThatThrownBy(() -> onCallValidator.validateAssignMonthAndStartDayOfTheWeek(value))
                .hasMessageContaining("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("비상 근무를 배정할 월과 시작 요일의 입력 값이 바른 경우")
    @ValueSource(strings = {"1,월", "2,화", "3,수", "12,일"})
    void validateAssignMonthAndStartDayOfTheWeekTest(String value) {
        assertDoesNotThrow(() -> onCallValidator.validateAssignMonthAndStartDayOfTheWeek(value));
    }
}