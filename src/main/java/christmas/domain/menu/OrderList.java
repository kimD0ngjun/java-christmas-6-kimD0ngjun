package christmas.domain.menu;

import christmas.service.OrderFormParser;
import christmas.utility.OrderFormValidator;
import christmas.utility.OrderValueValidator;
import java.util.List;

public class OrderList {
    private final List<OrderMenu> orderList;
    private final MenuCounter menuCounter;

    public OrderList(List<String> orderListForm) {
        OrderFormValidator.validateForm(orderListForm);
        List<OrderMenu> form = OrderFormParser.parseOrderForm(orderListForm);
        validateValue(form);
        this.orderList = form;
        this.menuCounter = new MenuCounter(orderList);
    }

    public List<OrderMenu> getOrderList() {
        return orderList;
    }

    public int countDessertMenus() {
        return menuCounter.countDessertMenus();
    }

    public int countMainMenus() {
        return menuCounter.countMainMenus();
    }

    private void validateValue(List<OrderMenu> form) {
        OrderValueValidator.hasDuplicateMenus(form);
        OrderValueValidator.isTotalQuantityValid(form);
        OrderValueValidator.validateBeverageOnlyCategory(form);
    }
}
