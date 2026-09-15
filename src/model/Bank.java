package model;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;
    private int accountCounter;

    public Bank() {
        accounts = new ArrayList<>();
        accountCounter = 1001;
    }

    public Account createAccount(String name,
                                 String pin,
                                 double initialDeposit) {

        String accountNumber = "SB" + accountCounter++;

        Account account = new Account(
                accountNumber,
                name,
                pin,
                initialDeposit
        );

        accounts.add(account);

        return account;
    }

    public Account findAccount(String accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber()
                    .equals(accountNumber)) {

                return account;
            }
        }

        return null;
    }

    public boolean accountExists(String accountNumber) {

        return findAccount(accountNumber) != null;
    }

    public ArrayList<Account> getAccounts() {

        return accounts;
    }

    public int getTotalAccounts() {

        return accounts.size();
    }
}