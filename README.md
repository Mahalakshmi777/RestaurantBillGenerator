# RestaurantBillGenerator
A simple Java-based billing system for restaurants that generates formatted bills, calculates GST, assigns waiters, and collects customer feedback. Includes exception handling, OOP concepts, and user-friendly console output. 
📌 Overview

The Restaurant Billing System is a Java-based console application designed to generate formatted bills for restaurant orders. It calculates subtotal, SGST, CGST, and total amount, assigns a random waiter and table number, and collects customer feedback.

🚀 Features

Add multiple items with quantity and price

Auto-generated bill with formatted alignment

Random table & waiter assignment

GST Calculation (SGST 2.5% + CGST 2.5%)

Customer feedback collection

Input validation & exception handling

🛠️ Tech Stack

Language: Java

Concepts Used: OOP, Exception Handling, String Formatting, Arrays

📂 Project Structure

RestaurantBillingSystem/
│── src/
│   ├── BillGenerator.java
│   ├── Items.java
│   ├── Customer.java
│── README.md
│── .gitignore
│── LICENSE

🔧 Setup & Installation

Clone the repository:

git clone https://github.com/yourusername/RestaurantBillingSystem.git

Navigate to the project directory:

cd RestaurantBillingSystem

Compile the Java files:

javac src/*.java

Run the program:

java src.BillGenerator

📌 Usage

The system will prompt the user to enter customer details.

Users can add multiple items by providing item names, quantities, and prices.

The bill is generated with proper alignment and tax calculations.

Customers are prompted to rate their experience and provide feedback.

The application handles invalid inputs gracefully.

🏆 Example Output

╔════════════════════════════════════════════════╗
║               ** Bite & Beyond **              ║
╠════════════════════════════════════════════════╣
║ Customer Name : John Doe                       ║
║ Table No      : 5                              ║
║ Waiter        : Rahul                          ║
╠════════════════════════════════════════════════╣
║ Item           │ Qty │ Rate  │ Total           ║
║ Burger         │  2  │ ₹50.00 │ ₹100.00        ║
║ Coke           │  1  │ ₹30.00 │ ₹30.00         ║
╠════════════════════════════════════════════════╣
║ Subtotal       : ₹130.00                       ║
║ SGST (2.5%)    : ₹3.25                         ║
║ CGST (2.5%)    : ₹3.25                         ║
║ Total Amount   : ₹136.50                       ║
╚════════════════════════════════════════════════╝

🤝 Contributing

Contributions are welcome! Feel free to fork the repository and submit a pull request.

📜 License

This project is licensed under the MIT License.

🌟 Support

If you like this project, consider starring ⭐ the repository and sharing it with others! 😊

