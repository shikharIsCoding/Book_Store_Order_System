import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BookStoreMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookStore bookStore = new BookStore();

        // Input customer details only once for the session
        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();

        System.out.println("Enter customer phone:");
        String customerPhone = scanner.nextLine();

        System.out.println("Enter customer email address:");
        String customerEmail = scanner.nextLine();

        Customer customer1 = new Customer(customerName, customerPhone, customerEmail);

        // Initialize the total cost and invoice number collection
        double accumulatedTotalCost = 0;
        StringBuilder invoiceNumbers = new StringBuilder();
        ArrayList<Invoice> invoices = new ArrayList<>();

        String moreOrders = "yes";
        while (moreOrders.equalsIgnoreCase("yes")) {
            // User Input for Book Details
            System.out.println("Enter book name:");
            String bookName = scanner.nextLine();

            System.out.println("Enter author name:");
            String authorName = scanner.nextLine();

            System.out.println("Enter price of the book:");
            double bookPrice = 0;
            try {
                bookPrice = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid price input. Please enter a numeric value.");
                continue; // Skips the rest of the current loop iteration
            }

            Stock stock1 = new Stock(bookName, authorName, bookPrice);

            // Customer places an order to purchase a book
            Order order1 = new Order(customer1, stock1);

            // Determine the shipping date
            int year1 = 2022;
            int month1 = 12;
            int day1 = 12;

            LocalDate shipDate1 = LocalDate.of(year1, month1, day1);
            Shipping shipOrder1 = new Shipping(order1, shipDate1);

            // Calculate the shipping cost to send the order
            double shipCost1 = shipOrder1.calcShipCost(true);

            // Create an invoice
            Invoice invoice1 = new Invoice("AAA111", stock1, shipOrder1);
            double cost1 = invoice1.invoice();
            accumulatedTotalCost += cost1;
            invoices.add(invoice1);

            // Append the invoice number to the StringBuilder
            if (invoiceNumbers.length() > 0) invoiceNumbers.append(", ");
            invoiceNumbers.append(invoice1.getInvoiceNbr());

            // Ask the user if they want to place another order
            System.out.println("Do you want to place another order? (yes/no)");
            moreOrders = scanner.nextLine();
        }

        // Print the total cost, customer name, and invoice numbers
        System.out.println("Total cost for all orders: " + accumulatedTotalCost);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Invoice Numbers: " + invoiceNumbers.toString());

        scanner.close(); // Close the scanner at the end
    }
}
