import java.util.Scanner;

abstract class Account {
    int accountNumber;
    double balance;

    Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    abstract void deposit(double amount);

    abstract void withdraw(double amount);

    void display() {
        System.out.println("Account Number: " + accountNumber + ", Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    double interestRate;

    SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    void deposit(double amount) {
        balance += amount;
        balance += balance * (interestRate / 100); 
        System.out.println(amount + " deposited. Interest applied at " + interestRate + "%.");
    }

    @Override
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn from SavingsAccount.");
        } else {
            System.out.println("Insufficient balance in SavingsAccount.");
        }
    }

    @Override
    void display() {
        super.display();
        System.out.println("Account Type: Savings, Interest Rate: " + interestRate + "%");
    }
}

class CurrentAccount extends Account {
    double overdraftLimit;

    CurrentAccount(int accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited into CurrentAccount.");
    }

    @Override
    void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println(amount + " withdrawn from CurrentAccount.");
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }

    @Override
    void display() {
        super.display();
        System.out.println("Account Type: Current, Overdraft Limit: " + overdraftLimit);
    }
}

public class BankAccounts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account acc1 = new SavingsAccount(101, 5000, 5);
        Account acc2 = new CurrentAccount(102, 10000, 2000);

        System.out.println("Initial Account Details:");
        acc1.display();
        System.out.println();
        acc2.display();

        System.out.println("\n--- Transactions ---");
        acc1.deposit(1000);
        acc1.withdraw(2000);

        acc2.deposit(500);
        acc2.withdraw(12000);

        System.out.println("\nUpdated Account Details:");
        acc1.display();
        System.out.println();
        acc2.display();

        sc.close();
    }
}
