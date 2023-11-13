package christmas.domain.badge;

import christmas.message.OutputMessage;

public class GiveBadge {
    private final OutputMessage message;
    private final int limitAmount;
    private final String badge;

    public GiveBadge(OutputMessage message, int limitAmount, String badge) {
        this.message = message;
        this.limitAmount = limitAmount;
        this.badge = badge;
    }

    public OutputMessage getMessage() {
        return message;
    }

    public int getLimitAmount() {
        return limitAmount;
    }

    public String getBadge() {
        return badge;
    }
}
