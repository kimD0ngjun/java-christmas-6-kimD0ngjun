package christmas.utility;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderFormValidatorTest {
    @DisplayName("옳게 입력된 주문 정보 단위는 -를 기준으로 메뉴명과 수량이 적힌다.")
    @Test
    public void validDataTest() {
        List<String> validOrderList = Arrays.asList("티본스테이크-2", "해산물파스타-3", "레드와인-1");
        assertDoesNotThrow(() -> OrderFormValidator.validateForm(validOrderList));
    }

    @DisplayName("-표가 없으면 예외가 발생한다.")
    @Test
    public void invalidDashTest() {
        List<String> noDashOrderList = Arrays.asList("티본스테이크-2", "해산물파스타3", "레드와인-1");
        assertThrows(
                IllegalArgumentException.class, () -> OrderFormValidator.validateForm(noDashOrderList));

        List<String> invalidMenuCase = Arrays.asList("티본스테이크-2", "해산물파스타해산물파스타", "레드와인-1");
        assertThrows(
                IllegalArgumentException.class, () -> OrderFormValidator.validateForm(invalidMenuCase));

        List<String> invalidNumberCase = Arrays.asList("티본스테이크-2", "33", "레드와인-1");
        assertThrows(
                IllegalArgumentException.class, () -> OrderFormValidator.validateForm(invalidNumberCase)
        );
    }

    @DisplayName("-표를 기준으로 메뉴명과 수량을 옳게 작성하지 않으면 예외가 발생한다.")
    @Test
    public void invalidMenuNumberTest() {
        List<String> wrongDashCase = Arrays.asList("-티본스테이크-2", "해산물파스타-3", "레드와인-1");
        assertThrows(
                IllegalArgumentException.class, () -> OrderFormValidator.validateForm(wrongDashCase));

        List<String> onlyMenuCase = Arrays.asList("티본스테이크-티본스테이크", "해산물파스타-3", "레드와인-1");
        assertThrows(
                IllegalArgumentException.class, () -> OrderFormValidator.validateForm(onlyMenuCase));

        List<String> whiteSpaceCase = Arrays.asList(" -티본스테이크", "해산물파스타- ", " ");
        assertThrows(
                IllegalArgumentException.class, () -> OrderFormValidator.validateForm(whiteSpaceCase));
    }

    @DisplayName("수량이 0이거나 음수면 예외가 발생한다.")
    @Test
    public void invalidUnitTest() {
        List<String> invalidMinusNumber = Arrays.asList("티본스테이크-2", "해산물파스타--3", "레드와인-1");
        assertThrows(
                IllegalArgumentException.class, () -> OrderFormValidator.validateForm(invalidMinusNumber));

        List<String> invalidZeroNumber = Arrays.asList("티본스테이크-2", "해산물파스타-0", "레드와인-1");
        assertThrows(
                IllegalArgumentException.class, () -> OrderFormValidator.validateForm(invalidZeroNumber));
    }
}
