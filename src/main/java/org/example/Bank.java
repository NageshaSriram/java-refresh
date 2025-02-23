package org.example;

class BankAccount {
    int balance;

    BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(10);
        int balance = bankAccount.getBalance();
        System.out.println("Your balance is "+ balance);
        bankAccount.setBalance(30);

        System.out.println("Your balance is "+ bankAccount.getBalance());

    }
}


