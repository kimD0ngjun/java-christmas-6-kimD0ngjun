package christmas.domain.benefits;

import christmas.domain.menu.OrderList;
import christmas.domain.date.OrderDate;

public class SpecialDiscount implements Discount {
    private final int SPECIAL_DISCOUNT = 1_000;

    @Override
    public int calculateDiscount(OrderList orderList, OrderDate orderDate) {
        if (orderDate.isSpecialDiscount()) {
            return SPECIAL_DISCOUNT;
        }
        return 0;
    }
}
