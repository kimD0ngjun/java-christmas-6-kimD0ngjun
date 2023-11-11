package christmas.domain;

import christmas.message.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

// 주문서 양식
public class OrderListForm {
    private List<OrderMenu> orderList;

    public OrderListForm(List<String> orderListForm) {
        validateForm(orderListForm);
        this.orderList = generateOrderList(orderListForm);
    }

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
