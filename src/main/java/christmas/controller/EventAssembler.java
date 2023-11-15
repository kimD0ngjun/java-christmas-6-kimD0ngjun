package christmas.controller;

import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.factory.OutputValueControllerFactory;
import christmas.view.message.GuideProcedure;

public class EventAssembler {
    private OrderDate orderDate;
    private OrderList orderList;

    public void eventController() {
        GuideProcedure.welcome();
        orderDate = InputValueController.getInputDate();
        orderList = InputValueController.getInputOrderList();

        GuideStartController.startGuide(orderDate, orderList);

        OutputValueControllerFactory factory = new OutputValueControllerFactory();
        OutputValueController output = factory.createController(orderList, orderDate);
        output.displayOutput();
    }
}
