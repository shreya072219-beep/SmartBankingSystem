package service;

import model.Account;

public class TransactionService {

    public boolean deposit(Account account,
                           double amount) {

        if (account == null) {
            return false;
        }

        if (amount <= 0) {
            System.out.println(
                "Amount must be greater than zero."
            );
            return false;
        }

        account.deposit(amount);

        return true;
    }

    public boolean withdraw(Account account,
                            double amount) {

        if (account == null) {
            return false;
        }

        if (amount <= 0) {
            System.out.println(
                "Amount must be greater than zero."
            );
            return false;
        }

        if (amount > account.getBalance()) {
            System.out.println(
                "Insufficient balance."
            );
            return false;
        }

        return account.withdraw(amount);
    }

    public boolean transfer(Account sender,
                            Account receiver,
                            double amount) {

        if (sender == null || receiver == null) {
            return false;
        }

        if (sender == receiver) {
            System.out.println(
                "Cannot transfer to yourself."
            );
            return false;
        }

        if (amount <= 0) {
            System.out.println(
                "Amount must be greater than zero."
            );
            return false;
        }

        if (amount > sender.getBalance()) {
            System.out.println(
                "Insufficient balance."
            );
            return false;
        }

        return sender.transfer(
                receiver,
                amount
        );
    }

    public void showTransactionHistory(Account account) {

        if (account == null) {
            return;
        }

        account.showTransactions();
    }
}