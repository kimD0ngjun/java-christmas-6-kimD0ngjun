package christmas.domain.menu;

import christmas.view.message.ErrorMessage;

public enum Menu {
    SOUP("양송이수프", 6_000, Category.APPETIZER),
    TAPAS("타파스", 5_500, Category.APPETIZER),
    SALAD("시저샐러드", 8_000, Category.APPETIZER),
    STEAK("티본스테이크", 55_000, Category.MAIN),
    RIBS("바비큐립", 54_000, Category.MAIN),
    SEAFOOD("해산물파스타", 35_000, Category.MAIN),
    X_DAY_PASTA("크리스마스파스타", 25_000, Category.MAIN),
    CAKE("초코케이크", 15_000, Category.DESSERT),
    ICE_CREAM("아이스크림", 5_000, Category.DESSERT),
    COKE("제로콜라", 3_000, Category.BEVERAGE),
    WINE("레드와인", 60_000, Category.BEVERAGE),
    CHAMPAGNE("샴페인", 25_000, Category.BEVERAGE);

    private final String name;
    private final int price;
    private final Category category;

    Menu(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    // 입력값이 메뉴판에 있는 메뉴인지 판별
    public static Menu getMenuByName(String orderMenu) {
        for (Menu menu : values()) {
            if (menu.getName().equals(orderMenu)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.WRONG_ORDER.getMessage());
    }

    public enum Category {
        APPETIZER, // 애피타이저
        MAIN,      // 메인
        DESSERT,   // 디저트
        BEVERAGE   // 음료
    }
}
