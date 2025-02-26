package mypackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice, count = 0;
        Items[] totalItems = new Items[50];
        Scanner input = new Scanner(System.in);
        Items item;

        // Create Customer object
        Customer customer = new Customer(input);

        String[] itemNames = {
            "Chicken Rice", "Chicken Biryani", "Mutton Biryani",
            "Chicken Tandoori", "Paneer Butter Masala", "Masala Dosa",
            "Idli (2 Pieces)", "Vada (2 Pieces)", "Parotta", "Gulab Jamun (2 Pieces)"
        };

        double[] itemPrices = {120, 150, 200, 225, 180, 80, 40, 50, 30, 60};

        // Display Menu
        printMenu(itemNames, itemPrices);

        do {
            // Validate item number
            choice = getItemChoice(input, itemNames);

            // Validate quantity
            int quantity = getQuantity(input);

            // Add item to the list
            if (count < totalItems.length) {
                item = new Items(itemNames[choice - 1], itemPrices[choice - 1], quantity);
                totalItems[count++] = item;
                item.subTotalBill();
            } else {
                System.out.println("Item list full! Cannot add more.");
                break;
            }

            // Ask user if they want to add more items with proper validation
            System.out.print("Do you want to add more items? (Y/N): ");
            while (true) {
                String response = input.next().trim();
                if (response.equalsIgnoreCase("Y")) {
                    break;
                } else if (response.equalsIgnoreCase("N")) {
                    input.nextLine(); // Consume newline
                    BillGenerator bill = new BillGenerator();
                    bill.totalBill(totalItems, customer);
                    input.close();
                    return;
                } else {
                    System.out.print("Invalid input! Please enter Y or N: ");
                }
            }
        } while (true);
    }

    private static void printMenu(String[] itemNames, double[] itemPrices) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║            ** Bite & Beyond  **              ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.printf("║ %-2s │ %-25s  │ %-7s    ║\n", "No", "Item", "Price");
        System.out.println("╠══════════════════════════════════════════════╣");

        for (int i = 0; i < itemNames.length; i++) {
            System.out.printf("║ %-2d │ %-25s  │ ₹%-6.2f    ║\n", (i + 1), itemNames[i], itemPrices[i]);
        }

        System.out.println("╚══════════════════════════════════════════════╝");
    }

    private static int getItemChoice(Scanner input, String[] itemNames) {
        int choice;
        while (true) {
            try {
                System.out.print("\nSelect the item number: ");
                choice = input.nextInt();

                if (choice < 1 || choice > itemNames.length) {
                    System.out.println("Invalid choice! Please select a valid item (1-" + itemNames.length + ").");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                input.next(); // Clear buffer
            }
        }
        return choice;
    }

    private static int getQuantity(Scanner input) {
        int quantity = 0;
        while (true) {
            try {
                System.out.print("Enter the quantity: ");
                quantity = input.nextInt();

                if (quantity < 1) {
                    throw new InvalidQuantityException("Quantity must be at least 1.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid quantity.");
                input.next(); // Clear buffer
            } catch (InvalidQuantityException e) {
                System.out.println(e.getMessage());
            }
        }
        return quantity;
    }
}

// Define InvalidQuantityException class (if not already created)
class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}
