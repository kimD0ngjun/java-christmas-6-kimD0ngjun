package christmas.domain.benefits;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.OrderList;
import christmas.domain.date.OrderDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class XMasDiscountTest {

    @DisplayName("12월 1일부터 12월 25일까지 크리스마스 할인이 적용된다.")
    @Test
    public void testXMasDiscount() {
        List<String> orderListForm = Arrays.asList("티본스테이크-2", "해산물파스타-3", "레드와인-1");

        OrderList orderList = new OrderList(orderListForm);
        OrderDate day25 = new OrderDate(25);
        OrderDate day17 = new OrderDate(17);
        XMasDiscount xMasDiscount = new XMasDiscount();

        int result1 = xMasDiscount.calculateDiscount(orderList, day25);
        int result2 = xMasDiscount.calculateDiscount(orderList, day17);

        assertEquals(3_400, result1);
        assertEquals(2_600, result2);
    }

    @DisplayName("12월 26일부터는 크리스마스 할인이 적용되지 않는다.")
    @Test
    public void testNoXMasDiscount() {
        List<String> orderListForm = Arrays.asList("티본스테이크-2", "해산물파스타-3", "레드와인-1");

        OrderList orderList = new OrderList(orderListForm);
        OrderDate day26 = new OrderDate(26);
        XMasDiscount xMasDiscount = new XMasDiscount();

        int result = xMasDiscount.calculateDiscount(orderList, day26);

        assertEquals(0, result);
    }
}
