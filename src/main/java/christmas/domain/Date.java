package christmas.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Date {
    MIN_DATE(1),
    MAX_DATE(31),
    DDAY_MAX_DATE(25),
    YEAR(2023),
    SPECIAL_DISCOUNT_1(3),
    SPECIAL_DISCOUNT_2(10),
    SPECIAL_DISCOUNT_3(17),
    SPECIAL_DISCOUNT_4(24),
    SPECIAL_DISCOUNT_5(25),
    SPECIAL_DISCOUNT_6(31);

    private final int date;

    Date(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    public static Set<Integer> getSpecialDiscountDates() {
        // 특별 할인 날짜만 추출하여 Set으로 반환
        Set<Integer> specialDiscountDates = new HashSet<>();
        specialDiscountDates.addAll(Arrays.asList(
                SPECIAL_DISCOUNT_1.getDate(),
                SPECIAL_DISCOUNT_2.getDate(),
                SPECIAL_DISCOUNT_3.getDate(),
                SPECIAL_DISCOUNT_4.getDate(),
                SPECIAL_DISCOUNT_5.getDate(),
                SPECIAL_DISCOUNT_6.getDate()
        ));
        return specialDiscountDates;
    }
}
