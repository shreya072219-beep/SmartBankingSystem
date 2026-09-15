package test;

import model.Account;

public class AccountTest {

    public static void main(String[] args) {

        Account account =
                new Account(
                        "SB1001",
                        "Test User",
                        "1234",
                        5000
                );

        System.out.println("Testing Account...");

        System.out.println(
                "Account Number: "
                + account.getAccountNumber()
        );

        System.out.println(
                "Initial Balance: Rs."
                + account.getBalance()
        );


        account.deposit(1000);

        System.out.println(
                "After Deposit: Rs."
                + account.getBalance()
        );


        boolean result =
                account.withdraw(500);

        System.out.println(
                "Withdrawal successful: "
                + result
        );

        System.out.println(
                "Final Balance: Rs."
                + account.getBalance()
        );


        System.out.println(
                "\nAccount test completed."
        );
    }
}