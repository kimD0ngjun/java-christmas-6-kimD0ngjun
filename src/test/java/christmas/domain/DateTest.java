package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

    @DisplayName("1일부터 31일까지 중의 숫자를 입력해야 한다.")
    @Test
    void validDateTest() {
        assertDoesNotThrow(() -> new OrderDate(15));
    }

    @DisplayName("날짜를 벗어난 숫자를 입력하지 않는다.")
    @Test
    void invalidDateTest() {
        assertThrows(IllegalArgumentException.class, () -> new OrderDate(35));
    }

    @DisplayName("0 혹은 음수의 숫자를 입력하지 않는다.")
    @Test
    void invalidNegativeDateTest() {
        assertThrows(IllegalArgumentException.class, () -> new OrderDate(0));
        assertThrows(IllegalArgumentException.class, () -> new OrderDate(-5));
    }

    @DisplayName("크리스마스 D-Day 여부 테스트")
    @Test
    void isChristmasDDayTest() {
        // 크리스마스 D-Day인 날짜를 입력
        OrderDate christmasDate = new OrderDate(15);
        assertTrue(christmasDate.isChristmasDDay());

        // 크리스마스 D-Day가 아닌 날짜를 입력
        OrderDate nonChristmasDate = new OrderDate(27);
        assertFalse(nonChristmasDate.isChristmasDDay());
    }

    @DisplayName("특별 할인 여부 테스트")
    @Test
    void isSpecialDiscountTest() {
        // 특별 할인 이벤트인 날짜를 입력
        OrderDate specialDiscountDate = new OrderDate(3);
        assertTrue(specialDiscountDate.isSpecialDiscount());

        // 특별 할인 이벤트가 아닌 날짜를 입력
        OrderDate nonSpecialDiscountDate = new OrderDate(15);
        assertFalse(nonSpecialDiscountDate.isSpecialDiscount());
    }

    @DisplayName("평일, 주말 할인 판별 테스트")
    @Test
    void isWeekDayOrWeekEnd() {
        // 평일(수요일 판별)
        OrderDate weekDayDate = new OrderDate(13);
        assertEquals("weekDay", weekDayDate.getDayOfWeek());

        // 주말(토요일 판별)
        OrderDate weekEndDate = new OrderDate(2);
        assertEquals("weekEnd", weekEndDate.getDayOfWeek());
    }
}