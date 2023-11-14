package christmas.controller;

import christmas.domain.benefits.Discount;
import christmas.domain.menu.OrderList;
import christmas.domain.price.TotalPrice;
import christmas.utility.NumberFormatter;
import java.util.List;

public class OutputAssembler {
    private TotalPrice totalprice;
    private OrderList orderList;
    private List<Discount> discount;

    public OutputAssembler(TotalPrice totalprice, OrderList orderList, List<Discount> discount) {
        this.totalprice = totalprice;
        this.orderList = orderList;
        this.discount = discount;
    }

    // 총 주문 금액 가이드(리팩토링)
    public String formatTotalPrice() {
        int totalAmount = totalprice.calculateTotalPrice(orderList);
        return NumberFormatter.formatNumber(totalAmount);
    }
}


