import java.util.ArrayList;

public class ExpenseManager {

    private ArrayList<Transaction> transactions;

    public ExpenseManager() {
        transactions = new ArrayList<>();
    }

    // Add Transaction
    public void addTransaction(Transaction transaction) {

        transactions.add(transaction);

        System.out.println("\nTransaction Added Successfully!");

    }

    // View Transactions
    public void viewTransactions() {

        if (transactions.isEmpty()) {
            System.out.println("\nNo Transactions Found.");
            return;
        }

        System.out.println("\n========== TRANSACTIONS ==========");

        for (int i = 0; i < transactions.size(); i++) {

            System.out.println((i + 1) + ". " + transactions.get(i));

        }

    }

    // Show Balance
    public void showBalance() {

        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction t : transactions) {

            if (t.getType().equalsIgnoreCase("Income")) {

                totalIncome += t.getAmount();

            } else {

                totalExpense += t.getAmount();

            }

        }

        double balance = totalIncome - totalExpense;

        System.out.println("\n========== SUMMARY ==========");

        System.out.printf("Total Income  : ₹%.2f%n", totalIncome);
        System.out.printf("Total Expense : ₹%.2f%n", totalExpense);
        System.out.printf("Current Balance : ₹%.2f%n", balance);

    }

    // Delete Transaction
    public void deleteTransaction(int index) {

        if (transactions.isEmpty()) {

            System.out.println("\nNo Transactions Available.");

            return;

        }

        if (index <= 0 || index > transactions.size()) {

            System.out.println("Invalid Transaction Number.");

            return;

        }

        transactions.remove(index - 1);

        System.out.println("Transaction Deleted Successfully.");

    }

    // Called when program exits
    public void saveData() {

        FileManager.saveTransactions(transactions);

    }

    // Called when program starts
    public void loadData() {

        transactions = FileManager.loadTransactions();

    }

}
