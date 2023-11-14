package christmas.factory;

import christmas.controller.OutputValueController;
import christmas.domain.badge.GiveBadgeProvider;
import christmas.domain.badge.SimpleGiveBadgeProvider;
import christmas.domain.benefits.Discount;
import christmas.domain.benefits.Present;
import christmas.domain.benefits.SimplePresent;
import christmas.domain.benefits.SpecialDiscount;
import christmas.domain.benefits.TotalDiscount;
import christmas.domain.benefits.WeekDiscount;
import christmas.domain.benefits.XMasDiscount;
import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.domain.price.SimpleTotalPrice;
import christmas.domain.price.TotalPrice;
import christmas.service.ExpectedPriceCalculator;
import christmas.service.TotalBenefitsCalculator;
import java.util.Arrays;
import java.util.List;

public class OutputValueControllerFactory {
    public OutputValueController createController(OrderList orderList, OrderDate orderDate) {
        TotalPrice totalPrice = new SimpleTotalPrice();
        List<Discount> discount = Arrays.asList(new WeekDiscount(), new SpecialDiscount(), new XMasDiscount());
        TotalDiscount totalDiscount = new TotalDiscount(discount, totalPrice);
        Present present = new SimplePresent(totalPrice);
        TotalBenefitsCalculator totalBenefits = new TotalBenefitsCalculator(present, totalDiscount);
        ExpectedPriceCalculator expectedPrice = new ExpectedPriceCalculator(totalPrice, totalDiscount);
        GiveBadgeProvider badge = new SimpleGiveBadgeProvider();

        return new OutputValueController(orderList, orderDate, totalPrice, totalBenefits, expectedPrice, badge);
    }
}
