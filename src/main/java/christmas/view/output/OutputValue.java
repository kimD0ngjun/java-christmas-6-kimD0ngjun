package christmas.view.output;

import christmas.domain.benefits.Discount;
import christmas.domain.benefits.SpecialDiscount;
import christmas.domain.benefits.TotalDiscount;
import christmas.domain.benefits.WeekDiscount;
import christmas.domain.benefits.XMasDiscount;
import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.domain.menu.OrderMenu;
import christmas.domain.badge.GiveBadge;
import christmas.domain.badge.GiveBadgeProvider;
import christmas.domain.price.TotalPrice;
import christmas.view.message.OutputMessage;
import christmas.service.TotalBenefitsCalculator;
import christmas.utility.NumberFormatter;
import java.util.Arrays;
import java.util.List;

public class OutputValue {

    // 이벤트 안내
    public static void guideEvent(OrderDate orderDate) {
        int date = orderDate.getDate();
        System.out.printf("%s%n", OutputMessage.EVENT_GUIDE.getMessage(date));
    }

    // 주문 메뉴 가이드
    public static void guideOrderMenu(OrderList orderList) {
        System.out.println(OutputMessage.ORDER_MENU_TITLE.getMessage());
        for (OrderMenu orderMenu : orderList.getOrderList()) {
            System.out.println(
                    OutputMessage.ORDER_MENU_INFO.getMessage(orderMenu.getMenuName(), orderMenu.getQuantity())
            );
        }
    }

    // 총주문 금액 가이드
    public static void guideTotalPrice(int totalPrice) {
        System.out.printf("%s%n", OutputMessage.TOTAL_PRICE.getMessage(NumberFormatter.formatNumber(totalPrice)));
    }

    // 증정 메뉴 가이드
    public static void guidePresent(int totalPrice) {
        if (totalPrice >= 120_000) {
            System.out.printf("%s%n", OutputMessage.PRESENT.getMessage("샴페인 1개"));
        }
        if (totalPrice < 120_000) {
            System.out.printf("%s%n", OutputMessage.PRESENT.getMessage("없음"));
        }
    }

    // 혜택 내역 가이드

    public static void guideBenefits(TotalPrice totalPrice, OrderList orderList, OrderDate orderDate) {
        SpecialDiscount specialDiscount = new SpecialDiscount();
        XMasDiscount xMasDiscount = new XMasDiscount();
        WeekDiscount weekDiscount = new WeekDiscount();

        int totalAmount = totalPrice.calculateTotalPrice(orderList);

        if (totalAmount < 10_000) {
            System.out.println("없음");
        }
        if (totalAmount >= 10_000) {
            guideXMasDiscount(orderList, orderDate, xMasDiscount);
            guideWeekDiscount(orderList, orderDate, weekDiscount);
            guideSpecialDiscount(orderList, orderDate, specialDiscount);
            guidePresentDiscount(totalPrice, orderList);
        }
    }
    public static void guideXMasDiscount(OrderList orderList, OrderDate orderDate, XMasDiscount xMasDiscount) {
        int xMasDiscountAmount = xMasDiscount.calculateDiscount(orderList, orderDate);
        printDiscount(OutputMessage.X_MAS_DISCOUNT, xMasDiscountAmount);
    }

    public static void guideWeekDiscount(OrderList orderList, OrderDate orderDate, WeekDiscount weekDiscount) {
        int weekDiscountAmount = weekDiscount.calculateDiscount(orderList, orderDate);
        printDiscount(getWeekDiscountMessage(orderDate), weekDiscountAmount);
    }

    public static void guideSpecialDiscount(OrderList orderList, OrderDate orderDate, SpecialDiscount specialDiscount) {
        int specialDiscountAmount = specialDiscount.calculateDiscount(orderList, orderDate);
        printDiscount(OutputMessage.SPECIAL_DISCOUNT, specialDiscountAmount);
    }

    public static void guidePresentDiscount(TotalPrice totalPrice, OrderList orderList) {
        int totalAmount = totalPrice.calculateTotalPrice(orderList);
        if (totalAmount >= 120_000) {
            System.out.println(OutputMessage.PRESENT_EVENT.getMessage());
        }
    }

    private static void printDiscount(OutputMessage message, int discountPrice) {
        if (discountPrice > 0) {
            System.out.printf("%s%n", message.getMessage(NumberFormatter.formatNumber(discountPrice)));
        }
    }

    private static OutputMessage getWeekDiscountMessage(OrderDate date) {
        if ("weekDay".equals(date.getDayOfWeek())) {
            return OutputMessage.WEEKDAY_DISCOUNT;
        }
        return OutputMessage.WEEKEND_DISCOUNT;
    }

    // 총혜택 금액 가이드
    public static void guideTotalBenefits(
            TotalPrice totalPrice, OrderList orderList, OrderDate orderDate, TotalDiscount totalDiscount, TotalBenefitsCalculator totalBenefit) {

        int totalAmount = totalPrice.calculateTotalPrice(orderList);
        int totalDiscountAmount = totalDiscount.calculateTotalDiscount(orderList, orderDate);
        int totalBenefitAmount = totalBenefit.calculateTotalBenefits(orderList, orderDate);

        if (totalAmount < 10_000) {
            System.out.printf("%s%n", OutputMessage.TOTAL_BENEFITS.getMessage(NumberFormatter.formatNumber(0)));
        }
        if (totalAmount < 120_000 && totalAmount >= 10_000) {
            System.out.printf(
                    "%s%n", OutputMessage.TOTAL_BENEFITS.getMessage(NumberFormatter.formatNumber(-totalDiscountAmount)));
        }
        if (totalAmount >= 120_000) {
            System.out.printf(
                    "%s%n", OutputMessage.TOTAL_BENEFITS.getMessage(NumberFormatter.formatNumber(-totalBenefitAmount)));
        }
    }

    // 할인 후 예상 결제 금액 가이드
    public static void guideExpectedPrice(int expectedPrice) {
        System.out.printf("%s%n", OutputMessage.EXPECTED_PRICE.getMessage(NumberFormatter.formatNumber(expectedPrice)));
    }

    // 배지 부여 가이드
    public static void guideBadge(TotalBenefitsCalculator totalBenefit, OrderList orderList, OrderDate orderDate, GiveBadgeProvider badgeProvider) {
        int totalBenefitAmount = totalBenefit.calculateTotalBenefits(orderList, orderDate);

        GiveBadge badge = badgeProvider.getBadge(totalBenefitAmount);

        System.out.printf("%s%n", badge.getMessage().getMessage(badge.getBadge()));
    }
}
