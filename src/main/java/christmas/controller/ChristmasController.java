package christmas.controller;

import christmas.domain.OrderDate;
import christmas.domain.OrderList;
import christmas.message.OutputMessage;
import christmas.service.OrderCalculator;
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
        OutputValue.guideTotalPrice(calculator.getTotalPrice());
        OutputValue.guidePresent(calculator.getTotalPrice());
        OutputValue.guideBenefits(calculator, orderDate);
        System.out.println(calculator.getExpectedPrice());
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
