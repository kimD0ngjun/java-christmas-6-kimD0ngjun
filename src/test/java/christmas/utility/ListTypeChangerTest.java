package christmas.utility;

import christmas.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListTypeChangerTest {

    @DisplayName("옳게 입력된 주문은 List<String>로 변환된다.")
    @Test
    public void changeListType_ValidInput_ReturnsList() {
        String input = "해산물파스타-2,레드와인-1,초코케이크-1";
        assertDoesNotThrow(() -> ListTypeChanger.changeListType(input));
    }

    @DisplayName("입력값이 null이면 예외가 발생한다.")
    @Test
    public void changeListType_NullInput_ThrowsIllegalArgumentException() {
        String input = null;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> ListTypeChanger.changeListType(input));
        assertEquals(ErrorMessage.WRONG_ORDER.getMessage(), exception.getMessage());
    }

    @DisplayName("입력값이 빈 문자열이면 예외가 발생한다.")
    @Test
    public void changeListType_EmptyInput_ThrowsIllegalArgumentException() {
        String input = "";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> ListTypeChanger.changeListType(input));
        assertEquals(ErrorMessage.WRONG_ORDER.getMessage(), exception.getMessage());
    }

    @DisplayName("주문 단위의 첫 인덱스에 - 표시가 있으면 예외가 발생한다.")
    @Test
    public void changeListType_InvalidInputWithDash_ThrowsIllegalArgumentException() {
        String input = "해산물파스타-2,-레드와인-1,초코케이크-1";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> ListTypeChanger.changeListType(input));
        assertEquals(ErrorMessage.WRONG_ORDER.getMessage(), exception.getMessage());
    }

    @DisplayName("주문 단위의 마지막 인덱스에 - 표시가 있으면 예외가 발생한다.")
    @Test
    public void changeListType_InvalidInputEndsWithDash_ThrowsIllegalArgumentException() {
        String input = "해산물파스타-2,레드와인-1,초코케이크-1-";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> ListTypeChanger.changeListType(input));
        assertEquals(ErrorMessage.WRONG_ORDER.getMessage(), exception.getMessage());
    }

    @DisplayName("주문 단위의 앞뒤 인덱스에 - 표시가 있으면 예외가 발생한다.")
    @Test
    public void changeListType_InvalidInputWithTwoDashes_ThrowsIllegalArgumentException() {
        String input = "해산물파스타-2,-레드와인-1,초코케이크-1-";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> ListTypeChanger.changeListType(input));
        assertEquals(ErrorMessage.WRONG_ORDER.getMessage(), exception.getMessage());
    }
}
