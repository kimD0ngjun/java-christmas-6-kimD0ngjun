package christmas.view.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.message.InputMessage;

public class OrderInput {
    // 주문 메뉴 입력
    public static String inputOrder() {
        System.out.println(InputMessage.ORDER.getMessage());
        return Console.readLine();
    }
}
