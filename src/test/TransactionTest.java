package test;

import model.Account;
import service.TransactionService;

public class TransactionTest {

    public static void main(String[] args) {

        Account sender =
                new Account(
                        "SB1001",
                        "Sender",
                        "1234",
                        5000
                );

        Account receiver =
                new Account(
                        "SB1002",
                        "Receiver",
                        "5678",
                        2000
                );


        TransactionService service =
                new TransactionService();


        System.out.println(
                "Testing Transactions..."
        );


        boolean deposit =
                service.deposit(
                        sender,
                        1000
                );

        System.out.println(
                "Deposit test: "
                + deposit
        );


        boolean withdrawal =
                service.withdraw(
                        sender,
                        500
                );

        System.out.println(
                "Withdrawal test: "
                + withdrawal
        );


        boolean transfer =
                service.transfer(
                        sender,
                        receiver,
                        1000
                );

        System.out.println(
                "Transfer test: "
                + transfer
        );


        System.out.println(
                "\nSender Balance: Rs."
                + sender.getBalance()
        );

        System.out.println(
                "Receiver Balance: Rs."
                + receiver.getBalance()
        );


        System.out.println(
                "\nTransaction test completed."
        );
    }
}