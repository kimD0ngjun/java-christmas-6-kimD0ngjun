package christmas.domain.benefits;

import christmas.domain.OrderList;

// 총주문액과 증정 여부의 연관성 고려 의존성 주입 인터페이스
public interface Present {
    int calculatePresent(OrderList orderList);
}
