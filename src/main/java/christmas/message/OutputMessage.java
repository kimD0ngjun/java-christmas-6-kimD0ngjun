package christmas.message;

public enum OutputMessage {
    WELCOME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    EVENT_GUIDE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    ORDER_MENU_TITLE("<주문 메뉴>"),
    ORDER_MENU_INFO("%s %d개"),
    TOTAL_PRICE("\n<할인 전 총주문 금액>\n%s원"),
    PRESENT("\n<증정 메뉴>\n%s"),
    BENEFITS_GUIDE("\n<혜택 내역>\n"),
    X_MAS_DISCOUNT("크리스마스 디데이 할인: -%s원"),
    WEEKDAY_DISCOUNT("평일 할인 : -%s원"),
    WEEKEND_DISCOUNT("주말 할인 : -%s원"),
    SPECIAL_DISCOUNT("특별 할인 : -%s원"),
    PRESENT_EVENT("증정 이벤트: -25,000원")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int number) {
        return String.format(message, number);
    }

    public String getMessage(String number) {
        return String.format(message, number);
    }

    public String getMessage(String menuName, int menuQuantity) {
        return String.format(message, menuName, menuQuantity);
    }
}
