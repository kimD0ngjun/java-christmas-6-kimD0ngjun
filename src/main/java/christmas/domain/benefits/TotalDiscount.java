package christmas.domain.benefits;

import christmas.domain.OrderList;
import christmas.domain.date.OrderDate;
import java.util.List;

public class TotalDiscount {
    private final List<Discount> discount;

    public TotalDiscount(List<Discount> discount) {
        this.discount = discount;
    }
    public int calculateTotalDiscount(OrderList orderList, OrderDate orderDate) {
        int totalBenefits = 0;
        for (Discount discountUnit : discount) {
            totalBenefits += discountUnit.calculateDiscount(orderList, orderDate);
        }
        return totalBenefits;
    }
}
