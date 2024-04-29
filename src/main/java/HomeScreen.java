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
                    break;
                case 2:
                    // Option 2: Add Transaction
                    System.out.println("Adding a transaction...");
                    writeToFile("Transaction added.");
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

    private static void writeToFile(String data) {
        try {
            FileWriter writer = new FileWriter("output.txt", true); // Append to existing file
            writer.write(data + "\n");
            writer.close();
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

