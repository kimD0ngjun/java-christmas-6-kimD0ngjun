package christmas.view.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.message.InputMessage;

public class OrderInput {
    public static String inputOrder() {
        System.out.println(InputMessage.ORDER.getMessage());
        return Console.readLine();
    }
}
