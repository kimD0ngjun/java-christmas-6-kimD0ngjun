package christmas.domain;

import christmas.message.OutputMessage;

// 캡슐화를 위한 열거형
public enum Badges {
    NONE(OutputMessage.BADGE, 0, "없음"),
    STAR(OutputMessage.BADGE, 5000, "별"),
    TREE(OutputMessage.BADGE, 10000, "트리"),
    SANTA(OutputMessage.BADGE, 20000, "산타");

    private final OutputMessage message;
    private final int limitAmount;
    private final String badge;

    Badges(OutputMessage message, int limitAmount, String badge) {
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
