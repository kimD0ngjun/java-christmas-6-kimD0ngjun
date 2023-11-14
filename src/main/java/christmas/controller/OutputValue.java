package christmas.controller;

import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.domain.badge.GiveBadgeProvider;
import christmas.domain.price.TotalPrice;
import christmas.service.ExpectedPriceCalculator;
import christmas.service.TotalBenefitsCalculator;
import christmas.view.output.combinedArgument.GuideBadge;
import christmas.view.output.combinedArgument.GuideBenefits;
import christmas.view.output.combinedArgument.GuideEvent;
import christmas.view.output.combinedArgument.GuideExpectedPrice;
import christmas.view.output.combinedArgument.GuideTotalBenefits;
import christmas.view.output.orderListArgument.GuideOrderMenu;
import christmas.view.output.orderListArgument.GuidePresent;
import christmas.view.output.orderListArgument.GuideTotalPrice;

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
    public static void guideBenefits(
            TotalPrice totalPrice,
            OrderList orderList,
            OrderDate orderDate) {
        GuideBenefits guideBenefits = new GuideBenefits(totalPrice, orderList, orderDate);
        guideBenefits.displayBenefits();
    }

    // 총혜택 금액 가이드
    public static void guideTotalBenefits(
            TotalPrice totalPrice,
            OrderList orderList,
            OrderDate orderDate,
            TotalBenefitsCalculator totalBenefits) {
        GuideTotalBenefits guideTotalBenefits =
                new GuideTotalBenefits(totalPrice,orderList, orderDate, totalBenefits);
        guideTotalBenefits.displayTotalBenefits();
    }

    // 할인 후 예상 결제 금액 가이드
    public static void guideExpectedPrice(
            ExpectedPriceCalculator calculator,
            OrderList orderList,
            OrderDate orderDate) {
        GuideExpectedPrice guideExpectedPrice =
                new GuideExpectedPrice(calculator, orderList, orderDate);
        guideExpectedPrice.displayExpectedPrice();
    }

    // 배지 부여 가이드
    public static void guideBadge(
            TotalBenefitsCalculator totalBenefit,
            OrderList orderList,
            OrderDate orderDate,
            GiveBadgeProvider badgeProvider) {
        GuideBadge guideBadge = new GuideBadge(totalBenefit, orderList, orderDate, badgeProvider);
        guideBadge.displayBadge();
    }
}
