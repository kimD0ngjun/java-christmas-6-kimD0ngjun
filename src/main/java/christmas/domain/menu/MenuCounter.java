package christmas.domain.menu;

import java.util.List;

public class MenuCounter {
    private final List<OrderMenu> orderList;

    public MenuCounter(List<OrderMenu> orderList) {
        this.orderList = orderList;
    }

    public int countDessertMenus() {
        return countMenusByCategory(Menu.Category.DESSERT);
    }

    public int countMainMenus() {
        return countMenusByCategory(Menu.Category.MAIN);
    }

    private int countMenusByCategory(Menu.Category category) {
        int count = 0;
        for (OrderMenu orderMenu : orderList) {
            if (orderMenu.getCategory() == category) {
                count += orderMenu.getQuantity();
            }
        }
        return count;
    }
}
