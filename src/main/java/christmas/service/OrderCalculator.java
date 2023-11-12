package christmas.service;

import christmas.domain.OrderDate;
import christmas.domain.OrderList;
import christmas.domain.OrderMenu;

public class OrderCalculator {
    private final int WEEK_DISCOUNT = 2_023;
    private final int SPECIAL_DISCOUNT = 1_000;
    private final int X_MAS_DISCOUNT = 100;

    private final int totalPrice;
    private final int weekDiscountPrice;
    private final int xMasDiscountPrice;
    private final int specialDiscountPrice;
    private final int expectedPrice;


    public OrderCalculator(OrderList orderList, OrderDate orderDate) {
        this.totalPrice = calculateTotalPrice(orderList);
        this.weekDiscountPrice = discountWeek(orderList, orderDate);
        this.xMasDiscountPrice = discountXMas(orderDate);
        this.specialDiscountPrice = discountSpecial(orderDate);
        this.expectedPrice = calculateExpectedPrice(orderList, orderDate);
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getWeekDiscountPrice() {
        return weekDiscountPrice;
    }

    public int getXMasDiscountPrice() {
        return xMasDiscountPrice;
    }

    public int getSpecialDiscountPrice() {
        return specialDiscountPrice;
    }

    public int getExpectedPrice() {
        return expectedPrice;
    }

    // 총 주문 금액
    public static int calculateTotalPrice(OrderList orderList) {
        int totalPrice = 0;
        for (OrderMenu orderMenu : orderList.getOrderList()) {
            totalPrice += orderMenu.getTotalPrice();
        }
        return totalPrice;
    }

    // 예상 결제 금액
    public int calculateExpectedPrice(OrderList orderList, OrderDate orderDate) {
        int totalPrice = calculateTotalPrice(orderList);
        int discountPrice =
                discountWeek(orderList, orderDate) + discountSpecial(orderDate) + discountXMas(orderDate);
        if (totalPrice >= 10_000) {
            return totalPrice - discountPrice;
        }
        return totalPrice;
    }

    // 주일 할인 금액
    public int discountWeek(OrderList orderList, OrderDate orderDate) {
        if (orderDate.getDayOfWeek().equals("weekDay")) {
            return orderList.countDessertMenus() * WEEK_DISCOUNT;
        }
        if (orderDate.getDayOfWeek().equals("weekEnd")) {
            return orderList.countMainMenus() * WEEK_DISCOUNT;
        }
        return 0;
    }

    // 특별 할인 금액
    public int discountSpecial(OrderDate orderDate) {
        if (orderDate.isSpecialDiscount()) {
            return SPECIAL_DISCOUNT;
        }
        return 0;
    }

    // 크리스마스 할인 금액
    public int discountXMas(OrderDate orderDate) {
        if (orderDate.isChristmasDDay()) {
            return X_MAS_DISCOUNT * (orderDate.getDate() - 1) + 1_000;
        }
        return 0;
    }
}
