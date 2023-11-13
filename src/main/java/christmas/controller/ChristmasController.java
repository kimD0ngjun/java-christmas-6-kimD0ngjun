package christmas.controller;

import christmas.domain.date.OrderDate;
import christmas.domain.OrderList;
import christmas.domain.badge.GiveBadgeProvider;
import christmas.domain.badge.SimpleGiveBadgeProvider;
import christmas.message.OutputMessage;
import christmas.domain.OrderCalculator;
import christmas.utility.ListTypeChanger;
import christmas.utility.NumberTypeChanger;
import christmas.view.InputValue;
import christmas.view.OutputValue;
import java.util.List;

public class ChristmasController {
    private OrderDate orderDate;
    private OrderList orderList;

    public void startEvent() {
        System.out.println(OutputMessage.WELCOME.getMessage());
        orderDate = getInputDate();
        orderList = getInputOrderList();
        OutputValue.guideEvent(orderDate);
        OutputValue.guideOrderMenu(orderList);

        OrderCalculator calculator = new OrderCalculator(orderList, orderDate);
        GiveBadgeProvider badge = new SimpleGiveBadgeProvider();

        OutputValue.guideTotalPrice(calculator);
        OutputValue.guidePresent(calculator);
        OutputValue.guideBenefits(calculator, orderDate);
        OutputValue.guideTotalBenefits(calculator);
        OutputValue.guideExpectedPrice(calculator);
        OutputValue.guideBadge(calculator, badge);
    }

    private OrderDate getInputDate() {
        while (true) {
            try {
                String input = InputValue.inputDate();
                int dateNumber = NumberTypeChanger.changeNumberType(input);
                OrderDate date = new OrderDate(dateNumber);
                return date;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private OrderList getInputOrderList() {
        while (true) {
            try {
                String input = InputValue.inputOrder();
                List<String> orderListForm = ListTypeChanger.changeListType(input);
                OrderList orderList = new OrderList(orderListForm);
                return orderList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
