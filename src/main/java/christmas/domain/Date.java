package christmas.domain;

import christmas.message.ErrorMessage;

public class Date {
    // 상수로 날짜 범위 정의
    private final int MIN_DATE = 1;
    private final int MAX_DATE = 31;
    // 크리스마스 디데이 이벤트
    private final int[] CHRISTMAS_DATES = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30};
    // 특별 할인 이벤트
    private final int[] SPECIAL_DISCOUNT = {3, 10, 17, 24, 25, 31};

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

    // TODO: 크리스마스 디데이 해당 여부
    private boolean isChristmasDDay() {
        for (int christmasDate : CHRISTMAS_DATES) {
            if (date == christmasDate) {
                return true;
            }
        }
        return false;
    }

    // TODO: 특별 할인 해당 여부
    private boolean isSpecialDiscount() {
        for (int specialDiscountDate : SPECIAL_DISCOUNT) {
            if (date == specialDiscountDate ) {
                return true;
            }
        }
        return false;
    }
}
