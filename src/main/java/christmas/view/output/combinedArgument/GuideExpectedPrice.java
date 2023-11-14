package christmas.view.output.combinedArgument;

import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.service.ExpectedPriceCalculator;
import christmas.utility.NumberFormatter;
import christmas.view.message.OutputMessage;

public class GuideExpectedPrice {
    private ExpectedPriceCalculator calculator;
    private OrderList orderList;
    private OrderDate orderDate;

    public GuideExpectedPrice(
            ExpectedPriceCalculator calculator,
            OrderList orderList,
            OrderDate orderDate) {
        this.calculator = calculator;
        this.orderList = orderList;
        this.orderDate = orderDate;
    }

    public void displayExpectedPrice() {
        int expectedPrice = calculator.calculateExpectedPrice(orderList, orderDate);
        String expectedPriceString = NumberFormatter.formatNumber(expectedPrice);
        System.out.printf("%s%n", OutputMessage.EXPECTED_PRICE.getMessage(expectedPriceString));
    }
}
