package christmas.domain.benefits;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.OrderList;
import christmas.domain.date.OrderDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TotalDiscountTest {

    @DisplayName("할인 금액은 총주문 금액에서 지불 예정 금액의 차액이다.")
    @Test
    public void testXMasDiscount() {
        List<String> orderListForm = Arrays.asList("티본스테이크-2", "해산물파스타-3", "아이스크림-1");

        OrderList orderList = new OrderList(orderListForm);
        OrderDate orderDate = new OrderDate(25);

        List<Discount> discount = Arrays.asList(
                new WeekDiscount(),
                new SpecialDiscount(),
                new XMasDiscount()
        );

        TotalDiscount totalDiscount = new TotalDiscount(discount);

        int result = totalDiscount.calculateTotalDiscount(orderList, orderDate);

        assertEquals(6_423, result);
    }
}
