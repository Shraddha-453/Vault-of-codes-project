import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        manager.loadData();

        while (true) {

            System.out.println("\n=================================");
            System.out.println("      SMART EXPENSE TRACKER");
            System.out.println("=================================");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. Show Balance");
            System.out.println("5. Delete Transaction");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid Input!");
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter Income Source: ");
                    String incomeSource = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double incomeAmount = Double.parseDouble(sc.nextLine());

                    manager.addTransaction(
                            new Transaction("Income",
                                    incomeSource,
                                    incomeAmount)
                    );

                    break;

                case 2:

                    System.out.print("Enter Expense Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double expenseAmount = Double.parseDouble(sc.nextLine());

                    manager.addTransaction(
                            new Transaction("Expense",
                                    category,
                                    expenseAmount)
                    );

                    break;

                case 3:

                    manager.viewTransactions();
                    break;

                case 4:

                    manager.showBalance();
                    break;

                case 5:

                    manager.viewTransactions();

                    System.out.print("Enter Transaction Number to Delete: ");

                    int index = Integer.parseInt(sc.nextLine());

                    manager.deleteTransaction(index);

                    break;

                case 6:

                    manager.saveData();

                    System.out.println("\nData Saved Successfully.");
                    System.out.println("Thank You!");

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

}