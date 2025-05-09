import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
    private double balance;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " deposited successfully.");
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
            checkBalance();
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance!");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ATM atm = new ATM(1000.00); // Initial balance of $1000

            while (true) {
                System.out.println("\n### ATM Menu ###");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");

                try {
                    System.out.print("\nChoose an option: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1 -> atm.checkBalance();
                        case 2 -> {
                            System.out.print("Enter deposit amount: ");
                            double depositAmount = scanner.nextDouble();
                            atm.deposit(depositAmount);
                        }
                        case 3 -> {
                            System.out.print("Enter withdrawal amount: ");
                            double withdrawAmount = scanner.nextDouble();
                            atm.withdraw(withdrawAmount);
                        }
                        case 4 -> {
                            System.out.println("Thank you for using our ATM, Goodbye!");
                            return;
                        }
                        default -> System.out.println("Invalid option! Please choose a valid number.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next(); // Clear invalid input
                }
            }
        }
    }
}
