import java.util.Scanner;

class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    int accountNumber;
    double balance;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void withdraw(double amount) throws LowBalanceException {
        if (amount > balance) {
            throw new LowBalanceException("Insufficient balance! Current balance: " + balance);
        } else {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully. Remaining balance: " + balance);
        }
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. New balance: " + balance);
    }

    void display() {
        System.out.println("Account Number: " + accountNumber + ", Balance: " + balance);
    }
}

public class BankWithdrawal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount acc = new BankAccount(101, 5000);
        System.out.println("Welcome to the Bank!");
        acc.display();

        try {
            System.out.print("\nEnter amount to withdraw: ");
            double amount = sc.nextDouble();

            acc.withdraw(amount);
        } catch (LowBalanceException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e);
        } finally {
            System.out.println("Thank you for banking with us.");
        }

        sc.close();
    }
}
