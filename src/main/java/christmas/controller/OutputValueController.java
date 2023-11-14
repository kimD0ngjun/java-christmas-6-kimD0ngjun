package christmas.controller;

import christmas.domain.badge.GiveBadgeProvider;
import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.domain.price.TotalPrice;
import christmas.service.ExpectedPriceCalculator;
import christmas.service.TotalBenefitsCalculator;
import christmas.view.output.OutputValue;

public class OutputValueController {
    private final OrderList orderList;
    private final OrderDate orderDate;
    private final TotalPrice totalPrice;
    private final TotalBenefitsCalculator totalBenefits;
    private final ExpectedPriceCalculator expectedPriceCalculator;
    private final GiveBadgeProvider badge;

    public OutputValueController(
            OrderList orderList,
            OrderDate orderDate,
            TotalPrice totalPrice,
            TotalBenefitsCalculator totalBenefits,
            ExpectedPriceCalculator expectedPriceCalculator,
            GiveBadgeProvider badge) {
        this.orderList = orderList;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.totalBenefits = totalBenefits;
        this.expectedPriceCalculator = expectedPriceCalculator;
        this.badge = badge;
    }

    public void displayOutput() {
        OutputValue.guideTotalPrice(orderList);
        OutputValue.guidePresent(orderList);
        OutputValue.guideBenefits(totalPrice, orderList, orderDate);
        OutputValue.guideTotalBenefits(totalPrice, orderList, orderDate, totalBenefits);
        OutputValue.guideExpectedPrice(expectedPriceCalculator, orderList, orderDate);
        OutputValue.guideBadge(totalBenefits, orderList, orderDate, badge);
    }
}
