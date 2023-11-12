package christmas.service;

import christmas.domain.OrderMenu;
import java.util.List;

public class OrderCalculator {
    public static int calculateTotalPrice(List<OrderMenu> orderList) {
        int totalPrice = 0;
        for (OrderMenu orderMenu : orderList) {
            totalPrice += orderMenu.getTotalPrice();
        }
        return totalPrice;
    }
}

