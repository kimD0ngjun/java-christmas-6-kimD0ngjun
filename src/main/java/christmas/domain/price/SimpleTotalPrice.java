package christmas.domain.price;

import christmas.domain.menu.OrderList;
import christmas.domain.menu.OrderMenu;

public class SimpleTotalPrice implements TotalPrice {
    @Override
    public int calculateTotalPrice(OrderList orderList) {
        int totalPrice = 0;
        for (OrderMenu orderMenu : orderList.getOrderList()) {
            totalPrice += orderMenu.getTotalPrice();
        }
        return totalPrice;
    }
}