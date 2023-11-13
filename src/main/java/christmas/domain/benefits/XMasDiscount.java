package christmas.domain.benefits;

import christmas.domain.OrderList;
import christmas.domain.date.OrderDate;

public class XMasDiscount implements Discount {
    private final int X_MAS_DISCOUNT = 100;
    private final int BASE_DISCOUNT = 1_000;

    @Override
    public int calculateDiscount(OrderList orderList, OrderDate orderDate) {
        if (orderDate.isChristmasDDay()) {
            return X_MAS_DISCOUNT * (orderDate.getDate() - 1) + BASE_DISCOUNT;
        }
        return 0;
    }
}
