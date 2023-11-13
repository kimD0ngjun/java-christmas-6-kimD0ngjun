package christmas.domain.benefits;

import christmas.domain.price.TotalPrice;

public class Present {
    private final int STANDARD_PRICE = 120_000;
    private final int STANDARD_PRESENT = 25_000;

    private int present;

    public Present(TotalPrice totalPrice) {
        this.present = calculatePresent(totalPrice);
    }

    public int calculatePresent(TotalPrice totalPrice) {
        if (totalPrice.calculateTotalPrice() >= STANDARD_PRICE) {
            return STANDARD_PRESENT;
        }
        return 0;
    }
}
