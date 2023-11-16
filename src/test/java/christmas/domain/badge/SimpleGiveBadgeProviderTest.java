package christmas.domain.badge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleGiveBadgeProviderTest {

    @DisplayName("총혜택 금액 4_999원 이하까지는 배지를 수여하지 않는다.")
    @Test
    public void testGetBadge_NoBadge() {
        SimpleGiveBadgeProvider provider = new SimpleGiveBadgeProvider();
        GiveBadge badge = provider.getBadge(0);
        assertEquals("없음", badge.getBadge());
    }

    @DisplayName("총혜택 금액 5_000원 이상, 9_999원 이하까지 별을 수여한다.")
    @Test
    public void testGetBadge_StarBadge() {
        SimpleGiveBadgeProvider provider = new SimpleGiveBadgeProvider();
        GiveBadge badge = provider.getBadge(7000);
        assertEquals("별", badge.getBadge());
    }

    @DisplayName("총혜택 금액 10_000원 이상, 19_999원 이하까지 트리를 수여한다.")
    @Test
    public void testGetBadge_TreeBadge() {
        SimpleGiveBadgeProvider provider = new SimpleGiveBadgeProvider();
        GiveBadge badge = provider.getBadge(15000);
        assertEquals("트리", badge.getBadge());
    }

    @DisplayName("총혜택 금액 20_000원 이상부터 산타를 수여한다.")
    @Test
    public void testGetBadge_SantaBadge() {
        SimpleGiveBadgeProvider provider = new SimpleGiveBadgeProvider();
        GiveBadge badge = provider.getBadge(25000);
        assertEquals("산타", badge.getBadge());
    }
}

