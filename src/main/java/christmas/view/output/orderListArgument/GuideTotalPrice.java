package christmas.view.output.orderListArgument;

import christmas.domain.menu.OrderList;
import christmas.domain.price.SimpleTotalPrice;
import christmas.domain.price.TotalPrice;
import christmas.utility.NumberFormatter;
import christmas.view.message.OutputMessage;

public class GuideTotalPrice {
    private final OrderList orderList;

    public GuideTotalPrice(OrderList orderList) {
        this.orderList = orderList;
    }

    public void displayTotalPrice() {
        TotalPrice totalAmount = new SimpleTotalPrice();
        int totalPrice = totalAmount.calculateTotalPrice(orderList);
        String totalPriceString = NumberFormatter.formatNumber(totalPrice);
        System.out.printf("%s%n", OutputMessage.TOTAL_PRICE.getMessage(totalPriceString));
    }
}
