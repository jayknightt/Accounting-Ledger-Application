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
            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'D':
                    // Option D: View Transactions
                    System.out.println("Viewing transactions...");
                    viewTransactions();
                    break;
                case 'P':
                    // Option P: Make a Payment
                    System.out.println("Making a payment...");
                    addTransaction(scanner);
                    break;
                case 'L':
                    // Option L: Display Ledger
                    System.out.println("Displaying Ledger...");
                    break;
                case 'X':
                    // Option X: Exit
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayHomeScreen() {
        System.out.println("=== Home Screen ===");
        System.out.println("D. View Transactions");
        System.out.println("P. Make a Payment");
        System.out.println("L. Display Ledger");
        System.out.println("X. Exit");
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
            System.out.print("Enter payment details (e.g., date, amount, description): ");
            String transactionDetails = scanner.nextLine();

            // Write transaction details to CSV file
            writer.write(transactionDetails);
            writer.newLine();

            System.out.println("Payment added successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to make payment :( ");
            e.printStackTrace();
        }
    }

    private static void displayLedgerMenu(Scanner scanner) {
        System.out.println("=== Ledger Menu ===");
        System.out.println("A. All Transactions");
        System.out.println("D. Deposits");
        System.out.println("P. Payments");
        System.out.println("R. Reports");
        System.out.println("H. Go Back to Home Screen");
        System.out.print("Choose an option: ");
        char choice = scanner.next().charAt(0);

        switch (choice) {
            case 'A':
                System.out.println("Viewing all transactions...");
                break;
            case 'D':
                System.out.println("Viewing deposits...");
                break;
            case 'P':
                System.out.println("Viewing payments...");
                break;
            case 'R':
                System.out.println("Generating reports...");
                // Implement the logic to generate reports
                break;
            case 'H':
                System.out.println("Going back to the home screen...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}


