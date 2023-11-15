package christmas.view.message;

import christmas.domain.date.OrderDate;
import christmas.view.output.combinedArgument.GuideEvent;

public class GuideMessage {
    public static void welcome() {
        System.out.println(OutputMessage.WELCOME.getMessage());
    }

    public static void requestDate() {
        System.out.println(InputMessage.DATE.getMessage());
    }

    public static void requestOrder() {
        System.out.println(InputMessage.ORDER.getMessage());
    }
}
