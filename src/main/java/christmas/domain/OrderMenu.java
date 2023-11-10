package christmas.domain;

public class OrderMenu {
    private Menu orderMenu;

    public OrderMenu(String orderMenu) {
        this.orderMenu = Menu.getMenuByName(orderMenu);
    }

    public Menu getMenu() {
        return orderMenu;
    }

    // 주문 메뉴의 가격 반환
    public int getPrice() {
        return orderMenu.getPrice();
    }

    // 주문 메뉴의 카테고리 반환
    public Menu.Category getCategory() {
        return orderMenu.getCategory();
    }
}
