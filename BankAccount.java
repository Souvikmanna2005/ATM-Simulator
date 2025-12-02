import java.util.ArrayList;

public class BankAccount {
    private double balance;
    private int pin;
    private ArrayList<String> miniStatement;

    public BankAccount(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
        this.miniStatement = new ArrayList<>();
    }

    public boolean validatePin(int userPin) {
        return this.pin == userPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        miniStatement.add("Deposited: ₹" + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        miniStatement.add("Withdrawn: ₹" + amount);
        return true;
    }

    public ArrayList<String> getMiniStatement() {
        return miniStatement;
    }
}
