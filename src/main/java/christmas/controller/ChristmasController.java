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
import christmas.message.OutputMessage;
import christmas.domain.OrderCalculator;
import christmas.service.ExpectedPriceCalculator;
import christmas.service.TotalBenefitsCalculator;
import christmas.utility.ListTypeChanger;
import christmas.utility.NumberFormatter;
import christmas.utility.NumberTypeChanger;
import christmas.view.InputValue;
import christmas.view.OutputValue;
import java.util.Arrays;
import java.util.List;

public class ChristmasController {
    private OrderDate orderDate;
    private OrderList orderList;

    public void startEvent() {
        System.out.println(OutputMessage.WELCOME.getMessage());
        orderDate = getInputDate();
        orderList = getInputOrderList();
        OutputValue.guideEvent(orderDate);
        OutputValue.guideOrderMenu(orderList);

        //TODO REFACTORING

        TotalPrice totalPrice = new SimpleTotalPrice();
        int totalAmount = totalPrice.calculateTotalPrice(orderList);


        List<Discount> discounts = Arrays.asList(
                new WeekDiscount(),
                new SpecialDiscount(),
                new XMasDiscount()
        );

        TotalDiscount totalDiscount = new TotalDiscount(discounts);
        int total = totalDiscount.calculateTotalDiscount(orderList, orderDate);

        SpecialDiscount specialDiscount = new SpecialDiscount();
        int special = specialDiscount.calculateDiscount(orderList, orderDate);

        XMasDiscount xMasDiscount = new XMasDiscount();
        int xMas = xMasDiscount.calculateDiscount(orderList, orderDate);

        WeekDiscount weekDiscount = new WeekDiscount();
        int week = weekDiscount.calculateDiscount(orderList, orderDate);

        Present present = new SimplePresent(totalPrice);
        int isPresent = present.calculatePresent(orderList);

        TotalBenefitsCalculator totalBenefitsCalculator = new TotalBenefitsCalculator(present, totalDiscount);
        int totalBenefits = totalBenefitsCalculator.calculateTotalBenefits(orderList, orderDate);

        ExpectedPriceCalculator expectedPriceCalculator = new ExpectedPriceCalculator(totalPrice, totalDiscount);
        int expectedPrice = expectedPriceCalculator.calculateExpectedPrice(orderList, orderDate);

        OrderCalculator calculator = new OrderCalculator(orderList, orderDate);
        GiveBadgeProvider badge = new SimpleGiveBadgeProvider();

        OutputAssembler assembler = new OutputAssembler(totalPrice, orderList, discounts);

        OutputValue.guideTotalPrice(NumberFormatter.formatNumber(totalAmount));
        OutputValue.guidePresent(totalAmount);

        OutputValue.guideBenefits(totalPrice, orderList, orderDate, specialDiscount, xMasDiscount, weekDiscount);

        //TODO
        OutputValue.guideTotalBenefits(calculator);
        OutputValue.guideExpectedPrice(calculator);
        OutputValue.guideBadge(calculator, badge);
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
