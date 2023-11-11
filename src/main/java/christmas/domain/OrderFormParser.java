package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderFormParser {
    public static List<OrderMenu> parseOrderForm(List<String> orderListForm) {
        List<OrderMenu> orderList= new ArrayList<>();;

        for (String order : orderListForm) {
            String[] parts = order.split("-");

            String orderMenu = parts[0];
            int orderQuantity = Integer.parseInt(parts[1]);

            OrderMenu menu = new OrderMenu(orderMenu, orderQuantity);

            orderList.add(menu);
        }
        return orderList;
    }
}
