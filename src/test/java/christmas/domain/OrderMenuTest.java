package christmas.domain;

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

    @DisplayName("주문 메뉴 별로 가격 데이터가 있다.")
    @Test
    void checkOrderMenuPrice() {
        OrderMenu orderSoup = new OrderMenu("양송이수프", 1);
        assertEquals(6_000, orderSoup.getPrice());

        OrderMenu orderSteak = new OrderMenu("티본스테이크", 2);
        assertEquals(55_000, orderSteak.getPrice());
    }

    @DisplayName("주문 메뉴 별로 카테고리 데이터가 있다.")
    @Test
    void checkOrderMenuCategory() {
        OrderMenu orderSoup = new OrderMenu("양송이수프", 2);
        assertEquals(Menu.Category.APPETIZER, orderSoup.getCategory());

        OrderMenu orderSteak = new OrderMenu("티본스테이크", 1);
        assertEquals(Menu.Category.MAIN, orderSteak.getCategory());
    }
}

