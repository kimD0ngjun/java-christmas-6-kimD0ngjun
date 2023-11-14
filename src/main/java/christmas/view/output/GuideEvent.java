package christmas.view.output;

import christmas.domain.date.OrderDate;
import christmas.view.message.OutputMessage;

public class GuideEvent {
    private final OrderDate orderDate;

    public GuideEvent(OrderDate orderDate) {
        this.orderDate = orderDate;
    }

    public void displayEventGuide() {
        int date = orderDate.getDate();
        System.out.printf("%s%n", OutputMessage.EVENT_GUIDE.getMessage(date));
    }
}
