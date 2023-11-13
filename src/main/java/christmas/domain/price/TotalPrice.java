package christmas.domain.price;

import christmas.domain.OrderList;
import christmas.domain.OrderMenu;

public class TotalPrice {
    private final OrderList orderList;

    public TotalPrice(OrderList orderList) {
        this.orderList = orderList;
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (OrderMenu orderMenu : orderList.getOrderList()) {
            totalPrice += orderMenu.getTotalPrice();
        }
        return totalPrice;
    }
}
