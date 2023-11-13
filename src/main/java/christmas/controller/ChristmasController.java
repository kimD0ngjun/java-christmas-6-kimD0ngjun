package christmas.controller;

import christmas.domain.date.OrderDate;
import christmas.domain.OrderList;
import christmas.domain.badge.GiveBadgeProvider;
import christmas.domain.badge.SimpleGiveBadgeProvider;
import christmas.domain.discount.Discount;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.discount.TotalDiscount;
import christmas.domain.discount.WeekDiscount;
import christmas.domain.discount.XMasDiscount;
import christmas.message.OutputMessage;
import christmas.domain.OrderCalculator;
import christmas.utility.ListTypeChanger;
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


        List<Discount> discounts = Arrays.asList(
                new WeekDiscount(),
                new SpecialDiscount(),
                new XMasDiscount()
        );

        TotalDiscount totalDiscount = new TotalDiscount(discounts);
        int total = totalDiscount.calculateTotalBenefits(orderList, orderDate);

        SpecialDiscount specialDiscount = new SpecialDiscount();
        int special = specialDiscount.calculateDiscount(orderList, orderDate);

        XMasDiscount xMasDiscount = new XMasDiscount();
        int xMas = xMasDiscount.calculateDiscount(orderList, orderDate);

        WeekDiscount weekDiscount = new WeekDiscount();
        int week = weekDiscount.calculateDiscount(orderList, orderDate);

        OrderCalculator calculator = new OrderCalculator(orderList, orderDate);
        GiveBadgeProvider badge = new SimpleGiveBadgeProvider();

        OutputValue.guideTotalPrice(calculator);
        OutputValue.guidePresent(calculator);
        OutputValue.guideBenefits(calculator, orderDate);
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
