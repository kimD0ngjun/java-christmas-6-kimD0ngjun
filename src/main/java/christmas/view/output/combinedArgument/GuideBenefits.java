package christmas.view.output.combinedArgument;

import christmas.domain.benefits.SpecialDiscount;
import christmas.domain.benefits.WeekDiscount;
import christmas.domain.benefits.XMasDiscount;
import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.domain.price.TotalPrice;
import christmas.utility.NumberFormatter;
import christmas.view.message.OutputMessage;

public class GuideBenefits {
    private TotalPrice totalPrice;
    private OrderList orderList;
    private OrderDate orderDate;

    private final int STANDARD_PRICE = 120_000;
    private final int LIMIT_PRICE = 10_000;
    private final int LIMIT_DISCOUNT = 0;

    public GuideBenefits(
            TotalPrice totalPrice,
            OrderList orderList,
            OrderDate orderDate) {
        this.totalPrice = totalPrice;
        this.orderList = orderList;
        this.orderDate = orderDate;
    }

    public void displayBenefits() {
        SpecialDiscount specialDiscount = new SpecialDiscount();
        XMasDiscount xMasDiscount = new XMasDiscount();
        WeekDiscount weekDiscount = new WeekDiscount();
        int totalAmount = totalPrice.calculateTotalPrice(orderList);

        System.out.println(OutputMessage.BENEFITS_GUIDE.getMessage());
        if (totalAmount < LIMIT_PRICE) {System.out.println("없음");}
        if (totalAmount >= LIMIT_PRICE) {
            guideXMasDiscount(orderList, orderDate, xMasDiscount);
            guideWeekDiscount(orderList, orderDate, weekDiscount);
            guideSpecialDiscount(orderList, orderDate, specialDiscount);
            guidePresentDiscount(totalPrice, orderList);
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
