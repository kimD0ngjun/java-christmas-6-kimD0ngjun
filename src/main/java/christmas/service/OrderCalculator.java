package christmas.service;

import christmas.domain.OrderMenu;
import java.util.List;

public class OrderCalculator {
    public static int calculateTotalOrderAmount(List<OrderMenu> orderList) {
        int totalAmount = 0;
        for (OrderMenu orderMenu : orderList) {
            totalAmount += orderMenu.getTotalPrice();
        }
        return totalAmount;
    }
}

