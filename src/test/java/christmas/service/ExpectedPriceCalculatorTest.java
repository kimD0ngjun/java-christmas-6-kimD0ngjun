package christmas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.OrderList;
import christmas.domain.benefits.Discount;
import christmas.domain.benefits.Present;
import christmas.domain.benefits.SimplePresent;
import christmas.domain.benefits.SpecialDiscount;
import christmas.domain.benefits.TotalDiscount;
import christmas.domain.benefits.WeekDiscount;
import christmas.domain.benefits.XMasDiscount;
import christmas.domain.date.OrderDate;
import christmas.domain.price.SimpleTotalPrice;
import christmas.domain.price.TotalPrice;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpectedPriceCalculatorTest {

    @DisplayName("결제 예정 금액은 총주문 금액에서 할인 금액의 차액이다.")
    @Test
    public void testExpectedPrice() {
        List<String> orderListForm = Arrays.asList("티본스테이크-2", "해산물파스타-3", "초코케이크-1");
        OrderList orderList = new OrderList(orderListForm);
        OrderDate date = new OrderDate(25);

        TotalPrice totalPrice = new SimpleTotalPrice();
        List<Discount> discount = Arrays.asList(new WeekDiscount(), new SpecialDiscount(),
                new XMasDiscount()
        );

        TotalDiscount totalDiscount = new TotalDiscount(discount);
        ExpectedPriceCalculator calculator = new ExpectedPriceCalculator(totalPrice, totalDiscount);
        int expectedPrice = calculator.calculateExpectedPrice(orderList, date);

        assertEquals(223_577, expectedPrice);
    }
}
