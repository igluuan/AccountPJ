package com.luandev.application;

import com.luandev.domainException.NotEnoughBalanceException;
import com.luandev.entities.Account;

import java.rmi.AccessException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter account data:\n");
            sc.nextLine(); // Consume newline character
            System.out.print("Number: ");
            Integer numberAcc = sc.nextInt();
            sc.nextLine(); // Consume newline character
            System.out.print("Holder: ");
            String holderAcc = sc.nextLine();
            System.out.print("Initial balance: ");
            Double balanceAcc = sc.nextDouble();
            System.out.print("Withdrawal limit: ");
            Double withdrawLimitAcc = sc.nextDouble();

            Account acc = new Account(numberAcc, holderAcc, balanceAcc, withdrawLimitAcc);

            System.out.println("\nEnter amount for withdraw: ");
            double amount = sc.nextDouble();
            acc.withdraw(amount);

            System.out.printf("\nNew balance: $%.2f%n", acc.getBalance());

        } catch (AccessException | NotEnoughBalanceException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }
    }
}