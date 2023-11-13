package christmas.service;

import christmas.domain.OrderList;
import christmas.domain.benefits.TotalDiscount;
import christmas.domain.date.OrderDate;
import christmas.domain.price.TotalPrice;

public class ExpectedPriceCalculator {
    private final TotalPrice totalPrice;
    private final TotalDiscount totalDiscount;

    public ExpectedPriceCalculator(TotalPrice totalPrice, TotalDiscount totalDiscount) {
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
    }

    public int calculateExpectedPrice(OrderList orderList, OrderDate orderDate) {
        int totalAmount = totalPrice.calculateTotalPrice(orderList);
        int totalDiscountAmount = totalDiscount.calculateTotalDiscount(orderList, orderDate);

        return totalAmount - totalDiscountAmount;
    }
}
