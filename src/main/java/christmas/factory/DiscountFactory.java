package christmas.factory;

import christmas.domain.benefits.Discount;
import christmas.domain.benefits.SpecialDiscount;
import christmas.domain.benefits.WeekDiscount;
import christmas.domain.benefits.XMasDiscount;
import java.util.List;

public class DiscountFactory {
    public static List<Discount> createDiscounts() {
        return List.of(new WeekDiscount(), new SpecialDiscount(), new XMasDiscount());
    }
}
