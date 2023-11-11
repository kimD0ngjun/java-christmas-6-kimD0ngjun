package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderListFormTest {
    @DisplayName("옳게 입력된 주문 정보 단위는 -를 기준으로 메뉴명과 수량이 적힌다.")
    @Test
    public void validateOrderListForm_ValidData_NoExceptionThrown() {
        List<String> validOrderList = Arrays.asList("티본스테이크-2", "해산물파스타-3", "레드와인-1");
        assertDoesNotThrow(() -> OrderList.validateForm(validOrderList));
    }

    @DisplayName("-표가 없으면 예외가 발생한다.")
    @Test
    public void validateOrderListForm_InvalidDash_ExceptionThrown() {
        List<String> noDashOrderList = Arrays.asList("티본스테이크-2", "해산물파스타3", "레드와인-1");
        assertThrows(IllegalArgumentException.class, () -> OrderList.validateForm(noDashOrderList));

        List<String> invalidMenuCase = Arrays.asList("티본스테이크-2", "해산물파스타해산물파스타", "레드와인-1");
        assertThrows(IllegalArgumentException.class, () -> OrderList.validateForm(invalidMenuCase));

        List<String> invalidNumberCase = Arrays.asList("티본스테이크-2", "33", "레드와인-1");
        assertThrows(
                IllegalArgumentException.class, () -> OrderList.validateForm(invalidNumberCase)
        );
    }

    @DisplayName("-표를 기준으로 메뉴명과 수량을 옳게 작성하지 않으면 예외가 발생한다.")
    @Test
    public void validateOrderListForm_InvalidMenuNumber_ExceptionThrown() {
        List<String> wrongDashCase = Arrays.asList("-티본스테이크-2", "해산물파스타-3", "레드와인-1");
        assertThrows(IllegalArgumentException.class, () -> OrderList.validateForm(wrongDashCase));

        List<String> onlyMenuCase = Arrays.asList("티본스테이크-티본스테이크", "해산물파스타-3", "레드와인-1");
        assertThrows(IllegalArgumentException.class, () -> OrderList.validateForm(onlyMenuCase));

        List<String> whiteSpaceCase = Arrays.asList(" -티본스테이크", "해산물파스타- ", " ");
        assertThrows(IllegalArgumentException.class, () -> OrderList.validateForm(whiteSpaceCase));

//        List<String> onlyNumberCase = Arrays.asList("2-2", "해산물파스타-3", "레드와인-1");
//        assertThrows(IllegalArgumentException.class, () -> OrderListForm.validateForm(onlyNumberCase));
        //TODO "2-2" : 위 케이스는 어차피 Menu 클래스에서 검증 될 것
    }

    @DisplayName("수량이 0이거나 음수면 예외가 발생한다.")
    @Test
    public void validateOrderListForm_InvalidUnit_ExceptionThrown() {
        List<String> invalidMinusNumber = Arrays.asList("티본스테이크-2", "해산물파스타--3", "레드와인-1");
        assertThrows(IllegalArgumentException.class, () -> OrderList.validateForm(invalidMinusNumber));

        List<String> invalidZeroNumber = Arrays.asList("티본스테이크-2", "해산물파스타-0", "레드와인-1");
        assertThrows(IllegalArgumentException.class, () -> OrderList.validateForm(invalidZeroNumber));
    }

}

