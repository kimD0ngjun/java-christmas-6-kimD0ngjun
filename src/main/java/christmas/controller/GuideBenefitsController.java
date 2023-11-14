package christmas.controller;

import christmas.domain.benefits.Discount;
import christmas.domain.benefits.Present;
import christmas.domain.benefits.SimplePresent;
import christmas.domain.benefits.SpecialDiscount;
import christmas.domain.benefits.TotalDiscount;
import christmas.domain.benefits.WeekDiscount;
import christmas.domain.benefits.XMasDiscount;
import christmas.domain.menu.OrderList;
import christmas.domain.price.SimpleTotalPrice;
import christmas.domain.price.TotalPrice;
import christmas.service.ExpectedPriceCalculator;
import christmas.service.TotalBenefitsCalculator;
import christmas.view.output.OutputValue;
import java.util.Arrays;
import java.util.List;

public class GuideBenefitsController {
    public static void start(OrderList orderList) {
        TotalPrice totalPrice = new SimpleTotalPrice();

        List<Discount> discounts = Arrays.asList(
                new WeekDiscount(),
                new SpecialDiscount(),
                new XMasDiscount()
        );

    }
}
