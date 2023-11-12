package christmas.service;

import christmas.domain.Menu;
import christmas.domain.OrderDate;
import christmas.domain.OrderMenu;
import java.util.List;
import java.util.Objects;

public class OrderCalculator {
    private final int WEEK_DISCOUNT = -2_023;
    private final int SPECIAL_DISCOUNT = -1_000;

    private int price;

    public OrderCalculator(List<OrderMenu> orderList, int orderDate) {
//        this.price = price;
    }

    //TODO: 총주문 금액
    public int calculateTotalPrice(List<OrderMenu> orderList) {
        int totalPrice = 0;
        for (OrderMenu orderMenu : orderList) {
            totalPrice += orderMenu.getTotalPrice();
        }
        return totalPrice;
    }

    //TODO: 주일 할인 금액
    public int discountWeek(List<OrderMenu> orderList, int orderDate) {
        OrderDate date = new OrderDate(orderDate);
        if (Objects.equals(date.getDayOfWeek(), "weekDay")) {
            return countDessertMenus(orderList) * WEEK_DISCOUNT;
        }
        if (Objects.equals(date.getDayOfWeek(), "weekEnd")) {
            return countMainMenus(orderList) * WEEK_DISCOUNT;
        }
        return 0;
    }

    // DESSERT 카테고리인 메뉴 갯수 세기
    private int countDessertMenus(List<OrderMenu> orderList) {
        int dessertCount = 0;
        for (OrderMenu orderMenu : orderList) {
            if (orderMenu.getCategory() == Menu.Category.DESSERT) {
                dessertCount++;
            }
        }
        return dessertCount;
    }

    // MAIN 카테고리인 메뉴 갯수 세기
    private int countMainMenus(List<OrderMenu> orderList) {
        int mainCount = 0;
        for (OrderMenu orderMenu : orderList) {
            if (orderMenu.getCategory() == Menu.Category.MAIN) {
                mainCount++;
            }
        }
        return mainCount;
    }

    //TODO: 특별 할인 금액
    public int discountSpecial(int orderDate) {
        OrderDate date = new OrderDate(orderDate);
        if (date.isSpecialDiscount()) {
            return SPECIAL_DISCOUNT;
        }
        return 0;
    }

    //
}

