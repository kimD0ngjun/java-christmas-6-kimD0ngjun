package christmas.domain.badge;

import christmas.message.OutputMessage;

// 캡슐화를 위한 열거형
public enum Badges {
    NONE(OutputMessage.BADGE, 4_999, "없음"),
    STAR(OutputMessage.BADGE, 9_999, "별"),
    TREE(OutputMessage.BADGE, 19_999, "트리"),
    SANTA(OutputMessage.BADGE, Integer.MAX_VALUE, "산타");

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
