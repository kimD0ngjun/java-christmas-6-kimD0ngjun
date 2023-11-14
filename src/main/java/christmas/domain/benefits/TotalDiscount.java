package christmas.domain.benefits;

import christmas.domain.menu.OrderList;
import christmas.domain.date.OrderDate;
import christmas.domain.price.TotalPrice;
import java.util.List;

public class TotalDiscount {
    private final int STNADARD_PRICE = 10_000;

    private final List<Discount> discount;
    private final TotalPrice totalPrice;

    public TotalDiscount(List<Discount> discount, TotalPrice totalPrice) {
        this.discount = discount;
        this.totalPrice = totalPrice;
    }
    public int calculateTotalDiscount(OrderList orderList, OrderDate orderDate) {
        int totalBenefits = 0;
        if (totalPrice.calculateTotalPrice(orderList) >= STNADARD_PRICE) {
            for (Discount discountUnit : discount) {
                totalBenefits += discountUnit.calculateDiscount(orderList, orderDate);
            }
        }
        return totalBenefits;
    }
}
