import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "expenses.txt";

    // Save transactions to file
    public static void saveTransactions(ArrayList<Transaction> transactions) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Transaction t : transactions) {

                writer.write(t.getType() + "," +
                             t.getCategory() + "," +
                             t.getAmount());

                writer.newLine();

            }

        } catch (IOException e) {

            System.out.println("Error saving data.");

        }

    }

    // Load transactions from file
    public static ArrayList<Transaction> loadTransactions() {

        ArrayList<Transaction> transactions = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {

            return transactions;

        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 3) {

                    String type = data[0];
                    String category = data[1];
                    double amount = Double.parseDouble(data[2]);

                    transactions.add(new Transaction(type, category, amount));

                }

            }

        } catch (IOException e) {

            System.out.println("Error loading data.");

        }

        return transactions;

    }

}