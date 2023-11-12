package christmas.view;

import christmas.domain.OrderDate;
import christmas.domain.OrderList;
import christmas.domain.OrderMenu;
import christmas.message.OutputMessage;
import christmas.service.OrderCalculator;
import java.text.DecimalFormat;

public class OutputValue {
    // int 포맷팅 메소드
    private static String formatNumberWithCommas(int number) {
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
    public static void guideTotalPrice(int price) {
        String totalPrice = formatNumberWithCommas(price);
        System.out.printf("%s%n", OutputMessage.TOTAL_PRICE.getMessage(totalPrice));
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

    private static int getTotalDiscount(OrderCalculator result) {
        return result.getSpecialDiscountPrice() + result.getWeekDiscountPrice() + result.getXMasDiscountPrice();
    }

    private static void printDiscount(OutputMessage message, int discountPrice) {
        if (discountPrice > 0) {
            System.out.printf("%s%n", message.getMessage(formatNumberWithCommas(discountPrice)));
        }
    }

    private static OutputMessage getWeekDiscountMessage(OrderDate date) {
        if ("weekDay".equals(date.getDayOfWeek())) {
            return OutputMessage.WEEKDAY_DISCOUNT;
        }
        return OutputMessage.WEEKEND_DISCOUNT;
    }
}
