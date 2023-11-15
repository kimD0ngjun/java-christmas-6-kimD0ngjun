package christmas.utility;

import christmas.view.message.ErrorMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTypeChanger {
    private final static String COMMA = ",";

    public static List<String> changeListType(String input) {
        verifyComma(input);
        String[] orderUnit = input.split(",");
        List<String> orderList = new ArrayList<>(Arrays.asList(orderUnit));
        validateOrderList(orderList);
        return orderList;
    }

    private static void verifyComma(String input) {
        if (input.endsWith(COMMA)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_ORDER.getMessage());
        }
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

    private static boolean validateEmpty(String orderElement) {
        return !orderElement.isBlank();
    }

    private static boolean validateDash(String orderElement) {
        return !orderElement.startsWith("-") && !orderElement.endsWith("-");
    }
}
