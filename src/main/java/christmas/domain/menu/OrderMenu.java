package christmas.domain.menu;

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

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return orderMenu.getPrice() * quantity;
    }

    public Menu.Category getCategory() {
        return orderMenu.getCategory();
    }

}
