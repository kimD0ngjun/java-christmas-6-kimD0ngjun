package christmas.domain.menu;

import christmas.service.OrderFormParser;
import christmas.utility.OrderFormValidator;
import christmas.utility.OrderValueValidator;
import java.util.List;

// 주문서 양식
public class OrderList {
    private final List<OrderMenu> orderList;

    public OrderList(List<String> orderListForm) {
        OrderFormValidator.validateForm(orderListForm);
        List<OrderMenu> form = OrderFormParser.parseOrderForm(orderListForm);
        validateValue(form);
        this.orderList = form;
    }

    public List<OrderMenu> getOrderList() {
        return orderList;
    }

    //TODO : OrderFormValidator
    // DESSERT 카테고리인 메뉴 갯수 세기(주중 할인)
    public int countDessertMenus() {
        int dessertCount = 0;
        for (OrderMenu orderMenu : orderList) {
            if (orderMenu.getCategory() == Menu.Category.DESSERT) {
                dessertCount += orderMenu.getQuantity();
            }
        }
        return dessertCount;
    }

    // MAIN 카테고리인 메뉴 갯수 세기(주말 할인)
    public int countMainMenus() {
        int mainCount = 0;
        for (OrderMenu orderMenu : orderList) {
            if (orderMenu.getCategory() == Menu.Category.MAIN) {
                mainCount += orderMenu.getQuantity();
            }
        }
        return mainCount;
    }

    // 입력값 유효성 검증하는 메소드
    private static void validateValue(List<OrderMenu> form) {
        OrderValueValidator.hasDuplicateMenus(form);
        OrderValueValidator.isTotalQuantityValid(form);
        OrderValueValidator.validateBeverageOnlyCategory(form);
    }
}
