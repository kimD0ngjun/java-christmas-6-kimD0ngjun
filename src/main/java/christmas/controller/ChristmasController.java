package christmas.controller;

import christmas.domain.Date;
import christmas.utility.NumberTypeChanger;
import christmas.view.InputValue;

public class ChristmasController {
    public void startEvent() {
        InputValue.inputDate();
        InputValue.inputOrder();
    }

    private Date getInputDate() {
        while (true) {
            try {
                String input = InputValue.inputDate();
                int dateNumber = NumberTypeChanger.changeNumberType(input);
                Date date = new Date(dateNumber);
                return date;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
