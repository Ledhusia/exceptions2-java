package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.printf("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.printf("Holder: ");
        String holder = sc.nextLine();
        System.out.printf("Initial balance: ");
        double balance = sc.nextDouble();
        System.out.printf("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();

        Account account = new Account(number, holder, balance, withdrawLimit);

        System.out.println();
        System.out.printf("Enter amount for withdraw: ");
        double amount = sc.nextDouble();
        if (amount > withdrawLimit) {
            System.out.println("Withdraw error: The amount exceeds withdraw limit");
        } else if (amount > balance) {
            System.out.println("Withdraw error: Not enough balance");
        } else {
            account.withdraw(amount);
            System.out.println("New balance: " + account.getBalance());
        }
        sc.close();
    }
}
