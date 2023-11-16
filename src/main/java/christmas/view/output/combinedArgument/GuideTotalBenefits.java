package christmas.view.output.combinedArgument;

import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.domain.price.TotalPrice;
import christmas.service.TotalBenefitsCalculator;
import christmas.utility.NumberFormatter;
import christmas.view.message.OutputMessage;

public class GuideTotalBenefits {
    private TotalPrice totalPrice;
    private OrderList orderList;
    private OrderDate orderDate;
    private TotalBenefitsCalculator totalBenefit;

    private final int LIMIT_PRICE = 10_000;
    private final int NO_DISCOUNT = 0;

    public GuideTotalBenefits(TotalPrice totalPrice, OrderList orderList, OrderDate orderDate,
                              TotalBenefitsCalculator totalBenefit) {
        this.totalPrice = totalPrice;
        this.orderList = orderList;
        this.orderDate = orderDate;
        this.totalBenefit = totalBenefit;
    }

    public void displayTotalBenefits() {
        int totalAmount = totalPrice.calculateTotalPrice(orderList);
        int totalBenefitsAmount = totalBenefit.calculateTotalBenefits(orderList, orderDate);

        String zero = NumberFormatter.formatNumber(NO_DISCOUNT);
        String totalBenefitsString = NumberFormatter.formatNumber(-totalBenefitsAmount);

        if (totalAmount < LIMIT_PRICE) {
            System.out.printf("%s%n", OutputMessage.TOTAL_BENEFITS.getMessage(zero));
        }
        if (totalAmount >= LIMIT_PRICE) {
            System.out.printf("%s%n", OutputMessage.TOTAL_BENEFITS.getMessage(totalBenefitsString));
        }
    }
}
