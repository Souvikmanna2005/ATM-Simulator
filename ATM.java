import java.util.Scanner;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (!account.validatePin(enteredPin)) {
            System.out.println("❌ Incorrect PIN. Access Denied.");
            sc.close();
            return;
        }

        int choice;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    System.out.println("✔ Amount Deposited Successfully!");
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    if (account.withdraw(wd)) {
                        System.out.println("✔ Withdraw Successful!");
                    } else {
                        System.out.println("❌ Insufficient Balance!");
                    }
                    break;

                case 4:
                    System.out.println("\n---- MINI STATEMENT ----");
                    for (String s : account.getMiniStatement()) {
                        System.out.println(s);
                    }
                    System.out.println("------------------------");
                    break;

                case 5:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
