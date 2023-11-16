package christmas.view.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.message.GuideProcedure;
import christmas.view.message.InputMessage;

public class DateInput {
    public static String inputDate() {
        GuideProcedure.requestDate();
        return Console.readLine();
    }
}
