package mypackage;

// Custom Exception for Invalid Quantity
public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}
