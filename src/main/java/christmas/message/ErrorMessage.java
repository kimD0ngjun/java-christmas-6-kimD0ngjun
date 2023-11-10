package christmas.message;

public enum ErrorMessage {
    WRONG_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    WRONG_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ONLY_BEVERAGE("[ERROR] 음료만 주문할 수 없습니다. 다른 메뉴를 추가해 주세요."),
    LIMIT_QUANTITY("[ERROR] 메뉴는 20개까지 주문할 수 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
