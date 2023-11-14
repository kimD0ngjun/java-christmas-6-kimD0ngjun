package christmas.utility;

import christmas.view.message.ErrorMessage;

public class NumberTypeChanger {
    private static final String MATCH_NUMBER = "\\d+";

    public static int changeNumberType(String input) {
        validateNumber(input);
        parseIntOrThrow(input);
        return Integer.parseInt(input);
    }

    private static void validateNumber(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_DATE.getMessage());
        }
    }

    private static void parseIntOrThrow(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_DATE.getMessage());
        }
    }

    private static boolean isNumeric(String input) {
        return input.matches(MATCH_NUMBER);
    }
}

