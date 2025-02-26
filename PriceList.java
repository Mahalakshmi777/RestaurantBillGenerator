package mypackage;

public class PriceList {
    public static double itemPrice(String itemName) {
        switch (itemName) {
            case "Chicken Rice": return 120;
            case "Chicken Biryani": return 150;
            case "Mutton Biryani": return 200;
            case "Chicken Tandoori": return 225;
            case "Paneer Butter Masala": return 180;
            case "Masala Dosa": return 80;
            case "Idli": return 40;
            case "Vada": return 50;
            case "Parotta": return 30;
            case "Gulab Jamun": return 60;
            default: return 0;
        }
    }
}
