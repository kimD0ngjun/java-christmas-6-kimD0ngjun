package christmas.controller;

import static christmas.utility.NumberFormatter.formatNumber;

import christmas.domain.OrderCalculator;
import christmas.domain.menu.OrderList;
import christmas.domain.price.SimpleTotalPrice;
import christmas.domain.price.TotalPrice;
import christmas.message.OutputMessage;
import christmas.utility.NumberFormatter;

public class OutputAssembler {
    private TotalPrice totalprice;
    private OrderList orderList;

    public OutputAssembler(TotalPrice totalprice, OrderList orderList) {
        this.totalprice = totalprice;
        this.orderList = orderList;
    }

    // 총 주문 금액 가이드(리팩토링)
    public String formatTotalPrice() {
        int totalAmount = totalprice.calculateTotalPrice(orderList);
        return NumberFormatter.formatNumber(totalAmount);
    }


}
