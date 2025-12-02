public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000.0, 1234);  // initial balance + PIN
        ATM atm = new ATM(account);
        atm.start();
    }
}
