package christmas.view.output.combinedArgument;

import christmas.domain.badge.GiveBadge;
import christmas.domain.badge.GiveBadgeProvider;
import christmas.domain.date.OrderDate;
import christmas.domain.menu.OrderList;
import christmas.service.TotalBenefitsCalculator;

public class GuideBadge {
    private TotalBenefitsCalculator totalBenefit;
    private OrderList orderList;
    private OrderDate orderDate;
    private GiveBadgeProvider badgeProvider;

    public GuideBadge(
            TotalBenefitsCalculator totalBenefit,
            OrderList orderList,
            OrderDate orderDate,
            GiveBadgeProvider badgeProvider) {
        this.totalBenefit = totalBenefit;
        this.orderList = orderList;
        this.orderDate = orderDate;
        this.badgeProvider = badgeProvider;
    }

    public void displayBadge() {
        int totalBenefitAmount = totalBenefit.calculateTotalBenefits(orderList, orderDate);
        GiveBadge badge = badgeProvider.getBadge(totalBenefitAmount);
        System.out.printf("%s%n", badge.getMessage().getMessage(badge.getBadge()));
    }
}
