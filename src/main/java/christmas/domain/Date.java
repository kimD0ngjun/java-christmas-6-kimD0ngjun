package christmas.domain;

public class Date {
    private final int date;

    public Date(Integer date) {
        validateDate(date);
        this.date = date;
    }

    // 올바른 날짜 검증
    private void validateDate(int date) {
        if(date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
