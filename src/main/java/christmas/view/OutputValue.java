package christmas.view;

import christmas.domain.OrderDate;
import christmas.domain.OrderList;
import christmas.domain.OrderMenu;
import christmas.message.OutputMessage;

public class OutputValue {
    public static void guideEvent(OrderDate orderDate) {
        int date = orderDate.getDate();
        System.out.printf("%s%n", OutputMessage.EVENT_GUIDE.getMessage(date));
    }

    public static void guideOrderMenu(OrderList orderList) {
        System.out.println(OutputMessage.ORDER_MENU.getMessage());
        for (OrderMenu orderMenu : orderList.getOrderList()) {
            System.out.println(orderMenu.getMenuName() + " " + orderMenu.getQuantity() +"개");
        }
    }
}
