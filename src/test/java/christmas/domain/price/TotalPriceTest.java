package christmas.domain.price;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.menu.OrderList;
import christmas.domain.price.SimpleTotalPrice;
import christmas.domain.price.TotalPrice;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TotalPriceTest {
    @DisplayName("총주문 금액을 계산한다.")
    @Test
    public void testTotalPrice() {
        List<String> orderListForm1 = Arrays.asList("티본스테이크-2", "해산물파스타-3", "레드와인-1");
        List<String> orderListForm2 = Arrays.asList("시저샐러드-2", "크리스마스파스타-3", "아이스크림-2");

        OrderList orderList1 = new OrderList(orderListForm1);
        OrderList orderList2 = new OrderList(orderListForm2);

        TotalPrice totalPrice1 = new SimpleTotalPrice();
        TotalPrice totalPrice2 = new SimpleTotalPrice();

        int totalPriceCase1 = totalPrice1.calculateTotalPrice(orderList1);
        int totalPriceCase2 = totalPrice1.calculateTotalPrice(orderList2);

        assertEquals(275_000, totalPriceCase1);
        assertEquals(101_000, totalPriceCase2);
    }
}
