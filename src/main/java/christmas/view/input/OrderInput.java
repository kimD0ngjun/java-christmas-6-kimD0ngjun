package christmas.view.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.message.GuideProcedure;
import christmas.view.message.InputMessage;

public class OrderInput {
    public static String inputOrder() {
        GuideProcedure.requestOrder();
        return Console.readLine();
    }
}
