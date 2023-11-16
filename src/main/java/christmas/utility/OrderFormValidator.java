package christmas.utility;

import christmas.view.message.ErrorMessage;
import java.util.List;

public class OrderFormValidator {
    private static final String DIVISION = "-";

    public static void validateForm(List<String> orderListForm) {
        for (String order : orderListForm) {
            if (!isValidOrderFormat(order)) {
                throw new IllegalArgumentException(ErrorMessage.WRONG_ORDER.getMessage());
            }
        }
    }

    private static boolean isValidOrderFormat(String order) {
        String[] parts = order.split(DIVISION);
        return parts.length == 2 && isValidString(parts[0]) && isValidNumber(parts[1]);
    }

    private static boolean isValidString(String str) {
        return str != null && !str.isBlank();
    }

    private static boolean isValidNumber(String str) {
        try {
            int quantity = Integer.parseInt(str);
            return quantity > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
