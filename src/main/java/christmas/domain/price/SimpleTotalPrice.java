package christmas.domain.price;

import christmas.domain.OrderList;
import christmas.domain.OrderMenu;

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