package christmas.controller;

import christmas.domain.benefits.Present;
import christmas.domain.benefits.SimplePresent;
import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.domain.badge.GiveBadgeProvider;
import christmas.domain.badge.SimpleGiveBadgeProvider;
import christmas.domain.benefits.Discount;
import christmas.domain.benefits.SpecialDiscount;
import christmas.domain.benefits.TotalDiscount;
import christmas.domain.benefits.WeekDiscount;
import christmas.domain.benefits.XMasDiscount;
import christmas.domain.price.SimpleTotalPrice;
import christmas.domain.price.TotalPrice;
import christmas.view.message.OutputMessage;
import christmas.service.ExpectedPriceCalculator;
import christmas.service.TotalBenefitsCalculator;
import christmas.utility.ListTypeChanger;
import christmas.utility.NumberTypeChanger;
import christmas.view.input.InputValue;
import java.util.Arrays;
import java.util.List;

public class ChristmasController {
    private OrderDate orderDate;
    private OrderList orderList;

    public void startEvent() {
        System.out.println(OutputMessage.WELCOME.getMessage());
        orderDate = getInputDate();
        orderList = getInputOrderList();
        //TODO 12월 25일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
        OutputValue.guideEvent(orderDate);
        //TODO <주문 메뉴>
        OutputValue.guideOrderMenu(orderList);

        TotalPrice totalPrice = new SimpleTotalPrice();
        int totalAmount = totalPrice.calculateTotalPrice(orderList);

        List<Discount> discounts = Arrays.asList(
                new WeekDiscount(),
                new SpecialDiscount(),
                new XMasDiscount()
        );

        TotalDiscount totalDiscount = new TotalDiscount(discounts, totalPrice);

        Present present = new SimplePresent(totalPrice);

        TotalBenefitsCalculator totalBenefits = new TotalBenefitsCalculator(present, totalDiscount);

        ExpectedPriceCalculator expectedPriceCalculator = new ExpectedPriceCalculator(totalPrice, totalDiscount);
        int expectedPrice = expectedPriceCalculator.calculateExpectedPrice(orderList, orderDate);

        GiveBadgeProvider badge = new SimpleGiveBadgeProvider();

        //TODO <할인 전 총주문 금액>
        OutputValue.guideTotalPrice(totalAmount);
        //TODO <증정 메뉴>
        OutputValue.guidePresent(totalAmount);
        //TODO <혜택 내역>
        System.out.println(OutputMessage.BENEFITS_GUIDE.getMessage());
        OutputValue.guideBenefits(totalPrice, orderList, orderDate);
        //TODO <총혜택 금액>
        OutputValue.guideTotalBenefits(totalPrice, orderList, orderDate, totalBenefits);
        //TODO <할인 후 예상 결제 금액>
        OutputValue.guideExpectedPrice(expectedPrice);
        //TODO <12월 이벤트 배지>
        OutputValue.guideBadge(totalBenefits, orderList, orderDate, badge);
    }

    private OrderDate getInputDate() {
        while (true) {
            try {
                String input = InputValue.inputDate();
                int dateNumber = NumberTypeChanger.changeNumberType(input);
                OrderDate date = new OrderDate(dateNumber);
                return date;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private OrderList getInputOrderList() {
        while (true) {
            try {
                String input = InputValue.inputOrder();
                List<String> orderListForm = ListTypeChanger.changeListType(input);
                OrderList orderList = new OrderList(orderListForm);
                return orderList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
