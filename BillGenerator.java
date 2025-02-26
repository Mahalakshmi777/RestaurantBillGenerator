package mypackage;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BillGenerator {
    private static final String[] waiterNames = {"Surya", "Rahul", "Suresh", "Kiran", "Ravi"};
    private static final String GST_NUMBER = "33AABCU9603R1Z2"; // Sample GST Number

    public void totalBill(Items[] items, Customer customer) {
        Random rand = new Random();
        int tableNumber = rand.nextInt(20) + 1;
        String waiterName = waiterNames[rand.nextInt(waiterNames.length)];

        System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      ** Bite & Beyond **                         ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ %-64s ║\n", "Keeranatham Rd,Saravanampatti,Coimbatore,Tamil Nadu 641035");
        System.out.printf("║ %-64s ║\n", "Phone: 1234567890");
        System.out.printf("║ GST No: %-55s  ║\n", GST_NUMBER);
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ Customer Name : %-49s║\n", customer.getName());
        System.out.printf("║ Table No      : %-49d║\n", tableNumber);
        System.out.printf("║ Waiter        : %-49s║\n", waiterName);
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ %-25s │ %-5s │ %-8s │ %-10s        ║\n", "Item", "Qty", "Rate", "Total");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");

        double subtotal = 0;
        int totalItems = 0;
        for (Items item : items) {
            if (item != null) {
                totalItems += item.getQuantity();
                String nos = (item.getQuantity() > 1) ? " nos" : "";
                System.out.printf("║ %-25s │ %-5d │ ₹%-7.2f │ ₹%-10.2f       ║\n",
                        item.getItemName() + nos, item.getQuantity(), item.getItemPrice(),
                        item.subTotalBill());
                subtotal += item.subTotalBill();
            }
        }

        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ %-36s : %-26d║\n", "Total Items", totalItems);
        System.out.printf("║ %-36s : ₹%-25.2f║\n", "Subtotal", subtotal);
        
        double sgst = subtotal * 0.025; 
        double cgst = subtotal * 0.025; 
        double totalTax = sgst + cgst;

        System.out.printf("║ %-36s : ₹%-25.2f║\n", "SGST (2.5%)", sgst);
        System.out.printf("║ %-36s : ₹%-25.2f║\n", "CGST (2.5%)", cgst);
        System.out.printf("║ %-36s : ₹%-25.2f║\n", "Total Amount", subtotal + totalTax);
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");

        collectFeedback();
        
        System.out.println("║ Thank You! Visit Again!                              	   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    private void collectFeedback() {
        Scanner input = new Scanner(System.in);
        int rating = 0;
        boolean validRating = false;

        while (!validRating) {
            try {
                System.out.print("\nRate your experience (1-5): ");
                rating = input.nextInt();
                input.nextLine(); // Consume newline
                if (rating < 1 || rating > 5) {
                    throw new IllegalArgumentException("Invalid rating! Please enter a number between 1 and 5.");
                }
                validRating = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number!");
                input.nextLine(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Any feedback? ");
        String feedback = input.nextLine();

        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      ** CUSTOMER FEEDBACK **                     ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ Rate your experience (1-5): %-34d   ║\n", rating);
        System.out.printf("║ Feedback: %-55s║\n", feedback);
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    public static char getValidUserChoice(Scanner input) {
        char choice;
        while (true) {
            System.out.print("\nDo you want to add more items? (y/n): ");
            String userInput = input.next().toLowerCase();
            if (userInput.equals("y") || userInput.equals("n")) { 
                choice = userInput.charAt(0);
                break;
            } else {
                System.out.println("Invalid input! Please enter 'y' or 'n' only.");
            }
        }
        return choice;
    }
}
