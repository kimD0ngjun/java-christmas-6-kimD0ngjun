package christmas.view;

import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.domain.menu.OrderMenu;
import christmas.domain.badge.GiveBadge;
import christmas.domain.badge.GiveBadgeProvider;
import christmas.message.OutputMessage;
import christmas.domain.OrderCalculator;
import java.text.DecimalFormat;

public class OutputValue {
    // int 포맷팅 메소드
    private static String formatNumber(int number) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(number);
    }

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
    public static void guideTotalPrice(OrderCalculator result) {
        System.out.printf("%s%n", OutputMessage.TOTAL_PRICE.getMessage(formatNumber(result.getTotalPrice())));
    }

    // 증정 메뉴 가이드
    public static void guidePresent(OrderCalculator result) {
        if (result.getTotalPrice() >= 120_000) {
            System.out.printf("%s%n", OutputMessage.PRESENT.getMessage("샴페인 1개"));
        }
        if (result.getTotalPrice() < 120_000) {
            System.out.printf("%s%n", OutputMessage.PRESENT.getMessage("없음"));
        }
    }

    // 혜택 내역 가이드
    public static void guideBenefits(OrderCalculator result, OrderDate date) {
        System.out.println(OutputMessage.BENEFITS_GUIDE.getMessage());

        if (result.getTotalPrice() < 10_000) {
            System.out.println("없음");
        }
        if (result.getTotalPrice() >= 10_000) {
            printDiscount(OutputMessage.X_MAS_DISCOUNT, result.getXMasDiscountPrice());
            printDiscount(getWeekDiscountMessage(date), result.getWeekDiscountPrice());
            printDiscount(OutputMessage.SPECIAL_DISCOUNT, result.getSpecialDiscountPrice());
        }
        if (result.getTotalPrice() >= 120_000) {
            System.out.println(OutputMessage.PRESENT_EVENT.getMessage());
        }
    }

    private static void printDiscount(OutputMessage message, int discountPrice) {
        if (discountPrice > 0) {
            System.out.printf("%s%n", message.getMessage(formatNumber(discountPrice)));
        }
    }

    private static OutputMessage getWeekDiscountMessage(OrderDate date) {
        if ("weekDay".equals(date.getDayOfWeek())) {
            return OutputMessage.WEEKDAY_DISCOUNT;
        }
        return OutputMessage.WEEKEND_DISCOUNT;
    }

    // 총혜택 금액 가이드
    public static void guideTotalBenefits(OrderCalculator result) {
        if (result.getTotalPrice() < 10_000) {
            System.out.printf("%s%n", OutputMessage.TOTAL_BENEFITS.getMessage(formatNumber(0)));
        }
        if (result.getTotalPrice() < 120_000 && result.getTotalPrice() >= 10_000) {
            System.out.printf(
                    "%s%n", OutputMessage.TOTAL_BENEFITS.getMessage(formatNumber(-getTotalDiscount(result))));
        }
        if (result.getTotalPrice() >= 120_000) {
            System.out.printf(
                    "%s%n", OutputMessage.TOTAL_BENEFITS.getMessage(formatNumber(-getTotalBenefits(result))));
        }
    }

    private static int getTotalDiscount(OrderCalculator result) {
        return result.getSpecialDiscountPrice() + result.getWeekDiscountPrice() + result.getXMasDiscountPrice();
    }

    private static int getTotalBenefits(OrderCalculator result) {
        if (result.getTotalPrice() >= 120_000) {
            return getTotalDiscount(result) + 25_000;
        }
        return getTotalDiscount(result);
    }

    // 할인 후 예상 결제 금액 가이드
    public static void guideExpectedPrice(OrderCalculator result) {
        System.out.printf("%s%n", OutputMessage.EXPECTED_PRICE.getMessage(formatNumber(result.getExpectedPrice())));
    }

    // 배지 부여 가이드
    public static void guideBadge(OrderCalculator result, GiveBadgeProvider badgeProvider) {
        GiveBadge badge = badgeProvider.getBadge(result.getTotalBenefits());

        System.out.printf("%s%n", badge.getMessage().getMessage(badge.getBadge()));
    }
}
