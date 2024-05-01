import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayHomeScreen();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Option 1: View Transactions
                    System.out.println("Viewing transactions...");
                    viewTransactions();
                    break;
                case 2:
                    // Option 2: Add Transaction
                    System.out.println("Adding a transaction...");
                    addTransaction(scanner);
                    break;
                case 3:
                    // Option 3: Generate Reports
                    System.out.println("Generating reports...");
                    break;
                case 4:
                    // Option 4: Exit
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayHomeScreen() {
        System.out.println("=== Accounting Ledger Application ===");
        System.out.println("1. View Transactions");
        System.out.println("2. Add Transaction");
        System.out.println("3. Generate Reports");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private static void viewTransactions() {
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading transactions from the file.");
            e.printStackTrace();
        }
    }

    private static void addTransaction(Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv", true))) {
            // Prompt user for transaction details
            scanner.nextLine(); // Consume newline character left by previous nextInt()
            System.out.print("Enter transaction details (e.g., date, amount, description): ");
            String transactionDetails = scanner.nextLine();

            // Write transaction details to CSV file
            writer.write(transactionDetails);
            writer.newLine();

            System.out.println("Transaction added successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
