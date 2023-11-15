package christmas.view.message;

public class GuideProcedure {
    public static void welcome() {
        System.out.println(OutputMessage.WELCOME.getMessage());
    }

    public static void requestDate() {
        System.out.println(InputMessage.DATE.getMessage());
    }

    public static void requestOrder() {
        System.out.println(InputMessage.ORDER.getMessage());
    }
}
