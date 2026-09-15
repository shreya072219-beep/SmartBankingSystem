package service;

import model.Account;
import model.Bank;

public class AccountService {

    private Bank bank;

    public AccountService(Bank bank) {
        this.bank = bank;
    }

    public Account createAccount(String name,
                                 String pin,
                                 double initialDeposit) {

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name cannot be empty.");
            return null;
        }

        if (pin == null || pin.length() != 4) {
            System.out.println("PIN must contain 4 digits.");
            return null;
        }

        if (initialDeposit < 0) {
            System.out.println(
                "Initial deposit cannot be negative."
            );
            return null;
        }

        return bank.createAccount(
                name,
                pin,
                initialDeposit
        );
    }

    public Account login(String accountNumber,
                         String pin) {

        Account account =
                bank.findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return null;
        }

        if (!account.verifyPin(pin)) {
            System.out.println("Incorrect PIN.");
            return null;
        }

        return account;
    }

    public Account searchAccount(String accountNumber) {

        return bank.findAccount(accountNumber);
    }

    public int getTotalAccounts() {

        return bank.getTotalAccounts();
    }
}