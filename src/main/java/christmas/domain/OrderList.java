package christmas.domain;

import christmas.domain.Menu.Category;
import christmas.message.ErrorMessage;
import christmas.service.OrderCalculator;
import java.util.List;

// 주문서 양식
public class OrderList {
    private List<OrderMenu> orderList;
    private int orderPrice;

    public OrderList(List<String> orderListForm) {
        validateForm(orderListForm);
        List<OrderMenu> form = OrderFormParser.parseOrderForm(orderListForm);
        validateValue(form);
        this.orderList = form;
        this.orderPrice = calculateOrderPrice();
    }

    // 총 주문 가격 계산
    private int calculateOrderPrice() {
        int totalPrice = 0;
        for (OrderMenu orderMenu : orderList) {
            totalPrice += orderMenu.getTotalPrice();
        }
        return totalPrice;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    // DESSERT 카테고리인 메뉴 갯수 세기(주중 할인)
    public int countDessertMenus() {
        int dessertCount = 0;
        for (OrderMenu orderMenu : orderList) {
            if (orderMenu.getCategory() == Menu.Category.DESSERT) {
                dessertCount++;
            }
        }
        return dessertCount;
    }

    // MAIN 카테고리인 메뉴 갯수 세기(주말 할인)
    public int countMainMenus() {
        int mainCount = 0;
        for (OrderMenu orderMenu : orderList) {
            if (orderMenu.getCategory() == Menu.Category.MAIN) {
                mainCount++;
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

    // 입력 양식 유효성 검증하는 메소드
    public static void validateForm(List<String> orderListForm) {
        for (String order : orderListForm) {
            if (!isValidOrderFormat(order)) {
                throw new IllegalArgumentException(ErrorMessage.WRONG_ORDER.getMessage());
            }
        }
    }

    private static boolean isValidOrderFormat(String order) {
        String[] parts = order.split("-");
        return parts.length == 2 && isValidString(parts[0]) && isValidNumber(parts[1]);
        // 길이가 2다(String과 number로 나눠져 있다) 그리고 옳은 형태로 입력된 String이다 그리고 옳은 형태로 입력된 number이다.
    }

    //공백이나 빈값 허용 x
    private static boolean isValidString(String str) {
        return str != null && !str.isBlank();
    }

    // 수량이 제대로 입력됐는지
    private static boolean isValidNumber(String str) {
        try {
            int quantity = Integer.parseInt(str);
            return quantity > 0; // 음수 혹은 0이 아닌지 확인
        } catch (NumberFormatException e) {
            return false; // 숫자로 변환할 수 없는 경우
        }
    }

}
