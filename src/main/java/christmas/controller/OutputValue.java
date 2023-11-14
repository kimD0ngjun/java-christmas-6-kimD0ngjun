package christmas.controller;

import christmas.domain.benefits.SpecialDiscount;
import christmas.domain.benefits.WeekDiscount;
import christmas.domain.benefits.XMasDiscount;
import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.domain.menu.OrderMenu;
import christmas.domain.badge.GiveBadge;
import christmas.domain.badge.GiveBadgeProvider;
import christmas.domain.price.SimpleTotalPrice;
import christmas.domain.price.TotalPrice;
import christmas.view.message.OutputMessage;
import christmas.service.TotalBenefitsCalculator;
import christmas.utility.NumberFormatter;
import christmas.view.output.GuideBenefits;
import christmas.view.output.GuideEvent;
import christmas.view.output.GuideOrderMenu;
import christmas.view.output.GuidePresent;
import christmas.view.output.GuideTotalPrice;

public class OutputValue {

    // 이벤트 안내
    public static void guideEvent(OrderDate orderDate) {
        GuideEvent guideEvent = new GuideEvent(orderDate);
        guideEvent.displayEventGuide();
    }

    // 주문 메뉴 가이드
    public static void guideOrderMenu(OrderList orderList) {
        GuideOrderMenu guideOrderMenu = new GuideOrderMenu(orderList);
        guideOrderMenu.displayOrderMenu();
    }

    // 총주문 금액 가이드
    public static void guideTotalPrice(OrderList orderList) {
        GuideTotalPrice guideTotalPrice = new GuideTotalPrice(orderList);
        guideTotalPrice.displayTotalPrice();
    }

    // 증정 메뉴 가이드
    public static void guidePresent(OrderList orderList) {
        GuidePresent guidePresent = new GuidePresent(orderList);
        guidePresent.displayPresent();
    }

    // 혜택 내역 가이드
    public static void guideBenefits(TotalPrice totalPrice, OrderList orderList, OrderDate orderDate) {
        GuideBenefits guideBenefits = new GuideBenefits(totalPrice, orderList, orderDate);
        guideBenefits.displayBenefits();
    }

    // 총혜택 금액 가이드
    public static void guideTotalBenefits(
            TotalPrice totalPrice, OrderList orderList, OrderDate orderDate, TotalBenefitsCalculator totalBenefit) {

        int totalAmount = totalPrice.calculateTotalPrice(orderList);
        int totalBenefitAmount = totalBenefit.calculateTotalBenefits(orderList, orderDate);

        if (totalAmount < 10_000) {
            System.out.printf("%s%n", OutputMessage.TOTAL_BENEFITS.getMessage(NumberFormatter.formatNumber(0)));
        }
        if (totalAmount >= 10_000) {
            System.out.printf(
                    "%s%n", OutputMessage.TOTAL_BENEFITS.getMessage(NumberFormatter.formatNumber(-totalBenefitAmount)));
        }
    }

    // 할인 후 예상 결제 금액 가이드
    public static void guideExpectedPrice(int expectedPrice) {
        System.out.printf("%s%n", OutputMessage.EXPECTED_PRICE.getMessage(NumberFormatter.formatNumber(expectedPrice)));
    }

    // 배지 부여 가이드
    public static void guideBadge(
            TotalBenefitsCalculator totalBenefit, OrderList orderList, OrderDate orderDate, GiveBadgeProvider badgeProvider) {
        int totalBenefitAmount = totalBenefit.calculateTotalBenefits(orderList, orderDate);

        GiveBadge badge = badgeProvider.getBadge(totalBenefitAmount);

        System.out.printf("%s%n", badge.getMessage().getMessage(badge.getBadge()));
    }
}
