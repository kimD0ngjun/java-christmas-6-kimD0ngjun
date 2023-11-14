package christmas.controller;

import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.utility.ListTypeChanger;
import christmas.utility.NumberTypeChanger;
import christmas.view.input.DateInput;
import christmas.view.input.OrderInput;
import java.util.List;

public class InputValueController {
    public static OrderDate getInputDate() {
        while (true) {
            try {
                String input = DateInput.inputDate();
                int dateNumber = NumberTypeChanger.changeNumberType(input);
                OrderDate date = new OrderDate(dateNumber);
                return date;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static OrderList getInputOrderList() {
        while (true) {
            try {
                String input = OrderInput.inputOrder();
                List<String> orderListForm = ListTypeChanger.changeListType(input);
                OrderList orderList = new OrderList(orderListForm);
                return orderList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
