package christmas.domain.badge;

// Badge 결정 인터페이스(전략 패턴 적용)
public interface GiveBadgeProvider {
    GiveBadge getBadge(int totalBenefits);
}

