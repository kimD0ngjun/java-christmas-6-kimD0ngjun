package christmas.domain.benefits;

import christmas.domain.menu.OrderList;
import christmas.domain.price.TotalPrice;

public class SimplePresent implements Present {
    private final int STANDARD_PRICE = 120_000;
    private final int STANDARD_PRESENT = 25_000;

    private final TotalPrice totalPrice;

    public SimplePresent(TotalPrice totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public int calculatePresent(OrderList orderList) {
        if (totalPrice.calculateTotalPrice(orderList) >= STANDARD_PRICE) {
            return STANDARD_PRESENT;
        }
        return 0;
    }
}