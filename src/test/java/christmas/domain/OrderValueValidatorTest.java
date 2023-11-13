package christmas.domain;

import christmas.domain.menu.OrderMenu;
import christmas.utility.OrderValueValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderValueValidatorTest {

    @DisplayName("중복된 메뉴를 입력하면 예외가 발생한다.")
    @Test
    public void duplicatedOrderListTest() {
        List<OrderMenu> duplicatedOrderList = new ArrayList<>();
        OrderMenu order1 = new OrderMenu("양송이수프", 2);
        OrderMenu order2 = new OrderMenu("양송이수프", 3);
        OrderMenu order3 = new OrderMenu("타파스", 3);
        duplicatedOrderList.add(order1);
        duplicatedOrderList.add(order2);
        duplicatedOrderList.add(order3);

        assertThrows(IllegalArgumentException.class, () ->
                OrderValueValidator.hasDuplicateMenus(duplicatedOrderList));
    }

    @DisplayName("주문 수량이 20개를 넘으면 예외가 발생한다.")
    @Test
    public void overQuantityOrderListTest() {
        List<OrderMenu> overQuantityOrderList = new ArrayList<>();
        OrderMenu order1 = new OrderMenu("티본스테이크", 10);
        OrderMenu order2 = new OrderMenu("바비큐립", 12);
        overQuantityOrderList.add(order1);
        overQuantityOrderList.add(order2);

        assertThrows(IllegalArgumentException.class, () ->
                OrderValueValidator.isTotalQuantityValid(overQuantityOrderList));
    }

    @DisplayName("음료 카테고리의 메뉴만 주문하면 예외가 발생한다.")
    @Test
    public void onlyBeverageOrderListTest() {
        List<OrderMenu> onlyBeverageOrderList = new ArrayList<>();
        OrderMenu order1 = new OrderMenu("제로콜라", 1);
        OrderMenu order2 = new OrderMenu("레드와인", 6);
        onlyBeverageOrderList.add(order1);
        onlyBeverageOrderList.add(order2);

        assertThrows(IllegalArgumentException.class, () ->
                OrderValueValidator.validateBeverageOnlyCategory(onlyBeverageOrderList));
    }
}

