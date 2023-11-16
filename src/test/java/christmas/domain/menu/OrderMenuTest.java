package christmas.domain.menu;

import christmas.domain.menu.OrderMenu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderMenuTest {

    @DisplayName("유효한 메뉴 주문 시 예외가 발생하지 않는다.")
    @Test
    void validOrderMenu() {
        assertDoesNotThrow(() -> new OrderMenu("양송이수프", 1));
        assertDoesNotThrow(() -> new OrderMenu("티본스테이크", 2));
    }

    @DisplayName("유효하지 않은 메뉴 주문 시 예외가 발생해야 한다.")
    @Test
    void invalidOrderMenu() {
        assertThrows(IllegalArgumentException.class, () -> new OrderMenu("방어회", 1));
        assertThrows(IllegalArgumentException.class, () -> new OrderMenu("123", 2));
        assertThrows(IllegalArgumentException.class, () -> new OrderMenu("-,.", 1));
        assertThrows(IllegalArgumentException.class, () -> new OrderMenu("", 1));
    }
}

