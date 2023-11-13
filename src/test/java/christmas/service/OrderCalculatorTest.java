package christmas.service;

import christmas.domain.OrderCalculator;
import christmas.domain.date.OrderDate;
import christmas.domain.OrderList;
import christmas.domain.discount.Discount;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.discount.WeekDiscount;
import christmas.domain.discount.XMasDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderCalculatorTest {

    @DisplayName("총주문 금액은 할인 적용 이전의 합산 값이다.")
    @Test
    public void calculateTotalPriceTest() {
        List<Discount> discounts = Arrays.asList(
                new WeekDiscount(),
                new SpecialDiscount(),
                new XMasDiscount()
        );
        List<String> orderListForm = Arrays.asList("티본스테이크-2", "해산물파스타-3", "레드와인-1", "아이스크림-2");
        OrderList orderList = new OrderList(orderListForm);
        OrderDate orderDate = new OrderDate(25);

        OrderCalculator totalPrice = new OrderCalculator(orderList, orderDate, discounts);

        assertEquals(285_000, totalPrice.calculateTotalPrice(orderList));
    }

    @DisplayName("예상 결제 금액은 총주문 금액에서 할인 혜택 금액을 뺀 값이다.")
    @Test
    public void calculateExpectedPriceTest() {
        List<Discount> discounts = Arrays.asList(
                new WeekDiscount(),
                new SpecialDiscount(),
                new XMasDiscount()
        );
        List<String> orderListForm = Arrays.asList("티본스테이크-2", "해산물파스타-3", "레드와인-1", "아이스크림-2");
        OrderList orderList = new OrderList(orderListForm);
        OrderDate orderDate = new OrderDate(25);

        OrderCalculator expectedPrice = new OrderCalculator(orderList, orderDate, discounts);

        assertEquals(276_554, expectedPrice.getExpectedPrice());
    }

    @DisplayName("총주문 금액이 10_000원 미만이면 어떤 이벤트도 적용되지 않는다.")
    @Test
    public void eventConditionTest() {
        List<Discount> discounts = Arrays.asList(
                new WeekDiscount(),
                new SpecialDiscount(),
                new XMasDiscount()
        );
        List<String> orderListForm1 = Arrays.asList("아이스크림-1");
        OrderList orderList1 = new OrderList(orderListForm1);

        List<String> orderListForm2 = Arrays.asList("아이스크림-2");
        OrderList orderList2 = new OrderList(orderListForm2);

        OrderDate orderDate = new OrderDate(25);

        OrderCalculator price1 = new OrderCalculator(orderList1, orderDate, discounts);
        OrderCalculator price2 = new OrderCalculator(orderList2, orderDate, discounts);

        assertEquals(5_000, price1.calculateExpectedPrice(orderList1, orderDate));
        assertEquals(1_554, price2.calculateExpectedPrice(orderList2, orderDate));
    }

    @DisplayName("주중에는 디저트 메뉴에 할인이, 주말에는 메인 메뉴에 할인이 붙는다")
    @Test
    public void discountWeekTest() {
        List<Discount> discounts = Arrays.asList(
                new WeekDiscount(),
                new SpecialDiscount(),
                new XMasDiscount()
        );
        List<String> orderListForm = Arrays.asList("티본스테이크-1", "아이스크림-2");
        OrderList orderList = new OrderList(orderListForm);

        OrderDate weekDay = new OrderDate(7);
        OrderDate weekEndDay = new OrderDate(8);

        OrderCalculator price1 = new OrderCalculator(orderList, weekDay, discounts);
        OrderCalculator price2 = new OrderCalculator(orderList, weekEndDay, discounts);

        assertEquals(4_046, price1.discountWeek(orderList, weekDay));
        assertEquals(2_023, price2.discountWeek(orderList, weekEndDay));
    }

    @DisplayName("달력에 별이 붙은 날에는 특별할인이 적용된다.")
    @Test
    public void discountSpecialTest() {
        List<Discount> discounts = Arrays.asList(
                new WeekDiscount(),
                new SpecialDiscount(),
                new XMasDiscount()
        );
        List<String> orderListForm = Arrays.asList("티본스테이크-1", "아이스크림-2");
        OrderList orderList = new OrderList(orderListForm);

        OrderDate specialDay = new OrderDate(25);
        OrderDate noSpecialDay = new OrderDate(26);

        OrderCalculator price1 = new OrderCalculator(orderList, specialDay, discounts);
        OrderCalculator price2 = new OrderCalculator(orderList, noSpecialDay, discounts);

        assertEquals(1_000, price1.discountSpecial(specialDay));
        assertEquals(0, price2.discountSpecial(noSpecialDay));
    }

    @DisplayName("1일부터 25일까지는 크리스마스 할인이 등차수열로 합산된다.")
    @Test
    public void discountXMasTest() {
        List<Discount> discounts = Arrays.asList(
                new WeekDiscount(),
                new SpecialDiscount(),
                new XMasDiscount()
        );
        List<String> orderListForm = Arrays.asList("티본스테이크-1", "아이스크림-2");
        OrderList orderList = new OrderList(orderListForm);

        OrderDate xMasDay = new OrderDate(25);
        OrderDate noXMasDay = new OrderDate(26);

        OrderCalculator price1 = new OrderCalculator(orderList, xMasDay, discounts);
        OrderCalculator price2 = new OrderCalculator(orderList, noXMasDay, discounts);

        assertEquals(3_400, price1.discountXMas(xMasDay));
        assertEquals(0, price2.discountXMas(noXMasDay));
    }
}
