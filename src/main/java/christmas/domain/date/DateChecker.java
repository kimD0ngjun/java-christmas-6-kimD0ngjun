package christmas.domain.date;

import java.util.Calendar;
import java.util.Set;

public class DateChecker {

    public static boolean isChristmasDDay(int date) {
        return date <= Date.DDAY_MAX_DATE.getDate();
    }

    public static boolean isSpecialDiscount(int date, Set<Integer> specialDiscountDates) {
        return specialDiscountDates.contains(date);
    }

    public static String getDayOfWeek(int dayOfWeek) {
        if (dayOfWeek == Calendar.FRIDAY || dayOfWeek == Calendar.SATURDAY) {
            return "weekEnd";
        }
        return "weekDay";
    }
}

