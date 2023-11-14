package christmas.domain.benefits;

import christmas.domain.menu.OrderList;
import christmas.domain.date.OrderDate;
import christmas.domain.price.TotalPrice;
import java.util.List;

public class TotalDiscount {
    private final List<Discount> discount;
    private final TotalPrice totalPrice;

    public TotalDiscount(List<Discount> discount, TotalPrice totalPrice) {
        this.discount = discount;
        this.totalPrice = totalPrice;
    }
    public int calculateTotalDiscount(OrderList orderList, OrderDate orderDate) {
        int totalBenefits = 0;
        if (totalPrice.calculateTotalPrice(orderList) >= 10_000) {
            for (Discount discountUnit : discount) {
                totalBenefits += discountUnit.calculateDiscount(orderList, orderDate);
            }
        }
        return totalBenefits;
    }
}
