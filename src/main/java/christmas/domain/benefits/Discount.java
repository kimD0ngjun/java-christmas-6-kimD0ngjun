package christmas.domain.benefits;

import christmas.domain.menu.OrderList;
import christmas.domain.date.OrderDate;

public interface Discount {
    int calculateDiscount(OrderList orderList, OrderDate orderDate);
}
