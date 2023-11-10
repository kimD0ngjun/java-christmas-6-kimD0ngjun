package christmas.domain;

import christmas.message.ErrorMessage;

public class Date {
    // 상수로 날짜 범위 정의
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    private final int date;

    public Date(Integer date) {
        validateDate(date);
        this.date = date;
    }

    // 올바른 날짜 검증
    private void validateDate(int date) throws IllegalArgumentException {
        if (date < MIN_DATE || date > MAX_DATE) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_DATE.getMessage());
        }
    }
}
