package christmas.domain;

import christmas.message.OutputMessage;

public class Badge {
    private final OutputMessage message;
    private final int limitAmount;
    private final String badge;

    public Badge(OutputMessage message, int limitAmount, String badge) {
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
