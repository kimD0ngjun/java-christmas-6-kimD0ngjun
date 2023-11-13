package christmas.service;

import christmas.domain.OrderList;
import christmas.domain.benefits.Present;
import christmas.domain.benefits.TotalDiscount;
import christmas.domain.date.OrderDate;

public class TotalBenefitsCalculator {
    private final Present present;
    private final TotalDiscount totalDiscount;

    public TotalBenefitsCalculator(Present present, TotalDiscount totalDiscount) {
        this.present = present;
        this.totalDiscount = totalDiscount;
    }

    public int calculateTotalBenefits(OrderList orderList, OrderDate orderDate) {
        int presentAmount = present.calculatePresent(orderList);
        int discountAmount = totalDiscount.calculateTotalDiscount(orderList, orderDate);

        return presentAmount + discountAmount;
    }
}
