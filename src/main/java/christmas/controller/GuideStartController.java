package christmas.controller;

import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.view.output.OutputValue;

public class GuideStartController {
    public static void startGuide(OrderDate orderDate, OrderList orderList) {
        OutputValue.guideEvent(orderDate);
        OutputValue.guideOrderMenu(orderList);
    }
}
