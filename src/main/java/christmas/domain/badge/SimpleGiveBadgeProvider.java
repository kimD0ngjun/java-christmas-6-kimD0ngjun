package christmas.domain.badge;

// 실제로 배지를 결정하는 구체 전략
public class SimpleGiveBadgeProvider implements GiveBadgeProvider {
    @Override
    public GiveBadge getBadge(int totalBenefits) {
        for (Badges badge : Badges.values()) {
            if (totalBenefits >= badge.getLimitAmount()) {
                return new GiveBadge(badge.getMessage(), badge.getLimitAmount(), badge.getBadge());
            }
        }
        return null;
    }
}
