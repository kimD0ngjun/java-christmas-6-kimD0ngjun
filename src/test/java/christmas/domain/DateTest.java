package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

    @DisplayName("1일부터 31일까지 중의 숫자를 입력해야 한다.")
    @Test
    void validDateTest() {
        assertDoesNotThrow(() -> new Date(15));
    }

    @DisplayName("날짜를 벗어난 숫자를 입력하지 않는다.")
    @Test
    void invalidDateTest() {
        assertThrows(IllegalArgumentException.class, () -> new Date(35));
    }

    @DisplayName("0 혹은 음수의 숫자를 입력하지 않는다.")
    @Test
    void invalidNegativeDateTest() {
        assertThrows(IllegalArgumentException.class, () -> new Date(0));
        assertThrows(IllegalArgumentException.class, () -> new Date(-5));
    }
}