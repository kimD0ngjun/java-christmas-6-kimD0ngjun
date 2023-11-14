package christmas.domain.benefits;

import christmas.domain.menu.OrderList;

public interface Present {
    int calculatePresent(OrderList orderList);
}
