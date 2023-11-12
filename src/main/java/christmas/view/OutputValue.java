package christmas.view;

import christmas.domain.OrderDate;
import christmas.message.OutputMessage;

public class OutputValue {
    public static void guideEvent(OrderDate orderDate) {
        int date = orderDate.getDate();
        System.out.printf("%s%n", OutputMessage.EVENT_GUIDE.getMessage(date));
    }
}
