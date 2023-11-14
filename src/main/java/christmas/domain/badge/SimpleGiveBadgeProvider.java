package christmas.domain.badge;

import christmas.view.message.OutputMessage;

public class SimpleGiveBadgeProvider implements GiveBadgeProvider {
    private final int LIMIT_AMOUNT = 20_000;
    private final String BADGE = "산타";

    @Override
    public GiveBadge getBadge(int totalBenefits) {
        for (Badges badge : Badges.values()) {
            if (totalBenefits <= badge.getLimitAmount()) {
                return new GiveBadge(badge.getMessage(), badge.getLimitAmount(), badge.getBadge());
            }
        }
        return new GiveBadge(OutputMessage.BADGE, LIMIT_AMOUNT, BADGE);
    }
}
