package christmas.view.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.message.InputMessage;

public class DateInput {
    // 날짜 입력
    public static String inputDate() {
        System.out.println(InputMessage.DATE.getMessage());
        return Console.readLine();
    }
}
