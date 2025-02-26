package mypackage;

public class Items {
    private String itemName;
    private double itemPrice;
    private int quantity;

    public Items(String itemName, double itemPrice, int quantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double subTotalBill() {
        return itemPrice * quantity;
    }

    public static boolean search(Items[] items, String name, int qty) {
        for (Items item : items) {
            if (item != null && item.getItemName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
