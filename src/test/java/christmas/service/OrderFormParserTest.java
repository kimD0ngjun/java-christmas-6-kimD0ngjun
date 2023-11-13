package christmas.service;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.OrderMenu;
import christmas.service.OrderFormParser;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderFormParserTest {

    @DisplayName("List<String>화 시킨 주문서 입력을 List<OrderMenu>화 한다.")
    @Test
    public void testParseOrderForm() {
        List<String> orderListForm = List.of("해산물파스타-2", "타파스-3");

        List<OrderMenu> orderList = OrderFormParser.parseOrderForm(orderListForm);

        OrderMenu firstOrder = orderList.get(0);
        assertEquals("해산물파스타", firstOrder.getMenu().getName());
        assertEquals(2, firstOrder.getQuantity());

        OrderMenu secondOrder = orderList.get(1);
        assertEquals("타파스", secondOrder.getMenu().getName());
        assertEquals(3, secondOrder.getQuantity());
    }
}

