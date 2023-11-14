package christmas.view.output;

import christmas.domain.menu.OrderList;
import christmas.domain.menu.OrderMenu;
import christmas.view.message.OutputMessage;

public class GuideOrderMenu {
    private final OrderList orderList;

    public GuideOrderMenu(OrderList orderList) {
        this.orderList = orderList;
    }

    public void displayOrderMenu() {
        System.out.println(OutputMessage.ORDER_MENU_TITLE.getMessage());
        for (OrderMenu orderMenu : orderList.getOrderList()) {
            String menuName = orderMenu.getMenuName();
            int menuQuantity = orderMenu.getQuantity();
            System.out.println(OutputMessage.ORDER_MENU_INFO.getMessage(menuName, menuQuantity));
        }
    }
}
