package christmas.utility;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTypeChangerTest {
    @DisplayName("숫자를 요구하는 입력 단계에서는 숫자만 입력한다.")
    @Test
    void testValidateNumber() {
        assertDoesNotThrow(() -> NumberTypeChanger.changeNumberType("1"));
        assertDoesNotThrow(() -> NumberTypeChanger.changeNumberType("31"));
    }

    @DisplayName("숫자 이외의 문자, 기호, 공백을 입력하지 않는다.")
    @Test
    void testInvalidateNumber() {
        assertThrows(IllegalArgumentException.class, () -> NumberTypeChanger.changeNumberType("abc"));
        assertThrows(IllegalArgumentException.class, () -> NumberTypeChanger.changeNumberType("ab12"));
        assertThrows(IllegalArgumentException.class, () -> NumberTypeChanger.changeNumberType("12  "));
        assertThrows(IllegalArgumentException.class, () -> NumberTypeChanger.changeNumberType("1,-"));
    }
}
