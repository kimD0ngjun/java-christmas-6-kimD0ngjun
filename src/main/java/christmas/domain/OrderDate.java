package christmas.domain;

import christmas.message.ErrorMessage;
import java.util.Calendar;

public class OrderDate {
    // 상수로 날짜 범위 정의
    private final int MIN_DATE = 1;
    private final int MAX_DATE = 31;
    // 크리스마스 디데이 이벤트
    private final int DDAY_MAX_DATE = 25;
    // 특별 할인 이벤트
    private final int[] SPECIAL_DISCOUNT = {3, 10, 17, 24, 25, 31};
    // 평일, 주말 할인 판별을 위한 연도
    private final int YEAR = 2023;

    private final int date;

    public OrderDate(Integer date) {
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
    public boolean isChristmasDDay() {
        if (date <= DDAY_MAX_DATE) {
            return true;
        }
        return false;
    }

    // TODO: 특별 할인 해당 여부
    public boolean isSpecialDiscount() {
        for (int specialDiscountDate : SPECIAL_DISCOUNT) {
            if (date == specialDiscountDate) {
                return true;
            }
        }
        return false;
    }

    // TODO: 아직 평일 할인(일~목), 주말 할인(금, 토) 여부
    public String getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR, Calendar.DECEMBER, date);  // 예시 연도와 월을 적절히 변경

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        if (dayOfWeek == Calendar.FRIDAY || dayOfWeek == Calendar.SATURDAY) {
            return "weekEnd";
        } else {
            return "weekDay";
        }
    }
}
