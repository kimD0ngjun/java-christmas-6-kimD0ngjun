package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.message.InputMessage;

public class InputValue {
    // 날짜 입력
    public static String inputDate() {
        System.out.println(InputMessage.DATE.getMessage());
        return Console.readLine();
    }

    // 주문 메뉴 입력
    public static String inputOrder() {
        System.out.println(InputMessage.ORDER.getMessage());
        return Console.readLine();
    }
}
