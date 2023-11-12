package christmas.domain;

public class OrderMenu {
    private Menu orderMenu;
    private int quantity;

    public OrderMenu(String orderMenu, int quantity) {
        this.orderMenu = Menu.getMenuByName(orderMenu);
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return orderMenu;
    }

    public String getMenuName() {
        return orderMenu.getName();
    }

    // 주문 메뉴의 수량 반환
    public int getQuantity() {
        return quantity;
    }

    // 주문 메뉴의 총 가격 반환
    public int getTotalPrice() {
        return orderMenu.getPrice() * quantity;
    }

    // 주문 메뉴의 카테고리 반환
    public Menu.Category getCategory() {
        return orderMenu.getCategory();
    }

}
