package mypackage;

import java.util.Scanner;

public class Customer {
    private String name;
    private long phoneNumber;

    // Constructor accepting Scanner to avoid multiple scanner instances
    public Customer(Scanner input) {
        System.out.print("Enter your name: ");
        this.name = input.nextLine();

        // Validate phone number (must be exactly 10 digits)
        this.phoneNumber = getValidPhoneNumber(input);
    }

    private long getValidPhoneNumber(Scanner input) {
        while (true) {
            System.out.print("Enter your Phone Number (10 digits): ");
            String phoneInput = input.nextLine();

            // Check if input contains exactly 10 digits
            if (phoneInput.matches("\\d{10}")) {
                return Long.parseLong(phoneInput);
            } else {
                System.out.println("Invalid phone number! Please enter exactly 10 digits.");
            }
        }
    }

    public String getName() {
        return name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }
}
