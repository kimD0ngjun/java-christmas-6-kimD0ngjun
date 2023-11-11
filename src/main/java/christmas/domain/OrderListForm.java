package christmas.domain;

import christmas.message.ErrorMessage;
import java.util.List;

// 바로 Map화를 시켜도 되나... 그 과정에서 유효성 검증을 수행할 수 있으려나....
// 어차피 메뉴명 옳은지 여부는 OrderMenu 클래스에서 수행하고 있잖아.
// 수량도 OrderQuantity 클래스 나중에 만들어서 숫자인지 여부 판별할 텐데.
// 근데 Map화 시킬 때 제네릭에 지정된 데이터 타입 안 들어가면 컴파일 예외 발생하지 않나
// IllegalArgumentException는 런타임 예외인데 흠....

// 주문서 양식
public class OrderListForm {
    private List<String> orderListForm;

    public OrderListForm(List<String> orderListForm) {
        validateForm(orderListForm);
        this.orderListForm = orderListForm;
    }

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

    // 수량이 제대로 입력됐는지, 양의 정수인지는 OrderQuantity 클래스에서 정적 메소드로 작성해서 여기로 들고오는 식으로 리팩토링?
    private static boolean isValidNumber(String str) {
        try {
            int quantity = Integer.parseInt(str);
            return quantity > 0; // 음수 혹은 0이 아닌지 확인
        } catch (NumberFormatException e) {
            return false; // 숫자로 변환할 수 없는 경우
        }
    }
}
