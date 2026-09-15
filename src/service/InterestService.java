package service;

import model.Account;

public class InterestService {

    private static final double INTEREST_RATE = 0.04;

    public double calculateInterest(Account account) {

        if (account == null) {
            return 0;
        }

        return account.getBalance()
                * INTEREST_RATE;
    }

    public void addInterest(Account account) {

        if (account == null) {
            return;
        }

        double interest =
                calculateInterest(account);

        account.addInterest();

        System.out.println(
            "Interest rate applied: 4%"
        );

        System.out.println(
            "Interest amount: Rs."
            + interest
        );
    }

    public double getInterestRate() {

        return INTEREST_RATE * 100;
    }
}

