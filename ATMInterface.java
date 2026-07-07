
import java.util.Scanner;

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println( + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {

        if (amount > balance) {
            System.out.println("Sorry! You don't have enough balance.");
        } else {
            balance -= amount;
            System.out.println("Please collect your cash.");
            System.out.println( +  amount + " withdrawn successfully.");
        }
    }
}

class ATM {

    private final BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {

        int choice;

        try (Scanner sc = new Scanner(System.in)) {
            do {

                System.out.println("\n========== ATM ==========");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1 -> System.out.println("Current Balance:  " + account.getBalance());

                    case 2 -> {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();

                        if (depositAmount > 0) {
                            account.deposit(depositAmount);
                        } else {
                            System.out.println("Please enter a valid amount.");
                        }
                    }

                    case 3 -> {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();

                        if (withdrawAmount > 0) {
                            account.withdraw(withdrawAmount);
                        } else {
                            System.out.println("Please enter a valid amount.");
                        }
                    }

                    case 4 -> System.out.println("Thank you for using our ATM.");

                    default -> System.out.println("Invalid choice! Try again.");
                }

            } while (choice != 4);
        }
    }
}

public class ATMInterface {

    public static void main(String[] args) {

        BankAccount myAccount = new BankAccount(5000);

        ATM atm = new ATM(myAccount);

        atm.showMenu();
    }
}   
