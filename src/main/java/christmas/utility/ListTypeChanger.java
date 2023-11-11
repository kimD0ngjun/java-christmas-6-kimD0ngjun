package christmas.utility;

import christmas.message.ErrorMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTypeChanger {
    public static List<String> changeListType(String input) {
        String[] orderUnit = input.split(",");
        List<String> orderList = new ArrayList<>(Arrays.asList(orderUnit));
        validateOrderList(orderList);
        return orderList;
    }

    private static void validateOrderList(List<String> orderList) {
        for (String orderElement : orderList) {
            validateOrderElement(orderElement);
        }
    }

    private static void validateOrderElement(String orderElement) {
        if (!validateEmpty(orderElement) || !validateDash(orderElement)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_ORDER.getMessage());
        }
    }

    // 빈 문자열 검증
    private static boolean validateEmpty(String orderElement) {
        return !orderElement.isBlank();
    }

    // 요소 시작, 마지막 인덱스에 "-" 있는지 검증
    private static boolean validateDash(String orderElement) {
        return !orderElement.startsWith("-") && !orderElement.endsWith("-");
    }

}
