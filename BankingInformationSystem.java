import java.util.Scanner;

class BankAccount {

    private int accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Deposit method
    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    // Withdraw method
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } 
        else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } 
        else {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully.");
        }
    }

    // Display account details
    void displayDetails() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : " + balance);
    }

    // Check balance
    void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class BankingInformationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     BANKING INFORMATION SYSTEM");
        System.out.println("=================================");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account =
                new BankAccount(accountNumber, name, balance);

        int choice;

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Display Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.println("==========================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    account.displayDetails();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    account.checkBalance();
                    break;

                case 5:
                    System.out.println("Thank you for using Banking Information System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}