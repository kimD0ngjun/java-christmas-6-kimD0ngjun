package christmas.domain.benefits;

import christmas.domain.OrderList;
import christmas.domain.date.OrderDate;

public interface Discount {
    int calculateDiscount(OrderList orderList, OrderDate orderDate);
}