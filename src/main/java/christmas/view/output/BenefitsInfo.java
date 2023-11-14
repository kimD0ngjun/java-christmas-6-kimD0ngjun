package christmas.view.output;

import christmas.domain.benefits.SpecialDiscount;
import christmas.domain.benefits.WeekDiscount;
import christmas.domain.benefits.XMasDiscount;
import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.domain.price.TotalPrice;
import christmas.service.TotalBenefitsCalculator;
import christmas.utility.NumberFormatter;

public class BenefitsInfo {
    private TotalPrice totalPrice;
    private OrderList orderList;
    private OrderDate orderDate;

    public BenefitsInfo(TotalPrice totalPrice, OrderList orderList, OrderDate orderDate) {
        this.totalPrice = totalPrice;
        this.orderList = orderList;
        this.orderDate = orderDate;
    }

    public String calculateSpecialDiscount(SpecialDiscount specialDiscount) {
        int specialDiscountAmount = specialDiscount.calculateDiscount(orderList, orderDate);
        return NumberFormatter.formatNumber(specialDiscountAmount);
    }

    public String calculateXMasDiscount(XMasDiscount xMasDiscount) {
        int xMasDiscountAmount = xMasDiscount.calculateDiscount(orderList, orderDate);
        return NumberFormatter.formatNumber(xMasDiscountAmount);
    }

    public String calculateWeekDiscount(WeekDiscount weekDiscount) {
        int weekDiscountAmount = weekDiscount.calculateDiscount(orderList, orderDate);
        return NumberFormatter.formatNumber(weekDiscountAmount);
    }

    public String calculateTotalBenefits(TotalBenefitsCalculator totalBenefitsCalculator) {
        int totalBenefitsAmount = totalBenefitsCalculator.calculateTotalBenefits(orderList, orderDate);
        return NumberFormatter.formatNumber(totalBenefitsAmount);
    }
}
