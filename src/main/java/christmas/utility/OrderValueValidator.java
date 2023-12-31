package christmas.utility;

import christmas.domain.menu.Menu;
import christmas.domain.menu.OrderMenu;
import christmas.view.message.ErrorMessage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderValueValidator {
    private final static int OVER_QUANTITY = 21;

    public static void hasDuplicateMenus(List<OrderMenu> orderList) {
        Set<Menu> uniqueMenus = new HashSet<>();

        for (OrderMenu order : orderList) {
            Menu menu = order.getMenu();

            if (!uniqueMenus.add(menu)) {
                throw new IllegalArgumentException(ErrorMessage.WRONG_ORDER.getMessage());
            }
        }
    }

    public static void isTotalQuantityValid(List<OrderMenu> orderList) {
        int totalQuantity = orderList.stream()
                .mapToInt(OrderMenu::getQuantity)
                .sum();

        if (totalQuantity >= OVER_QUANTITY) {
            throw new IllegalArgumentException(ErrorMessage.LIMIT_QUANTITY.getMessage());
        }
    }

    public static void validateBeverageOnlyCategory(List<OrderMenu> orderList) {
        boolean hasBeverage = false;

        for (OrderMenu order : orderList) {
            if (order.getMenu().getCategory() != Menu.Category.BEVERAGE) {
                return;
            }
            hasBeverage = true;
        }

        if (hasBeverage) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_BEVERAGE.getMessage());
        }
    }
}
