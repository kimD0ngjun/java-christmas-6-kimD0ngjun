package christmas.domain.benefits;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.menu.OrderList;
import christmas.domain.date.OrderDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeekDiscountTest {

    @DisplayName("금요일과 토요일에는 메인 메뉴당 2023원 할인이 적용된다.")
    @Test
    public void testWeekDayDiscount() {
        List<String> orderListForm = Arrays.asList("티본스테이크-2", "레드와인-1");

        OrderList orderList = new OrderList(orderListForm);
        OrderDate weekEndDay = new OrderDate(15);
        OrderDate weekDay = new OrderDate(14);
        WeekDiscount weekDiscount = new WeekDiscount();

        int result1 = weekDiscount.calculateDiscount(orderList, weekEndDay);
        int result2 = weekDiscount.calculateDiscount(orderList, weekDay);

        assertEquals(4_046, result1);
        assertEquals(0, result2);
    }

    @DisplayName("그 외의 요일에는 디저트 메뉴당 2023원 할인이 적용된다.")
    @Test
    public void testWeekEndDiscount() {
        List<String> orderListForm = Arrays.asList("아이스크림-2", "레드와인-1");

        OrderList orderList = new OrderList(orderListForm);
        OrderDate weekEndDay = new OrderDate(15);
        OrderDate weekDay = new OrderDate(14);
        WeekDiscount weekDiscount = new WeekDiscount();

        int result1 = weekDiscount.calculateDiscount(orderList, weekEndDay);
        int result2 = weekDiscount.calculateDiscount(orderList, weekDay);

        assertEquals(0, result1);
        assertEquals(4_046, result2);
    }
}
