package christmas.service;

import christmas.domain.menu.OrderMenu;
import java.util.ArrayList;
import java.util.List;

public class OrderFormParser {
    private static final String DIVISION = "-";

    public static List<OrderMenu> parseOrderForm(List<String> orderListForm) {
        List<OrderMenu> orderList= new ArrayList<>();;

        for (String order : orderListForm) {
            String[] parts = order.split(DIVISION);

            String orderMenu = parts[0];
            int orderQuantity = Integer.parseInt(parts[1]);

            OrderMenu menu = new OrderMenu(orderMenu, orderQuantity);

            orderList.add(menu);
        }
        return orderList;
    }
}
