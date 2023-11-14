package christmas.domain.date;

import christmas.view.message.ErrorMessage;
import java.util.Calendar;
import java.util.Set;

public class OrderDate {

    private final int date;

    public OrderDate(Integer date) {
        validateDate(date);
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    private void validateDate(int date) throws IllegalArgumentException {
        if (date > Date.MAX_DATE.getDate() || date < Date.MIN_DATE.getDate()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_DATE.getMessage());
        }
    }

    public boolean isChristmasDDay() {
        return DateChecker.isChristmasDDay(date);
    }

    public boolean isSpecialDiscount() {
        Set<Integer> specialDiscountDates = Date.getSpecialDiscountDates();
        return DateChecker.isSpecialDiscount(date, specialDiscountDates);
    }

    public String getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Date.YEAR.getDate(), Calendar.DECEMBER, date);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        return DateChecker.getDayOfWeek(dayOfWeek);
    }
}
