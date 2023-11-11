package christmas.domain;

import christmas.message.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 주문서 양식
public class OrderList {
    private List<OrderMenu> orderList;

    public OrderList(List<String> orderListForm) {
        validateForm(orderListForm);
        List<OrderMenu> form = generateOrderList(orderListForm);
        hasDuplicateMenus(form);
        isTotalQuantityValid(form);
        validateBeverageOnlyCategory(form);
        this.orderList = form;
    }

    //TODO 중복메뉴, 21개 검증, 오로지 음료(별도 클래스로 분리고려하기

    private static boolean hasDuplicateMenus(List<OrderMenu> orderList) {
        Set<Menu> uniqueMenus = new HashSet<>();

        for (OrderMenu order : orderList) {
            Menu menu = order.getMenu();

            if (!uniqueMenus.add(menu)) {
                // 중복된 메뉴가 있다면 false 반환
                throw new IllegalArgumentException(ErrorMessage.WRONG_ORDER.getMessage());
            }
        }

        // 중복된 메뉴가 없다면 true 반환
        return true;
    }

    private static boolean isTotalQuantityValid(List<OrderMenu> orderList) {
        int totalQuantity = orderList.stream()
                .mapToInt(OrderMenu::getQuantity)
                .sum();

        // 주문 수량의 합이 21 이하이면 true, 그렇지 않으면 false 반환
        if (totalQuantity >= 21) {
            throw new IllegalArgumentException(ErrorMessage.LIMIT_QUANTITY.getMessage());
        }

        return true;
    }

    private static void validateBeverageOnlyCategory(List<OrderMenu> orderList) {
        boolean hasBeverage = false;

        for (OrderMenu order : orderList) {
            if (order.getMenu().getCategory() != Menu.Category.BEVERAGE) {
                // BEVERAGE 카테고리 이외의 다른 카테고리가 발견되면 예외 발생
                return;
            }

            hasBeverage = true;
        }

        // BEVERAGE 카테고리만 있는 경우 예외 발생
        if (hasBeverage) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_BEVERAGE.getMessage());
        }
    }


    //TODO

    private List<OrderMenu> generateOrderList(List<String> orderListForm) {
        List<OrderMenu> orderList= new ArrayList<>();;

        for (String order : orderListForm) {
            String[] parts = order.split("-");

            String orderMenu = parts[0];
            int orderQuantity = Integer.parseInt(parts[1]);

            OrderMenu menu = new OrderMenu(orderMenu, orderQuantity);

            orderList.add(menu);
        }
        return orderList;
    }

    // 유효성 검증하는 메소드
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
