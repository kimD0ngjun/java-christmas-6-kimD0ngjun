package christmas.domain.menu;

import christmas.domain.menu.OrderList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderListTest {
    @DisplayName("인스턴스가 생성될 때, 해당하는 메뉴 목록들 중 메인과 디저트의 개수가 반환된다.")
    @Test
    public void countMenuTest() {
        List<String> orderListForm = Arrays.asList("아이스크림-2", "해산물파스타-3", "레드와인-1");
        OrderList orderList = new OrderList(orderListForm);

        int mainCount = orderList.countMainMenus();
        int dessertCount = orderList.countDessertMenus();

        assertEquals(3, mainCount);
        assertEquals(2, dessertCount);
    }
}

