package christmas.domain.benefits;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.OrderList;
import christmas.domain.price.SimpleTotalPrice;
import christmas.domain.price.TotalPrice;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PresentTest {

    @DisplayName("총주문 금액이 120_000원 이상이면 증정 이벤트가 적용된다.")
    @Test
    public void testPresent() {
        List<String> orderListForm = Arrays.asList("티본스테이크-2", "해산물파스타-3", "레드와인-1");

        OrderList orderList = new OrderList(orderListForm);

        TotalPrice totalPrice = new SimpleTotalPrice();

        Present present = new SimplePresent(totalPrice);
        int presentWhether = present.calculatePresent(orderList);

        assertEquals(25_000, presentWhether);
    }

    @DisplayName("총주문 금액이 120_000원 미만이면 증정 이벤트가 적용된다.")
    @Test
    public void testNoPresent() {
        List<String> orderListForm = Arrays.asList("아이스크림-4");

        OrderList orderList = new OrderList(orderListForm);

        TotalPrice totalPrice = new SimpleTotalPrice();

        Present present = new SimplePresent(totalPrice);
        int presentWhether = present.calculatePresent(orderList);

        assertEquals(0, presentWhether);
    }
}
