package christmas.domain.benefits;

import christmas.domain.menu.OrderList;
import christmas.domain.date.OrderDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialDiscountTest {

    @DisplayName("3일, 10일, 17일, 24일, 25일, 31일은 특별할인이 적용된다.")
    @Test
    public void testSpecialDiscount() {
        List<String> orderListForm = Arrays.asList("티본스테이크-2", "해산물파스타-3", "레드와인-1");

        OrderList orderList = new OrderList(orderListForm);
        OrderDate orderDate = new OrderDate(25);
        SpecialDiscount specialDiscount = new SpecialDiscount();

        int result = specialDiscount.calculateDiscount(orderList, orderDate);

        assertEquals(1_000, result);
    }

    @DisplayName("그 외의 날짜에는 특별할인이 적용되지 않는다.")
    @Test
    public void testNoSpecialDiscount() {
        List<String> orderListForm = Arrays.asList("티본스테이크-2", "해산물파스타-3", "레드와인-1");

        OrderList orderList = new OrderList(orderListForm);
        OrderDate orderDate = new OrderDate(26);
        SpecialDiscount specialDiscount = new SpecialDiscount();

        int result = specialDiscount.calculateDiscount(orderList, orderDate);

        assertEquals(0, result);
    }
}