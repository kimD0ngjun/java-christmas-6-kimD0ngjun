package christmas.domain.benefits;

import christmas.domain.menu.OrderList;
import christmas.domain.date.OrderDate;

public class WeekDiscount implements Discount{
    private final int WEEK_DISCOUNT = 2_023;

    @Override
    public int calculateDiscount(OrderList orderList, OrderDate orderDate) {
        if (orderDate.getDayOfWeek().equals("weekDay")) {
            return orderList.countDessertMenus() * WEEK_DISCOUNT;
        }
        if (orderDate.getDayOfWeek().equals("weekEnd")) {
            return orderList.countMainMenus() * WEEK_DISCOUNT;
        }
        return 0;
    }
}
