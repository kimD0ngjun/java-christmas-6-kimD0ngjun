package christmas.view.output.orderListArgument;

import christmas.domain.menu.OrderList;
import christmas.domain.price.SimpleTotalPrice;
import christmas.domain.price.TotalPrice;
import christmas.view.message.OutputMessage;

public class GuidePresent {
    private final int STANDARD_TOTAL_PRICE = 120_000;
    private final String CHAMPAGNE = "샴페인 1개";
    private final String NONE = "없음";

    private final OrderList orderList;

    public GuidePresent(OrderList orderList) {
        this.orderList = orderList;
    }

    public void displayPresent() {
        TotalPrice totalAmount = new SimpleTotalPrice();
        int totalPrice = totalAmount.calculateTotalPrice(orderList);
        if (totalPrice >= STANDARD_TOTAL_PRICE) {
            System.out.printf("%s%n", OutputMessage.PRESENT.getMessage(CHAMPAGNE));
        }
        if (totalPrice < STANDARD_TOTAL_PRICE) {
            System.out.printf("%s%n", OutputMessage.PRESENT.getMessage(NONE));
        }
    }
}
