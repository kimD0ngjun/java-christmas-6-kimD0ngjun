package christmas.domain.price;

import christmas.domain.OrderList;

public interface TotalPrice {
    int calculateTotalPrice(OrderList orderList);
}
