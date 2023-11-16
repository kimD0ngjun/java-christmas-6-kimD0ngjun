package christmas.domain.price;

import christmas.domain.menu.OrderList;

public interface TotalPrice {
    int calculateTotalPrice(OrderList orderList);
}
