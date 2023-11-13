package christmas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.menu.OrderList;
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

public class TotalBenefitsCalculatorTest {
    @DisplayName("총혜택 금액은 할인 금액과 증정품 금액을 합한 값이다.")
    @Test
    public void testTotalBenefits() {
        List<String> orderListForm = Arrays.asList("티본스테이크-2", "해산물파스타-3", "초코케이크-1");
        OrderList orderList = new OrderList(orderListForm);
        OrderDate date = new OrderDate(25);
        TotalPrice totalPriceCalculator = new SimpleTotalPrice();

        Present present = new SimplePresent(totalPriceCalculator);
        List<Discount> discount = Arrays.asList(new WeekDiscount(), new SpecialDiscount(),
                new XMasDiscount()
        );

        TotalDiscount totalDiscount = new TotalDiscount(discount);
        TotalBenefitsCalculator calculator = new TotalBenefitsCalculator(present, totalDiscount);
        int totalBenefits = calculator.calculateTotalBenefits(orderList, date);
        assertEquals(31_423, totalBenefits);
    }
}
