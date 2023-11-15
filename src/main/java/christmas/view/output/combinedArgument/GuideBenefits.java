package christmas.view.output.combinedArgument;

import christmas.domain.benefits.Discount;
import christmas.domain.benefits.SpecialDiscount;
import christmas.domain.benefits.WeekDiscount;
import christmas.domain.benefits.XMasDiscount;
import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.domain.price.TotalPrice;
import christmas.factory.DiscountFactory;
import christmas.utility.NumberFormatter;
import christmas.view.message.OutputMessage;
import java.util.List;

public class GuideBenefits {
    private final int STANDARD_PRICE = 120_000;
    private final int LIMIT_PRICE = 10_000;
    private final int LIMIT_DISCOUNT = 0;
    private final String NONE = "없음";

    private TotalPrice totalPrice;
    private OrderList orderList;
    private OrderDate orderDate;

    public GuideBenefits(
            TotalPrice totalPrice,
            OrderList orderList,
            OrderDate orderDate) {
        this.totalPrice = totalPrice;
        this.orderList = orderList;
        this.orderDate = orderDate;
    }

    public void displayBenefits() {
        int totalAmount = totalPrice.calculateTotalPrice(orderList);

        System.out.println(OutputMessage.BENEFITS_GUIDE.getMessage());
        if (totalAmount < LIMIT_PRICE) {
            System.out.println(NONE);
        }
        if (totalAmount >= LIMIT_PRICE) {
            guideAllDiscounts(orderList, orderDate);
            guidePresentDiscount(totalPrice, orderList);
        }
    }

    private void guideAllDiscounts(OrderList orderList, OrderDate orderDate) {
        List<Discount> discounts = DiscountFactory.createDiscounts();
        for (Discount discount : discounts) {
            if (discount instanceof XMasDiscount) {
                guideXMasDiscount(orderList, orderDate, (XMasDiscount) discount);
            }
            if (discount instanceof WeekDiscount) {
                guideWeekDiscount(orderList, orderDate, (WeekDiscount) discount);
            }
            if (discount instanceof SpecialDiscount) {
                guideSpecialDiscount(orderList, orderDate, (SpecialDiscount) discount);
            }
        }
    }

    private void guideXMasDiscount(
            OrderList orderList,
            OrderDate orderDate,
            XMasDiscount xMasDiscount) {
        int xMasDiscountAmount = xMasDiscount.calculateDiscount(orderList, orderDate);
        printDiscount(OutputMessage.X_MAS_DISCOUNT, xMasDiscountAmount);
    }

    private void guideWeekDiscount(
            OrderList orderList,
            OrderDate orderDate,
            WeekDiscount weekDiscount) {
        int weekDiscountAmount = weekDiscount.calculateDiscount(orderList, orderDate);
        printDiscount(getWeekDiscountMessage(orderDate), weekDiscountAmount);
    }

    private void guideSpecialDiscount(
            OrderList orderList,
            OrderDate orderDate,
            SpecialDiscount specialDiscount) {
        int specialDiscountAmount = specialDiscount.calculateDiscount(orderList, orderDate);
        printDiscount(OutputMessage.SPECIAL_DISCOUNT, specialDiscountAmount);
    }

    private void guidePresentDiscount(
            TotalPrice totalPrice,
            OrderList orderList) {
        int totalAmount = totalPrice.calculateTotalPrice(orderList);
        if (totalAmount >= STANDARD_PRICE) {
            System.out.println(OutputMessage.PRESENT_EVENT.getMessage());
        }
    }

    private void printDiscount(OutputMessage message, int discountPrice) {
        if (discountPrice > LIMIT_DISCOUNT) {
            System.out.printf("%s%n", message.getMessage(NumberFormatter.formatNumber(discountPrice)));
        }
    }

    private OutputMessage getWeekDiscountMessage(OrderDate date) {
        if ("weekDay".equals(date.getDayOfWeek())) {
            return OutputMessage.WEEKDAY_DISCOUNT;
        }
        return OutputMessage.WEEKEND_DISCOUNT;
    }
}
