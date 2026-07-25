public class Transaction {

    private String type;
    private String category;
    private double amount;

    public Transaction(String type, String category, double amount) {

        this.type = type;
        this.category = category;
        this.amount = amount;

    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {

        return String.format("%-10s %-20s ₹%.2f",
                type,
                category,
                amount);

    }

}