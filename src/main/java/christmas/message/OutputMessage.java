package christmas.message;

public enum OutputMessage {
    WELCOME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    EVENT_GUIDE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int date) {
        return String.format(message, date);
    }
}
