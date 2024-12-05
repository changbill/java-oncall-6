package oncall.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import oncall.repository.OnCallRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OnCallServiceTest {
    private OnCallService onCallService;

    @BeforeEach
    void setUp() {
        onCallService = new OnCallService(new OnCallValidator(), new OnCallParser(), new OnCallRepository());
    }

    @Nested
    class WeekdaysOnCallPlaceTests {

        @ParameterizedTest
        @ValueSource(strings = {
                "가,나,다,라,마",
                "가,나,다,라,마,바,사,아,자,차,카,타,파,하,기,니,디,리,미,비,시,이,지,치,키,티,피,히,그,느,드,르,므,브,스",
                "가나다라마,가,나,다,라"
        })
        void 정상_테스트(String value) {
            assertSimpleTest(() ->
                    assertDoesNotThrow(() -> onCallService.saveWeekdaysOnCallPlace(value))
            );
        }

        @Test
        void 닉네임_최대길이_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> onCallService.saveWeekdaysOnCallPlace("가나다라마바,나,다,라,가"))
                            .hasMessageContaining("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.")
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 중복_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> onCallService.saveWeekdaysOnCallPlace("가,나,다,라,가"))
                            .hasMessageContaining("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.")
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 직원_최소_숫자_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> onCallService.saveWeekdaysOnCallPlace("가,나,다,라"))
                            .hasMessageContaining("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.")
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 직원_최대_숫자_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> onCallService.saveWeekdaysOnCallPlace(
                            "가,나,다,라,마,바,사,아,자,차,카,타,파,하,"
                                    + "기,니,디,리,미,비,시,이,지,치,키,티,피,히,"
                                    + "그,느,드,르,므,브,스,으"
                    ))
                            .hasMessageContaining("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.")
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }
}